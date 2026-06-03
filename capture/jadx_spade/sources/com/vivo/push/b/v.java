package com.vivo.push.b;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class v extends w {
    private long a;
    private int b;

    static {
        Covode.recordClassIndex(655003);
    }

    @Override // com.vivo.push.b.t, com.vivo.push.v
    public final String toString() {
        return "OnUndoMsgCommand";
    }

    public final long e() {
        return this.a;
    }

    public v() {
        super(20);
        this.a = -1L;
    }

    public final String f() {
        long j = this.a;
        if (j != -1) {
            return String.valueOf(j);
        }
        return null;
    }

    @Override // com.vivo.push.b.w, com.vivo.push.b.t, com.vivo.push.v
    protected final void c(com.vivo.push.d dVar) {
        super.c(dVar);
        dVar.a("undo_msg_v1", this.a);
        dVar.a("undo_msg_type_v1", this.b);
    }

    @Override // com.vivo.push.b.w, com.vivo.push.b.t, com.vivo.push.v
    protected final void d(com.vivo.push.d dVar) {
        super.d(dVar);
        this.a = dVar.b("undo_msg_v1", this.a);
        this.b = dVar.b("undo_msg_type_v1", 0);
    }
}
