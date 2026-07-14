# -*- coding: utf-8 -*-
"""用 stsc+stco+stsz 算真实样本偏移, 验证 mdat 1024 之后是否明文 HEVC。"""
import struct

def iter_boxes(data, start, end):
    o = start
    while o + 8 <= end:
        sz = struct.unpack(">I", data[o:o+4])[0]; typ = data[o+4:o+8]; hs = 8
        if sz == 1: sz = struct.unpack(">Q", data[o+8:o+16])[0]; hs = 16
        elif sz == 0: sz = end - o
        yield typ, o, sz, hs
        if sz <= 0: break
        o += sz

def find(data, path, start=0, end=None):
    if end is None: end = len(data)
    for typ,o,sz,hs in iter_boxes(data,start,end):
        if typ == path[0]:
            return (o+hs,o+sz) if len(path)==1 else find(data,path[1:],o+hs,o+sz)
    return None

def all_traks(data):
    moov = find(data,[b"moov"])
    out=[]
    for typ,o,sz,hs in iter_boxes(data,*moov):
        if typ==b"trak": out.append((o+hs,o+sz))
    return out

def stbl_of(data, trak):
    return find(data,[b"mdia",b"minf",b"stbl"],*trak)

def handler(data, trak):
    h = find(data,[b"mdia",b"hdlr"],*trak)
    return data[h[0]+8:h[0]+12] if h else b"????"

def u32(d,o): return struct.unpack(">I",d[o:o+4])[0]

def sample_offsets(data, stbl):
    s,e = stbl
    stsz = find(data,[b"stsz"],s,e); stco=find(data,[b"stco"],s,e); co64=find(data,[b"co64"],s,e); stsc=find(data,[b"stsc"],s,e)
    # sizes
    ss = u32(data,stsz[0]+4); cnt=u32(data,stsz[0]+8)
    sizes=[ss]*cnt if ss else [u32(data,stsz[0]+12+4*i) for i in range(cnt)]
    # chunk offsets
    if stco:
        n=u32(data,stco[0]+4); chunks=[u32(data,stco[0]+8+4*i) for i in range(n)]
    else:
        n=u32(data,co64[0]+4); chunks=[struct.unpack(">Q",data[co64[0]+8+8*i:co64[0]+16+8*i])[0] for i in range(n)]
    # stsc runs
    ne=u32(data,stsc[0]+4); runs=[(u32(data,stsc[0]+8+12*i),u32(data,stsc[0]+12+12*i),u32(data,stsc[0]+16+12*i)) for i in range(ne)]
    # 每 chunk 的样本数
    spc=[0]*len(chunks)
    for i,(fc,spchunk,sdi) in enumerate(runs):
        last = runs[i+1][0]-1 if i+1<len(runs) else len(chunks)
        for c in range(fc, last+1):
            if 1<=c<=len(chunks): spc[c-1]=spchunk
    # 展开样本偏移
    offs=[]; si=0
    for c in range(len(chunks)):
        off=chunks[c]
        for _ in range(spc[c]):
            if si>=cnt: break
            offs.append(off); off+=sizes[si]; si+=1
    return sizes, offs

NAL={32:"VPS",33:"SPS",34:"PPS",35:"AUD",39:"SEI",40:"SEI_S",19:"IDR_W",20:"IDR_N",21:"CRA",1:"TRAIL_R",0:"TRAIL_N"}
def check_sample(data, off, size):
    p=off; end=off+size; nals=[]; ok=True
    while p+4<=end:
        ln=u32(data,p)
        if ln==0 or p+4+ln>end: ok=False; nals.append(("BAD",ln)); break
        nh=data[p+4]; nt=(nh>>1)&0x3f; fzb=(nh>>7)&1
        nals.append((NAL.get(nt,nt),ln));
        if fzb: ok=False
        p+=4+ln
    if p!=end: ok=False
    return ok,nals

for tag in ["hit1","hit3"]:
    data=open(f"capture/ct/{tag}.mp4","rb").read()
    mdat=find(data,[b"mdat"]); mds=mdat[0]
    print("="*60,tag,"mdat_data=",mds)
    for trak in all_traks(data):
        hdl=handler(data,trak).decode("latin1")
        stbl=stbl_of(data,trak)
        sizes,offs=sample_offsets(data,stbl)
        print(f"  trak hdlr={hdl} samples={len(sizes)} first_off={offs[0] if offs else '?'} (mdatoff={offs[0]-mds if offs else '?'})")
        # 找第一个 mdat 偏移 >=1024 的样本, 验证
        shown=0
        for i,(o,sz) in enumerate(zip(offs,sizes)):
            mo=o-mds
            if mo>=1024 and shown<3:
                ok,nals=check_sample(data,o,sz)
                print(f"    s{i} mdatoff={mo} size={sz}: {'OK明文' if ok else 'BAD'} {nals[:5]}")
                shown+=1
        # 也验证第一个样本(应跨越加密边界->BAD)
        if offs:
            ok,nals=check_sample(data,offs[0],sizes[0])
            print(f"    s0 mdatoff={offs[0]-mds} size={sizes[0]}: {'OK' if ok else 'BAD(预期,含加密区)'} {nals[:3]}")
