# -*- coding: utf-8 -*-
"""验证: mdat 前1024字节之外是否为明文 HEVC。解析 moov 样本表。"""
import struct, sys

def find_box(data, path, start=0, end=None):
    """按 path(list of 4cc) 深入, 返回 (dataStart, dataEnd)。"""
    if end is None: end = len(data)
    o = start
    while o + 8 <= end:
        sz = struct.unpack(">I", data[o:o+4])[0]; typ = data[o+4:o+8]; hs = 8
        if sz == 1:
            sz = struct.unpack(">Q", data[o+8:o+16])[0]; hs = 16
        elif sz == 0:
            sz = end - o
        if typ == path[0]:
            if len(path) == 1:
                return (o+hs, o+sz)
            return find_box(data, path[1:], o+hs, o+sz)
        o += sz
    return None

def parse_stsz(data, s, e):
    ver_flags, sample_size, count = struct.unpack(">IInI".replace("n",""), data[s:s+12]) if False else (None,None,None)
    sample_size = struct.unpack(">I", data[s+4:s+8])[0]
    count = struct.unpack(">I", data[s+8:s+12])[0]
    sizes = []
    if sample_size == 0:
        for i in range(count):
            sizes.append(struct.unpack(">I", data[s+12+4*i:s+16+4*i])[0])
    else:
        sizes = [sample_size]*count
    return sizes

def parse_offsets(data):
    stco = find_box(data, [b"moov",b"trak",b"mdia",b"minf",b"stbl",b"stco"])
    if stco:
        s,e = stco; cnt = struct.unpack(">I", data[s+4:s+8])[0]
        return [struct.unpack(">I", data[s+8+4*i:s+12+4*i])[0] for i in range(cnt)]
    co64 = find_box(data, [b"moov",b"trak",b"mdia",b"minf",b"stbl",b"co64"])
    if co64:
        s,e = co64; cnt = struct.unpack(">I", data[s+4:s+8])[0]
        return [struct.unpack(">Q", data[s+8+8*i:s+16+8*i])[0] for i in range(cnt)]
    return []

NAL_NAMES = {32:"VPS",33:"SPS",34:"PPS",35:"AUD",39:"SEI",19:"IDR_W",20:"IDR_N",21:"CRA",
             0:"TRAIL_N",1:"TRAIL_R",2:"TSA_N",3:"TSA_R",4:"STSA_N",5:"STSA_R"}

def check_sample(data, off, size, label):
    # HEVC hvc1: 样本是若干 [4字节长度][NAL] 串联。逐 NAL 走, 看是否走到样本尾。
    p = off; end = off+size; nals=[]
    ok = True
    while p+4 <= end:
        ln = struct.unpack(">I", data[p:p+4])[0]
        if ln == 0 or p+4+ln > end:
            ok = (p+4+ln == end) if ln else False
            if p+4+ln != end: ok=False
            nals.append(("BAD",ln)); break
        nh = data[p+4]
        nal_type = (nh >> 1) & 0x3f
        fzb = (nh >> 7) & 1
        nals.append((NAL_NAMES.get(nal_type,nal_type), ln, "fzb=%d"%fzb))
        if fzb != 0: ok=False
        p += 4+ln
    if p != end: ok=False
    print(f"  [{label}] off={off} size={size}: {'OK' if ok else 'BAD'} nals={nals[:6]}")
    return ok

for tag in ["hit1","hit3"]:
    path = f"capture/ct/{tag}.mp4"
    data = open(path,"rb").read()
    print("="*60, tag, "len", len(data))
    mdat = find_box(data, [b"mdat"])
    mdat_start = mdat[0]
    sizes = parse_stsz(data, *find_box(data, [b"moov",b"trak",b"mdia",b"minf",b"stbl",b"stsz"]))
    offs = parse_offsets(data)
    print(f"  mdat_data={mdat_start} samples={len(sizes)} chunk_offsets={len(offs)}  first sizes={sizes[:6]}")
    print(f"  first chunk offset={offs[0] if offs else '?'} (mdat_data={mdat_start})")
    # 逐样本累积偏移(假设 1 sample/chunk 或连续). 用 stco[0] 起，连续排布
    base = offs[0] if offs else mdat_start
    cur = base; cum=0
    for i,sz in enumerate(sizes[:8]):
        enc = "ENC(前1024内)" if cum < 1024 else "明文区"
        check_sample(data, cur, sz, f"s{i} {enc} mdatoff={cur-mdat_start}")
        cur += sz; cum += sz
