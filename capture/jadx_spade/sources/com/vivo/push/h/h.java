package com.vivo.push.h;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class h extends ab {
    static {
        Covode.recordClassIndex(655061);
    }

    h(com.vivo.push.v vVar) {
        super(vVar);
    }

    @Override // com.vivo.push.s
    protected final void a(com.vivo.push.v vVar) {
        com.vivo.push.b.i iVar = (com.vivo.push.b.i) vVar;
        String f = iVar.f();
        com.vivo.push.util.t.d("OnBindTask", "doTask,订阅APP结果 = " + iVar.j() + " clientToken= " + f);
        com.vivo.push.m.a().a(iVar.i(), iVar.j(), f);
        com.vivo.push.t.a(new i(this, f, iVar));
    }
}
