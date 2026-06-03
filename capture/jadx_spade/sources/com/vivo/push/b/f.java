package com.vivo.push.b;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class f extends com.vivo.push.v {
    private int a;

    static {
        Covode.recordClassIndex(654987);
    }

    @Override // com.vivo.push.v
    public final String toString() {
        return "DefaultCommand";
    }

    public f() {
        super(0);
    }

    public final void a(int i) {
        this.a = i;
    }

    @Override // com.vivo.push.v
    protected final void c(com.vivo.push.d dVar) {
        if (dVar != null) {
            dVar.a("APP_CLIENT_SWITCH_FLAG", this.a);
        }
    }

    @Override // com.vivo.push.v
    protected final void d(com.vivo.push.d dVar) {
        if (dVar != null) {
            this.a = dVar.b("APP_CLIENT_SWITCH_FLAG", 0);
        }
    }
}
