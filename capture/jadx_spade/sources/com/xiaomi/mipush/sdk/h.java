package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.xiaomi.push.av;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class h {
    private static int a;

    static {
        Covode.recordClassIndex(655306);
        a = -1;
    }

    private static boolean a() {
        try {
            String str = (String) av.a("android.os.SystemProperties", "get", "ro.build.hw_emui_api_level", "");
            if (!TextUtils.isEmpty(str)) {
                if (Integer.parseInt(str) >= 9) {
                    return true;
                }
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
        }
        return false;
    }

    public static q a(Context context) {
        if (m107a(context)) {
            return q.HUAWEI;
        }
        if (c(context)) {
            return q.OPPO;
        }
        if (d(context)) {
            return q.VIVO;
        }
        return q.OTHER;
    }

    public static boolean c(Context context) {
        boolean z = false;
        Object a2 = av.a("com.xiaomi.assemble.control.COSPushManager", "isSupportPush", context);
        if (a2 != null && (a2 instanceof Boolean)) {
            z = ((Boolean) Boolean.class.cast(a2)).booleanValue();
        }
        com.xiaomi.channel.commonutils.logger.b.c("color os push  is avaliable ? :" + z);
        return z;
    }

    public static boolean d(Context context) {
        boolean z = false;
        Object a2 = av.a("com.xiaomi.assemble.control.FTOSPushManager", "isSupportPush", context);
        if (a2 != null && (a2 instanceof Boolean)) {
            z = ((Boolean) Boolean.class.cast(a2)).booleanValue();
        }
        com.xiaomi.channel.commonutils.logger.b.c("fun touch os push  is avaliable ? :" + z);
        return z;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m107a(Context context) {
        try {
            if (context.getPackageManager().getServiceInfo(new ComponentName("com.huawei.hwid", "com.huawei.hms.core.service.HMSCoreService"), 128) != null) {
                if (a()) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static boolean b(Context context) {
        boolean z;
        int i;
        Object a2 = av.a(av.a("com.google.android.gms.common.GoogleApiAvailability", "getInstance", new Object[0]), "isGooglePlayServicesAvailable", context);
        Object a3 = av.a("com.google.android.gms.common.ConnectionResult", "SUCCESS");
        if (a3 != null && (a3 instanceof Integer)) {
            int intValue = ((Integer) Integer.class.cast(a3)).intValue();
            if (a2 != null) {
                if (a2 instanceof Integer) {
                    if (((Integer) Integer.class.cast(a2)).intValue() == intValue) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    a = i;
                } else {
                    a = 0;
                    com.xiaomi.channel.commonutils.logger.b.c("google service is not avaliable");
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("is google service can be used");
            if (a > 0) {
                z = true;
            } else {
                z = false;
            }
            sb.append(z);
            com.xiaomi.channel.commonutils.logger.b.c(sb.toString());
            if (a <= 0) {
                return false;
            }
            return true;
        }
        com.xiaomi.channel.commonutils.logger.b.c("google service is not avaliable");
        a = 0;
        return false;
    }
}
