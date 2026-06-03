package jk4;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class u0 {
    public final androidx.compose.ui.graphics.l0 a;
    public final androidx.compose.ui.graphics.l0 b;
    public final androidx.compose.ui.graphics.l0 c;
    public final androidx.compose.ui.graphics.l0 d;

    static {
        Covode.recordClassIndex(607884);
    }

    public /* synthetic */ u0(androidx.compose.ui.graphics.l0 l0Var, androidx.compose.ui.graphics.l0 l0Var2, androidx.compose.ui.graphics.l0 l0Var3, androidx.compose.ui.graphics.l0 l0Var4, DefaultConstructorMarker defaultConstructorMarker) {
        this(l0Var, l0Var2, l0Var3, l0Var4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof u0)) {
            return false;
        }
        u0 u0Var = (u0) obj;
        return Intrinsics.areEqual(this.a, u0Var.a) && Intrinsics.areEqual(this.b, u0Var.b) && Intrinsics.areEqual(this.c, u0Var.c) && Intrinsics.areEqual(this.d, u0Var.d);
    }

    public int hashCode() {
        androidx.compose.ui.graphics.l0 l0Var = this.a;
        int v = (l0Var == null ? 0 : androidx.compose.ui.graphics.l0.v(l0Var.x())) * 31;
        androidx.compose.ui.graphics.l0 l0Var2 = this.b;
        int v2 = (v + (l0Var2 == null ? 0 : androidx.compose.ui.graphics.l0.v(l0Var2.x()))) * 31;
        androidx.compose.ui.graphics.l0 l0Var3 = this.c;
        int v3 = (v2 + (l0Var3 == null ? 0 : androidx.compose.ui.graphics.l0.v(l0Var3.x()))) * 31;
        androidx.compose.ui.graphics.l0 l0Var4 = this.d;
        return v3 + (l0Var4 != null ? androidx.compose.ui.graphics.l0.v(l0Var4.x()) : 0);
    }

    public String toString() {
        return "SimilarNpsCardItemUiConfig(itemBackgroundColor=" + this.a + ", itemTextColor=" + this.b + ", itemSelectedBackgroundColor=" + this.c + ", itemSelectedTextColor=" + this.d + ')';
    }

    private u0(androidx.compose.ui.graphics.l0 l0Var, androidx.compose.ui.graphics.l0 l0Var2, androidx.compose.ui.graphics.l0 l0Var3, androidx.compose.ui.graphics.l0 l0Var4) {
        this.a = l0Var;
        this.b = l0Var2;
        this.c = l0Var3;
        this.d = l0Var4;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ u0(androidx.compose.ui.graphics.l0 r8, androidx.compose.ui.graphics.l0 r9, androidx.compose.ui.graphics.l0 r10, androidx.compose.ui.graphics.l0 r11, int r12, kotlin.jvm.internal.DefaultConstructorMarker r13) {
        /*
            r7 = this;
            r13 = r12 & 1
            r0 = 0
            if (r13 == 0) goto L7
            r2 = r0
            goto L8
        L7:
            r2 = r8
        L8:
            r8 = r12 & 2
            if (r8 == 0) goto Le
            r3 = r0
            goto Lf
        Le:
            r3 = r9
        Lf:
            r8 = r12 & 4
            if (r8 == 0) goto L15
            r4 = r0
            goto L16
        L15:
            r4 = r10
        L16:
            r8 = r12 & 8
            if (r8 == 0) goto L1c
            r5 = r0
            goto L1d
        L1c:
            r5 = r11
        L1d:
            r6 = 0
            r1 = r7
            r1.<init>(r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: jk4.u0.<init>(androidx.compose.ui.graphics.l0, androidx.compose.ui.graphics.l0, androidx.compose.ui.graphics.l0, androidx.compose.ui.graphics.l0, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
