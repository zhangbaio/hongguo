package kotlin.random;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class c {
    static {
        Covode.recordClassIndex(658606);
    }

    public static final double b(int i, int i2) {
        return ((i << 27) + i2) / 9.007199254740992E15d;
    }

    public static final java.util.Random a(Random random) {
        a aVar;
        java.util.Random impl;
        Intrinsics.checkNotNullParameter(random, "<this>");
        if (random instanceof a) {
            aVar = (a) random;
        } else {
            aVar = null;
        }
        if (aVar == null || (impl = aVar.getImpl()) == null) {
            return new KotlinRandom(random);
        }
        return impl;
    }
}
