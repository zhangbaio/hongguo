package kotlin;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@JvmInline
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class g implements Comparable<g> {
    public static final a b;
    private final byte a;

    public static final class a {
        static {
            Covode.recordClassIndex(658114);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Covode.recordClassIndex(658113);
        b = new a(null);
    }

    public static final /* synthetic */ g a(byte b2) {
        return new g(b2);
    }

    public static byte b(byte b2) {
        return b2;
    }

    public static boolean c(byte b2, Object obj) {
        return (obj instanceof g) && b2 == ((g) obj).f();
    }

    public static int d(byte b2) {
        return b2;
    }

    public boolean equals(Object obj) {
        return c(this.a, obj);
    }

    public final /* synthetic */ byte f() {
        return this.a;
    }

    public int hashCode() {
        return d(this.a);
    }

    public String toString() {
        return e(this.a);
    }

    private /* synthetic */ g(byte b2) {
        this.a = b2;
    }

    public static String e(byte b2) {
        return String.valueOf(b2 & 255);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(g gVar) {
        return Intrinsics.compare(f() & 255, gVar.f() & 255);
    }
}
