package nr4;

import com.dragon.read.local.db.entity.Book;
import com.dragon.read.local.db.pojo.BookModel;
import com.dragon.read.pages.bookshelf.model.BookType;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface q {
    lr4.q a(String str, BookType bookType);

    List<lr4.q> b(List<String> list);

    List<lr4.q> c();

    Long[] d(lr4.q... qVarArr);

    List<lr4.z0> e(List<String> list);

    List<BookModel> f();

    List<lr4.k> g(List<String> list);

    int h(Book... bookArr);

    List<String> i();

    int j(lr4.q... qVarArr);

    Long[] k(Book... bookArr);

    List<Book> l(String... strArr);

    List<lr4.z0> queryRealBookStatusInShelf();

    Book v(String str);
}
