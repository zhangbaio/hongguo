package com.vivo.push.b;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class l extends t {
    private int a;
    private int b;

    static {
        Covode.recordClassIndex(654993);
    }

    public final int e() {
        return this.a;
    }

    public final int f() {
        return this.b;
    }

    public l() {
        super(2016);
        this.a = -1;
        this.b = -1;
    }

    @Override // com.vivo.push.b.t, com.vivo.push.v
    protected final void c(com.vivo.push.d dVar) {
        super.c(dVar);
        dVar.a("key_dispatch_environment", this.a);
        dVar.a("key_dispatch_area", this.b);
    }

    @Override // com.vivo.push.b.t, com.vivo.push.v
    protected final void d(com.vivo.push.d dVar) {
        super.d(dVar);
        this.a = dVar.b("key_dispatch_environment", 1);
        this.b = dVar.b("key_dispatch_area", 1);
    }
}
