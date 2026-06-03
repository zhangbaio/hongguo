package com.dragon.read.kmp.utils;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class e1 {
    public final int a;
    public final int b;
    public final int c;
    public final int d;

    static {
        Covode.recordClassIndex(609576);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e1)) {
            return false;
        }
        e1 e1Var = (e1) obj;
        return this.a == e1Var.a && this.b == e1Var.b && this.c == e1Var.c && this.d == e1Var.d;
    }

    public int hashCode() {
        return (((((this.a * 31) + this.b) * 31) + this.c) * 31) + this.d;
    }

    public String toString() {
        return "ToneRange(lMin=" + this.a + ", lMax=" + this.b + ", sMin=" + this.c + ", sMax=" + this.d + ')';
    }

    public e1(int i, int i2, int i3, int i4) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
    }
}
