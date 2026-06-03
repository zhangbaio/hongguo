package ws3;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class q {
    public final long a;
    public final String b;
    public final long c;

    static {
        Covode.recordClassIndex(599168);
    }

    public q() {
        this(0L, null, 0L, 7, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        return this.a == qVar.a && Intrinsics.areEqual(this.b, qVar.b) && this.c == qVar.c;
    }

    public int hashCode() {
        return (((j.a(this.a) * 31) + this.b.hashCode()) * 31) + j.a(this.c);
    }

    public String toString() {
        return "VideoMediaInfo(size=" + this.a + ", format=" + this.b + ", duration=" + this.c + ')';
    }

    public q(long j, String format, long j2) {
        Intrinsics.checkNotNullParameter(format, "format");
        this.a = j;
        this.b = format;
        this.c = j2;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ q(long r5, java.lang.String r7, long r8, int r10, kotlin.jvm.internal.DefaultConstructorMarker r11) {
        /*
            r4 = this;
            r11 = r10 & 1
            r0 = 0
            if (r11 == 0) goto L8
            r2 = r0
            goto L9
        L8:
            r2 = r5
        L9:
            r5 = r10 & 2
            if (r5 == 0) goto Lf
            java.lang.String r7 = ""
        Lf:
            r11 = r7
            r5 = r10 & 4
            if (r5 == 0) goto L16
            r9 = r0
            goto L17
        L16:
            r9 = r8
        L17:
            r5 = r4
            r6 = r2
            r8 = r11
            r5.<init>(r6, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ws3.q.<init>(long, java.lang.String, long, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
