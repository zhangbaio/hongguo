package com.vivo.push.h;

import com.bytedance.covode.number.Covode;
import com.vivo.push.model.UnvarnishedMessage;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class t extends ab {
    static {
        Covode.recordClassIndex(655073);
    }

    t(com.vivo.push.v vVar) {
        super(vVar);
    }

    @Override // com.vivo.push.s
    protected final void a(com.vivo.push.v vVar) {
        com.vivo.push.b.o oVar = (com.vivo.push.b.o) vVar;
        UnvarnishedMessage f = oVar.f();
        if (f != null && f.isTransMsgArrive()) {
            com.vivo.push.m.a().a(new com.vivo.push.b.h(String.valueOf(oVar.h())));
        }
        if (com.vivo.push.m.a().g() && !a(com.vivo.push.util.ah.c(this.a), oVar.e(), oVar.k())) {
            super.a(1021);
            return;
        }
        if (f != null) {
            if (f.isTransMsgExpired()) {
                com.vivo.push.util.t.d("OnMessageTask", "tragetType is Expired msg =" + f.getMsgId());
                ((ab) this).b.onTransmissionMessageExpired(f);
                super.a(0);
                return;
            }
            com.vivo.push.util.t.d("OnMessageTask", "tragetType is " + f.getTargetType() + " ; messageId is " + f.getMsgId());
            ((ab) this).b.onTransmissionMessage(this.a, f);
            super.a(0);
            return;
        }
        super.a(2807);
        com.vivo.push.util.t.a("OnMessageTask", " message is null");
    }
}
