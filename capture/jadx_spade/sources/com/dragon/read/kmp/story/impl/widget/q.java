package com.dragon.read.kmp.story.impl.widget;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class q {
    public final float a;
    public final float b;
    public final float c;
    public final float d;

    static {
        Covode.recordClassIndex(609430);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        return Float.compare(this.a, qVar.a) == 0 && Float.compare(this.b, qVar.b) == 0 && Float.compare(this.c, qVar.c) == 0 && Float.compare(this.d, qVar.d) == 0;
    }

    public int hashCode() {
        return (((((Float.floatToIntBits(this.a) * 31) + Float.floatToIntBits(this.b)) * 31) + Float.floatToIntBits(this.c)) * 31) + Float.floatToIntBits(this.d);
    }

    public String toString() {
        return "ScrollCalculationInfo(averageItemHeight=" + this.a + ", estimatedTotalHeight=" + this.b + ", currentOffset=" + this.c + ", viewportHeight=" + this.d + ')';
    }

    public q(float f, float f2, float f3, float f4) {
        this.a = f;
        this.b = f2;
        this.c = f3;
        this.d = f4;
    }
}
