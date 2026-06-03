package com.tencent.tinker.lib.stub.p3;

import android.os.Bundle;
import com.bytedance.apm.agent.v2.instrumentation.ActivityAgent;
import com.bytedance.covode.number.Covode;
import com.tencent.tinker.lib.stub.BaseStubActivity;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class StubStandardActivity5 extends BaseStubActivity {
    static {
        Covode.recordClassIndex(653919);
    }

    @Override // com.tencent.tinker.lib.stub.BaseStubActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        ActivityAgent.onTrace("com.tencent.tinker.lib.stub.p3.StubStandardActivity5", "onCreate", true);
        super.onCreate(bundle);
        ActivityAgent.onTrace("com.tencent.tinker.lib.stub.p3.StubStandardActivity5", "onCreate", false);
    }

    @Override // android.app.Activity
    public void onResume() {
        ActivityAgent.onTrace("com.tencent.tinker.lib.stub.p3.StubStandardActivity5", "onResume", true);
        super.onResume();
        ActivityAgent.onTrace("com.tencent.tinker.lib.stub.p3.StubStandardActivity5", "onResume", false);
    }

    @Override // android.app.Activity
    public void onStart() {
        ActivityAgent.onTrace("com.tencent.tinker.lib.stub.p3.StubStandardActivity5", "onStart", true);
        super.onStart();
        ActivityAgent.onTrace("com.tencent.tinker.lib.stub.p3.StubStandardActivity5", "onStart", false);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        ActivityAgent.onTrace("com.tencent.tinker.lib.stub.p3.StubStandardActivity5", "onWindowFocusChanged", true);
        super.onWindowFocusChanged(z);
    }
}
