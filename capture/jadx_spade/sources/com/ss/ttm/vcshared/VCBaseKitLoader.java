package com.ss.ttm.vcshared;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class VCBaseKitLoader {
    static {
        Covode.recordClassIndex(652242);
    }

    private VCBaseKitLoader() {
    }

    public static synchronized boolean loadLibrary() {
        boolean loadLibrary;
        synchronized (VCBaseKitLoader.class) {
            loadLibrary = com.ss.vcbkit.VCBaseKitLoader.loadLibrary();
        }
        return loadLibrary;
    }
}
