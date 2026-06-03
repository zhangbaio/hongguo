package com.vivo.push.b;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class n extends t {
    private String a;
    private int b;
    private boolean c;

    static {
        Covode.recordClassIndex(654995);
    }

    public final void h() {
        this.c = false;
    }

    @Override // com.vivo.push.b.t, com.vivo.push.v
    public final String toString() {
        return "OnLogCommand";
    }

    public final String e() {
        return this.a;
    }

    public final int f() {
        return this.b;
    }

    public final boolean g() {
        return this.c;
    }

    public n() {
        super(7);
        this.b = 0;
        this.c = false;
    }

    public final void a(int i) {
        this.b = i;
    }

    public final void b(String str) {
        this.a = str;
    }

    @Override // com.vivo.push.b.t, com.vivo.push.v
    protected final void c(com.vivo.push.d dVar) {
        super.c(dVar);
        dVar.a("content", this.a);
        dVar.a("log_level", this.b);
        dVar.a("is_server_log", this.c);
    }

    @Override // com.vivo.push.b.t, com.vivo.push.v
    protected final void d(com.vivo.push.d dVar) {
        super.d(dVar);
        this.a = dVar.a("content");
        this.b = dVar.b("log_level", 0);
        this.c = dVar.e("is_server_log");
    }
}
