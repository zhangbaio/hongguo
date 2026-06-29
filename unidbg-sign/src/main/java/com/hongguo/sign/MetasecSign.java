package com.hongguo.sign;

import com.github.unidbg.AndroidEmulator;
import com.github.unidbg.Module;
import com.github.unidbg.linux.android.AndroidEmulatorBuilder;
import com.github.unidbg.linux.android.AndroidResolver;
import com.github.unidbg.linux.android.dvm.*;
import com.github.unidbg.linux.android.dvm.array.ArrayObject;
import com.github.unidbg.linux.android.dvm.wrapper.DvmBoolean;
import com.github.unidbg.memory.Memory;

import java.io.File;

/**
 * 红果(com.phoenix.read, aid=8662) metasec 脱机签名 —— 仿 dy233_unidbg_sign 范本适配。
 * 关键:① 真实类链 ms/bd/c/k ← a0 ← MS;② createDalvikVM 带 base.apk;③ 回调喂红果真值。
 * 里程碑④:先让 JNI_OnLoad + init 在带 apk/真类链下尽量往前,记录 MS.b 各 opcode。
 */
public class MetasecSign extends AbstractJni {

    static final String PKG = "com.phoenix.read";
    static final String VER = "7.2.2.32";
    static final String FILES_DIR = "/data/user/0/com.phoenix.read/files";

    private final AndroidEmulator emulator;
    private final VM vm;
    private final Module module;
    private final Memory memory;

    public MetasecSign(File apk, File so) {
        emulator = AndroidEmulatorBuilder.for64Bit()
                .setProcessName(PKG)
                .build();
        emulator.getSyscallHandler().setVerbose(false);
        memory = emulator.getMemory();
        memory.setLibraryResolver(new AndroidResolver(23));
        memory.setCallInitFunction(true);

        vm = (apk != null && apk.exists()) ? emulator.createDalvikVM(apk) : emulator.createDalvikVM();
        vm.setJni(this);
        vm.setVerbose(true);

        // 真实类链(范本:k ← a0 ← MS)
        DvmClass k = vm.resolveClass("ms/bd/c/k");
        DvmClass a0 = vm.resolveClass("ms/bd/c/a0", k);
        vm.resolveClass("com/bytedance/mobsec/metasec/ml/MS", a0);

        DalvikModule dm = vm.loadLibrary(so, true);   // true → 调 JNI_OnLoad
        module = dm.getModule();
        System.out.println("[*] loaded base=0x" + Long.toHexString(module.base) + " JNI_OnLoad 完成");
    }

    // native→Java 实例方法回调(反调试:伪造调用栈)
    @Override
    public DvmObject<?> callObjectMethodV(BaseVM vm, DvmObject<?> dvmObject, String signature, VaList vaList) {
        switch (signature) {
            case "java/lang/Thread->getStackTrace()[Ljava/lang/StackTraceElement;":
                return new ArrayObject(
                        vm.resolveClass("java/lang/StackTraceElement").newObject("dalvik.system.VMStack"),
                        vm.resolveClass("java/lang/StackTraceElement").newObject("java.lang.Thread"));
        }
        System.out.println("    [callObjectMethodV] " + signature);
        return super.callObjectMethodV(vm, dvmObject, signature, vaList);
    }

    // metasec 的 native→Java 分发器 MS.b + 其它静态回调
    @Override
    public DvmObject<?> callStaticObjectMethodV(BaseVM vm, DvmClass dvmClass, String signature, VaList vaList) {
        if (signature.startsWith("com/bytedance/mobsec/metasec/ml/MS->b(")) {
            int op = vaList.getIntArg(0);
            switch (op) {
                // 范本 dy233 的 op(版本不同可能不命中,留作参考)
                case 65539:      return new StringObject(vm, FILES_DIR + "/;o@Y0f");
                case 33554433:   return DvmBoolean.valueOf(vm, Boolean.TRUE);
                case 33554434:   return DvmBoolean.valueOf(vm, Boolean.TRUE);
                case 16777233:   return new StringObject(vm, VER);
                default:
                    System.out.println("    [MS.b] 未知 op=" + op + " (0x" + Integer.toHexString(op) + ") → 暂返回 null");
                    return null;
            }
        }
        switch (signature) {
            case "java/lang/Thread->currentThread()Ljava/lang/Thread;":
                return vm.resolveClass("java/lang/Thread").newObject(Thread.currentThread());
        }
        System.out.println("    [callStaticObjectMethodV] " + signature);
        return super.callStaticObjectMethodV(vm, dvmClass, signature, vaList);
    }

    @Override
    public void callStaticVoidMethodV(BaseVM vm, DvmClass dvmClass, String signature, VaList vaList) {
        if (signature.equals("com/bytedance/mobsec/metasec/ml/MS->a()V")) return;
        System.out.println("    [callStaticVoidMethodV] " + signature);
        super.callStaticVoidMethodV(vm, dvmClass, signature, vaList);
    }

    public static void main(String[] args) {
        File apk = new File(args.length > 0 ? args[0] : "/Users/zhangbiao/Documents/编程/ai/claude/hongguo-mac/base.apk");
        File so = new File(args.length > 1 ? args[1] : "../capture/so/libmetasec_ml.so");
        if (!so.exists()) { System.err.println("找不到 so: " + so.getAbsolutePath()); return; }
        System.out.println("[*] apk=" + (apk.exists() ? apk.getName() : "(无,用空VM)") + " so=" + so.getName());
        try {
            new MetasecSign(apk.exists() ? apk : null, so);
            System.out.println("[*] 里程碑④:JNI_OnLoad/init 在真类链下跑通(看上面 MS.b opcode)");
        } catch (Throwable t) {
            System.out.println("[!] 卡点:"); t.printStackTrace(System.out);
        }
    }
}
