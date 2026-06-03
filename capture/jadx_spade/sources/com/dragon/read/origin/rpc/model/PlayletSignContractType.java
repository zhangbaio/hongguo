package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum PlayletSignContractType {
    Single(1),
    Frame(2);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613299);
    }

    public static PlayletSignContractType findByValue(int i) {
        if (i != 1) {
            if (i != 2) {
                return null;
            }
            return Frame;
        }
        return Single;
    }

    PlayletSignContractType(int i) {
        this.value = i;
    }
}
