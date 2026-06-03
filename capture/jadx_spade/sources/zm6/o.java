package zm6;

import bytedance.jvm.time.ZoneOffset;
import bytedance.jvm.time.format.DateTimeFormatter;
import cn6.w;
import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.format.l2;
import kotlinx.datetime.format.x;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

@Serializable(with = w.class)
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class o {
    public static final a Companion;
    private static final o b;
    public final ZoneOffset a;

    public static final class a {
        static {
            Covode.recordClassIndex(659428);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<o> serializer() {
            return w.a;
        }

        public final o a(CharSequence input, x<o> format) {
            DateTimeFormatter j;
            o o;
            DateTimeFormatter k;
            o o2;
            DateTimeFormatter l;
            o o3;
            Intrinsics.checkNotNullParameter(input, "input");
            Intrinsics.checkNotNullParameter(format, "format");
            b bVar = b.a;
            if (format == bVar.b()) {
                l = t.l();
                Intrinsics.checkNotNullExpressionValue(l, "access$getIsoFormat(...)");
                o3 = t.o(input, l);
                return o3;
            }
            if (format == bVar.c()) {
                k = t.k();
                Intrinsics.checkNotNullExpressionValue(k, "access$getIsoBasicFormat(...)");
                o2 = t.o(input, k);
                return o2;
            }
            if (format == bVar.a()) {
                j = t.j();
                Intrinsics.checkNotNullExpressionValue(j, "access$getFourDigitsFormat(...)");
                o = t.o(input, j);
                return o;
            }
            return format.a(input);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ o b(a aVar, CharSequence charSequence, x xVar, int i, Object obj) {
            if ((i & 2) != 0) {
                xVar = u.b();
            }
            return aVar.a(charSequence, xVar);
        }
    }

    public static final class b {
        public static final b a;

        static {
            Covode.recordClassIndex(659429);
            a = new b();
        }

        private b() {
        }

        public final x<o> a() {
            return l2.L();
        }

        public final x<o> b() {
            return l2.M();
        }

        public final x<o> c() {
            return l2.N();
        }
    }

    public final int a() {
        return this.a.getTotalSeconds();
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        String zoneOffset = this.a.toString();
        Intrinsics.checkNotNullExpressionValue(zoneOffset, "toString(...)");
        return zoneOffset;
    }

    static {
        Covode.recordClassIndex(659427);
        Companion = new a(null);
        ZoneOffset UTC = ZoneOffset.UTC;
        Intrinsics.checkNotNullExpressionValue(UTC, "UTC");
        b = new o(UTC);
    }

    public o(ZoneOffset zoneOffset) {
        Intrinsics.checkNotNullParameter(zoneOffset, "zoneOffset");
        this.a = zoneOffset;
    }

    public boolean equals(Object obj) {
        if ((obj instanceof o) && Intrinsics.areEqual(this.a, ((o) obj).a)) {
            return true;
        }
        return false;
    }
}
