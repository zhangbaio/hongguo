package kotlin.time;

import com.bytedance.covode.number.Covode;
import java.text.DecimalFormat;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class d {
    private static final boolean a;
    private static final ThreadLocal<DecimalFormat>[] b;

    public static final boolean a() {
        return a;
    }

    static {
        Covode.recordClassIndex(658807);
        a = false;
        ThreadLocal<DecimalFormat>[] threadLocalArr = new ThreadLocal[4];
        for (int i = 0; i < 4; i++) {
            threadLocalArr[i] = new ThreadLocal<>();
        }
        b = threadLocalArr;
    }
}
