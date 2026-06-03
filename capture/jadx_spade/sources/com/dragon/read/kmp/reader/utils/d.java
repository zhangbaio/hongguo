package com.dragon.read.kmp.reader.utils;

import androidx.compose.ui.graphics.n0;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class d {
    public static final d a;

    static {
        Covode.recordClassIndex(608651);
        a = new d();
    }

    private d() {
    }

    public final long b(long j) {
        float[] fArr = {0.0f, 0.0f, 0.0f};
        com.dragon.read.kmp.util.c cVar = com.dragon.read.kmp.util.c.a;
        cVar.a(n0.k(j), fArr);
        return n0.b(cVar.b(new float[]{fArr[0], 0.4f, 0.5f}));
    }

    public final long c(long j) {
        float[] fArr = {0.0f, 0.0f, 0.0f};
        com.dragon.read.kmp.util.c cVar = com.dragon.read.kmp.util.c.a;
        cVar.a(n0.k(j), fArr);
        return n0.b(cVar.b(new float[]{fArr[0], 0.4f, 0.24f}));
    }

    public final long a(String str) {
        boolean z;
        float f;
        com.dragon.read.kmp.util.c cVar = com.dragon.read.kmp.util.c.a;
        float[] fArr = {0.0f, 0.0f, 0.0f};
        cVar.a(cVar.g(str, "#FFFFFF"), fArr);
        float f2 = fArr[0];
        float f3 = fArr[1];
        float f4 = fArr[2];
        if (f2 == 0.0f) {
            z = true;
        } else {
            z = false;
        }
        if (!z && f3 >= 0.05f) {
            float f5 = 25.0f;
            if (f4 > 0.25f) {
                f = f4 * 100;
            } else {
                f = 25.0f;
            }
            if (f3 > 0.25f) {
                f5 = 100 * f3;
            }
            float f6 = 25;
            float f7 = 75;
            float f8 = 100;
            return n0.b(cVar.b(new float[]{f2, (f6 + (((f5 - f6) * 35) / f7)) / f8, (92 + (((f - f6) * 4) / f7)) / f8}));
        }
        return n0.b(cVar.b(new float[]{0.0f, 0.0f, 0.95f}));
    }
}
