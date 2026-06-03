package com.xiaomi.push.service;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.xiaomi.push.BuildConfig;
import com.xiaomi.push.r;
import com.xiaomi.push.service.am;
import java.util.Locale;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class p {
    public final int a;

    /* renamed from: a, reason: collision with other field name */
    public final String f1002a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;

    static {
        Covode.recordClassIndex(655731);
    }

    public static boolean a() {
        try {
            return com.xiaomi.push.q.a(null, "miui.os.Build").getField("IS_ALPHA_BUILD").getBoolean(null);
        } catch (Exception unused) {
            return false;
        }
    }

    private static boolean b(Context context) {
        return context.getPackageName().equals("com.xiaomi.xmsf");
    }

    public am.b a(XMPushService xMPushService) {
        am.b bVar = new am.b(xMPushService);
        a(bVar, xMPushService, xMPushService.m669b(), "c");
        return bVar;
    }

    private static String a(Context context) {
        if ("com.xiaomi.xmsf".equals(context)) {
            if (!TextUtils.isEmpty(null)) {
                return null;
            }
            String m628a = com.xiaomi.push.j.m628a("ro.miui.region");
            if (TextUtils.isEmpty(m628a)) {
                return com.xiaomi.push.j.m628a("ro.product.locale.region");
            }
            return m628a;
        }
        return com.xiaomi.push.j.b();
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m744a(Context context) {
        if ("com.xiaomi.xmsf".equals(context.getPackageName()) && a()) {
            return true;
        }
        return false;
    }

    public am.b a(am.b bVar, Context context, h hVar, String str) {
        String str2;
        bVar.f933a = context.getPackageName();
        bVar.f936b = this.f1002a;
        bVar.h = this.c;
        bVar.c = this.b;
        bVar.g = "5";
        bVar.d = "XMPUSH-PASS";
        bVar.f935a = false;
        r.a aVar = new r.a();
        aVar.a("sdk_ver", 48).a("cpvn", BuildConfig.VERSION_NAME).a("cpvc", 50906).a("country_code", b.a(context).b()).a("region", b.a(context).a()).a("miui_vn", com.xiaomi.push.j.c()).a("miui_vc", Integer.valueOf(com.xiaomi.push.j.a(context))).a("xmsf_vc", Integer.valueOf(com.xiaomi.push.g.a(context, "com.xiaomi.xmsf"))).a("android_ver", Integer.valueOf(Build.VERSION.SDK_INT)).a("n_belong_to_app", Boolean.valueOf(af.m683a(context))).a("systemui_vc", Integer.valueOf(com.xiaomi.push.g.a(context)));
        String a = a(context);
        if (!TextUtils.isEmpty(a)) {
            aVar.a("latest_country_code", a);
        }
        String d = com.xiaomi.push.j.d();
        if (!TextUtils.isEmpty(d)) {
            aVar.a("device_ch", d);
        }
        String e = com.xiaomi.push.j.e();
        if (!TextUtils.isEmpty(e)) {
            aVar.a("device_mfr", e);
        }
        bVar.e = aVar.toString();
        if (b(context)) {
            str2 = "1000271";
        } else {
            str2 = this.d;
        }
        r.a aVar2 = new r.a();
        aVar2.a("appid", str2).a("locale", Locale.getDefault().toString()).a("sync", 1);
        if (m744a(context)) {
            aVar2.a("ab", str);
        }
        bVar.f = aVar2.toString();
        bVar.f932a = hVar;
        return bVar;
    }

    public p(String str, String str2, String str3, String str4, String str5, String str6, int i) {
        this.f1002a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = str6;
        this.a = i;
    }
}
