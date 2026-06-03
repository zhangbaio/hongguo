package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import java.util.Arrays;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class cj {
    private static Boolean a;

    /* renamed from: a, reason: collision with other field name */
    private static final List<String> f201a;

    public static void a(String str, String str2) {
    }

    static {
        Covode.recordClassIndex(655415);
        f201a = Arrays.asList("001", "002", "003", "004", "005");
        a = null;
    }

    static void a(String str) {
        a("Push-ConnectionQualityStatsHelper", str);
    }

    public static boolean a(Context context) {
        if (a == null) {
            try {
                if (!j.m631a(context)) {
                    a = Boolean.FALSE;
                }
                String m746a = com.xiaomi.push.service.q.m746a(context);
                if (!TextUtils.isEmpty(m746a) && m746a.length() >= 3) {
                    a = Boolean.valueOf(f201a.contains(m746a.substring(m746a.length() - 3)));
                } else {
                    a = Boolean.FALSE;
                }
                a("Sampling statistical connection quality: " + a);
            } catch (Throwable th) {
                a = Boolean.FALSE;
                com.xiaomi.channel.commonutils.logger.b.c("Push-ConnectionQualityStatsHelper", "Determine sampling switch error: " + th);
            }
        }
        return a.booleanValue();
    }
}
