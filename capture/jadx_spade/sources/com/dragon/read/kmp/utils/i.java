package com.dragon.read.kmp.utils;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class i {
    private static final int a;
    private static final long b;

    private static final float g(float f, float f2, float f3) {
        float f4;
        if (f3 < 0.0f) {
            f3 += 1.0f;
        }
        if (f3 > 1.0f) {
            f3 -= 1.0f;
        }
        if (f3 < 0.16666667f) {
            f4 = (f2 - f) * 6.0f * f3;
        } else {
            if (f3 < 0.5f) {
                return f2;
            }
            if (f3 >= 0.6666667f) {
                return f;
            }
            f4 = (f2 - f) * (0.6666667f - f3) * 6.0f;
        }
        return f + f4;
    }

    static {
        Covode.recordClassIndex(609526);
        a = -1;
        b = androidx.compose.ui.graphics.n0.d(4282400832L);
    }

    private static final long f(float[] fArr) {
        float f;
        boolean z = false;
        float f2 = fArr[0] / 360.0f;
        float f3 = fArr[1];
        float f4 = fArr[2];
        if (f3 == 0.0f) {
            z = true;
        }
        if (z) {
            return androidx.compose.ui.graphics.n0.e(f4, f4, f4, 1.0f, (androidx.compose.ui.graphics.colorspace.c) null, 16, (Object) null);
        }
        if (f4 < 0.5f) {
            f = (1 + f3) * f4;
        } else {
            f = (f4 + f3) - (f3 * f4);
        }
        float f5 = (2 * f4) - f;
        return androidx.compose.ui.graphics.n0.e(g(f5, f, f2 + 0.33333334f), g(f5, f, f2), g(f5, f, f2 - 0.33333334f), 1.0f, (androidx.compose.ui.graphics.colorspace.c) null, 16, (Object) null);
    }

    private static final void b(long j, float[] fArr) {
        boolean z;
        float f;
        boolean z2;
        boolean z3;
        float f2;
        float f3;
        int i;
        float u = androidx.compose.ui.graphics.l0.u(j);
        float t = androidx.compose.ui.graphics.l0.t(j);
        float r = androidx.compose.ui.graphics.l0.r(j);
        float max = Math.max(u, Math.max(t, r));
        float min = Math.min(u, Math.min(t, r));
        float f4 = max - min;
        float f5 = max + min;
        float f6 = f5 / 2.0f;
        float f7 = 0.0f;
        if (f4 == 0.0f) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            f3 = 0.0f;
        } else {
            if (f6 < 0.5f) {
                f = f4 / f5;
            } else {
                f = f4 / ((2.0f - max) - min);
            }
            float f8 = f;
            if (max == u) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                float f9 = (t - r) / f4;
                if (t < r) {
                    i = 6;
                } else {
                    i = 0;
                }
                f2 = f9 + i;
            } else {
                if (max == t) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3) {
                    f2 = 2 + ((r - u) / f4);
                } else {
                    f2 = ((u - t) / f4) + 4;
                }
            }
            f7 = f2 / 6.0f;
            f3 = f8;
        }
        fArr[0] = (f7 * 360.0f) % 360.0f;
        fArr[1] = f3;
        fArr[2] = f6;
    }

    public static final long d(androidx.compose.ui.graphics.l0 l0Var, x0 cfg) {
        long j;
        e1 e1Var;
        float coerceIn;
        float coerceIn2;
        float coerceIn3;
        float coerceIn4;
        float coerceIn5;
        float coerceIn6;
        Intrinsics.checkNotNullParameter(cfg, "cfg");
        float[] fArr = new float[3];
        if (l0Var != null) {
            j = l0Var.x();
        } else {
            j = cfg.e;
        }
        b(j, fArr);
        float f = fArr[0];
        float f2 = fArr[1];
        float f3 = fArr[2];
        if (h(f, f2, cfg.a)) {
            return cfg.e;
        }
        if (((androidx.compose.ui.graphics.l0.u(j) * 0.299d) + (androidx.compose.ui.graphics.l0.t(j) * 0.587d) + (androidx.compose.ui.graphics.l0.r(j) * 0.114d)) * 100 > cfg.d) {
            e1Var = cfg.f;
        } else {
            e1Var = cfg.g;
        }
        coerceIn = RangesKt___RangesKt.coerceIn(Math.max(f2, cfg.b / 100.0f) * 100.0f, cfg.b, cfg.c);
        coerceIn2 = RangesKt___RangesKt.coerceIn(Math.max(f3, cfg.b / 100.0f) * 100.0f, cfg.b, cfg.c);
        coerceIn3 = RangesKt___RangesKt.coerceIn((coerceIn - cfg.b) / (cfg.c - r6), 0.0f, 1.0f);
        coerceIn4 = RangesKt___RangesKt.coerceIn((coerceIn2 - cfg.b) / (cfg.c - r10), 0.0f, 1.0f);
        float f4 = (e1Var.c + ((e1Var.d - r1) * coerceIn3)) / 100.0f;
        float f5 = (e1Var.a + ((e1Var.b - r1) * coerceIn4)) / 100.0f;
        coerceIn5 = RangesKt___RangesKt.coerceIn(f4, 0.0f, 1.0f);
        coerceIn6 = RangesKt___RangesKt.coerceIn(f5, 0.0f, 1.0f);
        return f(new float[]{f, coerceIn5, coerceIn6});
    }

    private static final boolean h(float f, float f2, float f3) {
        boolean z;
        if (f == a) {
            z = true;
        } else {
            z = false;
        }
        if (z || f2 < f3) {
            return true;
        }
        return false;
    }

    public static final long c(androidx.compose.ui.graphics.l0 l0Var, float f, float f2, long j) {
        float[] fArr = new float[3];
        if (l0Var != null) {
            j = l0Var.x();
        }
        b(j, fArr);
        fArr[1] = f;
        fArr[2] = f2;
        return f(fArr);
    }

    public static /* synthetic */ long e(androidx.compose.ui.graphics.l0 l0Var, x0 x0Var, int i, Object obj) {
        if ((i & 2) != 0) {
            x0Var = new x0(0.0f, 0, 0, 0, 0L, null, null, 127, null);
        }
        return d(l0Var, x0Var);
    }
}
