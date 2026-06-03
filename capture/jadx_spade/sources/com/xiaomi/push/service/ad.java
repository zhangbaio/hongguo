package com.xiaomi.push.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import com.bytedance.covode.number.Covode;
import com.dragon.read.app.PrivacyMgr;
import com.xiaomi.push.gj;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
class ad {
    private static ad a;

    /* renamed from: a, reason: collision with other field name */
    private SpannableString f906a;

    private ad() {
    }

    public static ad a() {
        return a;
    }

    /* renamed from: a, reason: collision with other method in class */
    private boolean m677a() {
        return Build.VERSION.SDK_INT >= 24;
    }

    private boolean a(Context context) {
        if (b(context) && af.m683a(context)) {
            return ah.a(context).a(gj.LatestNotificationNotIntoGroupSwitch.a(), false);
        }
        return false;
    }

    /* renamed from: a, reason: collision with other method in class */
    private boolean m678a(Notification notification) {
        if (notification == null) {
            return false;
        }
        Object a2 = com.xiaomi.push.av.a((Object) notification, "isGroupSummary", (Object[]) null);
        if (a2 instanceof Boolean) {
            return ((Boolean) a2).booleanValue();
        }
        return false;
    }

    public String a(Context context, Notification.Builder builder, String str) {
        if (!m677a() || !a(context)) {
            return str;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Bundle extras = builder.getExtras();
        extras.putString("push_src_group_name", str);
        extras.putLong("push_src_group_time", currentTimeMillis);
        return String.format("pushmask_%s_%s", Long.valueOf(currentTimeMillis), str);
    }

    public void a(Context context, int i, Notification notification) {
        if (m677a()) {
            if (a(context)) {
                try {
                    b(context, i, notification);
                } catch (Exception e) {
                    com.xiaomi.channel.commonutils.logger.b.m54a("group notify handle restore error " + e);
                }
            }
            if (b(context)) {
                try {
                    a(context, i, notification, true);
                } catch (Exception e2) {
                    com.xiaomi.channel.commonutils.logger.b.m54a("group notify handle auto error " + e2);
                }
            }
        }
    }

    private void a(Map<String, a> map, StatusBarNotification statusBarNotification) {
        String b2 = b(statusBarNotification.getNotification());
        a aVar = map.get(b2);
        if (aVar == null) {
            aVar = new a();
            map.put(b2, aVar);
        }
        b bVar = new b(statusBarNotification.getId(), statusBarNotification.getNotification());
        if (m678a(statusBarNotification.getNotification())) {
            aVar.b.add(bVar);
        } else {
            aVar.f907a.add(bVar);
        }
    }

    static {
        Covode.recordClassIndex(655660);
        a = new ad();
    }

    private class b {
        int a;

        /* renamed from: a, reason: collision with other field name */
        Notification f908a;

        static {
            Covode.recordClassIndex(655662);
        }

        public String toString() {
            return "id:" + this.a;
        }

        public b(int i, Notification notification) {
            this.a = i;
            this.f908a = notification;
        }
    }

    private String a(Notification notification) {
        Bundle bundle;
        if (notification != null && (bundle = notification.extras) != null) {
            return bundle.getString("push_src_group_name");
        }
        return null;
    }

    private boolean b(Context context) {
        return ah.a(context).a(gj.NotificationAutoGroupSwitch.a(), true);
    }

    private class a {

        /* renamed from: a, reason: collision with other field name */
        List<b> f907a;
        List<b> b;

        static {
            Covode.recordClassIndex(655661);
        }

        private a() {
            this.f907a = new ArrayList();
            this.b = new ArrayList();
        }
    }

    private String b(Notification notification) {
        if (notification == null) {
            return null;
        }
        String group = notification.getGroup();
        if (m679b(notification)) {
            return a(notification);
        }
        return group;
    }

    private List<StatusBarNotification> a(af afVar) {
        List<StatusBarNotification> list;
        if (afVar != null) {
            list = afVar.m691b();
        } else {
            list = null;
        }
        if (list == null || list.size() == 0) {
            return null;
        }
        return list;
    }

    /* renamed from: b, reason: collision with other method in class */
    private boolean m679b(Notification notification) {
        Bundle bundle;
        if (notification == null || notification.getGroup() == null || (bundle = notification.extras) == null) {
            return false;
        }
        return notification.getGroup().equals(String.format("pushmask_%s_%s", Long.valueOf(bundle.getLong("push_src_group_time")), a(notification)));
    }

    private int a(String str, String str2) {
        return ("GroupSummary" + str + str2).hashCode();
    }

    @Proxy("getLaunchIntentForPackage")
    @TargetClass("android.content.pm.PackageManager")
    public static Intent INVOKEVIRTUAL_com_xiaomi_push_service_ad_com_dragon_read_base_lancet_PrivacyAop_getLaunchIntentForPackage(PackageManager packageManager, String str) {
        if (PrivacyMgr.inst().hasConfirmedAndNotBasic()) {
            return packageManager.getLaunchIntentForPackage(str);
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.phoenix.read", "com.dragon.read.pages.splash.SplashActivity"));
        return intent;
    }

    private PendingIntent a(Context context, String str) {
        PendingIntent INVOKESTATIC_com_xiaomi_push_service_ad_com_dragon_read_aop_target31_PendingIntentAop_getActivity;
        if (context == null && TextUtils.isEmpty(str)) {
            com.xiaomi.channel.commonutils.logger.b.m54a("ctx or pkg must not be null in getting launch intent");
            return null;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                com.xiaomi.channel.commonutils.logger.b.m54a("pm must not be null in getting launch intent");
                return null;
            }
            Intent INVOKEVIRTUAL_com_xiaomi_push_service_ad_com_dragon_read_base_lancet_PrivacyAop_getLaunchIntentForPackage = INVOKEVIRTUAL_com_xiaomi_push_service_ad_com_dragon_read_base_lancet_PrivacyAop_getLaunchIntentForPackage(packageManager, str);
            if (INVOKEVIRTUAL_com_xiaomi_push_service_ad_com_dragon_read_base_lancet_PrivacyAop_getLaunchIntentForPackage == null) {
                com.xiaomi.channel.commonutils.logger.b.m54a("targetIntent must not be null in getting launch intent");
                return null;
            }
            INVOKEVIRTUAL_com_xiaomi_push_service_ad_com_dragon_read_base_lancet_PrivacyAop_getLaunchIntentForPackage.addFlags(268435456);
            if (Build.VERSION.SDK_INT >= 31) {
                INVOKESTATIC_com_xiaomi_push_service_ad_com_dragon_read_aop_target31_PendingIntentAop_getActivity = INVOKESTATIC_com_xiaomi_push_service_ad_com_dragon_read_aop_target31_PendingIntentAop_getActivity(context, 0, INVOKEVIRTUAL_com_xiaomi_push_service_ad_com_dragon_read_base_lancet_PrivacyAop_getLaunchIntentForPackage, 33554432);
            } else {
                INVOKESTATIC_com_xiaomi_push_service_ad_com_dragon_read_aop_target31_PendingIntentAop_getActivity = INVOKESTATIC_com_xiaomi_push_service_ad_com_dragon_read_aop_target31_PendingIntentAop_getActivity(context, 0, INVOKEVIRTUAL_com_xiaomi_push_service_ad_com_dragon_read_base_lancet_PrivacyAop_getLaunchIntentForPackage, 0);
            }
            return INVOKESTATIC_com_xiaomi_push_service_ad_com_dragon_read_aop_target31_PendingIntentAop_getActivity;
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.d("error occurred during getting launch pendingIntent. exception:" + th);
            return null;
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    private SpannableString m676a(Context context, String str) {
        int i;
        Resources resources;
        DisplayMetrics displayMetrics;
        int max;
        if (this.f906a == null) {
            if (context != null && (resources = context.getResources()) != null && (displayMetrics = resources.getDisplayMetrics()) != null && (max = Math.max(displayMetrics.heightPixels, displayMetrics.widthPixels)) > 0) {
                i = max / 16;
            } else {
                i = 200;
            }
            if (TextUtils.isEmpty(str)) {
                str = "新消息";
            }
            StringBuilder sb = new StringBuilder(str.length() + i + 12);
            sb.append(str);
            for (int i2 = 0; i2 < i; i2++) {
                sb.append(' ');
            }
            sb.append("GroupSummary");
            SpannableString spannableString = new SpannableString(sb.toString());
            spannableString.setSpan(new ForegroundColorSpan(0), str.length(), sb.length(), 33);
            this.f906a = spannableString;
        }
        return this.f906a;
    }

    private void b(Context context, int i, Notification notification) {
        String c = ag.c(notification);
        if (TextUtils.isEmpty(c)) {
            com.xiaomi.channel.commonutils.logger.b.m54a("group restore not extract pkg from notification:" + i);
            return;
        }
        af a2 = af.a(context, c);
        List<StatusBarNotification> a3 = a(a2);
        if (a3 == null) {
            com.xiaomi.channel.commonutils.logger.b.m54a("group restore not get notifications");
            return;
        }
        for (StatusBarNotification statusBarNotification : a3) {
            Notification notification2 = statusBarNotification.getNotification();
            if (notification2 != null && m679b(notification2) && statusBarNotification.getId() != i) {
                Notification.Builder recoverBuilder = Notification.Builder.recoverBuilder(context, statusBarNotification.getNotification());
                recoverBuilder.setGroup(a(notification2));
                ag.a(recoverBuilder, m678a(notification2));
                a2.a(statusBarNotification.getId(), recoverBuilder.build());
                com.xiaomi.channel.commonutils.logger.b.b("group restore notification:" + statusBarNotification.getId());
            }
        }
    }

    private void a(Context context, String str, String str2) {
        com.xiaomi.channel.commonutils.logger.b.b("group cancel summary:" + str2);
        af.a(context, str).a(a(str, str2));
    }

    @Proxy("getActivity")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.app.PendingIntent")
    public static PendingIntent INVOKESTATIC_com_xiaomi_push_service_ad_com_dragon_read_aop_target31_PendingIntentAop_getActivity(Context context, int i, Intent intent, int i2) {
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

    private void a(Context context, int i, Notification notification, boolean z) {
        Notification notification2;
        String c = ag.c(notification);
        if (TextUtils.isEmpty(c)) {
            com.xiaomi.channel.commonutils.logger.b.m54a("group auto not extract pkg from notification:" + i);
            return;
        }
        List<StatusBarNotification> a2 = a(af.a(context, c));
        if (a2 == null) {
            com.xiaomi.channel.commonutils.logger.b.m54a("group auto not get notifications");
            return;
        }
        String b2 = b(notification);
        HashMap hashMap = new HashMap();
        for (StatusBarNotification statusBarNotification : a2) {
            if (statusBarNotification.getNotification() != null && statusBarNotification.getId() != i) {
                a(hashMap, statusBarNotification);
            }
        }
        for (Map.Entry<String, a> entry : hashMap.entrySet()) {
            String key = entry.getKey();
            if (!TextUtils.isEmpty(key)) {
                a value = entry.getValue();
                if (z && key.equals(b2) && !m679b(notification)) {
                    b bVar = new b(i, notification);
                    if (m678a(notification)) {
                        value.b.add(bVar);
                    } else {
                        value.f907a.add(bVar);
                    }
                }
                int size = value.f907a.size();
                if (value.b.size() <= 0) {
                    if (z && size >= 2) {
                        a(context, c, key, value.f907a.get(0).f908a);
                    }
                } else if (size <= 0) {
                    a(context, c, key);
                } else if (ah.a(context).a(gj.NotificationGroupUpdateTimeSwitch.a(), false) && (notification2 = value.b.get(0).f908a) != null) {
                    notification2.when = System.currentTimeMillis();
                    a(context, c, key, notification2);
                }
            }
        }
    }

    private void a(Context context, String str, String str2, Notification notification) {
        Notification.Builder defaults;
        try {
            if (TextUtils.isEmpty(str2)) {
                com.xiaomi.channel.commonutils.logger.b.m54a("group show summary group is null");
                return;
            }
            int a2 = ag.a(context, str);
            if (a2 == 0) {
                com.xiaomi.channel.commonutils.logger.b.m54a("group show summary not get icon from " + str);
                return;
            }
            af a3 = af.a(context, str);
            int i = Build.VERSION.SDK_INT;
            if (i >= 26) {
                String c = a3.c(notification.getChannelId(), "groupSummary");
                NotificationChannel m685a = a3.m685a(c);
                if ("groupSummary".equals(c) && m685a == null) {
                    a3.a(new NotificationChannel(c, "group_summary", 3));
                }
                defaults = new Notification.Builder(context, c);
            } else {
                defaults = new Notification.Builder(context).setPriority(0).setDefaults(-1);
            }
            ag.a(defaults, true);
            Notification build = defaults.setContentTitle(m676a(context, "新消息")).setContentText("你有一条新消息").setSmallIcon(Icon.createWithResource(str, a2)).setAutoCancel(true).setGroup(str2).setGroupSummary(true).build();
            if (i >= 31) {
                build.contentIntent = a(context, str);
            }
            if (!com.xiaomi.push.j.m635c() && "com.xiaomi.xmsf".equals(context.getPackageName())) {
                ag.m692a(build, str);
            }
            int a4 = a(str, str2);
            a3.a(a4, build);
            com.xiaomi.channel.commonutils.logger.b.b("group show summary notify:" + a4);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m54a("group show summary error " + e);
        }
    }
}
