package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum SubmitColdStartInAdvanceType {
    Agree(1),
    Reject(2);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613466);
    }

    public static SubmitColdStartInAdvanceType findByValue(int i) {
        if (i != 1) {
            if (i != 2) {
                return null;
            }
            return Reject;
        }
        return Agree;
    }

    SubmitColdStartInAdvanceType(int i) {
        this.value = i;
    }
}
