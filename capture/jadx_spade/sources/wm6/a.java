package wm6;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Instant;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class a {
    static {
        Covode.recordClassIndex(658839);
    }

    public static final Instant a(java.time.Instant instant) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        return Instant.Companion.b(instant.getEpochSecond(), instant.getNano());
    }
}
