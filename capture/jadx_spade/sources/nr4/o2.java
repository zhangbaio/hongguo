package nr4;

import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface o2 {
    void a(String str);

    int b(String str);

    void c(List<lr4.s0> list);

    List<Long> d(List<lr4.s0> list);

    List<lr4.s0> e(String str);

    public static class a implements o2 {
        private final o2 a;

        static {
            Covode.recordClassIndex(611732);
        }

        public a(o2 o2Var) {
            this.a = o2Var;
        }

        @Override // nr4.o2
        public void a(String str) {
            this.a.a(str);
        }

        @Override // nr4.o2
        public int b(String str) {
            return this.a.b(str);
        }

        @Override // nr4.o2
        public List<lr4.s0> e(String str) {
            return this.a.e(str);
        }

        @Override // nr4.o2
        public void c(List<lr4.s0> list) {
            Iterator it2 = com.dragon.read.local.db.p.a(list).iterator();
            while (it2.hasNext()) {
                this.a.c((List) it2.next());
            }
        }

        @Override // nr4.o2
        public List<Long> d(List<lr4.s0> list) {
            List a = com.dragon.read.local.db.p.a(list);
            ArrayList arrayList = new ArrayList();
            Iterator it2 = a.iterator();
            while (it2.hasNext()) {
                arrayList.addAll(this.a.d((List) it2.next()));
            }
            return arrayList;
        }
    }
}
