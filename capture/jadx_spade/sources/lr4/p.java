package lr4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.pages.bookshelf.model.BookType;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class p {
    public int a;
    public long c;
    public String d;
    public BookType e;
    public long i;
    public boolean j;
    public long k;
    public long l;
    public boolean m;
    public boolean n;
    public long o;
    public boolean p;
    public int q;
    public int r;
    public int s;
    public long v;
    public int w;
    public long b = System.currentTimeMillis();
    public boolean h = false;
    public boolean g = true;
    public String f = "";
    public String t = "";
    public String u = "";

    static {
        Covode.recordClassIndex(611564);
    }

    public String a() {
        String str = this.d;
        if (str == null) {
            return "";
        }
        return str;
    }

    public boolean b() {
        if (this.a == 6) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "Bookshelf{addType=" + this.a + ", createTime=" + this.b + ", updateTime=" + this.c + ", bookId='" + this.d + "', bookType=" + this.e + ", booklistName='" + this.f + "', isSync=" + this.g + ", isDelete=" + this.h + ", booklistOperateTime=" + this.i + '}';
    }

    public p(String str, BookType bookType) {
        this.d = str;
        this.e = bookType;
    }
}
