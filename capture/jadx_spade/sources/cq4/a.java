package cq4;

import androidx.compose.ui.graphics.l0;
import androidx.compose.ui.graphics.n0;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.base.h;
import com.dragon.read.kmp.utils.k;
import com.dragon.read.kmp.utils.v;
import dn6.s;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import yn0.a;
import yn0.b;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {
    public static final a a;

    /* renamed from: cq4.a$a, reason: collision with other inner class name */
    private static final class C0139a {
        public String a;
        public String b;

        static {
            Covode.recordClassIndex(609425);
        }
    }

    static {
        Covode.recordClassIndex(609424);
        a = new a();
    }

    private a() {
    }

    private final boolean b(float f, float f2) {
        return ((f > (-1.0f) ? 1 : (f == (-1.0f) ? 0 : -1)) == 0) || f2 < 0.05f;
    }

    public final long a(float[] hsl) {
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        int i;
        Intrinsics.checkNotNullParameter(hsl, "hsl");
        Float orNull = ArraysKt___ArraysKt.getOrNull(hsl, 0);
        if (orNull != null) {
            f = orNull.floatValue();
        } else {
            f = 0.0f;
        }
        Float orNull2 = ArraysKt___ArraysKt.getOrNull(hsl, 1);
        if (orNull2 != null) {
            f2 = orNull2.floatValue();
        } else {
            f2 = 0.0f;
        }
        Float orNull3 = ArraysKt___ArraysKt.getOrNull(hsl, 2);
        if (orNull3 != null) {
            f3 = orNull3.floatValue();
        } else {
            f3 = 0.0f;
        }
        if (b(f, f2)) {
            return n0.d(4282400832L);
        }
        k kVar = k.a;
        long c = k.c(kVar, new float[]{f, f2, f3}, 0.0f, 2, null);
        double u = ((((l0.u(c) * 0.299d) + (l0.t(c) * 0.587d)) + (l0.r(c) * 0.114d)) / 255) * 100;
        float f7 = 25.0f;
        if (f3 > 0.25d) {
            f4 = f3 * 100;
        } else {
            f4 = 25.0f;
        }
        if (f2 > 0.25d) {
            f7 = 100 * f2;
        }
        if (u > 50.0d) {
            f5 = 25;
            f6 = f4 - f5;
            i = 15;
        } else {
            f5 = 25;
            f6 = f4 - f5;
            i = 5;
        }
        float f8 = 75;
        float f9 = 100;
        return k.c(kVar, new float[]{f, (f5 + (((f7 - f5) * 35) / f8)) / f9, (((f6 * i) / f8) + f5) / f9}, 0.0f, 2, null);
    }

    public final List<l0> c(String str, List<l0> defaultColors) {
        boolean z;
        Object m773constructorimpl;
        long x;
        long x2;
        List<l0> listOf;
        Intrinsics.checkNotNullParameter(defaultColors, "defaultColors");
        try {
            v vVar = v.a;
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            Object obj = null;
            if (!z) {
                try {
                    Result.Companion companion = Result.Companion;
                    gn6.a c = h.c();
                    m773constructorimpl = Result.m773constructorimpl(c.c(en6.a.u(s.a(c.getSerializersModule(), Reflection.getOrCreateKotlinClass(C0139a.class))), str));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    m773constructorimpl = Result.m773constructorimpl(ResultKt.createFailure(th));
                }
                Throwable m776exceptionOrNullimpl = Result.m776exceptionOrNullimpl(m773constructorimpl);
                if (m776exceptionOrNullimpl != null) {
                    a.a.b(b.b, "JSONUtils", "fromJson json error " + m776exceptionOrNullimpl.getMessage(), false, 4, (Object) null);
                }
                if (!Result.m779isFailureimpl(m773constructorimpl)) {
                    obj = m773constructorimpl;
                }
            }
            C0139a c0139a = (C0139a) obj;
            if (c0139a != null) {
                k kVar = k.a;
                x = kVar.d(c0139a.a, defaultColors.get(0).x());
                x2 = kVar.d(c0139a.b, defaultColors.get(1).x());
            } else {
                x = defaultColors.get(0).x();
                x2 = defaultColors.get(1).x();
            }
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new l0[]{l0.j(x), l0.j(x2)});
            return listOf;
        } catch (Exception unused) {
            return defaultColors;
        }
    }
}
