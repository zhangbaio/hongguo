package bq4;

import com.bytedance.covode.number.Covode;
import kotlin.random.Random;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {
    public static final a a;

    static {
        Covode.recordClassIndex(609423);
        a = new a();
    }

    private a() {
    }

    public final Random a() {
        return Random.Default;
    }

    public final long b() {
        long j = 0;
        while (j == 0) {
            j = a().nextLong();
        }
        return Math.abs(j);
    }
}
