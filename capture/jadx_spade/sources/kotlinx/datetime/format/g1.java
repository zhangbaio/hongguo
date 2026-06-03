package kotlinx.datetime.format;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface g1 {
    void B(Integer num);

    void C(Integer num);

    void b(Integer num);

    void f(an6.a aVar);

    void h(AmPmMarker amPmMarker);

    Integer i();

    Integer k();

    an6.a l();

    Integer o();

    Integer p();

    AmPmMarker s();

    void t(Integer num);

    void u(Integer num);

    Integer x();

    public static final class a {
        static {
            Covode.recordClassIndex(659513);
        }

        public static an6.a a(g1 g1Var) {
            Integer o = g1Var.o();
            if (o != null) {
                return new an6.a(o.intValue(), 9);
            }
            return null;
        }

        public static void b(g1 g1Var, an6.a aVar) {
            Integer num;
            if (aVar != null) {
                num = Integer.valueOf(aVar.b(9));
            } else {
                num = null;
            }
            g1Var.u(num);
        }
    }
}
