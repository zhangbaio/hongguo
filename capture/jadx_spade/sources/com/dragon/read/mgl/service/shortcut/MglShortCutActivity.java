package com.dragon.read.mgl.service.shortcut;

import al2.a;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.bytedance.apm.agent.v2.instrumentation.ActivityAgent;
import com.bytedance.covode.number.Covode;
import com.bytedance.minigame.bdpbase.schema.SchemaInfo;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.dragon.read.component.biz.api.NsAdApi;
import com.dragon.read.plugin.common.host.IRouterService;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class MglShortCutActivity extends AppCompatActivity {
    public static final int a;

    static {
        Covode.recordClassIndex(611983);
        a = 8;
    }

    public void S1() {
        super.onStop();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void T1(Intent intent, Bundle bundle) {
        super/*android.app.Activity*/.startActivity(intent, bundle);
    }

    public void onResume() {
        ActivityAgent.onTrace("com.dragon.read.mgl.service.shortcut.MglShortCutActivity", "onResume", true);
        super/*androidx.fragment.app.FragmentActivity*/.onResume();
        ActivityAgent.onTrace("com.dragon.read.mgl.service.shortcut.MglShortCutActivity", "onResume", false);
    }

    public void onStart() {
        ActivityAgent.onTrace("com.dragon.read.mgl.service.shortcut.MglShortCutActivity", "onStart", true);
        super.onStart();
        ActivityAgent.onTrace("com.dragon.read.mgl.service.shortcut.MglShortCutActivity", "onStart", false);
    }

    protected void onStop() {
        U1(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onWindowFocusChanged(boolean z) {
        ActivityAgent.onTrace("com.dragon.read.mgl.service.shortcut.MglShortCutActivity", "onWindowFocusChanged", true);
        super/*android.app.Activity*/.onWindowFocusChanged(z);
    }

    public void startActivity(Intent intent, Bundle bundle) {
        V1(this, intent, bundle);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void U1(MglShortCutActivity mglShortCutActivity) {
        mglShortCutActivity.S1();
        if (EnterTransitionCrashOptimizer.getContext() != null) {
            try {
                mglShortCutActivity.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void X1(Intent intent) {
        Uri data;
        if (intent == null || (data = intent.getData()) == null) {
            return;
        }
        Uri build = data.buildUpon().build();
        Intent intent2 = new Intent();
        intent2.setAction("android.intent.action.VIEW");
        intent2.addCategory("android.intent.category.DEFAULT");
        intent2.addCategory("android.intent.category.BROWSABLE");
        intent2.setData(build);
        startActivity(intent2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(Bundle bundle) {
        String str;
        SchemaInfo parse;
        ActivityAgent.onTrace("com.dragon.read.mgl.service.shortcut.MglShortCutActivity", "onCreate", true);
        super/*androidx.fragment.app.FragmentActivity*/.onCreate(bundle);
        try {
            SchemaInfo.Companion companion = SchemaInfo.Companion;
            Uri data = getIntent().getData();
            if (data != null) {
                str = data.toString();
            } else {
                str = null;
            }
            parse = companion.parse(str);
        } catch (Exception unused) {
        } catch (Throwable th) {
            finish();
            ActivityAgent.onTrace("com.dragon.read.mgl.service.shortcut.MglShortCutActivity", "onCreate", false);
            throw th;
        }
        if (parse != null) {
            ((IRouterService) ServiceManager.getService(IRouterService.class)).openScheme(this, parse.toSchema());
            finish();
            ActivityAgent.onTrace("com.dragon.read.mgl.service.shortcut.MglShortCutActivity", "onCreate", false);
        } else {
            X1(getIntent());
            finish();
            ActivityAgent.onTrace("com.dragon.read.mgl.service.shortcut.MglShortCutActivity", "onCreate", false);
        }
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "startActivity")
    public static void V1(MglShortCutActivity mglShortCutActivity, Intent intent, Bundle bundle) {
        a.a.i("startActivity-aop", new Object[0]);
        if (NsAdApi.IMPL.interceptQuickApp(intent)) {
            return;
        }
        mglShortCutActivity.T1(intent, bundle);
    }
}
