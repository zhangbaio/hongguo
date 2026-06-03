package kotlinx.datetime.format;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.format.y;
import kotlinx.datetime.internal.format.SignedFormatStructure;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface e extends y.e {
    void b(kotlinx.datetime.internal.format.n<? super o1> nVar);

    public static final class a {
        static {
            Covode.recordClassIndex(659440);
        }

        public static void a(e eVar, x<zm6.o> format) {
            Intrinsics.checkNotNullParameter(format, "format");
            if (format instanceof p1) {
                eVar.b(((p1) format).b());
            }
        }

        public static void b(e eVar, Padding padding) {
            Intrinsics.checkNotNullParameter(padding, "padding");
            eVar.b(new SignedFormatStructure(new kotlinx.datetime.internal.format.e(new o2(padding)), true));
        }

        public static void c(e eVar, Padding padding) {
            Intrinsics.checkNotNullParameter(padding, "padding");
            eVar.b(new kotlinx.datetime.internal.format.e(new m2(padding)));
        }

        public static void d(e eVar, Padding padding) {
            Intrinsics.checkNotNullParameter(padding, "padding");
            eVar.b(new kotlinx.datetime.internal.format.e(new n2(padding)));
        }
    }
}
