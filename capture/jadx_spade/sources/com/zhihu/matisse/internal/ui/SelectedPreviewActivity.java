package com.zhihu.matisse.internal.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.bytedance.apm.agent.v2.instrumentation.ActivityAgent;
import com.bytedance.covode.number.Covode;
import com.bytedance.sysoptimizer.BadParcelableCrashOptimizer;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.dragon.read.component.biz.api.NsAdApi;
import com.zhihu.matisse.internal.entity.Item;
import java.util.ArrayList;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class SelectedPreviewActivity extends a {
    static {
        Covode.recordClassIndex(656136);
    }

    public void f2() {
        super.onStop();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void h2(Intent intent, Bundle bundle) {
        super/*android.app.Activity*/.startActivity(intent, bundle);
    }

    public void onResume() {
        ActivityAgent.onTrace("com.zhihu.matisse.internal.ui.SelectedPreviewActivity", "onResume", true);
        super/*androidx.fragment.app.FragmentActivity*/.onResume();
        ActivityAgent.onTrace("com.zhihu.matisse.internal.ui.SelectedPreviewActivity", "onResume", false);
    }

    public void onStart() {
        ActivityAgent.onTrace("com.zhihu.matisse.internal.ui.SelectedPreviewActivity", "onStart", true);
        super.onStart();
        ActivityAgent.onTrace("com.zhihu.matisse.internal.ui.SelectedPreviewActivity", "onStart", false);
    }

    protected void onStop() {
        i2(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onWindowFocusChanged(boolean z) {
        ActivityAgent.onTrace("com.zhihu.matisse.internal.ui.SelectedPreviewActivity", "onWindowFocusChanged", true);
        super/*android.app.Activity*/.onWindowFocusChanged(z);
    }

    public void startActivity(Intent intent, Bundle bundle) {
        j2(this, intent, bundle);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void i2(SelectedPreviewActivity selectedPreviewActivity) {
        selectedPreviewActivity.f2();
        if (EnterTransitionCrashOptimizer.getContext() != null) {
            try {
                selectedPreviewActivity.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.zhihu.matisse.internal.ui.a
    protected void onCreate(Bundle bundle) {
        ActivityAgent.onTrace("com.zhihu.matisse.internal.ui.SelectedPreviewActivity", "onCreate", true);
        super.onCreate(bundle);
        if (!com.zhihu.matisse.internal.entity.a.b().o) {
            setResult(0);
            finish();
            ActivityAgent.onTrace("com.zhihu.matisse.internal.ui.SelectedPreviewActivity", "onCreate", false);
            return;
        }
        ArrayList parcelableArrayList = e2(getIntent(), "extra_default_bundle").getParcelableArrayList("state_selection");
        this.d.a(parcelableArrayList);
        this.d.notifyDataSetChanged();
        if (this.b.f) {
            this.e.setCheckedNum(1);
        } else {
            this.e.setChecked(true);
        }
        this.i = 0;
        d2((Item) parcelableArrayList.get(0));
        ActivityAgent.onTrace("com.zhihu.matisse.internal.ui.SelectedPreviewActivity", "onCreate", false);
    }

    @Proxy("getBundleExtra")
    @TargetClass("android.content.Intent")
    public static Bundle e2(Intent intent, String str) {
        Bundle bundleExtra = intent.getBundleExtra(str);
        Context context = BadParcelableCrashOptimizer.getContext();
        if (bundleExtra != null && context != null) {
            bundleExtra.setClassLoader(context.getClassLoader());
        }
        return bundleExtra;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "startActivity")
    public static void j2(SelectedPreviewActivity selectedPreviewActivity, Intent intent, Bundle bundle) {
        al2.a.a.i("startActivity-aop", new Object[0]);
        if (NsAdApi.IMPL.interceptQuickApp(intent)) {
            return;
        }
        selectedPreviewActivity.h2(intent, bundle);
    }
}
