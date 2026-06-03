package com.vivo.push.d;

import com.bytedance.covode.number.Covode;
import com.vivo.push.util.t;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class f implements com.vivo.push.restructure.request.c<i> {
    final /* synthetic */ e a;

    static {
        Covode.recordClassIndex(655017);
    }

    f(e eVar) {
        this.a = eVar;
    }

    @Override // com.vivo.push.restructure.request.c
    public final void a(int i) {
        t.d("NotifyGuideDialogManage", "onError:".concat(String.valueOf(i)));
        this.a.b.onStateChanged(i);
    }

    @Override // com.vivo.push.restructure.request.c
    public final /* synthetic */ void a(i iVar) {
        i iVar2 = iVar;
        if (iVar2 == null) {
            this.a.b.onStateChanged(10000);
            return;
        }
        t.d("NotifyGuideDialogManage", "onReceiveAck:" + iVar2.a());
        this.a.b.onStateChanged(iVar2.a());
    }
}
