package com.dragon.read.nuwa.ctrl;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class GcStepOptCtrl {
    public static IGcListener sListener;

    public interface IGcListener {
        void onGcStepUpdate(long j, long j2, float f);
    }

    static {
        Covode.recordClassIndex(612605);
        sListener = null;
    }
}
