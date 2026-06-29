package com.hongguo.sign;

import com.github.unidbg.AndroidEmulator;
import com.github.unidbg.Module;
import com.github.unidbg.linux.android.AndroidEmulatorBuilder;
import com.github.unidbg.linux.android.AndroidResolver;
import com.github.unidbg.linux.android.dvm.AbstractJni;
import com.github.unidbg.linux.android.dvm.DalvikModule;
import com.github.unidbg.linux.android.dvm.VM;
import com.github.unidbg.memory.Memory;

import java.io.File;

/**
 * unidbg 加载 libmetasec_ml.so —— 里程碑①:跑通 JNI_OnLoad,观察 RegisterNatives 注册了哪些
 * (类名/方法名/签名),以及第一处卡点(缺失 JNI 回调 / 反模拟器检查 / 系统调用)。
 *
 * 红果(fqnovel)签名脱机化的第一步。后续:补齐 JNI 回调让 env 检查通过 → 定位签名函数 → 调用产出 X-Argus 等。
 */
public class MetasecSign extends AbstractJni {

    private final AndroidEmulator emulator;
    private final VM vm;
    private final Module module;

    public MetasecSign(File soFile) {
        // arm64 模拟器,进程名伪装成红果
        emulator = AndroidEmulatorBuilder.for64Bit()
                .setProcessName("com.phoenix.read")
                .build();
        Memory memory = emulator.getMemory();
        memory.setLibraryResolver(new AndroidResolver(23)); // 模拟 Android 6 的系统库

        vm = emulator.createDalvikVM();      // 暂不加载 apk(后续如需类解析再加)
        vm.setVerbose(true);                  // 打印 JNI 调用 / RegisterNatives
        vm.setJni(this);                      // env 回调到本类

        System.out.println("[*] loading " + soFile.getAbsolutePath());
        DalvikModule dm = vm.loadLibrary(soFile, true);  // true = 调用 JNI_OnLoad → 触发 RegisterNatives
        module = dm.getModule();
        System.out.println("[*] loaded base=0x" + Long.toHexString(module.base) + " JNI_OnLoad done");
    }

    public static void main(String[] args) {
        File so = new File(args.length > 0 ? args[0] : "../capture/so/libmetasec_ml.so");
        if (!so.exists()) {
            System.err.println("找不到 so: " + so.getAbsolutePath());
            return;
        }
        try {
            new MetasecSign(so);
            System.out.println("[*] 里程碑① 通过:JNI_OnLoad 跑完(看上面 RegisterNatives 输出)");
        } catch (Throwable t) {
            System.out.println("[!] 卡点(预期内,逐步补):");
            t.printStackTrace(System.out);
        }
    }
}
