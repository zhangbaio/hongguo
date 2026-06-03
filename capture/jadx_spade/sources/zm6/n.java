package zm6;

import bytedance.jvm.time.DateTimeException;
import bytedance.jvm.time.LocalDateTime;
import bytedance.jvm.time.ZoneId;
import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.DateTimeArithmeticException;
import kotlinx.datetime.Instant;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final /* synthetic */ class n {
    static {
        Covode.recordClassIndex(659425);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean c(ZoneId zoneId) {
        try {
            return zoneId.getRules().isFixedOffset();
        } catch (ArrayIndexOutOfBoundsException unused) {
            return false;
        }
    }

    public static final Instant b(kotlinx.datetime.c cVar, l timeZone) {
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        return new Instant(cVar.a.atStartOfDay(timeZone.a).toInstant());
    }

    public static final Instant d(h hVar, l timeZone) {
        Intrinsics.checkNotNullParameter(hVar, "<this>");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        return new Instant(hVar.a.atZone(timeZone.a).toInstant());
    }

    public static final h e(Instant instant, l timeZone) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        try {
            return new h(LocalDateTime.ofInstant(instant.getValue$kotlinx_datetime_release(), timeZone.a));
        } catch (DateTimeException e) {
            throw new DateTimeArithmeticException((Throwable) e);
        }
    }
}
