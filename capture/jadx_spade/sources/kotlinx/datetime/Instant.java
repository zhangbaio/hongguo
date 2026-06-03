package kotlinx.datetime;

import bytedance.jvm.time.DateTimeException;
import cn6.l;
import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.DurationUnit;
import kotlin.time.c;
import kotlinx.datetime.format.DateTimeComponents;
import kotlinx.datetime.format.x;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

@Serializable(with = l.class)
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class Instant implements Comparable<Instant> {
    public static final a Companion;
    private static final Instant DISTANT_FUTURE;
    private static final Instant DISTANT_PAST;
    private static final Instant MAX;
    private static final Instant MIN;
    private final bytedance.jvm.time.Instant value;

    public static final class a {
        static {
            Covode.recordClassIndex(659402);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<Instant> serializer() {
            return l.a;
        }

        public final Instant d() {
            return Instant.MAX;
        }

        public final Instant e() {
            return Instant.MIN;
        }

        public final Instant f() {
            bytedance.jvm.time.Instant instant = bytedance.jvm.time.Clock.systemUTC().instant();
            Intrinsics.checkNotNullExpressionValue(instant, "instant(...)");
            return new Instant(instant);
        }

        public final Instant a(long j) {
            bytedance.jvm.time.Instant ofEpochMilli = bytedance.jvm.time.Instant.ofEpochMilli(j);
            Intrinsics.checkNotNullExpressionValue(ofEpochMilli, "ofEpochMilli(...)");
            return new Instant(ofEpochMilli);
        }

        public final Instant b(long j, int i) {
            return c(j, i);
        }

        public final Instant c(long j, long j2) {
            Instant e;
            try {
                bytedance.jvm.time.Instant ofEpochSecond = bytedance.jvm.time.Instant.ofEpochSecond(j, j2);
                Intrinsics.checkNotNullExpressionValue(ofEpochSecond, "ofEpochSecond(...)");
                return new Instant(ofEpochSecond);
            } catch (Exception e2) {
                if (!(e2 instanceof ArithmeticException) && !(e2 instanceof DateTimeException)) {
                    throw e2;
                }
                if (j > 0) {
                    e = d();
                } else {
                    e = e();
                }
                return e;
            }
        }

        public final Instant g(CharSequence input, x<DateTimeComponents> format) {
            Intrinsics.checkNotNullParameter(input, "input");
            Intrinsics.checkNotNullParameter(format, "format");
            try {
                return format.a(input).c();
            } catch (IllegalArgumentException e) {
                throw new DateTimeFormatException("Failed to parse an instant from '" + ((Object) input) + '\'', e);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Instant h(a aVar, CharSequence charSequence, x xVar, int i, Object obj) {
            if ((i & 2) != 0) {
                xVar = DateTimeComponents.b.a.C();
            }
            return aVar.g(charSequence, xVar);
        }
    }

    public final bytedance.jvm.time.Instant getValue$kotlinx_datetime_release() {
        return this.value;
    }

    public final long getEpochSeconds() {
        return this.value.getEpochSecond();
    }

    public final int getNanosecondsOfSecond() {
        return this.value.getNano();
    }

    public int hashCode() {
        return this.value.hashCode();
    }

    public String toString() {
        String instant = this.value.toString();
        Intrinsics.checkNotNullExpressionValue(instant, "toString(...)");
        return instant;
    }

    public final long toEpochMilliseconds() {
        try {
            return this.value.toEpochMilli();
        } catch (ArithmeticException unused) {
            if (this.value.isAfter(bytedance.jvm.time.Instant.EPOCH)) {
                return Long.MAX_VALUE;
            }
            return Long.MIN_VALUE;
        }
    }

    static {
        Covode.recordClassIndex(659401);
        Companion = new a(null);
        bytedance.jvm.time.Instant ofEpochSecond = bytedance.jvm.time.Instant.ofEpochSecond(-3217862419201L, 999999999L);
        Intrinsics.checkNotNullExpressionValue(ofEpochSecond, "ofEpochSecond(...)");
        DISTANT_PAST = new Instant(ofEpochSecond);
        bytedance.jvm.time.Instant ofEpochSecond2 = bytedance.jvm.time.Instant.ofEpochSecond(3093527980800L, 0L);
        Intrinsics.checkNotNullExpressionValue(ofEpochSecond2, "ofEpochSecond(...)");
        DISTANT_FUTURE = new Instant(ofEpochSecond2);
        bytedance.jvm.time.Instant MIN2 = bytedance.jvm.time.Instant.MIN;
        Intrinsics.checkNotNullExpressionValue(MIN2, "MIN");
        MIN = new Instant(MIN2);
        bytedance.jvm.time.Instant MAX2 = bytedance.jvm.time.Instant.MAX;
        Intrinsics.checkNotNullExpressionValue(MAX2, "MAX");
        MAX = new Instant(MAX2);
    }

    public Instant(bytedance.jvm.time.Instant value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.value = value;
    }

    @Override // java.lang.Comparable
    public int compareTo(Instant other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return this.value.compareTo(other.value);
    }

    /* renamed from: minus-LRDsOJo, reason: not valid java name */
    public final Instant m1106minusLRDsOJo(long j) {
        return m1107plusLRDsOJo(kotlin.time.c.V(j));
    }

    public boolean equals(Object obj) {
        if (this != obj && (!(obj instanceof Instant) || !Intrinsics.areEqual(this.value, ((Instant) obj).value))) {
            return false;
        }
        return true;
    }

    /* renamed from: minus-5sfh64U, reason: not valid java name */
    public final long m1105minus5sfh64U(Instant other) {
        Intrinsics.checkNotNullParameter(other, "other");
        c.a aVar = kotlin.time.c.b;
        return kotlin.time.c.Q(kotlin.time.e.t(this.value.getEpochSecond() - other.value.getEpochSecond(), DurationUnit.SECONDS), kotlin.time.e.s(this.value.getNano() - other.value.getNano(), DurationUnit.NANOSECONDS));
    }

    /* renamed from: plus-LRDsOJo, reason: not valid java name */
    public final Instant m1107plusLRDsOJo(long j) {
        Instant instant;
        try {
            bytedance.jvm.time.Instant plusNanos = this.value.plusSeconds(kotlin.time.c.u(j)).plusNanos(kotlin.time.c.w(j));
            Intrinsics.checkNotNullExpressionValue(plusNanos, "plusNanos(...)");
            return new Instant(plusNanos);
        } catch (Exception e) {
            if (!(e instanceof ArithmeticException) && !(e instanceof DateTimeException)) {
                throw e;
            }
            if (kotlin.time.c.M(j)) {
                instant = MAX;
            } else {
                instant = MIN;
            }
            return instant;
        }
    }
}
