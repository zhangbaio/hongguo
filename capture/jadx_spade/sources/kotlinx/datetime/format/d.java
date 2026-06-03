package kotlinx.datetime.format;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.format.c;
import kotlinx.datetime.format.f;
import kotlinx.datetime.format.y;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface d extends c, f, y.b {
    void i(kotlinx.datetime.internal.format.n<Object> nVar);

    public static final class a {
        static {
            Covode.recordClassIndex(659438);
        }

        public static void k(d dVar, int i) {
            f.a.d(dVar, i);
        }

        public static void o(d dVar, int i) {
            c.a.g(dVar, i);
        }

        public static void a(d dVar, kotlinx.datetime.internal.format.n<? super g> structure) {
            Intrinsics.checkNotNullParameter(structure, "structure");
            dVar.i(structure);
        }

        public static void b(d dVar, kotlinx.datetime.internal.format.n<? super g1> structure) {
            Intrinsics.checkNotNullParameter(structure, "structure");
            dVar.i(structure);
        }

        public static void c(d dVar, x<kotlinx.datetime.c> format) {
            Intrinsics.checkNotNullParameter(format, "format");
            c.a.a(dVar, format);
        }

        public static void d(d dVar, Padding padding) {
            Intrinsics.checkNotNullParameter(padding, "padding");
            c.a.b(dVar, padding);
        }

        public static void e(d dVar, DayOfWeekNames names) {
            Intrinsics.checkNotNullParameter(names, "names");
            c.a.c(dVar, names);
        }

        public static void f(d dVar, Padding padding) {
            Intrinsics.checkNotNullParameter(padding, "padding");
            f.a.a(dVar, padding);
        }

        public static void g(d dVar, Padding padding) {
            Intrinsics.checkNotNullParameter(padding, "padding");
            f.a.b(dVar, padding);
        }

        public static void h(d dVar, MonthNames names) {
            Intrinsics.checkNotNullParameter(names, "names");
            c.a.d(dVar, names);
        }

        public static void i(d dVar, Padding padding) {
            Intrinsics.checkNotNullParameter(padding, "padding");
            c.a.e(dVar, padding);
        }

        public static void j(d dVar, Padding padding) {
            Intrinsics.checkNotNullParameter(padding, "padding");
            f.a.c(dVar, padding);
        }

        public static void m(d dVar, x<zm6.j> format) {
            Intrinsics.checkNotNullParameter(format, "format");
            f.a.f(dVar, format);
        }

        public static void n(d dVar, Padding padding) {
            Intrinsics.checkNotNullParameter(padding, "padding");
            c.a.f(dVar, padding);
        }

        public static void l(d dVar, int i, int i2) {
            f.a.e(dVar, i, i2);
        }
    }
}
