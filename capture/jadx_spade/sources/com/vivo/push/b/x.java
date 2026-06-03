package com.vivo.push.b;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class x extends com.vivo.push.v {
    private int a;

    static {
        Covode.recordClassIndex(655005);
    }

    @Override // com.vivo.push.v
    public final boolean d() {
        return true;
    }

    @Override // com.vivo.push.v
    public final String toString() {
        return "PushModeCommand";
    }

    public final int e() {
        return this.a;
    }

    public x() {
        super(2011);
        this.a = 0;
    }

    @Override // com.vivo.push.v
    protected final void c(com.vivo.push.d dVar) {
        dVar.a("com.bbk.push.ikey.MODE_TYPE", this.a);
    }

    @Override // com.vivo.push.v
    protected final void d(com.vivo.push.d dVar) {
        this.a = dVar.b("com.bbk.push.ikey.MODE_TYPE", 0);
    }
}
