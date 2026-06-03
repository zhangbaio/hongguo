package com.unionpay;

import al2.e0;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.bytedance.covode.number.Covode;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class e extends WebViewClient {
    final /* synthetic */ WebViewJavascriptBridge a;

    static {
        Covode.recordClassIndex(654853);
    }

    private e(WebViewJavascriptBridge webViewJavascriptBridge) {
        this.a = webViewJavascriptBridge;
    }

    /* synthetic */ e(WebViewJavascriptBridge webViewJavascriptBridge, byte b) {
        this(webViewJavascriptBridge);
    }

    public final boolean a(WebView webView, String str) {
        boolean z;
        com.unionpay.utils.j.b("uppay", "shouldOverrideUrlLoading：" + str);
        z = this.a.mAllowScheme;
        if (z && !TextUtils.isEmpty(str) && !str.startsWith("http") && !str.startsWith("HTTP")) {
            try {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.setData(Uri.parse(str));
                this.a.mContext.startActivity(intent);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        com.unionpay.utils.j.b("uppay", "onPageFinished");
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return b(this, webView, str);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.webkit.WebViewClient")
    @Insert("shouldOverrideUrlLoading")
    public static boolean b(e eVar, WebView webView, String str) {
        boolean a = eVar.a(webView, str);
        if (e0.b(webView, str)) {
            e0.a.i("shouldOverrideUrlLoading, url: %s", new Object[]{str});
            return true;
        }
        return a;
    }
}
