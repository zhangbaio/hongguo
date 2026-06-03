package com.vivo.push.util;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class y {
    static {
        Covode.recordClassIndex(655210);
    }

    public static int a(com.vivo.push.b.c cVar) {
        ad c = ad.c();
        int b = cVar.b();
        long currentTimeMillis = System.currentTimeMillis();
        int b2 = c.b("com.vivo.push_preferences.operate." + b + "OPERATE_COUNT", 0);
        long b3 = currentTimeMillis - c.b("com.vivo.push_preferences.operate." + b + "START_TIME", 0L);
        if (b3 <= 86400000 && b3 >= 0) {
            if (b2 >= cVar.e()) {
                return 1001;
            }
            c.a("com.vivo.push_preferences.operate." + b + "OPERATE_COUNT", b2 + 1);
        } else {
            c.a("com.vivo.push_preferences.operate." + b + "START_TIME", System.currentTimeMillis());
            c.a("com.vivo.push_preferences.operate." + b + "OPERATE_COUNT", 1);
        }
        return 0;
    }
}
