package com.unionpay;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class c implements g {
    private final String a;
    final /* synthetic */ WebViewJavascriptBridge b;

    static {
        Covode.recordClassIndex(654851);
    }

    public c(WebViewJavascriptBridge webViewJavascriptBridge, String str) {
        this.b = webViewJavascriptBridge;
        this.a = str;
    }

    @Override // com.unionpay.g
    public final void a(String str) {
        this.b._callbackJs(this.a, str);
    }
}
