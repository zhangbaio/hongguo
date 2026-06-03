package com.xiaomi.push.service;

import android.content.Context;
import com.bytedance.covode.number.Covode;
import com.xiaomi.push.fh;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.XMPushService.b;
import com.xiaomi.push.service.am;
import java.util.Collection;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class s extends XMPushService.j {
    private XMPushService a;

    /* renamed from: a, reason: collision with other field name */
    private String f1007a;

    /* renamed from: a, reason: collision with other field name */
    private byte[] f1008a;
    private String b;
    private String c;

    static {
        Covode.recordClassIndex(655740);
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    public String a() {
        return "register app";
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public void mo383a() {
        am.b next;
        p m745a = q.m745a((Context) this.a);
        if (m745a == null) {
            try {
                m745a = q.a(this.a, this.f1007a, this.b, this.c);
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.d("fail to register push account. " + e);
            }
        }
        if (m745a == null) {
            com.xiaomi.channel.commonutils.logger.b.d("no account for registration.");
            t.a(this.a, 70000002, "no account.");
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.m54a("do registration now.");
        Collection<am.b> m697a = am.a().m697a("5");
        if (m697a.isEmpty()) {
            next = m745a.a(this.a);
            w.a(this.a, next);
            am.a().a(next);
        } else {
            next = m697a.iterator().next();
        }
        if (this.a.m672c()) {
            try {
                am.c cVar = next.f931a;
                if (cVar == am.c.binded) {
                    w.a(this.a, this.f1007a, this.f1008a);
                } else if (cVar == am.c.unbind) {
                    t.a(this.f1007a, this.f1008a);
                    XMPushService xMPushService = this.a;
                    XMPushService xMPushService2 = this.a;
                    xMPushService2.getClass();
                    xMPushService.a(xMPushService2.new b(next));
                }
                return;
            } catch (fh e2) {
                com.xiaomi.channel.commonutils.logger.b.d("meet error, disconnect connection. " + e2);
                this.a.a(10, e2);
                return;
            }
        }
        t.a(this.f1007a, this.f1008a);
        this.a.a(true);
    }

    public s(XMPushService xMPushService, String str, String str2, String str3, byte[] bArr) {
        super(9);
        this.a = xMPushService;
        this.f1007a = str;
        this.f1008a = bArr;
        this.b = str2;
        this.c = str3;
    }
}
