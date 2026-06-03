package com.dragon.read.kmp.reader.state;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.reader.annotation.BDExportToObjc;
import com.dragon.read.kmp.reader.bookcover.BookCoverDataLoadState;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

@BDExportToObjc
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {
    public static final int z;
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final Integer h;
    public final String i;
    public final String j;
    public final String k;
    public final String l;
    public final String m;
    public final String n;
    public final String o;
    public final String p;
    public final String q;
    public final String r;
    public final String s;
    public final List<i> t;
    public final BookCoverDataLoadState u;
    public final String v;
    public final List<j> w;
    public final List<g> x;
    public final boolean y;

    static {
        Covode.recordClassIndex(608567);
        z = 8;
    }

    public a() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, 33554431, null);
    }

    public final a a(String str, String str2, String str3, String str4, String str5, String str6, String str7, Integer num, String str8, String str9, String str10, String str11, String str12, String publishingHouse, String str13, String str14, String str15, String str16, String backgroundUrl, List<i> hotLines, BookCoverDataLoadState hotLineLoadState, String str17, List<j> rankListAwardList, List<g> categorySchema, boolean z2) {
        Intrinsics.checkNotNullParameter(publishingHouse, "publishingHouse");
        Intrinsics.checkNotNullParameter(backgroundUrl, "backgroundUrl");
        Intrinsics.checkNotNullParameter(hotLines, "hotLines");
        Intrinsics.checkNotNullParameter(hotLineLoadState, "hotLineLoadState");
        Intrinsics.checkNotNullParameter(rankListAwardList, "rankListAwardList");
        Intrinsics.checkNotNullParameter(categorySchema, "categorySchema");
        return new a(str, str2, str3, str4, str5, str6, str7, num, str8, str9, str10, str11, str12, publishingHouse, str13, str14, str15, str16, backgroundUrl, hotLines, hotLineLoadState, str17, rankListAwardList, categorySchema, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Intrinsics.areEqual(this.a, aVar.a) && Intrinsics.areEqual(this.b, aVar.b) && Intrinsics.areEqual(this.c, aVar.c) && Intrinsics.areEqual(this.d, aVar.d) && Intrinsics.areEqual(this.e, aVar.e) && Intrinsics.areEqual(this.f, aVar.f) && Intrinsics.areEqual(this.g, aVar.g) && Intrinsics.areEqual(this.h, aVar.h) && Intrinsics.areEqual(this.i, aVar.i) && Intrinsics.areEqual(this.j, aVar.j) && Intrinsics.areEqual(this.k, aVar.k) && Intrinsics.areEqual(this.l, aVar.l) && Intrinsics.areEqual(this.m, aVar.m) && Intrinsics.areEqual(this.n, aVar.n) && Intrinsics.areEqual(this.o, aVar.o) && Intrinsics.areEqual(this.p, aVar.p) && Intrinsics.areEqual(this.q, aVar.q) && Intrinsics.areEqual(this.r, aVar.r) && Intrinsics.areEqual(this.s, aVar.s) && Intrinsics.areEqual(this.t, aVar.t) && this.u == aVar.u && Intrinsics.areEqual(this.v, aVar.v) && Intrinsics.areEqual(this.w, aVar.w) && Intrinsics.areEqual(this.x, aVar.x) && this.y == aVar.y;
    }

    public int hashCode() {
        String str = this.a;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.b;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.c;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.d;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.e;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.f;
        int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.g;
        int hashCode7 = (hashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        Integer num = this.h;
        int hashCode8 = (hashCode7 + (num == null ? 0 : num.hashCode())) * 31;
        String str8 = this.i;
        int hashCode9 = (hashCode8 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.j;
        int hashCode10 = (hashCode9 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.k;
        int hashCode11 = (hashCode10 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.l;
        int hashCode12 = (hashCode11 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.m;
        int hashCode13 = (((hashCode12 + (str12 == null ? 0 : str12.hashCode())) * 31) + this.n.hashCode()) * 31;
        String str13 = this.o;
        int hashCode14 = (hashCode13 + (str13 == null ? 0 : str13.hashCode())) * 31;
        String str14 = this.p;
        int hashCode15 = (hashCode14 + (str14 == null ? 0 : str14.hashCode())) * 31;
        String str15 = this.q;
        int hashCode16 = (hashCode15 + (str15 == null ? 0 : str15.hashCode())) * 31;
        String str16 = this.r;
        int hashCode17 = (((((((hashCode16 + (str16 == null ? 0 : str16.hashCode())) * 31) + this.s.hashCode()) * 31) + this.t.hashCode()) * 31) + this.u.hashCode()) * 31;
        String str17 = this.v;
        return ((((((hashCode17 + (str17 != null ? str17.hashCode() : 0)) * 31) + this.w.hashCode()) * 31) + this.x.hashCode()) * 31) + androidx.compose.animation.m.a(this.y);
    }

    public String toString() {
        return "BookCoverState(bookId=" + this.a + ", bookName=" + this.b + ", author=" + this.c + ", authorId=" + this.d + ", translatorName=" + this.e + ", thumbUrl=" + this.f + ", score=" + this.g + ", wordNumber=" + this.h + ", abstraction=" + this.i + ", publisherName=" + this.j + ", publisherUrl=" + this.k + ", publishTime=" + this.l + ", isbn=" + this.m + ", publishingHouse=" + this.n + ", authorPrizeName=" + this.o + ", authorPrizeYear=" + this.p + ", readCount=" + this.q + ", readCountAll=" + this.r + ", backgroundUrl=" + this.s + ", hotLines=" + this.t + ", hotLineLoadState=" + this.u + ", backColorDominate=" + this.v + ", rankListAwardList=" + this.w + ", categorySchema=" + this.x + ", isUpDownMode=" + this.y + ')';
    }

    public final boolean c() {
        if (this.u == BookCoverDataLoadState.SUCCESS && this.t.size() >= 3) {
            return true;
        }
        return false;
    }

    public a(String str, String str2, String str3, String str4, String str5, String str6, String str7, Integer num, String str8, String str9, String str10, String str11, String str12, String publishingHouse, String str13, String str14, String str15, String str16, String backgroundUrl, List<i> hotLines, BookCoverDataLoadState hotLineLoadState, String str17, List<j> rankListAwardList, List<g> categorySchema, boolean z2) {
        Intrinsics.checkNotNullParameter(publishingHouse, "publishingHouse");
        Intrinsics.checkNotNullParameter(backgroundUrl, "backgroundUrl");
        Intrinsics.checkNotNullParameter(hotLines, "hotLines");
        Intrinsics.checkNotNullParameter(hotLineLoadState, "hotLineLoadState");
        Intrinsics.checkNotNullParameter(rankListAwardList, "rankListAwardList");
        Intrinsics.checkNotNullParameter(categorySchema, "categorySchema");
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = str6;
        this.g = str7;
        this.h = num;
        this.i = str8;
        this.j = str9;
        this.k = str10;
        this.l = str11;
        this.m = str12;
        this.n = publishingHouse;
        this.o = str13;
        this.p = str14;
        this.q = str15;
        this.r = str16;
        this.s = backgroundUrl;
        this.t = hotLines;
        this.u = hotLineLoadState;
        this.v = str17;
        this.w = rankListAwardList;
        this.x = categorySchema;
        this.y = z2;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ a(java.lang.String r27, java.lang.String r28, java.lang.String r29, java.lang.String r30, java.lang.String r31, java.lang.String r32, java.lang.String r33, java.lang.Integer r34, java.lang.String r35, java.lang.String r36, java.lang.String r37, java.lang.String r38, java.lang.String r39, java.lang.String r40, java.lang.String r41, java.lang.String r42, java.lang.String r43, java.lang.String r44, java.lang.String r45, java.util.List r46, com.dragon.read.kmp.reader.bookcover.BookCoverDataLoadState r47, java.lang.String r48, java.util.List r49, java.util.List r50, boolean r51, int r52, kotlin.jvm.internal.DefaultConstructorMarker r53) {
        /*
            Method dump skipped, instructions count: 299
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.reader.state.a.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.List, com.dragon.read.kmp.reader.bookcover.BookCoverDataLoadState, java.lang.String, java.util.List, java.util.List, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
