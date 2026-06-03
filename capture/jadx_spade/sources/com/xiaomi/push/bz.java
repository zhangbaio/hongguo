package com.xiaomi.push;

import android.system.Os;
import com.bytedance.covode.number.Covode;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class bz {
    static {
        Covode.recordClassIndex(655400);
    }

    public static long a(String str) {
        try {
            if (!new PolarisFileWrapper(str).exists()) {
                return 0L;
            }
            return Os.stat(str).st_size;
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            return 0L;
        }
    }
}
