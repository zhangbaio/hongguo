# 在 Apple Silicon Mac 上做红果视频解密逆向（全套搬到 Mac）

> 目标：用 M 芯片 Mac 跑**原生 arm64** Android 模拟器（或真机），拆掉 MuMu 的 **Houdini 翻译层墙**，
> 让 Frida 的 native **backtrace 可用** → **定位 spade_a→key 的 unwrap 函数** → **直接调用它批量出 key（无需播放视频）**。
>
> 背景速读（详见 `docs/VIDEO_DECRYPTION_RE.md`）：红果视频 = 标准 **CENC AES-128-CTR**，密码学层已攻破。
> 每视频要 `content key(16B) + base_iv64(8B)`。key 由 `spade_a`(37B 包装 blob) 在**端上 native 本地 unwrap**得到。
> 在 MuMu(x86+Houdini) 上无法回溯定位 unwrap；**Apple Silicon 跑 arm64 镜像零翻译，backtrace 可用 → 这是关键解锁。**
>
> 三个产出目标（由易到难）：
> - **(P-now) keybox 预言机**：`downloader.py`/`oracle.py` 已验证，在 Mac arm64 上同样可用且更快（仍需播放/解码，作为即时可用兜底）。
> - **(P1 ★本计划核心) 直调 unwrap，无需播放**：定位 unwrap 函数 → `NativeFunction(spade,kid)→key` 批量。app 要运行但**不放视频**。
> - **(P2 终极) 纯离线无 app**：逆出 unwrap 算法/KEK，纯代码解所有视频。需要 P1 的函数定位 + 深逆。

---

## 0. 总览与机器角色

- **Mac（本计划主机）**：跑 arm64 Android（AVD 或真机）+ Frida + Ghidra + Python，做全部逆向与解密。
- 不再依赖 Windows PC（签名栈/MuMu 留在 Windows，与本计划无关）。
- 需要从 Windows 仓库**拷贝的资产**见 §5；**不要**拷贝敏感文件（config.json / apikeys.json / .env / deploy 私钥）。

---

## 1. macOS 基础环境

```bash
# Homebrew（若未装）
/bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"

# 基础工具
brew install python@3.12 ffmpeg wget openjdk@21 git
brew install --cask android-studio      # 含 SDK/AVD/emulator（Apple Silicon 原生）
brew install --cask ghidra              # 反编译器

# Python 虚拟环境
python3 -m venv ~/hg-venv
source ~/hg-venv/bin/activate
pip install --upgrade pip
pip install frida-tools frida pycryptodome requests
frida --version       # 记下版本号(如 16.5.9)，下一步 frida-server 必须同版本
```

把这些加到 `~/.zshrc`：
```bash
export ANDROID_HOME="$HOME/Library/Android/sdk"
export PATH="$ANDROID_HOME/platform-tools:$ANDROID_HOME/emulator:$ANDROID_HOME/cmdline-tools/latest/bin:$PATH"
export JAVA_HOME="$(brew --prefix openjdk@21)/libexec/openjdk.jdk/Contents/Home"
source ~/hg-venv/bin/activate
```

---

## 2. 原生 arm64 Android 模拟器（关键：必须 arm64-v8a 镜像）

```bash
sdkmanager "platform-tools" "emulator" "platforms;android-33"
# Google APIs 镜像支持 adb root（Play 镜像不支持）；arm64-v8a = 原生无翻译
sdkmanager "system-images;android-33;google_apis;arm64-v8a"

avdmanager create avd -n hgarm -k "system-images;android-33;google_apis;arm64-v8a" -d pixel_5

# 启动（首次用 -no-snapshot；-writable-system 便于后续刷 Magisk）
emulator -avd hgarm -no-snapshot -writable-system -gpu swiftshader_indirect &

adb wait-for-device
adb root                                  # google_apis 镜像可直接 root adbd
adb shell getprop ro.product.cpu.abi      # 必须输出 arm64-v8a  ✅（证明无 Houdini）
adb shell uname -m                        # aarch64
```

> 若红果要求更高/更低 Android：换 `android-31`(12) 或 `android-34`(14) 的 `google_apis;arm64-v8a` 镜像即可。
> **真机替代**：若用 Pixel/Mi 4C，跳过本节，`adb` 直接连真机即可，后续完全相同。

---

## 3. frida-server（arm64，版本与电脑端一致）

```bash
FV=$(frida --version)
wget https://github.com/frida/frida/releases/download/$FV/frida-server-$FV-android-arm64.xz
unxz frida-server-$FV-android-arm64.xz
adb push frida-server-$FV-android-arm64 /data/local/tmp/frida-server
adb shell chmod 755 /data/local/tmp/frida-server
adb shell "/data/local/tmp/frida-server -D &"     # adb 已 root，直接跑
frida-ps -U | head                                # 能列进程 = 连通
```

---

## 4. 安装红果 app

**优先**用我们手里的 apk（让 `.so` 偏移与已有 Ghidra 分析对齐）：
```bash
# 红果是 split APK：base + abi + density + locale。若有全套：
adb install-multiple base.apk split_config.arm64_v8a.apk split_config.xxhdpi.apk split_config.zh.apk
# 若只有 base.apk 且能独立装：
adb install base.apk
adb shell monkey -p com.phoenix.read 1            # 启动
```
装不上/缺 split → 用红果官方 .apks/.xapk（应用商店导出）再 `install-multiple`。
> ⚠ 之后若用商店新版本，`.so` 偏移会变，§7 的定位要在**该版本的 .so** 上重做（Ghidra 同流程）。

### 4.1 反检测（仅当 app 拒绝运行/播放时再做）
字节系 app 有模拟器/root 检测。若黑屏/闪退/不播：
```bash
# rootAVD 给模拟器装 Magisk
git clone https://github.com/newbit1/rootAVD && cd rootAVD
./rootAVD.sh ListAllAVDs
./rootAVD.sh <上面列出的 ramdisk.img 路径>
```
然后：装 Magisk app → 开 **Zygisk** → 装 **Shamiko** 模块 → DenyList 勾 `com.phoenix.read`。
> 我们其实只需**成功 prepare/播一次**拿到 spade + backtrace 即可定位，不必长期稳定。

---

## 5. 从 Windows 仓库拷过来的资产

拷到 Mac `~/hongguo/`：
- `frida/`（全部 `.py` / `.js`：oracle.py、downloader.py、decrypt_full.py、extract_keybox_pairs.py、hook_jnistr.js、hook_ctrinit.js、ghidra_*.py 等）
- `capture/so/`（`libavmdlv2.so` / `libuniplayer.so` / `libttmplayer.so` / `libvcn.so` / `libttcrypto.so` / `libEncryptor.so` / `libdragon_crypt.so` …）—— Ghidra 用
- `capture/spade_key_pairs*.json`（5 组 spade→key 真值，验证 unwrap 用）
- `docs/VIDEO_DECRYPTION_RE.md`、`docs/MAC_ARM_PLAN.md`（本文件）、`tools/ghidra_scripts/*.java`
- 可选：`hongguo.py`（按 vid 取 video_model 含 spade/kid/main_url，用于批量喂 unwrap）

**不要拷**（RE 用不到 + 敏感）：`config.json`、`apikeys.json`、`.env*`、`deploy/`、`capture/*.bin`（多 GB，Mac 上重新 dump）。

### 5.1 适配 oracle.py / downloader.py 到 Mac（adb 已 root，无需 su）
两脚本顶部常量改成 Mac 环境：
```python
ADB = "adb"                 # PATH 里的 adb
DEV = "emulator-5554"       # 真机则填 `adb devices` 里的序列号
```
并把 `adb_su(cmd)` 改为直接以 root 跑（adbd 已 root，不需要 `su -c`）：
```python
def adb_su(cmd, **kw):
    return adb("shell", cmd, **kw)     # 原来是 "su -c '...'"，Mac AVD 直接 shell 即 root
```
> 真机若非 adb-root 而是 Magisk root，则保留 `su -c '...'` 形式。

---

## 6. 阶段 1 —— 决定性验证：backtrace 不再被翻译层挡（先做这个！）

这是整个 Mac 方案值不值得的判定点。**1 小时内能出结论。**

1. 红果里**滑到一个全新在线短剧并让它播放**（画面在动 = 在解码，spade 会进内存/经 JNI）。
2. 跑 JNI hook 抓 spade + 回溯：
```bash
cd ~/hongguo
# hook_jnistr.js: hook JNIEnv GetStringUTFChars(vtable idx 169)，匹配 base64 的 spade 串后打印 Thread.backtrace
frida -U -n com.phoenix.read -l frida/hook_jnistr.js
```
3. **判定**：
   - ✅ backtrace 帧形如 `libuniplayer.so!0x10fc78`、`libavmdlv2.so!0x...` 等**真实 ARM 模块+偏移** → **墙已拆，继续 §7**。
   - ❌ 仍指向 `libhoudini`/无法解析 → 说明跑的不是原生 arm64（镜像选错/真机非 arm64），回 §2 检查 `ro.product.cpu.abi`。

> 在原生 arm64 上根本不存在 libhoudini，正常情况一定是 ✅。这一步主要是确认镜像/设备选对了。

---

## 7. 阶段 2 —— 定位 spade→key 的 unwrap 函数

已知链路（来自 `VIDEO_DECRYPTION_RE.md` §16.3）：
`Java(EncryptInfo.spadeA) → libuniplayer(解析/搬运 spade) → ??? unwrap(37B→16B key) → libavmdl 密钥盒 → AES-CTR`。
unwrap 在某 native lib（**不**在 libavmdl 自带 AES，**不**在 Java javax.crypto）。在 arm64 上这样找：

**7a. 用 backtrace 锁定消费者**
- §6 的 backtrace 里，紧挨 JNI 之上的几帧就是**读取 spade 字符串的 native 函数**。记下其 `模块!偏移`。

**7b. Ghidra 反编译该函数，顺调用图找 unwrap**
```bash
# headless 反编译（复用已有脚本/思路）
export JAVA_HOME="$(brew --prefix openjdk@21)/libexec/openjdk.jdk/Contents/Home"
analyzeHeadless ~/hg-ghidra-proj hg -import capture/so/libuniplayer.so \
  -postScript tools/ghidra_scripts/DecompAll.java -deleteProject
# 或针对单函数偏移做 xref / callers：
python frida/ghidra_callers.py capture/so/<lib>.so <偏移>
```
- 在反编译里追：哪个函数拿 37 字节 buffer + 输出 16 字节写入下游 struct（密钥盒）。
- 重点怀疑对象：libuniplayer 之外被它调用的 native（可能 libavmdl 的**非** AES 区、libttmplayer、libvcn、或某 ByteDance security 库）。

**7c. Frida 动态确认（用真值对，无歧义）**
- 对候选 unwrap 函数 hook 入口/出口：入口 dump x0..x3 指向的内存、出口 dump 输出 buffer。
- 让 app 播放 **真值样本对应的视频**（或任意视频），核对：**入参里出现某 spade(37B)、出参/写入处出现对应 16B key**。
- 我们有 5 组 `spade→key` 真值（`capture/spade_key_pairs*.json`）→ 命中即 100% 确认是 unwrap。

参考 Frida hook 骨架（base+偏移绕 namespace 隔离）：
```js
const base = Module.findBaseAddress("libXXX.so")
  || Process.enumerateRanges('r-x').find(r => r.file && r.file.path.endsWith("libXXX.so")).base;
const fn = base.add(0xXXXXX);
Interceptor.attach(fn, {
  onEnter(a){ this.spade = a[0]; this.out = a[2]; console.log("spade37:", hexdump(a[0], {length:37})); },
  onLeave(r){ console.log("key16:", hexdump(this.out, {length:16})); console.log(Thread.backtrace(this.context, Backtracer.ACCURATE).map(DebugSymbol.fromAddress).join("\n")); }
});
```

---

## 8. 阶段 3 —— 无需播放：直接调用 unwrap

确认 unwrap 函数签名后（典型：`int unwrap(const u8* spade37, int len, const u8* kid16, u8* out_key16)`，或返回 key 指针）：

```js
// 直接调用，喂任意视频的 spade+kid，得到 key —— 全程不播放视频
const unwrap = new NativeFunction(fn, 'int', ['pointer','int','pointer','pointer']);
function getKey(spadeBytes, kidBytes){
  const sp = Memory.alloc(37); sp.writeByteArray(spadeBytes);
  const kid = Memory.alloc(16); kid.writeByteArray(kidBytes);
  const out = Memory.alloc(16);
  unwrap(sp, 37, kid, out);
  return out.readByteArray(16);
}
```
- **批量**：从我们的 API / `hongguo.py` 取每个 vid 的 `spade_a`(base64→37B) + `kid`(hex→16B) → 调 `getKey` → 内容密钥。**千/秒级、零播放**。
- 先用 5 组真值 `getKey(spade)==known key` 全部命中做回归验证。

### 8.1 还差 base_iv64（8B）
解密需要 `key + base_iv64`。三种来源，按优先级试：
1. **密文文件自带 senc**：实测下载的密文 mp4 含 `senc/saio/saiz`，per-sample 8B IV 且逐样本+1 →
   **base_iv64 = 首样本 IV 高 8 字节，直接读文件即可**（若确为如此，base_iv 完全离线、无需内存/app）。
   验证：`oracle.py --verify <密文>` 跑出的 base_iv 是否 == 密文 senc 首样本 IV。**（强烈建议先验证这条，成立则 P1 直接升级为"key 靠 unwrap、iv 靠文件"的近似纯离线）**
2. unwrap 是否**同时**产出 iv（hook 出参里看有没有 8/16B IV）。
3. 退化：从密钥盒取（`oracle.py` 现成）。

### 8.2 接成"无播放下载器"
- 把 `downloader.py` 的"播放→dump 密钥盒"替换为"`getKey(spade)` 直调 + base_iv(§8.1) + `decrypt_full.py`"。
- app 保持运行（unwrap 函数需进程在）但**不放任何视频**；要纯离线无 app，进 §9。

---

## 9. 阶段 4（终极/可选）—— 纯离线无 app：逆 unwrap 算法

定位到 unwrap 函数后，在 arm64 + Ghidra 上**反编译并移植该算法**（含其 KEK 来源：常量/白盒查表/运行时派生）。
- 先扫该函数引用的常量表（4KB 级 = 白盒 T-box 嫌疑）。
- 有 backtrace + 干净 arm64 反编译，比在 Houdini 下逆**容易得多**。
- 成功 → 纯 Python/C 实现 `spade→key`，**彻底脱离 app**，与第三方下载器同级。
> 这是大工程；P1（§8 直调）已能"无需播放"，多数情况够用，P2 量力而行。

---

## 10. 即时兜底：keybox 预言机在 Mac 上同样可用（更快）

定位 unwrap 之前，`oracle.py`/`downloader.py` 在 Mac arm64 上**立即可用**（原生更快），流程同 Windows：
```bash
# 确保红果正在【在线流】播放、画面在动
python frida/downloader.py            # 自动 dump→提 key/iv→下密文→试解→输出可播 mp4
# 或工具自检：
python frida/oracle.py --reuse <dump> --verify <密文>
```
> 注意 §5.1 的 adb/su 适配。仅在线流有效（缓存/离线无 key）。

---

## 11. 执行顺序（建议）

1. §1–§4 环境就绪 → §6 **决定性验证 backtrace**（1 小时定生死）。
2. backtrace ✅ → §7 定位 unwrap（Ghidra+Frida+真值对，1–3 天）。
3. §8 直调 unwrap = **无需播放出 key**；并先验证 §8.1-(1) base_iv 是否在密文 senc 里（成立则近似纯离线）。
4. 接 `downloader.py` 成无播放批量下载器（§8.2）。
5. 余力 → §9 逆算法做纯离线无 app。
6. 全程兜底：§10 keybox 预言机随时可用。

---

## 12. 坑与注意
- **镜像必须 `google_apis;arm64-v8a`**（Play 镜像不能 adb root；x86 镜像又回到翻译层问题）。
- frida-server **版本必须等于** `pip` 装的 frida（`frida --version`）。
- app 检测模拟器/root → §4.1 Magisk+Shamiko；或换真机。
- 红果**只有在线流**视频才在内存生成 spade/填密钥盒；缓存/下载走安全路径不暴露（§6 必须放全新在线视频）。
- 重型 Frida 操作（枚举十万类）会崩 app；类名过滤要轻量。
- 大文件：`capture/*.bin`、`tools/` 已 gitignore；Mac 上新生成的 dump 同样别提交。
- 进展请同步追加到 `docs/VIDEO_DECRYPTION_RE.md` §16.10。
```
