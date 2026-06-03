package com.xm;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.covode.number.Covode;
import com.bytedance.push.i;
import java.util.Arrays;
import v01.c;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
class a {
    static {
        Covode.recordClassIndex(655769);
    }

    private static boolean b(String str) {
        Pair a = i.z().a(MiPushAdapter.getMiPush());
        if (a != null && !TextUtils.isEmpty((CharSequence) a.first) && !TextUtils.isEmpty((CharSequence) a.second)) {
            return true;
        }
        i.v().e(str, "Mipush key configuration error, missing key configuration");
        return false;
    }

    static boolean c(String str, Context context) throws PackageManager.NameNotFoundException {
        return a(context, str) & b(str) & d(context, str);
    }

    private static boolean d(Context context, String str) throws PackageManager.NameNotFoundException {
        return v01.i.d(context, str, "MiPush", Arrays.asList("android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", "android.permission.ACCESS_WIFI_STATE", "android.permission.VIBRATE", context.getPackageName() + ".permission.MIPUSH_RECEIVE"));
    }

    private static boolean a(Context context, String str) throws PackageManager.NameNotFoundException {
        boolean g = v01.i.g(context, str, "MiPush Error", Arrays.asList(c.a.b("com.xiaomi.push.service.XMPushService").e(context.getPackageName() + ":pushservice").a, c.a.b("com.xiaomi.push.service.XMJobService").e(context.getPackageName() + ":pushservice").d("android.permission.BIND_JOB_SERVICE").a, c.a.b("com.xiaomi.mipush.sdk.PushMessageHandler").e(context.getPackageName()).a, c.a.b("com.xiaomi.mipush.sdk.MessageHandleService").e(context.getPackageName()).a));
        if (!v01.i.e(context, str, "MiPush Error", Arrays.asList(c.a.b("com.xiaomi.push.service.receivers.PingReceiver").e(context.getPackageName() + ":pushservice").a(new c.b(Arrays.asList("com.xiaomi.push.PING_TIMER"))).a, c.a.b("com.xiaomi.push.service.receivers.MIPushMessageHandler").e(context.getPackageName()).a(new c.b(Arrays.asList("com.xiaomi.mipush.RECEIVE_MESSAGE"))).a(new c.b(Arrays.asList("com.xiaomi.mipush.MESSAGE_ARRIVED"))).a(new c.b(Arrays.asList("com.xiaomi.mipush.ERROR"))).a)) || !g) {
            return false;
        }
        return true;
    }
}
