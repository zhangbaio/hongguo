package com.xm;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.bytedance.covode.number.Covode;
import com.bytedance.push.i;
import com.bytedance.push.third.PushChannelHelper;
import com.bytedance.push.third.c;
import com.xiaomi.MiPushSettings;
import com.xiaomi.channel.commonutils.logger.LoggerInterface;
import com.xiaomi.mipush.sdk.Logger;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.util.List;
import je6.b;
import ke6.g;
import pz0.l;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class MiPushAdapter implements c {
    private static int MI_PUSH;

    public boolean isPushAvailable(Context context, int i) {
        return true;
    }

    public void trackPush(Context context, int i, Object obj) {
    }

    static {
        Covode.recordClassIndex(655770);
        MI_PUSH = -1;
    }

    public static int getMiPush() {
        if (MI_PUSH == -1) {
            MI_PUSH = PushChannelHelper.v(b.a()).e(MiPushAdapter.class.getName());
        }
        return MI_PUSH;
    }

    class a implements LoggerInterface {
        @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
        public void setTag(String str) {
        }

        a() {
        }

        @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
        public void log(String str) {
            i.v().i("MiPush", str);
        }

        @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
        public void log(String str, Throwable th) {
            i.v().i("MiPush", str, th);
        }
    }

    private void doUpgradeMiPush(Context context) {
        MiPushSettings miPushSettings = (MiPushSettings) l.b(context, MiPushSettings.class);
        if (!miPushSettings.A0()) {
            miPushSettings.Z1(true);
            context.getSharedPreferences("mipush_account", 0).edit().clear().commit();
            context.getSharedPreferences("mipush_extra", 0).edit().clear().commit();
            context.getSharedPreferences("mipush", 0).edit().clear().commit();
            context.getSharedPreferences("XMPushServiceConfig", 0).edit().clear().commit();
        }
    }

    public boolean checkThirdPushConfig(String str, Context context) throws Exception {
        return com.xm.a.c(str, context);
    }

    public boolean requestRemoveVoipNotification(Context context, int i) {
        MiPushClient.removeWindow(context);
        return true;
    }

    public void unregisterPush(Context context, int i) {
        if (context != null && i == getMiPush()) {
            i.v().i("MiPush", "unregisterMiPush");
            try {
                MiPushClient.pausePush(context.getApplicationContext(), null);
                MiPushClient.unregisterPush(context.getApplicationContext());
            } catch (Throwable unused) {
            }
        }
    }

    public void registerPush(Context context, int i) {
        String str = null;
        if (context != null && i == getMiPush()) {
            i.v().i("MiPush", "registerMiPush");
            String q = g.q(context);
            if (!TextUtils.isEmpty(q)) {
                if (q.endsWith(g.e)) {
                    g.i0(context, "com.xiaomi.push.service.receivers.MIPushMessageHandler", false);
                    g.i0(context, "com.xiaomi.push.service.receivers.WidgetProviderMIPushMessageHandler", false);
                    g.i0(context, "com.xiaomi.push.service.receivers.SmpMIPushMessageHandler", true);
                } else if (q.endsWith(":widgetProvider")) {
                    g.i0(context, "com.xiaomi.push.service.receivers.MIPushMessageHandler", false);
                    g.i0(context, "com.xiaomi.push.service.receivers.SmpMIPushMessageHandler", false);
                    g.i0(context, "com.xiaomi.push.service.receivers.WidgetProviderMIPushMessageHandler", true);
                }
            }
            try {
                Pair a2 = i.z().a(getMiPush());
                if (a2 == null) {
                    i.w().j(i, 106, "0", "configuration is null");
                    return;
                }
                doUpgradeMiPush(context);
                MiPushClient.registerPush(context, (String) a2.first, (String) a2.second);
                MiPushClient.resumePush(context.getApplicationContext(), null);
                Logger.setLogger(context, new a());
                return;
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        if (context == null) {
            str = "context is null";
        } else if (i != getMiPush()) {
            str = "channel register failed";
        }
        i.w().j(i, 101, "0", str);
    }

    public void setAlias(Context context, String str, int i) {
        if (context != null && i == getMiPush()) {
            i.v().i("MiPush", "setAlias");
            try {
                List<String> allAlias = MiPushClient.getAllAlias(context);
                if (allAlias != null) {
                    for (String str2 : allAlias) {
                        if (!TextUtils.isEmpty(str2) && !str2.equals(str)) {
                            MiPushClient.unsetAlias(context, str2, null);
                        }
                    }
                }
            } catch (Exception unused) {
            }
            try {
                MiPushClient.setAlias(context, str, null);
            } catch (Exception e) {
                i.w().j(i, 105, "0", Log.getStackTraceString(e));
                e.printStackTrace();
            }
        }
    }
}
