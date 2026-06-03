package kotlin;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@JvmInline
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class o implements Comparable<o> {
    public static final a b;
    private final short a;

    public static final class a {
        static {
            Covode.recordClassIndex(658134);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Covode.recordClassIndex(658133);
        b = new a(null);
    }

    public static final /* synthetic */ o a(short s) {
        return new o(s);
    }

    public static short b(short s) {
        return s;
    }

    public static boolean c(short s, Object obj) {
        return (obj instanceof o) && s == ((o) obj).f();
    }

    public static int d(short s) {
        return s;
    }

    public boolean equals(Object obj) {
        return c(this.a, obj);
    }

    public final /* synthetic */ short f() {
        return this.a;
    }

    public int hashCode() {
        return d(this.a);
    }

    public String toString() {
        return e(this.a);
    }

    private /* synthetic */ o(short s) {
        this.a = s;
    }

    public static String e(short s) {
        return String.valueOf(s & 65535);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(o oVar) {
        return Intrinsics.compare(f() & 65535, oVar.f() & 65535);
    }
}
