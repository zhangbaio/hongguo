package zl4;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.graphics.n0;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.reader.background.ReaderBgColorType;
import kotlin.jvm.internal.Intrinsics;
import zl4.b;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class e implements b {
    public static final e a;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            Covode.recordClassIndex(608251);
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

    static {
        Covode.recordClassIndex(608250);
        a = new e();
    }

    private e() {
    }

    @Override // zl4.b
    public double e(double d) {
        double d2 = 0.06d;
        if (!(d == 0.03d)) {
            d2 = 0.1d;
            if (!(d == 0.06d)) {
                if (d == 0.1d) {
                    return 0.2d;
                }
                if (d == 0.4d) {
                    return 0.6d;
                }
                if (d == 0.7d) {
                    return 0.8d;
                }
                return d;
            }
        }
        return d2;
    }

    @Override // zl4.b
    public int getTheme() {
        return 6;
    }

    @Override // zl4.b
    public long a() {
        return b.a.f(this);
    }

    @Override // zl4.b
    public long d() {
        return b.a.g(this);
    }

    @Override // zl4.b
    public long g() {
        return b.a.d(this);
    }

    @Override // zl4.b
    public long h() {
        return b.a.j(this);
    }

    @Override // zl4.b
    public long i() {
        return b.a.s(this);
    }

    @Override // zl4.b
    public long j() {
        return n0.b(447250508);
    }

    @Override // zl4.b
    public long k() {
        return b.a.h(this);
    }

    @Override // zl4.b
    public long n() {
        return b.a.n(this);
    }

    @Override // zl4.b
    public long q() {
        return b.a.i(this);
    }

    @Override // zl4.b
    public long u() {
        return b.a.o(this);
    }

    @Override // zl4.b
    public long b() {
        return n0.d(2583324453L);
    }

    @Override // zl4.b
    public long f() {
        return n0.d(4289232972L);
    }

    @Override // zl4.b
    public long o() {
        return n0.d(4286611584L);
    }

    @Override // zl4.b
    public long p() {
        return n0.d(4279571733L);
    }

    @Override // zl4.b
    public long s() {
        return n0.d(4279900698L);
    }

    @Override // zl4.b
    public long t() {
        return n0.d(4291581471L);
    }

    @Override // zl4.b
    public long l(ReaderBgColorType bgTypeColor) {
        Intrinsics.checkNotNullParameter(bgTypeColor, "bgTypeColor");
        return n0.d(4284045657L);
    }

    @Override // zl4.b
    public long m(ReaderBgColorType bgTypeColor) {
        Intrinsics.checkNotNullParameter(bgTypeColor, "bgTypeColor");
        int i = a.a[bgTypeColor.ordinal()];
        if (i != 1) {
            if (i != 2) {
                return n0.d(4279900698L);
            }
            return n0.d(4280229663L);
        }
        return n0.d(4280229663L);
    }

    @Override // zl4.b
    public long v(ReaderBgColorType bgTypeColor) {
        Intrinsics.checkNotNullParameter(bgTypeColor, "bgTypeColor");
        int i = a.a[bgTypeColor.ordinal()];
        if (i != 1) {
            if (i != 2) {
                return n0.d(4280690214L);
            }
            return n0.d(4281545523L);
        }
        return n0.d(4281545523L);
    }

    @Override // zl4.b
    public long c(Composer composer, int i) {
        return b.a.e(this, composer, i);
    }

    @Override // zl4.b
    public long r(Composer composer, int i) {
        return b.a.c(this, composer, i);
    }
}
