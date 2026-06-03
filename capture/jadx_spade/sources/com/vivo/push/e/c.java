package com.vivo.push.e;

import com.bytedance.covode.number.Covode;
import com.vivo.push.restructure.request.a.a.c;
import com.vivo.push.util.t;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class c implements c.a<b> {
    static {
        Covode.recordClassIndex(655028);
    }

    c() {
    }

    @Override // com.vivo.push.restructure.request.a.a.c.a
    public final /* synthetic */ com.vivo.push.restructure.request.a.a.c a(String str) {
        return b(str);
    }

    private static b b(String str) {
        try {
            return new b(new com.vivo.push.restructure.request.a.a.a(str));
        } catch (Exception e) {
            t.a(8101, e.getMessage());
            return null;
        }
    }
}
