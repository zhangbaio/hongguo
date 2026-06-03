package com.dragon.read.kmp.widget.expandableText;

import androidx.compose.animation.m;
import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b {
    public final androidx.compose.ui.text.e a;
    public final int b;
    public final int c;
    public final boolean d;
    public final float e;

    static {
        Covode.recordClassIndex(609677);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return Intrinsics.areEqual(this.a, bVar.a) && this.b == bVar.b && this.c == bVar.c && this.d == bVar.d && Float.compare(this.e, bVar.e) == 0;
    }

    public int hashCode() {
        return (((((((this.a.hashCode() * 31) + this.b) * 31) + this.c) * 31) + m.a(this.d)) * 31) + Float.floatToIntBits(this.e);
    }

    public String toString() {
        return "ExpandableTextData(text=" + this.a + ", lineCount=" + this.b + ", originalLineCount=" + this.c + ", isOverFlow=" + this.d + ", height=" + this.e + ')';
    }

    public b(androidx.compose.ui.text.e text, int i, int i2, boolean z, float f) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.a = text;
        this.b = i;
        this.c = i2;
        this.d = z;
        this.e = f;
    }
}
