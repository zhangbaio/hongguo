package com.xiaomi.push.service;

import android.text.TextUtils;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class aj {
    private static long a;

    /* renamed from: a, reason: collision with other field name */
    private static String f922a;

    public static String b() {
        return com.xiaomi.push.ba.a(32);
    }

    static {
        Covode.recordClassIndex(655672);
        a = 0L;
        f922a = "";
    }

    public static String a() {
        if (TextUtils.isEmpty(f922a)) {
            f922a = com.xiaomi.push.ba.a(4);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(f922a);
        long j = a;
        a = 1 + j;
        sb.append(j);
        return sb.toString();
    }

    public static String a(String str) {
        if (!TextUtils.isEmpty(str) && str.length() >= 32) {
            try {
                return "BlockId_" + str.substring(8);
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.d("Exception occurred when filtering registration packet id for log. " + e);
                return "UnexpectedId";
            }
        }
        return str;
    }
}
