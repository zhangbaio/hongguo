# 设备池轮换 + device_register 侦察(2026-06-29)

针对"多 token / 多设备轮换降低风控"的需求,本文记录**已验证的关键事实**、**设备池框架**,以及 **device_register 离线注册的侦察结论与剩余缺口**(留作下一阶段)。

---

## 一、决定性发现:不需要 token / 账号

实测(unidbg 离线签名 + 红果 API):

| 请求 | 结果 |
|------|------|
| search **去 x-tt-token + 去 cookie**(纯游客) | `code=0` 真实数据 ✓ |
| `multi_video_model`(下载)**纯游客** | `code=0` 真实直链 ✓ |
| 下载 **随机 device_id/iid + 游客**(单个) | `code=0` ✓ |

**结论:红果 search/下载对游客开放,不校验登录态。** 所以"多 token 轮换"的本质是 **设备指纹池轮换**,不是养账号。

## 二、新设备速率墙(关键约束)

继续测试发现:**同一 IP 短时间灌入大量全新随机 device_id 会被静默风控**(网关返回空 body),而**原始那个真实 device_id 始终 `code=0` 正常**(IP 未被整体封)。

- 单个全新 device_id 有 grace,能蒙混;
- 批量全新设备从同一 IP 涌入 → 触发风控;
- 原始设备能用,是因为它**经过 device_register 注册、有服务端历史**。

**推论:设备池不能用纯随机喂,需要合法注册过的 (device_id, iid);且注册/使用都要 IP 分散。**

字段一致性要点(实测):
- **A**(只随机 device_id/iid/cdid)→ 通;
- **B**(改机型字段但 UA 没同步)→ **空 body**(UA↔设备不自洽被拒);
- **C**(改机型 + UA 同步自洽)→ 通;
- **D**(去掉 `klink_egdi`)→ 空 body(该字段必须保留)。
→ 故池里每台设备的 `device_type/os_version/resolution/rom_version/UA` 必须**整套自洽**,且保留 `klink_egdi` 等设备绑定字段。

## 三、设备池框架(已实现并验证轮换)

`devicepool.py` + `hongguo.py` 集成:
- 真实大众机型档案(Redmi/HUAWEI/OPPO/vivo/...),每台随机 `device_id/iid/cdid` + 自洽 `UA/机型/分辨率/os`;
- 线程内粘滞 + 线程间轮询(并发下载各线程天然用不同设备);`rotate_device()` 主动换台;
- 池设备走游客(自动去 token/cookie),保留 `klink_egdi` 等;
- `DEVICE_POOL_SIZE>0` 启用并落盘 `devices.json`;默认 `None` = 单设备(不影响现状)。

**状态:轮换逻辑、请求字节正确性已验证。但用纯随机设备会撞"新设备速率墙"(见二);需用 device_register 产出的合法设备填充才实用。**

## 四、device_register 侦察(剩余缺口)

抓包(frida hook retrofit/okhttp,清数据+首启+过隐私/权限弹窗触发)确认:

- **端点**:`POST https://log.snssdk.com/service/2/device_register/?req_id=<uuid>&tt_data=a`
- **请求体**:**1110 字节,TTEncrypt 加密**,magic `74 63 05 10`(`tc..`);`tt_data=a` 表示 body 加密
- **签名**:metasec 那套(X-Argus...),我们能离线签
- **响应**:返回 `device_id_str` / `install_id_str`(标准 AppLog 注册响应)

**还差两块(下一阶段):**
1. **明文 JSON 结构** —— 需 hook 加密函数输入抓明文。尝试 hook `libEncryptor.so` 的 `ttEncrypt` 未命中(加密疑在另一库,待定位;`capture/decomp_libEncryptor.so.c` 有部分逆向)。
2. **复刻加密 或 绕过** —— 要么逆 TTEncrypt 重写,要么测"去 `tt_data` 直接发明文 JSON + 离线签名"服务端是否接受(后者若成立可绕过整个加密)。

**外加结构性约束**:注册本身也要 IP 分散——同 IP 批量注册新设备同样触发风控。

### 后续结论(2026-06-29 二次)

1. **抓明文不可行(Java 层)**:红果 applog 是 **native Rust**(`libapplog_rust.so`/`libiesapplogger.so`),
   device_register 的 JSON **在 native 组装+加密,从不以 Java 字符串/对象存在**。实测无 Java `ttEncrypt`
   方法;hook `org.json.JSONObject.toString` / `String([B])` 均零捕获。body 加密(`ttEncrypt`)是
   libEncryptor 里 RegisterNatives 注册的 OLLVM 混淆 native。→ 要明文只能逆 native(大工程)。
2. **明文注册测试不通(确定性)**:用公开 applog schema + config.json 设备字段拼出明文注册体
   (1325 字节,比真实 1110 还全),明文 POST `log.snssdk.com/service/2/device_register/`:
   服务端**接受并解析(HTTP 200,返回标准响应结构),但 device_id 恒为 0**;加签名/加 sig_hash
   (`56a962410c494bbaf0b58dba20cae56f`)/补全字段均无差别。**唯一差异变量是 body 加密**——
   服务端只对 `tt_data=a` 加密体真正分配 device_id,明文一律给 0。
   → **离线 device_register 必须复刻 native TTEncrypt 加密,无捷径。**

**最终判断**:离线注册 = 逆 native 加密(libEncryptor ttEncrypt / Rust applog),研究级工作量,
本阶段不划算。**推荐走第五节"抓真实注册设备入池"**:用本地 app 正常注册 N 台、grab 设备字段填
`devices.json`,设备池立即用上合法设备,完全不碰离线注册。
frida 备忘补充:`-n`(按名 attach)在本机 frida-server 枚举进程失败,只能 `-f` spawn;
反复 spawn/native 枚举会把 frida CLI(Python)abort 崩,尽量用轻量 Java hook。

### 抓包环境备忘(复现用)
- frida 17.9.6:**不能用 raw `create_script`**(`Java`/`Module.findExportByName` 全局已移除),用 `frida` CLI(自带桥接);后台跑需 `sleep N | frida ...` 保持 stdin 否则 REPL 读 EOF 即退;反复 spawn/attach 易把 frida CLI(Python)abort 崩。
- 触发注册:`adb shell pm clear com.phoenix.read` → spawn → 点"同意并继续"(1080x2400 约 540,2076)→ 通知 Allow(约 540,1245)。
- 抓包脚本:`frida/cap_all.js`(广捕 URL + service2 body)、`frida/hook_ttencrypt.js`(待定位正确加密库)。

## 五、可选替代路线(若不啃离线注册)

复用现有 app 环境:本地正常注册 N 台(清数据/多实例)→ `/grab` 各自 `device_id/iid/cdid/klink_egdi` 等 → 填进 `devices.json`。池子立即用上**合法**设备,完全不碰离线注册。
