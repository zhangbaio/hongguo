package nr4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.ListUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class o implements n {
    private n a;

    static {
        Covode.recordClassIndex(611645);
    }

    public o(n nVar) {
        this.a = nVar;
    }

    @Override // nr4.n
    public lr4.f b(String str) {
        return this.a.b(str);
    }

    @Override // nr4.n
    public List<lr4.f> a(List<String> list) {
        List a = com.dragon.read.local.db.e.a(list);
        ArrayList arrayList = new ArrayList();
        Iterator it2 = a.iterator();
        while (it2.hasNext()) {
            List<lr4.f> a2 = this.a.a((List) it2.next());
            if (!ListUtils.isEmpty(a2)) {
                arrayList.addAll(a2);
            }
        }
        return arrayList;
    }

    @Override // nr4.n
    public int delete(lr4.f... fVarArr) {
        Iterator it2 = com.dragon.read.local.db.e.b(fVarArr).iterator();
        int i = 0;
        while (it2.hasNext()) {
            i += this.a.delete((lr4.f[]) ((List) it2.next()).toArray(new lr4.f[0]));
        }
        return i;
    }

    @Override // nr4.n
    public Long[] insert(lr4.f... fVarArr) {
        List b = com.dragon.read.local.db.e.b(fVarArr);
        ArrayList arrayList = new ArrayList();
        Iterator it2 = b.iterator();
        while (it2.hasNext()) {
            Collections.addAll(arrayList, this.a.insert((lr4.f[]) ((List) it2.next()).toArray(new lr4.f[0])));
        }
        return (Long[]) arrayList.toArray(new Long[0]);
    }
}
