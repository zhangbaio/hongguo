package com.vivo.push.b;

import com.bytedance.covode.number.Covode;
import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class z extends c {
    private ArrayList<String> a;

    static {
        Covode.recordClassIndex(655007);
    }

    @Override // com.vivo.push.b.c, com.vivo.push.v
    public final String toString() {
        return "TagCommand";
    }

    @Override // com.vivo.push.b.c, com.vivo.push.v
    protected final void c(com.vivo.push.d dVar) {
        super.c(dVar);
        dVar.a("tags", (Serializable) this.a);
    }

    @Override // com.vivo.push.b.c, com.vivo.push.v
    protected final void d(com.vivo.push.d dVar) {
        super.d(dVar);
        this.a = dVar.c("tags");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public z(boolean r1, java.lang.String r2, java.util.ArrayList<java.lang.String> r3) {
        /*
            r0 = this;
            if (r1 == 0) goto L5
            r1 = 2004(0x7d4, float:2.808E-42)
            goto L7
        L5:
            r1 = 2005(0x7d5, float:2.81E-42)
        L7:
            r0.<init>(r1, r2)
            r0.a = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.push.b.z.<init>(boolean, java.lang.String, java.util.ArrayList):void");
    }
}
