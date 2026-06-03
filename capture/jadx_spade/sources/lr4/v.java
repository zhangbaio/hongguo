package lr4;

import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class v {
    public static final int D;
    public String A;
    public String B;
    public List<s> C;
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public String o;
    public String p;
    public String q;
    public String r;
    public String s;
    public String t;
    public int u;
    public int v;
    public String w;
    public String x;
    public String y;
    public String z;

    static {
        Covode.recordClassIndex(611570);
        D = 8;
    }

    public v() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, 0, null, null, null, null, null, null, null, 536870911, null);
    }

    public final int b() {
        int i = 0;
        for (s sVar : this.C) {
            if (sVar.p == 3) {
                i += sVar.r;
            }
        }
        return i;
    }

    public String toString() {
        return "ComicBookInfo(bookId='" + this.a + "', horizontalCoverUrl='" + this.c + "', verticalCoverUrl='" + this.d + "', lastUpdateTime='" + this.e + "', updateStatus='" + this.f + "', author='" + this.g + "', createTime='" + this.h + "', abstraction='" + this.i + "', readCount='" + this.j + "', score='" + this.k + "', creationStatus='" + this.l + "', authorizeType='" + this.m + "', firstChapterId='" + this.n + "', categoryScheme='" + this.p + "', source='" + this.q + "', tags='" + this.r + "', colorDominate='" + this.s + "', contentChapterCount='" + this.u + "', consumeAd='" + this.w + "')";
    }

    public final void c(List<s> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.C = list;
    }

    public final void d(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.a = str;
    }

    public final void e(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.b = str;
    }

    public final void f(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.w = str;
    }

    public final void g(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.z = str;
    }

    public final void h(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.x = str;
    }

    public final void i(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.B = str;
    }

    public final void j(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.y = str;
    }

    public final List<s> a(int i) {
        if (this.C.isEmpty()) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (s sVar : this.C) {
            if (sVar.p == i) {
                arrayList.add(sVar);
            }
        }
        return arrayList;
    }

    public v(String bookId, String bookName, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, int i, int i2, String consumeAd, String horizontalCoverPath, String verticalCoverPath, String directorySubInfo, String str19, String lastDownloadSuccessTime, List<s> bookDownloadChapterLists) {
        Intrinsics.checkNotNullParameter(bookId, "bookId");
        Intrinsics.checkNotNullParameter(bookName, "bookName");
        Intrinsics.checkNotNullParameter(consumeAd, "consumeAd");
        Intrinsics.checkNotNullParameter(horizontalCoverPath, "horizontalCoverPath");
        Intrinsics.checkNotNullParameter(verticalCoverPath, "verticalCoverPath");
        Intrinsics.checkNotNullParameter(directorySubInfo, "directorySubInfo");
        Intrinsics.checkNotNullParameter(lastDownloadSuccessTime, "lastDownloadSuccessTime");
        Intrinsics.checkNotNullParameter(bookDownloadChapterLists, "bookDownloadChapterLists");
        this.a = bookId;
        this.b = bookName;
        this.c = str;
        this.d = str2;
        this.e = str3;
        this.f = str4;
        this.g = str5;
        this.h = str6;
        this.i = str7;
        this.j = str8;
        this.k = str9;
        this.l = str10;
        this.m = str11;
        this.n = str12;
        this.o = str13;
        this.p = str14;
        this.q = str15;
        this.r = str16;
        this.s = str17;
        this.t = str18;
        this.u = i;
        this.v = i2;
        this.w = consumeAd;
        this.x = horizontalCoverPath;
        this.y = verticalCoverPath;
        this.z = directorySubInfo;
        this.A = str19;
        this.B = lastDownloadSuccessTime;
        this.C = bookDownloadChapterLists;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ v(java.lang.String r31, java.lang.String r32, java.lang.String r33, java.lang.String r34, java.lang.String r35, java.lang.String r36, java.lang.String r37, java.lang.String r38, java.lang.String r39, java.lang.String r40, java.lang.String r41, java.lang.String r42, java.lang.String r43, java.lang.String r44, java.lang.String r45, java.lang.String r46, java.lang.String r47, java.lang.String r48, java.lang.String r49, java.lang.String r50, int r51, int r52, java.lang.String r53, java.lang.String r54, java.lang.String r55, java.lang.String r56, java.lang.String r57, java.lang.String r58, java.util.List r59, int r60, kotlin.jvm.internal.DefaultConstructorMarker r61) {
        /*
            Method dump skipped, instructions count: 349
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: lr4.v.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.List, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
