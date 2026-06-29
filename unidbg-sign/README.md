# unidbg-sign — 红果(fqnovel)签名脱机化

目标:用 [unidbg](https://github.com/zhkl0228/unidbg) 在桌面 JVM 里模拟跑红果的 `libmetasec_ml.so`,
**脱离红果 App / 模拟器** 生成接口签名(`X-Argus / X-Gorgon / X-Ladon / X-Khronos`),
让 `hongguo.py` 的 `sign(url, headers)` 不再依赖 Frida 预言机。

> 背景:解密已 100% 离线(见 `docs/VIDEO_DECRYPTION_RE.md`);**唯一还需 App 的就是这一步签名**。
> 难度:`docs/REVERSE_ENGINEERING.md §7` 评估为"数天、中等成功率"(metasec OLLVM+VM+反模拟器)。本工程是其落地。

## 当前状态(2026-06-29)

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
