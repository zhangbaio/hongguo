package com.ttnet.org.chromium.net.impl;

import android.content.Context;
import android.os.ConditionVariable;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.ugc.bytex.taskmonitor.proxy.HandlerDelegate;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.net.NetworkChangeNotifier;

@JNINamespace("cronet")
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class CronetLibraryLoader {
    private static final Object a;
    private static final String b;
    private static final HandlerThread c;
    private static volatile boolean d;
    private static volatile boolean e;
    private static final ConditionVariable f;

    interface b {
        void a();

        void b();

        String getCronetVersion();
    }

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            CronetLibraryLoader.c();
        }
    }

    static void a() {
        c.c().a();
    }

    private static boolean e() {
        if (c.getLooper() == Looper.myLooper()) {
            return true;
        }
        return false;
    }

    private static String getDefaultUserAgent() {
        return a0.d(com.ttnet.org.chromium.base.c.f());
    }

    private static void ensureInitializedFromNative() {
        synchronized (a) {
            d = true;
            f.open();
        }
        b(com.ttnet.org.chromium.base.c.f(), null);
    }

    static {
        Covode.recordClassIndex(654594);
        a = new Object();
        b = CronetLibraryLoader.class.getSimpleName();
        c = new HandlerThread("CronetInit");
        d = false;
        f = new ConditionVariable();
    }

    static void c() {
        if (e) {
            return;
        }
        u.c = System.nanoTime();
        NetworkChangeNotifier.init();
        NetworkChangeNotifier.o();
        f.block();
        c.c().b();
        e = true;
        u.d = System.nanoTime();
    }

    private static void setNetworkThreadPriorityOnNetworkThread(int i) {
        Process.setThreadPriority(i);
    }

    public static void f(Runnable runnable) {
        if (e()) {
            runnable.run();
        } else {
            new HandlerDelegate(c.getLooper()).post(runnable);
        }
    }

    private static void d(CronetEngineBuilderImpl cronetEngineBuilderImpl) {
        String str = cronetEngineBuilderImpl.D;
        if (!TextUtils.isEmpty(str)) {
            PolarisFileWrapper polarisFileWrapper = new PolarisFileWrapper(str);
            if (polarisFileWrapper.exists() && !polarisFileWrapper.isDirectory()) {
                com.ttnet.org.chromium.base.h.h(b, "cronet so load: %s", str);
                System.load(str);
                return;
            }
        }
        if (cronetEngineBuilderImpl.c0() != null) {
            cronetEngineBuilderImpl.c0().loadLibrary("sscronet");
        } else {
            System.loadLibrary("sscronet");
        }
    }

    public static void b(Context context, CronetEngineBuilderImpl cronetEngineBuilderImpl) {
        synchronized (a) {
            if (!e) {
                com.ttnet.org.chromium.base.c.g(context);
                HandlerThread handlerThread = c;
                if (!handlerThread.isAlive()) {
                    handlerThread.start();
                }
                f(new a());
            }
            if (!d) {
                u.a = System.nanoTime();
                d(cronetEngineBuilderImpl);
                u.b = System.nanoTime();
                String a2 = ImplVersion.a();
                if (cronetEngineBuilderImpl != null && cronetEngineBuilderImpl.K) {
                    if (!a2.equals("107.0.5273.2")) {
                        throw new RuntimeException(String.format("Expected Cronet version number %s, actual version number %s.", a2, "107.0.5273.2"));
                    }
                } else if (a2.equals(c.c().getCronetVersion())) {
                    com.ttnet.org.chromium.base.h.h(b, "Cronet version: %s, arch: %s", a2, System.getProperty("os.arch"));
                } else {
                    throw new RuntimeException(String.format("Expected Cronet version number %s, actual version number %s.", a2, c.c().getCronetVersion()));
                }
                d = true;
                f.open();
            }
        }
    }
}
