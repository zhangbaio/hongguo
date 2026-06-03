package com.dragon.read.mgl.service.view;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;
import com.android.ttcjpaysdk.ttcjpayapi.IH5PayCallback;
import com.android.ttcjpaysdk.ttcjpayapi.TTCJPayObserver;
import com.android.ttcjpaysdk.ttcjpayapi.TTCJPayResult;
import com.android.ttcjpaysdk.ttcjpayapi.TTCJPayUtils;
import com.byted.mgl.merge.service.api.aweme.BdpAwemeService;
import com.byted.mgl.merge.service.api.aweme.BdpOpenSchemaTimelineManageService;
import com.byted.mgl.merge.service.api.aweme.RequestLynxPaymentCallback;
import com.bytedance.apm.agent.v2.instrumentation.ActivityAgent;
import com.bytedance.bdp.appbase.base.bdptask.BdpPool;
import com.bytedance.bdp.appbase.base.log.BdpLogger;
import com.bytedance.bdp.bdpbase.manager.BdpManager;
import com.bytedance.bdp.bdpbase.util.ActivityUtil;
import com.bytedance.bdp.bdpbase.util.BdpActivityResultRequest;
import com.bytedance.bdp.bdpbase.util.ProcessUtil;
import com.bytedance.covode.number.Covode;
import com.bytedance.ies.bullet.base.BulletSdk;
import com.bytedance.ies.bullet.service.base.api.IBulletUIComponent;
import com.bytedance.ies.bullet.service.base.api.IBulletUILifecycleListener;
import com.bytedance.ies.bullet.service.base.router.config.RouterOpenConfig;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.event.Event;
import com.bytedance.ies.xbridge.event.EventCenter;
import com.bytedance.ies.xbridge.event.Js2NativeEvent;
import com.bytedance.ies.xbridge.event.JsEventSubscriber;
import com.bytedance.ies.xbridge.model.collections.defaultimpl.DefaultXReadableMapImpl;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.dragon.read.app.SingleAppContext;
import com.dragon.read.component.biz.api.NsAdApi;
import com.dragon.read.mgl.service.view.BdpTransferActivity;
import com.ss.android.common.lib.AppLogNewUtils;
import com.ss.android.deviceregister.DeviceRegisterManager;
import com.ss.ttm.player.MediaPlayer;
import es4.j;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class BdpTransferActivity extends AppCompatActivity {
    public static final a g;
    public static final int h;
    private int a;
    private Map<String, String> b;
    private boolean c;
    private j d;
    private FrameLayout e;
    private TTCJPayObserver f = new d();

    static {
        Covode.recordClassIndex(611985);
        g = new a(null);
        h = 8;
    }

    public void U1() {
        super.onStop();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void V1(Intent intent, Bundle bundle) {
        super/*android.app.Activity*/.startActivity(intent, bundle);
    }

    public void onResume() {
        ActivityAgent.onTrace("com.dragon.read.mgl.service.view.BdpTransferActivity", "onResume", true);
        super/*androidx.fragment.app.FragmentActivity*/.onResume();
        ActivityAgent.onTrace("com.dragon.read.mgl.service.view.BdpTransferActivity", "onResume", false);
    }

    public void onStart() {
        ActivityAgent.onTrace("com.dragon.read.mgl.service.view.BdpTransferActivity", "onStart", true);
        super.onStart();
        ActivityAgent.onTrace("com.dragon.read.mgl.service.view.BdpTransferActivity", "onStart", false);
    }

    protected void onStop() {
        c2(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onWindowFocusChanged(boolean z) {
        ActivityAgent.onTrace("com.dragon.read.mgl.service.view.BdpTransferActivity", "onWindowFocusChanged", true);
        super/*android.app.Activity*/.onWindowFocusChanged(z);
    }

    public void startActivity(Intent intent, Bundle bundle) {
        d2(this, intent, bundle);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Map<String, String> b2() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("channel", SingleAppContext.inst(getApplicationContext()).getChannel());
        linkedHashMap.put("iid", DeviceRegisterManager.getInstallId());
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void f2() {
        k2();
        final String stringExtra = getIntent().getStringExtra("schema");
        final String stringExtra2 = getIntent().getStringExtra("appId");
        if (getIntent().getBooleanExtra("openInPost", false)) {
            BdpPool.runOnMain(new Runnable() { // from class: es4.a
                @Override // java.lang.Runnable
                public final void run() {
                    BdpTransferActivity.h2(BdpTransferActivity.this, stringExtra, stringExtra2);
                }
            });
        } else {
            e2(stringExtra, stringExtra2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void k2() {
        if (getResources().getConfiguration().orientation == 2) {
            ActivityUtil.setFullScreen(this);
            if (Build.VERSION.SDK_INT >= 28) {
                WindowManager.LayoutParams attributes = getWindow().getAttributes();
                attributes.layoutInDisplayCutoutMode = 1;
                getWindow().setAttributes(attributes);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void finish() {
        BdpLogger.i("BdpTransferActivity", new Object[]{"finish at " + System.currentTimeMillis()});
        super/*android.app.Activity*/.finish();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initTranslucentStatusBar() {
        int i;
        getWindow().setSoftInputMode(3);
        int i2 = Build.VERSION.SDK_INT;
        getWindow().addFlags(Integer.MIN_VALUE);
        getWindow().setStatusBarColor(Color.parseColor("#00000000"));
        if (i2 >= 23) {
            i = 9216;
        } else {
            i = 1024;
        }
        getWindow().getDecorView().setSystemUiVisibility(i);
        if (i2 >= 28) {
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.layoutInDisplayCutoutMode = 1;
            getWindow().setAttributes(attributes);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        BdpLogger.i("BdpTransferActivity", new Object[]{"onDestroy at " + System.currentTimeMillis()});
        if (this.a == 11) {
            TTCJPayUtils.Companion.getInstance().setObserver((TTCJPayObserver) null);
        }
        BdpManager.getInst().getService(BdpAwemeService.class).setIsCanShowShareFlow(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void j2() {
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("sdkInfo");
        int intExtra = intent.getIntExtra("service", 0);
        String stringExtra2 = intent.getStringExtra("subway");
        String stringExtra3 = intent.getStringExtra("ext");
        String stringExtra4 = intent.getStringExtra("referer");
        String stringExtra5 = intent.getStringExtra("event_ext");
        this.b = new LinkedHashMap();
        if (!TextUtils.isEmpty(stringExtra5)) {
            try {
                JSONObject jSONObject = new JSONObject(stringExtra5);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    Map<String, String> map = this.b;
                    if (map != null) {
                        Intrinsics.checkNotNull(next);
                        map.put(next, jSONObject.opt(next).toString());
                    }
                }
            } catch (Exception e2) {
                BdpLogger.e("BdpTransferActivity", new Object[]{"parse event ext error", e2});
            }
        }
        TTCJPayUtils.Companion.getInstance().setContext(this).setAid(String.valueOf(SingleAppContext.inst(getApplicationContext()).getAid())).setDid(DeviceRegisterManager.getDeviceId()).setRiskInfoParams(b2()).setObserver(this.f).pay(stringExtra, intExtra, stringExtra2, stringExtra4, stringExtra3, new e());
    }

    public static final class b implements JsEventSubscriber {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit e(BdpTransferActivity bdpTransferActivity) {
            FrameLayout frameLayout = bdpTransferActivity.e;
            if (frameLayout != null) {
                frameLayout.removeView(bdpTransferActivity.d);
            }
            return Unit.INSTANCE;
        }

        public void onReceiveJsEvent(Js2NativeEvent jsEvent) {
            String str;
            Intrinsics.checkNotNullParameter(jsEvent, "jsEvent");
            boolean z = true;
            Object[] objArr = new Object[1];
            StringBuilder sb = new StringBuilder();
            sb.append("receive event changeOrientation,orientation=");
            XReadableMap params = jsEvent.getParams();
            String str2 = null;
            if (params != null) {
                str = params.getString("orientation");
            } else {
                str = null;
            }
            sb.append(str);
            objArr[0] = sb.toString();
            BdpLogger.i("BdpTransferActivity", objArr);
            XReadableMap params2 = jsEvent.getParams();
            if (params2 != null) {
                str2 = params2.getString("orientation");
            }
            boolean areEqual = Intrinsics.areEqual("portrait", str2);
            XReadableMap params3 = jsEvent.getParams();
            if (params3 == null || !params3.getBoolean("needLoadingBg")) {
                z = false;
            }
            if (z) {
                final BdpTransferActivity bdpTransferActivity = BdpTransferActivity.this;
                final int i = areEqual ? 1 : 0;
                BdpPool.runOnMain(new Runnable() { // from class: es4.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        BdpTransferActivity.b.d(BdpTransferActivity.this, i);
                    }
                });
            } else {
                final BdpTransferActivity bdpTransferActivity2 = BdpTransferActivity.this;
                final int i2 = areEqual ? 1 : 0;
                BdpPool.runOnMain(new Runnable() { // from class: es4.g
                    @Override // java.lang.Runnable
                    public final void run() {
                        BdpTransferActivity.b.f(BdpTransferActivity.this, i2);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public static final void f(BdpTransferActivity bdpTransferActivity, int i) {
            if (bdpTransferActivity.d != null) {
                FrameLayout frameLayout = bdpTransferActivity.e;
                if (frameLayout != null) {
                    frameLayout.removeView(bdpTransferActivity.d);
                }
                bdpTransferActivity.d = null;
                bdpTransferActivity.setRequestedOrientation(i);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public static final void d(final BdpTransferActivity bdpTransferActivity, int i) {
            bdpTransferActivity.d = new j(bdpTransferActivity, bdpTransferActivity.getIntent().getStringExtra("appName"), bdpTransferActivity.getIntent().getStringExtra("appIcon"));
            j jVar = bdpTransferActivity.d;
            if (jVar != null) {
                jVar.setOnClickListener(new Function0() { // from class: es4.h
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit e;
                        e = BdpTransferActivity.b.e(BdpTransferActivity.this);
                        return e;
                    }
                });
            }
            FrameLayout frameLayout = bdpTransferActivity.e;
            if (frameLayout != null) {
                frameLayout.addView(bdpTransferActivity.d);
            }
            bdpTransferActivity.setRequestedOrientation(i);
        }
    }

    public static final class d implements TTCJPayObserver {
        public void onMonitor(String serviceName, int i, JSONObject logExtr) {
            Intrinsics.checkNotNullParameter(serviceName, "serviceName");
            Intrinsics.checkNotNullParameter(logExtr, "logExtr");
        }

        public void onPayCallback(TTCJPayResult result) {
            Intrinsics.checkNotNullParameter(result, "result");
        }

        public void onWebViewInit(WeakReference<WebView> webViewRef) {
            Intrinsics.checkNotNullParameter(webViewRef, "webViewRef");
        }

        d() {
        }

        public void onEvent(String str, Map<String, String> map) {
            Map map2;
            if (str != null) {
                if (map != null && (map2 = BdpTransferActivity.this.b) != null) {
                    map2.putAll(map);
                }
                Map map3 = BdpTransferActivity.this.b;
                if (map3 == null) {
                    map3 = MapsKt__MapsKt.emptyMap();
                }
                AppLogNewUtils.onEventV3(str, new JSONObject(map3));
            }
        }
    }

    public static final class e implements IH5PayCallback {
        e() {
        }

        public void onResult(int i, String str) {
            Intent intent = new Intent();
            intent.putExtra("code", i);
            intent.putExtra("msg", str);
            BdpTransferActivity.this.setResult(0, intent);
            TTCJPayUtils.Companion.getInstance().closeSDK();
            BdpTransferActivity.this.finish();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void c2(BdpTransferActivity bdpTransferActivity) {
        bdpTransferActivity.U1();
        if (EnterTransitionCrashOptimizer.getContext() != null) {
            try {
                bdpTransferActivity.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();
            } catch (Throwable unused) {
            }
        }
    }

    public static final class c extends IBulletUILifecycleListener.Base {
        final /* synthetic */ String a;
        final /* synthetic */ String b;
        final /* synthetic */ BdpTransferActivity c;
        final /* synthetic */ JsEventSubscriber d;

        public void onOpen(IBulletUIComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
        }

        public void onClose(IBulletUIComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            BdpLogger.i("BdpTransferActivity", new Object[]{"onLynxViewClose"});
            JsEventSubscriber jsEventSubscriber = this.d;
            if (jsEventSubscriber != null) {
                EventCenter.unregisterJsEventSubscriber("changeOrientation", jsEventSubscriber);
            }
            this.c.finish();
            EventCenter.enqueueEvent(new Event("onLynxViewPopupClose", System.currentTimeMillis(), new DefaultXReadableMapImpl(new JSONObject())));
        }

        public void onLoadSuccess(IBulletUIComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            if (this.a != null) {
                BdpManager.getInst().getService(BdpOpenSchemaTimelineManageService.class).addTimelineData(this.b, this.a, "mg_android_bullet_sdk_load_success", System.currentTimeMillis());
            }
            this.c.setResult(0);
        }

        public void onLoadFailed(IBulletUIComponent iBulletUIComponent, Throwable throwable) {
            Intrinsics.checkNotNullParameter(throwable, "throwable");
            BdpLogger.i("BdpTransferActivity", new Object[]{"onLynxViewClose"});
            JsEventSubscriber jsEventSubscriber = this.d;
            if (jsEventSubscriber != null) {
                EventCenter.unregisterJsEventSubscriber("changeOrientation", jsEventSubscriber);
            }
            Intent intent = new Intent();
            intent.putExtra("errMsg", throwable.getMessage());
            this.c.setResult(2, intent);
            this.c.finish();
            EventCenter.enqueueEvent(new Event("onLynxViewPopupClose", System.currentTimeMillis(), new DefaultXReadableMapImpl(new JSONObject())));
        }

        c(String str, String str2, BdpTransferActivity bdpTransferActivity, JsEventSubscriber jsEventSubscriber) {
            this.a = str;
            this.b = str2;
            this.c = bdpTransferActivity;
            this.d = jsEventSubscriber;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        BdpLogger.i("BdpTransferActivity", new Object[]{"onConfigurationChanged"});
        j jVar = this.d;
        if (jVar != null && newConfig.orientation == 2) {
            FrameLayout frameLayout = this.e;
            if (frameLayout != null) {
                frameLayout.removeView(jVar);
            }
            this.d = null;
            setRequestedOrientation(0);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(Bundle bundle) {
        ActivityAgent.onTrace("com.dragon.read.mgl.service.view.BdpTransferActivity", "onCreate", true);
        super/*androidx.fragment.app.FragmentActivity*/.onCreate(bundle);
        View decorView = getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "getDecorView(...)");
        decorView.setSystemUiVisibility(3846);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        getWindow().setFlags(MediaPlayer.MEDIA_PLAYER_OPTION_APPID, MediaPlayer.MEDIA_PLAYER_OPTION_APPID);
        getWindow().addFlags(67108864);
        getWindow().addFlags(134217728);
        getWindow().addFlags(1024);
        FrameLayout frameLayout = new FrameLayout(this);
        this.e = frameLayout;
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        setContentView(this.e);
        int intExtra = getIntent().getIntExtra("proxy_type", 0);
        this.a = intExtra;
        if (intExtra == 2) {
            f2();
        } else if (intExtra == 11) {
            initTranslucentStatusBar();
            j2();
        }
        BdpManager.getInst().getService(BdpAwemeService.class).setIsCanShowShareFlow(false);
        ActivityAgent.onTrace("com.dragon.read.mgl.service.view.BdpTransferActivity", "onCreate", false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void e2(String str, String str2) {
        boolean contains$default;
        boolean z = false;
        b bVar = null;
        if (str != null) {
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "game_cashier", false, 2, (Object) null);
            if (contains$default) {
                z = true;
            }
        }
        if (z) {
            this.c = true;
            bVar = new b();
            EventCenter.registerJsEventSubscriber("changeOrientation", bVar);
        }
        if (!TextUtils.isEmpty(str)) {
            String queryParameter = Uri.parse(str).getQueryParameter("container_event_extra_id");
            if (queryParameter != null) {
                BdpManager.getInst().getService(BdpOpenSchemaTimelineManageService.class).addTimelineData(str2, queryParameter, "mg_android_bdp_transfer_activity_oncreate", System.currentTimeMillis());
            }
            RouterOpenConfig routerOpenConfig = new RouterOpenConfig();
            routerOpenConfig.setUiLifecycleListener(new c(queryParameter, str2, this, bVar));
            BulletSdk bulletSdk = BulletSdk.INSTANCE;
            Uri parse = Uri.parse(str);
            Intrinsics.checkNotNullExpressionValue(parse, "parse(...)");
            bulletSdk.open(this, parse, routerOpenConfig, "default_bid");
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("errMsg", "empty schema");
        setResult(2, intent);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(611986);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void i(BdpActivityResultRequest bdpActivityResultRequest, Intent intent, BdpActivityResultRequest.Callback callback) {
            bdpActivityResultRequest.startForResult(intent, callback);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(Function2 function2, int i, int i2, Intent intent) {
            if (function2 != null) {
                String str = null;
                if (i2 == 0) {
                    function2.invoke(Boolean.TRUE, null);
                    return;
                }
                if (intent != null) {
                    str = intent.getStringExtra("errMsg");
                }
                function2.invoke(Boolean.FALSE, str);
            }
        }

        private final void h(Activity activity, final Intent intent, int i, final BdpActivityResultRequest.Callback callback) {
            intent.setClass(activity, BdpTransferActivity.class);
            intent.putExtra("proxy_type", i);
            final BdpActivityResultRequest bdpActivityResultRequest = new BdpActivityResultRequest(activity);
            BdpPool.postMain(new Runnable() { // from class: es4.e
                @Override // java.lang.Runnable
                public final void run() {
                    BdpTransferActivity.a.i(bdpActivityResultRequest, intent, callback);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void g(RequestLynxPaymentCallback requestLynxPaymentCallback, int i, int i2, Intent intent) {
            if (requestLynxPaymentCallback != null) {
                if (i2 != 0) {
                    if (i2 != 2) {
                        requestLynxPaymentCallback.onFailed(-1, "unknown");
                        return;
                    }
                    String str = "pay failed";
                    if (intent != null) {
                        String stringExtra = intent.getStringExtra("msg");
                        if (!TextUtils.isEmpty(stringExtra)) {
                            str = stringExtra;
                        }
                        requestLynxPaymentCallback.onFailed(i2, str);
                        return;
                    }
                    requestLynxPaymentCallback.onFailed(i2, "pay failed");
                    return;
                }
                if (intent != null) {
                    requestLynxPaymentCallback.onSuccess(intent.getIntExtra("code", -1), intent.getStringExtra("msg"));
                } else {
                    requestLynxPaymentCallback.onSuccess(4, "支付取消");
                }
            }
        }

        public final void d(Activity activity, String str, String str2, JSONObject jSONObject, final Function2<? super Boolean, ? super String, Unit> function2) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intent intent = new Intent();
            intent.putExtra("schema", str);
            intent.putExtra("appId", str2);
            if (jSONObject != null) {
                intent.putExtra("openInPost", jSONObject.optBoolean("openInPost", false));
                intent.putExtra("isLandscape", jSONObject.optBoolean("isLandscape", false));
                intent.putExtra("appIcon", jSONObject.optString("appIcon"));
                intent.putExtra("appName", jSONObject.optString("appName"));
            }
            h(activity, intent, 2, new BdpActivityResultRequest.Callback() { // from class: es4.c
                public final void onActivityResult(int i, int i2, Intent intent2) {
                    BdpTransferActivity.a.e(Function2.this, i, i2, intent2);
                }
            });
        }

        public final void f(Activity activity, String str, int i, String str2, String str3, String str4, final RequestLynxPaymentCallback requestLynxPaymentCallback) {
            boolean z;
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intent intent = new Intent();
            intent.putExtra("sdkInfo", str);
            intent.putExtra("service", i);
            intent.putExtra("subway", str2);
            intent.putExtra("ext", str3);
            intent.putExtra("referer", str4);
            if (!ProcessUtil.isMiniAppProcess(activity) && !ProcessUtil.isMiniGameProcess(activity)) {
                z = false;
            } else {
                z = true;
            }
            intent.putExtra("isMiniAppProcess", z);
            if (requestLynxPaymentCallback != null) {
                intent.putExtra("event_ext", requestLynxPaymentCallback.getMiniGameEventCommonParams().toString());
            }
            intent.setFlags(536870912);
            h(activity, intent, 11, new BdpActivityResultRequest.Callback() { // from class: es4.d
                public final void onActivityResult(int i2, int i3, Intent intent2) {
                    BdpTransferActivity.a.g(requestLynxPaymentCallback, i2, i3, intent2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i2(BdpTransferActivity bdpTransferActivity, String str, String str2) {
        bdpTransferActivity.e2(str, str2);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "startActivity")
    public static void d2(BdpTransferActivity bdpTransferActivity, Intent intent, Bundle bundle) {
        al2.a.a.i("startActivity-aop", new Object[0]);
        if (NsAdApi.IMPL.interceptQuickApp(intent)) {
            return;
        }
        bdpTransferActivity.V1(intent, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void h2(final BdpTransferActivity bdpTransferActivity, final String str, final String str2) {
        bdpTransferActivity.getWindow().getDecorView().post(new Runnable() { // from class: es4.b
            @Override // java.lang.Runnable
            public final void run() {
                BdpTransferActivity.i2(BdpTransferActivity.this, str, str2);
            }
        });
    }
}
