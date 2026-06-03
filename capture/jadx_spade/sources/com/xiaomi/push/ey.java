package com.xiaomi.push;

import com.bytedance.covode.number.Covode;
import com.xiaomi.push.Cdo;
import com.xiaomi.push.ez;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class ey implements fi {
    public static boolean a;

    /* renamed from: a, reason: collision with other field name */
    private ez f420a;

    /* renamed from: a, reason: collision with other field name */
    private SimpleDateFormat f423a = new SimpleDateFormat("hh:mm:ss aaa");

    /* renamed from: a, reason: collision with other field name */
    private a f419a = null;
    private a b = null;

    /* renamed from: a, reason: collision with other field name */
    private fc f421a = null;

    /* renamed from: a, reason: collision with other field name */
    private final String f422a = "[Slim] ";

    static {
        Covode.recordClassIndex(655510);
        a = false;
    }

    private void a() {
        this.f419a = new a(true);
        this.b = new a(false);
        ez ezVar = this.f420a;
        a aVar = this.f419a;
        ezVar.a(aVar, aVar);
        ez ezVar2 = this.f420a;
        a aVar2 = this.b;
        ezVar2.b(aVar2, aVar2);
        this.f421a = new fc() { // from class: com.xiaomi.push.ey.1
            @Override // com.xiaomi.push.fc
            public void a(ez ezVar3) {
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + ey.this.f423a.format(new Date()) + " Connection started (" + ey.this.f420a.hashCode() + ")");
            }

            @Override // com.xiaomi.push.fc
            public void b(ez ezVar3) {
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + ey.this.f423a.format(new Date()) + " Connection reconnected (" + ey.this.f420a.hashCode() + ")");
            }

            @Override // com.xiaomi.push.fc
            public void a(ez ezVar3, Exception exc) {
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + ey.this.f423a.format(new Date()) + " Reconnection failed due to an exception (" + ey.this.f420a.hashCode() + ")");
                exc.printStackTrace();
            }

            @Override // com.xiaomi.push.fc
            public void a(ez ezVar3, int i, Exception exc) {
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + ey.this.f423a.format(new Date()) + " Connection closed (" + ey.this.f420a.hashCode() + ")");
            }
        };
    }

    public ey(ez ezVar) {
        this.f420a = ezVar;
        a();
    }

    class a implements fe, fj {

        /* renamed from: a, reason: collision with other field name */
        String f424a;

        /* renamed from: a, reason: collision with other field name */
        private boolean f425a;

        static {
            Covode.recordClassIndex(655511);
        }

        @Override // com.xiaomi.push.fj
        /* renamed from: a */
        public boolean mo244a(fn fnVar) {
            return true;
        }

        @Override // com.xiaomi.push.fe
        public void a(fn fnVar) {
            if (ey.a) {
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + ey.this.f423a.format(new Date()) + this.f424a + " PKT " + fnVar.mo435a());
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + ey.this.f423a.format(new Date()) + this.f424a + " PKT [" + fnVar.k() + "," + fnVar.j() + "]");
        }

        @Override // com.xiaomi.push.fe
        public void a(eq eqVar) {
            if (ey.a) {
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + ey.this.f423a.format(new Date()) + this.f424a + eqVar.toString());
            } else {
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + ey.this.f423a.format(new Date()) + this.f424a + " Blob [" + eqVar.m394a() + "," + eqVar.a() + "," + com.xiaomi.push.service.aj.a(eqVar.e()) + "]");
            }
            if (eqVar != null && eqVar.a() == 99999) {
                String m394a = eqVar.m394a();
                eq eqVar2 = null;
                if (!this.f425a) {
                    if ("BIND".equals(m394a)) {
                        com.xiaomi.channel.commonutils.logger.b.m54a("build binded result for loopback.");
                        Cdo.d dVar = new Cdo.d();
                        dVar.a(true);
                        dVar.c("login success.");
                        dVar.b("success");
                        dVar.a("success");
                        eq eqVar3 = new eq();
                        eqVar3.a(dVar.m378a(), (String) null);
                        eqVar3.a((short) 2);
                        eqVar3.a(99999);
                        eqVar3.a("BIND", (String) null);
                        eqVar3.a(eqVar.e());
                        eqVar3.b((String) null);
                        eqVar3.c(eqVar.g());
                        eqVar2 = eqVar3;
                    } else if (!"UBND".equals(m394a) && "SECMSG".equals(m394a)) {
                        eq eqVar4 = new eq();
                        eqVar4.a(99999);
                        eqVar4.a("SECMSG", (String) null);
                        eqVar4.c(eqVar.g());
                        eqVar4.a(eqVar.e());
                        eqVar4.a(eqVar.m396a());
                        eqVar4.b(eqVar.f());
                        eqVar4.a(eqVar.m399a(com.xiaomi.push.service.am.a().a(String.valueOf(99999), eqVar.g()).h), (String) null);
                        eqVar2 = eqVar4;
                    }
                }
                if (eqVar2 != null) {
                    for (Map.Entry<fe, ez.a> entry : ey.this.f420a.m419a().entrySet()) {
                        if (ey.this.f419a != entry.getKey()) {
                            entry.getValue().a(eqVar2);
                        }
                    }
                }
            }
        }

        a(boolean z) {
            String str;
            this.f425a = z;
            if (z) {
                str = " RCV ";
            } else {
                str = " Sent ";
            }
            this.f424a = str;
        }
    }
}
