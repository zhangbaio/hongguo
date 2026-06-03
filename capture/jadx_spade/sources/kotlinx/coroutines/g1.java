package kotlinx.coroutines;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class g1 {
    private static final kotlinx.coroutines.internal.f0 a;
    public static final kotlinx.coroutines.internal.f0 b;
    private static final kotlinx.coroutines.internal.f0 c;
    private static final kotlinx.coroutines.internal.f0 d;
    private static final kotlinx.coroutines.internal.f0 e;
    private static final o0 f;
    private static final o0 g;

    static {
        Covode.recordClassIndex(659011);
        a = new kotlinx.coroutines.internal.f0("COMPLETING_ALREADY");
        b = new kotlinx.coroutines.internal.f0("COMPLETING_WAITING_CHILDREN");
        c = new kotlinx.coroutines.internal.f0("COMPLETING_RETRY");
        d = new kotlinx.coroutines.internal.f0("TOO_LATE_TO_CANCEL");
        e = new kotlinx.coroutines.internal.f0("SEALED");
        f = new o0(false);
        g = new o0(true);
    }

    public static final Object g(Object obj) {
        if (obj instanceof x0) {
            return new y0((x0) obj);
        }
        return obj;
    }

    public static final Object h(Object obj) {
        y0 y0Var;
        x0 x0Var;
        if (obj instanceof y0) {
            y0Var = (y0) obj;
        } else {
            y0Var = null;
        }
        if (y0Var != null && (x0Var = y0Var.a) != null) {
            return x0Var;
        }
        return obj;
    }
}
