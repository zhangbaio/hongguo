# -*- coding: utf-8 -*-
"""解析 smaps, 选出有驻留(Rss>0)的 rw 段, 生成 dump 计划 capture/dump_plan.txt (start_hex size pages)。"""
import re
from collections import Counter
regions=[]; cur=None
for line in open("capture/smaps.txt", errors="replace"):
    m=re.match(r'^([0-9a-f]+)-([0-9a-f]+)\s+(\S{4})\s+\S+\s+\S+\s+\S+\s*(.*)$', line)
    if m:
        cur={"s":int(m.group(1),16),"e":int(m.group(2),16),"perm":m.group(3),
             "path":m.group(4).strip(),"rss":0}
        regions.append(cur)
    else:
        mm=re.match(r'^Rss:\s+(\d+)\s*kB', line)
        if mm and cur: cur["rss"]=int(mm.group(1))
rw=[r for r in regions if r["perm"][0]=="r" and r["perm"][1]=="w"]
rwres=[r for r in rw if r["rss"]>0]
tot=sum(r["rss"] for r in rwres)
print(f"regions={len(regions)} rw={len(rw)} rw+Rss>0={len(rwres)} residentRW={tot/1024:.0f}MB")
c=Counter()
for r in rwres: c[(r["path"] or "[anon]").split('/')[-1]]+=r["rss"]
for p,kb in c.most_common(12): print(f"  {kb/1024:8.1f}MB  {p}")
with open("capture/dump_plan.txt","w") as f:
    for r in rwres:
        f.write(f"{r['s']:x} {r['e']-r['s']} {r['rss']} {(r['path'] or '[anon]')}\n")
print("wrote capture/dump_plan.txt with", len(rwres), "regions")
