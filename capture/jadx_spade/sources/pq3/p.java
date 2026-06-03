package pq3;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class p {
    public final boolean a;
    public final boolean b;
    public final boolean c;
    public final boolean d;

    static {
        Covode.recordClassIndex(598252);
    }

    public p() {
        this(false, false, false, false, 15, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        return this.a == pVar.a && this.b == pVar.b && this.c == pVar.c && this.d == pVar.d;
    }

    public int hashCode() {
        return (((((androidx.compose.animation.m.a(this.a) * 31) + androidx.compose.animation.m.a(this.b)) * 31) + androidx.compose.animation.m.a(this.c)) * 31) + androidx.compose.animation.m.a(this.d);
    }

    public String toString() {
        return "SeekBarPreviewHeicConfig(heicEnable=" + this.a + ", closeEncodedImage=" + this.b + ", closeEncodedImageReference=" + this.c + ", closeBitmapReference=" + this.d + ')';
    }

    public p(boolean z, boolean z2, boolean z3, boolean z4) {
        this.a = z;
        this.b = z2;
        this.c = z3;
        this.d = z4;
    }

    public /* synthetic */ p(boolean z, boolean z2, boolean z3, boolean z4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? false : z3, (i & 8) != 0 ? false : z4);
    }
}
