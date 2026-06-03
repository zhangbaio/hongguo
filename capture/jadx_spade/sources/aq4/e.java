package aq4;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class e {
    public final int a;
    public final int b;
    public final float c;
    public final float d;
    public final float e;
    public final float f;
    public final float g;
    public final float h;
    public final float i;
    public final float j;

    static {
        Covode.recordClassIndex(609415);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return this.a == eVar.a && this.b == eVar.b && Float.compare(this.c, eVar.c) == 0 && Float.compare(this.d, eVar.d) == 0 && Float.compare(this.e, eVar.e) == 0 && Float.compare(this.f, eVar.f) == 0 && Float.compare(this.g, eVar.g) == 0 && Float.compare(this.h, eVar.h) == 0 && Float.compare(this.i, eVar.i) == 0 && Float.compare(this.j, eVar.j) == 0;
    }

    public int hashCode() {
        return (((((((((((((((((this.a * 31) + this.b) * 31) + Float.floatToIntBits(this.c)) * 31) + Float.floatToIntBits(this.d)) * 31) + Float.floatToIntBits(this.e)) * 31) + Float.floatToIntBits(this.f)) * 31) + Float.floatToIntBits(this.g)) * 31) + Float.floatToIntBits(this.h)) * 31) + Float.floatToIntBits(this.i)) * 31) + Float.floatToIntBits(this.j);
    }

    public String toString() {
        return "GradientMaskParams(width=" + this.a + ", height=" + this.b + ", leftEdge=" + this.c + ", topEdge=" + this.d + ", rightEdge=" + this.e + ", bottomEdge=" + this.f + ", leftEmptyRange=" + this.g + ", topEmptyRange=" + this.h + ", rightEmptyRange=" + this.i + ", bottomEmptyRange=" + this.j + ')';
    }

    public e(int i, int i2, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        this.a = i;
        this.b = i2;
        this.c = f;
        this.d = f2;
        this.e = f3;
        this.f = f4;
        this.g = f5;
        this.h = f6;
        this.i = f7;
        this.j = f8;
    }
}
