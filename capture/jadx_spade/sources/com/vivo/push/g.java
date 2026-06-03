package com.vivo.push;

import com.bytedance.covode.number.Covode;
import com.vivo.push.restructure.request.a.a.c;
import org.json.JSONException;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class g implements com.vivo.push.restructure.request.a.a.c {
    public static c.a<g> a;
    private int b;
    private String c;

    public final String b() {
        return this.c;
    }

    static {
        Covode.recordClassIndex(655038);
        a = new h();
    }

    @Override // com.vivo.push.restructure.request.a.a.c
    public final String a() {
        com.vivo.push.restructure.request.a.a.a aVar = new com.vivo.push.restructure.request.a.a.a();
        aVar.a(this.b);
        aVar.a(this.c);
        return aVar.e();
    }

    protected g(com.vivo.push.restructure.request.a.a.a aVar) throws JSONException {
        this.b = aVar.a();
        this.c = aVar.c();
    }
}
