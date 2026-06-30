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
 * 番茄海外(com.dragon.read.oversea.gp 6.8.1.32)metasec 签名 —— 已知 offset 0x168c80。
 * 目的:在本 unidbg 环境验证能出真签名(验证 harness),并支持 trace 抓 .rodata 算法表地址。
 */
public class FqTrace extends AbstractJni implements IOResolver<AndroidFileIO> {
    static final String PKG = "com.dragon.read.oversea.gp";
    static final String FILES = "/data/user/0/com.dragon.read.oversea.gp/files";
    static final long SIGN = 0x168c80;
    static final String DIR = "../capture/fq_oversea/";

    private final AndroidEmulator emulator;
    private final VM vm;
    private final Module module;
    private final Memory memory;
    private final File soMeta = new File(DIR + "libmetasec_ml.so");
    private final File cert = new File(DIR + "ms_16777218.bin");

    public FqTrace() {
        emulator = AndroidEmulatorBuilder.for64Bit()
                .addBackendFactory(new com.github.unidbg.arm.backend.Unicorn2Factory(true))  // Unicorn2: Linux x64 自洽 native
                .setProcessName(PKG).build();
        emulator.getSyscallHandler().setVerbose(false);
        emulator.getSyscallHandler().addIOResolver(this);
        java.util.Map<String, Integer> inode = new java.util.HashMap<>();
        inode.put("/data/user/0/com.dragon.read.oversea.gp", 655781);
        inode.put("/data/user/0/com.dragon.read.oversea.gp/files", 655864);
        emulator.set("inode", inode);
        emulator.set("uid", 10074);
        memory = emulator.getMemory();
        memory.setLibraryResolver(new AndroidResolver(23));
        vm = emulator.createDalvikVM();
        vm.setJni(this);
        vm.setVerbose(false);
        new AndroidModule(emulator, vm).register(memory);
        new JniGraphics(emulator, vm).register(memory);
        File cpp = new File(DIR + "libc++_shared.so");
        if (cpp.exists()) vm.loadLibrary(cpp, false);
        DvmClass m = vm.resolveClass("ms/bd/c/m");
        DvmClass a4a = vm.resolveClass("ms/bd/c/a4$a", m);
        vm.resolveClass("com/bytedance/mobsec/metasec/ml/MS", a4a);
        DalvikModule dm = vm.loadLibrary(soMeta, true);
        module = dm.getModule();
        dm.callJNI_OnLoad(emulator);
        System.out.println("[*] 番茄海外 init 完成 base=0x" + Long.toHexString(module.base));
    }

    static final java.util.Map<Long, Integer> READS = new java.util.HashMap<>();
    private long modBase, modSize;

    private void enableReadTrace() {
        modBase = module.base; modSize = module.size;
        emulator.getBackend().hook_add_new(new com.github.unidbg.arm.backend.ReadHook() {
            public void hook(com.github.unidbg.arm.backend.Backend b, long addr, int size, Object u) {
                if (addr >= modBase && addr < modBase + modSize) READS.merge(addr, 1, Integer::sum);
            }
            public void onAttach(com.github.unidbg.arm.backend.UnHook unHook) {}
            public void detach() {}
        }, modBase, modBase + modSize, null);
    }

    public String sign(String url, String header) {
        Number n = module.callFunction(emulator, SIGN, url, header);
        if (n == null) return null;
        UnidbgPointer p = memory.pointer(n.longValue());
        return p == null ? null : p.getString(0);
    }

    public void reportHotReads(int topN) {
        // 按读取次数排序,打印 libmetasec 内部(.rodata)最热地址 = 算法表
        java.util.List<java.util.Map.Entry<Long, Integer>> es = new java.util.ArrayList<>(READS.entrySet());
        es.sort((a, b) -> b.getValue() - a.getValue());
        System.out.println("[*] 热读地址 top" + topN + "(off=相对libmetasec, cnt=次数):");
        for (int i = 0; i < Math.min(topN, es.size()); i++)
            System.out.printf("    +0x%-8x cnt=%d%n", es.get(i).getKey() - modBase, es.get(i).getValue());
        // 找连续簇(表):按 off 排序,输出读>=20次的地址的 off 范围
        es.sort(java.util.Map.Entry.comparingByKey());
        long start = -1, prev = -1; int cnt = 0;
        System.out.println("[*] 热读连续区(疑似表, off 范围):");
        for (java.util.Map.Entry<Long, Integer> e : es) {
            if (e.getValue() < 10) continue;
            long off = e.getKey() - modBase;
            if (start < 0) { start = off; prev = off; cnt = 1; }
            else if (off - prev <= 64) { prev = off; cnt++; }
            else { if (cnt >= 4) System.out.printf("    +0x%x .. +0x%x (%d点)%n", start, prev, cnt); start = off; prev = off; cnt = 1; }
        }
        if (cnt >= 4) System.out.printf("    +0x%x .. +0x%x (%d点)%n", start, prev, cnt);
    }

    private DvmObject<?> handleMS(BaseVM vm, int op) {
        switch (op) {
            case 65539: return new StringObject(vm, FILES + "/.msdata");
            case 33554433: case 33554434: return DvmBoolean.valueOf(vm, true);
            case 16777232: return vm.resolveClass("java/lang/Integer").newObject(68132);
            case 16777233: return new StringObject(vm, "6.8.1.32");
            case 16777218:
                try { if (cert.exists()) return new ByteArray(vm, Files.readAllBytes(cert.toPath())); } catch (Exception e) {}
                return null;
            case 268435470: return vm.resolveClass("java/lang/Long").newObject(System.currentTimeMillis());
            default: return null;
        }
    }

    @Override public DvmObject<?> callStaticObjectMethodV(BaseVM vm, DvmClass c, String s, VaList va) {
        if (s.startsWith("com/bytedance/mobsec/metasec/ml/MS->b(")) return handleMS(vm, va.getIntArg(0));
        if (s.equals("java/lang/Thread->currentThread()Ljava/lang/Thread;"))
            return vm.resolveClass("java/lang/Thread").newObject(Thread.currentThread());
        return super.callStaticObjectMethodV(vm, c, s, va);
    }
    @Override public DvmObject<?> callObjectMethodV(BaseVM vm, DvmObject<?> o, String s, VaList va) {
        switch (s) {
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
        return super.callObjectMethodV(vm, o, s, va);
    }
    @Override public long callLongMethodV(BaseVM vm, DvmObject<?> o, String s, VaList va) {
        if ("java/lang/Long->longValue()J".equals(s) && o.getValue() instanceof Long) return (Long) o.getValue();
        return super.callLongMethodV(vm, o, s, va);
    }
    @Override public int callIntMethodV(BaseVM vm, DvmObject<?> o, String s, VaList va) {
        if ("java/lang/Integer->intValue()I".equals(s) && o.getValue() instanceof Integer) return (Integer) o.getValue();
        return super.callIntMethodV(vm, o, s, va);
    }
    @Override public boolean callBooleanMethodV(BaseVM vm, DvmObject<?> o, String s, VaList va) {
        if ("java/lang/Boolean->booleanValue()Z".equals(s) && o.getValue() instanceof Boolean) return (Boolean) o.getValue();
        return super.callBooleanMethodV(vm, o, s, va);
    }
    @Override public int getStaticIntField(BaseVM vm, DvmClass c, String s) {
        if ("com/bytedance/mobsec/metasec/ml/MS->a()V".equals(s)) return 0x40;
        return super.getStaticIntField(vm, c, s);
    }
    @Override public void callVoidMethod(BaseVM vm, DvmObject<?> o, String s, VarArg va) {
        if ("com/bytedance/mobsec/metasec/ml/MS->a()V".equals(s)) return;
        super.callVoidMethod(vm, o, s, va);
    }
    @Override public FileResult resolve(Emulator emu, String pathname, int oflags) {
        if (pathname.contains("libmetasec_ml.so"))
            return FileResult.success(new SimpleFileIO(oflags, soMeta, pathname));
        return null;
    }

    /** 把 sign() 的 "X-Argus\nval\nX-Gorgon\nval..." 解析成有序 Map(给 HTTP/JSON 用)。 */
    public java.util.Map<String, String> signMap(String url, String header) {
        java.util.LinkedHashMap<String, String> m = new java.util.LinkedHashMap<>();
        String sig = sign(url, header);
        if (sig == null) return m;
        String[] lines = sig.split("\n");
        for (int i = 0; i + 1 < lines.length; i += 2)
            if (lines[i].startsWith("X-")) m.put(lines[i].trim(), lines[i + 1].trim());
        return m;
    }

    /** 常驻签名服务:POST /sign {"url":..,"headers":{..}} → {"X-Argus":..}。协议同原 frida 签名服务。
     *  单模拟器单线程(unidbg 同 JVM 多模拟器并发会出空签名,故一进程一模拟器、签名加锁)。
     *  HTTP 用线程池并发收连接;真并发签名靠多进程(多端口)+ hongguo.py 的 SIGN_SERVER 轮询。 */
    /** 常驻签名服务。unidbg 模拟器绑"创建它的那个线程",故由专用签名线程自己创建模拟器并串行处理所有签名;
     *  HTTP 用线程池并发收连接(解决 setExecutor(null) 并发连接挤队列拖慢),各连接入队后阻塞等结果。 */
    static void serveStatic(int port) throws Exception {
        final java.util.concurrent.BlockingQueue<Object[]> queue = new java.util.concurrent.LinkedBlockingQueue<>();
        Thread signer = new Thread(() -> {
            FqTrace t = new FqTrace();                    // 模拟器在本线程创建 = 后续都在本线程用
            System.out.println("[*] 签名工作线程就绪(模拟器本线程持有)");
            while (true) {
                Object[] task;
                try { task = queue.take(); } catch (InterruptedException ie) { return; }
                @SuppressWarnings("unchecked")
                java.util.concurrent.CompletableFuture<java.util.Map<String, String>> fut =
                        (java.util.concurrent.CompletableFuture<java.util.Map<String, String>>) task[2];
                try { fut.complete(t.signMap((String) task[0], (String) task[1])); }
                catch (Throwable e) { fut.completeExceptionally(e); }
            }
        }, "fqtrace-signer");
        signer.setDaemon(true);
        signer.start();
        String bindHost = System.getenv().getOrDefault("BIND_HOST", "127.0.0.1");
        com.sun.net.httpserver.HttpServer srv = com.sun.net.httpserver.HttpServer.create(new java.net.InetSocketAddress(bindHost, port), 0);
        srv.createContext("/sign", ex -> {
            byte[] resp;
            try {
                byte[] in = readAll(ex.getRequestBody());
                com.alibaba.fastjson.JSONObject req = com.alibaba.fastjson.JSON.parseObject(new String(in, StandardCharsets.UTF_8));
                String url = req.getString("url");
                com.alibaba.fastjson.JSONObject hs = req.getJSONObject("headers");
                StringBuilder hb = new StringBuilder();
                if (hs != null) for (String k : hs.keySet()) {
                    if (hb.length() > 0) hb.append("\r\n");
                    hb.append(k).append("\r\n").append(hs.getString(k));
                }
                java.util.concurrent.CompletableFuture<java.util.Map<String, String>> fut = new java.util.concurrent.CompletableFuture<>();
                queue.add(new Object[]{url, hb.toString(), fut});
                java.util.Map<String, String> sig = fut.get();   // 等签名线程串行处理
                resp = com.alibaba.fastjson.JSON.toJSONString(sig).getBytes(StandardCharsets.UTF_8);
            } catch (Throwable t) {
                resp = ("{\"error\":\"" + String.valueOf(t.getMessage()).replace('"', '\'') + "\"}").getBytes(StandardCharsets.UTF_8);
            }
            ex.getResponseHeaders().add("Content-Type", "application/json");
            ex.sendResponseHeaders(200, resp.length);
            ex.getResponseBody().write(resp);
            ex.close();
        });
        srv.setExecutor(java.util.concurrent.Executors.newFixedThreadPool(16));  // 并发收连接
        srv.start();
        System.out.println("[*] unidbg 离线签名服务已启动: " + bindHost + ":" + port + "/sign (Ctrl-C 停止)");
    }

    private static byte[] readAll(java.io.InputStream is) throws java.io.IOException {
        java.io.ByteArrayOutputStream bo = new java.io.ByteArrayOutputStream();
        byte[] buf = new byte[4096]; int n;
        while ((n = is.read(buf)) > 0) bo.write(buf, 0, n);
        return bo.toByteArray();
    }

    public static void main(String[] args) throws Exception {
        // 服务模式:serve [port] → 常驻 HTTP 签名服务(专用签名线程持有模拟器)
        if (args.length >= 1 && args[0].equals("serve")) {
            int port = args.length >= 2 ? Integer.parseInt(args[1]) : 9090;
            serveStatic(port);
            Thread.currentThread().join();
            return;
        }
        FqTrace t = new FqTrace();
        // 命令行模式:args[0]=url, args[1]=header(\r\n分隔 key/value) → 输出签名头(给红果API试签)
        if (args.length >= 1) {
            String url = args[0];
            String header = args.length >= 2 ? args[1].replace("\\r\\n", "\r\n") : "";
            String sig = t.sign(url, header);
            System.out.println("===SIG_START===");
            System.out.println(sig);
            System.out.println("===SIG_END===");
            return;
        }
        t.enableReadTrace();
        String url = "https://api5-normal-sinfonlinec.fqnovel.com/reading/bookapi/search/tab/v?aid=1967&device_id=4223674528607515&iid=4223674528611611&version_code=68132&query=test";
        String header = "x-ss-req-ticket\r\n1754299673613\r\ncontent-type\r\napplication/json";
        System.out.println("[*] 番茄海外 试签名(带读trace)...");
        String sig = t.sign(url, header);
        System.out.println("[*] 签名 X-Gorgon 行:" + (sig != null && sig.contains("X-Gorgon") ? "有" : "无"));
        t.reportHotReads(30);
    }
}
