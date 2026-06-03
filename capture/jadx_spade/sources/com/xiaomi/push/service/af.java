package com.xiaomi.push.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.xiaomi.push.gj;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.WeakHashMap;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class af {
    private static Context a;

    /* renamed from: a, reason: collision with other field name */
    private static Object f913a;

    /* renamed from: a, reason: collision with other field name */
    private static WeakHashMap<Integer, af> f914a;

    /* renamed from: a, reason: collision with other field name */
    private static boolean f915a;

    /* renamed from: a, reason: collision with other field name */
    private String f916a;
    private String b;

    /* renamed from: a, reason: collision with other method in class */
    public Context m686a() {
        return a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public String m687a() {
        return this.f916a;
    }

    /* renamed from: a, reason: collision with other method in class */
    private static boolean m682a() {
        if (com.xiaomi.push.j.m630a() && ah.a(a).a(gj.NotificationBelongToAppSwitch.a(), true)) {
            return f915a;
        }
        return false;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m690a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith(b(""));
    }

    /* renamed from: a, reason: collision with other method in class */
    public String m688a(String str) {
        if (TextUtils.isEmpty(str)) {
            return b();
        }
        return com.xiaomi.push.j.m631a(m686a()) ? b(str) : str;
    }

    void a(NotificationChannel notificationChannel) {
        String str = this.f916a;
        try {
            if (m682a()) {
                int a2 = a(str);
                if (a2 != -1) {
                    com.xiaomi.push.av.b(f913a, "createNotificationChannelsForPackage", str, Integer.valueOf(a2), a(Arrays.asList(notificationChannel)));
                }
            } else {
                a().createNotificationChannel(notificationChannel);
            }
        } catch (Exception e) {
            m681a("createNotificationChannel error" + e);
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public NotificationChannel m685a(String str) {
        NotificationChannel notificationChannel = null;
        try {
            if (m682a()) {
                List<NotificationChannel> m689a = m689a();
                if (m689a != null) {
                    for (NotificationChannel notificationChannel2 : m689a) {
                        if (str.equals(notificationChannel2.getId())) {
                            notificationChannel = notificationChannel2;
                            break;
                        }
                    }
                }
            } else {
                notificationChannel = a().getNotificationChannel(str);
            }
        } catch (Exception e) {
            m681a("getNotificationChannel error" + e);
        }
        return notificationChannel;
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    /* renamed from: a, reason: collision with other method in class */
    public List<NotificationChannel> m689a() {
        String str;
        String str2 = this.f916a;
        List<NotificationChannel> list = null;
        try {
            if (m682a()) {
                int a2 = a(str2);
                if (a2 != -1) {
                    Object obj = f913a;
                    Object[] objArr = {str2, Integer.valueOf(a2), Boolean.FALSE};
                    str = "mipush|%s|%s";
                    list = (List) a(com.xiaomi.push.av.a(obj, "getNotificationChannelsForPackage", objArr));
                } else {
                    str = null;
                }
            } else {
                list = a().getNotificationChannels();
                str = "mipush_%s_%s";
            }
            if (!com.xiaomi.push.j.m630a() || list == null) {
                return list;
            }
            ArrayList arrayList = new ArrayList();
            String a3 = a(str, str2, "");
            for (NotificationChannel notificationChannel : list) {
                if (notificationChannel.getId().startsWith(a3)) {
                    arrayList.add(notificationChannel);
                }
            }
            return arrayList;
        } catch (Exception e) {
            m681a("getNotificationChannels error " + e);
            return list;
        }
    }

    void a(NotificationChannel notificationChannel, boolean z) {
        String str = this.f916a;
        try {
            if (z) {
                int a2 = a(str);
                if (a2 != -1) {
                    com.xiaomi.push.av.b(f913a, "updateNotificationChannelForPackage", str, Integer.valueOf(a2), notificationChannel);
                }
            } else {
                a(notificationChannel);
            }
        } catch (Exception e) {
            m681a("updateNotificationChannel error " + e);
        }
    }

    public void a(int i, Notification notification) {
        String str = this.f916a;
        NotificationManager a2 = a();
        try {
            int i2 = Build.VERSION.SDK_INT;
            if (m682a()) {
                notification.extras.putString("xmsf_target_package", str);
                if (i2 >= 29) {
                    INVOKEVIRTUAL_com_xiaomi_push_service_af_com_dragon_read_base_lancet_NotifyPushAop_notifyAsPackage(a2, str, null, i, notification);
                } else {
                    INVOKEVIRTUAL_com_xiaomi_push_service_af_com_dragon_read_base_lancet_NotifyPushAop_notify(a2, i, notification);
                }
            } else {
                INVOKEVIRTUAL_com_xiaomi_push_service_af_com_dragon_read_base_lancet_NotifyPushAop_notify(a2, i, notification);
            }
        } catch (Exception unused) {
        }
    }

    public void a(int i) {
        String str = this.f916a;
        try {
            if (m682a()) {
                int a2 = com.xiaomi.push.i.a();
                String packageName = m686a().getPackageName();
                if (Build.VERSION.SDK_INT >= 30) {
                    com.xiaomi.push.av.b(f913a, "cancelNotificationWithTag", str, packageName, null, Integer.valueOf(i), Integer.valueOf(a2));
                } else {
                    com.xiaomi.push.av.b(f913a, "cancelNotificationWithTag", str, null, Integer.valueOf(i), Integer.valueOf(a2));
                }
                m681a("cancel succ:" + i);
                return;
            }
            a().cancel(i);
        } catch (Exception e) {
            m681a("cancel error" + e);
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    private StatusBarNotification[] m684a() {
        if (!com.xiaomi.push.j.m631a(m686a())) {
            return null;
        }
        try {
            Object a2 = com.xiaomi.push.av.a(f913a, "getActiveNotifications", m686a().getPackageName());
            if (a2 instanceof StatusBarNotification[]) {
                return (StatusBarNotification[]) a2;
            }
            return null;
        } catch (Throwable th) {
            m681a("getAllNotifications error " + th);
            return null;
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    static void m681a(String str) {
        com.xiaomi.channel.commonutils.logger.b.m54a("NMHelper:" + str);
    }

    static {
        Covode.recordClassIndex(655666);
        f914a = new WeakHashMap<>();
    }

    private static NotificationManager a() {
        return (NotificationManager) a.getSystemService("notification");
    }

    String b() {
        if (TextUtils.isEmpty(this.b)) {
            this.b = b("default");
        }
        return this.b;
    }

    public String toString() {
        return "NotificationManagerHelper{" + this.f916a + "}";
    }

    /* renamed from: b, reason: collision with other method in class */
    public List<StatusBarNotification> m691b() {
        StatusBarNotification[] m684a;
        String str = this.f916a;
        NotificationManager a2 = a();
        ArrayList arrayList = null;
        try {
            if (m682a()) {
                int a3 = com.xiaomi.push.i.a();
                if (a3 == -1) {
                    return null;
                }
                return (List) a(com.xiaomi.push.av.a(f913a, "getAppActiveNotifications", str, Integer.valueOf(a3)));
            }
            if (Build.VERSION.SDK_INT >= 23) {
                m684a = a2.getActiveNotifications();
            } else {
                m684a = m684a();
            }
            if (m684a == null || m684a.length <= 0) {
                return null;
            }
            ArrayList arrayList2 = new ArrayList();
            try {
                for (StatusBarNotification statusBarNotification : m684a) {
                    if (str.equals(ag.c(statusBarNotification.getNotification()))) {
                        arrayList2.add(statusBarNotification);
                    }
                }
                return arrayList2;
            } catch (Throwable th) {
                th = th;
                arrayList = arrayList2;
                m681a("getActiveNotifications error " + th);
                return arrayList;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private af(String str) {
        this.f916a = str;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m683a(Context context) {
        a(context);
        return m682a();
    }

    private String b(String str) {
        return b(this.f916a, str);
    }

    private static int a(String str) {
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                return a.getPackageManager().getPackageUid(str, 0);
            } catch (Exception unused) {
                return -1;
            }
        }
        return -1;
    }

    private static <T> T a(Object obj) {
        if (obj != null) {
            try {
                return (T) obj.getClass().getMethod("getList", new Class[0]).invoke(obj, new Object[0]);
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }

    private static Object a(List list) {
        return l3.a.q("android.content.pm.ParceledListSlice").getConstructor(List.class).newInstance(list);
    }

    private static void a(Context context) {
        boolean z;
        if (a == null) {
            a = context.getApplicationContext();
            NotificationManager a2 = a();
            Boolean bool = (Boolean) com.xiaomi.push.av.a((Object) a2, "isSystemConditionProviderEnabled", "xmsf_fake_condition_provider_path");
            m681a("fwk is support.init:" + bool);
            if (bool != null) {
                z = bool.booleanValue();
            } else {
                z = false;
            }
            f915a = z;
            if (z) {
                f913a = com.xiaomi.push.av.a((Object) a2, "getService", new Object[0]);
            }
        }
    }

    public static String b(String str, String str2) {
        String str3;
        if (m682a()) {
            str3 = "mipush|%s|%s";
        } else {
            str3 = "mipush_%s_%s";
        }
        return a(str3, str, str2);
    }

    String c(String str, String str2) {
        if (!m682a()) {
            return str2;
        }
        return str;
    }

    public static af a(Context context, String str) {
        a(context);
        int hashCode = str.hashCode();
        af afVar = f914a.get(Integer.valueOf(hashCode));
        if (afVar == null) {
            af afVar2 = new af(str);
            f914a.put(Integer.valueOf(hashCode), afVar2);
            return afVar2;
        }
        return afVar;
    }

    public static String a(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            String a2 = a("mipush|%s|%s", str2, "");
            if (str.startsWith(a2)) {
                return a("mipush_%s_%s", str2, str.replace(a2, ""));
            }
            return str;
        }
        return str;
    }

    @Proxy("notify")
    @TargetClass("android.app.NotificationManager")
    public static void INVOKEVIRTUAL_com_xiaomi_push_service_af_com_dragon_read_base_lancet_NotifyPushAop_notify(NotificationManager notificationManager, int i, Notification notification) {
        ko2.r.a.a((String) null, (String) null, i, notification);
        notificationManager.notify(i, notification);
    }

    private static String a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return String.format(str, str2, str3);
    }

    @Proxy("notifyAsPackage")
    @TargetClass("android.app.NotificationManager")
    public static void INVOKEVIRTUAL_com_xiaomi_push_service_af_com_dragon_read_base_lancet_NotifyPushAop_notifyAsPackage(NotificationManager notificationManager, String str, String str2, int i, Notification notification) {
        ko2.r.a.a(str, str2, i, notification);
        notificationManager.notifyAsPackage(str, str2, i, notification);
    }
}
