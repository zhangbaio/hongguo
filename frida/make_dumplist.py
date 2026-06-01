# -*- coding: utf-8 -*-
"""从 dump_plan.txt 过滤 native 堆段, 生成设备端列表 capture/dumplist.txt:
每行 'startPage countPages'(4096字节单位), 并写 capture/dumpindex.json 记录 file_offset->addr 映射。"""
import json
EXCL = ["dalvik", ".art]", ".vdex", ".oat", ".odex", "gralloc", "Ashmem", "ashmem",
        "jit-cache", "boot-", "framework", "/dev/", "mali", "kgsl", "dmabuf",
        ".jar", ".apk", "[stack", "linker", "[vdso", "[vvar"]
PAGE=4096
rows=[]
for line in open("capture/dump_plan.txt", errors="replace"):
    parts=line.split(None,3)
    if len(parts)<3: continue
    start=int(parts[0],16); size=int(parts[1]); rss=int(parts[2]); path=parts[3].strip() if len(parts)>3 else ""
    if any(x in path for x in EXCL): continue
    if size % PAGE: size = (size//PAGE)*PAGE
    if size==0: continue
    rows.append((start,size,rss,path))
tot=sum(r[1] for r in rows); totrss=sum(r[2] for r in rows)
print(f"native rw regions kept={len(rows)} mapped={tot/1048576:.0f}MB resident={totrss/1024:.0f}MB")
# 设备列表(页单位) + 索引
idx=[]; foff=0
with open("capture/dumplist.txt","w",newline="\n") as f:
    for start,size,rss,path in rows:
        f.write(f"{start//PAGE} {size//PAGE}\n")
        idx.append({"foff":foff,"addr":start,"size":size,"path":path})
        foff+=size
json.dump(idx, open("capture/dumpindex.json","w"))
print("wrote capture/dumplist.txt(", len(rows), "regions ) and dumpindex.json; expected dump size", tot/1048576, "MB")
