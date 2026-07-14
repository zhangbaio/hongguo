# -*- coding: utf-8 -*-
import re, glob, os
KEYS = ["encryption_method","kid","spade_a","video_id","vid","file_id","file_hash",
        "main_url","backup_url_1","check_info","codec_type","definition","quality","size"]
for fn in sorted(glob.glob("capture/mem_hit_*.txt")):
    t = open(fn, encoding="utf-8").read()
    print("="*72)
    print(os.path.basename(fn), len(t), "B")
    for key in KEYS:
        m = re.search(r'"%s"\s*:\s*"?([^",}\]]{0,500})' % re.escape(key), t)
        if m:
            print("  %-16s = %s" % (key, m.group(1)[:220]))
