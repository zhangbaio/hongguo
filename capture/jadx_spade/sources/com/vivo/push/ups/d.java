package com.vivo.push.ups;

import com.bytedance.covode.number.Covode;
import com.vivo.push.IPushActionListener;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class d implements IPushActionListener {
    final /* synthetic */ UPSTurnCallback a;
    final /* synthetic */ VUpsManager b;

    static {
        Covode.recordClassIndex(655168);
    }

    @Override // com.vivo.push.IPushActionListener
    public final void onStateChanged(int i) {
        this.a.onResult(new CodeResult(i));
    }

    d(VUpsManager vUpsManager, UPSTurnCallback uPSTurnCallback) {
        this.b = vUpsManager;
        this.a = uPSTurnCallback;
    }
}
