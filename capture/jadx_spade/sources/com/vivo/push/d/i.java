package com.vivo.push.d;

import com.bytedance.covode.number.Covode;
import com.vivo.push.restructure.request.a.a.b;
import org.json.JSONException;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class i implements com.vivo.push.restructure.request.a.a.b {
    public static final b.a<i> a;
    private int b;

    public final int a() {
        return this.b;
    }

    static {
        Covode.recordClassIndex(655020);
        a = new j();
    }

    @Override // com.vivo.push.restructure.request.a.a.b
    public final void a(com.vivo.push.restructure.request.a.a.a aVar) {
        aVar.a(this.b);
    }

    public i(com.vivo.push.restructure.request.a.a.a aVar) throws JSONException {
        this.b = aVar.a();
    }
}
