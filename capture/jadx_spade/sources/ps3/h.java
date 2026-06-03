package ps3;

import android.content.Context;
import android.os.Bundle;
import androidx.compose.animation.m;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.Args;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class h {
    public final Object a;
    public final Integer b;
    public final boolean c;
    public final boolean d;
    public final boolean e;
    public final String f;
    public final Bundle g;
    public final int h;
    public final Args i;
    public final long j;
    public final int k;
    public final Context l;
    public final boolean m;
    public final Boolean n;
    public final Boolean o;
    public final String p;
    public final String q;
    public final int r;

    static {
        Covode.recordClassIndex(599033);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return Intrinsics.areEqual(this.a, hVar.a) && Intrinsics.areEqual(this.b, hVar.b) && this.c == hVar.c && this.d == hVar.d && this.e == hVar.e && Intrinsics.areEqual(this.f, hVar.f) && Intrinsics.areEqual(this.g, hVar.g) && this.h == hVar.h && Intrinsics.areEqual(this.i, hVar.i) && this.j == hVar.j && this.k == hVar.k && Intrinsics.areEqual(this.l, hVar.l) && this.m == hVar.m && Intrinsics.areEqual(this.n, hVar.n) && Intrinsics.areEqual(this.o, hVar.o) && Intrinsics.areEqual(this.p, hVar.p) && Intrinsics.areEqual(this.q, hVar.q) && this.r == hVar.r;
    }

    public int hashCode() {
        Object obj = this.a;
        int hashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        Integer num = this.b;
        int hashCode2 = (((((((((hashCode + (num == null ? 0 : num.hashCode())) * 31) + m.a(this.c)) * 31) + m.a(this.d)) * 31) + m.a(this.e)) * 31) + this.f.hashCode()) * 31;
        Bundle bundle = this.g;
        int hashCode3 = (((hashCode2 + (bundle == null ? 0 : bundle.hashCode())) * 31) + this.h) * 31;
        Args args = this.i;
        int hashCode4 = (((((hashCode3 + (args == null ? 0 : args.hashCode())) * 31) + j.a(this.j)) * 31) + this.k) * 31;
        Context context = this.l;
        int hashCode5 = (((hashCode4 + (context == null ? 0 : context.hashCode())) * 31) + m.a(this.m)) * 31;
        Boolean bool = this.n;
        int hashCode6 = (hashCode5 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.o;
        int hashCode7 = (hashCode6 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        String str = this.p;
        int hashCode8 = (hashCode7 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.q;
        return ((hashCode8 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.r;
    }

    public String toString() {
        return "VideoFeedShortSeriesLaunchConfig(data=" + this.a + ", tabType=" + this.b + ", coldStartSeries=" + this.c + ", needUnlock=" + this.d + ", isNext=" + this.e + ", forceVid=" + this.f + ", extraBundle=" + this.g + ", currentSelectPosition=" + this.h + ", reportArgs=" + this.i + ", currentPlaybackTime=" + this.j + ", currentVideoProgress=" + this.k + ", context=" + this.l + ", isAutoShowCatalogDialog=" + this.m + ", enableStartAnimation=" + this.n + ", enableEnterAlphaAnimation=" + this.o + ", filterType=" + this.p + ", filterTagNames=" + this.q + ", traceFrom=" + this.r + ')';
    }

    public final Context getContext() {
        return this.l;
    }

    public h(Object obj, Integer num, boolean z, boolean z2, boolean z3, String forceVid, Bundle bundle, int i, Args args, long j, int i2, Context context, boolean z4, Boolean bool, Boolean bool2, String str, String str2, int i3) {
        Intrinsics.checkNotNullParameter(forceVid, "forceVid");
        this.a = obj;
        this.b = num;
        this.c = z;
        this.d = z2;
        this.e = z3;
        this.f = forceVid;
        this.g = bundle;
        this.h = i;
        this.i = args;
        this.j = j;
        this.k = i2;
        this.l = context;
        this.m = z4;
        this.n = bool;
        this.o = bool2;
        this.p = str;
        this.q = str2;
        this.r = i3;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ h(java.lang.Object r20, java.lang.Integer r21, boolean r22, boolean r23, boolean r24, java.lang.String r25, android.os.Bundle r26, int r27, com.dragon.read.base.Args r28, long r29, int r31, android.content.Context r32, boolean r33, java.lang.Boolean r34, java.lang.Boolean r35, java.lang.String r36, java.lang.String r37, int r38, int r39, kotlin.jvm.internal.DefaultConstructorMarker r40) {
        /*
            Method dump skipped, instructions count: 200
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ps3.h.<init>(java.lang.Object, java.lang.Integer, boolean, boolean, boolean, java.lang.String, android.os.Bundle, int, com.dragon.read.base.Args, long, int, android.content.Context, boolean, java.lang.Boolean, java.lang.Boolean, java.lang.String, java.lang.String, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
