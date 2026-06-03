package com.vivo.push.b;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class w extends t {
    private String a;
    private long b;

    static {
        Covode.recordClassIndex(655004);
    }

    public final long h() {
        return this.b;
    }

    public final String k() {
        return this.a;
    }

    public w(int i) {
        super(i);
    }

    @Override // com.vivo.push.b.t, com.vivo.push.v
    protected void c(com.vivo.push.d dVar) {
        super.c(dVar);
        dVar.a("OnVerifyCallBackCommand.EXTRA_SECURITY_CONTENT", this.a);
        dVar.a("notify_id", this.b);
    }

    @Override // com.vivo.push.b.t, com.vivo.push.v
    protected void d(com.vivo.push.d dVar) {
        super.d(dVar);
        this.a = dVar.a("OnVerifyCallBackCommand.EXTRA_SECURITY_CONTENT");
        this.b = dVar.b("notify_id", -1L);
    }
}
