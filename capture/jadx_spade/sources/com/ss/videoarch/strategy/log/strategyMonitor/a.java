package com.ss.videoarch.strategy.log.strategyMonitor;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class a {
    public static String b;
    private static volatile a c;
    public long a = -1;

    static {
        Covode.recordClassIndex(653143);
        b = "330361";
        c = null;
    }

    public static a a() {
        if (c == null) {
            synchronized (a.class) {
                if (c == null) {
                    c = new a();
                }
            }
        }
        return c;
    }
}
