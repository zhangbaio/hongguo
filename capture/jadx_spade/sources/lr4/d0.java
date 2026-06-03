package lr4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.pages.bookshelf.model.BookType;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class d0 {
    public long a;
    public String b;
    public BookType c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public int i;
    public float j;
    public long k;
    public int l;
    public int m;
    public boolean n;
    public String o;
    public String p;
    public int q;
    public boolean r;
    public long s;
    public boolean t;

    static {
        Covode.recordClassIndex(611582);
    }

    public d0() {
        this.l = -1;
        this.m = 0;
        this.q = 1;
    }

    public String toString() {
        return "LocalBook{bookshelfUpdateTime=" + this.a + ", bookId='" + this.b + "', bookType=" + this.c + ", coverUrl='" + this.d + "', bookName='" + this.e + "', filePath='" + this.f + "', lastChapterId='" + this.g + "', lastChapterTitle='" + this.h + "', lastPageIndex=" + this.i + ", progressRate=" + this.j + ", progressUpdateTime=" + this.k + ", paragraphId=" + this.l + ", lineInParagraphOffset=" + this.m + ", isExternal=" + this.n + ", bookGroupName='" + this.o + "', mimeType='" + this.p + "', version=" + this.q + ", isPinned=" + this.r + ", pinnedTime=" + this.s + ", isAsterisked=" + this.t + '}';
    }

    public static class a {
        public final String a;
        public final BookType b;
        public final String c;
        public final String d;

        static {
            Covode.recordClassIndex(611583);
        }

        public a(String str, BookType bookType, String str2, String str3) {
            this.a = str;
            this.b = bookType;
            this.c = str2;
            this.d = str3;
        }
    }

    public d0(String str, String str2, String str3, String str4, boolean z, String str5) {
        this(str, BookType.READ, str2, str3, str4, z, str5, "");
    }

    public d0(String str, BookType bookType, String str2, String str3, String str4, boolean z, String str5, String str6) {
        this.l = -1;
        this.m = 0;
        this.q = 1;
        this.a = System.currentTimeMillis();
        this.b = str;
        this.c = bookType;
        this.d = str2;
        this.e = str3;
        this.f = str4;
        this.n = z;
        this.p = str5;
        this.o = str6;
    }
}
