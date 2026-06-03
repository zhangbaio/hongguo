package zl4;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.graphics.n0;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.reader.background.ReaderBgColorType;
import kotlin.jvm.internal.Intrinsics;
import zl4.b;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a implements b {
    public static final a a;

    /* renamed from: zl4.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0305a {
        public static final /* synthetic */ int[] a;

        static {
            Covode.recordClassIndex(608243);
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
        Covode.recordClassIndex(608242);
        a = new a();
    }

    private a() {
    }

    @Override // zl4.b
    public int getTheme() {
        return 4;
    }

    @Override // zl4.b
    public long a() {
        return n0.b(137705789);
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
        return n0.d(4282222028L);
    }

    @Override // zl4.b
    public long g() {
        return n0.d(4293457663L);
    }

    @Override // zl4.b
    public long i() {
        return n0.d(4292273135L);
    }

    @Override // zl4.b
    public long p() {
        return n0.d(4290175999L);
    }

    @Override // zl4.b
    public long s() {
        return n0.d(4292404464L);
    }

    @Override // zl4.b
    public long u() {
        return n0.d(4282222028L);
    }

    @Override // zl4.b
    public double e(double d) {
        return b.a.w(this, d);
    }

    @Override // zl4.b
    public long l(ReaderBgColorType bgTypeColor) {
        Intrinsics.checkNotNullParameter(bgTypeColor, "bgTypeColor");
        return n0.d(4292931066L);
    }

    @Override // zl4.b
    public long m(ReaderBgColorType bgTypeColor) {
        Intrinsics.checkNotNullParameter(bgTypeColor, "bgTypeColor");
        int i = C0305a.a[bgTypeColor.ordinal()];
        if (i != 1) {
            if (i != 2) {
                return n0.d(4292404464L);
            }
            return n0.d(4290961136L);
        }
        return n0.d(4290697449L);
    }

    @Override // zl4.b
    public long v(ReaderBgColorType bgTypeColor) {
        Intrinsics.checkNotNullParameter(bgTypeColor, "bgTypeColor");
        int i = C0305a.a[bgTypeColor.ordinal()];
        if (i != 1) {
            if (i != 2) {
                return n0.d(4292931066L);
            }
            return n0.d(4292799991L);
        }
        return n0.d(4292209399L);
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
