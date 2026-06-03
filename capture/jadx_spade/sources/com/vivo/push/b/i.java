package com.vivo.push.b;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class i extends t {
    private String a;
    private String b;
    private String c;
    private String d;

    static {
        Covode.recordClassIndex(654990);
    }

    @Override // com.vivo.push.b.t, com.vivo.push.v
    public final String toString() {
        return "OnBindCommand";
    }

    public final String e() {
        return this.a;
    }

    public final String f() {
        return this.c;
    }

    public i(int i) {
        super(i);
    }

    @Override // com.vivo.push.b.t, com.vivo.push.v
    protected final void c(com.vivo.push.d dVar) {
        super.c(dVar);
        dVar.a("app_id", this.a);
        dVar.a("client_id", this.b);
        dVar.a("client_token", this.c);
        dVar.a("client_token_validity_period", this.d);
    }

    @Override // com.vivo.push.b.t, com.vivo.push.v
    protected final void d(com.vivo.push.d dVar) {
        super.d(dVar);
        this.a = dVar.a("app_id");
        this.b = dVar.a("client_id");
        this.c = dVar.a("client_token");
        this.d = dVar.a("client_token_validity_period");
    }
}
