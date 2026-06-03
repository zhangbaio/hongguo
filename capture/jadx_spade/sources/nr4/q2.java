package nr4;

import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface q2 {
    void a(String str);

    int b(String str);

    void c(List<lr4.t0> list);

    int d(String str);

    List<lr4.t0> e(String str);

    List<Long> f(List<lr4.t0> list);

    public static class a implements q2 {
        private final q2 a;

        static {
            Covode.recordClassIndex(611735);
        }

        public a(q2 q2Var) {
            this.a = q2Var;
        }

        @Override // nr4.q2
        public void a(String str) {
            this.a.a(str);
        }

        @Override // nr4.q2
        public int b(String str) {
            return this.a.b(str);
        }

        @Override // nr4.q2
        public int d(String str) {
            return this.a.d(str);
        }

        @Override // nr4.q2
        public List<lr4.t0> e(String str) {
            return this.a.e(str);
        }

        @Override // nr4.q2
        public void c(List<lr4.t0> list) {
            Iterator it2 = com.dragon.read.local.db.p.a(list).iterator();
            while (it2.hasNext()) {
                this.a.c((List) it2.next());
            }
        }

        @Override // nr4.q2
        public List<Long> f(List<lr4.t0> list) {
            List a = com.dragon.read.local.db.p.a(list);
            ArrayList arrayList = new ArrayList();
            Iterator it2 = a.iterator();
            while (it2.hasNext()) {
                arrayList.addAll(this.a.f((List) it2.next()));
            }
            return arrayList;
        }
    }
}
