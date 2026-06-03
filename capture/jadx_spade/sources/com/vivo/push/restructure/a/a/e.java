package com.vivo.push.restructure.a.a;

import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.vivo.push.sdk.PushMessageCallback;
import com.vivo.push.util.t;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class e extends a<com.vivo.push.restructure.a.a> {
    static {
        Covode.recordClassIndex(655110);
    }

    private static PushMessageCallback b(com.vivo.push.restructure.a.a aVar) {
        try {
            return (PushMessageCallback) l3.a.q(com.vivo.push.restructure.a.a().e().a(com.vivo.push.restructure.a.a().b(), aVar.b().getAction())).getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e) {
            t.b("DispatchNode", "reflect e: ", e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.vivo.push.restructure.a.a.a
    public int a(com.vivo.push.restructure.a.a aVar) {
        PushMessageCallback b = b(aVar);
        if (b == null) {
            return 2804;
        }
        int i = 0;
        if (aVar != null && aVar.g()) {
            com.vivo.push.restructure.request.d.a().a(aVar);
            return 0;
        }
        if (aVar != null) {
            int l = aVar.l();
            String m = aVar.m();
            if (l == 3) {
                String i2 = com.vivo.push.m.a().i();
                if (TextUtils.isEmpty(i2) || !TextUtils.equals(i2, m)) {
                    i = 2810;
                }
            } else if (l == 4) {
                com.vivo.push.m.a();
                if (!com.vivo.push.m.c().contains(m)) {
                    i = 2811;
                }
            }
            if (i != 0) {
                com.vivo.push.util.g.a().execute(new f(this, l, m));
                return i;
            }
        }
        try {
            return com.vivo.push.m.a().a(aVar.b(), b);
        } catch (Exception unused) {
            return 2808;
        }
    }

    public e(com.vivo.push.restructure.a.a aVar, j jVar) {
        super("ClientDispatchNode", aVar, jVar);
    }
}
