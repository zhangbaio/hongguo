package com.hongguo.sign;

import com.github.unidbg.AndroidEmulator;
import com.github.unidbg.Emulator;
import com.github.unidbg.Module;
import com.github.unidbg.Symbol;
import com.github.unidbg.file.FileResult;
import com.github.unidbg.file.IOResolver;
import com.github.unidbg.file.linux.AndroidFileIO;
import com.github.unidbg.linux.android.AndroidEmulatorBuilder;
import com.github.unidbg.linux.android.AndroidResolver;
import com.github.unidbg.linux.android.dvm.AbstractJni;
import com.github.unidbg.linux.android.dvm.DalvikModule;
import com.github.unidbg.linux.android.dvm.VM;
import com.github.unidbg.memory.Memory;

import java.io.File;

/**
 * 里程碑②:摸清 JNI_OnLoad 为何不注册 native——
 *  - 手动调 JNI_OnLoad 并打印返回值(0x10006=JNI_VERSION_1_6 正常;否则=bail/反模拟器)
 *  - 记录 metasec 在 init 期探测了哪些文件/路径(/proc/self/* /system/* 等反模拟器指纹)
 */
public class MetasecSign extends AbstractJni implements IOResolver<AndroidFileIO> {

    private final AndroidEmulator emulator;
    private final VM vm;
    private final Module module;

    public MetasecSign(File soFile) {
        emulator = AndroidEmulatorBuilder.for64Bit()
                .setProcessName("com.phoenix.read")
                .build();
        Memory memory = emulator.getMemory();
        memory.setLibraryResolver(new AndroidResolver(23));

        emulator.getSyscallHandler().addIOResolver(this);   // 记录文件探测(反模拟器指纹)

        vm = emulator.createDalvikVM();
        vm.setVerbose(true);
        vm.setJni(this);

        System.out.println("[*] loading " + soFile.getName());
        DalvikModule dm = vm.loadLibrary(soFile, false);    // false: 手动调 JNI_OnLoad 以拿返回值
        module = dm.getModule();
        System.out.println("[*] loaded base=0x" + Long.toHexString(module.base) + ", 手动调 JNI_OnLoad...");

        // 预注册 metasec 会 FindClass/GetSuperClass 的类,显式给 Object 父类(过掉 GetSuperClass 异常)
        com.github.unidbg.linux.android.dvm.DvmClass object = vm.resolveClass("java/lang/Object");
        vm.resolveClass("com/bytedance/mobsec/metasec/ml/MS", object);

        Symbol onLoad = module.findSymbolByName("JNI_OnLoad", false);
        Number ret = onLoad.call(emulator, vm.getJavaVM(), 0);
        int v = ret.intValue();
        System.out.printf("[*] JNI_OnLoad 返回 = 0x%x  (0x10006=JNI_VERSION_1_6 正常; 其它=异常/bail)%n", v);
        if (v != 0x10006) {
            System.out.println("[!] 非正常版本 → metasec 很可能在 JNI_OnLoad 检测到环境异常提前返回(反模拟器/反调试)");
        } else {
            System.out.println("[*] JNI_OnLoad 返回正常版本号 → 若上面无 RegisterNatives,则 native 为惰性注册(首次调用时)");
        }
    }

    // 记录所有文件访问(反模拟器探测点);返回 null = 交回 unidbg 默认处理
    @Override
    public FileResult<AndroidFileIO> resolve(Emulator<AndroidFileIO> emu, String pathname, int oflags) {
        System.out.println("    [open] " + pathname);
        return null;
    }

    public static void main(String[] args) {
        File so = new File(args.length > 0 ? args[0] : "../capture/so/libmetasec_ml.so");
        if (!so.exists()) { System.err.println("找不到 so: " + so.getAbsolutePath()); return; }
        try {
            new MetasecSign(so);
            System.out.println("[*] 里程碑② 观测完成");
        } catch (Throwable t) {
            System.out.println("[!] 卡点:");
            t.printStackTrace(System.out);
        }
    }
}
