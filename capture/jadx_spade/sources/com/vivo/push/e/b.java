package com.vivo.push.e;

import com.bytedance.covode.number.Covode;
import com.vivo.push.restructure.request.a.a.c;
import org.json.JSONException;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class b implements com.vivo.push.restructure.request.a.a.c {
    public static c.a<b> a;
    private String b;

    public final String b() {
        return this.b;
    }

    static {
        Covode.recordClassIndex(655027);
        a = new c();
    }

    @Override // com.vivo.push.restructure.request.a.a.c
    public final String a() {
        com.vivo.push.restructure.request.a.a.a aVar = new com.vivo.push.restructure.request.a.a.a();
        aVar.a(this.b);
        return aVar.e();
    }

    public b(String str) {
        this.b = str;
    }

    protected b(com.vivo.push.restructure.request.a.a.a aVar) throws JSONException {
        this.b = aVar.c();
    }
}
