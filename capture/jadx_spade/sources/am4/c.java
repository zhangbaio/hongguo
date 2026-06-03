package am4;

import android.content.Context;
import androidx.compose.animation.m;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.k;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import x0.i;
import x0.j;
import x0.w;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class c {
    public static final int x;
    public final Context a;
    public final boolean b;
    public final float c;
    public final float d;
    public final boolean e;
    public final boolean f;
    public final boolean g;
    public final float h;
    public final float i;
    public final float j;
    public final float k;
    public final float l;
    public final float m;
    public final long n;
    public final long o;
    public final long p;
    public final long q;
    public final float r;
    public final long s;
    public final long t;
    public final float u;
    public final long v;
    public final float w;

    static {
        Covode.recordClassIndex(608264);
        x = 8;
    }

    public /* synthetic */ c(Context context, boolean z, float f, float f2, boolean z2, boolean z3, boolean z4, float f3, float f4, float f5, float f6, float f7, float f8, long j, long j2, long j3, long j4, float f9, long j5, long j6, float f10, long j7, float f11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, z, f, f2, z2, z3, z4, f3, f4, f5, f6, f7, f8, j, j2, j3, j4, f9, j5, j6, f10, j7, f11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return Intrinsics.areEqual(this.a, cVar.a) && this.b == cVar.b && i.i(this.c, cVar.c) && i.i(this.d, cVar.d) && this.e == cVar.e && this.f == cVar.f && this.g == cVar.g && i.i(this.h, cVar.h) && i.i(this.i, cVar.i) && i.i(this.j, cVar.j) && i.i(this.k, cVar.k) && i.i(this.l, cVar.l) && i.i(this.m, cVar.m) && w.e(this.n, cVar.n) && w.e(this.o, cVar.o) && w.e(this.p, cVar.p) && w.e(this.q, cVar.q) && i.i(this.r, cVar.r) && w.e(this.s, cVar.s) && w.e(this.t, cVar.t) && i.i(this.u, cVar.u) && w.e(this.v, cVar.v) && i.i(this.w, cVar.w);
    }

    public int hashCode() {
        Context context = this.a;
        return ((((((((((((((((((((((((((((((((((((((((((((context == null ? 0 : context.hashCode()) * 31) + m.a(this.b)) * 31) + i.k(this.c)) * 31) + i.k(this.d)) * 31) + m.a(this.e)) * 31) + m.a(this.f)) * 31) + m.a(this.g)) * 31) + i.k(this.h)) * 31) + i.k(this.i)) * 31) + i.k(this.j)) * 31) + i.k(this.k)) * 31) + i.k(this.l)) * 31) + i.k(this.m)) * 31) + w.i(this.n)) * 31) + w.i(this.o)) * 31) + w.i(this.p)) * 31) + w.i(this.q)) * 31) + i.k(this.r)) * 31) + w.i(this.s)) * 31) + w.i(this.t)) * 31) + i.k(this.u)) * 31) + w.i(this.v)) * 31) + i.k(this.w);
    }

    public String toString() {
        return "BookCoverSpace(context=" + this.a + ", isInSplitMode=" + this.b + ", contentWidthDp=" + ((Object) i.l(this.c)) + ", contentHeightDp=" + ((Object) i.l(this.d)) + ", isMiniScreen=" + this.e + ", isPadScreen=" + this.f + ", is800Width=" + this.g + ", bookCoverImageTop=" + ((Object) i.l(this.h)) + ", baseInfoTop=" + ((Object) i.l(this.i)) + ", pagerTop=" + ((Object) i.l(this.j)) + ", listenEntranceEnd=" + ((Object) i.l(this.k)) + ", listenEntranceTop=" + ((Object) i.l(this.l)) + ", contentHorizontalPadding=" + ((Object) i.l(this.m)) + ", awardFontSize=" + ((Object) w.k(this.n)) + ", awardTimeFontSize=" + ((Object) w.k(this.o)) + ", baseInfoMainFontSize=" + ((Object) w.k(this.p)) + ", baseInfoSubFontSize=" + ((Object) w.k(this.q)) + ", pagerHeight=" + ((Object) i.l(this.r)) + ", pagerMainFontSize=" + ((Object) w.k(this.s)) + ", pagerDescFontSize=" + ((Object) w.k(this.t)) + ", authorNameTop=" + ((Object) i.l(this.u)) + ", bookNameTextSize=" + ((Object) w.k(this.v)) + ", pagerCardWidth=" + ((Object) i.l(this.w)) + ')';
    }

    public final Context getContext() {
        return this.a;
    }

    public final long a() {
        if (this.f && !this.b && i.f(this.d, this.c) > 0) {
            return j.a(i.g(240), i.g(340));
        }
        return j.a(i.g(174), i.g(236));
    }

    private c(Context context, boolean z, float f, float f2, boolean z2, boolean z3, boolean z4, float f3, float f4, float f5, float f6, float f7, float f8, long j, long j2, long j3, long j4, float f9, long j5, long j6, float f10, long j7, float f11) {
        this.a = context;
        this.b = z;
        this.c = f;
        this.d = f2;
        this.e = z2;
        this.f = z3;
        this.g = z4;
        this.h = f3;
        this.i = f4;
        this.j = f5;
        this.k = f6;
        this.l = f7;
        this.m = f8;
        this.n = j;
        this.o = j2;
        this.p = j3;
        this.q = j4;
        this.r = f9;
        this.s = j5;
        this.t = j6;
        this.u = f10;
        this.v = j7;
        this.w = f11;
        k.a("BookCover-Space", String.valueOf(this));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ c(android.content.Context r34, boolean r35, float r36, float r37, boolean r38, boolean r39, boolean r40, float r41, float r42, float r43, float r44, float r45, float r46, long r47, long r49, long r51, long r53, float r55, long r56, long r58, float r60, long r61, float r63, int r64, kotlin.jvm.internal.DefaultConstructorMarker r65) {
        /*
            Method dump skipped, instructions count: 560
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: am4.c.<init>(android.content.Context, boolean, float, float, boolean, boolean, boolean, float, float, float, float, float, float, long, long, long, long, float, long, long, float, long, float, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
