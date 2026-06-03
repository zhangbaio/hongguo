package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.xiaomi.push.eq;
import com.xiaomi.push.fl;
import com.xiaomi.push.fm;
import com.xiaomi.push.fn;
import com.xiaomi.push.fp;
import com.xiaomi.push.service.am;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class h {
    private u a = new u();

    static {
        Covode.recordClassIndex(655716);
    }

    public void a(Context context, am.b bVar, boolean z, int i, String str) {
        if ("5".equalsIgnoreCase(bVar.g)) {
            this.a.a(context, bVar, z, i, str);
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.xiaomi.push.channel_opened");
        intent.setPackage(bVar.f933a);
        intent.putExtra("ext_succeeded", z);
        if (!z) {
            intent.putExtra("ext_reason", i);
        }
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra("ext_reason_msg", str);
        }
        intent.putExtra("ext_chid", bVar.g);
        intent.putExtra(an.s, bVar.f936b);
        intent.putExtra(an.J, bVar.i);
        com.xiaomi.channel.commonutils.logger.b.m54a(String.format("[Bcst] notify channel open result. %s,%s,%b,%d", bVar.g, bVar.f933a, Boolean.valueOf(z), Integer.valueOf(i)));
        a(context, intent, bVar);
    }

    public void a(XMPushService xMPushService, String str, fn fnVar) {
        String str2;
        am.b a = a(fnVar);
        if (a == null) {
            com.xiaomi.channel.commonutils.logger.b.d("error while notify channel closed! channel " + str + " not registered");
            return;
        }
        if ("5".equalsIgnoreCase(str)) {
            this.a.a(xMPushService, fnVar, a);
            return;
        }
        String str3 = a.f933a;
        if (fnVar instanceof fm) {
            str2 = "com.xiaomi.push.new_msg";
        } else if (fnVar instanceof fl) {
            str2 = "com.xiaomi.push.new_iq";
        } else {
            if (!(fnVar instanceof fp)) {
                com.xiaomi.channel.commonutils.logger.b.d("unknown packet type, drop it");
                return;
            }
            str2 = "com.xiaomi.push.new_pres";
        }
        Intent intent = new Intent();
        intent.setAction(str2);
        intent.setPackage(str3);
        intent.putExtra("ext_chid", str);
        intent.putExtra("ext_packet", fnVar.a());
        intent.putExtra(an.J, a.i);
        intent.putExtra(an.B, a.h);
        com.xiaomi.channel.commonutils.logger.b.m54a(String.format("[Bcst] notify packet arrival. %s,%s,%s", a.g, a.f933a, fnVar.j()));
        if ("3".equalsIgnoreCase(str)) {
            intent.putExtra(an.w, fnVar.f461a);
            intent.putExtra(an.x, System.currentTimeMillis());
        }
        a(xMPushService, intent, a);
    }

    public void a(XMPushService xMPushService, String str, eq eqVar) {
        am.b a = a(eqVar);
        if (a == null) {
            com.xiaomi.channel.commonutils.logger.b.d("error while notify channel closed! channel " + str + " not registered");
            return;
        }
        if ("5".equalsIgnoreCase(str)) {
            this.a.a(xMPushService, eqVar, a);
            return;
        }
        String str2 = a.f933a;
        Intent intent = new Intent();
        intent.setAction("com.xiaomi.push.new_msg");
        intent.setPackage(str2);
        intent.putExtra("ext_rcv_timestamp", SystemClock.elapsedRealtime());
        intent.putExtra("ext_chid", str);
        intent.putExtra("ext_raw_packet", eqVar.m399a(a.h));
        intent.putExtra(an.J, a.i);
        intent.putExtra(an.B, a.h);
        if (e.a(eqVar)) {
            intent.putExtra("ext_downward_pkt_id", eqVar.e());
        }
        if (a.f927a != null) {
            try {
                a.f927a.send(Message.obtain(null, 17, intent));
                com.xiaomi.channel.commonutils.logger.b.m54a("message was sent by messenger for chid=" + str);
                return;
            } catch (RemoteException unused) {
                a.f927a = null;
                StringBuilder sb = new StringBuilder();
                sb.append("peer may died: ");
                String str3 = a.f936b;
                sb.append(str3.substring(str3.lastIndexOf(64)));
                com.xiaomi.channel.commonutils.logger.b.m54a(sb.toString());
            }
        }
        if ("com.xiaomi.xmsf".equals(str2)) {
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.m54a(String.format("[Bcst] notify packet(blob) arrival. %s,%s,%s", a.g, a.f933a, eqVar.e()));
        if (e.a(eqVar)) {
            at.a().a(eqVar.e(), SystemClock.elapsedRealtime());
        }
        a(xMPushService, intent, a);
    }

    public static String a(am.b bVar) {
        if (!"9".equals(bVar.g)) {
            return bVar.f933a + ".permission.MIPUSH_RECEIVE";
        }
        return bVar.f933a + ".permission.MIMC_RECEIVE";
    }

    am.b a(eq eqVar) {
        Collection<am.b> m697a = am.a().m697a(Integer.toString(eqVar.a()));
        if (m697a.isEmpty()) {
            return null;
        }
        Iterator<am.b> it2 = m697a.iterator();
        if (m697a.size() == 1) {
            return it2.next();
        }
        String g = eqVar.g();
        while (it2.hasNext()) {
            am.b next = it2.next();
            if (TextUtils.equals(g, next.f936b)) {
                return next;
            }
        }
        return null;
    }

    am.b a(fn fnVar) {
        Collection<am.b> m697a = am.a().m697a(fnVar.k());
        if (m697a.isEmpty()) {
            return null;
        }
        Iterator<am.b> it2 = m697a.iterator();
        if (m697a.size() == 1) {
            return it2.next();
        }
        String m = fnVar.m();
        String l = fnVar.l();
        while (it2.hasNext()) {
            am.b next = it2.next();
            if (TextUtils.equals(m, next.f936b) || TextUtils.equals(l, next.f936b)) {
                return next;
            }
        }
        return null;
    }

    public void a(Context context) {
        if ("com.xiaomi.xmsf".equals(context.getPackageName())) {
            Intent intent = new Intent();
            intent.setAction("com.xiaomi.push.service_started");
            if (com.xiaomi.push.j.m635c()) {
                intent.addFlags(16777216);
            }
            com.xiaomi.channel.commonutils.logger.b.m54a("[Bcst] send ***.push.service_started broadcast to inform push service has started.");
            intent.setPackage("com.android.mms");
            context.sendBroadcast(intent);
        }
    }

    private static void a(Context context, Intent intent, am.b bVar) {
        if ("com.xiaomi.xmsf".equals(context.getPackageName())) {
            context.sendBroadcast(intent);
        } else {
            context.sendBroadcast(intent, a(bVar));
        }
    }

    public void a(Context context, am.b bVar, int i) {
        if (!"5".equalsIgnoreCase(bVar.g)) {
            Intent intent = new Intent();
            intent.setAction("com.xiaomi.push.channel_closed");
            intent.setPackage(bVar.f933a);
            intent.putExtra(an.v, bVar.g);
            intent.putExtra("ext_reason", i);
            intent.putExtra(an.s, bVar.f936b);
            intent.putExtra(an.J, bVar.i);
            if (bVar.f927a != null && "9".equals(bVar.g)) {
                try {
                    bVar.f927a.send(Message.obtain(null, 17, intent));
                    return;
                } catch (RemoteException unused) {
                    bVar.f927a = null;
                    StringBuilder sb = new StringBuilder();
                    sb.append("peer may died: ");
                    String str = bVar.f936b;
                    sb.append(str.substring(str.lastIndexOf(64)));
                    com.xiaomi.channel.commonutils.logger.b.m54a(sb.toString());
                    return;
                }
            }
            com.xiaomi.channel.commonutils.logger.b.m54a(String.format("[Bcst] notify channel closed. %s,%s,%d", bVar.g, bVar.f933a, Integer.valueOf(i)));
            a(context, intent, bVar);
        }
    }

    public void a(Context context, am.b bVar, String str, String str2) {
        if (bVar == null) {
            com.xiaomi.channel.commonutils.logger.b.d("error while notify kick by server!");
            return;
        }
        if ("5".equalsIgnoreCase(bVar.g)) {
            com.xiaomi.channel.commonutils.logger.b.d("mipush kicked by server");
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.xiaomi.push.kicked");
        intent.setPackage(bVar.f933a);
        intent.putExtra("ext_kick_type", str);
        intent.putExtra("ext_kick_reason", str2);
        intent.putExtra("ext_chid", bVar.g);
        intent.putExtra(an.s, bVar.f936b);
        intent.putExtra(an.J, bVar.i);
        com.xiaomi.channel.commonutils.logger.b.m54a(String.format("[Bcst] notify packet(blob) arrival. %s,%s,%s", bVar.g, bVar.f933a, str2));
        a(context, intent, bVar);
    }
}
