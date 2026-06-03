package com.dragon.read.kmp.utils;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class x0 {
    public static final int h;
    public float a;
    public int b;
    public int c;
    public int d;
    public long e;
    public e1 f;
    public e1 g;

    static {
        Covode.recordClassIndex(609571);
        h = 8;
    }

    public /* synthetic */ x0(float f, int i, int i2, int i3, long j, e1 e1Var, e1 e1Var2, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, i, i2, i3, j, e1Var, e1Var2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof x0)) {
            return false;
        }
        x0 x0Var = (x0) obj;
        return Float.compare(this.a, x0Var.a) == 0 && this.b == x0Var.b && this.c == x0Var.c && this.d == x0Var.d && androidx.compose.ui.graphics.l0.p(this.e, x0Var.e) && Intrinsics.areEqual(this.f, x0Var.f) && Intrinsics.areEqual(this.g, x0Var.g);
    }

    public int hashCode() {
        return (((((((((((Float.floatToIntBits(this.a) * 31) + this.b) * 31) + this.c) * 31) + this.d) * 31) + androidx.compose.ui.graphics.l0.v(this.e)) * 31) + this.f.hashCode()) * 31) + this.g.hashCode();
    }

    public String toString() {
        return "ThemeConfig(thresholdS=" + this.a + ", floor=" + this.b + ", upper=" + this.c + ", brightCutoff=" + this.d + ", defaultColor=" + ((Object) androidx.compose.ui.graphics.l0.w(this.e)) + ", bright=" + this.f + ", dark=" + this.g + ')';
    }

    private x0(float f, int i, int i2, int i3, long j, e1 bright, e1 dark) {
        Intrinsics.checkNotNullParameter(bright, "bright");
        Intrinsics.checkNotNullParameter(dark, "dark");
        this.a = f;
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = j;
        this.f = bright;
        this.g = dark;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ x0(float r12, int r13, int r14, int r15, long r16, com.dragon.read.kmp.utils.e1 r18, com.dragon.read.kmp.utils.e1 r19, int r20, kotlin.jvm.internal.DefaultConstructorMarker r21) {
        /*
            r11 = this;
            r0 = r20 & 1
            if (r0 == 0) goto L8
            r0 = 1036831949(0x3dcccccd, float:0.1)
            goto L9
        L8:
            r0 = r12
        L9:
            r1 = r20 & 2
            r2 = 25
            if (r1 == 0) goto L12
            r1 = 25
            goto L13
        L12:
            r1 = r13
        L13:
            r3 = r20 & 4
            if (r3 == 0) goto L1a
            r3 = 100
            goto L1b
        L1a:
            r3 = r14
        L1b:
            r4 = r20 & 8
            if (r4 == 0) goto L22
            r4 = 50
            goto L23
        L22:
            r4 = r15
        L23:
            r5 = r20 & 16
            if (r5 == 0) goto L2c
            long r5 = com.dragon.read.kmp.utils.i.a()
            goto L2e
        L2c:
            r5 = r16
        L2e:
            r7 = r20 & 32
            r8 = 60
            if (r7 == 0) goto L3c
            com.dragon.read.kmp.utils.e1 r7 = new com.dragon.read.kmp.utils.e1
            r9 = 40
            r7.<init>(r2, r9, r2, r8)
            goto L3e
        L3c:
            r7 = r18
        L3e:
            r9 = r20 & 64
            if (r9 == 0) goto L4a
            com.dragon.read.kmp.utils.e1 r9 = new com.dragon.read.kmp.utils.e1
            r10 = 30
            r9.<init>(r2, r10, r2, r8)
            goto L4c
        L4a:
            r9 = r19
        L4c:
            r2 = 0
            r12 = r11
            r13 = r0
            r14 = r1
            r15 = r3
            r16 = r4
            r17 = r5
            r19 = r7
            r20 = r9
            r21 = r2
            r12.<init>(r13, r14, r15, r16, r17, r19, r20, r21)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.utils.x0.<init>(float, int, int, int, long, com.dragon.read.kmp.utils.e1, com.dragon.read.kmp.utils.e1, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
