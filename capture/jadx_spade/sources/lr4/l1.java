package lr4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.pages.bookshelf.model.BookType;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class l1 {
    public String a;
    public BookType b;
    public String c;
    public String d;
    public String e;
    public int f;
    public String g;

    static {
        Covode.recordClassIndex(611621);
    }

    public String toString() {
        return "UgcBookInfo{bookId='" + this.a + "', bookType=" + this.b + ", bookListId='" + this.c + "', recommendCount='" + this.d + "', readCount='" + this.e + "', colorDominate='" + this.g + "'}";
    }

    public l1(String str, BookType bookType, String str2) {
        this.a = str;
        this.b = bookType;
        this.c = str2;
    }
}
