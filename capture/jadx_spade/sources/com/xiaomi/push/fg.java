package com.xiaomi.push;

import android.content.Context;
import android.os.SystemClock;
import com.bytedance.covode.number.Covode;
import com.xiaomi.push.service.XMPushService;
import java.io.IOException;
import java.net.Socket;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class fg extends ez {
    protected Exception a;

    /* renamed from: a, reason: collision with other field name */
    protected Socket f446a;
    protected XMPushService b;
    private int c;

    /* renamed from: c, reason: collision with other field name */
    String f447c;
    private String d;
    protected volatile long e;
    protected volatile long f;
    protected volatile long g;
    private long h;

    static {
        Covode.recordClassIndex(655521);
    }

    /* renamed from: a */
    protected abstract void mo410a(boolean z);

    public Context a() {
        return this.b;
    }

    public String c() {
        return ((ez) this).f432a;
    }

    @Override // com.xiaomi.push.ez
    public void a(eq[] eqVarArr) {
        throw new fh("Don't support send Blob");
    }

    @Override // com.xiaomi.push.ez
    /* renamed from: a */
    public String mo418a() {
        return this.d;
    }

    public void f() {
        this.e = SystemClock.elapsedRealtime();
    }

    public void g() {
        this.f = SystemClock.elapsedRealtime();
    }

    /* renamed from: a, reason: collision with other method in class */
    public Socket m429a() {
        return new Socket();
    }

    public synchronized void e() {
        try {
            if (!m423c() && !m422b()) {
                a(0, 0, (Exception) null);
                a(((ez) this).f429a);
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.m54a("WARNING: current xmpp has connected");
        } catch (IOException e) {
            throw new fh(e);
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    protected synchronized void mo430a() {
    }

    private void a(fa faVar) {
        a(faVar.c(), faVar.m424a());
    }

    cb a(final String str) {
        cb a = cf.a().a(str, false);
        if (!a.b()) {
            fx.a(new Runnable() { // from class: com.xiaomi.push.fg.3
                @Override // java.lang.Runnable
                public void run() {
                    cf.a().a(str, true);
                }
            });
        }
        return a;
    }

    @Override // com.xiaomi.push.ez
    public void b(boolean z) {
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        final long currentTimeMillis = System.currentTimeMillis();
        mo410a(z);
        com.xiaomi.push.service.m.a(this.b).m732c();
        if (!z) {
            this.b.a(new XMPushService.j(13) { // from class: com.xiaomi.push.fg.1
                @Override // com.xiaomi.push.service.XMPushService.j
                public String a() {
                    return "check the ping-pong." + currentTimeMillis;
                }

                @Override // com.xiaomi.push.service.XMPushService.j
                /* renamed from: a */
                public void mo383a() {
                    Thread.yield();
                    if (fg.this.m423c() && !fg.this.a(elapsedRealtime)) {
                        com.xiaomi.push.service.m.a(fg.this.b).m731b();
                        fg.this.b.a(22, (Exception) null);
                    }
                }
            }, 10000L);
        }
    }

    protected void a(Exception exc) {
        if (SystemClock.elapsedRealtime() - this.g < 300000) {
            if (at.m155a((Context) this.b)) {
                int i = this.c + 1;
                this.c = i;
                if (i >= 2) {
                    String mo418a = mo418a();
                    com.xiaomi.channel.commonutils.logger.b.m54a("max short conn time reached, sink down current host:" + mo418a);
                    a(mo418a, 0L, exc);
                    this.c = 0;
                    return;
                }
                return;
            }
            return;
        }
        this.c = 0;
    }

    public void c(final int i, final Exception exc) {
        at.b();
        this.b.a(new XMPushService.j(2) { // from class: com.xiaomi.push.fg.2
            @Override // com.xiaomi.push.service.XMPushService.j
            /* renamed from: a */
            public void mo383a() {
                fg.this.b.a(i, exc);
            }

            @Override // com.xiaomi.push.service.XMPushService.j
            public String a() {
                return "shutdown the connection. " + i + ", " + exc;
            }
        });
    }

    public fg(XMPushService xMPushService, fa faVar) {
        super(xMPushService, faVar);
        this.a = null;
        this.f447c = null;
        this.e = 0L;
        this.f = 0L;
        this.g = 0L;
        this.h = 0L;
        this.b = xMPushService;
    }

    @Override // com.xiaomi.push.ez
    public void b(int i, Exception exc) {
        a(i, exc);
        if ((exc != null || i == 18) && this.g != 0) {
            a(exc);
        }
    }

    protected synchronized void a(int i, Exception exc) {
        if (b() == 2) {
            return;
        }
        a(2, i, exc);
        ((ez) this).f432a = "";
        try {
            this.f446a.close();
        } catch (Throwable unused) {
        }
        this.e = 0L;
        this.f = 0L;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0303  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x033b  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x02aa  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x02c5  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x02da  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x02ac  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a(java.lang.String r32, int r33) {
        /*
            Method dump skipped, instructions count: 838
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.fg.a(java.lang.String, int):void");
    }

    protected void a(String str, long j, Exception exc) {
        cb a = cf.a().a(fa.a(), false);
        if (a != null) {
            a.b(str, j, 0L, exc);
            cf.a().m240c();
        }
    }
}
