package gk4;

import com.bytedance.covode.number.Covode;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b0 {
    public static final int g;
    public final int a;
    public final String b;
    public final boolean c;
    public final long d;
    public final String e;
    public final Map<String, String> f;

    static {
        Covode.recordClassIndex(607818);
        g = 8;
    }

    public b0() {
        this(0, null, false, 0L, null, null, 63, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b0)) {
            return false;
        }
        b0 b0Var = (b0) obj;
        return this.a == b0Var.a && Intrinsics.areEqual(this.b, b0Var.b) && this.c == b0Var.c && this.d == b0Var.d && Intrinsics.areEqual(this.e, b0Var.e) && Intrinsics.areEqual(this.f, b0Var.f);
    }

    public int hashCode() {
        int hashCode = ((((((((this.a * 31) + this.b.hashCode()) * 31) + androidx.compose.animation.m.a(this.c)) * 31) + j.a(this.d)) * 31) + this.e.hashCode()) * 31;
        Map<String, String> map = this.f;
        return hashCode + (map == null ? 0 : map.hashCode());
    }

    public String toString() {
        return "LikeStateChangeObserverModel(type=" + this.a + ", targetId=" + this.b + ", isLike=" + this.c + ", likeCount=" + this.d + ", seriesId=" + this.e + ", extra=" + this.f + ')';
    }

    public final int getType() {
        return this.a;
    }

    public b0(int i, String targetId, boolean z, long j, String seriesId, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(targetId, "targetId");
        Intrinsics.checkNotNullParameter(seriesId, "seriesId");
        this.a = i;
        this.b = targetId;
        this.c = z;
        this.d = j;
        this.e = seriesId;
        this.f = map;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ b0(int r6, java.lang.String r7, boolean r8, long r9, java.lang.String r11, java.util.Map r12, int r13, kotlin.jvm.internal.DefaultConstructorMarker r14) {
        /*
            r5 = this;
            r14 = r13 & 1
            r0 = 0
            if (r14 == 0) goto L7
            r14 = 0
            goto L8
        L7:
            r14 = r6
        L8:
            r6 = r13 & 2
            java.lang.String r1 = ""
            if (r6 == 0) goto L10
            r2 = r1
            goto L11
        L10:
            r2 = r7
        L11:
            r6 = r13 & 4
            if (r6 == 0) goto L16
            goto L17
        L16:
            r0 = r8
        L17:
            r6 = r13 & 8
            if (r6 == 0) goto L1d
            r9 = 0
        L1d:
            r3 = r9
            r6 = r13 & 16
            if (r6 == 0) goto L23
            goto L24
        L23:
            r1 = r11
        L24:
            r6 = r13 & 32
            if (r6 == 0) goto L2c
            java.util.Map r12 = kotlin.collections.MapsKt.emptyMap()
        L2c:
            r13 = r12
            r6 = r5
            r7 = r14
            r8 = r2
            r9 = r0
            r10 = r3
            r12 = r1
            r6.<init>(r7, r8, r9, r10, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: gk4.b0.<init>(int, java.lang.String, boolean, long, java.lang.String, java.util.Map, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
