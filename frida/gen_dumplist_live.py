# -*- coding: utf-8 -*-
import re
regions=[]; cur=None
EXCL=["dalvik",".art]",".vdex",".oat",".odex","gralloc","Ashmem","ashmem",
      "jit-cache","boot-","framework","/dev/","mali","kgsl","dmabuf",
      ".jar",".apk","[stack","linker","[vdso","[vvar"]
for line in open("capture/smaps_live.txt", errors="replace"):
    m=re.match(r"^([0-9a-f]+)-([0-9a-f]+)\s+(\S{4})\s+\S+\s+\S+\s+\S+\s*(.*)$", line)
    if m:
        cur={"s":int(m.group(1),16),"e":int(m.group(2),16),"perm":m.group(3),"path":m.group(4).strip(),"rss":0}
        regions.append(cur)
    else:
        mm=re.match(r"^Rss:\s+(\d+)\s*kB", line)
        if mm and cur: cur["rss"]=int(mm.group(1))
rw=[r for r in regions if r["perm"][0]=="r" and r["perm"][1]=="w"]
rwres=[r for r in rw if r["rss"]>0 and not any(x in r["path"] for x in EXCL)]
tot=sum(r["rss"] for r in rwres)
print(f"native rw resident: {tot/1024:.0f} MB, regions={len(rwres)}")
with open("capture/dumplist_live.txt","w",newline="\n") as f:
    for r in rwres:
        sz=(r["e"]-r["s"])//4096
        if sz>0: f.write(f"{r['s']//4096} {sz}\n")
print("wrote capture/dumplist_live.txt")
