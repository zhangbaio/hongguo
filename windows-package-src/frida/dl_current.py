# -*- coding: utf-8 -*-
"""下载当前视频的密文: kid=682165e3, spade_a=kLwe+lawL..."""
import urllib.request, os, struct, base64, json

# 从内存捕获到的当前视频信息 (kid=682165e3f8818b2123d6d8790003ebeb)
# 取第一个 main_url (360p, ds=1)
URL = "https://v5-gzb-alismart-reading-video.qznovelvod.com/081847728629326e15858803e20fb020/6a1dabe7/video/tos/cn/tos-cn-v-6fcc8e/okyXRgDDoBdkDabFEDOW2DQJrArtfIegH5ILPj/?a=8662&ch=0&cr=9&dr=0&er=1&lr=default&cd=0%7C0%7C0%7C9&cv=1&bt=194&cs=5&ds=1&ft=BGyBnH7vh..NOlMY7QjVQ9tSdZLJ9E5im4m_GuOCnz6QkZnUxRyqkZ&mime_type=video_mp4&qs=0&rc=N2Q0MzNoOWQ4NzloMzw7ZEBpajRwO2w5cnJwMzMzNGhoM0BhMl8zXi5fNWExMG"
KID = "682165e3f8818b2123d6d8790003ebeb"
SPADE = "kLwe+lawL8tisRj2Zb4f9WG4GehTlBzqZq0r42CuLP5miS6Wlg=="
OUT = "capture/ct/live_current.mp4"

os.makedirs("capture/ct", exist_ok=True)
if os.path.exists(OUT):
    print(f"already exists {OUT} ({os.path.getsize(OUT)} bytes)")
else:
    print(f"downloading...")
    req = urllib.request.Request(URL, headers={"User-Agent": "Mozilla/5.0"})
    data = urllib.request.urlopen(req, timeout=60).read()
    open(OUT, "wb").write(data)
    print(f"saved {OUT} {len(data)} bytes")

# 保存元数据
meta = {"tag":"live_current","kid":KID,"spade_a":SPADE,"path":OUT,
        "spade_bytes":base64.b64decode(SPADE).hex()}
json.dump(meta, open("capture/live_meta.json","w"), indent=2)
print("meta saved, spade_bytes=", meta["spade_bytes"])
