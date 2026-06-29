# 快手短剧榜逆向复现手册

> 目标:拿到快手 App「短剧热榜」(推荐/热播/漫剧/必看/星芒/穿越/古风/脑洞/家庭/甜宠/逆袭/都市)的数据接口。
> 结论速览:**接口公开,可直接 HTTP GET,无需 App / 签名 / cookie / 设备参数。**
> 关键:快手所有**运行时抓包都失败**(自研网络栈 + 强缓存),制胜路线是 **拉 KRN(React Native)bundle 读 JS 源码 + 从 App 日志翻出 host**。本文供其他 AI/人复现这条"换维度"的逆向法。

---

## 0. 最终成果(可直接用)

```bash
curl "https://api.e.kuaishou.com/rest/miniSeries/wd/hotRank/queryListNew?classifyId=2&sourceType=0&count=20"
```

- **方法**:GET。无需鉴权(无签名/无 cookie/无 UA 要求),HTTP 200,`{"result":1,"data":{...}}`。
- **`classifyId`**(子榜,响应 `data.tabListInfo` 给全集):
  `0`推荐榜 `10`热播榜 `1`漫剧榜 `2`必看榜 `11`星芒榜 `9`穿越榜 `8`古风榜 `7`脑洞榜 `6`家庭榜 `4`甜宠榜 `3`逆袭榜 `5`都市榜
- 固定带 `sourceType=0`;`count` 可调(≤50)。另有旧路径 `/queryList`(广告位用),主用 `queryListNew`。
- **响应**:`data.tabListInfo[]`(子榜列表)+ `data.tabHotListDetail.content[]`(当前子榜内容)。每项:
  - `rankNo`(排名)、`courseName`(剧名)、`courseId`(剧id)
  - `coverImg`(封面)、`scoreStr`(热度,如 "1000.0万")、`score`(数值热度)
  - `computeLabelList[0].desc`(播放量,如 "11901.6万播放")、`episodeDesc`(集数 "全49集")
  - `desc`(简介)、`tagNameList`(标签)、`launchTag.text`(角标:爆/新剧/飙升)、`seriesJumpUrl`(kwai 深链)

> 同样是私有 API,无契约保证,生产用请加重试/限速/兜底。

---

## 1. 环境与版本(与抖音手册共用同一套)

| 组件 | 版本 |
|---|---|
| 主机 | macOS 26.3.1 / Apple Silicon (arm64) |
| 模拟器 | emulator 36.6.11.0,AVD = `system-images;android-33;google_apis;arm64-v8a`(Android 13) |
| adb | 1.0.41 |
| Python | python.org 3.10.0 `/Library/Frameworks/Python.framework/Versions/3.10` |
| frida(主机/设备) | 17.9.6(两端必须同版本) |
| friTap | 2.2.3(本案最终没用上,但探路时用了) |
| Python 库 | `brotli` 1.1.0、`hpack` 4.1.0(探路时解 h2/br 用) |
| 快手 APK | `com.smile.gifmaker` 14.5.40 |

环境搭建(AVD/adb root/frida-server)与 `DOUYIN_BOARD_RE.md` §1 完全一致,不赘述。装快手:
```bash
adb install -r kuaishou-14.5.40.apk
adb shell 'monkey -p com.smile.gifmaker -c android.intent.category.LAUNCHER 1'
# 首启会弹隐私同意 + 通知权限,点过即可(快手不硬反模拟器)
```
> 磁盘不够时:卸不再需要的 App,或删字节系埋点库。快手主进程是 `com.smile.gifmaker`(还有 `:push_v3`/`:messagesdk` 等子进程,别 hook 错)。

---

## 2. 逆向过程

### 2.1 先说结论:运行时抓包全军覆没(别浪费时间)
快手短剧榜页是 **KRN(Kwai React Native)`com.kwai.kds.krn.api.page.tabs.KrnMultiTabActivity`**,网络走**自研 `libaegon.so`(基于 cronet)+ cmtp 多传输**,且榜单数据**按天强缓存 + KRN 页常驻内存**。以下层逐一验证**都抓不到榜单 JSON**:

| 尝试 | 结果 | 原因 |
|---|---|---|
| friTap(libssl/libmonochrome) | 0 | 不走系统 TLS |
| hook 系统 `libssl.so` / conscrypt `libjavacrypto.so` 的 SSL_read/write | 只有指纹/埋点 | 不走 conscrypt |
| hook `libaegon.so` Cronet C API(`Cronet_UrlRequest_InitWithParams`/`OnReadCompleted`/`Aegon_MT*` URL 函数) | 只有图片 | 榜单走 cmtp/prefetch,不经这些函数 |
| hook okhttp3 `RealInterceptorChain.proceed` + `peekBody` | 0 | 榜单不走 Java okhttp |
| Java 层 `ResponseBody.string()` / `JSONObject(String)` | 0 | Retrofit+Gson 流式 `fromJson(JsonReader)`,原始 JSON 不落 String |
| 进程内存 `Memory.scanSync` | flaky | 能数到匹配但 `readByteArray` 返回 null + V8 GC 不稳定 |
| 清缓存/force-stop 后重进 | 不重新联网 | 页面/数据常驻 |
| 分享按钮链接 | 无榜单 | bcebos 上的"下载/拉起 App"中转页,只有 `kwai://home` |

> `libaegon.so` 是**静态链接 + strip 的 BoringSSL**,不导出 SSL 符号,friTap 的 pattern 也匹配不上 → native 抓包这条死路。

### 2.2 制胜路线:拉 KRN bundle 读 JS 源码
KRN 页面的 **JS bundle 就在 App 磁盘上(明文)**,里面直接写着调哪个接口、什么参数。

**① 定位短剧榜模块的 bundle**(bundle 文件名是 `resource.tex`,其实是明文 UTF-8 JS):
```bash
R=/data/data/com.smile.gifmaker/files/kxb_v2/install/kds_react
# 用榜名内容反查模块
adb shell "su 0 grep -rla '短剧热榜' $R"
# → .../kds_react/CommercialTubeHotList/<ver>/resource.tex   ← 短剧榜模块
```

**② 拉出来,挖接口路径与参数**:
```bash
F="$R/CommercialTubeHotList/<ver>/resource.tex"
adb shell "su 0 cp $F /data/local/tmp/t.tex; su 0 chmod 644 /data/local/tmp/t.tex"
adb pull /data/local/tmp/t.tex /tmp/t.tex
# 接口路径
grep -aoE "/rest/[a-zA-Z0-9/_]*hotRank[a-zA-Z0-9/_]*" /tmp/t.tex | sort -u
# → /rest/miniSeries/wd/hotRank/queryList  和  /queryListNew
```
读 JS 上下文得知(关键片段,已美化):
```js
// 请求封装:host 为变量 Hc(模块 1560,值是空字符串 s="" → host 由 KRN 原生层注入)
var r = (e===AD_TUBE) ? "/rest/miniSeries/wd/hotRank/queryList" : "/rest/miniSeries/wd/hotRank/queryListNew";
request({ url: HOST + r, method:"GET", params:t });   // GET
// 参数对象:
{ classifyId: tab.id+"", sourceType:""+s, tubeSourceType:""+u, sourcePhotoPage:f, pageType:y }
```
→ 选子榜的参数是 **`classifyId`**(= 子榜 id),配 `sourceType=0`。

**③ host 在哪?bundle 里 host 是空的(原生注入)→ 去 App 的 debug 日志翻**:
```bash
L=$(adb shell "su 0 ls /data/data/com.smile.gifmaker/files/debuglog/app/main/*.app.log" | tr -d '\r' | head -1)
adb shell "su 0 grep -aoE 'https?://[^ \"]*miniSeries[^ \"]*' $L" | head
# → https://api.e.kuaishou.com/rest/miniSeries/wd/hotRank/queryListNew
```
→ host = **`api.e.kuaishou.com`**。

### 2.3 验证:直接可调
```bash
curl -s "https://api.e.kuaishou.com/rest/miniSeries/wd/hotRank/queryListNew?classifyId=2&sourceType=0&count=10" | head -c 200
# → {"result":1,"data":{"selectTabIndex":0,"tabListInfo":[{"id":0,"desc":"推荐榜"...   HTTP 200
```
改 `classifyId` 切子榜(2=必看 → 烈火之路;11=星芒 → 因为一盘花生米),与 App 完全吻合。**公开、无签名、无 cookie**。逆向完成。

---

## 3. 复现 Checklist

- [ ] AVD(google_apis;arm64-v8a)启动,`adb root`,装快手 14.5.40,进 App。
- [ ] (可选探路)确认运行时抓包抓不到——直接跳过,走 bundle 路线。
- [ ] `grep -rla '短剧热榜'` 定位到 `CommercialTubeHotList/.../resource.tex`。
- [ ] pull bundle,`grep hotRank` 拿路径 `/rest/miniSeries/wd/hotRank/queryListNew`,读出参数 `classifyId/sourceType`。
- [ ] `grep miniSeries` debuglog 拿 host `api.e.kuaishou.com`。
- [ ] `curl` 拼起来验证公开可用;`classifyId` 切子榜核对。
- [ ] (可选)用 §4 脚本直采。

---

## 4. 直采脚本 `fetch_ks_board.py`
```python
#!/usr/bin/env python3
import sys, requests
BASE = "https://api.e.kuaishou.com/rest/miniSeries/wd/hotRank/queryListNew"
def fetch(classify_id=0, count=20):
    return requests.get(BASE, params={"classifyId":classify_id,"sourceType":0,"count":count},
                        headers={"User-Agent":"kwai-android"}, timeout=15).json()
if __name__ == "__main__":
    cid = int(sys.argv[1]) if len(sys.argv)>1 else 2   # 默认必看榜
    d = fetch(cid)
    print("子榜:", ", ".join(f"{t['id']}={t['desc']}" for t in d["data"]["tabListInfo"]))
    for it in d["data"]["tabHotListDetail"]["content"]:
        play = (it.get("computeLabelList") or [{}])[0].get("desc","")
        print(f"{it['rankNo']:2d}. {it['courseName']:18s} {it.get('scoreStr',''):>9} {it.get('episodeDesc','')}  {play}  id={it.get('courseId')}")
```

---

## 5. 一句话总结 / 通用经验
快手三样全和抖音相反:**自研 cronet(libaegon,strip)+ 签名网关 + 按天强缓存**,运行时抓包全堵死。
**通用心法:目标是 KRN/Lynx/Hybrid 类页面时,别死磕 native 网络层——直接去磁盘拉前端 bundle 读源码(接口、参数都在里面),host 缺了就翻 App 自己的 debug 日志。** 这条路绕开了 TLS / 签名 / 缓存的全部对抗。
对比抖音见 `DOUYIN_BOARD_RE.md`。
