package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum UserAuthStatus {
    NONE(0),
    VERIFIED(1),
    PROCESSING(2);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613550);
    }

    public static UserAuthStatus findByValue(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    return null;
                }
                return PROCESSING;
            }
            return VERIFIED;
        }
        return NONE;
    }

    UserAuthStatus(int i) {
        this.value = i;
    }
}
