package com.dragon.read.kmp.profile.guestprofile.view;

import com.bytedance.covode.number.Covode;
import kotlin.ranges.RangesKt___RangesKt;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {
    public static final a a;

    static {
        Covode.recordClassIndex(608163);
        a = new a();
    }

    private a() {
    }

    private final float c(float f, float f2, float f3, float f4, float f5) {
        float f6 = f3 - f2;
        return (f6 > 0.0f ? 1 : (f6 == 0.0f ? 0 : -1)) == 0 ? f4 : f4 + (((f - f2) / f6) * (f5 - f4));
    }

    public final long d(long j) {
        try {
            float[] fArr = {0.0f, 0.0f, 0.0f};
            com.dragon.read.kmp.utils.k kVar = com.dragon.read.kmp.utils.k.a;
            kVar.a(j, fArr);
            if (fArr[1] < 0.1f) {
                return com.dragon.read.kmp.utils.k.e(kVar, "#606060", 0L, 2, null);
            }
            long b = b(this, fArr, "#606060", 0.0f, 4, null);
            kVar.a(b, new float[]{0.0f, 0.0f, 0.0f});
            return b;
        } catch (Exception e) {
            e.printStackTrace();
            co0.b.a();
            System.out.println((Object) ("BackgroundMaskUtil: parse color error"));
            return com.dragon.read.kmp.utils.k.e(com.dragon.read.kmp.utils.k.a, "#606060", 0L, 2, null);
        }
    }

    private final long a(float[] fArr, String str, float f) {
        float coerceIn;
        float coerceIn2;
        float c;
        float c2;
        boolean z;
        float f2 = fArr[0];
        float f3 = fArr[1];
        float f4 = fArr[2];
        if (str != null) {
            if (f2 == -1.0f) {
                z = true;
            } else {
                z = false;
            }
            if (z || f3 < f) {
                return com.dragon.read.kmp.utils.k.e(com.dragon.read.kmp.utils.k.a, str, 0L, 2, null);
            }
        }
        com.dragon.read.kmp.utils.k kVar = com.dragon.read.kmp.utils.k.a;
        long c3 = com.dragon.read.kmp.utils.k.c(kVar, new float[]{f2, f3, f4}, 0.0f, 2, null);
        double u = ((((androidx.compose.ui.graphics.l0.u(c3) * 0.299d) + (androidx.compose.ui.graphics.l0.t(c3) * 0.587d)) + (androidx.compose.ui.graphics.l0.r(c3) * 0.114d)) / 255) * 100;
        coerceIn = RangesKt___RangesKt.coerceIn(f4 * 100.0f, 25.0f, 100.0f);
        coerceIn2 = RangesKt___RangesKt.coerceIn(f3 * 100.0f, 25.0f, 100.0f);
        if (u > 50.0d) {
            c = c(coerceIn, 25.0f, 100.0f, 25.0f, 40.0f);
            c2 = c(coerceIn2, 25.0f, 100.0f, 25.0f, 60.0f);
        } else {
            c = c(coerceIn, 25.0f, 100.0f, 25.0f, 30.0f);
            c2 = c(coerceIn2, 25.0f, 100.0f, 25.0f, 60.0f);
        }
        float f5 = c - 10;
        if (f5 < 20.0f) {
            f5 = 20.0f;
        }
        float f6 = 100;
        return com.dragon.read.kmp.utils.k.c(kVar, new float[]{f2, c2 / f6, f5 / f6}, 0.0f, 2, null);
    }

    static /* synthetic */ long b(a aVar, float[] fArr, String str, float f, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "#404040";
        }
        if ((i & 4) != 0) {
            f = 0.1f;
        }
        return aVar.a(fArr, str, f);
    }
}
