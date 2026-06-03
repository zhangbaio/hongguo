package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum SecurityStatus {
    NORMAL(1),
    STOP_RECOMMENDATION_DISTRIBUTION(2);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613416);
    }

    public static SecurityStatus findByValue(int i) {
        if (i != 1) {
            if (i != 2) {
                return null;
            }
            return STOP_RECOMMENDATION_DISTRIBUTION;
        }
        return NORMAL;
    }

    SecurityStatus(int i) {
        this.value = i;
    }
}
