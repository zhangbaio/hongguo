# unidbg-sign — 红果(fqnovel)签名脱机化

目标:用 [unidbg](https://github.com/zhkl0228/unidbg) 在桌面 JVM 里模拟跑红果的 `libmetasec_ml.so`,
**脱离红果 App / 模拟器** 生成接口签名(`X-Argus / X-Gorgon / X-Ladon / X-Khronos`),
让 `hongguo.py` 的 `sign(url, headers)` 不再依赖 Frida 预言机。

> 背景:解密已 100% 离线(见 `docs/VIDEO_DECRYPTION_RE.md`);**唯一还需 App 的就是这一步签名**。
> 难度:`docs/REVERSE_ENGINEERING.md §7` 评估为"数天、中等成功率"(metasec OLLVM+VM+反模拟器)。本工程是其落地。

## 🎉 已攻克(2026-06-29):跨 app 签名链路

**红果脱机签名达成 —— 走的不是"破红果自己的 VM",而是"用同后端的番茄海外签名器跨 app 签名"。**

关键发现:红果(aid 8662)和番茄海外(`com.dragon.read.oversea.gp`, aid 1967)**共用 fqnovel.com 后端**,
而 fqnovel 网关**只验签名本身有效,不做 app↔证书的强绑定校验**。所以可以:

1. 用 `FqTrace`(番茄海外 metasec,已知 offset `0x168c80`,在 unidbg 里能产真签名)给**红果的 API 请求**签名;
2. 带红果自己的 token/设备参数(`config.json`)发给红果 API → 服务器**认**。

实测对照(`/reading/bookapi/search/tab/v`):

| 请求 | 结果 |
|------|------|
| 红果请求 **无签名** | HTTP 200 但 **body 空** → 网关静默拦截(证明签名必需) |
| 红果请求 **+番茄海外跨app签名** | `code=0`,179KB 真实数据 ✅ |
| `multi_video_model` **+跨app签名** | `code=0`,返回 **1080p 真实 CDN 直链**(实拉首段 = 标准 MP4 `ftypisom`)✅ |

**端到端验证:`hongguo.py` 零改动**,仅把 `SIGN_SERVER` 指向本工程的常驻签名服务,
即可 `search → get_episodes → multi_video_model → 下载视频字节` 全程脱离红果 app / frida。

### 常驻签名服务(给 hongguo.py)

```bash
mvn -DskipTests package
# 启动(协议同原 frida 签名服务:POST /sign {url, headers} → {X-Argus,...})
java --add-opens java.base/java.lang=ALL-UNNAMED \
  -cp target/unidbg-sign-1.0-jar-with-dependencies.jar com.hongguo.sign.FqTrace serve 9099

# hongguo.py 端(另开终端):
export SIGN_SERVER="http://127.0.0.1:9099"
python hongguo.py search "皇后还乡"
python hongguo.py download <series_id> 1-3
```

> 依赖物(gitignore,不入库):`../capture/fq_oversea/` 下的番茄海外 `libmetasec_ml.so`、`libc++_shared.so`、
> 证书 `ms_16777218.bin`(取自 zero199901/fqnovel-unidbg)。
> 注:红果自身 build 的 metasec sign offset 仍未定位(OLLVM+VM 防静态),但**已无需**——跨 app 链路绕过了它。

---

## 历史:直攻红果自身 VM(已被跨app链路取代,存档)

- ✅ **里程碑①:工程跑通,`libmetasec_ml.so` 加载 + `JNI_OnLoad` 干净执行,无崩溃**(`base=0x40000000`)。
  - `libandroid.so` 依赖缺失是 unidbg 正常提示(用不到)。
  - JNI_OnLoad **未走标准 RegisterNatives/FindClass** → metasec 是**惰性注册**(首次调用 Java native 方法时才注册)。
- 已识别签名调用面(对运行中红果跑 `frida/find_metasec_methods.js` 得到):
  - **入口**:`com.bytedance.frameworks.baselib.network.http.NetworkParams.tryAddSecurityFactor(String url, Map headers)` → 返回安全头。
  - **核心**:`com.bytedance.mobsec.metasec.ml.MSManager`:
    - `Map getReportRaw(String, int, Map)` ← **生成 X-Argus 等的主函数**
    - `Map frameSign(String, int)`、`Map getFeatureHash(String, byte[])`、`void setCustomInfo(Map, boolean)`
  - 内部实现:`com.bytedance.mobsec.metasec.core.c` / `.core.a`;**native 方法在 `ms.bd.c.*`**(惰性注册)。

## 里程碑②进展(2026-06-29)

跑通后逐步观测 JNI_OnLoad(`MetasecSign` 手动调 + IOResolver 记录文件探测):
- **未发现反模拟器 bail**:JNI_OnLoad 正常执行 —— 先探测 `/dev/__properties__`、`/proc/stat`,
  然后 `FindClass(com/bytedance/mobsec/metasec/ml/MS)` **成功**。
- metasec **向上遍历类继承链**(完整性自检):`GetSuperClass(MS)` → 给它 Object 父类后 → `GetSuperClass(Object)`。
- **当前前沿卡点**:`GetSuperClass(java/lang/Object)` —— unidbg 0.9.8 对空父类抛 `BackendException`(DalvikVM64$7:148),
  应返回 null/0。属 unidbg 版本处理细节,**非反模拟器**。
- 结论:**这条路能往下走**,是标准的 unidbg "逐个补 env 回调" 迭代(每修一个暴露下一个)。

### 里程碑③进展(2026-06-29 续)

- 升级 unidbg **0.9.8 → 0.9.9**(JitPack;最新版,2026-03)。给 MS 注册 Object 父类后:
  `GetSuperClass(MS)→Object` ✅,推进到 `GetSuperClass(java/lang/Object)`。
- **确认这是 unidbg 的有意设计**(读 0.9.9 源码 `DalvikVM64._GetSuperclass`):当目标类是 `java/lang/Object`
  **或** `getSuperclass()==null 时,直接 `throw BackendException`,而不返回 0**。
  但 metasec 在真机上依赖 `GetSuperClass(Object)==null` 来**终止类继承链遍历**(完整性自检),所以这里必须返回 0。
- ⇒ **当前硬卡点 = metasec-on-unidbg 的已知摩擦:GetSuperClass 到 Object 时 unidbg 抛异常,需改 unidbg 行为。**

**两条解法(择一,均需真功夫):**
- **(a) fork/patch unidbg 源码**:把 `_GetSuperclass` 对 Object/null 改成 `return 0`,本地 `mvn install` 自建 unidbg 依赖。一行改动但要建 unidbg(含 unicorn/dynarmic 原生件)。
- **(b) 运行时 SVC hook**:取 JNIEnv 函数表,把 GetSuperclass 槽(JNINativeInterface 索引 10,偏移 0x50)替换成自定义 `Arm64Svc`(返回注册的父类,null→0)。不改 unidbg 但要手搓 JNIEnv 表 patch。

下一步候选:① 升级 unidbg 版本(新版 `GetSuperClass(Object)→0` 已处理);② 或自定义 DalvikVM 覆盖 GetSuperClass 对 Object 返回 0。
过了继承链遍历后,预计依次遇到:`GetMethodID`/`RegisterNatives`/读 `/proc/self/maps`/`getPackageName`/签名校验 等回调,逐个喂红果真实值。

### 里程碑③完成(2026-06-29 续2)🎉

- **解法(a) 落地**:克隆 unidbg v0.9.9 源码,把 `DalvikVM64._GetSuperclass` 对 `java/lang/Object`/null 父类
  从 `throw BackendException` 改为 `return 0`(符合 JNI 规范);**用 JDK 8(Zulu 8)编译**(JDK17+ 会 `Module` 歧义),
  `mvn install -pl unidbg-api,unidbg-android`(删父 pom 的 central-publishing 插件)→ 打补丁版 0.9.9 进本地 m2,backend 原生件用 Maven Central 的。
- 本工程 pom 依赖改为 Maven Central groupId `com.github.zhkl0228:unidbg-android:0.9.9`(本地打补丁版覆盖)。
- **结果:`JNI_OnLoad` 完整跑通,返回 `0x10006`(JNI_VERSION_1_6)= 成功!metasec 库在 unidbg 里初始化无反模拟器 bail。**
- 链路:`FindClass(MS)` → 类链遍历(补丁过)→ **`MS.b(op=0x1000000E,…)` 回调**(metasec 的 native→Java 分发器)→ 我先返回 null,JNI_OnLoad 即成功返回。
- natives = **惰性注册**(JNI_OnLoad 内无 RegisterNatives;首次调具体 native 方法时才注册)。

**`MS.b(int op,int,long,String,Object):Object`** 是 metasec 的核心回调:native 用不同 op 向 Java 要环境信息
(包名/签名/系统属性/设备参数 等)。当前仅 op=0x1000000E 在 init 期被调,返回 null 可过。

### 里程碑④进展(2026-06-29 续3):metasec 接口面完全测绘

反射枚举(`frida/enum_metasec_native.js`,attach 活红果)发现 metasec **整套 API 只有一个 native 入口**,对称 leviathan 设计:
- **native 入口(Java→native)**:`ms.bd.c.y2.a(int op, int, long, String, Object) : Object` —— init/getReportRaw/frameSign 全走它,靠 `op` 分发。
- **回调(native→Java)**:`com.bytedance.mobsec.metasec.ml.MS.b(int op, int, long, String, Object) : Object` —— native 反过来用它向 Java 要环境(包名/签名/系统属性/设备参数)。

⇒ 在 unidbg 里驱动签名 = **调 `y2.a(op,…)` 走对 opcode 序列(init → getReportRaw),并实现 `MS.b(op,…)` 各 opcode 返回红果真实值**。

**当前④卡点/下一步(多日 RE 主体):**
1. `y2.a` 是惰性注册且 libmetasec 无 `Java_*` 符号、JNI_OnLoad 内也没 RegisterNatives(疑 metasec 绕 JNIEnv 表手动注册以反 hook)
   → 需 **Ghidra 静态定位 `y2.a` 的 native 分发函数地址**(从 JNI_OnLoad/MS.b 引用链找),在 unidbg 里按地址直接调或手动 registerNatives。
2. **逆 opcode 表**:init 用哪些 op、getReportRaw 用哪个 op、各 op 的入参/返回语义。
3. **实现 `MS.b` 各 opcode**:喂红果真实环境(aid=8662、app_name=novelread、versionCode=72232、签名、设备参数取自 `config.json`)。
4. 过后续可能的反调试/完整性自检 → 产出 X-Argus,与 Frida 预言机输出逐字段比对(里程碑⑥真值校验)。

> 已实锤:库能在 unidbg 加载、JNI_OnLoad 初始化成功(无反模拟器 bail)、接口面=单 native 分发器 + 单回调。**地基与路线确定,剩余为 opcode 级 RE(按天计、中等成功率)。**

### 里程碑④突破(2026-06-29 续4):套用 dy233 范本,env 正确初始化

参考社区范本 **`zhuke945/dy233_unidbg_sign`**(抖音 metasec unidbg 签名,同款 libmetasec_ml.so),关键修正:
- **真实类链**:`ms/bd/c/k ← ms/bd/c/a0 ← com/bytedance/mobsec/metasec/ml/MS`(之前错注册成 MS→Object 才会卡 GetSuperClass(Object))。
- **`createDalvikVM(base.apk)`** 带真 APK(类解析/签名校验),`memory.setCallInitFunction(true)`。
- 实现回调:`Thread.getStackTrace`→伪造 2 帧(过反调试栈检查)、`Thread.currentThread`、`MS.a()V`→no-op、`MS.b(op,…)`→按 op 返回(files 目录/版本/布尔)。
- **结果:JNI_OnLoad + init 在真类链+apk 下完全干净跑通,无 GetSuperClass 报错、init 期未再触发问题 MS.b。env 已正确初始化。**

**签名调用法(范本给定)**:`module.callFunction(<签名函数偏移>, url, headerStr)` → 返回 hash → `vm.getObject(hash)`/`memory.pointer(hash)` 取签名串。
header 格式为 `key\r\nvalue\r\n…` 配对。

**当前④唯一剩余 = 找红果 libmetasec_ml.so 里那个签名函数的偏移**(dy233 是 0x438c0/32位thumb;红果是 arm64,偏移不同,需 RE):
- 候选找法:① Ghidra 静态找处理 url+header 字符串、产出头的函数;② 活红果上 trace `tryAddSecurityFactor` 的 native 调用链取偏移(受反 frida 限,需 attach);③ 在 unidbg 里驱动 `y2.a` 的签名 opcode 反推。
- 找到偏移后:`callFunction(off, url, header)`,期间会触发 `MS.b` 各 op(按需补真值)+ 可能反调试 → 出 X-Argus → 里程碑⑥ 与 Frida 预言机逐字段比对。

> ⚠ 依赖 `base.apk`(125MB,gitignore;放 hongguo-mac/ 或传参指定路径)。

### 里程碑④决定性发现(2026-06-29 续5):找到 fqnovel 专用 unidbg 范本 🎯

**`zero199901/fqnovel-unidbg`**(`IdleFQ.java`)是 **fqnovel(红果同后端)专用的完整 metasec 签名实现**,针对 `com.dragon.read.oversea.gp`(番茄海外 6.8.1.32)。**强证据:它处理的 `MS.b` op `268435470` = 返回 `System.currentTimeMillis()`,正是本项目红果实测到的那个 op → 红果与番茄海外共用同族 libmetasec,范本可直接套用。**

范本给全了之前缺的所有东西:
- **类链**:`ms/bd/c/m ← ms/bd/c/a4$a ← com/bytedance/mobsec/metasec/ml/MS`(版本相关,见下"待提取")。
- **签名调用**:`module.callFunction(emulator, 0x168c80, url, header)` → `memory.pointer(ret).getString(0)`;header 格式 `key\r\nvalue\r\n…`。
- **`MS.b(op,…)` 完整 opcode 表**(`handleMSMethod`):
  - `65539` → files 目录路径(`/data/user/0/<pkg>/files/.msdata`)
  - `33554433`/`33554434` → boolean true
  - `16777232` → Integer `68132`
  - `16777233` → 版本号字符串(如 "6.8.1.32")
  - **`16777218` → metasec 证书文件字节(`ms_16777218.bin`)**
  - `268435470` → `System.currentTimeMillis()`(✅ 与红果实测 op 一致)
- 其它回调:`Thread.getStackTrace`(真栈)、`getBytes`、`Long/Integer/Boolean.xxxValue`、`MS.a()V`→no-op、`getStaticIntField MS.a` → 0x40。
- 依赖:`libc++_shared.so`、apk、rootfs、`inode/uid` 设置、IOResolver 重定向 so/apk 路径。

### 最快落地路线(改用 fork fqnovel-unidbg)

比从零写本工程更快:**fork `zero199901/fqnovel-unidbg`,把番茄海外的 4 个工件换成红果的**:
1. **`libmetasec_ml.so`** → 红果的(已有 `capture/so/libmetasec_ml.so`)。
2. **签名偏移 `0x168c80`** → 红果 .so 可能不同;先**直接试 0x168c80**(同族大概率一致或接近),不对再 RE 定位(找处理 url+header 产出头的函数)。
3. **类链 `m/a4$a`** → 红果可能不同(本项目实测 native 在 `ms.bd.c.y2`);先试范本名,FindClass 失败则用红果实际混淆名。
4. **metasec 证书(op 16777218 的 `ms_16777218.bin`)** → 需从红果 app 提取(assets/运行时 dump)。
5. PACKAGE_NAME=`com.phoenix.read`、version=`7.2.2.32`、设备参数取 `config.json`。

> 进度:env 初始化已通(里程碑④突破);剩余 = 上面 4 个红果专属工件的提取/校准。范本把"怎么做"全给了,剩纯提取工作。

### 里程碑④再突破(2026-06-29 续6):harness 全移植,跑进红果签名函数内部

把 IdleFQ 完整移植进 `MetasecSign`(红果 libmetasec_ml.so + libc++_shared.so + 类链 + 全套回调),实跑结果:
- ✅ **类链 `MS ← ms/bd/c/a4$a ← ms/bd/c/m` 红果完全适用**(与番茄海外同名!`GetSuperClass(MS)→a4$a→m`)。
- ✅ **native 注册成功**:`RegisterNatives(ms/bd/c/m, a(IIJLjava/lang/String;Ljava/lang/Object;)…)` @ `libmetasec+0x26e684`。
- ✅ **init 完成**,FindClass(Long) 等回调正常。
- ✅ **`callFunction(0x168c80,url,header)` 落在红果可执行代码、签名开始执行**(进入 OLLVM 控制流),
  最终 `br x9` 读到未映射地址崩 —— 因为 **0x168c80 是番茄海外(6.8.1.32)的偏移,红果(7.2.2.32)是不同 build,落点偏进了函数中段**。

⇒ **唯一剩余 = 红果自己的签名函数入口偏移**(其余全部通用!证书 op 16777218 暂返回 null 也跑到了 sign 阶段)。
两个 .so 都在手(`capture/so/libmetasec_ml.so` 红果 / fqu 资源里番茄海外),可**二进制对比定位**:
- 番茄海外 sign 入口 = 0x168c80;提取其特征(prologue / 算法常量如 `0x0a021040`),在红果 .so 搜同特征 → 红果偏移。
- 或 Ghidra 找处理 url+header、调 m.a 分发、产出头的函数。
- 备选:不用直接偏移,改调已注册的 `m.a(op,…)` 分发器(需红果签名 opcode)。

### 里程碑④收口现状(2026-06-29 续7):仅差红果签名偏移,需 Ghidra

二进制对比尝试(`find_sign_offset.py`,capstone):
- 番茄海外 0x168c80 处函数**前缀字节在红果 0 命中**(OLLVM 跨 build 帧布局不同,预期)。
- 番茄海外 0x168c80 **wrapper 开头不加载大常量**(真正带算法常量的 crypto 在更深层调用),故线性反汇编的常量聚类**定位不到**。
- 已确认 vaddr==文件偏移(红果 `file[0x168c7c]=2c0300b9` 与运行时反汇编一致)。

⇒ **结论:定位红果签名函数入口偏移需要 Ghidra**(对 4MB OLLVM .so 做 CFG/反编译;线性 capstone 不够)。这是剩余唯一阻塞,且是 RE 专项活。

**找红果偏移的两条 Ghidra 路:**
1. 反编译番茄海外 0x168c80,看它的特征(调用链/字符串 xref/参数处理),在红果 .so 找对应函数;两 .so 都在手可对照。
2. 反编译红果已注册的 `m.a`@0x26e684 分发器,跟踪"取签名/报文"的 opcode 分支 → 找到内部 sign 函数;或直接在 unidbg 里调 `m.a(op,…)`(需该 opcode)。

> **当前完成度:除"红果签名函数偏移"外全部打通**(env/类链/native注册/init/回调/sign 执行入口全验证)。拿到偏移后 `sign(url,header)` 即可出 X-Argus(证书 op 16777218 若必需再补提取)。这是 metasec unidbg 工程的"最后一公里",需 Ghidra 专项。

### Ghidra 这一关结果(2026-06-29 续8):静态被 OLLVM 击败,转动态/数据表 xref

- Ghidra 12.1.1(brew)+ JDK17 可用;两个 .so 各 ~90s 分析入库(`/tmp/ghidra_proj` 的 `fq_meta`/`hg_meta`),工具脚本 `ghidra/decomp.java`(反编译+callees+xref)。
- 番茄海外 sign 入口 `0x168c80`(`FUN_00268c80`)= 小混淆 wrapper:读栈金丝雀 → 调 `FUN_00268ce4(buf)` → 间接调 `(ret+0x38)()`;`0x168c80` 被 `0x168c54` 调用。
- **OLLVM 使 Ghidra 反编译失效**:`FUN_00268ce4` 反编译成 `return unaff_x30;`(垃圾),满屏 "Could not recover jumptable / indirect jump"。**静态反编译定位红果对应函数走不通**。

**剩余可行路线(均为深度 RE,需专门时间):**
1. **动态 trace(最可行)**:番茄海外 sign 在 unidbg 已跑通(fqu harness)→ 开 `emulator.traceCode()` 跑一次,记录运行时真实执行到的函数/常量/数据表地址(运行时绕过 OLLVM 静态混淆)。
2. **.rodata 算法表 xref(最稳)**:从 trace 找 sign 用的 **crypto 查找表/S-box(.rodata,build 不变)** → 在红果 .so 搜同字节 → Ghidra 找 xref → 红果 sign 函数 → 回推入口偏移。
3. 备选:动态在 unidbg 里对红果 m.a(@0x26e684)驱动签名 opcode(需逆 opcode)。

> **里程碑④定论:除红果签名函数偏移外全部打通;该偏移因 metasec OLLVM 静态不可解,需动态 trace / .rodata 表匹配的专项 RE(数日级)。** 工程、文档、两个已分析的 Ghidra 工程、范本均已就绪可接力。

### 🎉 里程碑⑤验证(2026-06-29 续9):harness 产出真签名(番茄海外端到端打通)

`FqTrace.java`(番茄海外 6.8.1.32 配置 + capture/fq_oversea/ 工件)在本 unidbg 环境 **`callFunction(0x168c80, url, header)` 成功产出完整 metasec 签名**:
`X-Argus / X-Gorgon / X-Helios / X-Khronos / X-Ladon / X-Medusa / X-Neptune / X-Soter`(七神齐全,X-Khronos=当前时间戳,均结构合法)。
("SDK not init crashing" 为 benign 日志,不影响签名产出。)

⇒ **整套 harness/回调/证书/类链方案被证明完全可行** —— 同款 metasec,红果**只差签名函数偏移**。
现在有了**可跑通的番茄海外参照**,可用动态 trace 抓 .rodata 算法表 → 红果同表 xref → 反推红果偏移。

### 动态 trace 结果(2026-06-29 续10):harness 产真签名 ✅;但表匹配被 VM 保护挡住

`FqTrace` 加内存读 hook,trace 番茄海外 sign 运行时对 libmetasec 的读取:
- 找到热读区(疑似算法表):`+0x2a2970..0x2a37fc`(932点)、`+0x2a3b00..0x2a4944`(914点)等。
- **但这些区字节(`f500a232 f580a054…`)在红果 .so 里 0 命中** —— 它们是 **metasec VM 的字节码/加密表,build 专属**(VM 保护核心),**不是 build 不变的标准 crypto 表**。⇒ 表匹配定位红果偏移**也失败**。

**结论:metasec 的 OLLVM+VM 保护把"静态反编译"和"数据表跨 build 匹配"两条都封死了。** 找红果偏移只剩最硬的两条:
1. **devirtualize metasec VM**(还原 VM 解释器 + 找 sign 入口),数日级专家活;
2. **逆 m.a opcode**:红果已注册 native `m.a`@0x26e684,找签名 opcode + 参数布局,直接调 m.a(也需深逆)。

> **里程碑⑤定论:unidbg harness 已证明能产出真 metasec 七神签名(番茄海外端到端);红果同款,差且仅差签名入口偏移;该偏移被 metasec VM 保护封死静态/表匹配两路,需 VM 级深逆(最高难度档)。这是 metasec 逆向公认的天花板。**

> 备选务实方案(非脱机):redroid/模拟器跑红果 app 当无人值守签名服务(Frida 预言机已就绪,见主仓 `frida/oracle.js`)。

## 路线图(后续里程碑)

- **② 触发 native 注册 + 摸清 native 方法**:在 unidbg 里建 `MSManager`/`ms.bd.c.*` 的 DvmClass 并调用,
  让 metasec 惰性 RegisterNatives;`vm.setVerbose(true)` + slf4j-simple(本工程已配)观察注册的 (类,方法,签名) 与第一处缺失的 JNI 回调。
- **③ 补齐 env 回调过初始化**:metasec init 需要设备/应用上下文(packageName/签名/deviceId/appId/license…)。
  在 `MetasecSign extends AbstractJni` 里逐个实现被回调的 `callStaticObjectMethod` 等,喂红果真实值
  (aid=8662、app_name=novelread、versionCode=72232、设备参数取自 `config.json`)。
- **④ 跑通 `getReportRaw` / `tryAddSecurityFactor` 产出真签名**:复刻 app 的初始化序列(`MSConfig` / `MSManagerUtils.get(...)`),
  传入 `url + x-ss-stub(body MD5) + 设备头`,拿到 `X-Argus/X-Gorgon/...`。**主风险:反模拟器/完整性自检**。
- **⑤ 封装成签名服务**:暴露 `sign(url, headers) -> {安全头}`(HTTP 或 stdin/stdout),
  在 `hongguo.py` 设 `SIGN_SERVER=http://127.0.0.1:<port>` 即可替换 Frida 预言机 → **彻底脱离 App**。
- **⑥ 用 `config.json` 真实设备参数 + 真值校验**:对同一 url/headers,unidbg 产出的签名与 Frida 预言机产出的逐字段比对一致;
  再用真签名打 `multi_video_model` 拿到 `code=0`。

## 构建 & 运行

```bash
# 需 JDK8+(实测 JDK25 可编译运行)、Maven。libmetasec_ml.so 放 ../capture/so/(从设备 /data/app/.../lib/arm64/ 拉)
mvn -DskipTests package
java -jar target/unidbg-sign-1.0-jar-with-dependencies.jar ../capture/so/libmetasec_ml.so
```

## 文件
- `pom.xml` — unidbg(JitPack `com.github.zhkl0228.unidbg:unidbg-android:0.9.8`) + slf4j-simple。
- `src/main/java/com/hongguo/sign/MetasecSign.java` — 加载器(里程碑①)。后续在此 `extends AbstractJni` 补 env 回调。
- `src/main/resources/simplelogger.properties` — 打开 unidbg dvm 调试日志(看 RegisterNatives/JNI 回调)。
- `../capture/so/libmetasec_ml.so` — 目标库(gitignore;从设备拉取)。

## 已知坑
- metasec 字符串/类名加密、native stripped → 静态看不到方法名,**靠 unidbg 运行时观察 + frida 枚举**。
- JDK17+ 跑 unidbg 需 `--add-opens java.base/java.lang=ALL-UNNAMED`(本工程命令已带)。
- 真正难点在 ③④ 的反模拟器自检,不是加载本身;预期多轮迭代。
