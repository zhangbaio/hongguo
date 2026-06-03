package com.vivo.push.util;

import com.bytedance.covode.number.Covode;
import java.util.Calendar;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class ag {
    static {
        Covode.recordClassIndex(655183);
    }

    public static long a() {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.set(11, 0);
            calendar.set(12, 0);
            calendar.set(13, 0);
            return calendar.getTimeInMillis();
        } catch (Exception e) {
            t.a("TimeUtils", "getTodayStartTime error", e);
            return 0L;
        }
    }
}
