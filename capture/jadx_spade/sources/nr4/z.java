package nr4;

import com.dragon.read.local.db.entity.RecordModel;
import com.dragon.read.pages.bookshelf.model.BookType;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface z {
    List<lr4.i> a();

    RecordModel b(String str, BookType bookType);

    lr4.i c(String str, BookType bookType);

    List<RecordModel> d(int i, boolean z);

    List<lr4.i> e(BookType bookType);

    RecordModel f(boolean z);

    Long[] g(lr4.i... iVarArr);

    List<RecordModel> h(List<BookType> list);

    List<lr4.i> i(List<String> list);

    void j(String str, long j, long j2);

    List<RecordModel> k();

    int l(lr4.i... iVarArr);
}
