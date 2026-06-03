package com.tencent.mm.opensdk.diffdev;

import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.diffdev.a.a;
import com.tencent.mm.opensdk.utils.Log;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class DiffDevOAuthFactory {
    private static IDiffDevOAuth v1Instance;

    static {
        Covode.recordClassIndex(653289);
    }

    private DiffDevOAuthFactory() {
    }

    public static IDiffDevOAuth getDiffDevOAuth() {
        return getDiffDevOAuth(1);
    }

    public static IDiffDevOAuth getDiffDevOAuth(int i) {
        Log.v("MicroMsg.SDK.DiffDevOAuthFactory", "getDiffDevOAuth, version = " + i);
        if (i > 1) {
            Log.e("MicroMsg.SDK.DiffDevOAuthFactory", "getDiffDevOAuth fail, unsupported version = " + i);
            return null;
        }
        if (i != 1) {
            return null;
        }
        if (v1Instance == null) {
            v1Instance = new a();
        }
        return v1Instance;
    }
}
