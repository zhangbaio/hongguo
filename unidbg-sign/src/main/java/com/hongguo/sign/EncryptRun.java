package com.hongguo.sign;

import com.github.unidbg.AndroidEmulator;
import com.github.unidbg.linux.android.AndroidEmulatorBuilder;
import com.github.unidbg.linux.android.AndroidResolver;
import com.github.unidbg.linux.android.dvm.*;
import com.github.unidbg.linux.android.dvm.array.ByteArray;
import com.github.unidbg.memory.Memory;
import com.github.unidbg.virtualmodule.android.AndroidModule;
import com.github.unidbg.virtualmodule.android.JniGraphics;

import java.io.File;
import java.util.Base64;

/**
 * unidbg 离线调用 libEncryptor.so 的 ttEncrypt —— 为 device_register 加密 body(tt_data=a)。
 * 不逆算法, 直接跑库。类 com/bytedance/frameworks/encryptor/EncryptorUtil, 方法 ttEncrypt([BI)[B。
 * 用法: serve <port> 常驻; 或 <base64明文> 单次 → 输出 base64 密文。
 */
public class EncryptRun extends AbstractJni {
    static final String CLS = "com/bytedance/frameworks/encryptor/EncryptorUtil";
    static final File SO = new File("../capture/so/libEncryptor.so");

    private final AndroidEmulator emulator;
    private final VM vm;
    private final DvmClass clazz;

    public EncryptRun() {
        emulator = AndroidEmulatorBuilder.for64Bit().setProcessName("com.phoenix.read").build();
        emulator.getSyscallHandler().setVerbose(false);
        Memory memory = emulator.getMemory();
        memory.setLibraryResolver(new AndroidResolver(23));
        vm = emulator.createDalvikVM();
        vm.setJni(this);
        vm.setVerbose(false);
        new AndroidModule(emulator, vm).register(memory);
        new JniGraphics(emulator, vm).register(memory);
        clazz = vm.resolveClass(CLS);
        DalvikModule dm = vm.loadLibrary(SO, true);
        dm.callJNI_OnLoad(emulator);
        System.out.println("[*] libEncryptor init 完成 base=0x" + Long.toHexString(dm.getModule().base));
    }

    /** 明文 → 密文(tt_data body)。 */
    public synchronized byte[] encrypt(byte[] plain) {
        DvmObject<?> ret = clazz.callStaticJniMethodObject(
                emulator, "ttEncrypt([BI)[B", new ByteArray(vm, plain), plain.length);
        return ret == null ? null : (byte[]) ret.getValue();
    }

    public static void main(String[] args) throws Exception {
        EncryptRun e = new EncryptRun();
        if (args.length >= 1 && args[0].equals("serve")) {
            int port = args.length >= 2 ? Integer.parseInt(args[1]) : 9100;
            com.sun.net.httpserver.HttpServer srv =
                    com.sun.net.httpserver.HttpServer.create(new java.net.InetSocketAddress(port), 0);
            srv.createContext("/encrypt", ex -> {
                byte[] resp;
                try {
                    java.io.ByteArrayOutputStream bo = new java.io.ByteArrayOutputStream();
                    byte[] buf = new byte[4096]; int n;
                    while ((n = ex.getRequestBody().read(buf)) > 0) bo.write(buf, 0, n);
                    byte[] cipher = e.encrypt(bo.toByteArray());  // 请求体=明文, 返回=密文
                    resp = cipher == null ? new byte[0] : cipher;
                } catch (Throwable t) { resp = ("ERR:" + t.getMessage()).getBytes(); }
                ex.getResponseHeaders().add("Content-Type", "application/octet-stream");
                ex.sendResponseHeaders(200, resp.length);
                ex.getResponseBody().write(resp);
                ex.close();
            });
            srv.setExecutor(null);
            srv.start();
            System.out.println("[*] unidbg 加密服务: http://127.0.0.1:" + port + "/encrypt (POST 明文→密文)");
            Thread.currentThread().join();
            return;
        }
        // 单次: args[0]=base64 明文 → base64 密文
        byte[] plain = args.length >= 1 ? Base64.getDecoder().decode(args[0])
                : "{\"test\":1}".getBytes();
        byte[] c = e.encrypt(plain);
        System.out.println("===CIPHER_B64===");
        System.out.println(c == null ? "null" : Base64.getEncoder().encodeToString(c));
        System.out.println("===END===");
        if (c != null) {
            StringBuilder h = new StringBuilder();
            for (int i = 0; i < Math.min(8, c.length); i++) h.append(String.format("%02x ", c[i] & 0xff));
            System.out.println("magic: " + h);
        }
    }
}
