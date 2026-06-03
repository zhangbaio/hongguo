package zl4;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.graphics.n0;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.reader.background.ReaderBgColorType;
import kotlin.jvm.internal.Intrinsics;
import zl4.b;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class t implements b {
    public static final t a;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            Covode.recordClassIndex(608260);
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
        Covode.recordClassIndex(608259);
        a = new t();
    }

    private t() {
    }

    @Override // zl4.b
    public int getTheme() {
        return 2;
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
    public long f() {
        return b.a.m(this);
    }

    @Override // zl4.b
    public long h() {
        return b.a.j(this);
    }

    @Override // zl4.b
    public long j() {
        return b.a.l(this);
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
    public long t() {
        return b.a.p(this);
    }

    @Override // zl4.b
    public long b() {
        return n0.d(4291592468L);
    }

    @Override // zl4.b
    public long g() {
        return n0.d(4294963680L);
    }

    @Override // zl4.b
    public long i() {
        return n0.d(4293846997L);
    }

    @Override // zl4.b
    public long o() {
        return n0.d(4279504896L);
    }

    @Override // zl4.b
    public long p() {
        return n0.d(4294634179L);
    }

    @Override // zl4.b
    public long s() {
        return n0.d(4293452750L);
    }

    @Override // zl4.b
    public long u() {
        return n0.d(4291592468L);
    }

    @Override // zl4.b
    public double e(double d) {
        return b.a.w(this, d);
    }

    @Override // zl4.b
    public long l(ReaderBgColorType bgTypeColor) {
        Intrinsics.checkNotNullParameter(bgTypeColor, "bgTypeColor");
        return n0.d(4294636254L);
    }

    @Override // zl4.b
    public long m(ReaderBgColorType bgTypeColor) {
        Intrinsics.checkNotNullParameter(bgTypeColor, "bgTypeColor");
        int i = a.a[bgTypeColor.ordinal()];
        if (i != 1) {
            if (i != 2) {
                return n0.d(4293452750L);
            }
            return n0.d(4294436047L);
        }
        return n0.d(4293250735L);
    }

    @Override // zl4.b
    public long v(ReaderBgColorType bgTypeColor) {
        Intrinsics.checkNotNullParameter(bgTypeColor, "bgTypeColor");
        int i = a.a[bgTypeColor.ordinal()];
        if (i != 1) {
            if (i != 2) {
                return n0.d(4294636254L);
            }
            return n0.d(4294701285L);
        }
        return n0.d(4294042054L);
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
