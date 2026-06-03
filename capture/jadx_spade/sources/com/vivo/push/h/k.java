package com.vivo.push.h;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class k extends ab {
    static {
        Covode.recordClassIndex(655064);
    }

    k(com.vivo.push.v vVar) {
        super(vVar);
    }

    @Override // com.vivo.push.s
    protected final void a(com.vivo.push.v vVar) {
        com.vivo.push.util.t.d("OnClearCacheTask", "delete push info " + this.a.getPackageName());
        com.vivo.push.util.af.b(this.a).a();
    }
}
