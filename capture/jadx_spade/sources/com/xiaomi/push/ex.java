package com.xiaomi.push;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.xiaomi.push.Cdo;
import com.xiaomi.push.ez;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.am;
import java.util.Iterator;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class ex extends fg {
    private es a;

    /* renamed from: a, reason: collision with other field name */
    private et f416a;

    /* renamed from: a, reason: collision with other field name */
    private Thread f417a;

    /* renamed from: a, reason: collision with other field name */
    private byte[] f418a;

    static {
        Covode.recordClassIndex(655509);
    }

    @Override // com.xiaomi.push.ez
    /* renamed from: a, reason: collision with other method in class */
    public boolean mo411a() {
        return true;
    }

    /* renamed from: a, reason: collision with other method in class */
    synchronized byte[] m412a() {
        if (this.f418a == null && !TextUtils.isEmpty(((ez) this).f432a)) {
            String m709a = com.xiaomi.push.service.ax.m709a();
            StringBuilder sb = new StringBuilder();
            String str = ((ez) this).f432a;
            sb.append(str.substring(str.length() / 2));
            sb.append(m709a.substring(m709a.length() / 2));
            this.f418a = com.xiaomi.push.service.ar.a(((ez) this).f432a.getBytes(), sb.toString().getBytes());
        }
        return this.f418a;
    }

    @Override // com.xiaomi.push.fg, com.xiaomi.push.ez
    public void a(eq[] eqVarArr) {
        for (eq eqVar : eqVarArr) {
            b(eqVar);
        }
    }

    @Override // com.xiaomi.push.fg
    /* renamed from: a */
    protected synchronized void mo430a() {
        h();
        this.f416a.a();
    }

    private void h() {
        try {
            this.a = new es(((fg) this).f446a.getInputStream(), this);
            this.f416a = new et(((fg) this).f446a.getOutputStream(), this);
            Thread thread = new Thread("Blob Reader (" + ((ez) this).b + ")") { // from class: com.xiaomi.push.ex.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    try {
                        ex.this.a.m406a();
                    } catch (Exception e) {
                        ex.this.c(9, e);
                    }
                }
            };
            this.f417a = thread;
            thread.start();
        } catch (Exception e) {
            throw new fh("Error to init reader and writer", e);
        }
    }

    @Override // com.xiaomi.push.ez
    public void a(fn fnVar) {
        b(eq.a(fnVar, (String) null));
    }

    void b(fn fnVar) {
        if (fnVar == null) {
            return;
        }
        Iterator<ez.a> it2 = ((ez) this).f435a.values().iterator();
        while (it2.hasNext()) {
            it2.next().a(fnVar);
        }
    }

    private eq a(boolean z) {
        ew ewVar = new ew();
        if (z) {
            ewVar.a("1");
        }
        byte[] m392a = eo.m392a();
        if (m392a != null) {
            Cdo.j jVar = new Cdo.j();
            jVar.a(a.a(m392a));
            ewVar.a(jVar.m378a(), (String) null);
        }
        return ewVar;
    }

    @Override // com.xiaomi.push.ez
    public void b(eq eqVar) {
        et etVar = this.f416a;
        if (etVar != null) {
            try {
                int a = etVar.a(eqVar);
                ((ez) this).d = SystemClock.elapsedRealtime();
                String f = eqVar.f();
                if (!TextUtils.isEmpty(f)) {
                    fy.a(((ez) this).f431a, f, a, false, true, System.currentTimeMillis());
                }
                Iterator<ez.a> it2 = ((ez) this).f438b.values().iterator();
                while (it2.hasNext()) {
                    it2.next().a(eqVar);
                }
                return;
            } catch (Exception e) {
                throw new fh(e);
            }
        }
        throw new fh("the writer is null.");
    }

    void a(eq eqVar) {
        if (eqVar == null) {
            return;
        }
        if (com.xiaomi.push.service.e.a(eqVar)) {
            eq eqVar2 = new eq();
            eqVar2.a(eqVar.a());
            eqVar2.a("SYNC", "ACK_RTT");
            eqVar2.a(eqVar.e());
            eqVar2.b(eqVar.m400b());
            eqVar2.a(eqVar.m403c());
            ((ez) this).f431a.a(new com.xiaomi.push.service.aw(((ez) this).f431a, eqVar2));
        }
        if (eqVar.m397a()) {
            com.xiaomi.channel.commonutils.logger.b.m54a("[Slim] RCV blob chid=" + eqVar.a() + "; id=" + eqVar.e() + "; errCode=" + eqVar.b() + "; err=" + eqVar.m404c());
        }
        if (eqVar.a() == 0) {
            if ("PING".equals(eqVar.m394a())) {
                com.xiaomi.channel.commonutils.logger.b.m54a("[Slim] RCV ping id=" + eqVar.e());
                g();
            } else if ("CLOSE".equals(eqVar.m394a())) {
                c(13, null);
            }
        }
        Iterator<ez.a> it2 = ((ez) this).f435a.values().iterator();
        while (it2.hasNext()) {
            it2.next().a(eqVar);
        }
    }

    @Override // com.xiaomi.push.ez
    public synchronized void a(am.b bVar) {
        ep.a(bVar, c(), this);
    }

    @Override // com.xiaomi.push.fg
    /* renamed from: a, reason: collision with other method in class */
    protected void mo410a(boolean z) {
        if (this.f416a != null) {
            eq a = a(z);
            com.xiaomi.channel.commonutils.logger.b.m54a("[Slim] SND ping id=" + a.e());
            b(a);
            f();
            return;
        }
        throw new fh("The BlobWriter is null.");
    }

    public ex(XMPushService xMPushService, fa faVar) {
        super(xMPushService, faVar);
    }

    @Override // com.xiaomi.push.fg
    protected synchronized void a(int i, Exception exc) {
        es esVar = this.a;
        if (esVar != null) {
            esVar.b();
            this.a = null;
        }
        et etVar = this.f416a;
        if (etVar != null) {
            try {
                etVar.b();
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.d("SlimConnection shutdown cause exception: " + e);
            }
            this.f416a = null;
        }
        this.f418a = null;
        super.a(i, exc);
    }

    @Override // com.xiaomi.push.ez
    public synchronized void a(String str, String str2) {
        ep.a(str, str2, this);
    }
}
