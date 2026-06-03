package com.ss.ttvideoengine.strategrycenter;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class StrategyKeys {
    public static int mInteractionBlockDurationNonPreloaded;
    public static int mInteractionBlockDurationPreloaded;

    static {
        Covode.recordClassIndex(652722);
        mInteractionBlockDurationPreloaded = 400;
        mInteractionBlockDurationNonPreloaded = 800;
    }

    public static void setIntValue(int i, int i2) {
        if (i != 120) {
            if (i == 121) {
                mInteractionBlockDurationNonPreloaded = i2;
                return;
            }
            return;
        }
        mInteractionBlockDurationPreloaded = i2;
    }
}
