package com.vivo.push.d;

import com.bytedance.covode.number.Covode;
import com.vivo.push.restructure.request.a.a.b;
import org.json.JSONException;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class g implements com.vivo.push.restructure.request.a.a.b {
    public static final b.a<g> a;
    private long b;
    private int c;
    private int d;
    private boolean e;

    static {
        Covode.recordClassIndex(655018);
        a = new h();
    }

    @Override // com.vivo.push.restructure.request.a.a.b
    public final void a(com.vivo.push.restructure.request.a.a.a aVar) {
        aVar.a(this.b);
        aVar.a(this.c);
        aVar.a(this.d);
        aVar.a(this.e);
    }

    public g(com.vivo.push.restructure.request.a.a.a aVar) {
        try {
            this.b = aVar.b();
            this.c = aVar.a();
            this.d = aVar.a();
            this.e = aVar.d();
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public g(int i, boolean z) {
        this.c = i;
        this.d = 1;
        this.e = z;
    }

    public g(long j, int i, boolean z) {
        this.b = j;
        this.c = i;
        this.d = 2;
        this.e = z;
    }
}
