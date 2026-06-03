package com.dragon.read.kmp.widget;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class c {
    public static final int g = 0;
    public final String a;
    public final float b;
    public final float c;
    public final float d;
    public final float e;
    public final boolean f;

    static {
        Covode.recordClassIndex(609626);
    }

    public /* synthetic */ c(String str, float f, float f2, float f3, float f4, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, f, f2, f3, f4, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return Intrinsics.areEqual(this.a, cVar.a) && x0.i.i(this.b, cVar.b) && x0.i.i(this.c, cVar.c) && x0.i.i(this.d, cVar.d) && x0.i.i(this.e, cVar.e) && this.f == cVar.f;
    }

    public int hashCode() {
        return (((((((((this.a.hashCode() * 31) + x0.i.k(this.b)) * 31) + x0.i.k(this.c)) * 31) + x0.i.k(this.d)) * 31) + x0.i.k(this.e)) * 31) + androidx.compose.animation.m.a(this.f);
    }

    public String toString() {
        return "AudioIconCoverConfig(coverUrl=" + this.a + ", cardWidth=" + ((Object) x0.i.l(this.b)) + ", cardHeight=" + ((Object) x0.i.l(this.c)) + ", cornerRadius=" + ((Object) x0.i.l(this.d)) + ", iconSize=" + ((Object) x0.i.l(this.e)) + ", isPlaying=" + this.f + ')';
    }

    private c(String coverUrl, float f, float f2, float f3, float f4, boolean z) {
        Intrinsics.checkNotNullParameter(coverUrl, "coverUrl");
        this.a = coverUrl;
        this.b = f;
        this.c = f2;
        this.d = f3;
        this.e = f4;
        this.f = z;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ c(java.lang.String r10, float r11, float r12, float r13, float r14, boolean r15, int r16, kotlin.jvm.internal.DefaultConstructorMarker r17) {
        /*
            r9 = this;
            r0 = r16 & 32
            if (r0 == 0) goto L7
            r0 = 0
            r7 = 0
            goto L8
        L7:
            r7 = r15
        L8:
            r8 = 0
            r1 = r9
            r2 = r10
            r3 = r11
            r4 = r12
            r5 = r13
            r6 = r14
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.widget.c.<init>(java.lang.String, float, float, float, float, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
