package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.xiaomi.push.gr;
import com.xiaomi.push.hh;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class PushMessageHelper {
    private static int pushMode;

    static {
        Covode.recordClassIndex(655290);
        pushMode = 0;
    }

    private static void setPushMode(int i) {
        pushMode = i;
    }

    public static int getPushMode(Context context) {
        if (pushMode == 0) {
            if (isUseCallbackPushMode(context)) {
                setPushMode(1);
            } else {
                setPushMode(2);
            }
        }
        return pushMode;
    }

    public static boolean isUseCallbackPushMode(Context context) {
        Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent.setClassName(context.getPackageName(), "com.xiaomi.mipush.sdk.PushServiceReceiver");
        return isIntentAvailable(context, intent);
    }

    public static void sendQuitMessageBroadcast(Context context) {
        Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent.setPackage(context.getPackageName());
        intent.putExtra("message_type", 4);
        new PushServiceReceiver().onReceive(context, intent);
    }

    public static gr generateMessage(MiPushMessage miPushMessage) {
        gr grVar = new gr();
        grVar.a(miPushMessage.getMessageId());
        grVar.b(miPushMessage.getTopic());
        grVar.d(miPushMessage.getDescription());
        grVar.c(miPushMessage.getTitle());
        grVar.c(miPushMessage.getNotifyId());
        grVar.a(miPushMessage.getNotifyType());
        grVar.b(miPushMessage.getPassThrough());
        grVar.a(miPushMessage.getExtra());
        return grVar;
    }

    private static boolean isIntentAvailable(Context context, Intent intent) {
        try {
            List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 32);
            if (queryBroadcastReceivers != null) {
                if (!queryBroadcastReceivers.isEmpty()) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return true;
        }
    }

    public static void sendCommandMessageBroadcast(Context context, MiPushCommandMessage miPushCommandMessage) {
        Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent.setPackage(context.getPackageName());
        intent.putExtra("message_type", 3);
        intent.putExtra("key_command", miPushCommandMessage);
        new PushServiceReceiver().onReceive(context, intent);
    }

    public static MiPushMessage generateMessage(hh hhVar, gr grVar, boolean z) {
        MiPushMessage miPushMessage = new MiPushMessage();
        miPushMessage.setMessageId(hhVar.m572a());
        if (!TextUtils.isEmpty(hhVar.d())) {
            miPushMessage.setMessageType(1);
            miPushMessage.setAlias(hhVar.d());
        } else if (!TextUtils.isEmpty(hhVar.c())) {
            miPushMessage.setMessageType(2);
            miPushMessage.setTopic(hhVar.c());
        } else if (!TextUtils.isEmpty(hhVar.f())) {
            miPushMessage.setMessageType(3);
            miPushMessage.setUserAccount(hhVar.f());
        } else {
            miPushMessage.setMessageType(0);
        }
        miPushMessage.setCategory(hhVar.e());
        if (hhVar.a() != null) {
            miPushMessage.setContent(hhVar.a().c());
        }
        if (grVar != null) {
            if (TextUtils.isEmpty(miPushMessage.getMessageId())) {
                miPushMessage.setMessageId(grVar.m499a());
            }
            if (TextUtils.isEmpty(miPushMessage.getTopic())) {
                miPushMessage.setTopic(grVar.m504b());
            }
            miPushMessage.setDescription(grVar.d());
            miPushMessage.setTitle(grVar.m507c());
            miPushMessage.setNotifyType(grVar.a());
            miPushMessage.setNotifyId(grVar.c());
            miPushMessage.setPassThrough(grVar.b());
            miPushMessage.setExtra(grVar.m500a());
        }
        miPushMessage.setNotified(z);
        return miPushMessage;
    }

    public static MiPushCommandMessage generateCommandMessage(String str, List<String> list, long j, String str2, String str3, List<String> list2) {
        MiPushCommandMessage miPushCommandMessage = new MiPushCommandMessage();
        miPushCommandMessage.setCommand(str);
        miPushCommandMessage.setCommandArguments(list);
        miPushCommandMessage.setResultCode(j);
        miPushCommandMessage.setReason(str2);
        miPushCommandMessage.setCategory(str3);
        miPushCommandMessage.setAutoMarkPkgs(list2);
        return miPushCommandMessage;
    }
}
