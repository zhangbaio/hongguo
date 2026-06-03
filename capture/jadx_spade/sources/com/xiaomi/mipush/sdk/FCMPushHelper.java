package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.covode.number.Covode;
import com.dragon.read.app.App;
import com.dragon.read.app.launch.task.c3;
import com.dragon.read.component.biz.api.NsPushService;
import com.ss.android.common.util.ToolUtils;
import com.xiaomi.push.ge;
import com.xiaomi.push.ha;
import com.xiaomi.push.hh;
import com.xiaomi.push.ho;
import com.xiaomi.push.service.an;
import com.xiaomi.push.service.x;
import java.util.HashMap;
import java.util.Map;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class FCMPushHelper {
    static {
        Covode.recordClassIndex(655263);
    }

    public static void reportFCMMessageDelete() {
        MiTinyDataClient.upload(f.c(d.ASSEMBLE_PUSH_FCM), "fcm", 1L, "some fcm messages was deleted ");
    }

    public static void convertMessage(Intent intent) {
        f.a(intent);
    }

    public static void clearToken(Context context) {
        f.m100a(context, d.ASSEMBLE_PUSH_FCM);
    }

    private static boolean b(Context context) {
        return context.getSharedPreferences("mipush_extra", 0).getBoolean("is_xmsf_sup_decrypt", false);
    }

    public static boolean isFCMSwitchOpen(Context context) {
        if (f.m103a(context, d.ASSEMBLE_PUSH_FCM) && MiPushClient.getOpenFCMPush(context)) {
            return true;
        }
        return false;
    }

    private static Map<String, String> a(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("actionType", String.valueOf(ge.AckMessage.a()));
        hashMap.put("deviceStatus", String.valueOf((int) ho.a(context, context.getPackageName())));
        hashMap.put("mat", Long.toString(System.currentTimeMillis()));
        return hashMap;
    }

    public static void persistIfXmsfSupDecrypt(Context context) {
        boolean z = false;
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
        if (com.xiaomi.push.j.b(context) >= 50002000) {
            z = true;
        }
        edit.putBoolean("is_xmsf_sup_decrypt", z).apply();
    }

    /* renamed from: a, reason: collision with other method in class */
    private static boolean m71a(Context context) {
        if (com.xiaomi.push.j.b(context) >= 50002000 && b(context)) {
            return true;
        }
        return false;
    }

    public static void uploadToken(Context context, String str) {
        f.m101a(context, d.ASSEMBLE_PUSH_FCM, str);
    }

    private static void a(Context context, ha haVar) {
        try {
            MiPushMessage generateMessage = PushMessageHelper.generateMessage((hh) r.a(context, haVar), haVar.m533a(), false);
            PushMessageReceiver a = f.a(context);
            if (a != null) {
                a.onNotificationMessageArrived(context, generateMessage);
            }
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.a("fcm broadcast notification come error ", th);
        }
    }

    public static void notifyFCMNotificationCome(Context context, Map<String, String> map) {
        PushMessageReceiver a;
        String str = map.get("pushMsg");
        if (!TextUtils.isEmpty(str) && (a = f.a(context)) != null) {
            a.onNotificationMessageArrived(context, f.a(str));
        }
    }

    @Proxy("startService")
    @TargetClass("android.content.Context")
    public static ComponentName INVOKEVIRTUAL_com_xiaomi_mipush_sdk_FCMPushHelper_com_dragon_read_aop_ContextAop_startService(Context context, Intent intent) {
        if (!(context instanceof Context)) {
            return context.startService(intent);
        }
        if (lz4.b.a()) {
            lz4.b.b(context, intent);
        } else if (ToolUtils.isMainProcess(App.context()) && c3.g() && NsPushService.IMPL.isInterceptStartPushStart(context, intent)) {
            return null;
        }
        return context.startService(intent);
    }

    public static Map<String, String> notifyFCMPassThoughMessageCome(Context context, Map<String, String> map) {
        PushMessageReceiver a;
        String str = map.get("pushMsg");
        if (!TextUtils.isEmpty(str) && (a = f.a(context)) != null) {
            a.onReceivePassThroughMessage(context, f.a(str));
        }
        String str2 = map.get("mipushContainer");
        if (!TextUtils.isEmpty(str2)) {
            try {
                byte[] decode = Base64.decode(str2, 2);
                a(context, com.xiaomi.push.service.u.a(decode));
                a(context, decode);
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.a("fcm notify notification error ", th);
            }
            return a(context);
        }
        return new HashMap();
    }

    private static void a(Context context, byte[] bArr) {
        boolean m124a = u.a(context).m124a();
        boolean z = true;
        boolean z2 = !"com.xiaomi.xmsf".equals(context.getPackageName());
        boolean m71a = m71a(context);
        boolean z3 = false;
        if (m124a && z2 && m71a) {
            bArr = com.xiaomi.push.service.l.a(bArr, b.m79a(context).d());
            if (bArr == null) {
                com.xiaomi.channel.commonutils.logger.b.m54a("fcm message encrypt failed");
            } else {
                String encodeToString = Base64.encodeToString(bArr, 2);
                if (TextUtils.isEmpty(encodeToString)) {
                    com.xiaomi.channel.commonutils.logger.b.m54a("fcm message buf base64 encode failed");
                    z = false;
                } else {
                    Intent intent = new Intent(an.n);
                    intent.setPackage("com.xiaomi.xmsf");
                    intent.setClassName("com.xiaomi.xmsf", "com.xiaomi.push.service.XMPushService");
                    intent.putExtra("ext_fcm_container_buffer", encodeToString);
                    intent.putExtra("mipush_app_package", context.getPackageName());
                    INVOKEVIRTUAL_com_xiaomi_mipush_sdk_FCMPushHelper_com_dragon_read_aop_ContextAop_startService(context, intent);
                    com.xiaomi.channel.commonutils.logger.b.m54a("fcm message reroute to xmsf");
                }
                z3 = z;
            }
        } else {
            com.xiaomi.channel.commonutils.logger.b.m54a(String.format("xmsf can not receive fcm msg - shouldUseMIUIPush=%s;isNotXmsf=%s;xmsfSupport=%s", Boolean.valueOf(m124a), Boolean.valueOf(z2), Boolean.valueOf(m71a)));
        }
        if (!z3) {
            com.xiaomi.channel.commonutils.logger.b.b("fcm message post local");
            x.m757a(context, com.xiaomi.push.service.u.a(bArr), bArr);
        }
    }
}
