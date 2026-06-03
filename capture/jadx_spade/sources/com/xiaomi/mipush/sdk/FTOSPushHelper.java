package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class FTOSPushHelper {
    private static long a;

    /* renamed from: a, reason: collision with other field name */
    private static volatile boolean f24a;

    public static boolean getNeedRegister() {
        return f24a;
    }

    static {
        Covode.recordClassIndex(655264);
        a = 0L;
        f24a = false;
    }

    public static void setNeedRegister(boolean z) {
        f24a = z;
    }

    public static boolean hasNetwork(Context context) {
        return f.m102a(context);
    }

    private static void a(Context context) {
        AbstractPushManager a2 = e.a(context).a(d.ASSEMBLE_PUSH_FTOS);
        if (a2 != null) {
            com.xiaomi.channel.commonutils.logger.b.m54a("ASSEMBLE_PUSH :  register fun touch os when network change!");
            a2.register();
        }
    }

    public static void doInNetworkChange(Context context) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (getNeedRegister()) {
            long j = a;
            if (j <= 0 || j + 300000 <= elapsedRealtime) {
                a = elapsedRealtime;
                a(context);
            }
        }
    }

    public static void uploadToken(Context context, String str) {
        f.m101a(context, d.ASSEMBLE_PUSH_FTOS, str);
    }

    public static void notifyFTOSNotificationClicked(Context context, Map<String, String> map) {
        PushMessageReceiver a2;
        if (map != null && map.containsKey("pushMsg")) {
            String str = map.get("pushMsg");
            if (!TextUtils.isEmpty(str) && (a2 = f.a(context)) != null) {
                MiPushMessage a3 = f.a(str);
                if (a3.getExtra().containsKey("notify_effect")) {
                    return;
                }
                a2.onNotificationMessageClicked(context, a3);
            }
        }
    }
}
