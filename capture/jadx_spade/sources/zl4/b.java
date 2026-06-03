package zl4;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.n0;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.reader.background.ReaderBgColorType;
import com.dragon.read.kmp.reader.ui.d0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface b {

    /* renamed from: zl4.b$b, reason: collision with other inner class name */
    public /* synthetic */ class C0306b {
        public static final /* synthetic */ int[] a;

        static {
            Covode.recordClassIndex(608246);
            int[] iArr = new int[ReaderBgColorType.values().length];
            try {
                iArr[ReaderBgColorType.DIM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ReaderBgColorType.LIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
        }
    }

    long a();

    long b();

    long c(Composer composer, int i);

    long d();

    double e(double d);

    long f();

    long g();

    int getTheme();

    long h();

    long i();

    long j();

    long k();

    long l(ReaderBgColorType readerBgColorType);

    long m(ReaderBgColorType readerBgColorType);

    long n();

    long o();

    long p();

    long q();

    long r(Composer composer, int i);

    long s();

    long t();

    long u();

    long v(ReaderBgColorType readerBgColorType);

    public static final class a {
        static {
            Covode.recordClassIndex(608245);
        }

        public static int r(b bVar) {
            return 1;
        }

        public static double w(b bVar, double d) {
            return d;
        }

        public static long l(b bVar) {
            return n0.b(450339937);
        }

        public static long a(b bVar) {
            return n0.d(4294600485L);
        }

        public static long b(b bVar) {
            return n0.d(4294635491L);
        }

        public static long d(b bVar) {
            return n0.d(4294967295L);
        }

        public static long k(b bVar) {
            return n0.d(4278190080L);
        }

        public static long m(b bVar) {
            return n0.d(4292322401L);
        }

        public static long o(b bVar) {
            return n0.d(4294600485L);
        }

        public static long p(b bVar) {
            return n0.d(4294600485L);
        }

        public static long q(b bVar) {
            return n0.d(4294375158L);
        }

        public static long s(b bVar) {
            return n0.d(4294967295L);
        }

        public static long f(b bVar) {
            return d0.c(bVar.o(), bVar.e(0.03d));
        }

        public static long g(b bVar) {
            return d0.c(bVar.o(), bVar.e(0.06d));
        }

        public static long h(b bVar) {
            return d0.c(bVar.o(), bVar.e(0.1d));
        }

        public static long i(b bVar) {
            return d0.c(bVar.o(), bVar.e(0.4d));
        }

        public static long j(b bVar) {
            return d0.c(bVar.o(), bVar.e(0.7d));
        }

        public static long n(b bVar) {
            return d0.c(bVar.u(), bVar.e(0.1d));
        }

        public static long v(b bVar, ReaderBgColorType bgTypeColor) {
            Intrinsics.checkNotNullParameter(bgTypeColor, "bgTypeColor");
            return n0.d(4294967295L);
        }

        public static long t(b bVar, ReaderBgColorType bgTypeColor) {
            Intrinsics.checkNotNullParameter(bgTypeColor, "bgTypeColor");
            int i = C0306b.a[bgTypeColor.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    return n0.d(4294375158L);
                }
                return n0.d(4292335579L);
            }
            return n0.d(4292598747L);
        }

        public static long u(b bVar, ReaderBgColorType bgTypeColor) {
            Intrinsics.checkNotNullParameter(bgTypeColor, "bgTypeColor");
            int i = C0306b.a[bgTypeColor.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    return n0.d(4294967295L);
                }
                return n0.d(4293585644L);
            }
            return n0.d(4294111986L);
        }

        public static long c(b bVar, Composer composer, int i) {
            composer.startReplaceGroup(1562673802);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1562673802, i, -1, "com.dragon.read.kmp.reader.base.RSColorScheme.<get-globalBgColor> (RSColorScheme.kt:112)");
            }
            long m = bVar.m(s.a.a(composer, 6));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            return m;
        }

        public static long e(b bVar, Composer composer, int i) {
            composer.startReplaceGroup(-517134348);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-517134348, i, -1, "com.dragon.read.kmp.reader.base.RSColorScheme.<get-globalCardColor> (RSColorScheme.kt:98)");
            }
            long v = bVar.v(s.a.a(composer, 6));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            return v;
        }
    }
}
