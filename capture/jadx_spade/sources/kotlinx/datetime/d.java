package kotlinx.datetime;

import bytedance.jvm.time.DateTimeException;
import bytedance.jvm.time.LocalDate;
import bytedance.jvm.time.temporal.ChronoUnit;
import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class d {
    private static final long a;
    private static final long b;

    static {
        Covode.recordClassIndex(659409);
        a = LocalDate.MIN.toEpochDay();
        b = LocalDate.MAX.toEpochDay();
    }

    public static final int a(c cVar, c other) {
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return an6.d.a(cVar.a.until(other.a, ChronoUnit.DAYS));
    }

    public static final c b(c cVar, zm6.b period) {
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        Intrinsics.checkNotNullParameter(period, "period");
        try {
            LocalDate localDate = cVar.a;
            if (period.h() != 0) {
                localDate = localDate.plusMonths(period.h());
            }
            if (period.b() != 0) {
                localDate = localDate.plusDays(period.b());
            }
            return new c(localDate);
        } catch (DateTimeException unused) {
            throw new DateTimeArithmeticException("The result of adding " + cVar.a + " to " + cVar + " is out of LocalDate range.");
        }
    }
}
