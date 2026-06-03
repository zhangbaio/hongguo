package com.unionpay;

import android.app.Activity;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.bytedance.covode.number.Covode;
import java.io.InputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class WebViewJavascriptBridge implements Serializable {
    f _messageHandler;
    Activity mContext;
    WebView mWebView;
    private boolean mAllowScheme = false;
    Map _messageHandlers = new HashMap();
    Map _responseCallbacks = new HashMap();
    long _uniqueId = 0;

    static {
        Covode.recordClassIndex(654845);
    }

    public WebViewJavascriptBridge(Activity activity, WebView webView, f fVar) {
        byte b = 0;
        this.mContext = activity;
        this.mWebView = webView;
        this._messageHandler = fVar;
        WebSettings settings = this.mWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setSavePassword(false);
        settings.setAllowFileAccess(false);
        settings.setDomStorageEnabled(true);
        try {
            this.mWebView.removeJavascriptInterface("accessibility");
            this.mWebView.removeJavascriptInterface("accessibilityTraversal");
            this.mWebView.removeJavascriptInterface("searchBoxJavaBridge_");
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.mWebView.addJavascriptInterface(this, "_WebViewJavascriptBridge");
        this.mWebView.setWebViewClient(new e(this, b));
        this.mWebView.setWebChromeClient(new d(this, (byte) 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _callbackJs(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("responseId", str);
        hashMap.put("responseData", str2);
        _dispatchMessage(hashMap);
    }

    private void _dispatchMessage(Map map) {
        String jSONObject = new JSONObject(map).toString();
        com.unionpay.utils.j.b("uppay", "sending:" + jSONObject);
        this.mContext.runOnUiThread(new c0(this, String.format("javascript:WebViewJavascriptBridge._handleMessageFromJava('%s');", doubleEscapeString(jSONObject))));
    }

    private void _sendData(String str, g gVar, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("data", str);
        if (gVar != null) {
            StringBuilder sb = new StringBuilder("java_cb_");
            long j = this._uniqueId + 1;
            this._uniqueId = j;
            sb.append(j);
            String sb2 = sb.toString();
            this._responseCallbacks.put(sb2, gVar);
            hashMap.put("callbackId", sb2);
        }
        if (str2 != null) {
            hashMap.put("handlerName", str2);
        }
        _dispatchMessage(hashMap);
    }

    public static String convertStreamToString(InputStream inputStream) {
        String str;
        str = "";
        try {
            Scanner useDelimiter = new Scanner(inputStream, "UTF-8").useDelimiter("\\A");
            str = useDelimiter.hasNext() ? useDelimiter.next() : "";
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    private String doubleEscapeString(String str) {
        return str.replace("\\", "\\\\").replace("\"", "\\\"").replace("'", "\\'").replace("\n", "\\n").replace("\r", "\\r").replace("\f", "\\f");
    }

    private void loadWebViewJavascriptBridgeJs(WebView webView) {
        webView.loadUrl("javascript:" + convertStreamToString(getClass().getResourceAsStream("res/webviewjavascriptbridge.js")));
    }

    @JavascriptInterface
    public void _handleMessageFromJs(String str, String str2, String str3, String str4, String str5) {
        f fVar;
        if (str2 != null) {
            ((g) this._responseCallbacks.get(str2)).a(str3);
            this._responseCallbacks.remove(str2);
            return;
        }
        c cVar = str4 != null ? new c(this, str4) : null;
        if (str5 != null) {
            fVar = (f) this._messageHandlers.get(str5);
            if (fVar == null) {
                com.unionpay.utils.j.d("uppay", "WVJB Warning: No handler for " + str5);
                return;
            }
        } else {
            fVar = this._messageHandler;
        }
        try {
            this.mContext.runOnUiThread(new b0(this, fVar, str, cVar));
        } catch (Exception e) {
            com.unionpay.utils.j.d("uppay", "WebViewJavascriptBridge: WARNING: java handler threw. " + e.getMessage());
        }
    }

    public void callHandler(String str) {
        callHandler(str, null, null);
    }

    public void callHandler(String str, String str2) {
        callHandler(str, str2, null);
    }

    public void callHandler(String str, String str2, g gVar) {
        _sendData(str2, gVar, str);
    }

    public void registerHandler(String str, f fVar) {
        this._messageHandlers.put(str, fVar);
    }

    public void send(String str) {
        send(str, null);
    }

    public void send(String str, g gVar) {
        _sendData(str, gVar, null);
    }

    public void setAllowScheme(boolean z) {
        this.mAllowScheme = z;
    }
}
