package kotlinx.datetime.format;

import com.bytedance.covode.number.Covode;
import kotlinx.datetime.internal.format.UnsignedIntFieldFormatDirective;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class d0 extends UnsignedIntFieldFormatDirective<g1> {
    private final Padding e;

    static {
        Covode.recordClassIndex(659482);
    }

    public int hashCode() {
        return this.e.hashCode();
    }

    public boolean equals(Object obj) {
        if ((obj instanceof d0) && this.e == ((d0) obj).e) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public d0(kotlinx.datetime.format.Padding r5) {
        /*
            r4 = this;
            java.lang.String r0 = "padding"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            kotlinx.datetime.format.TimeFields r0 = kotlinx.datetime.format.TimeFields.a
            kotlinx.datetime.internal.format.x r0 = r0.b()
            kotlinx.datetime.format.Padding r1 = kotlinx.datetime.format.Padding.ZERO
            r2 = 2
            if (r5 != r1) goto L12
            r1 = 2
            goto L13
        L12:
            r1 = 1
        L13:
            kotlinx.datetime.format.Padding r3 = kotlinx.datetime.format.Padding.SPACE
            if (r5 != r3) goto L1c
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L1d
        L1c:
            r2 = 0
        L1d:
            r4.<init>(r0, r1, r2)
            r4.e = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.datetime.format.d0.<init>(kotlinx.datetime.format.Padding):void");
    }
}
