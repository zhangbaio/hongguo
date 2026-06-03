package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class COSPushHelper {
    private static long a;

    /* renamed from: a, reason: collision with other field name */
    private static volatile boolean f23a;

    public static void onNotificationMessageCome(Context context, String str) {
    }

    public static void onPassThoughMessageCome(Context context, String str) {
    }

    public static boolean getNeedRegister() {
        return f23a;
    }

    static {
        Covode.recordClassIndex(655260);
        f23a = false;
        a = 0L;
    }

    public static void convertMessage(Intent intent) {
        f.a(intent);
    }

    public static boolean hasNetwork(Context context) {
        return f.m102a(context);
    }

    public static synchronized void setNeedRegister(boolean z) {
        synchronized (COSPushHelper.class) {
            f23a = z;
        }
    }

    public static void doInNetworkChange(Context context) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (getNeedRegister()) {
            long j = a;
            if (j <= 0 || j + 300000 <= elapsedRealtime) {
                a = elapsedRealtime;
                registerCOSAssemblePush(context);
            }
        }
    }

    public static void registerCOSAssemblePush(Context context) {
        AbstractPushManager a2 = e.a(context).a(d.ASSEMBLE_PUSH_COS);
        if (a2 != null) {
            com.xiaomi.channel.commonutils.logger.b.m54a("ASSEMBLE_PUSH :  register cos when network change!");
            a2.register();
        }
    }

    public static void uploadToken(Context context, String str) {
        f.m101a(context, d.ASSEMBLE_PUSH_COS, str);
    }
}
