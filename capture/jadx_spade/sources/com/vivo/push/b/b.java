package com.vivo.push.b;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class b extends c {
    private String a;
    private String b;
    private int c;
    private boolean d;

    static {
        Covode.recordClassIndex(654983);
    }

    @Override // com.vivo.push.b.c, com.vivo.push.v
    public final String toString() {
        return "AppCommand:" + b();
    }

    public final void a(int i) {
        this.c = i;
    }

    @Override // com.vivo.push.b.c, com.vivo.push.v
    public final void c(com.vivo.push.d dVar) {
        super.c(dVar);
        dVar.a("sdk_clients", this.a);
        dVar.a("sdk_version", 356L);
        dVar.a("PUSH_REGID", this.b);
        if (b() == 2007) {
            dVar.a("PUSH_UNBIND_SOURCE_CODE", this.c);
        }
    }

    @Override // com.vivo.push.b.c, com.vivo.push.v
    public final void d(com.vivo.push.d dVar) {
        super.d(dVar);
        this.a = dVar.a("sdk_clients");
        this.b = dVar.a("PUSH_REGID");
        if (b() == 2007) {
            this.c = dVar.b("PUSH_UNBIND_SOURCE_CODE", 1);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public b(boolean r1, java.lang.String r2) {
        /*
            r0 = this;
            if (r1 == 0) goto L5
            r1 = 2006(0x7d6, float:2.811E-42)
            goto L7
        L5:
            r1 = 2007(0x7d7, float:2.812E-42)
        L7:
            r0.<init>(r1, r2)
            r1 = 1
            r0.c = r1
            r1 = 0
            r0.d = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.push.b.b.<init>(boolean, java.lang.String):void");
    }
}
