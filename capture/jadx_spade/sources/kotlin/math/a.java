package kotlin.math;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class a {
    public static final a a;
    public static final double b;
    public static final double c;
    public static final double d;
    public static final double e;
    public static final double f;
    public static final double g;

    private a() {
    }

    static {
        Covode.recordClassIndex(658588);
        a = new a();
        b = Math.log(2.0d);
        double ulp = Math.ulp(1.0d);
        c = ulp;
        double sqrt = Math.sqrt(ulp);
        d = sqrt;
        double sqrt2 = Math.sqrt(sqrt);
        e = sqrt2;
        double d2 = 1;
        f = d2 / sqrt;
        g = d2 / sqrt2;
    }
}
