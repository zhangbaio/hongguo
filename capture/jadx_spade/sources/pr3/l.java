package pr3;

import com.bytedance.covode.number.Covode;
import com.dragon.read.base.Args;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class l {
    public final String a;
    public final String b;
    public final boolean c;
    public final boolean d;
    public final Args e;
    public c f;

    static {
        Covode.recordClassIndex(598789);
    }

    public l(String position, String collectPosition, boolean z, boolean z2, Args args) {
        Intrinsics.checkNotNullParameter(position, "position");
        Intrinsics.checkNotNullParameter(collectPosition, "collectPosition");
        this.a = position;
        this.b = collectPosition;
        this.c = z;
        this.d = z2;
        this.e = args;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ l(java.lang.String r8, java.lang.String r9, boolean r10, boolean r11, com.dragon.read.base.Args r12, int r13, kotlin.jvm.internal.DefaultConstructorMarker r14) {
        /*
            r7 = this;
            r14 = r13 & 4
            r0 = 0
            if (r14 == 0) goto L7
            r4 = 0
            goto L8
        L7:
            r4 = r10
        L8:
            r10 = r13 & 8
            if (r10 == 0) goto Le
            r5 = 0
            goto Lf
        Le:
            r5 = r11
        Lf:
            r10 = r13 & 16
            if (r10 == 0) goto L14
            r12 = 0
        L14:
            r6 = r12
            r1 = r7
            r2 = r8
            r3 = r9
            r1.<init>(r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: pr3.l.<init>(java.lang.String, java.lang.String, boolean, boolean, com.dragon.read.base.Args, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
