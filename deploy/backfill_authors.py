# -*- coding: utf-8 -*-
"""一次性回填: 本地拉取当前7天内上新(带 copyright 作者), 更新服务器 hg_new_seen.author。
只改 author, 不动 first_seen/is_new。环境: SSH_HOST/SSH_USER/SSH_PWD; SIGN_SERVER。
"""
import os, sys, json
os.environ.setdefault("SIGN_SERVER", "http://127.0.0.1:8001")
sys.path.insert(0, os.path.dirname(os.path.dirname(os.path.abspath(__file__))))
import hongguo as H  # noqa: E402
import paramiko  # noqa: E402

mapping = {}
for genre in H.GENRES:
    items = H.latest(genre, only_today=False, max_items=300)
    mapping[genre] = {str(it["series_id"]): it.get("copyright", "")
                      for it in items if it.get("series_id") and it.get("copyright")}
    print(f"本地拉取 {genre}: {len(mapping[genre])} 条带作者")

HOST = os.environ["SSH_HOST"]; USER = os.environ.get("SSH_USER", "root"); PWD = os.environ["SSH_PWD"]
REMOTE = "/www/wwwroot/weixinshortdrama.momotools.top/short-vedio-manage"
c = paramiko.SSHClient(); c.set_missing_host_key_policy(paramiko.AutoAddPolicy())
c.connect(HOST, username=USER, password=PWD, timeout=20)
sftp = c.open_sftp()
with sftp.open(REMOTE + "/_au_backfill.json", "w") as f:
    f.write(json.dumps(mapping, ensure_ascii=False))
script = (
    "import sqlite3,json\n"
    "m=json.load(open('_au_backfill.json',encoding='utf-8'))\n"
    "c=sqlite3.connect('data/dramas.db');n=0\n"
    "for g,d in m.items():\n"
    "    for sid,au in d.items():\n"
    "        if not au: continue\n"
    "        n+=c.execute(\"UPDATE hg_new_seen SET author=? WHERE genre=? AND series_id=? AND COALESCE(author,'')=''\",(au,g,sid)).rowcount\n"
    "c.commit();print('已回填 author 行数:',n);c.close()\n"
)
with sftp.open(REMOTE + "/_au_backfill.py", "w") as f:
    f.write(script)
_, o, e = c.exec_command(f"cd {REMOTE} && python3 _au_backfill.py && rm -f _au_backfill.py _au_backfill.json")
print(o.read().decode(errors="ignore") + e.read().decode(errors="ignore"))
sftp.close(); c.close()
print("done")
