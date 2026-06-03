package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.xiaomi.push.ds;
import com.xiaomi.push.eq;
import com.xiaomi.push.fh;
import com.xiaomi.push.fk;
import com.xiaomi.push.fm;
import com.xiaomi.push.fn;
import com.xiaomi.push.fy;
import com.xiaomi.push.ge;
import com.xiaomi.push.go;
import com.xiaomi.push.gr;
import com.xiaomi.push.gu;
import com.xiaomi.push.gv;
import com.xiaomi.push.ha;
import com.xiaomi.push.hd;
import com.xiaomi.push.ho;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.am;
import com.xiaomi.push.service.x;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class u {
    static {
        Covode.recordClassIndex(655742);
    }

    public void a(Context context, am.b bVar, boolean z, int i, String str) {
        p m745a;
        if (z || (m745a = q.m745a(context)) == null || !"token-expired".equals(str)) {
            return;
        }
        q.a(context, m745a.f, m745a.d, m745a.e);
    }

    public void a(XMPushService xMPushService, fn fnVar, am.b bVar) {
        if (fnVar instanceof fm) {
            fm fmVar = (fm) fnVar;
            fk a = fmVar.a("s");
            if (a != null) {
                try {
                    a(xMPushService, ar.a(ar.a(bVar.h, fmVar.j()), a.c()), fy.a(fnVar.mo435a()));
                    return;
                } catch (IllegalArgumentException e) {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                    return;
                }
            }
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.m54a("not a mipush message");
    }

    public void a(XMPushService xMPushService, eq eqVar, am.b bVar) {
        HashMap hashMap;
        try {
            byte[] m399a = eqVar.m399a(bVar.h);
            if (e.b(eqVar)) {
                hashMap = new HashMap();
                hashMap.put("t_im", String.valueOf(eqVar.m400b()));
                hashMap.put("t_rt", String.valueOf(eqVar.m393a()));
            } else {
                hashMap = null;
            }
            a(xMPushService, m399a, eqVar.c(), hashMap);
        } catch (IllegalArgumentException e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
        }
    }

    private static void a(XMPushService xMPushService, byte[] bArr, long j) {
        a(xMPushService, bArr, j, (Map<String, String>) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00c1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void a(com.xiaomi.push.service.XMPushService r19, byte[] r20, long r21, java.util.Map<java.lang.String, java.lang.String> r23) {
        /*
            Method dump skipped, instructions count: 648
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.u.a(com.xiaomi.push.service.XMPushService, byte[], long, java.util.Map):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:120:0x0448  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x043b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(com.xiaomi.push.service.XMPushService r19, java.lang.String r20, byte[] r21, android.content.Intent r22) {
        /*
            Method dump skipped, instructions count: 1238
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.u.a(com.xiaomi.push.service.XMPushService, java.lang.String, byte[], android.content.Intent):void");
    }

    public static boolean a(Context context, String str, byte[] bArr) {
        if (!com.xiaomi.push.g.m459a(context, str)) {
            return false;
        }
        Intent intent = new Intent("com.xiaomi.mipush.MESSAGE_ARRIVED");
        intent.putExtra("mipush_payload", bArr);
        intent.setPackage(str);
        try {
            if (context.getPackageManager().queryBroadcastReceivers(intent, 0).isEmpty()) {
                return false;
            }
            com.xiaomi.channel.commonutils.logger.b.m54a("broadcast message arrived.");
            context.sendBroadcast(intent, w.a(str));
            return true;
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m54a("meet error when broadcast message arrived. " + e);
            return false;
        }
    }

    private static boolean a(XMPushService xMPushService, String str, ha haVar, gr grVar) {
        boolean z = true;
        if (grVar != null && grVar.m500a() != null && grVar.m500a().containsKey("__check_alive") && grVar.m500a().containsKey("__awake")) {
            hd hdVar = new hd();
            hdVar.b(haVar.m534a());
            hdVar.d(str);
            hdVar.c(go.AwakeSystemApp.f529a);
            hdVar.a(grVar.m499a());
            hdVar.f668a = new HashMap();
            boolean m459a = com.xiaomi.push.g.m459a(xMPushService.getApplicationContext(), str);
            hdVar.f668a.put("app_running", Boolean.toString(m459a));
            if (!m459a) {
                boolean parseBoolean = Boolean.parseBoolean(grVar.m500a().get("__awake"));
                hdVar.f668a.put("awaked", Boolean.toString(parseBoolean));
                if (!parseBoolean) {
                    z = false;
                }
            }
            try {
                w.a(xMPushService, w.a(haVar.b(), haVar.m534a(), hdVar, ge.Notification));
            } catch (fh e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
            }
        }
        return z;
    }

    private static boolean a(ha haVar) {
        return "com.xiaomi.xmsf".equals(haVar.f656b) && haVar.m533a() != null && haVar.m533a().m500a() != null && haVar.m533a().m500a().containsKey("miui_package_name");
    }

    private static boolean a(Context context, String str) {
        Intent intent = new Intent("com.xiaomi.mipush.miui.CLICK_MESSAGE");
        intent.setPackage(str);
        Intent intent2 = new Intent("com.xiaomi.mipush.miui.RECEIVE_MESSAGE");
        intent2.setPackage(str);
        PackageManager packageManager = context.getPackageManager();
        try {
            List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent2, 32);
            List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 32);
            if (queryBroadcastReceivers.isEmpty()) {
                if (queryIntentServices.isEmpty()) {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            return false;
        }
    }

    private static boolean a(Context context, Intent intent) {
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

    public static ha a(byte[] bArr) {
        ha haVar = new ha();
        try {
            ho.a(haVar, bArr);
            return haVar;
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.a(th);
            return null;
        }
    }

    private static boolean b(ha haVar) {
        Map<String, String> m500a = haVar.m533a().m500a();
        if (m500a != null && m500a.containsKey("notify_effect")) {
            return true;
        }
        return false;
    }

    private static boolean c(ha haVar) {
        if (haVar.m533a() != null && haVar.m533a().m500a() != null) {
            return "1".equals(haVar.m533a().m500a().get("obslete_ads_message"));
        }
        return false;
    }

    public static ha a(Context context, ha haVar) {
        return a(context, haVar, (Map<String, String>) null);
    }

    private static void b(final XMPushService xMPushService, final ha haVar) {
        xMPushService.a(new XMPushService.j(4) { // from class: com.xiaomi.push.service.u.2
            @Override // com.xiaomi.push.service.XMPushService.j
            public String a() {
                return "send ack message for message.";
            }

            @Override // com.xiaomi.push.service.XMPushService.j
            /* renamed from: a */
            public void mo383a() {
                Map<String, String> a;
                try {
                    if (com.xiaomi.push.j.m631a((Context) xMPushService)) {
                        try {
                            a = v.a((Context) xMPushService, haVar);
                        } catch (Throwable th) {
                            com.xiaomi.channel.commonutils.logger.b.d("error creating params for ack message :" + th);
                        }
                        w.a(xMPushService, u.a(xMPushService, haVar, a));
                    }
                    a = null;
                    w.a(xMPushService, u.a(xMPushService, haVar, a));
                } catch (fh e) {
                    com.xiaomi.channel.commonutils.logger.b.d("error sending ack message :" + e);
                    xMPushService.a(10, e);
                }
            }
        });
    }

    private static void c(final XMPushService xMPushService, final ha haVar) {
        xMPushService.a(new XMPushService.j(4) { // from class: com.xiaomi.push.service.u.3
            @Override // com.xiaomi.push.service.XMPushService.j
            public String a() {
                return "send ack message for obsleted message.";
            }

            @Override // com.xiaomi.push.service.XMPushService.j
            /* renamed from: a */
            public void mo383a() {
                try {
                    ha a = u.a((Context) xMPushService, haVar);
                    a.m533a().a("message_obsleted", "1");
                    w.a(xMPushService, a);
                } catch (fh e) {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                    xMPushService.a(10, e);
                }
            }
        });
    }

    private static void d(final XMPushService xMPushService, final ha haVar) {
        xMPushService.a(new XMPushService.j(4) { // from class: com.xiaomi.push.service.u.4
            @Override // com.xiaomi.push.service.XMPushService.j
            public String a() {
                return "send ack message for unrecognized new miui message.";
            }

            @Override // com.xiaomi.push.service.XMPushService.j
            /* renamed from: a */
            public void mo383a() {
                try {
                    ha a = u.a((Context) xMPushService, haVar);
                    a.m533a().a("miui_message_unrecognized", "1");
                    w.a(xMPushService, a);
                } catch (fh e) {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                    xMPushService.a(10, e);
                }
            }
        });
    }

    private static void a(final XMPushService xMPushService, final ha haVar) {
        xMPushService.a(new XMPushService.j(4) { // from class: com.xiaomi.push.service.u.1
            @Override // com.xiaomi.push.service.XMPushService.j
            public String a() {
                return "send app absent message.";
            }

            @Override // com.xiaomi.push.service.XMPushService.j
            /* renamed from: a */
            public void mo383a() {
                try {
                    w.a(xMPushService, w.a(haVar.b(), haVar.m534a()));
                } catch (fh e) {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                    xMPushService.a(10, e);
                }
            }
        });
    }

    public static Intent a(byte[] bArr, long j) {
        ha a = a(bArr);
        if (a == null) {
            return null;
        }
        Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent.putExtra("mipush_payload", bArr);
        intent.putExtra("mrt", Long.toString(j));
        intent.setPackage(a.f656b);
        return intent;
    }

    private static void b(Context context, ha haVar, byte[] bArr) {
        if (x.m761a(haVar)) {
            return;
        }
        String a = x.a(haVar);
        if (!TextUtils.isEmpty(a) && !a(context, a, bArr)) {
            ds.a(context).b(a, x.b(haVar), haVar.m533a().m499a(), "1");
        }
    }

    public static void a(Context context, ha haVar, byte[] bArr) {
        try {
            x.c m757a = x.m757a(context, haVar, bArr);
            if (m757a.a > 0 && !TextUtils.isEmpty(m757a.f1030a)) {
                fy.a(context, m757a.f1030a, m757a.a, true, false, System.currentTimeMillis());
            }
            if (com.xiaomi.push.j.m631a(context) && v.a(context, haVar, m757a.f1031a)) {
                v.m752a(context, haVar);
                com.xiaomi.channel.commonutils.logger.b.m54a("consume this broadcast by tts");
            } else {
                b(context, haVar, bArr);
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m54a("notify push msg error " + e);
            e.printStackTrace();
        }
    }

    public static ha a(Context context, ha haVar, Map<String, String> map) {
        String str;
        gu guVar = new gu();
        guVar.b(haVar.m534a());
        gr m533a = haVar.m533a();
        if (m533a != null) {
            guVar.a(m533a.m499a());
            guVar.a(m533a.m497a());
            if (!TextUtils.isEmpty(m533a.m504b())) {
                guVar.c(m533a.m504b());
            }
        }
        guVar.a(ho.a(context, haVar));
        ha a = w.a(haVar.b(), haVar.m534a(), guVar, ge.AckMessage);
        gr m533a2 = haVar.m533a();
        if (m533a2 != null) {
            m533a2 = au.a(m533a2.m498a());
            Map<String, String> m500a = m533a2.m500a();
            if (m500a != null) {
                str = m500a.get("channel_id");
            } else {
                str = null;
            }
            m533a2.a("mat", Long.toString(System.currentTimeMillis()));
            m533a2.a("cs", String.valueOf(f.a(context, haVar.f656b, str)));
        }
        if (map != null) {
            try {
                if (map.size() > 0) {
                    for (String str2 : map.keySet()) {
                        m533a2.a(str2, map.get(str2));
                    }
                }
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.d("error adding params to ack message :" + th);
            }
        }
        a.a(m533a2);
        return a;
    }

    private static void a(final XMPushService xMPushService, final ha haVar, final hd hdVar) {
        xMPushService.a(new XMPushService.j(4) { // from class: com.xiaomi.push.service.u.7
            @Override // com.xiaomi.push.service.XMPushService.j
            public String a() {
                return "send ack message for clear push message.";
            }

            @Override // com.xiaomi.push.service.XMPushService.j
            /* renamed from: a */
            public void mo383a() {
                try {
                    gv gvVar = new gv();
                    gvVar.c(go.CancelPushMessageACK.f529a);
                    gvVar.a(hdVar.m548a());
                    gvVar.a(hdVar.a());
                    gvVar.b(hdVar.b());
                    gvVar.e(hdVar.d());
                    gvVar.a(0L);
                    gvVar.d("success clear push message.");
                    w.a(xMPushService, w.b(haVar.b(), haVar.m534a(), gvVar, ge.Notification));
                } catch (fh e) {
                    com.xiaomi.channel.commonutils.logger.b.d("clear push message. " + e);
                    xMPushService.a(10, e);
                }
            }
        });
    }

    private static void a(final XMPushService xMPushService, final ha haVar, final String str) {
        xMPushService.a(new XMPushService.j(4) { // from class: com.xiaomi.push.service.u.5
            @Override // com.xiaomi.push.service.XMPushService.j
            public String a() {
                return "send app absent ack message for message.";
            }

            @Override // com.xiaomi.push.service.XMPushService.j
            /* renamed from: a */
            public void mo383a() {
                try {
                    ha a = u.a((Context) xMPushService, haVar);
                    a.m533a().a("absent_target_package", str);
                    w.a(xMPushService, a);
                } catch (fh e) {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                    xMPushService.a(10, e);
                }
            }
        });
    }

    private static void a(final XMPushService xMPushService, final ha haVar, final String str, final String str2) {
        xMPushService.a(new XMPushService.j(4) { // from class: com.xiaomi.push.service.u.6
            @Override // com.xiaomi.push.service.XMPushService.j
            public String a() {
                return "send wrong message ack for message.";
            }

            @Override // com.xiaomi.push.service.XMPushService.j
            /* renamed from: a */
            public void mo383a() {
                try {
                    ha a = u.a((Context) xMPushService, haVar);
                    a.f650a.a("error", str);
                    a.f650a.a("reason", str2);
                    w.a(xMPushService, a);
                } catch (fh e) {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                    xMPushService.a(10, e);
                }
            }
        });
    }
}
