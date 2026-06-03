package cl4;

import com.bytedance.covode.number.Covode;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class p {
    public static final int e;
    public final int[] a;
    public final float b;
    public final int c;
    public final int d;

    static {
        Covode.recordClassIndex(608053);
        e = 8;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        return Intrinsics.areEqual(this.a, pVar.a) && Float.compare(this.b, pVar.b) == 0 && this.c == pVar.c && this.d == pVar.d;
    }

    public int hashCode() {
        return (((((Arrays.hashCode(this.a) * 31) + Float.floatToIntBits(this.b)) * 31) + this.c) * 31) + this.d;
    }

    public String toString() {
        return "CardAnimInfo(cardBounds=" + Arrays.toString(this.a) + ", coverRatio=" + this.b + ", coverImageWidth=" + this.c + ", coverImageHeight=" + this.d + ')';
    }

    public p(int[] cardBounds, float f, int i, int i2) {
        Intrinsics.checkNotNullParameter(cardBounds, "cardBounds");
        this.a = cardBounds;
        this.b = f;
        this.c = i;
        this.d = i2;
    }
}
