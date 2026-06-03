package com.xiaomi.push.service;

import android.content.Context;
import android.os.Messenger;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.xiaomi.push.cr;
import com.xiaomi.push.eq;
import com.xiaomi.push.ez;
import com.xiaomi.push.fh;
import com.xiaomi.push.fn;
import com.xiaomi.push.ge;
import com.xiaomi.push.go;
import com.xiaomi.push.gr;
import com.xiaomi.push.gt;
import com.xiaomi.push.ha;
import com.xiaomi.push.hd;
import com.xiaomi.push.ho;
import com.xiaomi.push.hp;
import com.xiaomi.push.ht;
import com.xiaomi.push.service.am;
import com.xiaomi.push.service.ay;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class w {
    static {
        Covode.recordClassIndex(655746);
    }

    private static void a(final XMPushService xMPushService, final p pVar, int i) {
        ay.a(xMPushService).a(new ay.a("MSAID", i) { // from class: com.xiaomi.push.service.w.1
            @Override // com.xiaomi.push.service.ay.a
            void a(ay ayVar) {
                com.xiaomi.push.am a = com.xiaomi.push.am.a(xMPushService);
                String a2 = ayVar.a("MSAID", "msaid");
                String mo140a = a.mo140a();
                if (!TextUtils.isEmpty(mo140a) && !TextUtils.equals(a2, mo140a)) {
                    ayVar.a("MSAID", "msaid", mo140a);
                    hd hdVar = new hd();
                    hdVar.b(pVar.d);
                    hdVar.c(go.ClientInfoUpdate.f529a);
                    hdVar.a(aj.a());
                    hdVar.a(new HashMap());
                    a.a(hdVar.m549a());
                    byte[] a3 = ho.a(w.a(xMPushService.getPackageName(), pVar.d, hdVar, ge.Notification));
                    XMPushService xMPushService2 = xMPushService;
                    xMPushService2.a(xMPushService2.getPackageName(), a3, true);
                }
            }
        });
    }

    static void a(XMPushService xMPushService, String str, byte[] bArr) {
        cr.a(str, xMPushService.getApplicationContext(), bArr);
        ez m664a = xMPushService.m664a();
        if (m664a != null) {
            if (m664a.mo411a()) {
                eq a = a(xMPushService, bArr);
                if (a != null) {
                    m664a.b(a);
                    return;
                } else {
                    t.a(xMPushService, str, bArr, 70000003, "not a valid message");
                    return;
                }
            }
            throw new fh("Don't support XMPP connection.");
        }
        throw new fh("try send msg while connection is null.");
    }

    static void a(XMPushService xMPushService, ha haVar) {
        cr.a(haVar.b(), xMPushService.getApplicationContext(), haVar, -1);
        ez m664a = xMPushService.m664a();
        if (m664a != null) {
            if (m664a.mo411a()) {
                eq a = a(q.m745a((Context) xMPushService), xMPushService, haVar);
                if (a != null) {
                    m664a.b(a);
                    return;
                }
                return;
            }
            throw new fh("Don't support XMPP connection.");
        }
        throw new fh("try send msg while connection is null.");
    }

    private static String a(ha haVar) {
        Map<String, String> map;
        gr grVar = haVar.f650a;
        if (grVar != null && (map = grVar.f568b) != null) {
            String str = map.get("ext_traffic_source_pkg");
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return haVar.f656b;
    }

    static String a(String str) {
        return str + ".permission.MIPUSH_RECEIVE";
    }

    static void a(XMPushService xMPushService) {
        p m745a = q.m745a(xMPushService.getApplicationContext());
        if (m745a != null) {
            am.b a = q.m745a(xMPushService.getApplicationContext()).a(xMPushService);
            com.xiaomi.channel.commonutils.logger.b.m54a("prepare account. " + a.f933a);
            a(xMPushService, a);
            am.a().a(a);
            a(xMPushService, m745a, 172800);
        }
    }

    static void a(final XMPushService xMPushService, am.b bVar) {
        bVar.a((Messenger) null);
        bVar.a(new am.b.a() { // from class: com.xiaomi.push.service.w.2
            @Override // com.xiaomi.push.service.am.b.a
            public void a(am.c cVar, am.c cVar2, int i) {
                if (cVar2 == am.c.binded) {
                    t.a(XMPushService.this, true);
                    t.a(XMPushService.this);
                } else if (cVar2 == am.c.unbind) {
                    com.xiaomi.channel.commonutils.logger.b.m54a("onChange unbind");
                    t.a(XMPushService.this, 70000001, " the push is not connected.");
                }
            }
        });
    }

    static eq a(XMPushService xMPushService, byte[] bArr) {
        ha haVar = new ha();
        try {
            ho.a(haVar, bArr);
            return a(q.m745a((Context) xMPushService), xMPushService, haVar);
        } catch (ht e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            return null;
        }
    }

    static ha a(String str, String str2) {
        hd hdVar = new hd();
        hdVar.b(str2);
        hdVar.c("package uninstalled");
        hdVar.a(fn.i());
        hdVar.a(false);
        return a(str, str2, hdVar, ge.Notification);
    }

    static ha b(String str, String str2) {
        hd hdVar = new hd();
        hdVar.b(str2);
        hdVar.c(go.AppDataCleared.f529a);
        hdVar.a(aj.a());
        hdVar.a(false);
        return a(str, str2, hdVar, ge.Notification);
    }

    static eq a(p pVar, Context context, ha haVar) {
        try {
            eq eqVar = new eq();
            eqVar.a(5);
            eqVar.c(pVar.f1002a);
            eqVar.b(a(haVar));
            eqVar.a("SECMSG", "message");
            String str = pVar.f1002a;
            haVar.f651a.f578a = str.substring(0, str.indexOf("@"));
            haVar.f651a.f582c = str.substring(str.indexOf("/") + 1);
            eqVar.a(ho.a(haVar), pVar.c);
            eqVar.a((short) 1);
            com.xiaomi.channel.commonutils.logger.b.m54a("try send mi push message. packagename:" + haVar.f656b + " action:" + haVar.f649a);
            return eqVar;
        } catch (NullPointerException e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            return null;
        }
    }

    static <T extends hp<T, ?>> ha a(String str, String str2, T t, ge geVar) {
        return a(str, str2, t, geVar, true);
    }

    static <T extends hp<T, ?>> ha b(String str, String str2, T t, ge geVar) {
        return a(str, str2, t, geVar, false);
    }

    private static <T extends hp<T, ?>> ha a(String str, String str2, T t, ge geVar, boolean z) {
        byte[] a = ho.a(t);
        ha haVar = new ha();
        gt gtVar = new gt();
        gtVar.f577a = 5L;
        gtVar.f578a = "fakeid";
        haVar.a(gtVar);
        haVar.a(ByteBuffer.wrap(a));
        haVar.a(geVar);
        haVar.b(z);
        haVar.b(str);
        haVar.a(false);
        haVar.a(str2);
        return haVar;
    }
}
