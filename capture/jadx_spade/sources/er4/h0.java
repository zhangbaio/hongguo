package er4;

import com.bytedance.covode.number.Covode;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class h0 {
    public static final h0 a;
    private static final AtomicBoolean b;
    private static final AtomicBoolean c;
    private static final AtomicBoolean d;
    private static final AtomicBoolean e;
    public static final int f;

    private h0() {
    }

    public static final boolean a() {
        return b.get();
    }

    public static final boolean b() {
        return d.get();
    }

    public static final boolean c() {
        return e.get();
    }

    static {
        Covode.recordClassIndex(611484);
        a = new h0();
        b = new AtomicBoolean(false);
        c = new AtomicBoolean(false);
        d = new AtomicBoolean(false);
        e = new AtomicBoolean(false);
        f = 8;
    }

    public static final void d(boolean z) {
        c.set(z);
    }

    public static final void e(boolean z) {
        b.set(z);
    }

    public static final void f(boolean z) {
        d.set(z);
    }

    public static final void g(boolean z) {
        e.set(z);
    }
}
