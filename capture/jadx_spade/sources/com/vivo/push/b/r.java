package com.vivo.push.b;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class r extends t {
    private static String a;
    private int b;

    public final int e() {
        return this.b;
    }

    public r() {
        super(2023);
    }

    static {
        Covode.recordClassIndex(654999);
        a = "notify_guide_dialog_result";
    }

    @Override // com.vivo.push.b.t, com.vivo.push.v
    protected final void c(com.vivo.push.d dVar) {
        super.c(dVar);
        dVar.a(a, this.b);
    }

    @Override // com.vivo.push.b.t, com.vivo.push.v
    protected final void d(com.vivo.push.d dVar) {
        super.d(dVar);
        this.b = dVar.b(a, -1);
    }
}
