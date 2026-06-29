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

### 三次突破(2026-06-29):离线加密 oracle 打通(不逆算法)

不逆 TTEncrypt 算法,改用**与签名同款的 unidbg 跑库**思路直接调用加密函数:
- 库 `libEncryptor.so`(83928B, stripped, 有 `JNI_OnLoad` 导出, **无 VM 保护**, 比 metasec 简单)。
- 类 `com/bytedance/frameworks/encryptor/EncryptorUtil`(JNI 类名 XOR 0x73 加密, 解出),
  方法 `ttEncrypt([BI)[B`(`byte[] ttEncrypt(byte[] data,int len)`)。
- `unidbg-sign/.../EncryptRun.java`:加载库 + callJNI_OnLoad + `callStaticJniMethodObject("ttEncrypt([BI)[B",..)`。
  **实测产出密文 magic `74 63 05 10`, 与真机 device_register body 一字不差。**`EncryptRun serve <port>` 常驻(POST 明文→密文)。

**离线注册流程已搭通**(`明文JSON → unidbg加密 → tt_data=a POST → 签名`),但**返回 device_id 仍为 0**:
- 加密体让响应从长变短(`{server_time,device_id:0,install_id:0}`,服务端按加密分支处理),
  但 stub(明/密文)/content-type/有无签名/补字段 均无差别, 恒 0。
- **高度怀疑是"新设备速率墙"**:本次在同一(机房非)IP 上猛灌数十次注册尝试, 服务端很可能已临时
  禁止该 IP 铸造新设备 → 不论注册体对错都给 0(原始真实 device_id 仍正常 = 非整体封, 是新设备铸造被限)。
- **未结**:需换干净 IP / 挂代理 / 冷却 后用 `EncryptRun`+`FqTrace` 重跑离线注册, 才能证伪"注册体是否正确"。
  另注:libEncryptor 只有 ttEncrypt 无独立 decrypt, 无法用它解密真机密文来比对明文结构。

### 四次(2026-06-29):离线注册"通了一半"——精确定位剩余墙

换干净本机 IP 重跑仍 device_id=0 → 排除速率墙, 是注册体/协议问题。逐项突破:
- **ttEncrypt 固定 key**(同输入同输出), 算法稳定。
- **wire 格式 = `ttEncrypt(gzip(JSON))`**:raw JSON 加密 → 短响应(服务端 gunzip 失败);
  **gzip 后再加密 → 完整响应**(服务端成功解密+解压+解析)。gzip 是之前缺的关键步骤。
- **决定性隔离测试 —— aid 1967(番茄海外)注册成功**:用匹配的 aid-1967 签名器 + 番茄海外参数
  (versionCode 68132/6.8.1.32/com.dragon.read.oversea.gp)+ i18n 域名 `log.isnssdk.com`,
  **返回真 device_id(如 7656821399541384725)+ install_id + new_user:1**。
  → **离线注册管线完全正确**(拼明文→gzip→unidbg ttEncrypt→tt_data=a POST→FqTrace 签名)。
- **红果 aid 8662 注册仍 0**:因 applog 网关(log.snssdk.com)**严格校验 X-Argus 内的 aid 必须=注册 aid**,
  而我们签名器是番茄海外 aid 1967 → 不匹配 → 0。(内容接口 fqnovel.com 宽松, 跨 app 能蒙;applog 不行。)
- **跨 app 设备不通**:新铸的 aid-1967 设备打红果内容 → 空 body(被拒)。
  **红果内容要求设备是 aid-8662 注册的(设备对内容是 aid-绑定的, 与跨app签名不同)。**

**最终精确结论**:离线注册红果设备 = 需要红果 **aid-8662 的 X-Argus 签名**(applog 严格验 aid)。
这绕回了最初的 metasec 墙——当初只是"为内容跨 app 绕过"(fqnovel 宽松), 并未真正攻破 aid-8662 签名。
要做红果设备池, 须先拿到 aid-8662 签名能力:① 找红果 libmetasec_ml.so 自己的 sign offset(原始难题),
或 ② 提取红果 metasec 证书喂给番茄海外签名器并让其按 aid-8662 出签(需红果 cert/op 参数, 待验证)。
**副产品**:番茄海外(Fizzo, aid 1967)设备可离线无限铸——若需 Fizzo 内容可直接用。
推荐红果设备池仍走第五节"app 注册 grab 入池"省力路线, 除非攻破 aid-8662 签名。

### 五次(2026-06-29):攻 aid-8662 签名 → 撞回原始 metasec 墙

试图为红果产 aid-8662 的 X-Argus(applog 注册严格验 aid), 三条路均受阻:
1. **两个 libmetasec_ml.so 不同版本**:红果 3971808B(md5 a2b9619c..)vs 番茄海外 3447432B(md5 affd5bdf..),
   0x168c80 处字节完全不同 → 番茄 offset 对红果无效(印证 MetasecSign 当初崩溃)。跑红果自己的库需
   **红果 sign offset**——OLLVM+VM 保护, 即最初一直没定位的墙。
2. **跨库喂红果证书**:即便提取红果 metasec 证书喂番茄海外库, 因两库版本不同, 能否出有效 aid-8662 签名未知。
3. **抓红果证书(MS.b op 16777218)**:hook 到 MS.b 各 op(16777217=apk路径/16777221=dpi/16777222=1000 等),
   但 **op 16777218 仅在 fresh device_register 特定时刻触发**, frida 时序飘 + 反复 spawn/attach 把 frida CLI 搞崩,
   本会话未能稳定抓到。frida 备忘:`adb root` 会让 frida-server 变 "jailed"(需重启 frida-server);
   不清数据 spawn 可免隐私弹窗(已同意持久化在 mmkv), 但 op16777218 此时不再触发(用缓存证书)。

**最终结论**:破红果 aid-8662 签名 ≡ 攻破 OLLVM+VM 保护的 metasec sign offset(研究级 VM 反虚拟化),
或稳定提取红果证书并验证跨版本复用。这是当初"用跨 app 为内容绕过、从未正面攻破"的硬骨头。
"别人成功"大概率是真做了 metasec VM 反虚拟化。**红果设备池务实方案仍是第五节 grab 入池。**

### 抓包环境备忘(复现用)
- frida 17.9.6:**不能用 raw `create_script`**(`Java`/`Module.findExportByName` 全局已移除),用 `frida` CLI(自带桥接);后台跑需 `sleep N | frida ...` 保持 stdin 否则 REPL 读 EOF 即退;反复 spawn/attach 易把 frida CLI(Python)abort 崩。
- 触发注册:`adb shell pm clear com.phoenix.read` → spawn → 点"同意并继续"(1080x2400 约 540,2076)→ 通知 Allow(约 540,1245)。
- 抓包脚本:`frida/cap_all.js`(广捕 URL + service2 body)、`frida/hook_ttencrypt.js`(待定位正确加密库)。

## 五、务实方案(已实现并验证):grab → devices.json 设备池

把真 app 注册的合法设备 grab 进设备池。**已端到端验证**:grab 的真设备 + 游客 + 跨 app 签名 →
红果搜索 `code=0`(过内容墙)。

工具:
- `frida/grab_device.js`:hook retrofit Request, dump 带 device_id 的请求 {url, headers}(base64 JSON, 多条)。
- `grab_device.py`:attach 运行中红果(按 PID 比 -n 稳), 合并多条请求的 query+headers 取全设备字段
  (device_id/iid/cdid/klink_egdi/device_brand/device_type/resolution/os_*/rom_version/channel);
  retrofit $init 阶段无 UA → 按设备字段构造自洽 UA; 去重追加 `devices.json`。

工作流(攒 N 台):
```bash
# 0. frida-server 运行(adb root 后启动); 红果已过隐私同意
# 1. 每台新设备: app 清数据并重新同意(或多开实例)→ 铸一台真设备
adb shell pm clear com.phoenix.read   # 启动 app 点同意, 让它注册
# 2. grab 入池(重启 app 制造请求爆发更易抓全字段):
python grab_device.py --out <hongguo运行目录>/devices.json
# 重复 1-2 攒多台
# 3. 启用: hongguo.py 同目录有 devices.json 即自动轮换(devicepool.load_pool)
```
注意:同模拟器注册的设备共享硬件指纹(device_type 等), 仅 device_id/iid/cdid/klink_egdi 不同;
更强多样性需多设备/多实例。`devices.json` 已 gitignore。
关键修正:`hongguo.py` 仅在池设备 UA 非空时才覆盖 UA(空 UA 会被拒)。
