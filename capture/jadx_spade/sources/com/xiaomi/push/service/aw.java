package com.xiaomi.push.service;

import com.bytedance.covode.number.Covode;
import com.xiaomi.push.eq;
import com.xiaomi.push.fh;
import com.xiaomi.push.service.XMPushService;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class aw extends XMPushService.j {
    private eq a;

    /* renamed from: a, reason: collision with other field name */
    private XMPushService f949a;

    static {
        Covode.recordClassIndex(655697);
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    public String a() {
        return "send a message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public void mo383a() {
        try {
            eq eqVar = this.a;
            if (eqVar != null) {
                if (e.a(eqVar)) {
                    this.a.c(System.currentTimeMillis() - this.a.m393a());
                }
                this.f949a.a(this.a);
            }
        } catch (fh e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            this.f949a.a(10, e);
        }
    }

    public aw(XMPushService xMPushService, eq eqVar) {
        super(4);
        this.f949a = xMPushService;
        this.a = eqVar;
    }
}
