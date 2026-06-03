package lr4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.pages.bookshelf.model.BookType;
import java.util.Set;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class d1 {
    public String a;
    public BookType b;
    public Set<String> c;
    public String d;

    static {
        Covode.recordClassIndex(611613);
    }

    public String toString() {
        return "RelativeBook{id='" + this.a + "', bookType=" + this.b + ", relativeAudioBookSet=" + this.c + ", relativeNovelBookId='" + this.d + "'}";
    }

    public d1(String str, BookType bookType) {
        this.a = str;
        this.b = bookType;
    }
}
