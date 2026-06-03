package com.vivo.push.b;

import com.bytedance.covode.number.Covode;
import java.util.ArrayList;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class m extends t {
    private ArrayList<String> a;

    static {
        Covode.recordClassIndex(654994);
    }

    @Override // com.vivo.push.b.t, com.vivo.push.v
    public final String toString() {
        return "OnListTagCommand";
    }

    public final ArrayList<String> e() {
        return this.a;
    }

    public m() {
        super(8);
    }

    @Override // com.vivo.push.b.t, com.vivo.push.v
    protected final void c(com.vivo.push.d dVar) {
        super.c(dVar);
        dVar.a("tags_list", this.a);
    }

    @Override // com.vivo.push.b.t, com.vivo.push.v
    protected final void d(com.vivo.push.d dVar) {
        super.d(dVar);
        this.a = dVar.c("tags_list");
    }
}
