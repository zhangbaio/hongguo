package lq4;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface a {
    nq4.a a();

    int b(String str);

    /* renamed from: lq4.a$a, reason: collision with other inner class name */
    public static final class C0238a {
        static {
            Covode.recordClassIndex(611282);
        }

        public static int a(a aVar, String str) {
            nq4.a a = aVar.a();
            if (a != null) {
                if (str == null) {
                    return a.a();
                }
                return a.c(str);
            }
            return 0;
        }

        public static /* synthetic */ int b(a aVar, String str, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    str = null;
                }
                return aVar.b(str);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getCnt");
        }
    }
}
