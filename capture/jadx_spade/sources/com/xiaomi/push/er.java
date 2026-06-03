package com.xiaomi.push;

import android.util.Log;
import com.bytedance.covode.number.Covode;
import com.xiaomi.push.eu;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
class er {
    private static final boolean a;

    static {
        Covode.recordClassIndex(655499);
        a = Log.isLoggable("BCompressed", 3);
    }

    static byte[] a(eq eqVar, byte[] bArr) {
        try {
            byte[] a2 = eu.a.a(bArr);
            if (a) {
                com.xiaomi.channel.commonutils.logger.b.m55a("BCompressed", "decompress " + bArr.length + " to " + a2.length + " for " + eqVar);
                if (eqVar.f394a == 1) {
                    com.xiaomi.channel.commonutils.logger.b.m55a("BCompressed", "decompress not support upStream");
                }
            }
            return a2;
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m55a("BCompressed", "decompress error " + e);
            return bArr;
        }
    }
}
