package com.vivo.push.e;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.vivo.push.restructure.request.IPushRequestCallback;
import com.vivo.push.util.t;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class d implements a {
    static {
        Covode.recordClassIndex(655029);
    }

    @Override // com.vivo.push.e.a
    public final void deleteAllProfileId(IPushRequestCallback<Integer> iPushRequestCallback) {
        com.vivo.push.util.g.a().execute(new g(this, iPushRequestCallback));
    }

    @Override // com.vivo.push.e.a
    public final void queryProfileIds(IPushRequestCallback<List<String>> iPushRequestCallback) {
        com.vivo.push.util.g.a().execute(new h(this, iPushRequestCallback));
    }

    @Override // com.vivo.push.e.a
    public final void addProfileId(String str, IPushRequestCallback<Integer> iPushRequestCallback) {
        com.vivo.push.util.g.a().execute(new e(this, str, iPushRequestCallback));
    }

    @Override // com.vivo.push.e.a
    public final void deleteProfileId(String str, IPushRequestCallback<Integer> iPushRequestCallback) {
        com.vivo.push.util.g.a().execute(new f(this, str, iPushRequestCallback));
    }

    static /* synthetic */ void a(d dVar, String str, IPushRequestCallback iPushRequestCallback, int i) {
        if (com.vivo.push.restructure.a.a().g().b() != 0) {
            t.b("core not support sync profileInfo");
            if (iPushRequestCallback != null) {
                iPushRequestCallback.onError(8102);
                return;
            }
        }
        Context b = com.vivo.push.restructure.a.a().b();
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            arrayList.add(new b(str));
        }
        com.vivo.push.restructure.request.d.a().a(new com.vivo.push.restructure.request.b(new com.vivo.push.e.a.a(new com.vivo.push.e.a.b(b.getPackageName(), arrayList, i)), new j(dVar, iPushRequestCallback, i), 20000L));
    }
}
