package zm6;

import bytedance.jvm.time.LocalDate;
import bytedance.jvm.time.LocalDateTime;
import bytedance.jvm.time.LocalTime;
import bytedance.jvm.time.format.DateTimeParseException;
import com.bytedance.covode.number.Covode;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.DateTimeFormatException;
import kotlinx.datetime.format.o0;
import kotlinx.datetime.format.t0;
import kotlinx.datetime.format.x;
import kotlinx.datetime.format.y;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

@Serializable(with = cn6.n.class)
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class h implements Comparable<h> {
    public static final a Companion;
    private static final h b;
    private static final h c;
    public final LocalDateTime a;

    public static final class a {
        static {
            Covode.recordClassIndex(659412);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<h> serializer() {
            return cn6.n.a;
        }

        public final x<h> a(Function1<? super y.b, Unit> builder) {
            Intrinsics.checkNotNullParameter(builder, "builder");
            return o0.b.a(builder);
        }

        public final h b(CharSequence input, x<h> format) {
            Intrinsics.checkNotNullParameter(input, "input");
            Intrinsics.checkNotNullParameter(format, "format");
            if (format == b.a.a()) {
                try {
                    return new h(LocalDateTime.parse(input));
                } catch (DateTimeParseException e) {
                    throw new DateTimeFormatException((Throwable) e);
                }
            }
            return format.a(input);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ h c(a aVar, CharSequence charSequence, x xVar, int i, Object obj) {
            if ((i & 2) != 0) {
                xVar = i.a();
            }
            return aVar.b(charSequence, xVar);
        }
    }

    public static final class b {
        public static final b a;
        private static final x<h> b;

        private b() {
        }

        public final x<h> a() {
            return b;
        }

        static {
            Covode.recordClassIndex(659413);
            a = new b();
            b = t0.j();
        }
    }

    public final int c() {
        return this.a.getDayOfMonth();
    }

    public final int d() {
        return this.a.getHour();
    }

    public final int e() {
        return this.a.getMinute();
    }

    public final int f() {
        return this.a.getMonthValue();
    }

    public final int g() {
        return this.a.getNano();
    }

    public final int h() {
        return this.a.getSecond();
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public final int k() {
        return this.a.getYear();
    }

    public String toString() {
        String localDateTime = this.a.toString();
        Intrinsics.checkNotNullExpressionValue(localDateTime, "toString(...)");
        return localDateTime;
    }

    public final kotlinx.datetime.c b() {
        LocalDate localDate = this.a.toLocalDate();
        Intrinsics.checkNotNullExpressionValue(localDate, "toLocalDate(...)");
        return new kotlinx.datetime.c(localDate);
    }

    public final j i() {
        LocalTime localTime = this.a.toLocalTime();
        Intrinsics.checkNotNullExpressionValue(localTime, "toLocalTime(...)");
        return new j(localTime);
    }

    static {
        Covode.recordClassIndex(659411);
        Companion = new a(null);
        LocalDateTime MIN = LocalDateTime.MIN;
        Intrinsics.checkNotNullExpressionValue(MIN, "MIN");
        b = new h(MIN);
        LocalDateTime MAX = LocalDateTime.MAX;
        Intrinsics.checkNotNullExpressionValue(MAX, "MAX");
        c = new h(MAX);
    }

    public h(LocalDateTime value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.a = value;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(h other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return this.a.compareTo(other.a);
    }

    public boolean equals(Object obj) {
        if (this != obj && (!(obj instanceof h) || !Intrinsics.areEqual(this.a, ((h) obj).a))) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public h(kotlinx.datetime.c r2, zm6.j r3) {
        /*
            r1 = this;
            java.lang.String r0 = "date"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "time"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            bytedance.jvm.time.LocalDate r2 = r2.a
            bytedance.jvm.time.LocalTime r3 = r3.a
            bytedance.jvm.time.LocalDateTime r2 = bytedance.jvm.time.LocalDateTime.of(r2, r3)
            java.lang.String r3 = "of(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            r1.<init>(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: zm6.h.<init>(kotlinx.datetime.c, zm6.j):void");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public h(int r1, int r2, int r3, int r4, int r5, int r6, int r7) {
        /*
            r0 = this;
            bytedance.jvm.time.LocalDateTime r1 = bytedance.jvm.time.LocalDateTime.of(r1, r2, r3, r4, r5, r6, r7)     // Catch: bytedance.jvm.time.DateTimeException -> Lb
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            r0.<init>(r1)
            return
        Lb:
            r1 = move-exception
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            r2.<init>(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: zm6.h.<init>(int, int, int, int, int, int, int):void");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ h(int r11, int r12, int r13, int r14, int r15, int r16, int r17, int r18, kotlin.jvm.internal.DefaultConstructorMarker r19) {
        /*
            r10 = this;
            r0 = r18 & 32
            r1 = 0
            if (r0 == 0) goto L7
            r8 = 0
            goto L9
        L7:
            r8 = r16
        L9:
            r0 = r18 & 64
            if (r0 == 0) goto Lf
            r9 = 0
            goto L11
        Lf:
            r9 = r17
        L11:
            r2 = r10
            r3 = r11
            r4 = r12
            r5 = r13
            r6 = r14
            r7 = r15
            r2.<init>(r3, r4, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: zm6.h.<init>(int, int, int, int, int, int, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
