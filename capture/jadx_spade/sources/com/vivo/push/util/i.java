package com.vivo.push.util;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.dragon.read.app.PrivacyMgr;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.model.NotifyArriveCallbackByUser;
import java.util.Map;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class i extends b {
    private int e = 0;

    static {
        Covode.recordClassIndex(655194);
    }

    @Override // com.vivo.push.util.b
    protected final int a() {
        return this.e;
    }

    private int a(Intent intent) {
        if (intent.resolveActivityInfo(this.c.getPackageManager(), 65536) == null) {
            t.a("AndroidTwelveNotifyClickIntentParam", "activity is null  ");
            t.c(this.c, " 跳转参数对应的Activity找不到 通知不展示   2162");
            return 2162;
        }
        return 0;
    }

    @Override // com.vivo.push.util.b
    protected final PendingIntent a(Context context, Intent intent) {
        return INVOKESTATIC_com_vivo_push_util_i_com_dragon_read_aop_target31_PendingIntentAop_getActivity(context, (int) SystemClock.uptimeMillis(), intent, 201326592);
    }

    @Proxy("getLaunchIntentForPackage")
    @TargetClass("android.content.pm.PackageManager")
    public static Intent INVOKEVIRTUAL_com_vivo_push_util_i_com_dragon_read_base_lancet_PrivacyAop_getLaunchIntentForPackage(PackageManager packageManager, String str) {
        if (PrivacyMgr.inst().hasConfirmedAndNotBasic()) {
            return packageManager.getLaunchIntentForPackage(str);
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.phoenix.read", "com.dragon.read.pages.splash.SplashActivity"));
        return intent;
    }

    private int a(Intent intent, String str) {
        int a = a(intent);
        t.d("AndroidTwelveNotifyClickIntentParam", "checkSkipContentParameterLegal canfindactivity code : ".concat(String.valueOf(a)));
        if (a != 0) {
            return a;
        }
        int b = b(intent, str);
        t.d("AndroidTwelveNotifyClickIntentParam", "checkSkipContentParameterLegal packagefit code : ".concat(String.valueOf(b)));
        if (b != 0) {
            return b;
        }
        return 0;
    }

    private static Intent a(Intent intent, Map<String, String> map) {
        if (map != null && map.entrySet() != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry != null && entry.getKey() != null) {
                    intent.putExtra(entry.getKey(), entry.getValue());
                }
            }
        }
        return intent;
    }

    private int b(Intent intent, String str) {
        String str2;
        if (intent != null && !TextUtils.isEmpty(str)) {
            try {
                if (intent.getComponent() != null) {
                    str2 = intent.getComponent().getPackageName();
                } else {
                    str2 = intent.getPackage();
                }
                if (!TextUtils.isEmpty(str2) && !TextUtils.equals(str, str2)) {
                    t.d("AndroidTwelveNotifyClickIntentParam", "activity component error : local pkgName is " + str + "; but remote pkgName is " + str2);
                    t.a(this.c, " 跳转参数对应的包名不是当前应用包名    local pkgName is " + str + "; but remote pkgName is " + str2 + " code =2813");
                    return 2813;
                }
                return 0;
            } catch (Exception e) {
                t.a("AndroidTwelveNotifyClickIntentParam", "checkSkipContentPackage open activity error :  error " + e.getMessage());
                return 2158;
            }
        }
        StringBuilder sb = new StringBuilder("checkSkipContentPackageFit intent = : ");
        Object obj = intent;
        if (intent == null) {
            obj = "";
        }
        sb.append(obj);
        sb.append(" mPkgName = ");
        sb.append(str);
        t.a("AndroidTwelveNotifyClickIntentParam", sb.toString());
        return 2158;
    }

    @Override // com.vivo.push.util.b
    protected final Intent a(Context context, InsideNotificationItem insideNotificationItem, NotifyArriveCallbackByUser notifyArriveCallbackByUser) {
        return b(context, insideNotificationItem, notifyArriveCallbackByUser);
    }

    /* JADX WARN: Removed duplicated region for block: B:69:0x011f A[Catch: Exception -> 0x0193, TryCatch #1 {Exception -> 0x0193, blocks: (B:3:0x0005, B:5:0x000b, B:8:0x0013, B:17:0x003b, B:20:0x015f, B:23:0x0175, B:25:0x0045, B:26:0x0062, B:28:0x007f, B:59:0x00e0, B:60:0x00f3, B:61:0x00fd, B:63:0x0107, B:65:0x0113, B:69:0x011f, B:70:0x0145, B:72:0x0155, B:73:0x018b, B:30:0x0084, B:32:0x0096, B:35:0x009d, B:36:0x00a5, B:38:0x00ab, B:41:0x00b3, B:44:0x00b9, B:47:0x00c5, B:54:0x00d5, B:56:0x00db), top: B:2:0x0005, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0145 A[Catch: Exception -> 0x0193, TryCatch #1 {Exception -> 0x0193, blocks: (B:3:0x0005, B:5:0x000b, B:8:0x0013, B:17:0x003b, B:20:0x015f, B:23:0x0175, B:25:0x0045, B:26:0x0062, B:28:0x007f, B:59:0x00e0, B:60:0x00f3, B:61:0x00fd, B:63:0x0107, B:65:0x0113, B:69:0x011f, B:70:0x0145, B:72:0x0155, B:73:0x018b, B:30:0x0084, B:32:0x0096, B:35:0x009d, B:36:0x00a5, B:38:0x00ab, B:41:0x00b3, B:44:0x00b9, B:47:0x00c5, B:54:0x00d5, B:56:0x00db), top: B:2:0x0005, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private android.content.Intent b(android.content.Context r10, com.vivo.push.model.InsideNotificationItem r11, com.vivo.push.model.NotifyArriveCallbackByUser r12) {
        /*
            Method dump skipped, instructions count: 428
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.push.util.i.b(android.content.Context, com.vivo.push.model.InsideNotificationItem, com.vivo.push.model.NotifyArriveCallbackByUser):android.content.Intent");
    }

    private Intent a(Map<String, String> map, String str, Context context) {
        Intent intent = new Intent();
        intent.setPackage(str);
        try {
            intent = INVOKEVIRTUAL_com_vivo_push_util_i_com_dragon_read_base_lancet_PrivacyAop_getLaunchIntentForPackage(context.getPackageManager(), str);
            if (intent != null) {
                intent.setFlags(335544320);
                a(intent, map);
            } else {
                this.e = 2162;
                t.a("AndroidTwelveNotifyClickIntentParam", "sendFakeNoticeToClient LaunchIntent is null");
            }
        } catch (Exception e) {
            t.a("AndroidTwelveNotifyClickIntentParam", "sendFakeNoticeToClient LaunchIntent Exception" + e.getMessage());
        }
        return intent;
    }

    @Proxy("getActivity")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.app.PendingIntent")
    public static PendingIntent INVOKESTATIC_com_vivo_push_util_i_com_dragon_read_aop_target31_PendingIntentAop_getActivity(Context context, int i, Intent intent, int i2) {
        boolean z;
        if (Build.VERSION.SDK_INT >= 31) {
            boolean z2 = true;
            if ((67108864 & i2) != 0) {
                z = true;
            } else {
                z = false;
            }
            if ((i2 & 33554432) == 0) {
                z2 = false;
            }
            if (!z2 && !z) {
                i2 |= 33554432;
            }
        }
        return PendingIntent.getActivity(context, i, intent, i2);
    }

    private Intent a(String str, String str2, InsideNotificationItem insideNotificationItem, Context context) {
        try {
            Intent parseUri = Intent.parseUri(str, 1);
            parseUri.setSelector(null);
            parseUri.setPackage(str2);
            parseUri.setFlags(335544320);
            a(parseUri, insideNotificationItem.getParams());
            int a = a(parseUri, str2);
            if (a > 0) {
                this.e = a;
                t.c(context, " 落地页未找到，通知不展示：  " + this.e);
                return null;
            }
            return parseUri;
        } catch (Exception e) {
            t.a("AndroidTwelveNotifyClickIntentParam", "sendFakeNoticeToClient open activity error : ".concat(String.valueOf(str)), e);
            this.e = 2158;
            return null;
        }
    }
}
