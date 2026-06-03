package nr4;

import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface i2 {
    void a(String str);

    int b(String str);

    void c(List<lr4.p0> list);

    void d(String str);

    List<lr4.p0> e(String str);

    List<lr4.p0> f(String str);

    List<Long> g(List<lr4.p0> list);

    void h(List<lr4.p0> list);

    List<lr4.p0> i();

    public static class a implements i2 {
        private final i2 a;

        static {
            Covode.recordClassIndex(611723);
        }

        @Override // nr4.i2
        public List<lr4.p0> i() {
            return this.a.i();
        }

        public a(i2 i2Var) {
            this.a = i2Var;
        }

        @Override // nr4.i2
        public void a(String str) {
            this.a.a(str);
        }

        @Override // nr4.i2
        public int b(String str) {
            return this.a.b(str);
        }

        @Override // nr4.i2
        public void d(String str) {
            this.a.d(str);
        }

        @Override // nr4.i2
        public List<lr4.p0> e(String str) {
            return this.a.e(str);
        }

        @Override // nr4.i2
        public List<lr4.p0> f(String str) {
            return this.a.f(str);
        }

        @Override // nr4.i2
        public void c(List<lr4.p0> list) {
            Iterator it2 = com.dragon.read.local.db.p.a(list).iterator();
            while (it2.hasNext()) {
                this.a.c((List) it2.next());
            }
        }

        @Override // nr4.i2
        public void h(List<lr4.p0> list) {
            Iterator it2 = com.dragon.read.local.db.p.a(list).iterator();
            while (it2.hasNext()) {
                this.a.h((List) it2.next());
            }
        }

        @Override // nr4.i2
        public List<Long> g(List<lr4.p0> list) {
            List a = com.dragon.read.local.db.p.a(list);
            ArrayList arrayList = new ArrayList();
            Iterator it2 = a.iterator();
            while (it2.hasNext()) {
                arrayList.addAll(this.a.g((List) it2.next()));
            }
            return arrayList;
        }
    }
}
