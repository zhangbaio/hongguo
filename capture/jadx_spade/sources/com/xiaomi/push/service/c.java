package com.xiaomi.push.service;

import com.bytedance.covode.number.Covode;
import com.xiaomi.push.eq;
import com.xiaomi.push.fh;
import com.xiaomi.push.service.XMPushService;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
class c extends XMPushService.j {
    private XMPushService a;

    /* renamed from: a, reason: collision with other field name */
    private eq[] f973a;

    static {
        Covode.recordClassIndex(655708);
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    public String a() {
        return "batch send message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public void mo383a() {
        try {
            eq[] eqVarArr = this.f973a;
            if (eqVarArr != null) {
                this.a.a(eqVarArr);
            }
        } catch (fh e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            this.a.a(10, e);
        }
    }

    public c(XMPushService xMPushService, eq[] eqVarArr) {
        super(4);
        this.a = xMPushService;
        this.f973a = eqVarArr;
    }
}
