package nr4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.local.db.entity.RecordModel;
import com.dragon.read.pages.bookshelf.model.BookType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class a0 implements z {
    private final z a;

    static {
        Covode.recordClassIndex(611657);
    }

    @Override // nr4.z
    public List<lr4.i> a() {
        return this.a.a();
    }

    @Override // nr4.z
    public List<RecordModel> k() {
        return this.a.k();
    }

    public a0(z zVar) {
        this.a = zVar;
    }

    @Override // nr4.z
    public List<lr4.i> e(BookType bookType) {
        return this.a.e(bookType);
    }

    @Override // nr4.z
    public RecordModel f(boolean z) {
        return this.a.f(z);
    }

    @Override // nr4.z
    public List<RecordModel> h(List<BookType> list) {
        return this.a.h(list);
    }

    @Override // nr4.z
    public Long[] g(lr4.i... iVarArr) {
        List b = com.dragon.read.local.db.e.b(iVarArr);
        ArrayList arrayList = new ArrayList();
        Iterator it2 = b.iterator();
        while (it2.hasNext()) {
            Collections.addAll(arrayList, this.a.g((lr4.i[]) ((List) it2.next()).toArray(new lr4.i[0])));
        }
        return (Long[]) arrayList.toArray(new Long[0]);
    }

    @Override // nr4.z
    public List<lr4.i> i(List<String> list) {
        List a = com.dragon.read.local.db.e.a(list);
        ArrayList arrayList = new ArrayList();
        Iterator it2 = a.iterator();
        while (it2.hasNext()) {
            arrayList.addAll(this.a.i((List) it2.next()));
        }
        return arrayList;
    }

    @Override // nr4.z
    public int l(lr4.i... iVarArr) {
        Iterator it2 = com.dragon.read.local.db.e.b(iVarArr).iterator();
        int i = 0;
        while (it2.hasNext()) {
            i += this.a.l((lr4.i[]) ((List) it2.next()).toArray(new lr4.i[0]));
        }
        return i;
    }

    @Override // nr4.z
    public RecordModel b(String str, BookType bookType) {
        return this.a.b(str, bookType);
    }

    @Override // nr4.z
    public lr4.i c(String str, BookType bookType) {
        return this.a.c(str, bookType);
    }

    @Override // nr4.z
    public List<RecordModel> d(int i, boolean z) {
        return this.a.d(i, z);
    }

    @Override // nr4.z
    public void j(String str, long j, long j2) {
        this.a.j(str, j, j2);
    }
}
