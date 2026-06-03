package lr4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.local.db.entity.ComicChapterConsumeAd;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class s {
    public static final int A;
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public int i;
    public String j;
    public int k;
    public int l;
    public String m;
    public String n;
    public String o;
    public int p;
    public int q;
    public int r;
    public long s;
    public int t;
    public int u;
    public String v;
    public String w;
    public int x;
    public int y;
    public List<z> z;

    static {
        Covode.recordClassIndex(611567);
        A = 8;
    }

    public s() {
        this(null, null, null, null, null, null, null, null, 0, null, 0, 0, null, null, null, 0, 0, 0, 0L, 0, 0, null, null, 0, 0, null, 67108863, null);
    }

    public final boolean a() {
        return false;
    }

    public final boolean c() {
        if (this.y == ComicChapterConsumeAd.CONSUME_SUCCESS.getValue()) {
            return true;
        }
        return false;
    }

    public final boolean d() {
        int i = this.p;
        if (i != 3 && i != 1) {
            return true;
        }
        return false;
    }

    public final void e() {
        this.h = "";
        this.j = "";
        this.o = "";
        this.p = -1;
        this.q = 0;
        this.s = 0L;
        this.u = 0;
        this.v = "";
        this.y = ComicChapterConsumeAd.CONSUME_DEFAULT.getValue();
    }

    public final List<Integer> b() {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it2 = this.z.iterator();
        while (it2.hasNext()) {
            arrayList.add(Integer.valueOf(((z) it2.next()).h));
        }
        return arrayList;
    }

    public String toString() {
        return "ComicDownloadChapterInfo(comicId='" + this.b + "', chapterThumbUrl='" + this.c + "', publishTime='" + this.d + "', chapterName='" + this.e + "', version='" + this.g + "', content='" + this.h + "', keyVersion='" + this.i + "', contentMd5='" + this.j + "', order='" + this.k + "', firstPassTime='" + this.m + "', volumeName='" + this.n + "', contentKey='" + this.o + "', downloadStatus='" + this.p + "', contentLength='" + this.r + "')";
    }

    public final void f(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.a = str;
    }

    public final void g(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f = str;
    }

    public final void h(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.b = str;
    }

    public final void i(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.e = str;
    }

    public final void j(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.c = str;
    }

    public final void k(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.h = str;
    }

    public final void l(List<z> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.z = list;
    }

    public final void m(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.o = str;
    }

    public final void n(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.j = str;
    }

    public final void o(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.v = str;
    }

    public final void p(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.m = str;
    }

    public final void q(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.d = str;
    }

    public final void r(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.w = str;
    }

    public final void s(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.g = str;
    }

    public final void t(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.n = str;
    }

    public s(String bookId, String chapterId, String chapterThumbUrl, String publishTime, String chapterName, String bookName, String version, String content, int i, String contentMd5, int i2, int i3, String firstPassTime, String volumeName, String contentKey, int i4, int i5, int i6, long j, int i7, int i8, String downloadChapterPath, String thumbAbsPath, int i9, int i10, List<z> contentItemElements) {
        Intrinsics.checkNotNullParameter(bookId, "bookId");
        Intrinsics.checkNotNullParameter(chapterId, "chapterId");
        Intrinsics.checkNotNullParameter(chapterThumbUrl, "chapterThumbUrl");
        Intrinsics.checkNotNullParameter(publishTime, "publishTime");
        Intrinsics.checkNotNullParameter(chapterName, "chapterName");
        Intrinsics.checkNotNullParameter(bookName, "bookName");
        Intrinsics.checkNotNullParameter(version, "version");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(contentMd5, "contentMd5");
        Intrinsics.checkNotNullParameter(firstPassTime, "firstPassTime");
        Intrinsics.checkNotNullParameter(volumeName, "volumeName");
        Intrinsics.checkNotNullParameter(contentKey, "contentKey");
        Intrinsics.checkNotNullParameter(downloadChapterPath, "downloadChapterPath");
        Intrinsics.checkNotNullParameter(thumbAbsPath, "thumbAbsPath");
        Intrinsics.checkNotNullParameter(contentItemElements, "contentItemElements");
        this.a = bookId;
        this.b = chapterId;
        this.c = chapterThumbUrl;
        this.d = publishTime;
        this.e = chapterName;
        this.f = bookName;
        this.g = version;
        this.h = content;
        this.i = i;
        this.j = contentMd5;
        this.k = i2;
        this.l = i3;
        this.m = firstPassTime;
        this.n = volumeName;
        this.o = contentKey;
        this.p = i4;
        this.q = i5;
        this.r = i6;
        this.s = j;
        this.t = i7;
        this.u = i8;
        this.v = downloadChapterPath;
        this.w = thumbAbsPath;
        this.x = i9;
        this.y = i10;
        this.z = contentItemElements;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ s(java.lang.String r29, java.lang.String r30, java.lang.String r31, java.lang.String r32, java.lang.String r33, java.lang.String r34, java.lang.String r35, java.lang.String r36, int r37, java.lang.String r38, int r39, int r40, java.lang.String r41, java.lang.String r42, java.lang.String r43, int r44, int r45, int r46, long r47, int r49, int r50, java.lang.String r51, java.lang.String r52, int r53, int r54, java.util.List r55, int r56, kotlin.jvm.internal.DefaultConstructorMarker r57) {
        /*
            Method dump skipped, instructions count: 314
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: lr4.s.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, java.lang.String, int, int, java.lang.String, java.lang.String, java.lang.String, int, int, int, long, int, int, java.lang.String, java.lang.String, int, int, java.util.List, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
