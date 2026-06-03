package com.tencent.open.c;

import android.content.Context;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.bytedance.covode.number.Covode;
import com.tencent.open.log.SLog;
import java.lang.reflect.Method;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class b extends WebView {
    static {
        Covode.recordClassIndex(653524);
    }

    public void b__setWebViewClient$___twin___(WebViewClient webViewClient) {
        super.setWebViewClient(webViewClient);
    }

    @Override // android.webkit.WebView
    public void setWebViewClient(WebViewClient webViewClient) {
        com_tencent_open_c_b_com_dragon_read_aop_SecurityHoleAop_setWebViewClient(this, webViewClient);
    }

    protected void a() {
        removeJavascriptInterface("searchBoxJavaBridge_");
        removeJavascriptInterface("accessibility");
        removeJavascriptInterface("accessibilityTraversal");
        SLog.i("openSDK_LOG.OpenWebView", "removeJSInterface");
    }

    @Override // android.webkit.WebView
    public void destroy() {
        try {
            getSettings().setBuiltInZoomControls(true);
            getSettings().setDisplayZoomControls(false);
            setVisibility(8);
            SLog.i("openSDK_LOG.OpenWebView", "-->OpenWebView.destroy setBuiltInZoomControls");
        } catch (Exception e) {
            SLog.e("openSDK_LOG.OpenWebView", "-->OpenWebView.destroy setBuiltInZoomControls", e);
        }
        super.destroy();
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        WebSettings settings = getSettings();
        if (settings == null) {
            return;
        }
        settings.setSavePassword(false);
        try {
            Method method = settings.getClass().getMethod("removeJavascriptInterface", String.class);
            if (method != null) {
                method.invoke(this, "searchBoxJavaBridge_");
                method.invoke(this, "accessibility");
                method.invoke(this, "accessibilityTraversal");
                SLog.i("openSDK_LOG.OpenWebView", "remove js interface");
            }
        } catch (Exception e) {
            SLog.e("openSDK_LOG.OpenWebView", "remove js interface.e:" + e.toString());
        }
    }

    public b(Context context) {
        super(context);
        a();
    }

    @TargetClass(scope = Scope.DIRECT, value = "android.webkit.WebView")
    @Insert(mayCreateSuper = true, value = "setWebViewClient")
    public static void com_tencent_open_c_b_com_dragon_read_aop_SecurityHoleAop_setWebViewClient(b bVar, WebViewClient webViewClient) {
        WebSettings settings = bVar.getSettings();
        if (settings != null) {
            settings.setSavePassword(false);
        }
        bVar.b__setWebViewClient$___twin___(webViewClient);
    }
}
