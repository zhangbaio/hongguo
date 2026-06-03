package com.vivo.push;

import com.bytedance.covode.number.Covode;
import com.vivo.push.restructure.request.a.a.c;
import org.json.JSONException;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class e implements com.vivo.push.restructure.request.a.a.c {
    public static c.a<e> a;
    private int b;
    private String c;
    private String d;
    private String e;
    private String f;

    static {
        Covode.recordClassIndex(655022);
        a = new f();
    }

    @Override // com.vivo.push.restructure.request.a.a.c
    public final String a() {
        com.vivo.push.restructure.request.a.a.a aVar = new com.vivo.push.restructure.request.a.a.a();
        aVar.a(this.b);
        aVar.a(this.c);
        aVar.a(this.d);
        aVar.a(this.e);
        aVar.a(this.f);
        return aVar.e();
    }

    protected e(com.vivo.push.restructure.request.a.a.a aVar) throws JSONException {
        this.b = aVar.a();
        this.c = aVar.c();
        this.d = aVar.c();
        this.e = aVar.c();
        this.f = aVar.c();
    }

    public e(int i, String str, String str2, String str3, String str4) {
        this.b = i;
        this.c = str;
        this.d = str2;
        this.e = str3;
        this.f = str4;
    }
}
