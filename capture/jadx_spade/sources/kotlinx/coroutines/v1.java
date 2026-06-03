package kotlinx.coroutines;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class v1 {
    public static final v1 a;
    private static final ThreadLocal<p0> b;

    private v1() {
    }

    public final void c() {
        b.set(null);
    }

    public final p0 a() {
        return b.get();
    }

    static {
        Covode.recordClassIndex(659034);
        a = new v1();
        b = kotlinx.coroutines.internal.j0.a(new kotlinx.coroutines.internal.f0("ThreadLocalEventLoop"));
    }

    public final p0 b() {
        ThreadLocal<p0> threadLocal = b;
        p0 p0Var = threadLocal.get();
        if (p0Var == null) {
            p0 a2 = s0.a();
            threadLocal.set(a2);
            return a2;
        }
        return p0Var;
    }

    public final void d(p0 p0Var) {
        b.set(p0Var);
    }
}
