package kotlinx.datetime.format;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.format.y;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface c extends y.a {
    void z(kotlinx.datetime.internal.format.n<? super g> nVar);

    public static final class a {
        static {
            Covode.recordClassIndex(659436);
        }

        public static void a(c cVar, x<kotlinx.datetime.c> format) {
            Intrinsics.checkNotNullParameter(format, "format");
            if (format instanceof i0) {
                cVar.z(((i0) format).b());
            }
        }

        public static void b(c cVar, Padding padding) {
            Intrinsics.checkNotNullParameter(padding, "padding");
            cVar.z(new kotlinx.datetime.internal.format.e(new a0(padding)));
        }

        public static void c(c cVar, DayOfWeekNames names) {
            Intrinsics.checkNotNullParameter(names, "names");
            cVar.z(new kotlinx.datetime.internal.format.e(new b0(names)));
        }

        public static void d(c cVar, MonthNames names) {
            Intrinsics.checkNotNullParameter(names, "names");
            cVar.z(new kotlinx.datetime.internal.format.e(new d1(names)));
        }

        public static void e(c cVar, Padding padding) {
            Intrinsics.checkNotNullParameter(padding, "padding");
            cVar.z(new kotlinx.datetime.internal.format.e(new c1(padding)));
        }

        public static void f(c cVar, Padding padding) {
            Intrinsics.checkNotNullParameter(padding, "padding");
            cVar.z(new kotlinx.datetime.internal.format.e(new p2(padding, false, 2, null)));
        }

        public static void g(c cVar, int i) {
            cVar.z(new kotlinx.datetime.internal.format.e(new e1(i, false, 2, null)));
        }
    }
}
