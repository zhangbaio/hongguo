package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum MedalDayLimitType {
    Once(1),
    Continuance(2);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613214);
    }

    public static MedalDayLimitType findByValue(int i) {
        if (i != 1) {
            if (i != 2) {
                return null;
            }
            return Continuance;
        }
        return Once;
    }

    MedalDayLimitType(int i) {
        this.value = i;
    }
}
