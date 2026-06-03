package com.tencent.tinker.android.dex;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class SizeOf {
    static {
        Covode.recordClassIndex(653616);
    }

    private SizeOf() {
    }

    public static int roundToTimesOfFour(int i) {
        return (i + 3) & (-4);
    }
}
