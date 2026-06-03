package nr4;

import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface w2 {
    void a(String str);

    int b(String str);

    void c(List<lr4.w0> list);

    int d(String str);

    List<Long> e(List<lr4.w0> list);

    void f(List<lr4.w0> list);

    void g(String str);

    List<lr4.w0> h(String str);

    List<lr4.w0> i(String str);

    List<lr4.w0> j();

    public static class a implements w2 {
        private final w2 a;

        static {
            Covode.recordClassIndex(611744);
        }

        @Override // nr4.w2
        public List<lr4.w0> j() {
            return this.a.j();
        }

        public a(w2 w2Var) {
            this.a = w2Var;
        }

        @Override // nr4.w2
        public void a(String str) {
            this.a.a(str);
        }

        @Override // nr4.w2
        public int b(String str) {
            return this.a.b(str);
        }

        @Override // nr4.w2
        public int d(String str) {
            return this.a.d(str);
        }

        @Override // nr4.w2
        public void g(String str) {
            this.a.g(str);
        }

        @Override // nr4.w2
        public List<lr4.w0> h(String str) {
            return this.a.h(str);
        }

        @Override // nr4.w2
        public List<lr4.w0> i(String str) {
            return this.a.i(str);
        }

        @Override // nr4.w2
        public void c(List<lr4.w0> list) {
            Iterator it2 = com.dragon.read.local.db.p.a(list).iterator();
            while (it2.hasNext()) {
                this.a.c((List) it2.next());
            }
        }

        @Override // nr4.w2
        public void f(List<lr4.w0> list) {
            Iterator it2 = com.dragon.read.local.db.p.a(list).iterator();
            while (it2.hasNext()) {
                this.a.f((List) it2.next());
            }
        }

        @Override // nr4.w2
        public List<Long> e(List<lr4.w0> list) {
            List a = com.dragon.read.local.db.p.a(list);
            ArrayList arrayList = new ArrayList();
            Iterator it2 = a.iterator();
            while (it2.hasNext()) {
                arrayList.addAll(this.a.e((List) it2.next()));
            }
            return arrayList;
        }
    }
}
