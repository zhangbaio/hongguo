package com.xiaomi.push;

import android.content.Context;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
class aj {
    private static volatile boolean a;

    static {
        Covode.recordClassIndex(655343);
        a = false;
    }

    public static boolean a(Context context) {
        try {
            Class<?> a2 = q.a(context, "com.bun.miitmdid.core.JLibrary");
            if (a2 != null) {
                a(a2, context);
                return true;
            }
            return false;
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.m54a("mdid:check error " + th);
            return false;
        }
    }

    private static void a(Class<?> cls, Context context) {
        if (!a) {
            try {
                a = true;
                cls.getDeclaredMethod("InitEntry", Context.class).invoke(cls, context);
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.m54a("mdid:load lib error " + th);
            }
        }
    }
}
