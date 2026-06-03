package hq4;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.f2;
import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import yo2.d2;
import yo2.f2;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class f0 {
    public static final int d = 0;
    public final Modifier a;
    public final f2 b;
    public final org.jetbrains.compose.resources.b c;

    static {
        Covode.recordClassIndex(609674);
    }

    public f0() {
        this(null, null, null, 7, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f0)) {
            return false;
        }
        f0 f0Var = (f0) obj;
        return Intrinsics.areEqual(this.a, f0Var.a) && Intrinsics.areEqual(this.b, f0Var.b) && Intrinsics.areEqual(this.c, f0Var.c);
    }

    public int hashCode() {
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "DialogStyle(modifier=" + this.a + ", shape=" + this.b + ", closeButtonImage=" + this.c + ')';
    }

    public f0(Modifier modifier, f2 shape, org.jetbrains.compose.resources.b closeButtonImage) {
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Intrinsics.checkNotNullParameter(shape, "shape");
        Intrinsics.checkNotNullParameter(closeButtonImage, "closeButtonImage");
        this.a = modifier;
        this.b = shape;
        this.c = closeButtonImage;
    }

    public /* synthetic */ f0(Modifier modifier, f2 f2Var, org.jetbrains.compose.resources.b bVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? SizeKt.x(Modifier.Companion, x0.i.g(280)) : modifier, (i & 2) != 0 ? k.g.c(x0.i.g(16)) : f2Var, (i & 4) != 0 ? d2.q(f2.a.a) : bVar);
    }
}
