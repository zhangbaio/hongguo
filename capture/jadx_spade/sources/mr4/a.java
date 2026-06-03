package mr4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.pages.bookshelf.model.BookType;
import readersaas.com.dragon.read.saas.rpc.model.ReadingBookType;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {
    static {
        Covode.recordClassIndex(611630);
    }

    public static final ReadingBookType a(BookType bookType) {
        if (bookType == null) {
            return null;
        }
        return ReadingBookType.findByValue(bookType.getValue());
    }
}
