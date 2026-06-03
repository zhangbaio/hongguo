package com.unionpay;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.bytedance.apm.agent.v2.instrumentation.ActivityAgent;
import com.bytedance.covode.number.Covode;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.dragon.read.component.biz.api.NsAdApi;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class UPPayWapActivity extends Activity {
    private static String i;
    private WebView a;
    private WebViewJavascriptBridge b;
    private AlertDialog c;
    private boolean d = false;
    private String e = "";
    private String f;
    private View g;
    private g h;

    static {
        Covode.recordClassIndex(654842);
        i = "ex_mode";
    }

    static /* synthetic */ void i(UPPayWapActivity uPPayWapActivity, boolean z) {
        View view = uPPayWapActivity.g;
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(String str, String str2) {
        Intent intent = new Intent();
        intent.putExtra("pay_result", str);
        intent.putExtra("result_data", str2);
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String l(String str, String str2, String str3) {
        try {
            JSONObject jSONObject = new JSONObject("{\"code\":\"0\",\"msg\":\"success\"}");
            if (str != null) {
                jSONObject.put("code", str);
            }
            if (str2 != null) {
                jSONObject.put("msg", str2);
            }
            if (str3 != null) {
                jSONObject.put("value", str3);
            }
            return jSONObject.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String m(String str, String str2, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject("{\"code\":\"0\",\"msg\":\"success\"}");
            if (str != null) {
                jSONObject2.put("code", str);
            }
            if (str2 != null) {
                jSONObject2.put("msg", str2);
            }
            if (jSONObject != null) {
                jSONObject2.put("value", jSONObject);
            }
            return jSONObject2.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    static /* synthetic */ void q(UPPayWapActivity uPPayWapActivity) {
        AlertDialog.Builder builder = new AlertDialog.Builder(uPPayWapActivity);
        uPPayWapActivity.c = builder.create();
        builder.setMessage(com.unionpay.utils.k.a().a);
        builder.setTitle(com.unionpay.utils.k.a().d);
        builder.setPositiveButton(com.unionpay.utils.k.a().b, new t(uPPayWapActivity));
        builder.setNegativeButton(com.unionpay.utils.k.a().c, new u(uPPayWapActivity));
        builder.create().show();
    }

    public void a() {
        super.onStop();
    }

    public void b(Intent intent, Bundle bundle) {
        super.startActivity(intent, bundle);
    }

    @Override // android.app.Activity
    public void finish() {
        try {
            super.finish();
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1 && i3 == -1) {
            try {
                Bundle extras = intent.getExtras();
                if (extras != null) {
                    String str = "";
                    String string = extras.containsKey("pay_result") ? extras.getString("pay_result") : extras.containsKey("code") ? extras.getString("code") : "";
                    if (TextUtils.isEmpty(string)) {
                        string = "";
                    }
                    String string2 = extras.containsKey("data") ? extras.getString("data") : "";
                    if (!TextUtils.isEmpty(string2)) {
                        str = string2;
                    }
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("code", string);
                    jSONObject.put("data", str);
                    g gVar = this.h;
                    if (gVar != null) {
                        gVar.a(m("0", null, jSONObject));
                    }
                } else {
                    g gVar2 = this.h;
                    if (gVar2 != null) {
                        gVar2.a(l("1", "No pay result", null));
                    }
                }
            } catch (Exception unused) {
                g gVar3 = this.h;
                if (gVar3 != null) {
                    gVar3.a(l("1", "No pay result", null));
                }
            }
            this.h = null;
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        String str;
        View.OnClickListener onClickListener;
        String str2;
        ActivityAgent.onTrace("com.unionpay.UPPayWapActivity", "onCreate", true);
        super.onCreate(bundle);
        getWindow().addFlags(8192);
        try {
            try {
                if (!"949A1CC".equalsIgnoreCase(getIntent().getStringExtra("magic_data"))) {
                    finish();
                }
                this.d = "link".equals(getIntent().getStringExtra("actionType"));
                String stringExtra = getIntent().getStringExtra(i);
                this.e = stringExtra;
                if (TextUtils.isEmpty(stringExtra)) {
                    this.e = "00";
                }
                str = "";
                getWindow().requestFeature(1);
                RelativeLayout relativeLayout = new RelativeLayout(this);
                LinearLayout linearLayout = new LinearLayout(this);
                linearLayout.setOrientation(1);
                relativeLayout.addView(linearLayout, new RelativeLayout.LayoutParams(-1, -1));
                setContentView(relativeLayout);
                this.a = new WebView(this);
                String stringExtra2 = getIntent().getStringExtra("actionType");
                this.f = stringExtra2;
                if ("link".equals(stringExtra2)) {
                    str2 = getIntent().getStringExtra("wapurl");
                } else {
                    String stringExtra3 = getIntent().getStringExtra("waptype");
                    String stringExtra4 = getIntent().getStringExtra("wapurl");
                    if ("new_page".equals(stringExtra3)) {
                        str = stringExtra4 != null ? stringExtra4 : "";
                        onClickListener = new l(this);
                    } else {
                        String stringExtra5 = getIntent().getStringExtra("paydata");
                        if (stringExtra5 != null) {
                            str = stringExtra4 + "?s=" + stringExtra5;
                        }
                        onClickListener = null;
                    }
                    ImageView imageView = new ImageView(this);
                    imageView.setBackgroundDrawable(com.unionpay.utils.g.a(com.unionpay.utils.h.b));
                    int a = com.unionpay.utils.f.a(this, 24.0f);
                    int a2 = com.unionpay.utils.f.a(this, 18.0f);
                    int a3 = com.unionpay.utils.f.a(this, 14.0f);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(a, a);
                    layoutParams.addRule(9, -1);
                    layoutParams.addRule(10, -1);
                    layoutParams.setMargins(a2, a3, 0, 0);
                    relativeLayout.addView(imageView, layoutParams);
                    if (onClickListener == null) {
                        onClickListener = new s(this);
                    }
                    imageView.setOnClickListener(onClickListener);
                    this.g = imageView;
                    str2 = str;
                }
                this.a.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                linearLayout.addView(this.a);
                WebViewJavascriptBridge webViewJavascriptBridge = new WebViewJavascriptBridge(this, this.a, null);
                this.b = webViewJavascriptBridge;
                webViewJavascriptBridge.setAllowScheme(true);
                WebView webView = this.a;
                if (webView != null) {
                    webView.loadUrl(str2);
                }
                WebViewJavascriptBridge webViewJavascriptBridge2 = this.b;
                if (webViewJavascriptBridge2 != null) {
                    webViewJavascriptBridge2.registerHandler("getDeviceInfo", new v(this));
                    this.b.registerHandler("saveData", new w(this));
                    this.b.registerHandler("getData", new x(this));
                    this.b.registerHandler("removeData", new y(this));
                    this.b.registerHandler("setPageBackEnable", new z(this));
                    this.b.registerHandler("payBySDK", new a0(this));
                    this.b.registerHandler("payResult", new m(this));
                    this.b.registerHandler("closePage", new n(this));
                    this.b.registerHandler("openNewPage", new o(this));
                    this.b.registerHandler("checkBankSchemes", new p(this));
                    this.b.registerHandler("openBankApp", new q(this));
                    this.b.registerHandler("openScheme", new r(this));
                }
                ActivityAgent.onTrace("com.unionpay.UPPayWapActivity", "onCreate", false);
            } catch (Exception unused) {
                ActivityAgent.onTrace("com.unionpay.UPPayWapActivity", "onCreate", false);
            }
        } catch (Exception unused2) {
            finish();
            ActivityAgent.onTrace("com.unionpay.UPPayWapActivity", "onCreate", false);
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 != 4) {
            return super.onKeyDown(i2, keyEvent);
        }
        if (this.d) {
            WebView webView = this.a;
            if (webView != null && webView.canGoBack()) {
                this.a.goBack();
                return true;
            }
            j("cancel", null);
        } else {
            onPause();
        }
        return true;
    }

    @Override // android.app.Activity
    public void onResume() {
        ActivityAgent.onTrace("com.unionpay.UPPayWapActivity", "onResume", true);
        super.onResume();
        ActivityAgent.onTrace("com.unionpay.UPPayWapActivity", "onResume", false);
    }

    @Override // android.app.Activity
    public void onStart() {
        ActivityAgent.onTrace("com.unionpay.UPPayWapActivity", "onStart", true);
        super.onStart();
        ActivityAgent.onTrace("com.unionpay.UPPayWapActivity", "onStart", false);
    }

    @Override // android.app.Activity
    protected void onStop() {
        o(this);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        ActivityAgent.onTrace("com.unionpay.UPPayWapActivity", "onWindowFocusChanged", true);
        super.onWindowFocusChanged(z);
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent, Bundle bundle) {
        p(this, intent, bundle);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void o(UPPayWapActivity uPPayWapActivity) {
        uPPayWapActivity.a();
        if (EnterTransitionCrashOptimizer.getContext() != null) {
            try {
                uPPayWapActivity.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();
            } catch (Throwable unused) {
            }
        }
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "startActivity")
    public static void p(UPPayWapActivity uPPayWapActivity, Intent intent, Bundle bundle) {
        al2.a.a.i("startActivity-aop", new Object[0]);
        if (NsAdApi.IMPL.interceptQuickApp(intent)) {
            return;
        }
        uPPayWapActivity.b(intent, bundle);
    }
}
