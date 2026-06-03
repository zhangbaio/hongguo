package aq4;

import com.bytedance.covode.number.Covode;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class g {
    public static final int e;
    public final int a;
    public final int b;
    public final List<h> c;
    public final List<i> d;

    static {
        Covode.recordClassIndex(609417);
        e = 8;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return this.a == gVar.a && this.b == gVar.b && Intrinsics.areEqual(this.c, gVar.c) && Intrinsics.areEqual(this.d, gVar.d);
    }

    public int hashCode() {
        return (((((this.a * 31) + this.b) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
    }

    public String toString() {
        return "GradientMaskSpec(width=" + this.a + ", height=" + this.b + ", solidRects=" + this.c + ", gradientRects=" + this.d + ')';
    }

    public g(int i, int i2, List<h> solidRects, List<i> gradientRects) {
        Intrinsics.checkNotNullParameter(solidRects, "solidRects");
        Intrinsics.checkNotNullParameter(gradientRects, "gradientRects");
        this.a = i;
        this.b = i2;
        this.c = solidRects;
        this.d = gradientRects;
    }
}
