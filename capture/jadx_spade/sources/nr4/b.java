package nr4;

import com.bytedance.covode.number.Covode;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class b implements a {
    private final a a;

    static {
        Covode.recordClassIndex(611632);
    }

    @Override // nr4.a
    public List<lr4.a> c() {
        return this.a.c();
    }

    public b(a aVar) {
        this.a = aVar;
    }

    @Override // nr4.a
    public void a(lr4.a aVar) {
        this.a.a(aVar);
    }

    @Override // nr4.a
    public lr4.a d(String str) {
        return this.a.d(str);
    }

    @Override // nr4.a
    public void b(List<lr4.a> list) {
        Iterator it2 = com.dragon.read.local.db.e.a(list).iterator();
        while (it2.hasNext()) {
            this.a.b((List) it2.next());
        }
    }
}
