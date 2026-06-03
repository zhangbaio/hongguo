package kotlin.random;

import com.bytedance.covode.number.Covode;
import kotlin.UInt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class d {
    static {
        Covode.recordClassIndex(658611);
    }

    public static final int a(Random random) {
        Intrinsics.checkNotNullParameter(random, "<this>");
        return UInt.m790constructorimpl(random.nextInt());
    }
}
