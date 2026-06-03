package pq3;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class q {
    public final boolean a;
    public final boolean b;
    public final boolean c;

    static {
        Covode.recordClassIndex(598253);
    }

    public q() {
        this(false, false, false, 7, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        return this.a == qVar.a && this.b == qVar.b && this.c == qVar.c;
    }

    public int hashCode() {
        return (((androidx.compose.animation.m.a(this.a) * 31) + androidx.compose.animation.m.a(this.b)) * 31) + androidx.compose.animation.m.a(this.c);
    }

    public String toString() {
        return "SeekBarPreviewImageConfig(hiddenPreviewWithoutImage=" + this.a + ", preloadCurImageData=" + this.b + ", preloadPreAndNextImageData=" + this.c + ')';
    }

    public q(boolean z, boolean z2, boolean z3) {
        this.a = z;
        this.b = z2;
        this.c = z3;
    }

    public /* synthetic */ q(boolean z, boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? false : z3);
    }
}
