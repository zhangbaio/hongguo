package xl4;

import androidx.compose.ui.graphics.colorspace.c;
import androidx.compose.ui.graphics.l0;
import androidx.compose.ui.graphics.n0;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.j;
import com.dragon.read.kmp.utils.i;
import com.dragon.read.kmp.utils.k;
import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {
    public static final a a;

    static {
        Covode.recordClassIndex(608220);
        a = new a();
    }

    private a() {
    }

    private final float f(long j) {
        boolean z;
        boolean z2;
        float f;
        float u = l0.u(j);
        float t = l0.t(j);
        float r = l0.r(j);
        float max = Math.max(u, Math.max(t, r));
        float min = max - Math.min(u, Math.min(t, r));
        boolean z3 = true;
        if (min == 0.0f) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return 0.0f;
        }
        if (max == u) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            f = ((t - r) / min) % 6.0f;
        } else {
            if (max != t) {
                z3 = false;
            }
            if (z3) {
                f = ((r - u) / min) + 2.0f;
            } else {
                f = ((u - t) / min) + 4.0f;
            }
        }
        float f2 = f * 60.0f;
        if (f2 < 0.0f) {
            return f2 + 360.0f;
        }
        return f2;
    }

    public final long c(String color, long j, float f, float f2) {
        String stackTraceToString;
        Intrinsics.checkNotNullParameter(color, "color");
        try {
            return i.c(l0.j(k.g(k.a, color, null, 2, null)), f, f2, j);
        } catch (Exception e) {
            j jVar = j.a;
            StringBuilder sb = new StringBuilder();
            sb.append("generateBottomBgColor: ");
            sb.append(e.getMessage());
            sb.append(", stack: ");
            stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(e);
            sb.append(stackTraceToString);
            j.c(jVar, "ReservationColorUtils", sb.toString(), (Throwable) null, 4, (Object) null);
            return j;
        }
    }

    private final long e(float f, float f2, float f3, float f4) {
        Triple triple;
        float coerceIn;
        float f5 = ((f % 360.0f) + 360.0f) % 360.0f;
        float f6 = f2 * f3;
        float abs = (1.0f - Math.abs(((f5 / 60.0f) % 2.0f) - 1.0f)) * f6;
        float f7 = f3 - f6;
        Float valueOf = Float.valueOf(0.0f);
        if (f5 < 60.0f) {
            triple = new Triple(Float.valueOf(f6), Float.valueOf(abs), valueOf);
        } else if (f5 < 120.0f) {
            triple = new Triple(Float.valueOf(abs), Float.valueOf(f6), valueOf);
        } else if (f5 < 180.0f) {
            triple = new Triple(valueOf, Float.valueOf(f6), Float.valueOf(abs));
        } else if (f5 < 240.0f) {
            triple = new Triple(valueOf, Float.valueOf(abs), Float.valueOf(f6));
        } else if (f5 < 300.0f) {
            triple = new Triple(Float.valueOf(abs), valueOf, Float.valueOf(f6));
        } else {
            triple = new Triple(Float.valueOf(f6), valueOf, Float.valueOf(abs));
        }
        float floatValue = ((Number) triple.component1()).floatValue();
        float floatValue2 = ((Number) triple.component2()).floatValue();
        float floatValue3 = ((Number) triple.component3()).floatValue() + f7;
        coerceIn = RangesKt___RangesKt.coerceIn(f4, 0.0f, 1.0f);
        return n0.e(floatValue + f7, floatValue2 + f7, floatValue3, coerceIn, (c) null, 16, (Object) null);
    }

    public final long a(String str, long j, boolean z, float f, float f2, float f3) {
        Object m773constructorimpl;
        try {
            Result.Companion companion = Result.Companion;
            float f4 = f(k.g(k.a, str, null, 2, null));
            if (z) {
                f2 = f3;
            }
            m773constructorimpl = Result.m773constructorimpl(l0.j(e(f4, f, f2, 1.0f)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m773constructorimpl = Result.m773constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m776exceptionOrNullimpl(m773constructorimpl) != null) {
            m773constructorimpl = l0.j(j);
        }
        return ((l0) m773constructorimpl).x();
    }

    public static /* synthetic */ long d(a aVar, String str, long j, float f, float f2, int i, Object obj) {
        float f3;
        float f4;
        if ((i & 4) != 0) {
            f3 = 0.45f;
        } else {
            f3 = f;
        }
        if ((i & 8) != 0) {
            f4 = 0.8f;
        } else {
            f4 = f2;
        }
        return aVar.c(str, j, f3, f4);
    }

    public static /* synthetic */ long b(a aVar, String str, long j, boolean z, float f, float f2, float f3, int i, Object obj) {
        float f4;
        float f5;
        float f6;
        if ((i & 8) != 0) {
            f4 = 0.8f;
        } else {
            f4 = f;
        }
        if ((i & 16) != 0) {
            f5 = 0.3f;
        } else {
            f5 = f2;
        }
        if ((i & 32) != 0) {
            f6 = 0.13f;
        } else {
            f6 = f3;
        }
        return aVar.a(str, j, z, f4, f5, f6);
    }
}
