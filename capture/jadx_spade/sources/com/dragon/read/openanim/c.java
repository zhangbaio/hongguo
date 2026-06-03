package com.dragon.read.openanim;

import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class c {
    public static final int e;
    public final float a;
    public final Drawable b;
    public final Matrix c;
    public final Matrix d;

    static {
        Covode.recordClassIndex(612624);
        e = 8;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return Float.compare(this.a, cVar.a) == 0 && Intrinsics.areEqual(this.b, cVar.b) && Intrinsics.areEqual(this.c, cVar.c) && Intrinsics.areEqual(this.d, cVar.d);
    }

    public int hashCode() {
        int floatToIntBits = Float.floatToIntBits(this.a) * 31;
        Drawable drawable = this.b;
        int hashCode = (((floatToIntBits + (drawable == null ? 0 : drawable.hashCode())) * 31) + this.c.hashCode()) * 31;
        Matrix matrix = this.d;
        return hashCode + (matrix != null ? matrix.hashCode() : 0);
    }

    public String toString() {
        return "AnimValue(fraction=" + this.a + ", drawable=" + this.b + ", contentMatrix=" + this.c + ", bookCoverMatrix=" + this.d + ')';
    }

    public c(float f, Drawable drawable, Matrix contentMatrix, Matrix matrix) {
        Intrinsics.checkNotNullParameter(contentMatrix, "contentMatrix");
        this.a = f;
        this.b = drawable;
        this.c = contentMatrix;
        this.d = matrix;
    }
}
