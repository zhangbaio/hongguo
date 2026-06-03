package tr4;

import android.os.Looper;
import com.bytedance.covode.number.Covode;
import com.bytedance.ug.sdk.luckycat.api.depend.u0;
import com.dragon.read.base.util.LogWrapper;
import com.dragon.read.base.util.ThreadUtils;
import com.dragon.read.plugin.common.PluginServiceManager;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class r implements u0 {
    public static final r a;
    private static boolean b;
    private static boolean c;
    private static WeakReference<u0> d;
    public static final int e;

    static {
        Covode.recordClassIndex(611949);
        a = new r();
        e = 8;
    }

    private r() {
    }

    public final void Q() {
        b = false;
        c = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C() {
        u0 u0Var;
        WeakReference<u0> weakReference = d;
        if (weakReference != null && (u0Var = weakReference.get()) != null) {
            u0Var.onInitStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D() {
        u0 u0Var;
        WeakReference<u0> weakReference = d;
        if (weakReference != null && (u0Var = weakReference.get()) != null) {
            u0Var.onInitSuccess();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E() {
        u0 u0Var;
        WeakReference<u0> weakReference = d;
        if (weakReference != null && (u0Var = weakReference.get()) != null) {
            u0Var.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F() {
        u0 u0Var;
        WeakReference<u0> weakReference = d;
        if (weakReference != null && (u0Var = weakReference.get()) != null) {
            u0Var.j();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J() {
        u0 u0Var;
        WeakReference<u0> weakReference = d;
        if (weakReference != null && (u0Var = weakReference.get()) != null) {
            u0Var.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K() {
        u0 u0Var;
        WeakReference<u0> weakReference = d;
        if (weakReference != null && (u0Var = weakReference.get()) != null) {
            u0Var.k();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M() {
        u0 u0Var;
        WeakReference<u0> weakReference = d;
        if (weakReference != null && (u0Var = weakReference.get()) != null) {
            u0Var.h();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N() {
        u0 u0Var;
        WeakReference<u0> weakReference = d;
        if (weakReference != null && (u0Var = weakReference.get()) != null) {
            u0Var.b();
        }
    }

    public void b() {
        z(new Runnable() { // from class: tr4.i
            @Override // java.lang.Runnable
            public final void run() {
                r.N();
            }
        });
    }

    public void e() {
        z(new Runnable() { // from class: tr4.m
            @Override // java.lang.Runnable
            public final void run() {
                r.J();
            }
        });
    }

    public void g() {
        z(new Runnable() { // from class: tr4.g
            @Override // java.lang.Runnable
            public final void run() {
                r.E();
            }
        });
    }

    public void h() {
        z(new Runnable() { // from class: tr4.k
            @Override // java.lang.Runnable
            public final void run() {
                r.M();
            }
        });
    }

    public void j() {
        z(new Runnable() { // from class: tr4.f
            @Override // java.lang.Runnable
            public final void run() {
                r.F();
            }
        });
    }

    public void k() {
        z(new Runnable() { // from class: tr4.j
            @Override // java.lang.Runnable
            public final void run() {
                r.K();
            }
        });
    }

    public void onInitStart() {
        z(new Runnable() { // from class: tr4.l
            @Override // java.lang.Runnable
            public final void run() {
                r.C();
            }
        });
    }

    public void onInitSuccess() {
        z(new Runnable() { // from class: tr4.d
            @Override // java.lang.Runnable
            public final void run() {
                r.D();
            }
        });
    }

    public final void R(WeakReference<u0> weakReference) {
        d = weakReference;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(ut0.a aVar) {
        a.A(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(int i) {
        u0 u0Var;
        WeakReference<u0> weakReference = d;
        if (weakReference != null && (u0Var = weakReference.get()) != null) {
            u0Var.i(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(int i) {
        u0 u0Var;
        WeakReference<u0> weakReference = d;
        if (weakReference != null && (u0Var = weakReference.get()) != null) {
            u0Var.c(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(int i) {
        u0 u0Var;
        WeakReference<u0> weakReference = d;
        if (weakReference != null && (u0Var = weakReference.get()) != null) {
            u0Var.d(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(int i) {
        u0 u0Var;
        WeakReference<u0> weakReference = d;
        if (weakReference != null && (u0Var = weakReference.get()) != null) {
            u0Var.a(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(int i) {
        u0 u0Var;
        WeakReference<u0> weakReference = d;
        if (weakReference != null && (u0Var = weakReference.get()) != null) {
            u0Var.f(i);
        }
    }

    public void a(final int i) {
        z(new Runnable() { // from class: tr4.o
            @Override // java.lang.Runnable
            public final void run() {
                r.I(i);
            }
        });
    }

    public void c(final int i) {
        z(new Runnable() { // from class: tr4.h
            @Override // java.lang.Runnable
            public final void run() {
                r.G(i);
            }
        });
    }

    public void d(final int i) {
        z(new Runnable() { // from class: tr4.e
            @Override // java.lang.Runnable
            public final void run() {
                r.H(i);
            }
        });
    }

    public void f(final int i) {
        z(new Runnable() { // from class: tr4.q
            @Override // java.lang.Runnable
            public final void run() {
                r.L(i);
            }
        });
    }

    public void i(final int i) {
        z(new Runnable() { // from class: tr4.p
            @Override // java.lang.Runnable
            public final void run() {
                r.B(i);
            }
        });
    }

    private final void z(Runnable runnable) {
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            runnable.run();
        } else {
            ThreadUtils.postInForeground(runnable);
        }
    }

    public final void O(final ut0.a aVar) {
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            A(aVar);
        } else {
            ThreadUtils.postInForeground(new Runnable() { // from class: tr4.n
                @Override // java.lang.Runnable
                public final void run() {
                    r.P(aVar);
                }
            });
        }
    }

    private final void A(ut0.a aVar) {
        float f;
        if (aVar != null) {
            LogWrapper.info("LynxStatusCallbackMgr", "status: " + aVar.c, new Object[0]);
            int i = aVar.c;
            if (i != 2) {
                if (i != 3) {
                    if (i != 6) {
                        b = false;
                        return;
                    }
                    int pluginStatus = PluginServiceManager.ins().getPluginStatus("com.dragon.read.plugin.lynx");
                    LogWrapper.debug("LynxStatusCallbackMgr", "MorpheusStatusCode.FAILED, pluginState= " + pluginStatus, new Object[0]);
                    if (1 == pluginStatus && !c) {
                        a.c(aVar.c);
                    }
                    b = false;
                    return;
                }
                if (!c) {
                    a.j();
                    c = true;
                }
                b = false;
                return;
            }
            c = false;
            if (!b) {
                a.g();
                b = true;
            }
            long j = aVar.d;
            if (j > 0) {
                f = aVar.e / j;
            } else {
                f = 0.0f;
            }
            if (aVar.e == j) {
                f = 1.0f;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("progress= ");
            int i2 = (int) (f * 100);
            sb.append(i2);
            LogWrapper.debug("LynxStatusCallbackMgr", sb.toString(), new Object[0]);
            a.d(i2);
        }
    }
}
