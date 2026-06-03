package com.vivo.push.restructure.request;

import android.content.Intent;
import android.os.Bundle;
import com.bytedance.covode.number.Covode;
import com.vivo.push.restructure.request.a.a.b;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class a<I extends com.vivo.push.restructure.request.a.a.b, O extends com.vivo.push.restructure.request.a.a.b> {
    private int a;
    private I b;

    static {
        Covode.recordClassIndex(655131);
    }

    public abstract O a(com.vivo.push.restructure.request.a.a.a aVar);

    public final Intent a(int i) {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("client_pkgname", com.vivo.push.restructure.a.a().b().getPackageName());
        bundle.putBoolean("support_rf", true);
        com.vivo.push.restructure.request.a.c cVar = new com.vivo.push.restructure.request.a.c(this.a, i);
        com.vivo.push.restructure.request.a.a.a aVar = new com.vivo.push.restructure.request.a.a.a();
        cVar.a(aVar);
        bundle.putString("cf_content", aVar.e());
        com.vivo.push.restructure.request.a.a.a aVar2 = new com.vivo.push.restructure.request.a.a.a();
        this.b.a(aVar2);
        bundle.putString("content", aVar2.e());
        intent.putExtras(bundle);
        return intent;
    }

    protected a(int i, I i2) {
        this.a = i;
        this.b = i2;
    }
}
