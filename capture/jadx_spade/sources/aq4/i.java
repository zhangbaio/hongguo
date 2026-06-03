package aq4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.story.impl.ui.GradientOrientation;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class i {
    public final h a;
    public final GradientOrientation b;

    static {
        Covode.recordClassIndex(609420);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return Intrinsics.areEqual(this.a, iVar.a) && this.b == iVar.b;
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "GradientRectSegment(rect=" + this.a + ", orientation=" + this.b + ')';
    }

    public i(h rect, GradientOrientation orientation) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        this.a = rect;
        this.b = orientation;
    }
}
