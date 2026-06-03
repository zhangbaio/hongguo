package com.xiaomi.push.service;

import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.xiaomi.push.Cdo;
import com.xiaomi.push.cb;
import com.xiaomi.push.cf;
import com.xiaomi.push.da;
import com.xiaomi.push.eh;
import com.xiaomi.push.eo;
import com.xiaomi.push.eq;
import com.xiaomi.push.fa;
import com.xiaomi.push.fk;
import com.xiaomi.push.fl;
import com.xiaomi.push.fm;
import com.xiaomi.push.fn;
import com.xiaomi.push.fy;
import com.xiaomi.push.service.am;
import java.util.Date;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class ak {
    private XMPushService a;

    static {
        Covode.recordClassIndex(655673);
    }

    ak(XMPushService xMPushService) {
        this.a = xMPushService;
    }

    private void a(fk fkVar) {
        String c = fkVar.c();
        if (!TextUtils.isEmpty(c)) {
            String[] split = c.split(";");
            cb a = cf.a().a(fa.a(), false);
            if (a != null && split.length > 0) {
                a.a(split);
                this.a.a(20, (Exception) null);
                this.a.a(true);
            }
        }
    }

    private void b(fn fnVar) {
        am.b a;
        String l = fnVar.l();
        String k = fnVar.k();
        if (!TextUtils.isEmpty(l) && !TextUtils.isEmpty(k) && (a = am.a().a(k, l)) != null) {
            fy.a(this.a, a.f933a, fy.a(fnVar.mo435a()), true, true, System.currentTimeMillis());
        }
    }

    private void c(eq eqVar) {
        am.b a;
        String g = eqVar.g();
        String num = Integer.toString(eqVar.a());
        if (!TextUtils.isEmpty(g) && !TextUtils.isEmpty(num) && (a = am.a().a(num, g)) != null) {
            fy.a(this.a, a.f933a, eqVar.c(), true, true, System.currentTimeMillis());
        }
    }

    public void a(eq eqVar) {
        if (5 != eqVar.a()) {
            c(eqVar);
        }
        try {
            b(eqVar);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a("handle Blob chid = " + eqVar.a() + " cmd = " + eqVar.m394a() + " packetid = " + eqVar.e() + " failure ", e);
        }
    }

    public void a(fn fnVar) {
        if (!"5".equals(fnVar.k())) {
            b(fnVar);
        }
        String k = fnVar.k();
        if (TextUtils.isEmpty(k)) {
            k = "1";
            fnVar.l("1");
        }
        if (k.equals("0")) {
            com.xiaomi.channel.commonutils.logger.b.m54a("Received wrong packet with chid = 0 : " + fnVar.mo435a());
        }
        if (fnVar instanceof fl) {
            fk a = fnVar.a("kick");
            if (a != null) {
                String l = fnVar.l();
                String a2 = a.a("type");
                String a3 = a.a("reason");
                com.xiaomi.channel.commonutils.logger.b.m54a("kicked by server, chid=" + k + " res=" + am.b.a(l) + " type=" + a2 + " reason=" + a3);
                if ("wait".equals(a2)) {
                    am.b a4 = am.a().a(k, l);
                    if (a4 != null) {
                        this.a.a(a4);
                        a4.a(am.c.unbind, 3, 0, a3, a2);
                        return;
                    }
                    return;
                }
                this.a.a(k, l, 3, a3, a2);
                am.a().m701a(k, l);
                return;
            }
        } else if (fnVar instanceof fm) {
            fm fmVar = (fm) fnVar;
            if ("redir".equals(fmVar.b())) {
                fk a5 = fmVar.a("hosts");
                if (a5 != null) {
                    a(a5);
                    return;
                }
                return;
            }
        }
        this.a.m669b().a(this.a, k, fnVar);
    }

    public void b(eq eqVar) {
        String m394a = eqVar.m394a();
        if (eqVar.a() != 0) {
            String num = Integer.toString(eqVar.a());
            if ("SECMSG".equals(eqVar.m394a())) {
                if (!eqVar.m397a()) {
                    this.a.m669b().a(this.a, num, eqVar);
                    return;
                }
                com.xiaomi.channel.commonutils.logger.b.m54a("Recv SECMSG errCode = " + eqVar.b() + " errStr = " + eqVar.m404c());
                return;
            }
            if ("BIND".equals(m394a)) {
                Cdo.d a = Cdo.d.a(eqVar.m398a());
                String g = eqVar.g();
                am.b a2 = am.a().a(num, g);
                if (a2 == null) {
                    return;
                }
                if (a.m315a()) {
                    com.xiaomi.channel.commonutils.logger.b.m54a("SMACK: channel bind succeeded, chid=" + eqVar.a());
                    a2.a(am.c.binded, 1, 0, (String) null, (String) null);
                    return;
                }
                String m314a = a.m314a();
                if ("auth".equals(m314a)) {
                    if ("invalid-sig".equals(a.m316b())) {
                        com.xiaomi.channel.commonutils.logger.b.m54a("SMACK: bind error invalid-sig token = " + a2.c + " sec = " + a2.h);
                        eo.a(0, eh.BIND_INVALID_SIG.a(), 1, null, 0);
                    }
                    a2.a(am.c.unbind, 1, 5, a.m316b(), m314a);
                    am.a().m701a(num, g);
                } else if ("cancel".equals(m314a)) {
                    a2.a(am.c.unbind, 1, 7, a.m316b(), m314a);
                    am.a().m701a(num, g);
                } else if ("wait".equals(m314a)) {
                    this.a.a(a2);
                    a2.a(am.c.unbind, 1, 7, a.m316b(), m314a);
                }
                com.xiaomi.channel.commonutils.logger.b.m54a("SMACK: channel bind failed, chid=" + num + " reason=" + a.m316b());
                return;
            }
            if ("KICK".equals(m394a)) {
                Cdo.g a3 = Cdo.g.a(eqVar.m398a());
                String g2 = eqVar.g();
                String m339a = a3.m339a();
                String m341b = a3.m341b();
                com.xiaomi.channel.commonutils.logger.b.m54a("kicked by server, chid=" + num + " res= " + am.b.a(g2) + " type=" + m339a + " reason=" + m341b);
                if ("wait".equals(m339a)) {
                    am.b a4 = am.a().a(num, g2);
                    if (a4 != null) {
                        this.a.a(a4);
                        a4.a(am.c.unbind, 3, 0, m341b, m339a);
                        return;
                    }
                    return;
                }
                this.a.a(num, g2, 3, m341b, m339a);
                am.a().m701a(num, g2);
                return;
            }
            return;
        }
        if ("PING".equals(m394a)) {
            byte[] m398a = eqVar.m398a();
            if (m398a != null && m398a.length > 0) {
                Cdo.j a5 = Cdo.j.a(m398a);
                if (a5.m352b()) {
                    ax.a().a(a5.m350a());
                }
            }
            if (!"com.xiaomi.xmsf".equals(this.a.getPackageName())) {
                this.a.m666a();
            }
            if ("1".equals(eqVar.e())) {
                com.xiaomi.channel.commonutils.logger.b.m54a("received a server ping");
            } else {
                eo.b();
            }
            this.a.m670b();
            return;
        }
        if ("SYNC".equals(m394a)) {
            if ("CONF".equals(eqVar.m401b())) {
                ax.a().a(Cdo.b.a(eqVar.m398a()));
                return;
            }
            if (TextUtils.equals("U", eqVar.m401b())) {
                Cdo.k a6 = Cdo.k.a(eqVar.m398a());
                da.a(this.a).a(a6.m354a(), a6.m357b(), new Date(a6.m353a()), new Date(a6.m356b()), a6.c() * 1024, a6.e());
                eq eqVar2 = new eq();
                eqVar2.a(0);
                eqVar2.a(eqVar.m394a(), "UCA");
                eqVar2.a(eqVar.e());
                this.a.a(new aw(this.a, eqVar2));
                return;
            }
            if (TextUtils.equals("P", eqVar.m401b())) {
                Cdo.i a7 = Cdo.i.a(eqVar.m398a());
                eq eqVar3 = new eq();
                eqVar3.a(0);
                eqVar3.a(eqVar.m394a(), "PCA");
                eqVar3.a(eqVar.e());
                Cdo.i iVar = new Cdo.i();
                if (a7.m348a()) {
                    iVar.a(a7.m347a());
                }
                eqVar3.a(iVar.m378a(), (String) null);
                this.a.a(new aw(this.a, eqVar3));
                com.xiaomi.channel.commonutils.logger.b.m54a("ACK msgP: id = " + eqVar.e());
                return;
            }
            return;
        }
        if ("NOTIFY".equals(eqVar.m394a())) {
            Cdo.h a8 = Cdo.h.a(eqVar.m398a());
            com.xiaomi.channel.commonutils.logger.b.m54a("notify by server err = " + a8.c() + " desc = " + a8.m344a());
        }
    }
}
