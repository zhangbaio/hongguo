package com.xiaomi.push;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class p {
    static {
        Covode.recordClassIndex(655624);
    }

    public static String a(String str, String str2) {
        try {
            return (String) q.a(null, "android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, str, str2);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m54a("SystemProperties.get: " + e);
            return str2;
        }
    }
}
