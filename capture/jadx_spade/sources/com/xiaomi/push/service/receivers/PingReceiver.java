package com.xiaomi.push.service.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.dy;
import com.xiaomi.push.service.ServiceClient;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.an;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class PingReceiver extends BroadcastReceiver {
    static {
        Covode.recordClassIndex(655737);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        b.c(intent.getPackage() + " is the package name");
        if (XMPushService.m658e()) {
            return;
        }
        if (an.q.equals(intent.getAction())) {
            if (TextUtils.equals(context.getPackageName(), intent.getPackage())) {
                b.c("Ping XMChannelService on timer");
                try {
                    Intent intent2 = new Intent(context, (Class<?>) XMPushService.class);
                    intent2.putExtra("time_stamp", System.currentTimeMillis());
                    intent2.setAction("com.xiaomi.push.timer");
                    ServiceClient.getInstance(context).startServiceSafely(intent2);
                    return;
                } catch (Exception e) {
                    b.a(e);
                    return;
                }
            }
            return;
        }
        b.m54a("cancel the old ping timer");
        dy.a();
    }
}
