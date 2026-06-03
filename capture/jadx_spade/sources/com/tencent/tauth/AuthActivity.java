package com.tencent.tauth;

import al2.a;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.apm.agent.v2.instrumentation.ActivityAgent;
import com.bytedance.covode.number.Covode;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.dragon.read.app.PrivacyMgr;
import com.dragon.read.component.biz.api.NsAdApi;
import com.tencent.connect.common.AssistActivity;
import com.tencent.connect.common.UIListenerManager;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.k;
import com.tencent.open.utils.m;
import java.util.HashMap;
import java.util.Map;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class AuthActivity extends Activity {
    private static int a;
    private Map<String, ActionHandler> b = new HashMap();

    interface ActionHandler {
        void handleAction(Activity activity, Bundle bundle);
    }

    public void AuthActivity__onStop$___twin___() {
        super.onStop();
    }

    public void AuthActivity__startActivity$___twin___(Intent intent, Bundle bundle) {
        super.startActivity(intent, bundle);
    }

    @Override // android.app.Activity
    public void onResume() {
        ActivityAgent.onTrace("com.tencent.tauth.AuthActivity", "onResume", true);
        super.onResume();
        ActivityAgent.onTrace("com.tencent.tauth.AuthActivity", "onResume", false);
    }

    @Override // android.app.Activity
    public void onStart() {
        ActivityAgent.onTrace("com.tencent.tauth.AuthActivity", "onStart", true);
        super.onStart();
        ActivityAgent.onTrace("com.tencent.tauth.AuthActivity", "onStart", false);
    }

    @Override // android.app.Activity
    protected void onStop() {
        com_tencent_tauth_AuthActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        ActivityAgent.onTrace("com.tencent.tauth.AuthActivity", "onWindowFocusChanged", true);
        super.onWindowFocusChanged(z);
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent, Bundle bundle) {
        com_tencent_tauth_AuthActivity_com_dragon_read_aop_ActivityAop_startActivity(this, intent, bundle);
    }

    static {
        Covode.recordClassIndex(653576);
        a = 0;
    }

    private void a() {
        this.b.put("action_common_channel", new ActionHandler() { // from class: com.tencent.tauth.AuthActivity.1
            @Override // com.tencent.tauth.AuthActivity.ActionHandler
            public void handleAction(Activity activity, Bundle bundle) {
                SLog.i("openSDK_LOG.AuthActivity", "-->handleActionUri--common channel. ");
                Intent intent = new Intent(activity, (Class<?>) AssistActivity.class);
                intent.putExtras(bundle);
                intent.putExtra("key_request_code", 10114);
                intent.setFlags(603979776);
                AuthActivity.this.startActivity(intent);
                AuthActivity.this.finish();
            }
        });
    }

    @Override // android.app.Activity
    public void finish() {
        try {
            super.finish();
        } catch (Exception e) {
            SLog.e("openSDK_LOG.AuthActivity", "activity finish exception: ", e);
        }
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_tencent_tauth_AuthActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(AuthActivity authActivity) {
        authActivity.AuthActivity__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() != null) {
            try {
                authActivity.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();
            } catch (Throwable unused) {
            }
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        Uri uri;
        ActivityAgent.onTrace("com.tencent.tauth.AuthActivity", "onCreate", true);
        super.onCreate(bundle);
        if (getIntent() == null) {
            SLog.w("openSDK_LOG.AuthActivity", "-->onCreate, getIntent() return null");
            finish();
            ActivityAgent.onTrace("com.tencent.tauth.AuthActivity", "onCreate", false);
            return;
        }
        try {
            uri = getIntent().getData();
        } catch (Exception e) {
            SLog.e("openSDK_LOG.AuthActivity", "onCreate exception: ", e);
            uri = null;
        }
        SLog.v("openSDK_LOG.AuthActivity", "-->onCreate, uri: " + uri);
        a();
        try {
            a(uri);
        } catch (Exception e2) {
            SLog.e("openSDK_LOG.AuthActivity", "onCreate exception: ", e2);
            finish();
        }
        ActivityAgent.onTrace("com.tencent.tauth.AuthActivity", "onCreate", false);
    }

    private void a(Uri uri) {
        SLog.i("openSDK_LOG.AuthActivity", "-->handleActionUri--start");
        if (uri != null && uri.toString() != null) {
            String str = "";
            if (!uri.toString().equals("")) {
                String uri2 = uri.toString();
                Bundle a2 = m.a(uri2.substring(uri2.indexOf("#") + 1));
                if (a2 == null) {
                    SLog.w("openSDK_LOG.AuthActivity", "-->handleActionUri, bundle is null");
                    finish();
                    return;
                }
                String string = a2.getString("action");
                SLog.i("openSDK_LOG.AuthActivity", "-->handleActionUri, action: " + string);
                if (string == null) {
                    finish();
                    return;
                }
                if (!string.equals("shareToQQ") && !string.equals("shareToQzone") && !string.equals("sendToMyComputer") && !string.equals("shareToTroopBar")) {
                    if (string.equals("addToQQFavorites")) {
                        Intent intent = getIntent();
                        intent.putExtras(a2);
                        intent.putExtra("key_action", "action_share");
                        IUiListener listnerWithAction = UIListenerManager.getInstance().getListnerWithAction(string);
                        if (listnerWithAction != null) {
                            UIListenerManager.getInstance().handleDataToListener(intent, listnerWithAction);
                        }
                        finish();
                        return;
                    }
                    if (string.equals("sharePrize")) {
                        Intent INVOKEVIRTUAL_com_tencent_tauth_AuthActivity_com_dragon_read_base_lancet_PrivacyAop_getLaunchIntentForPackage = INVOKEVIRTUAL_com_tencent_tauth_AuthActivity_com_dragon_read_base_lancet_PrivacyAop_getLaunchIntentForPackage(getPackageManager(), getPackageName());
                        try {
                            str = m.d(a2.getString("response")).getString("activityid");
                        } catch (Exception e) {
                            SLog.e("openSDK_LOG.AuthActivity", "sharePrize parseJson has exception.", e);
                        }
                        if (!TextUtils.isEmpty(str)) {
                            INVOKEVIRTUAL_com_tencent_tauth_AuthActivity_com_dragon_read_base_lancet_PrivacyAop_getLaunchIntentForPackage.putExtra("sharePrize", true);
                            Bundle bundle = new Bundle();
                            bundle.putString("activityid", str);
                            INVOKEVIRTUAL_com_tencent_tauth_AuthActivity_com_dragon_read_base_lancet_PrivacyAop_getLaunchIntentForPackage.putExtras(bundle);
                        }
                        startActivity(INVOKEVIRTUAL_com_tencent_tauth_AuthActivity_com_dragon_read_base_lancet_PrivacyAop_getLaunchIntentForPackage);
                        finish();
                        return;
                    }
                    if (string.equals("sdkSetAvatar")) {
                        boolean booleanExtra = getIntent().getBooleanExtra("stay_back_stack", false);
                        Intent intent2 = new Intent(this, (Class<?>) AssistActivity.class);
                        intent2.putExtra("key_request_code", 10108);
                        intent2.putExtra("stay_back_stack", booleanExtra);
                        intent2.putExtras(a2);
                        intent2.setFlags(603979776);
                        startActivity(intent2);
                        finish();
                        return;
                    }
                    if ("sdkSetDynamicAvatar".equals(string)) {
                        boolean booleanExtra2 = getIntent().getBooleanExtra("stay_back_stack", false);
                        Intent intent3 = new Intent(this, (Class<?>) AssistActivity.class);
                        intent3.putExtra("key_request_code", 10110);
                        intent3.putExtra("stay_back_stack", booleanExtra2);
                        intent3.putExtras(a2);
                        intent3.setFlags(603979776);
                        startActivity(intent3);
                        finish();
                        return;
                    }
                    if (string.equals("sdkSetEmotion")) {
                        boolean booleanExtra3 = getIntent().getBooleanExtra("stay_back_stack", false);
                        Intent intent4 = new Intent(this, (Class<?>) AssistActivity.class);
                        intent4.putExtra("key_request_code", 10109);
                        intent4.putExtra("stay_back_stack", booleanExtra3);
                        intent4.putExtras(a2);
                        intent4.setFlags(603979776);
                        startActivity(intent4);
                        finish();
                        return;
                    }
                    if (string.equals("bindGroup")) {
                        SLog.i("openSDK_LOG.AuthActivity", "-->handleActionUri--bind group callback.");
                        boolean booleanExtra4 = getIntent().getBooleanExtra("stay_back_stack", false);
                        Intent intent5 = new Intent(this, (Class<?>) AssistActivity.class);
                        intent5.putExtra("key_request_code", 10112);
                        intent5.putExtra("stay_back_stack", booleanExtra4);
                        intent5.putExtras(a2);
                        intent5.setFlags(603979776);
                        startActivity(intent5);
                        finish();
                        return;
                    }
                    if (string.equals("joinGroup")) {
                        SLog.i("openSDK_LOG.AuthActivity", "-->handleActionUri--join group callback. ");
                        boolean booleanExtra5 = getIntent().getBooleanExtra("stay_back_stack", false);
                        Intent intent6 = new Intent(this, (Class<?>) AssistActivity.class);
                        intent6.putExtra("key_request_code", 10111);
                        intent6.putExtra("stay_back_stack", booleanExtra5);
                        intent6.putExtras(a2);
                        intent6.setFlags(603979776);
                        startActivity(intent6);
                        finish();
                        return;
                    }
                    if ("guildOpen".equals(string)) {
                        Intent intent7 = new Intent(this, (Class<?>) AssistActivity.class);
                        intent7.putExtras(a2);
                        intent7.putExtra("key_request_code", 10113);
                        intent7.setFlags(603979776);
                        startActivity(intent7);
                        finish();
                        return;
                    }
                    ActionHandler actionHandler = this.b.get(string);
                    if (actionHandler != null) {
                        actionHandler.handleAction(this, a2);
                        return;
                    } else {
                        finish();
                        return;
                    }
                }
                if (string.equals("shareToQzone") && k.a((Context) this, "com.tencent.mobileqq") != null && k.c(this, "5.2.0") < 0) {
                    int i = a + 1;
                    a = i;
                    if (i == 2) {
                        a = 0;
                        finish();
                        return;
                    }
                }
                SLog.i("openSDK_LOG.AuthActivity", "-->handleActionUri, most share action, start assistactivity");
                Intent intent8 = new Intent(this, (Class<?>) AssistActivity.class);
                intent8.putExtras(a2);
                intent8.setFlags(603979776);
                startActivity(intent8);
                finish();
                return;
            }
        }
        SLog.w("openSDK_LOG.AuthActivity", "-->handleActionUri, uri invalid");
        finish();
    }

    @Proxy("getLaunchIntentForPackage")
    @TargetClass("android.content.pm.PackageManager")
    public static Intent INVOKEVIRTUAL_com_tencent_tauth_AuthActivity_com_dragon_read_base_lancet_PrivacyAop_getLaunchIntentForPackage(PackageManager packageManager, String str) {
        if (PrivacyMgr.inst().hasConfirmedAndNotBasic()) {
            return packageManager.getLaunchIntentForPackage(str);
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.phoenix.read", "com.dragon.read.pages.splash.SplashActivity"));
        return intent;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "startActivity")
    public static void com_tencent_tauth_AuthActivity_com_dragon_read_aop_ActivityAop_startActivity(AuthActivity authActivity, Intent intent, Bundle bundle) {
        a.a.i("startActivity-aop", new Object[0]);
        if (NsAdApi.IMPL.interceptQuickApp(intent)) {
            return;
        }
        authActivity.AuthActivity__startActivity$___twin___(intent, bundle);
    }
}
