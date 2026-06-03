package kotlinx.datetime;

import bytedance.jvm.time.DateTimeException;
import bytedance.jvm.time.ZonedDateTime;
import com.bytedance.covode.number.Covode;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.a;
import zm6.l;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class b {
    static {
        Covode.recordClassIndex(659403);
    }

    private static final ZonedDateTime a(Instant instant, l lVar) {
        try {
            return instant.getValue$kotlinx_datetime_release().atZone(lVar.a);
        } catch (DateTimeException e) {
            throw new DateTimeArithmeticException((Throwable) e);
        }
    }

    public static final Instant c(Instant instant, long j, a.e unit) {
        Instant e;
        Intrinsics.checkNotNullParameter(instant, "<this>");
        Intrinsics.checkNotNullParameter(unit, "unit");
        try {
            an6.b d = an6.d.d(j, unit.m, 1000000000L);
            long j2 = d.a;
            bytedance.jvm.time.Instant plusNanos = instant.getValue$kotlinx_datetime_release().plusSeconds(j2).plusNanos(d.b);
            Intrinsics.checkNotNullExpressionValue(plusNanos, "plusNanos(...)");
            return new Instant(plusNanos);
        } catch (Exception e2) {
            if (!(e2 instanceof DateTimeException) && !(e2 instanceof ArithmeticException)) {
                throw e2;
            }
            if (j > 0) {
                e = Instant.Companion.d();
            } else {
                e = Instant.Companion.e();
            }
            return e;
        }
    }

    public static final Instant b(Instant instant, int i, a unit, l timeZone) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        Intrinsics.checkNotNullParameter(unit, "unit");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        return d(instant, i, unit, timeZone);
    }

    public static final Instant d(Instant instant, long j, a unit, l timeZone) {
        bytedance.jvm.time.Instant instant2;
        Intrinsics.checkNotNullParameter(instant, "<this>");
        Intrinsics.checkNotNullParameter(unit, "unit");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        try {
            ZonedDateTime a = a(instant, timeZone);
            if (unit instanceof a.e) {
                instant2 = c(instant, j, (a.e) unit).getValue$kotlinx_datetime_release();
                instant2.atZone(timeZone.a);
            } else if (unit instanceof a.c) {
                instant2 = a.plusDays(an6.c.c(j, ((a.c) unit).m)).toInstant();
            } else if (unit instanceof a.d) {
                instant2 = a.plusMonths(an6.c.c(j, ((a.d) unit).m)).toInstant();
            } else {
                throw new NoWhenBranchMatchedException();
            }
            return new Instant(instant2);
        } catch (Exception e) {
            if (!(e instanceof DateTimeException) && !(e instanceof ArithmeticException)) {
                throw e;
            }
            throw new DateTimeArithmeticException("Instant " + instant + " cannot be represented as local date when adding " + j + ' ' + unit + " to it", e);
        }
    }
}
