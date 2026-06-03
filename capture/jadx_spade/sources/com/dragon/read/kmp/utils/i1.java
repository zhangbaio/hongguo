package com.dragon.read.kmp.utils;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.base.KmpBigDecimal;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class i1 {
    public static final i1 a;

    static {
        Covode.recordClassIndex(609584);
        a = new i1();
    }

    private i1() {
    }

    public final String a(long j) {
        if (j < 10000) {
            return String.valueOf(j);
        }
        long j2 = 10000;
        try {
            KmpBigDecimal i = new KmpBigDecimal(j / j2).i(1, KmpBigDecimal.RoundingMode.HALF_UP);
            if (i.j().d <= 0) {
                StringBuilder sb = new StringBuilder();
                sb.append(i.f());
                sb.append((char) 19975);
                return sb.toString();
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(i.c());
            sb2.append((char) 19975);
            return sb2.toString();
        } catch (Exception unused) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(j / j2);
            sb3.append((char) 19975);
            return sb3.toString();
        }
    }
}
