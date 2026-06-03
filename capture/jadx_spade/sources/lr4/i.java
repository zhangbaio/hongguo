package lr4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.local.db.entity.PageInfo;
import com.dragon.read.pages.bookshelf.model.BookType;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class i {
    public long A;
    public long B;
    public String a;
    public String b;
    public String c;
    public int d;
    public int e;
    public long f;
    public String g;
    public BookType h;
    public long i;
    public long j;
    public boolean k;
    public boolean l;
    public String m;
    public boolean n;
    public int o;
    public String p;
    public String q;
    public PageInfo r;
    public boolean s;
    public boolean t;
    public boolean u;
    public int v;
    public String w;
    public long x;
    public String y;
    public long z;

    static {
        Covode.recordClassIndex(611557);
    }

    public String toString() {
        return "BookRecord{authorName='" + this.a + "', bookName='" + this.b + "', coverUrl='" + this.c + "', genreType=" + this.d + ", ttsStatus=" + this.e + ", updateTime=" + this.f + ", bookId='" + this.g + "', bookType=" + this.h + ", lastUpdateTime=" + this.i + ", readTime=" + this.j + ", isDelete=" + this.k + ", hasSync=" + this.l + ", resource='" + this.m + "', isFinish=" + this.n + ", recentReadCount=" + this.o + ", colorDominate=" + this.w + ", score='" + this.p + "', source='" + this.q + "', toneId='" + this.x + "'}";
    }

    public i(String str, BookType bookType) {
        this.k = false;
        this.l = false;
        this.n = false;
        this.t = true;
        this.w = "";
        this.x = 0L;
        this.y = "";
        this.z = 0L;
        this.A = 0L;
        this.B = 0L;
        this.g = str;
        this.h = bookType;
    }

    public i(String str, BookType bookType, String str2, String str3, String str4, long j, int i, int i2, String str5, boolean z, int i3, String str6, PageInfo pageInfo) {
        this.k = false;
        this.l = false;
        this.t = true;
        this.w = "";
        this.x = 0L;
        this.y = "";
        this.z = 0L;
        this.A = 0L;
        this.B = 0L;
        this.g = str;
        this.h = bookType;
        this.c = str2;
        this.b = str3;
        this.a = str4;
        this.f = j;
        this.i = j;
        this.j = j;
        this.d = i;
        this.e = i2;
        this.m = str5;
        this.n = z;
        this.o = i3;
        this.p = str6;
        this.r = pageInfo;
    }

    public i(String str, BookType bookType, String str2, String str3, String str4, long j, int i, int i2, String str5, boolean z, int i3, String str6, PageInfo pageInfo, long j2, long j3, long j4) {
        this.k = false;
        this.l = false;
        this.t = true;
        this.w = "";
        this.x = 0L;
        this.y = "";
        this.g = str;
        this.h = bookType;
        this.c = str2;
        this.b = str3;
        this.a = str4;
        this.f = j;
        this.i = j;
        this.j = j;
        this.d = i;
        this.e = i2;
        this.m = str5;
        this.n = z;
        this.o = i3;
        this.p = str6;
        this.r = pageInfo;
        this.z = j2;
        this.A = j3;
        this.B = j4;
    }
}
