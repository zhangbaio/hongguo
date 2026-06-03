package kotlinx.datetime.format;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.format.y;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface f extends y.d {
    void c(kotlinx.datetime.internal.format.n<? super g1> nVar);

    public static final class a {
        static {
            Covode.recordClassIndex(659442);
        }

        public static void d(f fVar, int i) {
            y.d.a.d(fVar, i);
        }

        public static void a(f fVar, Padding padding) {
            Intrinsics.checkNotNullParameter(padding, "padding");
            fVar.c(new kotlinx.datetime.internal.format.e(new d0(padding)));
        }

        public static void b(f fVar, Padding padding) {
            Intrinsics.checkNotNullParameter(padding, "padding");
            fVar.c(new kotlinx.datetime.internal.format.e(new b1(padding)));
        }

        public static void c(f fVar, Padding padding) {
            Intrinsics.checkNotNullParameter(padding, "padding");
            fVar.c(new kotlinx.datetime.internal.format.e(new f1(padding)));
        }

        public static void f(f fVar, x<zm6.j> format) {
            Intrinsics.checkNotNullParameter(format, "format");
            if (format instanceof u0) {
                fVar.c(((u0) format).b());
            }
        }

        public static void e(f fVar, int i, int i2) {
            fVar.c(new kotlinx.datetime.internal.format.e(new c0(i, i2, null, 4, null)));
        }
    }
}
