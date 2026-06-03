package zl4;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.graphics.n0;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.reader.background.ReaderBgColorType;
import kotlin.jvm.internal.Intrinsics;
import zl4.b;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class g implements b {
    public static final g a;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            Covode.recordClassIndex(608255);
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
        Covode.recordClassIndex(608254);
        a = new g();
    }

    private g() {
    }

    @Override // zl4.b
    public int getTheme() {
        return 3;
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
    public long o() {
        return b.a.k(this);
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
        return n0.d(4284848430L);
    }

    @Override // zl4.b
    public long g() {
        return n0.d(4293786345L);
    }

    @Override // zl4.b
    public long i() {
        return n0.d(4293062358L);
    }

    @Override // zl4.b
    public long p() {
        return n0.d(4292276666L);
    }

    @Override // zl4.b
    public long s() {
        return n0.d(4293193944L);
    }

    @Override // zl4.b
    public long u() {
        return n0.d(4284848430L);
    }

    @Override // zl4.b
    public double e(double d) {
        return b.a.w(this, d);
    }

    @Override // zl4.b
    public long l(ReaderBgColorType bgTypeColor) {
        Intrinsics.checkNotNullParameter(bgTypeColor, "bgTypeColor");
        return n0.d(4293786337L);
    }

    @Override // zl4.b
    public long m(ReaderBgColorType bgTypeColor) {
        Intrinsics.checkNotNullParameter(bgTypeColor, "bgTypeColor");
        int i = a.a[bgTypeColor.ordinal()];
        if (i != 1) {
            if (i != 2) {
                return n0.d(4293193944L);
            }
            return n0.d(4291419851L);
        }
        return n0.d(4291615677L);
    }

    @Override // zl4.b
    public long v(ReaderBgColorType bgTypeColor) {
        Intrinsics.checkNotNullParameter(bgTypeColor, "bgTypeColor");
        int i = a.a[bgTypeColor.ordinal()];
        if (i != 1) {
            if (i != 2) {
                return n0.d(4293786337L);
            }
            return n0.d(4293325031L);
        }
        return n0.d(4292930518L);
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
