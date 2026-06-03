package zm6;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.Clock;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class a {
    static {
        Covode.recordClassIndex(659377);
    }

    public static final kotlinx.datetime.c a(Clock clock, l timeZone) {
        Intrinsics.checkNotNullParameter(clock, "<this>");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        return m.c(clock.now(), timeZone).b();
    }
}
