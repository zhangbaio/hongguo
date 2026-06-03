package kotlin.time;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class i {
    private static final a a;

    public static final Instant b() {
        return a.now();
    }

    static {
        Covode.recordClassIndex(658819);
        a = rm6.b.a.d();
    }

    public static final Object a(Instant instant) {
        Intrinsics.checkNotNullParameter(instant, "instant");
        return new InstantSerialized(instant.getEpochSeconds(), instant.getNanosecondsOfSecond());
    }
}
