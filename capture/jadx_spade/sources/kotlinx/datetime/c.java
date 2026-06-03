package kotlinx.datetime;

import bytedance.jvm.time.DayOfWeek;
import bytedance.jvm.time.LocalDate;
import bytedance.jvm.time.format.DateTimeParseException;
import cn6.m;
import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.format.n0;
import kotlinx.datetime.format.x;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

@Serializable(with = m.class)
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class c implements Comparable<c> {
    public static final a Companion;
    private static final c b;
    private static final c c;
    public final LocalDate a;

    public static final class a {
        static {
            Covode.recordClassIndex(659407);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<c> serializer() {
            return m.a;
        }

        public final c a(CharSequence input, x<c> format) {
            Intrinsics.checkNotNullParameter(input, "input");
            Intrinsics.checkNotNullParameter(format, "format");
            if (format == b.a.a()) {
                try {
                    return new c(LocalDate.parse(input));
                } catch (DateTimeParseException e) {
                    throw new DateTimeFormatException((Throwable) e);
                }
            }
            return format.a(input);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ c b(a aVar, CharSequence charSequence, x xVar, int i, Object obj) {
            if ((i & 2) != 0) {
                xVar = e.a();
            }
            return aVar.a(charSequence, xVar);
        }
    }

    public static final class b {
        public static final b a;
        private static final x<c> b;

        private b() {
        }

        public final x<c> a() {
            return n0.j();
        }

        static {
            Covode.recordClassIndex(659408);
            a = new b();
            b = n0.k();
        }
    }

    public final int b() {
        return this.a.getDayOfMonth();
    }

    public final int d() {
        return this.a.getMonthValue();
    }

    public final int e() {
        return this.a.getYear();
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public final DayOfWeek c() {
        DayOfWeek dayOfWeek = this.a.getDayOfWeek();
        Intrinsics.checkNotNullExpressionValue(dayOfWeek, "getDayOfWeek(...)");
        return dayOfWeek;
    }

    public final int f() {
        return an6.d.a(this.a.toEpochDay());
    }

    public String toString() {
        String localDate = this.a.toString();
        Intrinsics.checkNotNullExpressionValue(localDate, "toString(...)");
        return localDate;
    }

    static {
        Covode.recordClassIndex(659406);
        Companion = new a(null);
        LocalDate MIN = LocalDate.MIN;
        Intrinsics.checkNotNullExpressionValue(MIN, "MIN");
        b = new c(MIN);
        LocalDate MAX = LocalDate.MAX;
        Intrinsics.checkNotNullExpressionValue(MAX, "MAX");
        c = new c(MAX);
    }

    public c(LocalDate value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.a = value;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(c other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return this.a.compareTo(other.a);
    }

    public boolean equals(Object obj) {
        if (this != obj && (!(obj instanceof c) || !Intrinsics.areEqual(this.a, ((c) obj).a))) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public c(int r1, int r2, int r3) {
        /*
            r0 = this;
            bytedance.jvm.time.LocalDate r1 = bytedance.jvm.time.LocalDate.of(r1, r2, r3)     // Catch: bytedance.jvm.time.DateTimeException -> Lb
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            r0.<init>(r1)
            return
        Lb:
            r1 = move-exception
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            r2.<init>(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.datetime.c.<init>(int, int, int):void");
    }
}
