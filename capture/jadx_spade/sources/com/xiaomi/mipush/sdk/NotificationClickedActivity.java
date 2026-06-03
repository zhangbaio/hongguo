package com.xiaomi.mipush.sdk;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import com.bytedance.apm.agent.v2.instrumentation.ActivityAgent;
import com.bytedance.covode.number.Covode;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.dragon.read.component.biz.api.NsAdApi;
import com.ss.android.ugc.bytex.taskmonitor.proxy.HandlerDelegate;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class NotificationClickedActivity extends Activity {
    private BroadcastReceiver a;

    /* renamed from: a, reason: collision with other field name */
    private Handler f38a;

    static {
        Covode.recordClassIndex(655285);
    }

    public void NotificationClickedActivity__onStop$___twin___() {
        super.onStop();
    }

    public void NotificationClickedActivity__startActivity$___twin___(Intent intent, Bundle bundle) {
        super.startActivity(intent, bundle);
    }

    @Override // android.app.Activity
    public void onStart() {
        ActivityAgent.onTrace("com.xiaomi.mipush.sdk.NotificationClickedActivity", "onStart", true);
        super.onStart();
        ActivityAgent.onTrace("com.xiaomi.mipush.sdk.NotificationClickedActivity", "onStart", false);
    }

    @Override // android.app.Activity
    protected void onStop() {
        com_xiaomi_mipush_sdk_NotificationClickedActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        ActivityAgent.onTrace("com.xiaomi.mipush.sdk.NotificationClickedActivity", "onWindowFocusChanged", true);
        super.onWindowFocusChanged(z);
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent, Bundle bundle) {
        com_xiaomi_mipush_sdk_NotificationClickedActivity_com_dragon_read_aop_ActivityAop_startActivity(this, intent, bundle);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.f38a.removeCallbacksAndMessages(null);
        try {
            INVOKEVIRTUAL_com_xiaomi_mipush_sdk_NotificationClickedActivity_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver(this, this.a);
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        ActivityAgent.onTrace("com.xiaomi.mipush.sdk.NotificationClickedActivity", "onResume", true);
        super.onResume();
        a(getIntent());
        ActivityAgent.onTrace("com.xiaomi.mipush.sdk.NotificationClickedActivity", "onResume", false);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_xiaomi_mipush_sdk_NotificationClickedActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(NotificationClickedActivity notificationClickedActivity) {
        notificationClickedActivity.NotificationClickedActivity__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() != null) {
            try {
                notificationClickedActivity.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();
            } catch (Throwable unused) {
            }
        }
    }

    private void a(Intent intent) {
        try {
            if (intent != null) {
                Intent intent2 = (Intent) intent.getParcelableExtra("mipush_serviceIntent");
                if (intent2 != null) {
                    intent2.setComponent(new ComponentName(getPackageName(), "com.xiaomi.mipush.sdk.PushMessageHandler"));
                    intent2.putExtra("is_clicked_activity_call", true);
                    com.xiaomi.channel.commonutils.logger.b.m55a("PushClickedActivity", "clicked activity start service.");
                    startService(intent2);
                } else {
                    com.xiaomi.channel.commonutils.logger.b.d("PushClickedActivity", "clicked activity start service, newIntent is null");
                }
            } else {
                com.xiaomi.channel.commonutils.logger.b.d("PushClickedActivity", "clicked activity start service, missing intent");
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        ActivityAgent.onTrace("com.xiaomi.mipush.sdk.NotificationClickedActivity", "onCreate", true);
        super.onCreate(bundle);
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.height = 1;
        attributes.width = 1;
        attributes.gravity = 8388659;
        window.setAttributes(attributes);
        HandlerDelegate handlerDelegate = new HandlerDelegate();
        this.f38a = handlerDelegate;
        handlerDelegate.postDelayed(new Runnable() { // from class: com.xiaomi.mipush.sdk.NotificationClickedActivity.1
            @Override // java.lang.Runnable
            public void run() {
                com.xiaomi.channel.commonutils.logger.b.e("clicked activity finish by timeout.");
                NotificationClickedActivity.this.finish();
            }
        }, 3000L);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("action_clicked_activity_finish");
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.xiaomi.mipush.sdk.NotificationClickedActivity.2
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                com.xiaomi.channel.commonutils.logger.b.b("clicked activity finish by normal.");
                NotificationClickedActivity.this.finish();
            }
        };
        this.a = broadcastReceiver;
        try {
            com.xiaomi.push.l.a(this, broadcastReceiver, intentFilter, c.a(this), null, 4);
        } catch (Exception unused) {
        }
        ActivityAgent.onTrace("com.xiaomi.mipush.sdk.NotificationClickedActivity", "onCreate", false);
    }

    @Proxy("unregisterReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    public static void INVOKEVIRTUAL_com_xiaomi_mipush_sdk_NotificationClickedActivity_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver(NotificationClickedActivity notificationClickedActivity, BroadcastReceiver broadcastReceiver) {
        ReceiverRegisterLancet.loge(broadcastReceiver, false);
        notificationClickedActivity.unregisterReceiver(broadcastReceiver);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "startActivity")
    public static void com_xiaomi_mipush_sdk_NotificationClickedActivity_com_dragon_read_aop_ActivityAop_startActivity(NotificationClickedActivity notificationClickedActivity, Intent intent, Bundle bundle) {
        al2.a.a.i("startActivity-aop", new Object[0]);
        if (NsAdApi.IMPL.interceptQuickApp(intent)) {
            return;
        }
        notificationClickedActivity.NotificationClickedActivity__startActivity$___twin___(intent, bundle);
    }
}
