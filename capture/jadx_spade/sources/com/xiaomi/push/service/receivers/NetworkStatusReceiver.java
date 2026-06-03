package com.xiaomi.push.service.receivers;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.bytedance.covode.number.Covode;
import com.xiaomi.mipush.sdk.COSPushHelper;
import com.xiaomi.mipush.sdk.FTOSPushHelper;
import com.xiaomi.mipush.sdk.HWPushHelper;
import com.xiaomi.mipush.sdk.MiPushClient;
import com.xiaomi.mipush.sdk.b;
import com.xiaomi.mipush.sdk.d;
import com.xiaomi.mipush.sdk.p;
import com.xiaomi.mipush.sdk.u;
import com.xiaomi.mipush.sdk.v;
import com.xiaomi.push.at;
import com.xiaomi.push.fy;
import com.xiaomi.push.l;
import com.xiaomi.push.service.ServiceClient;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class NetworkStatusReceiver extends BroadcastReceiver {
    private static boolean a;
    private boolean b = true;

    public NetworkStatusReceiver() {
    }

    public static boolean a() {
        return a;
    }

    static {
        Covode.recordClassIndex(655736);
        a = false;
    }

    public NetworkStatusReceiver(Object obj) {
        a = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context) {
        if (!u.a(context).m124a() && b.m79a(context).m88c() && !b.m79a(context).m91f()) {
            try {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(context, "com.xiaomi.push.service.XMPushService"));
                intent.setAction("com.xiaomi.push.network_status_changed");
                ServiceClient.getInstance(context).startServiceSafely(intent);
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
            }
        }
        fy.m451a(context);
        if (at.m155a(context) && u.a(context).m127b()) {
            u.a(context).m128c();
        }
        if (at.m155a(context)) {
            if ("syncing".equals(p.a(context).a(v.DISABLE_PUSH))) {
                MiPushClient.disablePush(context);
            }
            if ("syncing".equals(p.a(context).a(v.ENABLE_PUSH))) {
                MiPushClient.enablePush(context);
            }
            p a2 = p.a(context);
            v vVar = v.UPLOAD_HUAWEI_TOKEN;
            if ("syncing".equals(a2.a(vVar))) {
                u.a(context).a((String) null, vVar, d.ASSEMBLE_PUSH_HUAWEI, "net");
            }
            if ("syncing".equals(p.a(context).a(v.UPLOAD_FCM_TOKEN))) {
                u.a(context).a((String) null, vVar, d.ASSEMBLE_PUSH_HUAWEI, "net");
            }
            p a3 = p.a(context);
            v vVar2 = v.UPLOAD_COS_TOKEN;
            if ("syncing".equals(a3.a(vVar2))) {
                u.a(context).a((String) null, vVar2, d.ASSEMBLE_PUSH_COS, "net");
            }
            p a4 = p.a(context);
            v vVar3 = v.UPLOAD_FTOS_TOKEN;
            if ("syncing".equals(a4.a(vVar3))) {
                u.a(context).a((String) null, vVar3, d.ASSEMBLE_PUSH_FTOS, "net");
            }
            if (HWPushHelper.needConnect() && HWPushHelper.shouldTryConnect(context)) {
                HWPushHelper.setConnectTime(context);
                HWPushHelper.registerHuaWeiAssemblePush(context);
            }
            COSPushHelper.doInNetworkChange(context);
            FTOSPushHelper.doInNetworkChange(context);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(final Context context, Intent intent) {
        if (this.b) {
            return;
        }
        at.m154a();
        l.a().post(new Runnable() { // from class: com.xiaomi.push.service.receivers.NetworkStatusReceiver.1
            @Override // java.lang.Runnable
            public void run() {
                NetworkStatusReceiver.this.a(context);
            }
        });
    }
}
