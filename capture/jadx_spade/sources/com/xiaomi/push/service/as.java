package com.xiaomi.push.service;

import com.bytedance.covode.number.Covode;
import com.xiaomi.push.en;
import com.xiaomi.push.service.XMPushService.e;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
class as {
    private static int d;

    /* renamed from: a, reason: collision with other field name */
    private XMPushService f947a;
    private int b = 0;
    private int c = 0;
    private int a = 500;

    /* renamed from: a, reason: collision with other field name */
    private long f946a = 0;

    static {
        Covode.recordClassIndex(655690);
        d = 300000;
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m707a() {
        this.f946a = System.currentTimeMillis();
        this.f947a.a(1);
        this.b = 0;
    }

    private int a() {
        double d2;
        if (this.b > 8) {
            return 300000;
        }
        double random = (Math.random() * 2.0d) + 1.0d;
        int i = this.b;
        if (i > 4) {
            d2 = 60000.0d;
        } else if (i > 1) {
            d2 = 10000.0d;
        } else {
            if (this.f946a == 0) {
                return 0;
            }
            if (System.currentTimeMillis() - this.f946a < 310000) {
                int i2 = this.a;
                int i3 = d;
                if (i2 >= i3) {
                    return i2;
                }
                int i4 = this.c + 1;
                this.c = i4;
                if (i4 >= 4) {
                    return i3;
                }
                this.a = (int) (i2 * 1.5d);
                return i2;
            }
            this.a = 1000;
            this.c = 0;
            return 0;
        }
        return (int) (random * d2);
    }

    public as(XMPushService xMPushService) {
        this.f947a = xMPushService;
    }

    public void a(boolean z) {
        if (this.f947a.m667a()) {
            if (z) {
                if (!this.f947a.m668a(1)) {
                    this.b++;
                }
                this.f947a.a(1);
                com.xiaomi.channel.commonutils.logger.b.m55a("ReconnectionManager", "-->tryReconnect(): exec ConnectJob");
                XMPushService xMPushService = this.f947a;
                XMPushService xMPushService2 = this.f947a;
                xMPushService2.getClass();
                xMPushService.a(xMPushService2.new e());
                return;
            }
            if (this.f947a.m668a(1)) {
                return;
            }
            int a = a();
            this.b++;
            com.xiaomi.channel.commonutils.logger.b.m54a("schedule reconnect in " + a + "ms");
            XMPushService xMPushService3 = this.f947a;
            XMPushService xMPushService4 = this.f947a;
            xMPushService4.getClass();
            xMPushService3.a(xMPushService4.new e(), (long) a);
            if (this.b == 2 && en.m386a().m391a()) {
                z.b();
            }
            if (this.b == 3) {
                z.a();
                return;
            }
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.c("should not reconnect as no client or network.");
    }
}
