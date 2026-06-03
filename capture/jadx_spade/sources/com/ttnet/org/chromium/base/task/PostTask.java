package com.ttnet.org.chromium.base.task;

import com.bytedance.covode.number.Covode;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReferenceArray;

@JNINamespace("base")
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class PostTask {
    private static final Object a;
    private static List<m> b;
    private static volatile boolean c;
    private static final Executor d;
    private static volatile Executor e;
    private static AtomicReferenceArray<j> f;

    interface a {
        void a(int i, boolean z, boolean z2, byte b, byte[] bArr, Runnable runnable, long j, String str);
    }

    private static AtomicReferenceArray<j> a() {
        AtomicReferenceArray<j> atomicReferenceArray = new AtomicReferenceArray<>(5);
        atomicReferenceArray.set(0, new g());
        return atomicReferenceArray;
    }

    static Executor b() {
        if (e != null) {
            return e;
        }
        return d;
    }

    static {
        Covode.recordClassIndex(654401);
        a = new Object();
        b = new ArrayList();
        d = new e();
        f = a();
    }

    private static void onNativeSchedulerReady() {
        List<m> list;
        c = true;
        synchronized (a) {
            list = b;
            b = null;
        }
        Iterator<m> it2 = list.iterator();
        while (it2.hasNext()) {
            it2.next().e();
        }
    }

    private static void onNativeSchedulerShutdownForTesting() {
        synchronized (a) {
            b = new ArrayList();
        }
        c = false;
        f.set(0, new g());
        for (int i = 1; i < f.length(); i++) {
            f.set(i, null);
        }
    }

    private static j c(o oVar) {
        return f.get(oVar.d);
    }

    static boolean f(m mVar) {
        synchronized (a) {
            List<m> list = b;
            if (list == null) {
                return false;
            }
            list.add(mVar);
            return true;
        }
    }

    public static void e(o oVar, Runnable runnable) {
        d(oVar, runnable, 0L);
    }

    public static void d(o oVar, Runnable runnable, long j) {
        if (c && !oVar.f) {
            o e2 = oVar.e();
            h.b().a(e2.a, e2.b, e2.c, e2.d, e2.e, runnable, j, runnable.getClass().getName());
        } else {
            c(oVar).a(oVar, runnable, j);
        }
    }
}
