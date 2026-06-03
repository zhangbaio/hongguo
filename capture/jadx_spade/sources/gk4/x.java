package gk4;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class x {
    public static final int u = 0;
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final boolean e;
    public final int f;
    public final int g;
    public final int h;
    public final long i;
    public final int j;
    public final int k;
    public final int l;
    public final String m;
    public final boolean n;
    public final boolean o;
    public final String p;
    public final String q;
    public final int r;
    public final String s;
    public final String t;

    static {
        Covode.recordClassIndex(607813);
    }

    public x() {
        this(null, null, null, null, false, 0, 0, 0, 0L, 0, 0, 0, null, false, false, null, null, 0, null, null, 1048575, null);
    }

    public final x a(String itemId, String coverUrl, String name, String subInfo, boolean z, int i, int i2, int i3, long j, int i4, int i5, int i6, String genre, boolean z2, boolean z3, String postScheme, String postId, int i7, String srcMaterialId, String disableClickToast) {
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        Intrinsics.checkNotNullParameter(coverUrl, "coverUrl");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(subInfo, "subInfo");
        Intrinsics.checkNotNullParameter(genre, "genre");
        Intrinsics.checkNotNullParameter(postScheme, "postScheme");
        Intrinsics.checkNotNullParameter(postId, "postId");
        Intrinsics.checkNotNullParameter(srcMaterialId, "srcMaterialId");
        Intrinsics.checkNotNullParameter(disableClickToast, "disableClickToast");
        return new x(itemId, coverUrl, name, subInfo, z, i, i2, i3, j, i4, i5, i6, genre, z2, z3, postScheme, postId, i7, srcMaterialId, disableClickToast);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof x)) {
            return false;
        }
        x xVar = (x) obj;
        return Intrinsics.areEqual(this.a, xVar.a) && Intrinsics.areEqual(this.b, xVar.b) && Intrinsics.areEqual(this.c, xVar.c) && Intrinsics.areEqual(this.d, xVar.d) && this.e == xVar.e && this.f == xVar.f && this.g == xVar.g && this.h == xVar.h && this.i == xVar.i && this.j == xVar.j && this.k == xVar.k && this.l == xVar.l && Intrinsics.areEqual(this.m, xVar.m) && this.n == xVar.n && this.o == xVar.o && Intrinsics.areEqual(this.p, xVar.p) && Intrinsics.areEqual(this.q, xVar.q) && this.r == xVar.r && Intrinsics.areEqual(this.s, xVar.s) && Intrinsics.areEqual(this.t, xVar.t);
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + androidx.compose.animation.m.a(this.e)) * 31) + this.f) * 31) + this.g) * 31) + this.h) * 31) + j.a(this.i)) * 31) + this.j) * 31) + this.k) * 31) + this.l) * 31) + this.m.hashCode()) * 31) + androidx.compose.animation.m.a(this.n)) * 31) + androidx.compose.animation.m.a(this.o)) * 31) + this.p.hashCode()) * 31) + this.q.hashCode()) * 31) + this.r) * 31) + this.s.hashCode()) * 31) + this.t.hashCode();
    }

    public String toString() {
        return "IFilterListItem(itemId=" + this.a + ", coverUrl=" + this.b + ", name=" + this.c + ", subInfo=" + this.d + ", isInBookshelf=" + this.e + ", bookType=" + this.f + ", consumeChapterCount=" + this.g + ", totalChapterCount=" + this.h + ", updateTime=" + this.i + ", bookStatus=" + this.j + ", creationStatus=" + this.k + ", genreType=" + this.l + ", genre=" + this.m + ", isDownloaded=" + this.n + ", isVip=" + this.o + ", postScheme=" + this.p + ", postId=" + this.q + ", videoContentType=" + this.r + ", srcMaterialId=" + this.s + ", disableClickToast=" + this.t + ')';
    }

    public x(String itemId, String coverUrl, String name, String subInfo, boolean z, int i, int i2, int i3, long j, int i4, int i5, int i6, String genre, boolean z2, boolean z3, String postScheme, String postId, int i7, String srcMaterialId, String disableClickToast) {
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        Intrinsics.checkNotNullParameter(coverUrl, "coverUrl");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(subInfo, "subInfo");
        Intrinsics.checkNotNullParameter(genre, "genre");
        Intrinsics.checkNotNullParameter(postScheme, "postScheme");
        Intrinsics.checkNotNullParameter(postId, "postId");
        Intrinsics.checkNotNullParameter(srcMaterialId, "srcMaterialId");
        Intrinsics.checkNotNullParameter(disableClickToast, "disableClickToast");
        this.a = itemId;
        this.b = coverUrl;
        this.c = name;
        this.d = subInfo;
        this.e = z;
        this.f = i;
        this.g = i2;
        this.h = i3;
        this.i = j;
        this.j = i4;
        this.k = i5;
        this.l = i6;
        this.m = genre;
        this.n = z2;
        this.o = z3;
        this.p = postScheme;
        this.q = postId;
        this.r = i7;
        this.s = srcMaterialId;
        this.t = disableClickToast;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ x(java.lang.String r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, boolean r27, int r28, int r29, int r30, long r31, int r33, int r34, int r35, java.lang.String r36, boolean r37, boolean r38, java.lang.String r39, java.lang.String r40, int r41, java.lang.String r42, java.lang.String r43, int r44, kotlin.jvm.internal.DefaultConstructorMarker r45) {
        /*
            Method dump skipped, instructions count: 231
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: gk4.x.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean, int, int, int, long, int, int, int, java.lang.String, boolean, boolean, java.lang.String, java.lang.String, int, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
