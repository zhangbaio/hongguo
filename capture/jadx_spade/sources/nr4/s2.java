package nr4;

import com.bytedance.covode.number.Covode;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface s2 {
    List<lr4.u0> a();

    List<lr4.u0> b();

    void delete(String str);

    void delete(List<lr4.u0> list);

    void insert(List<lr4.u0> list);

    lr4.u0 query(String str);

    public static class a implements s2 {
        private s2 a;

        static {
            Covode.recordClassIndex(611738);
        }

        @Override // nr4.s2
        public List<lr4.u0> a() {
            return this.a.a();
        }

        @Override // nr4.s2
        public List<lr4.u0> b() {
            return this.a.b();
        }

        public a(s2 s2Var) {
            this.a = s2Var;
        }

        @Override // nr4.s2
        public void delete(String str) {
            this.a.delete(str);
        }

        @Override // nr4.s2
        public lr4.u0 query(String str) {
            return this.a.query(str);
        }

        @Override // nr4.s2
        public void delete(List<lr4.u0> list) {
            Iterator it2 = com.dragon.read.local.db.p.a(list).iterator();
            while (it2.hasNext()) {
                this.a.delete((List<lr4.u0>) it2.next());
            }
        }

        @Override // nr4.s2
        public void insert(List<lr4.u0> list) {
            Iterator it2 = com.dragon.read.local.db.p.a(list).iterator();
            while (it2.hasNext()) {
                this.a.insert((List) it2.next());
            }
        }
    }
}
