package kr4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.pages.bookshelf.model.BookType;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class b {
    static {
        Covode.recordClassIndex(611539);
    }

    public static Integer a(BookType bookType) {
        int value;
        if (bookType == null) {
            value = 0;
        } else {
            value = bookType.getValue();
        }
        return Integer.valueOf(value);
    }

    public static BookType b(Integer num) {
        return BookType.findByValue(num.intValue());
    }
}
