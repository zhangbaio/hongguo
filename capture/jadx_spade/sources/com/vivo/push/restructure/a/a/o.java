package com.vivo.push.restructure.a.a;

import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.vivo.push.util.t;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class o implements n {
    private Map<String, m> a = new ConcurrentHashMap();

    static {
        Covode.recordClassIndex(655120);
    }

    o() {
    }

    @Override // com.vivo.push.restructure.a.a.n
    public final void a(com.vivo.push.restructure.a.a aVar, a aVar2) {
        if (aVar == null) {
            t.a("addToCache error. msg is null");
        } else if (TextUtils.isEmpty(aVar.a())) {
            t.a("addToCache error. messageID is null");
        } else if (aVar2 == null) {
            t.a("addToCache error. firstNode is null");
        }
    }
}
