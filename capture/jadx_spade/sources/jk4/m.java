package jk4;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class m {
    public final boolean a;
    public final int b;
    public final androidx.compose.ui.graphics.l0 c;
    public final androidx.compose.ui.graphics.l0 d;
    public final u0 e;

    static {
        Covode.recordClassIndex(607872);
    }

    public /* synthetic */ m(boolean z, int i, androidx.compose.ui.graphics.l0 l0Var, androidx.compose.ui.graphics.l0 l0Var2, u0 u0Var, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, i, l0Var, l0Var2, u0Var);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return this.a == mVar.a && this.b == mVar.b && Intrinsics.areEqual(this.c, mVar.c) && Intrinsics.areEqual(this.d, mVar.d) && Intrinsics.areEqual(this.e, mVar.e);
    }

    public int hashCode() {
        int a = ((androidx.compose.animation.m.a(this.a) * 31) + this.b) * 31;
        androidx.compose.ui.graphics.l0 l0Var = this.c;
        int v = (a + (l0Var == null ? 0 : androidx.compose.ui.graphics.l0.v(l0Var.x()))) * 31;
        androidx.compose.ui.graphics.l0 l0Var2 = this.d;
        int v2 = (v + (l0Var2 == null ? 0 : androidx.compose.ui.graphics.l0.v(l0Var2.x()))) * 31;
        u0 u0Var = this.e;
        return v2 + (u0Var != null ? u0Var.hashCode() : 0);
    }

    public String toString() {
        return "NpsCardUiConfig(needDelete=" + this.a + ", topPadding=" + this.b + ", cardBackgroundColor=" + this.c + ", titleTextColor=" + this.d + ", similarNpsCardItemUiConfig=" + this.e + ')';
    }

    private m(boolean z, int i, androidx.compose.ui.graphics.l0 l0Var, androidx.compose.ui.graphics.l0 l0Var2, u0 u0Var) {
        this.a = z;
        this.b = i;
        this.c = l0Var;
        this.d = l0Var2;
        this.e = u0Var;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ m(boolean r8, int r9, androidx.compose.ui.graphics.l0 r10, androidx.compose.ui.graphics.l0 r11, jk4.u0 r12, int r13, kotlin.jvm.internal.DefaultConstructorMarker r14) {
        /*
            r7 = this;
            r14 = r13 & 1
            if (r14 == 0) goto L7
            r8 = 0
            r1 = 0
            goto L8
        L7:
            r1 = r8
        L8:
            r8 = r13 & 2
            if (r8 == 0) goto L11
            r9 = 12
            r2 = 12
            goto L12
        L11:
            r2 = r9
        L12:
            r8 = r13 & 4
            r9 = 0
            if (r8 == 0) goto L19
            r3 = r9
            goto L1a
        L19:
            r3 = r10
        L1a:
            r8 = r13 & 8
            if (r8 == 0) goto L20
            r4 = r9
            goto L21
        L20:
            r4 = r11
        L21:
            r8 = r13 & 16
            if (r8 == 0) goto L27
            r5 = r9
            goto L28
        L27:
            r5 = r12
        L28:
            r6 = 0
            r0 = r7
            r0.<init>(r1, r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: jk4.m.<init>(boolean, int, androidx.compose.ui.graphics.l0, androidx.compose.ui.graphics.l0, jk4.u0, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
