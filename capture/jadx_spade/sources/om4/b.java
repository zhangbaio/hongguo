package om4;

import com.bytedance.covode.number.Covode;
import x0.x;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b {
    static {
        Covode.recordClassIndex(608503);
    }

    public static final float e(float f, float f2) {
        return f * f2;
    }

    public static final int f(int i, float f) {
        return (int) (i * f);
    }

    public static final long a(float f) {
        return x.g(b(f));
    }

    public static final float b(float f) {
        return e(f, a.a());
    }

    public static final int c(int i) {
        return f(i, a.a());
    }

    public static final int d(int i, float f) {
        return f(i, Math.min(a.a(), f));
    }
}
