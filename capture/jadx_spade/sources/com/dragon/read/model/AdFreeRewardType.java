package com.dragon.read.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum AdFreeRewardType {
    Default(0),
    VIP(1);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(612001);
    }

    public static AdFreeRewardType findByValue(int i) {
        if (i != 0) {
            if (i != 1) {
                return null;
            }
            return VIP;
        }
        return Default;
    }

    AdFreeRewardType(int i) {
        this.value = i;
    }
}
