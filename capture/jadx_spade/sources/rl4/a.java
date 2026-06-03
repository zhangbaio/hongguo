package rl4;

import androidx.compose.animation.m;
import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.DefaultConstructorMarker;
import x0.i;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {
    public final int a;
    public final float b;
    public final float c;
    public final float d;
    public final boolean e;
    public final boolean f;
    public final float g;
    public final float h;

    static {
        Covode.recordClassIndex(608150);
    }

    public /* synthetic */ a(int i, float f, float f2, float f3, boolean z, boolean z2, float f4, float f5, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, f, f2, f3, z, z2, f4, f5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.a == aVar.a && i.i(this.b, aVar.b) && i.i(this.c, aVar.c) && i.i(this.d, aVar.d) && this.e == aVar.e && this.f == aVar.f && i.i(this.g, aVar.g) && i.i(this.h, aVar.h);
    }

    public int hashCode() {
        return (((((((((((((this.a * 31) + i.k(this.b)) * 31) + i.k(this.c)) * 31) + i.k(this.d)) * 31) + m.a(this.e)) * 31) + m.a(this.f)) * 31) + i.k(this.g)) * 31) + i.k(this.h);
    }

    public String toString() {
        return "GuestProfileOneTabUIConfig(columCount=" + this.a + ", horizontalArrangement=" + ((Object) i.l(this.b)) + ", verticalArrangement=" + ((Object) i.l(this.c)) + ", horizontalPadding=" + ((Object) i.l(this.d)) + ", isStaggerGrid=" + this.e + ", enableItemDivider=" + this.f + ", itemDividerHorizontalPadding=" + ((Object) i.l(this.g)) + ", itemDividerHeight=" + ((Object) i.l(this.h)) + ')';
    }

    private a(int i, float f, float f2, float f3, boolean z, boolean z2, float f4, float f5) {
        this.a = i;
        this.b = f;
        this.c = f2;
        this.d = f3;
        this.e = z;
        this.f = z2;
        this.g = f4;
        this.h = f5;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ a(int r14, float r15, float r16, float r17, boolean r18, boolean r19, float r20, float r21, int r22, kotlin.jvm.internal.DefaultConstructorMarker r23) {
        /*
            r13 = this;
            r0 = r22
            r1 = r0 & 16
            r2 = 0
            if (r1 == 0) goto L9
            r8 = 0
            goto Lb
        L9:
            r8 = r18
        Lb:
            r1 = r0 & 32
            if (r1 == 0) goto L11
            r9 = 0
            goto L13
        L11:
            r9 = r19
        L13:
            r1 = r0 & 64
            if (r1 == 0) goto L1e
            float r1 = (float) r2
            float r1 = x0.i.g(r1)
            r10 = r1
            goto L20
        L1e:
            r10 = r20
        L20:
            r0 = r0 & 128(0x80, float:1.8E-43)
            if (r0 == 0) goto L2b
            float r0 = (float) r2
            float r0 = x0.i.g(r0)
            r11 = r0
            goto L2d
        L2b:
            r11 = r21
        L2d:
            r12 = 0
            r3 = r13
            r4 = r14
            r5 = r15
            r6 = r16
            r7 = r17
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: rl4.a.<init>(int, float, float, float, boolean, boolean, float, float, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
