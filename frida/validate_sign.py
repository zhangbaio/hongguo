#!/usr/bin/env python3
# 端到端验证: frida调0x27d288签名 -> 实际请求fqnovel -> 看code=0
import frida, sys, time, json, urllib.request, urllib.parse

DEVICE_ID="1325332544628567"; IID="1325332544632663"  # 抓到的本机device(签名属于它)
def get_script():
    import subprocess
    pid=int(subprocess.check_output(["adb","shell","pgrep","-f","com.phoenix.read"]).split()[0])
    dev=frida.get_usb_device()
    sess=dev.attach(pid)
    code=open("sign_service.js").read()
    s=sess.create_script(code); s.load()
    return s

def build_url(query):
    rticket=int(time.time()*1000)
    q={"query":query,"tab_name":"feed","search_source":"1","offset":"0","count":"0","use_correct":"true",
       "aid":"8662","device_id":DEVICE_ID,"iid":IID,"ac":"wifi","channel":"update_64",
       "app_name":"novelread","version_code":"72232","version_name":"7.2.2.32","device_platform":"android",
       "os":"android","device_type":"sdk_gphone64_arm64","device_brand":"google","language":"en",
       "os_api":"33","os_version":"13","manifest_version_code":"72232","resolution":"1080*2337","dpi":"420",
       "update_version_code":"72232","_rticket":str(rticket),"host_abi":"arm64-v8a","dragon_device_type":"phone",
       "pv_player":"72232","compliance_status":"0"}
    return "https://api5-normal-sinfonlinea.fqnovel.com/reading/bookapi/search/tab/v?"+urllib.parse.urlencode(q)

def main():
    s=get_script()
    url=build_url("test")
    hdr="content-type\r\napplication/json; charset=utf-8\r\nx-ss-req-ticket\r\n%d\r\n"%(int(time.time()*1000))
    sig=s.exports_sync.sign(url, hdr)
    if not sig: print("签名=NULL, 失败"); return
    print("=== 签名结果 ===")
    lines=sig.replace("\r\n","\n").strip().split("\n")
    H={}
    for i in range(0,len(lines)-1,2): H[lines[i]]=lines[i+1]
    for k,v in H.items(): print(f"  {k}: {v[:50]}{'...' if len(v)>50 else ''}")
    # 实际请求
    req=urllib.request.Request(url, headers={
        "content-type":"application/json; charset=utf-8",
        "x-ss-req-ticket":str(int(time.time()*1000)),
        "user-agent":"com.phoenix.read/72232 (Linux; U; Android 13; en_US; sdk_gphone64_arm64; Build/TE1A.240213.009; Cronet/TTNetVersion:04657795 2026-01-23 QuicVersion:c67e9834 2025-09-08)",
        **H})
    try:
        resp=urllib.request.urlopen(req, timeout=20)
        body=resp.read().decode("utf-8","ignore")
        j=json.loads(body)
        code=j.get("code", j.get("BaseResp",{}).get("StatusCode","?"))
        tabs=j.get("search_tabs") or j.get("data")
        print(f"\n=== fqnovel 响应 code={code} ===")
        print("  有结果:", bool(tabs), " body前120:", body[:120])
        print("  ✅ 签名有效!" if (code in (0,"0",None) and tabs) else "  ❌ 被拒/无结果")
    except Exception as e:
        print("请求异常:", str(e)[:200])

main()
