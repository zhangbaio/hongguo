package nr4;

import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface m2 {
    List<lr4.r0> a();

    Long[] b(List<lr4.r0> list);

    public static class a implements m2 {
        private final m2 a;

        static {
            Covode.recordClassIndex(611729);
        }

        @Override // nr4.m2
        public List<lr4.r0> a() {
            try {
                return this.a.a();
            } catch (Exception unused) {
                return new ArrayList();
            }
        }

        public a(m2 m2Var) {
            this.a = m2Var;
        }

        @Override // nr4.m2
        public Long[] b(List<lr4.r0> list) {
            List a = com.dragon.read.local.db.p.a(list);
            ArrayList arrayList = new ArrayList();
            Iterator it2 = a.iterator();
            while (it2.hasNext()) {
                Collections.addAll(arrayList, this.a.b((List) it2.next()));
            }
            return (Long[]) arrayList.toArray(new Long[0]);
        }
    }
}
