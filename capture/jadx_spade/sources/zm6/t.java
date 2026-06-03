package zm6;

import bytedance.jvm.time.DateTimeException;
import bytedance.jvm.time.ZoneOffset;
import bytedance.jvm.time.format.DateTimeFormatter;
import bytedance.jvm.time.format.DateTimeFormatterBuilder;
import com.bytedance.covode.number.Covode;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.DateTimeFormatException;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class t {
    private static final Lazy a;
    private static final Lazy b;
    private static final Lazy c;

    /* JADX INFO: Access modifiers changed from: private */
    public static final DateTimeFormatter j() {
        return (DateTimeFormatter) c.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DateTimeFormatter k() {
        return (DateTimeFormatter) b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DateTimeFormatter l() {
        return (DateTimeFormatter) a.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DateTimeFormatter i() {
        return new DateTimeFormatterBuilder().u().i("+HHMM", "+0000").y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DateTimeFormatter m() {
        return new DateTimeFormatterBuilder().u().i("+HHmmss", "Z").y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DateTimeFormatter n() {
        return new DateTimeFormatterBuilder().u().j().y();
    }

    static {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Covode.recordClassIndex(659430);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: zm6.p
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                DateTimeFormatter n;
                n = t.n();
                return n;
            }
        });
        a = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: zm6.q
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                DateTimeFormatter m;
                m = t.m();
                return m;
            }
        });
        b = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: zm6.r
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                DateTimeFormatter i;
                i = t.i();
                return i;
            }
        });
        c = lazy3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final o o(CharSequence charSequence, DateTimeFormatter dateTimeFormatter) {
        try {
            return new o((ZoneOffset) dateTimeFormatter.l(charSequence, new bytedance.jvm.time.temporal.o() { // from class: zm6.s
                public final Object a(bytedance.jvm.time.temporal.e eVar) {
                    return ZoneOffset.from(eVar);
                }
            }));
        } catch (DateTimeException e) {
            throw new DateTimeFormatException((Throwable) e);
        }
    }

    public static final o d(Integer num, Integer num2, Integer num3) {
        o oVar;
        int i;
        int i2 = 0;
        try {
            if (num != null) {
                int intValue = num.intValue();
                if (num2 != null) {
                    i = num2.intValue();
                } else {
                    i = 0;
                }
                if (num3 != null) {
                    i2 = num3.intValue();
                }
                ZoneOffset ofHoursMinutesSeconds = ZoneOffset.ofHoursMinutesSeconds(intValue, i, i2);
                Intrinsics.checkNotNullExpressionValue(ofHoursMinutesSeconds, "ofHoursMinutesSeconds(...)");
                oVar = new o(ofHoursMinutesSeconds);
            } else if (num2 != null) {
                int intValue2 = num2.intValue() / 60;
                int intValue3 = num2.intValue() % 60;
                if (num3 != null) {
                    i2 = num3.intValue();
                }
                ZoneOffset ofHoursMinutesSeconds2 = ZoneOffset.ofHoursMinutesSeconds(intValue2, intValue3, i2);
                Intrinsics.checkNotNullExpressionValue(ofHoursMinutesSeconds2, "ofHoursMinutesSeconds(...)");
                oVar = new o(ofHoursMinutesSeconds2);
            } else {
                if (num3 != null) {
                    i2 = num3.intValue();
                }
                ZoneOffset ofTotalSeconds = ZoneOffset.ofTotalSeconds(i2);
                Intrinsics.checkNotNullExpressionValue(ofTotalSeconds, "ofTotalSeconds(...)");
                oVar = new o(ofTotalSeconds);
            }
            return oVar;
        } catch (DateTimeException e) {
            throw new IllegalArgumentException((Throwable) e);
        }
    }
}
