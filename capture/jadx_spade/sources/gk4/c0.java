package gk4;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class c0 implements f {
    public static final int f;
    private final long a;
    public final String b;
    public final String c;
    public final String d;
    public final ym4.k e;

    static {
        Covode.recordClassIndex(607821);
        f = ym4.k.f;
    }

    @Override // gk4.f
    public long a() {
        return this.a;
    }

    public c0(long j, String seriesId, String entrance, String str, ym4.k kVar) {
        Intrinsics.checkNotNullParameter(seriesId, "seriesId");
        Intrinsics.checkNotNullParameter(entrance, "entrance");
        this.a = j;
        this.b = seriesId;
        this.c = entrance;
        this.d = str;
        this.e = kVar;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ c0(long r8, java.lang.String r10, java.lang.String r11, java.lang.String r12, ym4.k r13, int r14, kotlin.jvm.internal.DefaultConstructorMarker r15) {
        /*
            r7 = this;
            r15 = r14 & 1
            if (r15 == 0) goto L6
            r8 = 0
        L6:
            r1 = r8
            r8 = r14 & 2
            java.lang.String r9 = ""
            if (r8 == 0) goto Lf
            r3 = r9
            goto L10
        Lf:
            r3 = r10
        L10:
            r8 = r14 & 4
            if (r8 == 0) goto L16
            r4 = r9
            goto L17
        L16:
            r4 = r11
        L17:
            r8 = r14 & 8
            r9 = 0
            if (r8 == 0) goto L1e
            r5 = r9
            goto L1f
        L1e:
            r5 = r12
        L1f:
            r8 = r14 & 16
            if (r8 == 0) goto L25
            r6 = r9
            goto L26
        L25:
            r6 = r13
        L26:
            r0 = r7
            r0.<init>(r1, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: gk4.c0.<init>(long, java.lang.String, java.lang.String, java.lang.String, ym4.k, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
