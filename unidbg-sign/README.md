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

下一步候选:① 升级 unidbg 版本(新版 `GetSuperClass(Object)→0` 已处理);② 或自定义 DalvikVM 覆盖 GetSuperClass 对 Object 返回 0。
过了继承链遍历后,预计依次遇到:`GetMethodID`/`RegisterNatives`/读 `/proc/self/maps`/`getPackageName`/签名校验 等回调,逐个喂红果真实值。

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
