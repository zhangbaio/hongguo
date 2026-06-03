package rs3;

import androidx.compose.animation.m;
import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class h {
    public final String a;
    public final int b;
    public final int c;
    public final int d;
    public final boolean e;
    public final boolean f;

    static {
        Covode.recordClassIndex(599063);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return Intrinsics.areEqual(this.a, hVar.a) && this.b == hVar.b && this.c == hVar.c && this.d == hVar.d && this.e == hVar.e && this.f == hVar.f;
    }

    public int hashCode() {
        return (((((((((this.a.hashCode() * 31) + this.b) * 31) + this.c) * 31) + this.d) * 31) + m.a(this.e)) * 31) + m.a(this.f);
    }

    public String toString() {
        return "RefreshDoneEvent(scene=" + this.a + ", tabType=" + this.b + ", bottomTabType=" + this.c + ", refreshType=" + this.d + ", isSuccess=" + this.e + ", isFromRecommend=" + this.f + ')';
    }

    public h(String scene, int i, int i2, int i3, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        this.a = scene;
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = z;
        this.f = z2;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ h(java.lang.String r8, int r9, int r10, int r11, boolean r12, boolean r13, int r14, kotlin.jvm.internal.DefaultConstructorMarker r15) {
        /*
            r7 = this;
            r14 = r14 & 16
            if (r14 == 0) goto L7
            r12 = 1
            r5 = 1
            goto L8
        L7:
            r5 = r12
        L8:
            r0 = r7
            r1 = r8
            r2 = r9
            r3 = r10
            r4 = r11
            r6 = r13
            r0.<init>(r1, r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: rs3.h.<init>(java.lang.String, int, int, int, boolean, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
