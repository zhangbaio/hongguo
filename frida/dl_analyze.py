# -*- coding: utf-8 -*-
import json, os, struct, urllib.request

meta = json.load(open("capture/hits_meta.json"))
os.makedirs("capture/ct", exist_ok=True)

def download(url, path):
    if os.path.exists(path) and os.path.getsize(path) > 0:
        print("  exists", path, os.path.getsize(path)); return
    req = urllib.request.Request(url, headers={"User-Agent": "Mozilla/5.0"})
    data = urllib.request.urlopen(req, timeout=60).read()
    open(path, "wb").write(data)
    print("  downloaded", path, len(data))

def boxes(data, start=0, end=None, depth=0):
    """列出顶层 mp4 box: (type, offset, size, header_size)"""
    if end is None: end = len(data)
    o = start; out = []
    while o + 8 <= end:
        sz = struct.unpack(">I", data[o:o+4])[0]
        typ = data[o+4:o+8].decode("latin1", "replace")
        hs = 8
        if sz == 1:
            sz = struct.unpack(">Q", data[o+8:o+16])[0]; hs = 16
        elif sz == 0:
            sz = end - o
        out.append((typ, o, sz, hs))
        if sz <= 0: break
        o += sz
    return out

for fn, m in meta.items():
    tag = "hit1" if "1" in fn else "hit3"
    path = f"capture/ct/{tag}.mp4"
    print("="*60, tag)
    try:
        download(m["main_url"], path)
    except Exception as e:
        print("  DL FAIL", e); continue
    data = open(path, "rb").read()
    print("  file size", len(data), "(meta size", m["size"], ")")
    bx = boxes(data)
    for typ, o, sz, hs in bx:
        print(f"   box {typ:6s} off={o} size={sz} dataStart={o+hs}")
    # mdat 数据起点
    mdat = [b for b in bx if b[0] == "mdat"]
    if mdat:
        typ, o, sz, hs = mdat[0]
        mdat_data = o + hs
        print("  mdat data starts at file offset", mdat_data)
        # 打印 mdat 前 32 字节 + 文件前 32 字节 hex
        print("  file[0:16] ", data[:16].hex())
        print("  mdat[0:32] ", data[mdat_data:mdat_data+32].hex())
        print("  mdat[508:1028]@512boundary first bytes:", data[mdat_data+1024:mdat_data+1040].hex())
