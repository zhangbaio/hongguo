package com.xiaomi.push.service;

import android.app.Notification;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.xiaomi.push.ad;
import com.xiaomi.push.du;
import java.util.List;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class bb {
    static {
        Covode.recordClassIndex(655705);
    }

    private static int a(Map<String, String> map) {
        return Math.max(0, com.xiaomi.push.r.a(map.get("notification_top_period"), 0));
    }

    private static int b(Map<String, String> map) {
        return Math.max(0, com.xiaomi.push.r.a(map.get("notification_top_frequency"), 0));
    }

    /* renamed from: a, reason: collision with other method in class */
    private static boolean m718a(Map<String, String> map) {
        String str = map.get("notification_top_repeat");
        if (!TextUtils.isEmpty(str)) {
            boolean parseBoolean = Boolean.parseBoolean(str);
            com.xiaomi.channel.commonutils.logger.b.c("top notification' repeat is " + parseBoolean);
            return parseBoolean;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(int i, String str) {
        return "n_top_update_" + i + "_" + str;
    }

    private static Notification a(Notification notification, int i, String str, af afVar) {
        if (notification != null) {
            if (!str.equals(notification.extras.getString("message_id"))) {
                notification = null;
            }
            return notification;
        }
        List<StatusBarNotification> m691b = afVar.m691b();
        if (m691b == null) {
            return null;
        }
        for (StatusBarNotification statusBarNotification : m691b) {
            Notification notification2 = statusBarNotification.getNotification();
            String string = notification2.extras.getString("message_id");
            if (i == statusBarNotification.getId() && str.equals(string)) {
                return notification2;
            }
        }
        return null;
    }

    static void a(Context context, Map<String, String> map, du duVar, long j) {
        if (map != null && duVar != null && com.xiaomi.push.j.m631a(context) && m718a(map)) {
            int a = a(map);
            int b = b(map);
            if (a > 0 && b <= a) {
                duVar.setPriority(2);
                Bundle bundle = new Bundle();
                bundle.putLong("mipush_org_when", j);
                bundle.putBoolean("mipush_n_top_flag", true);
                if (b > 0) {
                    bundle.putInt("mipush_n_top_fre", b);
                }
                bundle.putInt("mipush_n_top_prd", a);
                duVar.addExtras(bundle);
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.d("set top notification failed - period:" + a + " frequency:" + b);
        }
    }

    private static ad.a a(final Context context, final String str, final int i, final String str2, final Notification notification) {
        return new ad.a() { // from class: com.xiaomi.push.service.bb.1
            @Override // com.xiaomi.push.ad.a
            /* renamed from: a */
            public String mo187a() {
                return bb.b(i, str2);
            }

            @Override // java.lang.Runnable
            public void run() {
                bb.c(context, str, i, str2, notification);
            }
        };
    }

    /* renamed from: a, reason: collision with other method in class */
    static void m717a(Context context, String str, int i, String str2, Notification notification) {
        if (com.xiaomi.push.j.m631a(context) && notification != null && notification.extras.getBoolean("mipush_n_top_flag", false)) {
            c(context, str, i, str2, notification);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Context context, String str, int i, String str2, Notification notification) {
        af a;
        Notification a2;
        boolean z;
        int i2;
        if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && Build.VERSION.SDK_INT >= 26 && (a2 = a(notification, i, str2, (a = af.a(context, str)))) != null) {
            if (notification != null) {
                z = true;
            } else {
                z = false;
            }
            if (a2.getGroupAlertBehavior() != 1) {
                com.xiaomi.push.av.a((Object) a2, "mGroupAlertBehavior", (Object) 1);
            }
            long currentTimeMillis = System.currentTimeMillis();
            long j = a2.extras.getLong("mipush_org_when", 0L);
            int i3 = a2.extras.getInt("mipush_n_top_fre", 0);
            int i4 = a2.extras.getInt("mipush_n_top_prd", 0);
            if (i4 > 0 && i4 >= i3) {
                long j2 = (i4 * 1000) + j;
                if (j < currentTimeMillis && currentTimeMillis < j2) {
                    if (i3 > 0) {
                        i2 = (int) Math.min((j2 - currentTimeMillis) / 1000, i3);
                    } else {
                        i2 = i4;
                    }
                } else {
                    i2 = 0;
                }
                if (!z) {
                    if (i2 > 0) {
                        a2.when = currentTimeMillis;
                        com.xiaomi.channel.commonutils.logger.b.m54a("update top notification: " + str2);
                        a.a(i, a2);
                    } else {
                        Notification.Builder recoverBuilder = Notification.Builder.recoverBuilder(context, a2);
                        recoverBuilder.setPriority(0);
                        recoverBuilder.setWhen(currentTimeMillis);
                        Bundle extras = recoverBuilder.getExtras();
                        if (extras != null) {
                            extras.remove("mipush_n_top_flag");
                            extras.remove("mipush_org_when");
                            extras.remove("mipush_n_top_fre");
                            extras.remove("mipush_n_top_prd");
                            recoverBuilder.setExtras(extras);
                        }
                        com.xiaomi.channel.commonutils.logger.b.m54a("update top notification to common: " + str2);
                        a.a(i, recoverBuilder.build());
                    }
                }
                if (i2 > 0) {
                    com.xiaomi.channel.commonutils.logger.b.m54a("schedule top notification next update delay: " + i2);
                    com.xiaomi.push.ad.a(context).m135a(b(i, str2));
                    com.xiaomi.push.ad.a(context).b(a(context, str, i, str2, (Notification) null), i2);
                }
            }
        }
    }
}
