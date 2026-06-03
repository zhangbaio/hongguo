package com.vivo.push.h;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class a extends com.vivo.push.s {
    static {
        Covode.recordClassIndex(655043);
    }

    a(com.vivo.push.v vVar) {
        super(vVar);
    }

    @Override // com.vivo.push.s
    protected final void a(com.vivo.push.v vVar) {
        com.vivo.push.b.c cVar = (com.vivo.push.b.c) vVar;
        com.vivo.push.model.a a = com.vivo.push.util.aa.a(this.a, com.vivo.push.restructure.a.a().f());
        if (a == null) {
            com.vivo.push.m.a().a(cVar.g(), 1005, new Object[0]);
            return;
        }
        String a2 = a.a();
        if (a.c()) {
            com.vivo.push.m.a().a(cVar.g(), 1004, new Object[0]);
            vVar = new com.vivo.push.b.e();
        } else {
            int a3 = com.vivo.push.util.y.a(cVar);
            if (a3 != 0) {
                com.vivo.push.m.a().a(cVar.g(), a3, new Object[0]);
                return;
            }
        }
        com.vivo.push.a.a.a(this.a, a2, vVar);
    }
}
