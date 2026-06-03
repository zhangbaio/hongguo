package dn4;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class f {
    public static final int c;
    public final b0 a;
    public final boolean b;

    static {
        Covode.recordClassIndex(608744);
        c = 8;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f() {
        this(null, false, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ f b(f fVar, b0 b0Var, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            b0Var = fVar.a;
        }
        if ((i & 2) != 0) {
            z = fVar.b;
        }
        return fVar.a(b0Var, z);
    }

    public final f a(b0 normalCardModel, boolean z) {
        Intrinsics.checkNotNullParameter(normalCardModel, "normalCardModel");
        return new f(normalCardModel, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return Intrinsics.areEqual(this.a, fVar.a) && this.b == fVar.b;
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + androidx.compose.animation.m.a(this.b);
    }

    public String toString() {
        return "IpAudioBookCardModel(normalCardModel=" + this.a + ", isPlaying=" + this.b + ')';
    }

    public f(b0 normalCardModel, boolean z) {
        Intrinsics.checkNotNullParameter(normalCardModel, "normalCardModel");
        this.a = normalCardModel;
        this.b = z;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ f(dn4.b0 r14, boolean r15, int r16, kotlin.jvm.internal.DefaultConstructorMarker r17) {
        /*
            r13 = this;
            r0 = r16 & 1
            if (r0 == 0) goto L17
            dn4.b0 r0 = new dn4.b0
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 511(0x1ff, float:7.16E-43)
            r12 = 0
            r1 = r0
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            goto L18
        L17:
            r0 = r14
        L18:
            r1 = r16 & 2
            if (r1 == 0) goto L1f
            r1 = 0
            r2 = r13
            goto L21
        L1f:
            r2 = r13
            r1 = r15
        L21:
            r13.<init>(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: dn4.f.<init>(dn4.b0, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
