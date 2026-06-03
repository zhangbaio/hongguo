package nr4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.local.db.entity.Book;
import com.dragon.read.local.db.pojo.BookModel;
import com.dragon.read.pages.bookshelf.model.BookType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class r implements q {
    private final q a;

    static {
        Covode.recordClassIndex(611648);
    }

    @Override // nr4.q
    public List<lr4.q> c() {
        return this.a.c();
    }

    @Override // nr4.q
    public List<BookModel> f() {
        return this.a.f();
    }

    @Override // nr4.q
    public List<String> i() {
        return this.a.i();
    }

    @Override // nr4.q
    public List<lr4.z0> queryRealBookStatusInShelf() {
        return this.a.queryRealBookStatusInShelf();
    }

    public r(q qVar) {
        this.a = qVar;
    }

    @Override // nr4.q
    public Book v(String str) {
        return this.a.v(str);
    }

    @Override // nr4.q
    public List<lr4.q> b(List<String> list) {
        List a = com.dragon.read.local.db.e.a(list);
        ArrayList arrayList = new ArrayList();
        Iterator it2 = a.iterator();
        while (it2.hasNext()) {
            arrayList.addAll(this.a.b((List) it2.next()));
        }
        return arrayList;
    }

    @Override // nr4.q
    public Long[] d(lr4.q... qVarArr) {
        List b = com.dragon.read.local.db.e.b(qVarArr);
        ArrayList arrayList = new ArrayList();
        Iterator it2 = b.iterator();
        while (it2.hasNext()) {
            Collections.addAll(arrayList, this.a.d((lr4.q[]) ((List) it2.next()).toArray(new lr4.q[0])));
        }
        return (Long[]) arrayList.toArray(new Long[0]);
    }

    @Override // nr4.q
    public List<lr4.z0> e(List<String> list) {
        List a = com.dragon.read.local.db.e.a(list);
        ArrayList arrayList = new ArrayList();
        Iterator it2 = a.iterator();
        while (it2.hasNext()) {
            arrayList.addAll(this.a.e((List) it2.next()));
        }
        return arrayList;
    }

    @Override // nr4.q
    public List<lr4.k> g(List<String> list) {
        List a = com.dragon.read.local.db.e.a(list);
        ArrayList arrayList = new ArrayList();
        Iterator it2 = a.iterator();
        while (it2.hasNext()) {
            arrayList.addAll(this.a.g((List) it2.next()));
        }
        return arrayList;
    }

    @Override // nr4.q
    public int h(Book... bookArr) {
        Iterator it2 = com.dragon.read.local.db.e.b(bookArr).iterator();
        int i = 0;
        while (it2.hasNext()) {
            i += this.a.h((Book[]) ((List) it2.next()).toArray(new Book[0]));
        }
        return i;
    }

    @Override // nr4.q
    public int j(lr4.q... qVarArr) {
        Iterator it2 = com.dragon.read.local.db.e.b(qVarArr).iterator();
        int i = 0;
        while (it2.hasNext()) {
            i += this.a.j((lr4.q[]) ((List) it2.next()).toArray(new lr4.q[0]));
        }
        return i;
    }

    @Override // nr4.q
    public Long[] k(Book... bookArr) {
        List b = com.dragon.read.local.db.e.b(bookArr);
        ArrayList arrayList = new ArrayList();
        Iterator it2 = b.iterator();
        while (it2.hasNext()) {
            Collections.addAll(arrayList, this.a.k((Book[]) ((List) it2.next()).toArray(new Book[0])));
        }
        return (Long[]) arrayList.toArray(new Long[0]);
    }

    @Override // nr4.q
    public List<Book> l(String... strArr) {
        List b = com.dragon.read.local.db.e.b(strArr);
        ArrayList arrayList = new ArrayList();
        Iterator it2 = b.iterator();
        while (it2.hasNext()) {
            arrayList.addAll(this.a.l((String[]) ((List) it2.next()).toArray(new String[0])));
        }
        return arrayList;
    }

    @Override // nr4.q
    public lr4.q a(String str, BookType bookType) {
        return this.a.a(str, bookType);
    }
}
