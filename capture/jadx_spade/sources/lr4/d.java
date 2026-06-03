package lr4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.pages.bookshelf.model.BookType;
import com.dragon.read.progress.ChapterProgress;
import com.dragon.read.util.NumberUtils;
import com.dragon.read.util.i7;
import kotlin.jvm.internal.Intrinsics;
import readersaas.com.dragon.read.saas.rpc.model.ApiItemInfo;
import readersaas.com.dragon.read.saas.rpc.model.GenreTypeEnum;
import readersaas.com.dragon.read.saas.rpc.model.ProgressPosInfoV2;
import readersaas.com.dragon.read.saas.rpc.model.ProgressRateInfo;
import readersaas.com.dragon.read.saas.rpc.model.ReadingBookType;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class d {
    public static final int z;
    public int d;
    public int f;
    public float g;
    public long i;
    public float j;
    public int l;
    public int m;
    public int n;
    public int o;
    public double t;
    public int u;
    public long v;
    public long w;
    public long x;
    public long y;
    public String b = "";
    public String c = "";
    public String e = "";
    public BookType h = BookType.READ;
    public int k = -1;
    public GenreTypeEnum p = GenreTypeEnum.NOVEL;
    public long q = -1;
    public String r = "0";
    public String s = "0";
    public long a = i7.m();

    static {
        Covode.recordClassIndex(611551);
        z = 8;
    }

    public final ChapterProgress b() {
        ChapterProgress chapterProgress = new ChapterProgress(this.c);
        chapterProgress.setProgressInReader(Integer.valueOf((int) NumberUtils.parse(this.s, 0.0d)), Double.valueOf(this.t));
        chapterProgress.setProgressInPlayer(Integer.valueOf((int) NumberUtils.parse(this.s, 0.0d)));
        return chapterProgress;
    }

    public final h a() {
        h hVar = new h();
        hVar.h = this.b;
        hVar.a = this.c;
        hVar.b = this.d;
        hVar.c = this.e;
        hVar.d = this.f;
        hVar.e = this.g;
        hVar.i = this.h;
        hVar.g = this.i;
        hVar.j = this.j;
        hVar.k = this.k;
        hVar.l = this.l;
        hVar.m = this.m;
        hVar.n = this.n;
        hVar.o = this.o;
        hVar.q = this.q;
        hVar.f = this.u;
        hVar.r = this.v;
        return hVar;
    }

    public final ProgressRateInfo c() {
        ProgressRateInfo progressRateInfo = new ProgressRateInfo();
        progressRateInfo.bookId = this.b;
        progressRateInfo.itemId = this.c;
        progressRateInfo.pageIndex = this.f;
        progressRateInfo.progressRate = String.valueOf(this.g);
        progressRateInfo.bookType = mr4.a.a(this.h);
        progressRateInfo.readTimestampMs = this.i;
        progressRateInfo.pageProgressRate = this.j;
        progressRateInfo.paragraphId = String.valueOf(this.k);
        progressRateInfo.paragraphOffset = this.l;
        ProgressPosInfoV2 progressPosInfoV2 = new ProgressPosInfoV2();
        progressRateInfo.progressPosInfoV2 = progressPosInfoV2;
        Intrinsics.checkNotNull(progressPosInfoV2);
        progressPosInfoV2.startContainerIndex = this.m;
        ProgressPosInfoV2 progressPosInfoV22 = progressRateInfo.progressPosInfoV2;
        Intrinsics.checkNotNull(progressPosInfoV22);
        progressPosInfoV22.startElementIndex = this.n;
        ProgressPosInfoV2 progressPosInfoV23 = progressRateInfo.progressPosInfoV2;
        Intrinsics.checkNotNull(progressPosInfoV23);
        progressPosInfoV23.startElementOffset = this.o;
        progressRateInfo.genreType = this.p;
        progressRateInfo.toneId = this.q;
        progressRateInfo.itemProgressRate = this.s;
        progressRateInfo.channelId = this.v;
        progressRateInfo.curChannelId = this.w;
        return progressRateInfo;
    }

    public final void h(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.b = str;
    }

    public final void i(String bookId) {
        Intrinsics.checkNotNullParameter(bookId, "bookId");
        this.b = bookId;
    }

    public final void j(BookType bookType) {
        Intrinsics.checkNotNullParameter(bookType, "<set-?>");
        this.h = bookType;
    }

    public final void k(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.c = str;
    }

    public final void l(String chapterId) {
        Intrinsics.checkNotNullParameter(chapterId, "chapterId");
        this.c = chapterId;
    }

    public final void m(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.r = str;
    }

    public final void n(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.s = str;
    }

    public final void o(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.e = str;
    }

    public final void p(String str) {
        if (str == null) {
            str = "";
        }
        this.e = str;
    }

    public final void q(GenreTypeEnum genreTypeEnum) {
        Intrinsics.checkNotNullParameter(genreTypeEnum, "<set-?>");
        this.p = genreTypeEnum;
    }

    public final void g(d progress) {
        Intrinsics.checkNotNullParameter(progress, "progress");
        this.b = progress.b;
        this.c = progress.c;
        this.d = progress.d;
        this.e = progress.e;
        this.f = progress.f;
        this.g = progress.g;
        this.h = progress.h;
        this.i = progress.i;
        this.j = progress.j;
        this.k = progress.k;
        this.l = progress.l;
        this.m = progress.m;
        this.n = progress.n;
        this.o = progress.o;
        this.p = progress.p;
        this.q = progress.q;
        this.r = progress.r;
        this.s = progress.s;
        this.t = progress.t;
        this.u = progress.u;
        this.v = progress.v;
        this.w = progress.w;
        this.x = progress.x;
        this.y = progress.y;
    }

    public final void d(h progress, d dVar) {
        GenreTypeEnum genreTypeEnum;
        String str;
        double d;
        long j;
        long j2;
        long j3;
        String str2;
        Intrinsics.checkNotNullParameter(progress, "progress");
        String bookId = progress.h;
        Intrinsics.checkNotNullExpressionValue(bookId, "bookId");
        this.b = bookId;
        String a = progress.a();
        Intrinsics.checkNotNullExpressionValue(a, "getChapterId(...)");
        this.c = a;
        this.d = progress.b;
        String b = progress.b();
        Intrinsics.checkNotNullExpressionValue(b, "getChapterTitle(...)");
        this.e = b;
        this.f = progress.d;
        this.g = progress.e;
        BookType bookType = progress.i;
        Intrinsics.checkNotNullExpressionValue(bookType, "bookType");
        this.h = bookType;
        this.i = progress.g;
        this.j = progress.j;
        this.k = progress.k;
        this.l = progress.l;
        this.m = progress.m;
        this.n = progress.n;
        this.o = progress.o;
        if (dVar == null || (genreTypeEnum = dVar.p) == null) {
            genreTypeEnum = GenreTypeEnum.NOVEL;
        }
        this.p = genreTypeEnum;
        this.q = progress.q;
        String str3 = "0";
        if (dVar == null || (str = dVar.r) == null) {
            str = "0";
        }
        this.r = str;
        if (dVar != null && (str2 = dVar.s) != null) {
            str3 = str2;
        }
        this.s = str3;
        if (dVar != null) {
            d = dVar.t;
        } else {
            d = 0.0d;
        }
        this.t = d;
        this.u = progress.f;
        long j4 = 0;
        if (dVar != null) {
            j = dVar.v;
        } else {
            j = 0;
        }
        this.v = j;
        if (dVar != null) {
            j2 = dVar.w;
        } else {
            j2 = 0;
        }
        this.w = j2;
        if (dVar != null) {
            j3 = dVar.x;
        } else {
            j3 = 0;
        }
        this.x = j3;
        if (dVar != null) {
            j4 = dVar.y;
        }
        this.y = j4;
    }

    public final void e(ApiItemInfo progress, d dVar) {
        int i;
        int i2;
        int i3;
        long j;
        String str;
        String str2;
        long j2;
        long j3;
        Intrinsics.checkNotNullParameter(progress, "progress");
        String bookId = progress.bookId;
        Intrinsics.checkNotNullExpressionValue(bookId, "bookId");
        this.b = bookId;
        String itemId = progress.itemId;
        Intrinsics.checkNotNullExpressionValue(itemId, "itemId");
        this.c = itemId;
        this.d = NumberUtils.parseInt(progress.realChapterOrder, 1) - 1;
        String title = progress.title;
        Intrinsics.checkNotNullExpressionValue(title, "title");
        this.e = title;
        boolean z2 = false;
        this.f = 0;
        this.g = NumberUtils.parse(progress.progressRate, 0.0f);
        BookType findByValue = BookType.findByValue(NumberUtils.parseInt(progress.bookType, 0));
        Intrinsics.checkNotNullExpressionValue(findByValue, "findByValue(...)");
        this.h = findByValue;
        long j4 = 0;
        this.i = NumberUtils.parse(progress.readTimestampMs, 0L);
        this.j = NumberUtils.parse(progress.pageProgressRate, 0.0f);
        this.k = NumberUtils.parseInt(progress.paragraphId, -1);
        this.l = NumberUtils.parseInt(progress.paragraphOffset, 0);
        ProgressPosInfoV2 progressPosInfoV2 = progress.progressPosInfoV2;
        if (progressPosInfoV2 != null) {
            i = progressPosInfoV2.startContainerIndex;
        } else {
            i = 0;
        }
        this.m = i;
        if (progressPosInfoV2 != null) {
            i2 = progressPosInfoV2.startElementIndex;
        } else {
            i2 = 0;
        }
        this.n = i2;
        if (progressPosInfoV2 != null) {
            i3 = progressPosInfoV2.startElementOffset;
        } else {
            i3 = 0;
        }
        this.o = i3;
        GenreTypeEnum findByValue2 = GenreTypeEnum.findByValue(NumberUtils.parseInt(progress.genreType, 0));
        Intrinsics.checkNotNullExpressionValue(findByValue2, "findByValue(...)");
        this.p = findByValue2;
        if (dVar != null) {
            j = dVar.q;
        } else {
            j = 0;
        }
        this.q = j;
        this.r = com.dragon.read.util.kotlin.m.a(progress.itemProgressRate);
        if (dVar == null || (str = dVar.s) == null) {
            str = "0";
        }
        if (NumberUtils.parse(str, 0.0d) == 100.0d) {
            z2 = true;
        }
        if (z2) {
            str2 = "100";
        } else {
            str2 = progress.itemProgressRate.toString();
        }
        this.s = str2;
        this.t = NumberUtils.parse(progress.itemProgressRate, 0.0d);
        this.u = 1;
        String str3 = progress.channelId;
        if (str3 != null) {
            j2 = Long.parseLong(str3);
        } else {
            j2 = 0;
        }
        this.v = j2;
        if (dVar != null) {
            j3 = dVar.x;
        } else {
            j3 = 0;
        }
        this.x = j3;
        if (dVar != null) {
            j4 = dVar.y;
        }
        this.y = j4;
    }

    public final void f(ProgressRateInfo progress, d dVar) {
        int i;
        String str;
        int i2;
        BookType bookType;
        int i3;
        int i4;
        String str2;
        long j;
        Intrinsics.checkNotNullParameter(progress, "progress");
        String bookId = progress.bookId;
        Intrinsics.checkNotNullExpressionValue(bookId, "bookId");
        this.b = bookId;
        String itemId = progress.itemId;
        Intrinsics.checkNotNullExpressionValue(itemId, "itemId");
        this.c = itemId;
        int i5 = 0;
        if (dVar != null) {
            i = dVar.d;
        } else {
            i = 0;
        }
        this.d = i;
        if (dVar == null || (str = dVar.e) == null) {
            str = "";
        }
        this.e = str;
        if (dVar != null) {
            i2 = dVar.f;
        } else {
            i2 = 0;
        }
        this.f = i2;
        this.g = NumberUtils.parse(progress.progressRate, 0.0f);
        ReadingBookType readingBookType = progress.bookType;
        if (readingBookType == null) {
            readingBookType = ReadingBookType.Read;
        }
        if (readingBookType == ReadingBookType.Read) {
            bookType = BookType.READ;
        } else {
            bookType = BookType.LISTEN;
        }
        this.h = bookType;
        this.i = progress.readTimestampMs;
        this.j = (float) progress.pageProgressRate;
        this.k = NumberUtils.parseInt(progress.paragraphId, 0);
        this.l = progress.paragraphOffset;
        ProgressPosInfoV2 progressPosInfoV2 = progress.progressPosInfoV2;
        if (progressPosInfoV2 != null) {
            i3 = progressPosInfoV2.startContainerIndex;
        } else {
            i3 = 0;
        }
        this.m = i3;
        if (progressPosInfoV2 != null) {
            i4 = progressPosInfoV2.startElementIndex;
        } else {
            i4 = 0;
        }
        this.n = i4;
        if (progressPosInfoV2 != null) {
            i5 = progressPosInfoV2.startElementOffset;
        }
        this.o = i5;
        GenreTypeEnum genreTypeEnum = progress.genreType;
        if (genreTypeEnum == null) {
            genreTypeEnum = GenreTypeEnum.NOVEL;
        }
        this.p = genreTypeEnum;
        this.q = progress.toneId;
        String str3 = "0";
        if (dVar == null || (str2 = dVar.r) == null) {
            str2 = "0";
        }
        this.r = str2;
        String str4 = progress.itemProgressRate;
        if (str4 != null) {
            str3 = str4;
        }
        this.s = str3;
        this.t = NumberUtils.parse(str4, 0.0d);
        this.v = progress.channelId;
        long j2 = 0;
        if (dVar != null) {
            j = dVar.x;
        } else {
            j = 0;
        }
        this.x = j;
        if (dVar != null) {
            j2 = dVar.y;
        }
        this.y = j2;
    }
}
