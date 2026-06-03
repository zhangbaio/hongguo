package kotlinx.datetime.format;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.datetime.internal.format.SignedIntFieldFormatDirective;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class p2 extends SignedIntFieldFormatDirective<g> {
    private final Padding f;
    private final boolean g;

    static {
        Covode.recordClassIndex(659578);
    }

    public int hashCode() {
        return (this.f.hashCode() * 31) + androidx.compose.animation.m.a(this.g);
    }

    public boolean equals(Object obj) {
        if (obj instanceof p2) {
            p2 p2Var = (p2) obj;
            if (this.f == p2Var.f && this.g == p2Var.g) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public p2(kotlinx.datetime.format.Padding r8, boolean r9) {
        /*
            r7 = this;
            java.lang.String r0 = "padding"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            kotlinx.datetime.format.DateFields r0 = kotlinx.datetime.format.DateFields.a
            kotlinx.datetime.internal.format.p r2 = r0.d()
            kotlinx.datetime.format.Padding r0 = kotlinx.datetime.format.Padding.ZERO
            r1 = 4
            java.lang.Integer r6 = java.lang.Integer.valueOf(r1)
            if (r8 != r0) goto L15
            goto L16
        L15:
            r1 = 1
        L16:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r1)
            r4 = 0
            kotlinx.datetime.format.Padding r0 = kotlinx.datetime.format.Padding.SPACE
            if (r8 != r0) goto L21
            r5 = r6
            goto L23
        L21:
            r0 = 0
            r5 = r0
        L23:
            r1 = r7
            r1.<init>(r2, r3, r4, r5, r6)
            r7.f = r8
            r7.g = r9
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.datetime.format.p2.<init>(kotlinx.datetime.format.Padding, boolean):void");
    }

    public /* synthetic */ p2(Padding padding, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(padding, (i & 2) != 0 ? false : z);
    }
}
