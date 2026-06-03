package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class cm {
    private static int a;

    /* renamed from: a, reason: collision with other field name */
    private static cq f202a;

    /* renamed from: a, reason: collision with other field name */
    private static String f203a;

    static {
        Covode.recordClassIndex(655418);
        a = -1;
        f203a = null;
    }

    private static synchronized String a() {
        String str;
        synchronized (cm.class) {
            str = f203a;
        }
        return str;
    }

    static void a(String str) {
        cj.a("Push-DiscntStats", str);
    }

    /* renamed from: a, reason: collision with other method in class */
    public static void m245a(Context context) {
        if (!m246a(context)) {
            a("onReconnection shouldSampling = false");
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        a = a(context);
        cp.a(context, currentTimeMillis);
        a("onReconnection connectedNetworkType = " + a);
    }

    private static int a(Context context) {
        String str;
        try {
            au m148a = at.m148a();
            if (m148a != null) {
                if (m148a.a() == 0) {
                    String m160b = m148a.m160b();
                    if (!TextUtils.isEmpty(m160b) && !"UNKNOWN".equalsIgnoreCase(m160b)) {
                        str = "M-" + m160b;
                    } else {
                        str = null;
                    }
                    b(str);
                    return 0;
                }
                if (m148a.a() != 1 && m148a.a() != 6) {
                    b(null);
                    return -1;
                }
                b("WIFI-ID-UNKNOWN");
                return 1;
            }
            b(null);
            return -1;
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.d("DisconnectStatsHelper getNetType occurred error: " + e.getMessage());
            b(null);
            return -1;
        }
    }

    private static synchronized void b(String str) {
        synchronized (cm.class) {
            if ("WIFI-ID-UNKNOWN".equals(str)) {
                String str2 = f203a;
                if (str2 == null || !str2.startsWith("W-")) {
                    f203a = null;
                }
            } else {
                f203a = str;
            }
            a("updateNetId new networkId = " + str + ", finally netId = " + f203a);
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    private static boolean m246a(Context context) {
        return cj.a(context);
    }

    public static void b(Context context, ez ezVar) {
        cq cqVar = f202a;
        if (cqVar != null) {
            ezVar.b(cqVar);
            f202a = null;
            a("stopStats");
        }
    }

    public static void a(Context context, ez ezVar) {
        if (m246a(context)) {
            if (f202a == null) {
                f202a = new cq(context);
            }
            ezVar.a(f202a);
            a("startStats");
        }
    }

    public static void a(Context context, String str) {
        if (!m246a(context)) {
            a("onWifiChanged shouldSampling = false");
            return;
        }
        a("onWifiChanged wifiDigest = " + str);
        if (!TextUtils.isEmpty(str)) {
            b("W-" + str);
        }
    }

    public static void a(Context context, String str, int i) {
        if (!m246a(context)) {
            a("onDisconnection shouldSampling = false");
            return;
        }
        cp.a(context, str, at.b(context), System.currentTimeMillis(), i, com.xiaomi.push.service.m.a(context).m730b(), a(context), a(), a);
        a("onDisconnection");
    }
}
