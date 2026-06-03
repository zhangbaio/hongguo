package qs3;

import androidx.compose.animation.m;
import com.bytedance.covode.number.Covode;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b {
    public final List<com.dragon.read.component.shortvideo.data.saas.video.d> a;
    public final int b;
    public final boolean c;
    public final boolean d;
    public final boolean e;
    public final long f;
    public final int g;
    public final boolean h;

    static {
        Covode.recordClassIndex(599045);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return Intrinsics.areEqual(this.a, bVar.a) && this.b == bVar.b && this.c == bVar.c && this.d == bVar.d && this.e == bVar.e && this.f == bVar.f && this.g == bVar.g && this.h == bVar.h;
    }

    public int hashCode() {
        return (((((((((((((this.a.hashCode() * 31) + this.b) * 31) + m.a(this.c)) * 31) + m.a(this.d)) * 31) + m.a(this.e)) * 31) + j.a(this.f)) * 31) + this.g) * 31) + m.a(this.h);
    }

    public String toString() {
        return "ExitReplaceRecommendVideoEvent(recommendVideoDataList=" + this.a + ", curVideoPosition=" + this.b + ", onlyBringBack=" + this.c + ", onlyOneData=" + this.d + ", isSeriesChanged=" + this.e + ", internalSource=" + this.f + ", tabType=" + this.g + ", onlyRefreshPugcSeriesBottomBar=" + this.h + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(List<? extends com.dragon.read.component.shortvideo.data.saas.video.d> recommendVideoDataList, int i, boolean z, boolean z2, boolean z3, long j, int i2, boolean z4) {
        Intrinsics.checkNotNullParameter(recommendVideoDataList, "recommendVideoDataList");
        this.a = recommendVideoDataList;
        this.b = i;
        this.c = z;
        this.d = z2;
        this.e = z3;
        this.f = j;
        this.g = i2;
        this.h = z4;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ b(java.util.List r14, int r15, boolean r16, boolean r17, boolean r18, long r19, int r21, boolean r22, int r23, kotlin.jvm.internal.DefaultConstructorMarker r24) {
        /*
            r13 = this;
            r0 = r23
            r1 = r0 & 64
            r2 = 0
            if (r1 == 0) goto L9
            r11 = 0
            goto Lb
        L9:
            r11 = r21
        Lb:
            r0 = r0 & 128(0x80, float:1.8E-43)
            if (r0 == 0) goto L11
            r12 = 0
            goto L13
        L11:
            r12 = r22
        L13:
            r3 = r13
            r4 = r14
            r5 = r15
            r6 = r16
            r7 = r17
            r8 = r18
            r9 = r19
            r3.<init>(r4, r5, r6, r7, r8, r9, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: qs3.b.<init>(java.util.List, int, boolean, boolean, boolean, long, int, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
