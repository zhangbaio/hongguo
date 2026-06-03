package js4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.multigenre.bean.CoverExtendViewExclusiveZone;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {
    public static final int d;
    public final b a;
    public final float b;
    public final CoverExtendViewExclusiveZone c;

    static {
        Covode.recordClassIndex(612355);
        d = 8;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Intrinsics.areEqual(this.a, aVar.a) && Float.compare(this.b, aVar.b) == 0 && this.c == aVar.c;
    }

    public int hashCode() {
        return (((this.a.hashCode() * 31) + Float.floatToIntBits(this.b)) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "CoverExtendViewInfo(extendViewType=" + this.a + ", priority=" + this.b + ", exclusiveZone=" + this.c + ')';
    }

    public a(b extendViewType, float f, CoverExtendViewExclusiveZone exclusiveZone) {
        Intrinsics.checkNotNullParameter(extendViewType, "extendViewType");
        Intrinsics.checkNotNullParameter(exclusiveZone, "exclusiveZone");
        this.a = extendViewType;
        this.b = f;
        this.c = exclusiveZone;
    }
}
