package com.dragon.read.kmp.reader.state;

import androidx.compose.foundation.b1;
import androidx.compose.ui.platform.g3;
import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class d {
    public final float a;
    public final b1 b;
    public final androidx.compose.material.ripple.p c;
    public final g3 d;

    static {
        Covode.recordClassIndex(608571);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return Float.compare(this.a, dVar.a) == 0 && Intrinsics.areEqual(this.b, dVar.b) && Intrinsics.areEqual(this.c, dVar.c) && Intrinsics.areEqual(this.d, dVar.d);
    }

    public int hashCode() {
        return (((((Float.floatToIntBits(this.a) * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
    }

    public String toString() {
        return "DerivedConfigLocals(scale=" + this.a + ", indication=" + this.b + ", rippleTheme=" + this.c + ", viewConfiguration=" + this.d + ')';
    }

    public d(float f, b1 indication, androidx.compose.material.ripple.p rippleTheme, g3 viewConfiguration) {
        Intrinsics.checkNotNullParameter(indication, "indication");
        Intrinsics.checkNotNullParameter(rippleTheme, "rippleTheme");
        Intrinsics.checkNotNullParameter(viewConfiguration, "viewConfiguration");
        this.a = f;
        this.b = indication;
        this.c = rippleTheme;
        this.d = viewConfiguration;
    }
}
