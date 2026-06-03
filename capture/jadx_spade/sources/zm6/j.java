package zm6;

import bytedance.jvm.time.LocalTime;
import bytedance.jvm.time.format.DateTimeParseException;
import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.DateTimeFormatException;
import kotlinx.datetime.format.a1;
import kotlinx.datetime.format.x;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

@Serializable(with = cn6.o.class)
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class j implements Comparable<j> {
    public static final a Companion;
    private static final j b;
    private static final j c;
    public final LocalTime a;

    public static final class a {
        static {
            Covode.recordClassIndex(659417);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<j> serializer() {
            return cn6.o.a;
        }

        public final j a(CharSequence input, x<j> format) {
            Intrinsics.checkNotNullParameter(input, "input");
            Intrinsics.checkNotNullParameter(format, "format");
            if (format == b.a.a()) {
                try {
                    return new j(LocalTime.parse(input));
                } catch (DateTimeParseException e) {
                    throw new DateTimeFormatException((Throwable) e);
                }
            }
            return format.a(input);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ j b(a aVar, CharSequence charSequence, x xVar, int i, Object obj) {
            if ((i & 2) != 0) {
                xVar = k.a();
            }
            return aVar.a(charSequence, xVar);
        }
    }

    public static final class b {
        public static final b a;

        static {
            Covode.recordClassIndex(659418);
            a = new b();
        }

        private b() {
        }

        public final x<j> a() {
            return a1.l();
        }
    }

    public final int b() {
        return this.a.getHour();
    }

    public final int c() {
        return this.a.getMinute();
    }

    public final int d() {
        return this.a.getNano();
    }

    public final int e() {
        return this.a.getSecond();
    }

    public final int f() {
        return this.a.toSecondOfDay();
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        String localTime = this.a.toString();
        Intrinsics.checkNotNullExpressionValue(localTime, "toString(...)");
        return localTime;
    }

    static {
        Covode.recordClassIndex(659416);
        Companion = new a(null);
        LocalTime MIN = LocalTime.MIN;
        Intrinsics.checkNotNullExpressionValue(MIN, "MIN");
        b = new j(MIN);
        LocalTime MAX = LocalTime.MAX;
        Intrinsics.checkNotNullExpressionValue(MAX, "MAX");
        c = new j(MAX);
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(j other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return this.a.compareTo(other.a);
    }

    public boolean equals(Object obj) {
        if (this != obj && (!(obj instanceof j) || !Intrinsics.areEqual(this.a, ((j) obj).a))) {
            return false;
        }
        return true;
    }

    public j(LocalTime value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.a = value;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public j(int r1, int r2, int r3, int r4) {
        /*
            r0 = this;
            bytedance.jvm.time.LocalTime r1 = bytedance.jvm.time.LocalTime.of(r1, r2, r3, r4)     // Catch: bytedance.jvm.time.DateTimeException -> Lb
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            r0.<init>(r1)
            return
        Lb:
            r1 = move-exception
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            r2.<init>(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: zm6.j.<init>(int, int, int, int):void");
    }

    public /* synthetic */ j(int i, int i2, int i3, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, (i5 & 4) != 0 ? 0 : i3, (i5 & 8) != 0 ? 0 : i4);
    }
}
