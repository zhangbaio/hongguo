package com.vivo.push.h;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class af extends ab {
    static {
        Covode.recordClassIndex(655049);
    }

    af(com.vivo.push.v vVar) {
        super(vVar);
    }

    @Override // com.vivo.push.s
    protected final void a(com.vivo.push.v vVar) {
        com.vivo.push.b.i iVar = (com.vivo.push.b.i) vVar;
        com.vivo.push.util.t.c("OnUnBindTask", "doTask,解订阅APP结果 = " + iVar.j() + " clientToken= " + iVar.f());
        com.vivo.push.m.a().a(iVar.i(), iVar.j(), new Object[0]);
        com.vivo.push.t.a(new ag(this, iVar));
    }
}
