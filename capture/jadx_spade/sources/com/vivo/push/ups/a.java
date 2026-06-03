package com.vivo.push.ups;

import com.bytedance.covode.number.Covode;
import com.vivo.push.IPushActionListener;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class a implements IPushActionListener {
    final /* synthetic */ UPSRegisterCallback a;
    final /* synthetic */ VUpsManager b;

    static {
        Covode.recordClassIndex(655165);
    }

    @Override // com.vivo.push.IPushActionListener
    public final void onStateChanged(int i) {
        this.a.onResult(new TokenResult(i, com.vivo.push.restructure.a.a().h().b()));
    }

    a(VUpsManager vUpsManager, UPSRegisterCallback uPSRegisterCallback) {
        this.b = vUpsManager;
        this.a = uPSRegisterCallback;
    }
}
