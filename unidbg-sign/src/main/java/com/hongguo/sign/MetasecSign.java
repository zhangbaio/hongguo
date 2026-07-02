package com.hongguo.sign;

import com.github.unidbg.AndroidEmulator;
import com.github.unidbg.Emulator;
import com.github.unidbg.Module;
import com.github.unidbg.file.FileResult;
import com.github.unidbg.file.IOResolver;
import com.github.unidbg.file.linux.AndroidFileIO;
import com.github.unidbg.linux.android.AndroidEmulatorBuilder;
import com.github.unidbg.linux.android.AndroidResolver;
import com.github.unidbg.linux.android.dvm.*;
import com.github.unidbg.linux.android.dvm.array.ArrayObject;
import com.github.unidbg.linux.android.dvm.array.ByteArray;
import com.github.unidbg.linux.android.dvm.wrapper.DvmBoolean;
import com.github.unidbg.linux.file.SimpleFileIO;
import com.github.unidbg.memory.Memory;
import com.github.unidbg.pointer.UnidbgPointer;
import com.github.unidbg.virtualmodule.android.AndroidModule;
import com.github.unidbg.virtualmodule.android.JniGraphics;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

/**
 * 红果(com.phoenix.read)metasec 脱机签名 —— 移植 zero199901/fqnovel-unidbg(IdleFQ)适配红果。
 * 先用番茄海外的类链(m/a4$a)+偏移(0x168c80)试跑,观察红果实际 FindClass/卡点。
 */
public class MetasecSign extends AbstractJni implements IOResolver<AndroidFileIO> {

    static final String PKG = "com.phoenix.read";
    static final String VER = "7.2.5.32";      // 对齐设备实际版本(.msp hash 含 versionCode)
    static final String FILES = "/data/user/0/com.phoenix.read/files";
    // 红果自身 sign offset(2026-06-30 动态逆出):cronet 数据段 sscronet+0x5f5458 注册的 metasec 回调。
    // 调用约定: sign(x0=url, x1=header, x2=0x18, x3=ns_tick, x4=0xffffffffffffff, x5=counter) → "X-Argus\r\n...".
    static final long SIGN_OFFSET = 0x27d288;

    private final AndroidEmulator emulator;
    private final VM vm;
    private final Module module;
    private final Memory memory;
    private final File soMeta;
    private File certFile; // op 16777218

    public MetasecSign(File soMeta, File soCpp, File cert) {
        this.soMeta = soMeta;
        this.certFile = cert;
        emulator = AndroidEmulatorBuilder.for64Bit()
                .setProcessName(PKG)
                .build();
        emulator.getSyscallHandler().setVerbose(false);
        emulator.getSyscallHandler().addIOResolver(this);
        java.util.Map<String, Integer> inode = new java.util.HashMap<>();
        inode.put("/data/user/0/com.phoenix.read", 655781);
        inode.put("/data/user/0/com.phoenix.read/files", 655864);
        emulator.set("inode", inode);
        emulator.set("uid", 10174);

        memory = emulator.getMemory();
        memory.setLibraryResolver(new AndroidResolver(23));

        vm = emulator.createDalvikVM();
        vm.setJni(this);
        vm.setVerbose(true);
        new AndroidModule(emulator, vm).register(memory);
        new JniGraphics(emulator, vm).register(memory);

        if (soCpp != null && soCpp.exists()) vm.loadLibrary(soCpp, false);

        // 类链(番茄海外:m ← a4$a ← MS);红果若不同,FindClass 日志会暴露真实名
        DvmClass m = vm.resolveClass("ms/bd/c/m");
        DvmClass a4a = vm.resolveClass("ms/bd/c/a4$a", m);
        vm.resolveClass("com/bytedance/mobsec/metasec/ml/MS", a4a);

        DalvikModule dm = vm.loadLibrary(soMeta, true);
        module = dm.getModule();
        dm.callJNI_OnLoad(emulator);
        System.out.println("[*] JNI_OnLoad 完成 base=0x" + Long.toHexString(module.base));
        if (System.getProperty("noinit") == null) driveInit();
        else System.out.println("[*] 跳过 driveInit (noinit), 让 sign 惰性初始化(仿 FqTrace)");
    }

    /** 调分发器 a(IIJLString;Object) 驱动 SDK init(op1=0x4000001 + JSON config 含 license)。 */
    private void dispatch(int op1, int op2, long lv, String s, DvmObject<?> obj) {
        DvmClass m = vm.resolveClass("ms/bd/c/m");
        DvmObject<?> sObj = s == null ? null : new StringObject(vm, s);
        m.callStaticJniMethodObject(emulator,
                "a(IIJLjava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;",
                op1, op2, lv, sObj, obj);
    }

    private void driveInit() {
        try {
            File cfgFile = new File("../capture/cronet/init_config.json");
            if (!cfgFile.exists()) { System.out.println("[!] 缺 init_config.json, 跳过 init"); return; }
            String cfg = new String(Files.readAllBytes(cfgFile.toPath()), StandardCharsets.UTF_8).trim();
            System.out.println("[*] 驱动 SDK init (op 0x4000001, license len=" + cfg.length() + ")...");
            DvmClass m = vm.resolveClass("ms/bd/c/m");
            DvmObject<?> ret = m.callStaticJniMethodObject(emulator,
                    "a(IIJLjava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;",
                    0x4000001, 0, 0L, new StringObject(vm, cfg), null);
            System.out.println("[*] SDK init 返回 = " + (ret == null ? "null" : ret.getValue()));
        } catch (Throwable t) {
            System.out.println("[!] init 异常: " + t);
            t.printStackTrace(System.out);
        }
    }

    private long tick = 0x2d641eee02cfL;   // ns 单调 tick(递增即可)
    private int counter = 0x3a75b16;

    public String sign(String url, String header) {
        // 6 参数调用约定(动态逆出):x2=0x18, x4=0xffffffffffffff 为常量; x3 tick / x5 counter 递增。
        Number n = module.callFunction(emulator, SIGN_OFFSET,
                url, header, 0x18, tick, 0xffffffffffffffL, counter);
        tick += 0x100000; counter++;
        if (n == null) return null;
        UnidbgPointer p = memory.pointer(n.longValue());
        return p == null ? null : p.getString(0);
    }

    private DvmObject<?> handleMS(BaseVM vm, int op) {
        System.out.println("  [MS.b op=" + op + " 0x" + Integer.toHexString(op) + "]");
        switch (op) {
            case 65539:    return new StringObject(vm, FILES + "/.msdata");
            case 33554433:
            case 33554434: return DvmBoolean.valueOf(vm, true);
            case 16777232: return vm.resolveClass("java/lang/Integer").newObject(72532); // 红果 versionCode(7.2.5.32)
            case 16777233: return new StringObject(vm, VER);
            case 16777218:
                try {
                    if (certFile != null && certFile.exists())
                        return new ByteArray(vm, Files.readAllBytes(certFile.toPath()));
                } catch (Exception e) {}
                System.out.println("    [MS.b op=16777218 证书] 暂无,返回 null");
                return null;
            case 268435470: return vm.resolveClass("java/lang/Long").newObject(System.currentTimeMillis());
            default:
                System.out.println("    [MS.b 未处理 op=" + op + " 0x" + Integer.toHexString(op) + "]");
                return null;
        }
    }

    @Override
    public DvmObject<?> callStaticObjectMethodV(BaseVM vm, DvmClass c, String sig, VaList va) {
        if (sig.equals("com/bytedance/mobsec/metasec/ml/MS->b(IIJLjava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;"))
            return handleMS(vm, va.getIntArg(0));
        if (sig.equals("java/lang/Thread->currentThread()Ljava/lang/Thread;"))
            return vm.resolveClass("java/lang/Thread").newObject(Thread.currentThread());
        if (sig.equals("java/lang/Boolean->valueOf(Z)Ljava/lang/Boolean;"))
            return DvmBoolean.valueOf(vm, va.getIntArg(0) != 0);
        if (sig.equals("java/lang/Integer->valueOf(I)Ljava/lang/Integer;"))
            return vm.resolveClass("java/lang/Integer").newObject(va.getIntArg(0));
        if (sig.equals("java/lang/Long->valueOf(J)Ljava/lang/Long;"))
            return vm.resolveClass("java/lang/Long").newObject(va.getLongArg(0));
        return super.callStaticObjectMethodV(vm, c, sig, va);
    }

    @Override
    public DvmObject<?> callObjectMethodV(BaseVM vm, DvmObject<?> o, String sig, VaList va) {
        switch (sig) {
            case "java/lang/Thread->getStackTrace()[Ljava/lang/StackTraceElement;": {
                StackTraceElement[] es = Thread.currentThread().getStackTrace();
                DvmObject[] a = new DvmObject[es.length];
                for (int i = 0; i < es.length; i++) a[i] = vm.resolveClass("java/lang/StackTraceElement").newObject(es[i]);
                return new ArrayObject(a);
            }
            case "java/lang/StackTraceElement->getClassName()Ljava/lang/String;":
                return new StringObject(vm, ((StackTraceElement) o.getValue()).getClassName());
            case "java/lang/StackTraceElement->getMethodName()Ljava/lang/String;":
                return new StringObject(vm, ((StackTraceElement) o.getValue()).getMethodName());
            case "java/lang/Thread->getBytes(Ljava/lang/String;)[B":
                return new ByteArray(vm, ((String) va.getObjectArg(0).getValue()).getBytes(StandardCharsets.UTF_8));
        }
        return super.callObjectMethodV(vm, o, sig, va);
    }

    @Override
    public long callLongMethodV(BaseVM vm, DvmObject<?> o, String sig, VaList va) {
        if ("java/lang/Long->longValue()J".equals(sig) && o.getValue() instanceof Long) return (Long) o.getValue();
        return super.callLongMethodV(vm, o, sig, va);
    }

    @Override
    public int callIntMethodV(BaseVM vm, DvmObject<?> o, String sig, VaList va) {
        if ("java/lang/Integer->intValue()I".equals(sig) && o.getValue() instanceof Integer) return (Integer) o.getValue();
        return super.callIntMethodV(vm, o, sig, va);
    }

    @Override
    public boolean callBooleanMethodV(BaseVM vm, DvmObject<?> o, String sig, VaList va) {
        if ("java/lang/Boolean->booleanValue()Z".equals(sig) && o.getValue() instanceof Boolean) return (Boolean) o.getValue();
        return super.callBooleanMethodV(vm, o, sig, va);
    }

    @Override
    public int getStaticIntField(BaseVM vm, DvmClass c, String sig) {
        if ("com/bytedance/mobsec/metasec/ml/MS->a()V".equals(sig)) return 0x40;
        return super.getStaticIntField(vm, c, sig);
    }

    @Override
    public void callVoidMethod(BaseVM vm, DvmObject<?> o, String sig, VarArg va) {
        if ("com/bytedance/mobsec/metasec/ml/MS->a()V".equals(sig)) return;
        super.callVoidMethod(vm, o, sig, va);
    }

    static final String FILESDIR = "/data/user/0/com.phoenix.read/files";
    static final File MSROOT = new File("../capture/msstate"); // 含 .msdata/ 真身(从设备拉取)

    @Override
    public FileResult resolve(Emulator emu, String pathname, int oflags) {
        if (pathname.contains("libmetasec_ml.so"))
            return FileResult.success(new SimpleFileIO(oflags, soMeta, pathname));
        if (pathname.startsWith(FILESDIR) || pathname.contains(".ms") || pathname.contains("msdata"))
            System.out.println("  [resolve] " + pathname + " oflags=0x" + Integer.toHexString(oflags));
        // 映射 metasec 状态目录: /data/.../files/... -> ../capture/msstate/...
        if (pathname.startsWith(FILESDIR)) {
            String rel = pathname.substring(FILESDIR.length());
            File local = new File(MSROOT, rel);
            if (local.isDirectory())
                return FileResult.success(new com.github.unidbg.linux.file.DirectoryFileIO(oflags, pathname, local));
            if (local.exists())
                return FileResult.success(new SimpleFileIO(oflags, local, pathname));
            // 不存在: 写/创建(O_CREAT=0x40) 才建文件让 metasec 写新态; 纯读/access 返回未找到
            if ((oflags & 0x40) != 0) {
                local.getParentFile().mkdirs();
                try { local.createNewFile(); } catch (Exception e) {}
                return FileResult.success(new SimpleFileIO(oflags, local, pathname));
            }
            return null;
        }
        return null;
    }

    public static void main(String[] args) {
        File meta = new File("../capture/so/libmetasec_ml.so");
        File cpp = new File("../capture/so/libc++_shared.so");
        File cert = new File("../capture/ms_cert/ms_16777218.bin"); // 红果证书(待提取)
        if (!meta.exists()) { System.err.println("缺 libmetasec_ml.so"); return; }
        try {
            MetasecSign s = new MetasecSign(meta, cpp.exists()?cpp:null, cert.exists()?cert:null);
            // 简单 url+header 先看能否出 X-Argus(验证 offset+调用约定在 unidbg 成立)
            String url = "https://api5-normal-sinfonlinea.fqnovel.com/reading/bookapi/search/tab/v?aid=8662&device_id=1325332544628567&iid=1325332544632663&version_code=72232&query=test";
            String header = "x-ss-req-ticket\r\n1782800542209\r\ncontent-type\r\napplication/json; charset=utf-8\r\nx-ss-stub\r\n";
            System.out.println("[*] 试签名 (offset 0x" + Long.toHexString(SIGN_OFFSET) + ")...");
            String sig = s.sign(url, header);
            System.out.println("===SIG_START===");
            System.out.println(sig);
            System.out.println("===SIG_END===");
        } catch (Throwable t) { System.out.println("[!] 卡点:"); t.printStackTrace(System.out); }
    }
}
