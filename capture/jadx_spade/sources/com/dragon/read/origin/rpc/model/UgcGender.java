package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum UgcGender {
    FEMALE(0),
    MALE(1),
    NOSET(2);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613509);
    }

    public static UgcGender findByValue(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    return null;
                }
                return NOSET;
            }
            return MALE;
        }
        return FEMALE;
    }

    UgcGender(int i) {
        this.value = i;
    }
}
