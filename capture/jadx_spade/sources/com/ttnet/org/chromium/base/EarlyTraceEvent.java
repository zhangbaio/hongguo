package com.ttnet.org.chromium.base;

import android.os.Process;
import android.os.SystemClock;
import com.bytedance.covode.number.Covode;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.MainDex;
import java.util.List;

@JNINamespace("base::android")
@MainDex
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class EarlyTraceEvent {
    static volatile int a;
    private static boolean b;
    static final Object c;
    static List<b> d;
    static List<a> e;

    static final class a {
        final boolean a;
        final String b;
        final long c;
        final long d;

        static {
            Covode.recordClassIndex(654188);
        }
    }

    interface c {
        void a(String str, long j, int i, long j2);

        void b(String str, long j, int i, long j2);

        void c(String str, long j, long j2);

        void d(String str, long j, int i, long j2);

        void e(String str, long j, long j2);

        void f(String str, long j, int i, long j2);
    }

    public static boolean getBackgroundStartupTracingFlag() {
        return b;
    }

    static boolean e() {
        if (a == 1) {
            return true;
        }
        return false;
    }

    static {
        Covode.recordClassIndex(654187);
        a = 0;
        c = new Object();
    }

    static void b() {
        synchronized (c) {
            if (!e()) {
                return;
            }
            if (!d.isEmpty()) {
                d(d);
                d.clear();
            }
            if (!e.isEmpty()) {
                c(e);
                e.clear();
            }
            a = 2;
            d = null;
            e = null;
        }
    }

    static void setBackgroundStartupTracingFlag(boolean z) {
        com.ttnet.org.chromium.base.c.e().edit().putBoolean("bg_startup_tracing", z).apply();
    }

    private static void c(List<a> list) {
        for (a aVar : list) {
            if (aVar.a) {
                d.g().e(aVar.b, aVar.c, aVar.d);
            } else {
                d.g().c(aVar.b, aVar.c, aVar.d);
            }
        }
    }

    private static void d(List<b> list) {
        for (b bVar : list) {
            if (bVar.a) {
                if (bVar.b) {
                    d.g().f(bVar.c, bVar.e, bVar.d, bVar.f);
                } else {
                    d.g().a(bVar.c, bVar.e, bVar.d, bVar.f);
                }
            } else if (bVar.b) {
                d.g().d(bVar.c, bVar.e, bVar.d, bVar.f);
            } else {
                d.g().b(bVar.c, bVar.e, bVar.d, bVar.f);
            }
        }
    }

    public static void a(String str, boolean z) {
        if (!e()) {
            return;
        }
        b bVar = new b(str, true, z);
        synchronized (c) {
            if (!e()) {
                return;
            }
            d.add(bVar);
        }
    }

    public static void f(String str, boolean z) {
        if (!e()) {
            return;
        }
        b bVar = new b(str, false, z);
        synchronized (c) {
            if (!e()) {
                return;
            }
            d.add(bVar);
        }
    }

    static final class b {
        final boolean a;
        final boolean b;
        final String c;
        final int d = Process.myTid();
        final long e = System.nanoTime();
        final long f = SystemClock.currentThreadTimeMillis();

        static {
            Covode.recordClassIndex(654189);
        }

        b(String str, boolean z, boolean z2) {
            this.a = z;
            this.b = z2;
            this.c = str;
        }
    }
}
