package com.vivo.push.b;

import com.bytedance.covode.number.Covode;
import java.util.ArrayList;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class a extends c {
    private ArrayList<String> a;

    static {
        Covode.recordClassIndex(654982);
    }

    @Override // com.vivo.push.b.c, com.vivo.push.v
    public final String toString() {
        return "AliasCommand:" + b();
    }

    @Override // com.vivo.push.b.c, com.vivo.push.v
    public final void c(com.vivo.push.d dVar) {
        super.c(dVar);
        dVar.a("tags", this.a);
    }

    @Override // com.vivo.push.b.c, com.vivo.push.v
    public final void d(com.vivo.push.d dVar) {
        super.d(dVar);
        this.a = dVar.c("tags");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public a(boolean r1, java.lang.String r2, java.util.ArrayList<java.lang.String> r3) {
        /*
            r0 = this;
            if (r1 == 0) goto L5
            r1 = 2002(0x7d2, float:2.805E-42)
            goto L7
        L5:
            r1 = 2003(0x7d3, float:2.807E-42)
        L7:
            r0.<init>(r1, r2)
            r0.a = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.push.b.a.<init>(boolean, java.lang.String, java.util.ArrayList):void");
    }
}
