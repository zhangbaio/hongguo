package zm6;

import com.bytedance.covode.number.Covode;
import kotlin.KotlinNothingValueException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.datetime.DateTimeFormatException;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

@Serializable(with = cn6.d.class)
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class c {
    public static final a Companion;

    static {
        Covode.recordClassIndex(659382);
        Companion = new a(null);
    }

    private c() {
    }

    public /* synthetic */ c(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract int b();

    public abstract int h();

    public abstract long i();

    public static final class a {
        static {
            Covode.recordClassIndex(659383);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<c> serializer() {
            return cn6.d.a;
        }

        /* JADX WARN: Removed duplicated region for block: B:122:0x02ac A[LOOP:2: B:114:0x0293->B:122:0x02ac, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:123:0x02af A[EDGE_INSN: B:123:0x02af->B:124:0x02af BREAK  A[LOOP:2: B:114:0x0293->B:122:0x02ac], SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final zm6.c a(java.lang.String r21) {
            /*
                Method dump skipped, instructions count: 870
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: zm6.c.a.a(java.lang.String):zm6.c");
        }

        private static final Void b(String str, int i) {
            throw new DateTimeFormatException("Parse error at char " + i + ": " + str);
        }

        private static final int c(long j, int i, char c) {
            if (j >= -2147483648L && j <= 2147483647L) {
                return (int) j;
            }
            b("Value " + j + " does not fit into an Int, which is required for component '" + c + '\'', i);
            throw new KotlinNothingValueException();
        }
    }

    public final int e() {
        return h() % 12;
    }

    public final int j() {
        return h() / 12;
    }

    public int c() {
        return (int) (i() / 3600000000000L);
    }

    public int f() {
        return (int) (i() % 1000000000);
    }

    public int d() {
        return (int) ((i() % 3600000000000L) / 60000000000L);
    }

    public int g() {
        return (int) ((i() % 60000000000L) / 1000000000);
    }

    public int hashCode() {
        return (((h() * 31) + b()) * 31) + j.a(i());
    }

    private final boolean a() {
        if (h() <= 0 && b() <= 0 && i() <= 0 && ((h() | b()) != 0 || i() != 0)) {
            return true;
        }
        return false;
    }

    public String toString() {
        int i;
        Object obj;
        StringBuilder sb = new StringBuilder();
        if (a()) {
            sb.append('-');
            i = -1;
        } else {
            i = 1;
        }
        sb.append('P');
        if (j() != 0) {
            sb.append(j() * i);
            sb.append('Y');
        }
        if (e() != 0) {
            sb.append(e() * i);
            sb.append('M');
        }
        if (b() != 0) {
            sb.append(b() * i);
            sb.append('D');
        }
        String str = "";
        String str2 = "T";
        if (c() != 0) {
            sb.append("T");
            sb.append(c() * i);
            sb.append('H');
            str2 = "";
        }
        if (d() != 0) {
            sb.append(str2);
            sb.append(d() * i);
            sb.append('M');
        } else {
            str = str2;
        }
        if ((g() | f()) != 0) {
            sb.append(str);
            if (g() != 0) {
                obj = Integer.valueOf(g() * i);
            } else if (f() * i < 0) {
                obj = "-0";
            } else {
                obj = "0";
            }
            sb.append(obj);
            if (f() != 0) {
                sb.append('.');
                sb.append(StringsKt__StringsKt.padStart(String.valueOf(Math.abs(f())), 9, '0'));
            }
            sb.append('S');
        }
        if (sb.length() == 1) {
            sb.append("0D");
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (h() == cVar.h() && b() == cVar.b() && i() == cVar.i()) {
            return true;
        }
        return false;
    }
}
