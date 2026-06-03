package com.vivo.push;

import com.bytedance.covode.number.Covode;
import com.vivo.push.restructure.request.a.a.c;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class f implements c.a<e> {
    static {
        Covode.recordClassIndex(655036);
    }

    f() {
    }

    @Override // com.vivo.push.restructure.request.a.a.c.a
    public final /* synthetic */ com.vivo.push.restructure.request.a.a.c a(String str) {
        return b(str);
    }

    private static e b(String str) {
        try {
            return new e(new com.vivo.push.restructure.request.a.a.a(str));
        } catch (Exception e) {
            com.vivo.push.util.t.a(8101, e.getMessage());
            return null;
        }
    }
}
