package yq4;

import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.bytedance.sdk.bridge.annotation.BridgeContext;
import com.bytedance.sdk.bridge.annotation.BridgeParam;
import com.bytedance.sdk.bridge.model.IBridgeContext;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface y {
    HashMap<String, Object> a();

    f81.a b(WebView webView);

    long c(String str);

    y82.d d(WebView webView);

    boolean e();

    HashMap<String, Object> f();

    String g(String str);

    yy1.o getSecLinkSwitch();

    String h();

    boolean i();

    void interceptUrl(String str, Bundle bundle);

    String j(String str);

    void k();

    void l();

    boolean m();

    h n();

    String o(String str);

    boolean p(IBridgeContext iBridgeContext, String str, int i);

    void requestFromH5(@BridgeContext IBridgeContext iBridgeContext, @BridgeParam("__all_params__") JSONObject jSONObject);

    WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest);

    WebResourceResponse shouldInterceptRequest(WebView webView, String str);

    boolean shouldOverrideUrlLoading(WebView webView, String str);
}
