package com.vivo.push.b;

import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class u extends t {
    private ArrayList<String> a;
    private ArrayList<String> b;

    static {
        Covode.recordClassIndex(655002);
    }

    @Override // com.vivo.push.b.t, com.vivo.push.v
    public final String toString() {
        return "OnSetTagsCommand";
    }

    public final ArrayList<String> e() {
        return this.a;
    }

    public final List<String> f() {
        return this.b;
    }

    public u(int i) {
        super(i);
        this.a = null;
        this.b = null;
    }

    @Override // com.vivo.push.b.t, com.vivo.push.v
    protected final void c(com.vivo.push.d dVar) {
        super.c(dVar);
        dVar.a("content", this.a);
        dVar.a("error_msg", this.b);
    }

    @Override // com.vivo.push.b.t, com.vivo.push.v
    protected final void d(com.vivo.push.d dVar) {
        super.d(dVar);
        this.a = dVar.c("content");
        this.b = dVar.c("error_msg");
    }
}
