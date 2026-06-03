package com.xiaomi.push;

import android.content.Context;
import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.xiaomi.push.service.XMPushService;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class em implements fc {
    private int a;

    /* renamed from: a, reason: collision with other field name */
    ez f383a;

    /* renamed from: a, reason: collision with other field name */
    XMPushService f384a;

    /* renamed from: a, reason: collision with other field name */
    private Exception f385a;
    private long e;
    private long f;

    /* renamed from: a, reason: collision with other field name */
    private long f382a = 0;
    private long b = 0;
    private long c = 0;
    private long d = 0;

    /* renamed from: a, reason: collision with other field name */
    private String f386a = "";

    static {
        Covode.recordClassIndex(655492);
    }

    Exception a() {
        return this.f385a;
    }

    private void b() {
        this.b = 0L;
        this.d = 0L;
        this.f382a = 0L;
        this.c = 0L;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (at.m155a((Context) this.f384a)) {
            this.f382a = elapsedRealtime;
        }
        if (this.f384a.m672c()) {
            this.c = elapsedRealtime;
        }
    }

    private synchronized void c() {
        com.xiaomi.channel.commonutils.logger.b.c("stat connpt = " + this.f386a + " netDuration = " + this.b + " ChannelDuration = " + this.d + " channelConnectedTime = " + this.c);
        ei eiVar = new ei();
        eiVar.f361a = (byte) 0;
        eiVar.a(eh.CHANNEL_ONLINE_RATE.a());
        eiVar.a(this.f386a);
        eiVar.d((int) (System.currentTimeMillis() / 1000));
        eiVar.b((int) (this.b / 1000));
        eiVar.c((int) (this.d / 1000));
        en.m386a().a(eiVar);
        b();
    }

    /* renamed from: a, reason: collision with other method in class */
    public synchronized void m385a() {
        XMPushService xMPushService = this.f384a;
        if (xMPushService == null) {
            return;
        }
        String m151a = at.m151a((Context) xMPushService);
        boolean b = at.b(this.f384a);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j = this.f382a;
        if (j > 0) {
            this.b += elapsedRealtime - j;
            this.f382a = 0L;
        }
        long j2 = this.c;
        if (j2 != 0) {
            this.d += elapsedRealtime - j2;
            this.c = 0L;
        }
        if (b) {
            if ((!TextUtils.equals(this.f386a, m151a) && this.b > 30000) || this.b > 5400000) {
                c();
            }
            this.f386a = m151a;
            if (this.f382a == 0) {
                this.f382a = elapsedRealtime;
            }
            if (this.f384a.m672c()) {
                this.c = elapsedRealtime;
            }
        }
    }

    @Override // com.xiaomi.push.fc
    public void a(ez ezVar) {
        this.a = 0;
        this.f385a = null;
        this.f383a = ezVar;
        this.f386a = at.m151a((Context) this.f384a);
        eo.a(0, eh.CONN_SUCCESS.a());
    }

    @Override // com.xiaomi.push.fc
    public void b(ez ezVar) {
        m385a();
        this.c = SystemClock.elapsedRealtime();
        eo.a(0, eh.CONN_SUCCESS.a(), ezVar.mo418a(), ezVar.a());
    }

    em(XMPushService xMPushService) {
        this.e = 0L;
        this.f = 0L;
        this.f384a = xMPushService;
        b();
        int myUid = Process.myUid();
        try {
            this.f = TrafficStats.getUidRxBytes(myUid);
            this.e = TrafficStats.getUidTxBytes(myUid);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m54a("Failed to obtain traffic data during initialization: " + e);
            this.f = -1L;
            this.e = -1L;
        }
    }

    @Override // com.xiaomi.push.fc
    public void a(ez ezVar, Exception exc) {
        eo.a(0, eh.CHANNEL_CON_FAIL.a(), 1, ezVar.mo418a(), at.b(this.f384a) ? 1 : 0);
        m385a();
    }

    @Override // com.xiaomi.push.fc
    public void a(ez ezVar, int i, Exception exc) {
        long j;
        long j2;
        if (this.a == 0 && this.f385a == null) {
            this.a = i;
            this.f385a = exc;
            eo.b(ezVar.mo418a(), exc);
        }
        if (i == 22 && this.c != 0) {
            long m416a = ezVar.m416a() - this.c;
            if (m416a < 0) {
                m416a = 0;
            }
            this.d += m416a + (ff.b() / 2);
            this.c = 0L;
        }
        m385a();
        int myUid = Process.myUid();
        try {
            j = TrafficStats.getUidRxBytes(myUid);
            j2 = TrafficStats.getUidTxBytes(myUid);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m54a("Failed to obtain traffic data: " + e);
            j = -1;
            j2 = -1L;
        }
        com.xiaomi.channel.commonutils.logger.b.c("Stats rx=" + (j - this.f) + ", tx=" + (j2 - this.e));
        this.f = j;
        this.e = j2;
    }
}
