package xi6;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class g {
    private static final g e;
    public static final a f;
    public Object a;
    public final int b;
    public final String c;
    public final float d;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return this.b == gVar.b && Intrinsics.areEqual(this.c, gVar.c) && Float.compare(this.d, gVar.d) == 0;
    }

    public int hashCode() {
        int i = this.b * 31;
        String str = this.c;
        return ((i + (str != null ? str.hashCode() : 0)) * 31) + Float.floatToIntBits(this.d);
    }

    public String toString() {
        return "PredictState(code=" + this.b + ", name=" + this.c + ", percentage=" + this.d + ")";
    }

    public static final class a {
        static {
            Covode.recordClassIndex(652783);
        }

        private a() {
        }

        public final g a() {
            return g.e;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Covode.recordClassIndex(652782);
        f = new a(null);
        e = new g(-1, "Default", 1.0f);
    }

    public g(int i, String name, float f2) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.b = i;
        this.c = name;
        this.d = f2;
    }
}
