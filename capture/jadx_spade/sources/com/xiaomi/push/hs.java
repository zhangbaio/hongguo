package com.xiaomi.push;

import com.bytedance.covode.number.Covode;
import com.xiaomi.push.hv;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class hs {
    private final hz a;

    /* renamed from: a, reason: collision with other field name */
    private final ii f820a;

    static {
        Covode.recordClassIndex(655596);
    }

    public hs() {
        this(new hv.a());
    }

    public hs(ib ibVar) {
        ii iiVar = new ii();
        this.f820a = iiVar;
        this.a = ibVar.a(iiVar);
    }

    public void a(hp hpVar, byte[] bArr) {
        try {
            this.f820a.a(bArr);
            hpVar.a(this.a);
        } finally {
            this.a.k();
        }
    }
}
