package pr3;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.api.model.PrefetchScope;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class n {
    public final String a;
    public final q b;
    public final int c;
    public final o d;
    public PrefetchScope e;

    static {
        Covode.recordClassIndex(598792);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return Intrinsics.areEqual(this.a, nVar.a) && Intrinsics.areEqual(this.b, nVar.b) && this.c == nVar.c && Intrinsics.areEqual(this.d, nVar.d) && this.e == nVar.e;
    }

    public int hashCode() {
        int hashCode = this.a.hashCode() * 31;
        q qVar = this.b;
        int hashCode2 = (((hashCode + (qVar == null ? 0 : qVar.hashCode())) * 31) + this.c) * 31;
        o oVar = this.d;
        return ((hashCode2 + (oVar != null ? oVar.hashCode() : 0)) * 31) + this.e.hashCode();
    }

    public String toString() {
        return "SeriesIdWithHighlightModel(seriesId=" + this.a + ", highlightModel=" + this.b + ", entrance=" + this.c + ", serverDnsConfig=" + this.d + ", prefetchScope=" + this.e + ')';
    }

    public final void a(PrefetchScope prefetchScope) {
        Intrinsics.checkNotNullParameter(prefetchScope, "<set-?>");
        this.e = prefetchScope;
    }

    public n(String seriesId, q qVar, int i, o oVar, PrefetchScope prefetchScope) {
        Intrinsics.checkNotNullParameter(seriesId, "seriesId");
        Intrinsics.checkNotNullParameter(prefetchScope, "prefetchScope");
        this.a = seriesId;
        this.b = qVar;
        this.c = i;
        this.d = oVar;
        this.e = prefetchScope;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ n(java.lang.String r8, pr3.q r9, int r10, pr3.o r11, com.dragon.read.component.shortvideo.api.model.PrefetchScope r12, int r13, kotlin.jvm.internal.DefaultConstructorMarker r14) {
        /*
            r7 = this;
            r14 = r13 & 2
            r0 = 0
            if (r14 == 0) goto L7
            r3 = r0
            goto L8
        L7:
            r3 = r9
        L8:
            r9 = r13 & 8
            if (r9 == 0) goto Le
            r5 = r0
            goto Lf
        Le:
            r5 = r11
        Lf:
            r9 = r13 & 16
            if (r9 == 0) goto L15
            com.dragon.read.component.shortvideo.api.model.PrefetchScope r12 = com.dragon.read.component.shortvideo.api.model.PrefetchScope.OTHER
        L15:
            r6 = r12
            r1 = r7
            r2 = r8
            r4 = r10
            r1.<init>(r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: pr3.n.<init>(java.lang.String, pr3.q, int, pr3.o, com.dragon.read.component.shortvideo.api.model.PrefetchScope, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
