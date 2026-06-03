package com.tencent.tinker.lib.stub;

import android.app.Activity;
import android.os.Bundle;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class BaseStubActivity extends Activity {

    public static final class CodeConst {
        static {
            Covode.recordClassIndex(653818);
        }
    }

    static {
        Covode.recordClassIndex(653817);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        finish();
    }
}
