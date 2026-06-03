package kotlinx.datetime.format;

import com.bytedance.covode.number.Covode;
import kotlinx.datetime.internal.format.UnsignedIntFieldFormatDirective;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class c1 extends UnsignedIntFieldFormatDirective<g> {
    private final Padding e;

    static {
        Covode.recordClassIndex(659502);
    }

    public int hashCode() {
        return this.e.hashCode();
    }

    public boolean equals(Object obj) {
        if ((obj instanceof c1) && this.e == ((c1) obj).e) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public c1(kotlinx.datetime.format.Padding r5) {
        /*
            r4 = this;
            java.lang.String r0 = "padding"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            kotlinx.datetime.format.DateFields r0 = kotlinx.datetime.format.DateFields.a
            kotlinx.datetime.internal.format.x r0 = r0.c()
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
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.datetime.format.c1.<init>(kotlinx.datetime.format.Padding):void");
    }
}
