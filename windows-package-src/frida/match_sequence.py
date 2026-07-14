# -*- coding: utf-8 -*-
"""序列匹配(稳健): 明文连续帧大小序列 vs 密文 stsz 样本大小序列 -> 精确对齐
-> 恢复keystream -> 用 eg_keys 的66密钥做 counter-diff 验证 key+IV。
用已保存的 eg_plain.h265 + eg_diag.json(urls) + eg_keys.json, 不需新采集。"""
import json, struct, ssl, urllib.request
from Crypto.Cipher import AES

ctx=ssl.create_default_context(); ctx.check_hostname=False; ctx.verify_mode=ssl.CERT_NONE
diag=json.load(open("capture/eg_diag.json")); urls=diag["urls"]
keys=[bytes.fromhex(k) for k in json.load(open("capture/eg_keys.json"))]
plain=open("capture/eg_plain.h265","rb").read()
print(f"{len(urls)} urls, {len(keys)} keys, plain {len(plain)}B")

# 明文: 提取所有 picture NAL (type<22) 的 (off, size) 顺序序列
pnals=[]; i=0
while i+5<len(plain):
    if plain[i:i+4]==b"\x00\x00\x00\x01":
        j=plain.find(b"\x00\x00\x00\x01",i+4); sz=(j-i-4) if j>0 else len(plain)-i-4
        nt=(plain[i+4]>>1)&0x3f
        if nt<22: pnals.append((i+4,sz,nt))
        i=j if j>0 else len(plain)
    else: i+=1
pseq=[s for o,s,t in pnals]
print(f"plain picture NALs: {len(pnals)}, sizes[:12]={pseq[:12]}")

# mp4 helpers (含每样本 offset)
def ib(d,s,e):
    o=s
    while o+8<=e:
        sz=struct.unpack(">I",d[o:o+4])[0];t=d[o+4:o+8];hs=8
        if sz==1: sz=struct.unpack(">Q",d[o+8:o+16])[0];hs=16
        elif sz==0: sz=e-o
        yield t,o,sz,hs;o+=sz
def find(d,p,s=0,e=None):
    if e is None:e=len(d)
    for t,o,sz,hs in ib(d,s,e):
        if t==p[0]: return (o+hs,o+sz) if len(p)==1 else find(d,p[1:],o+hs,o+sz)
def traks(d):
    mv=find(d,[b"moov"]);return [(o+hs,o+sz) for t,o,sz,hs in ib(d,*mv) if t==b"trak"] if mv else []
def u32(d,o): return struct.unpack(">I",d[o:o+4])[0]
def hdlr(d,tr): h=find(d,[b"mdia",b"hdlr"],*tr);return d[h[0]+8:h[0]+12]
def vsamples(d,tr):
    s,e=find(d,[b"mdia",b"minf",b"stbl"],*tr)
    stsz=find(d,[b"stsz"],s,e);stco=find(d,[b"stco"],s,e);co64=find(d,[b"co64"],s,e);stsc=find(d,[b"stsc"],s,e)
    if not stsz: return None
    ss=u32(d,stsz[0]+4);cnt=u32(d,stsz[0]+8)
    sizes=[ss]*cnt if ss else [u32(d,stsz[0]+12+4*i) for i in range(cnt)]
    if stco: n=u32(d,stco[0]+4);ch=[u32(d,stco[0]+8+4*i) for i in range(n)]
    elif co64: n=u32(d,co64[0]+4);ch=[struct.unpack(">Q",d[co64[0]+8+8*i:co64[0]+16+8*i])[0] for i in range(n)]
    else: return None
    ne=u32(d,stsc[0]+4);runs=[(u32(d,stsc[0]+8+12*i),u32(d,stsc[0]+12+12*i),u32(d,stsc[0]+16+12*i)) for i in range(ne)]
    spc=[0]*len(ch)
    for i,(fc,sp,sd) in enumerate(runs):
        last=runs[i+1][0]-1 if i+1<len(runs) else len(ch)
        for c in range(fc,last+1):
            if 1<=c<=len(ch): spc[c-1]=sp
    offs=[];si=0
    for c in range(len(ch)):
        off=ch[c]
        for _ in range(spc[c]):
            if si>=cnt: break
            offs.append(off);off+=sizes[si];si+=1
    return sizes, offs

def dec(K,b): return AES.new(K,AES.MODE_ECB).decrypt(b)

# 对每个 url: 下载(整文件, 需全 stsz+样本), 序列匹配
WIN=8  # 连续帧窗口
for ui,url in enumerate(urls):
    try:
        req=urllib.request.Request(url,headers={"User-Agent":"Mozilla/5.0"})
        data=urllib.request.urlopen(req,timeout=25,context=ctx).read()
        if data[4:8]!=b'ftyp': continue
        mds=find(data,[b"mdat"])[0]
        vt=[t for t in traks(data) if hdlr(data,t)==b"vide"]
        if not vt: continue
        r=vsamples(data,vt[0])
        if not r: continue
        sizes,offs=r
        cbody=[s-4 for s in sizes]  # 样本 NAL body 大小(单NAL P帧)
        # 滑动: 找 pseq 的某段 == cbody 的某段(精确, 窗口 WIN)
        cset={}
        for ci in range(len(cbody)): cset.setdefault(cbody[ci],[]).append(ci)
        hit_align=None
        for pi in range(len(pseq)-WIN):
            # pseq[pi] 在 cbody 哪些位置?
            for ci in cset.get(pseq[pi],[]):
                if ci+WIN<=len(cbody) and all(pseq[pi+w]==cbody[ci+w] for w in range(WIN)):
                    hit_align=(pi,ci); break
            if hit_align: break
        if hit_align:
            pi,ci=hit_align
            print(f"*** SEQUENCE MATCH url#{ui} plain_idx={pi} cipher_sample={ci} (window {WIN} exact)")
            print(f"    url={url[:90]}")
            # 用该对齐帧恢复 keystream: plain NAL body vs cipher 样本 body
            po,psz,pt=pnals[pi]; co=offs[ci]; csz=sizes[ci]
            n=min(4096,psz,csz-4)
            ks=bytes(a^b for a,b in zip(data[co+4:co+4+n], plain[po:po+n]))
            mo=(co+4)-mds  # 该帧 body 在 mdat 的偏移
            ff=((mo+15)//16)*16; i0=ff-mo
            blkA=ks[i0:i0+16]; blkB=ks[i0+16:i0+32]; blkA_idx=ff//16
            print(f"    keystream blkA(idx{blkA_idx})={blkA.hex()}")
            # counter-diff 验证
            found=None
            for K in keys:
                if (int.from_bytes(dec(K,blkB),"big")-int.from_bytes(dec(K,blkA),"big"))%(1<<128)==1:
                    cA=int.from_bytes(dec(K,blkA),"big")
                    found=(K,cA); break
            if found:
                K,cA=found; iv=(cA-blkA_idx)%(1<<128)
                print(f"\n*** CONTENT KEY FOUND! key={K.hex()}")
                print(f"    IV={iv:032x}  counter@blk{blkA_idx}={cA:032x}")
                open("capture/ct/seqmatch.mp4","wb").write(data)
                json.dump({"key":K.hex(),"iv":f"{iv:032x}","blkA_idx":blkA_idx,
                           "url":url,"plain_idx":pi,"cipher_sample":ci},
                          open("capture/CONTENT_KEY.json","w"),indent=2)
                print("saved capture/CONTENT_KEY.json !!!"); raise SystemExit
            else:
                print("    matched but no key counter-diff (key不在dump? IV非线性CTR?)")
                # 存下供分析
                open("capture/ct/seqmatch.mp4","wb").write(data)
                json.dump({"blkA":blkA.hex(),"blkB":blkB.hex(),"blkA_idx":blkA_idx,
                           "url":url,"mo":mo},open("capture/seq_ks.json","w"),indent=2)
    except Exception as e:
        pass
print("done (no full success if reached here)")
