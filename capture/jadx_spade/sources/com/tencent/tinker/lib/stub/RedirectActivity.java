package com.tencent.tinker.lib.stub;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.bytedance.apm.agent.v2.instrumentation.ActivityAgent;
import com.bytedance.covode.number.Covode;
import com.tencent.tinker.lib.utils.IntentUtil;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class RedirectActivity extends Activity {

    public static final class CodeConst {
        static {
            Covode.recordClassIndex(653825);
        }
    }

    static {
        Covode.recordClassIndex(653824);
    }

    @Override // android.app.Activity
    public void onResume() {
        ActivityAgent.onTrace("com.tencent.tinker.lib.stub.RedirectActivity", "onResume", true);
        super.onResume();
        ActivityAgent.onTrace("com.tencent.tinker.lib.stub.RedirectActivity", "onResume", false);
    }

    @Override // android.app.Activity
    public void onStart() {
        ActivityAgent.onTrace("com.tencent.tinker.lib.stub.RedirectActivity", "onStart", true);
        super.onStart();
        ActivityAgent.onTrace("com.tencent.tinker.lib.stub.RedirectActivity", "onStart", false);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        ActivityAgent.onTrace("com.tencent.tinker.lib.stub.RedirectActivity", "onWindowFocusChanged", true);
        super.onWindowFocusChanged(z);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        Intent intent;
        ActivityAgent.onTrace("com.tencent.tinker.lib.stub.RedirectActivity", "onCreate", true);
        super.onCreate(bundle);
        Intent intent2 = getIntent();
        if (intent2 != null && (intent = (Intent) intent2.getParcelableExtra("mute_target_intent")) != null) {
            IntentUtil.safeRemoveUnSafeFlags(intent);
            startActivity(intent);
        }
        finish();
        ActivityAgent.onTrace("com.tencent.tinker.lib.stub.RedirectActivity", "onCreate", false);
    }
}
