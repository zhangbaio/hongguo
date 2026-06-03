package com.dragon.read.kmp.reader.detail.repo;

import androidx.compose.animation.m;
import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.t3;
import com.bytedance.kmp.ugc.model.xy;
import com.dragon.read.kmp.community.bookcomment.t;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b {
    public static final int l;
    public final t3 a;
    public final boolean b;
    public final List<com.dragon.read.kmp.reader.detail.widget.a> c;
    public final List<com.dragon.read.kmp.reader.detail.widget.a> d;
    public final List<com.dragon.read.kmp.reader.detail.widget.a> e;
    public final String f;
    public final String g;
    public final List<com.dragon.read.kmp.reader.detail.widget.a> h;
    public final t i;
    public final xy j;
    public final a k;

    static {
        Covode.recordClassIndex(608393);
        l = 8;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return Intrinsics.areEqual(this.a, bVar.a) && this.b == bVar.b && Intrinsics.areEqual(this.c, bVar.c) && Intrinsics.areEqual(this.d, bVar.d) && Intrinsics.areEqual(this.e, bVar.e) && Intrinsics.areEqual(this.f, bVar.f) && Intrinsics.areEqual(this.g, bVar.g) && Intrinsics.areEqual(this.h, bVar.h) && Intrinsics.areEqual(this.i, bVar.i) && Intrinsics.areEqual(this.j, bVar.j) && Intrinsics.areEqual(this.k, bVar.k);
    }

    public int hashCode() {
        int hashCode = ((((((((this.a.hashCode() * 31) + m.a(this.b)) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31;
        String str = this.f;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.g;
        int hashCode3 = (((hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.h.hashCode()) * 31;
        t tVar = this.i;
        int hashCode4 = (hashCode3 + (tVar == null ? 0 : tVar.hashCode())) * 31;
        xy xyVar = this.j;
        return ((hashCode4 + (xyVar != null ? xyVar.hashCode() : 0)) * 31) + this.k.hashCode();
    }

    public String toString() {
        return "BookDetailLoadResult(bookDetail=" + this.a + ", inBookshelf=" + this.b + ", alsoReadItems=" + this.c + ", sameAuthorItems=" + this.d + ", samePressItems=" + this.e + ", sameAuthorMoreUrl=" + this.f + ", samePressMoreUrl=" + this.g + ", adaptationItems=" + this.h + ", hotCommentsData=" + this.i + ", forumData=" + this.j + ", listenState=" + this.k + ')';
    }

    public b(t3 bookDetail, boolean z, List<com.dragon.read.kmp.reader.detail.widget.a> alsoReadItems, List<com.dragon.read.kmp.reader.detail.widget.a> sameAuthorItems, List<com.dragon.read.kmp.reader.detail.widget.a> samePressItems, String str, String str2, List<com.dragon.read.kmp.reader.detail.widget.a> adaptationItems, t tVar, xy xyVar, a listenState) {
        Intrinsics.checkNotNullParameter(bookDetail, "bookDetail");
        Intrinsics.checkNotNullParameter(alsoReadItems, "alsoReadItems");
        Intrinsics.checkNotNullParameter(sameAuthorItems, "sameAuthorItems");
        Intrinsics.checkNotNullParameter(samePressItems, "samePressItems");
        Intrinsics.checkNotNullParameter(adaptationItems, "adaptationItems");
        Intrinsics.checkNotNullParameter(listenState, "listenState");
        this.a = bookDetail;
        this.b = z;
        this.c = alsoReadItems;
        this.d = sameAuthorItems;
        this.e = samePressItems;
        this.f = str;
        this.g = str2;
        this.h = adaptationItems;
        this.i = tVar;
        this.j = xyVar;
        this.k = listenState;
    }
}
