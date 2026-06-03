package com.ttnet.org.chromium.base.metrics;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class c {
    private static CachingUmaRecorder a;
    private static boolean b;

    private c() {
    }

    public static b a() {
        return a;
    }

    static {
        Covode.recordClassIndex(654380);
        a = new CachingUmaRecorder();
        b = true;
    }
}
