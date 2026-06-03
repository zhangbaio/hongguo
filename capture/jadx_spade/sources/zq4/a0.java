package zq4;

import android.graphics.Rect;
import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a0 {
    public static final int e;
    public final boolean a;
    public final boolean b;
    public final Rect c;
    public final String d;

    static {
        Covode.recordClassIndex(611438);
        e = 8;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a0)) {
            return false;
        }
        a0 a0Var = (a0) obj;
        return this.a == a0Var.a && this.b == a0Var.b && Intrinsics.areEqual(this.c, a0Var.c) && Intrinsics.areEqual(this.d, a0Var.d);
    }

    public int hashCode() {
        return (((((androidx.compose.animation.m.a(this.a) * 31) + androidx.compose.animation.m.a(this.b)) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
    }

    public String toString() {
        return "ImageBlock(showInImage=" + this.a + ", isHideBubbleSmallImage=" + this.b + ", bubbleImageRectF=" + this.c + ", imageUrl=" + this.d + ')';
    }

    public a0(boolean z, boolean z2, Rect bubbleImageRectF, String imageUrl) {
        Intrinsics.checkNotNullParameter(bubbleImageRectF, "bubbleImageRectF");
        Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
        this.a = z;
        this.b = z2;
        this.c = bubbleImageRectF;
        this.d = imageUrl;
    }
}
