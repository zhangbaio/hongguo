package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum UgcRankType {
    History(1),
    Daily(2);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613517);
    }

    public static UgcRankType findByValue(int i) {
        if (i != 1) {
            if (i != 2) {
                return null;
            }
            return Daily;
        }
        return History;
    }

    UgcRankType(int i) {
        this.value = i;
    }
}
