package com.unionpay;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class b0 implements Runnable {
    final /* synthetic */ f a;
    final /* synthetic */ String b;
    final /* synthetic */ g c;
    final /* synthetic */ WebViewJavascriptBridge d;

    static {
        Covode.recordClassIndex(654947);
    }

    b0(WebViewJavascriptBridge webViewJavascriptBridge, f fVar, String str, g gVar) {
        this.d = webViewJavascriptBridge;
        this.a = fVar;
        this.b = str;
        this.c = gVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        f fVar = this.a;
        if (fVar != null) {
            fVar.a(this.b, this.c);
        }
    }
}
