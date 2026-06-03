package lp4;

import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.ugc.model.d6;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface b {
    void a();

    void b(String str, String str2, String str3, String str4, int i);

    void c(ym4.a aVar);

    void d();

    void e(d6 d6Var);

    void f();

    void g(ym4.a aVar);

    void h();

    void i(ym4.a aVar);

    void j();

    void k(ym4.a aVar);

    void l(String str, ym4.a aVar);

    void m(long j, int i, int i2, boolean z, ym4.a aVar);

    void n(String str, String str2, String str3, int i);

    void o(Boolean bool, d6 d6Var);

    void p(ym4.a aVar);

    public static final class a {
        static {
            Covode.recordClassIndex(609307);
        }

        public static /* synthetic */ void a(b bVar, ym4.a aVar, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    aVar = null;
                }
                bVar.p(aVar);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportClickBook");
        }

        public static /* synthetic */ void d(b bVar, ym4.a aVar, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    aVar = null;
                }
                bVar.g(aVar);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportShowBook");
        }

        public static /* synthetic */ void c(b bVar, String str, ym4.a aVar, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    aVar = null;
                }
                bVar.l(str, aVar);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportEvent");
        }

        public static /* synthetic */ void e(b bVar, String str, String str2, String str3, int i, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 8) != 0) {
                    i = 0;
                }
                bVar.n(str, str2, str3, i);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportShowNextPostBar");
        }

        public static /* synthetic */ void b(b bVar, String str, String str2, String str3, String str4, int i, int i2, Object obj) {
            int i3;
            if (obj == null) {
                if ((i2 & 16) != 0) {
                    i3 = 0;
                } else {
                    i3 = i;
                }
                bVar.b(str, str2, str3, str4, i3);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportClickNextPostBar");
        }
    }
}
