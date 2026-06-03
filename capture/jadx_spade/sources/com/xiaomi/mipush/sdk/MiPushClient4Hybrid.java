package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.xiaomi.mipush.sdk.b;
import com.xiaomi.push.BuildConfig;
import com.xiaomi.push.ba;
import com.xiaomi.push.ec;
import com.xiaomi.push.g;
import com.xiaomi.push.ge;
import com.xiaomi.push.go;
import com.xiaomi.push.gr;
import com.xiaomi.push.gs;
import com.xiaomi.push.gu;
import com.xiaomi.push.hd;
import com.xiaomi.push.he;
import com.xiaomi.push.hf;
import com.xiaomi.push.hk;
import com.xiaomi.push.hl;
import com.xiaomi.push.ho;
import com.xiaomi.push.service.aj;
import com.xiaomi.push.service.au;
import com.xiaomi.push.service.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class MiPushClient4Hybrid {
    private static Map<String, b.a> dataMap;
    private static MiPushCallback sCallback;
    private static Map<String, Long> sRegisterTimeMap;

    public static class MiPushCallback {
        static {
            Covode.recordClassIndex(655278);
        }

        public void onCommandResult(String str, MiPushCommandMessage miPushCommandMessage) {
        }

        public void onReceiveRegisterResult(String str, MiPushCommandMessage miPushCommandMessage) {
        }

        public void onReceiveUnregisterResult(String str, MiPushCommandMessage miPushCommandMessage) {
        }
    }

    static {
        Covode.recordClassIndex(655277);
        dataMap = new HashMap();
        sRegisterTimeMap = new HashMap();
    }

    public static void setCallback(MiPushCallback miPushCallback) {
        sCallback = miPushCallback;
    }

    public static void reportMessageClicked(Context context, MiPushMessage miPushMessage) {
        MiPushClient.reportMessageClicked(context, miPushMessage);
    }

    public static void uploadClearMessageData(Context context, LinkedList<? extends Object> linkedList) {
        x.a(context, linkedList);
    }

    public static boolean isRegistered(Context context, String str) {
        if (b.m79a(context).a(str) != null) {
            return true;
        }
        return false;
    }

    public static void onReceiveUnregisterResult(Context context, hl hlVar) {
        MiPushCommandMessage generateCommandMessage = PushMessageHelper.generateCommandMessage(ec.COMMAND_UNREGISTER.f356a, null, hlVar.f790a, hlVar.f798d, null, null);
        String a = hlVar.a();
        MiPushCallback miPushCallback = sCallback;
        if (miPushCallback != null) {
            miPushCallback.onReceiveUnregisterResult(a, generateCommandMessage);
        }
    }

    private static void addPullNotificationTime(Context context, String str) {
        context.getSharedPreferences("mipush_extra", 0).edit().putLong("last_pull_notification_" + str, System.currentTimeMillis()).commit();
    }

    private static short getDeviceStatus(MiPushMessage miPushMessage, boolean z) {
        String str;
        int i;
        if (miPushMessage.getExtra() == null) {
            str = "";
        } else {
            str = miPushMessage.getExtra().get("__hybrid_device_status");
        }
        if (!TextUtils.isEmpty(str)) {
            i = Integer.valueOf(str).intValue();
        } else {
            i = 0;
        }
        if (!z) {
            i = (i & (-4)) + g.b.NOT_ALLOWED.a();
        }
        return (short) i;
    }

    public static void removeDuplicateCache(Context context, MiPushMessage miPushMessage) {
        String str;
        if (miPushMessage.getExtra() != null) {
            str = miPushMessage.getExtra().get("jobkey");
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            str = miPushMessage.getMessageId();
        }
        t.a(context, str);
    }

    private static boolean shouldPullNotification(Context context, String str) {
        if (Math.abs(System.currentTimeMillis() - context.getSharedPreferences("mipush_extra", 0).getLong("last_pull_notification_" + str, -1L)) <= 300000) {
            return false;
        }
        return true;
    }

    public static void onReceiveRegisterResult(Context context, hf hfVar) {
        ArrayList arrayList;
        b.a aVar;
        String c = hfVar.c();
        if (hfVar.a() == 0 && (aVar = dataMap.get(c)) != null) {
            aVar.a(hfVar.f724e, hfVar.f725f);
            b.m79a(context).a(c, aVar);
        }
        if (!TextUtils.isEmpty(hfVar.f724e)) {
            arrayList = new ArrayList();
            arrayList.add(hfVar.f724e);
        } else {
            arrayList = null;
        }
        MiPushCommandMessage generateCommandMessage = PushMessageHelper.generateCommandMessage(ec.COMMAND_REGISTER.f356a, arrayList, hfVar.f712a, hfVar.f723d, null, null);
        MiPushCallback miPushCallback = sCallback;
        if (miPushCallback != null) {
            miPushCallback.onReceiveRegisterResult(c, generateCommandMessage);
        }
    }

    public static void unregisterPush(Context context, String str) {
        sRegisterTimeMap.remove(str);
        b.a a = b.m79a(context).a(str);
        if (a == null) {
            return;
        }
        hk hkVar = new hk();
        hkVar.a(aj.a());
        hkVar.d(str);
        hkVar.b(a.f46a);
        hkVar.c(a.c);
        hkVar.e(a.b);
        hd hdVar = new hd();
        hdVar.c(go.HybridUnregister.f529a);
        hdVar.b(b.m79a(context).m80a());
        hdVar.d(context.getPackageName());
        hdVar.a(ho.a(hkVar));
        hdVar.a(aj.a());
        u.a(context).a((u) hdVar, ge.Notification, (gr) null);
        b.m79a(context).b(str);
    }

    public static void reportMessageArrived(Context context, MiPushMessage miPushMessage, boolean z) {
        if (miPushMessage != null && miPushMessage.getExtra() != null) {
            try {
                gu guVar = new gu();
                guVar.b(b.m79a(context).m80a());
                guVar.a(miPushMessage.getMessageId());
                guVar.a(Long.valueOf(miPushMessage.getExtra().get("__hybrid_message_ts")).longValue());
                guVar.a(getDeviceStatus(miPushMessage, z));
                if (!TextUtils.isEmpty(miPushMessage.getTopic())) {
                    guVar.c(miPushMessage.getTopic());
                }
                u.a(context).a((u) guVar, ge.AckMessage, false, au.a(PushMessageHelper.generateMessage(miPushMessage)));
                com.xiaomi.channel.commonutils.logger.b.b("MiPushClient4Hybrid ack mina message, messageId is " + miPushMessage.getMessageId());
            } finally {
                try {
                    return;
                } finally {
                }
            }
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.m54a("do not ack message, message is null");
    }

    public static void registerPush(Context context, String str, String str2, String str3) {
        long j;
        if (b.m79a(context).m84a(str2, str3, str)) {
            ArrayList arrayList = new ArrayList();
            b.a a = b.m79a(context).a(str);
            if (a != null) {
                arrayList.add(a.c);
                MiPushCommandMessage generateCommandMessage = PushMessageHelper.generateCommandMessage(ec.COMMAND_REGISTER.f356a, arrayList, 0L, null, null, null);
                MiPushCallback miPushCallback = sCallback;
                if (miPushCallback != null) {
                    miPushCallback.onReceiveRegisterResult(str, generateCommandMessage);
                }
            }
            if (shouldPullNotification(context, str)) {
                hd hdVar = new hd();
                hdVar.b(str2);
                hdVar.c(go.PullOfflineMessage.f529a);
                hdVar.a(aj.a());
                hdVar.a(false);
                u.a(context).a(hdVar, ge.Notification, false, true, null, false, str, str2);
                com.xiaomi.channel.commonutils.logger.b.b("MiPushClient4Hybrid pull offline pass through message");
                addPullNotificationTime(context, str);
                return;
            }
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (sRegisterTimeMap.get(str) != null) {
            j = sRegisterTimeMap.get(str).longValue();
        } else {
            j = 0;
        }
        if (Math.abs(currentTimeMillis - j) < 5000) {
            com.xiaomi.channel.commonutils.logger.b.m54a("MiPushClient4Hybrid  Could not send register message within 5s repeatedly.");
            return;
        }
        sRegisterTimeMap.put(str, Long.valueOf(currentTimeMillis));
        String a2 = ba.a(6);
        b.a aVar = new b.a(context);
        aVar.c(str2, str3, a2);
        dataMap.put(str, aVar);
        he heVar = new he();
        heVar.a(aj.a());
        heVar.b(str2);
        heVar.e(str3);
        heVar.d(str);
        heVar.f(a2);
        heVar.c(com.xiaomi.push.g.m456a(context, context.getPackageName()));
        heVar.b(com.xiaomi.push.g.a(context, context.getPackageName()));
        heVar.h(BuildConfig.VERSION_NAME);
        heVar.a(50906);
        heVar.a(gs.Init);
        if (!com.xiaomi.push.j.m636d()) {
            String d = com.xiaomi.push.i.d(context);
            if (!TextUtils.isEmpty(d)) {
                heVar.i(ba.a(d));
            }
        }
        int a3 = com.xiaomi.push.i.a();
        if (a3 >= 0) {
            heVar.c(a3);
        }
        hd hdVar2 = new hd();
        hdVar2.c(go.HybridRegister.f529a);
        hdVar2.b(b.m79a(context).m80a());
        hdVar2.d(context.getPackageName());
        hdVar2.a(ho.a(heVar));
        hdVar2.a(aj.a());
        u.a(context).a((u) hdVar2, ge.Notification, (gr) null);
    }
}
