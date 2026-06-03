package gs4;

import com.bytedance.apm.util.CommonMonitorUtil;
import com.bytedance.covode.number.Covode;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {
    public static final int f;
    public final long a;
    public final long b;
    public final long c;
    public final boolean d;
    public final Map<String, Object> e;

    static {
        Covode.recordClassIndex(612312);
        f = 8;
    }

    public a() {
        this(0L, 0L, 0L, false, null, 31, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.a == aVar.a && this.b == aVar.b && this.c == aVar.c && this.d == aVar.d && Intrinsics.areEqual(this.e, aVar.e);
    }

    public int hashCode() {
        int a = ((((((j.a(this.a) * 31) + j.a(this.b)) * 31) + j.a(this.c)) * 31) + androidx.compose.animation.m.a(this.d)) * 31;
        Map<String, Object> map = this.e;
        return a + (map == null ? 0 : map.hashCode());
    }

    public String toString() {
        return "CpuInfo(timestamp=" + this.a + ", appCpuTime=" + this.b + ", totalCpuTime=" + this.c + ", hasAudioPlay=" + this.d + ", extras=" + this.e + ')';
    }

    public final double a(a endInfo) {
        Intrinsics.checkNotNullParameter(endInfo, "endInfo");
        if (endInfo.c - this.c > 0) {
            return (endInfo.b - this.b) / (r0 - r2);
        }
        return -1.0d;
    }

    public final double b(a endInfo) {
        Intrinsics.checkNotNullParameter(endInfo, "endInfo");
        if (endInfo.a - this.a > 0) {
            return (((endInfo.b - this.b) * 1000) / (r0 - r2)) / CommonMonitorUtil.getScClkTck(100L);
        }
        return -1.0d;
    }

    public a(long j, long j2, long j3, boolean z, Map<String, ? extends Object> map) {
        this.a = j;
        this.b = j2;
        this.c = j3;
        this.d = z;
        this.e = map;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ a(long r9, long r11, long r13, boolean r15, java.util.Map r16, int r17, kotlin.jvm.internal.DefaultConstructorMarker r18) {
        /*
            r8 = this;
            r0 = r17 & 1
            r1 = -1
            if (r0 == 0) goto L8
            r3 = r1
            goto L9
        L8:
            r3 = r9
        L9:
            r0 = r17 & 2
            if (r0 == 0) goto Lf
            r5 = r1
            goto L10
        Lf:
            r5 = r11
        L10:
            r0 = r17 & 4
            if (r0 == 0) goto L15
            goto L16
        L15:
            r1 = r13
        L16:
            r0 = r17 & 8
            if (r0 == 0) goto L1c
            r0 = 0
            goto L1d
        L1c:
            r0 = r15
        L1d:
            r7 = r17 & 16
            if (r7 == 0) goto L23
            r7 = 0
            goto L25
        L23:
            r7 = r16
        L25:
            r9 = r8
            r10 = r3
            r12 = r5
            r14 = r1
            r16 = r0
            r17 = r7
            r9.<init>(r10, r12, r14, r16, r17)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: gs4.a.<init>(long, long, long, boolean, java.util.Map, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
