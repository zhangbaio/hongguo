package com.vivo.push.h;

import android.content.Context;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class x extends ab {
    static {
        Covode.recordClassIndex(655078);
    }

    x(com.vivo.push.v vVar) {
        super(vVar);
    }

    @Override // com.vivo.push.s
    protected final void a(com.vivo.push.v vVar) {
        Context context = this.a;
        if (com.vivo.push.util.aa.c(context, context.getPackageName())) {
            e eVar = new e(vVar);
            eVar.a(((ab) this).b);
            eVar.a(vVar);
        } else {
            d dVar = new d(vVar);
            dVar.a(((ab) this).b);
            dVar.a(vVar);
        }
    }
}
