package com.xiaomi.push.service;

import android.app.Application;
import android.app.Notification;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.Settings;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class ag {
    public static final a<String, String, String> a;

    /* renamed from: a, reason: collision with other field name */
    static Boolean f917a;

    /* renamed from: a, reason: collision with other field name */
    private static String f918a;

    /* renamed from: a, reason: collision with other field name */
    private static final String[] f919a;
    public static final a<String, String, String> b;
    public static final a<String, String, String> c;
    public static final a<String, String, String> d;
    public static final a<String, String, String> e;
    public static final a<String, String, String> f;
    public static final a<String, String, String> g;
    public static final a<String, String, String> h;

    public static boolean a() {
        if (f917a == null) {
            if (Build.VERSION.SDK_INT >= 30) {
                Bundle m719a = f.m719a("com.xiaomi.xmsf", (String) null);
                if (m719a == null || m719a.isEmpty()) {
                    f917a = Boolean.FALSE;
                } else {
                    f917a = Boolean.TRUE;
                }
            } else {
                f917a = Boolean.FALSE;
            }
        }
        return f917a.booleanValue();
    }

    /* renamed from: a, reason: collision with other method in class */
    public static Notification.Action[] m694a(Notification notification) {
        Parcelable[] parcelableArray;
        Notification.Action[] actionArr = notification.actions;
        if (actionArr != null) {
            return actionArr;
        }
        Bundle bundle = notification.extras;
        if (bundle == null || (parcelableArray = bundle.getParcelableArray("mipush.customActions")) == null) {
            return null;
        }
        return (Notification.Action[]) Arrays.copyOf(parcelableArray, parcelableArray.length, Notification.Action[].class);
    }

    public static void a(Map<String, String> map, Bundle bundle, String str) {
        if (map == null || bundle == null || TextUtils.isEmpty(str)) {
            com.xiaomi.channel.commonutils.logger.b.m54a("cp map to b fail:" + str);
            return;
        }
        if (TextUtils.isEmpty(map.get(str))) {
            bundle.remove(str);
        } else {
            bundle.putString(str, map.get(str));
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    static void m692a(Notification notification, String str) {
        try {
            Bundle bundle = notification.extras;
            if (bundle != null) {
                bundle.putString("target_package", str);
            }
            Object a2 = com.xiaomi.push.av.a(notification, "extraNotification");
            if (a2 != null) {
                com.xiaomi.push.av.a(a2, "setTargetPkg", str);
            }
        } catch (Exception unused) {
        }
    }

    static void a(Notification notification, boolean z) {
        try {
            Bundle bundle = notification.extras;
            if (bundle != null) {
                bundle.putBoolean("miui.enableFloat", z);
            }
            Object a2 = com.xiaomi.push.av.a(notification, "extraNotification");
            if (a2 != null) {
                com.xiaomi.push.av.a(a2, "setEnableFloat", Boolean.valueOf(z));
            }
        } catch (Exception unused) {
        }
    }

    static void a(Notification notification, int i) {
        try {
            Bundle bundle = notification.extras;
            if (bundle != null) {
                bundle.putInt("miui.messageCount", i);
            }
            Object a2 = com.xiaomi.push.av.a(notification, "extraNotification");
            if (a2 != null) {
                com.xiaomi.push.av.a(a2, "setMessageCount", Integer.valueOf(i));
            }
        } catch (Exception unused) {
        }
    }

    static void a(Notification notification, int i, int i2) {
        if (notification != null) {
            if (notification.extras == null) {
                notification.extras = new Bundle();
            }
            notification.extras.putInt("is_priority", i);
            notification.extras.putInt("mipush_class", i2);
        }
    }

    static void a(Context context, String str, Intent intent) {
        if (intent == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            arrayList.add(str);
        }
        arrayList.addAll(Arrays.asList(f919a));
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            String str2 = (String) arrayList.get(i);
            if (!TextUtils.isEmpty(str2)) {
                Intent intent2 = new Intent(intent);
                intent2.setPackage(str2);
                try {
                    if (context.getPackageManager().resolveActivity(intent2, 65536) != null) {
                        intent.setPackage(str2);
                        break;
                    }
                    continue;
                } catch (Exception e2) {
                    com.xiaomi.channel.commonutils.logger.b.m54a("can't match url intent. " + e2);
                }
            }
        }
        intent.setPackage(intent.getPackage());
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m693a(ContentResolver contentResolver) {
        int a2 = a(contentResolver);
        return a2 == 1 || a2 == 2;
    }

    public static boolean a(Map<String, String> map) {
        return Boolean.parseBoolean((String) a(map, "not_suppress", "true"));
    }

    public static boolean a(Notification.Builder builder, boolean z) {
        if (Build.VERSION.SDK_INT >= 26) {
            builder.setGroupAlertBehavior(z ? 2 : 1);
            return true;
        }
        com.xiaomi.channel.commonutils.logger.b.b("not support setGroupAlertBehavior");
        return false;
    }

    public static boolean a(Context context, String str, String str2, a<String, String, String> aVar, boolean z) {
        if (aVar != null) {
            try {
                Bundle bundle = new Bundle();
                bundle.putBoolean(aVar.c, z);
                a(context, aVar.a, str, str2, bundle);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    static {
        Covode.recordClassIndex(655667);
        f919a = new String[]{"com.mi.globalbrowser", "com.android.browser"};
        f918a = null;
        String str = "getNotificationSettings";
        a = new a<>(str, str, str);
        String str2 = "canSound";
        b = new a<>("setSound", str2, str2);
        String str3 = "canVibrate";
        c = new a<>("setVibrate", str3, str3);
        String str4 = "canLights";
        d = new a<>("setLights", str4, str4);
        String str5 = "canShowOnKeyguard";
        e = new a<>("setShowOnKeyguard", str5, str5);
        f = new a<>("setFloat", "canFloat", "canShowFloat");
        String str6 = "canShowBadge";
        g = new a<>("setShowBadge", str6, str6);
        String str7 = "canShowOngoing";
        h = new a<>("setShowOngoing", str7, str7);
    }

    public static int a(ContentResolver contentResolver) {
        try {
            return Settings.Global.getInt(contentResolver, "user_aggregate", 0);
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.m54a("get user aggregate failed, " + e2);
            return 0;
        }
    }

    public static String b(Notification notification) {
        CharSequence charSequence;
        Bundle bundle = notification.extras;
        if (bundle != null) {
            charSequence = bundle.getCharSequence("android.text");
            if (TextUtils.isEmpty(charSequence)) {
                charSequence = notification.extras.getCharSequence("android.bigText");
            }
            if (TextUtils.isEmpty(charSequence)) {
                charSequence = notification.extras.getCharSequence("mipush.customContent");
            }
        } else {
            charSequence = null;
        }
        if (charSequence != null) {
            return charSequence.toString();
        }
        return "";
    }

    public static String c(Notification notification) {
        Object a2;
        String str = null;
        try {
            Bundle bundle = notification.extras;
            if (bundle != null) {
                str = bundle.getString("target_package");
            }
            if (TextUtils.isEmpty(str) && (a2 = com.xiaomi.push.av.a(notification, "extraNotification")) != null) {
                return (String) com.xiaomi.push.av.a(a2, "getTargetPkg", new Object[0]);
            }
            return str;
        } catch (Exception unused) {
            return str;
        }
    }

    public static String a(Notification notification) {
        CharSequence charSequence;
        Bundle bundle = notification.extras;
        if (bundle != null) {
            charSequence = bundle.getCharSequence("android.title");
            if (TextUtils.isEmpty(charSequence)) {
                charSequence = notification.extras.getCharSequence("android.title.big");
            }
            if (TextUtils.isEmpty(charSequence)) {
                charSequence = notification.extras.getCharSequence("mipush.customTitle");
            }
        } else {
            charSequence = null;
        }
        if (charSequence != null) {
            return charSequence.toString();
        }
        return "";
    }

    public static String a(Object obj) {
        return (String) a(obj, "msg_busi_type", "");
    }

    static int a(Context context, String str) {
        return com.xiaomi.push.g.b(context, str);
    }

    public static void b(Notification notification, boolean z) {
        try {
            Bundle bundle = notification.extras;
            if (bundle != null) {
                bundle.putBoolean("miui.enableKeyguard", z);
            }
            Object a2 = com.xiaomi.push.av.a(notification, "extraNotification");
            if (a2 != null) {
                com.xiaomi.push.av.a(a2, "setEnableKeyguard", Boolean.valueOf(z));
            }
        } catch (Exception unused) {
        }
    }

    public static <T> T a(Notification notification, String str) {
        Bundle bundle = notification.extras;
        if (bundle != null) {
            try {
                return (T) bundle.get(str);
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }

    public static class a<F, S, T> {
        F a;
        S b;
        T c;

        static {
            Covode.recordClassIndex(655668);
        }

        private a(F f, S s, T t) {
            this.a = f;
            this.b = s;
            this.c = t;
        }
    }

    public static Bundle a(Context context, String str, String str2) {
        try {
            return a(context, a.b, str, str2, (Bundle) null);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static <T> T a(java.lang.Object r2, java.lang.String r3, T r4) {
        /*
            r0 = 0
            boolean r1 = r2 instanceof android.app.Notification     // Catch: java.lang.Exception -> L38
            if (r1 == 0) goto Ld
            android.app.Notification r2 = (android.app.Notification) r2     // Catch: java.lang.Exception -> L38
            java.lang.Object r2 = a(r2, r3)     // Catch: java.lang.Exception -> L38
        Lb:
            r0 = r2
            goto L4d
        Ld:
            boolean r1 = r2 instanceof java.util.Map     // Catch: java.lang.Exception -> L38
            if (r1 == 0) goto L18
            java.util.Map r2 = (java.util.Map) r2     // Catch: java.lang.Exception -> L38
            java.lang.Object r2 = r2.get(r3)     // Catch: java.lang.Exception -> L38
            goto Lb
        L18:
            boolean r1 = r2 instanceof android.os.Bundle     // Catch: java.lang.Exception -> L38
            if (r1 == 0) goto L23
            android.os.Bundle r2 = (android.os.Bundle) r2     // Catch: java.lang.Exception -> L38
            java.lang.Object r2 = r2.get(r3)     // Catch: java.lang.Exception -> L38
            goto Lb
        L23:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L38
            r3.<init>()     // Catch: java.lang.Exception -> L38
            java.lang.String r1 = "not support get value from classType:"
            r3.append(r1)     // Catch: java.lang.Exception -> L38
            r3.append(r2)     // Catch: java.lang.Exception -> L38
            java.lang.String r2 = r3.toString()     // Catch: java.lang.Exception -> L38
            com.xiaomi.channel.commonutils.logger.b.m54a(r2)     // Catch: java.lang.Exception -> L38
            goto L4d
        L38:
            r2 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r1 = "get value error "
            r3.append(r1)
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            com.xiaomi.channel.commonutils.logger.b.m54a(r2)
        L4d:
            if (r0 != 0) goto L50
            goto L51
        L50:
            r4 = r0
        L51:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.ag.a(java.lang.Object, java.lang.String, java.lang.Object):java.lang.Object");
    }

    public static int a(Context context, String str, String str2, a<String, String, String> aVar) {
        if (aVar != null) {
            try {
                Bundle a2 = a(context, aVar.b, str, str2, (Bundle) null);
                if (a2 == null || !a2.containsKey(aVar.c)) {
                    return -1;
                }
                return a2.getBoolean(aVar.c) ? 1 : 0;
            } catch (Exception unused) {
                return -1;
            }
        }
        return -1;
    }

    @Proxy("call")
    @TargetClass("android.content.ContentResolver")
    public static Bundle INVOKEVIRTUAL_com_xiaomi_push_service_ag_com_dragon_read_base_lancet_AllianceProcessIsolateLancet_call(ContentResolver contentResolver, Uri uri, String str, String str2, Bundle bundle) {
        Application a2 = je6.b.a();
        LogWrapper.debug("ProcessIsolateLancet", "context=%s, uri=%s", new Object[]{a2, uri.getAuthority()});
        if (a2 != null && ke6.g.Y(a2) && !TextUtils.isEmpty(uri.getAuthority()) && (uri.getAuthority().endsWith(".pm.PPMP") || uri.getAuthority().endsWith(".am.PAMP"))) {
            LogWrapper.debug("ProcessIsolateLancet", "ContentResolver$call: intercept " + uri.getAuthority(), new Object[0]);
            return null;
        }
        return contentResolver.call(uri, str, str2, bundle);
    }

    private static Bundle a(Context context, String str, String str2, String str3, Bundle bundle) {
        if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("package", str2);
            if (!TextUtils.isEmpty(str3)) {
                bundle2.putString("channel_id", str3);
            }
            if (bundle != null) {
                bundle2.putAll(bundle);
            }
            return INVOKEVIRTUAL_com_xiaomi_push_service_ag_com_dragon_read_base_lancet_AllianceProcessIsolateLancet_call(context.getContentResolver(), Uri.parse("content://statusbar.notification"), str, null, bundle2);
        }
        throw new IllegalArgumentException("call notification provider failed!");
    }
}
