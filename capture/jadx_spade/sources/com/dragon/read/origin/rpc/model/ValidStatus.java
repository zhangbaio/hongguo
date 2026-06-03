package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum ValidStatus {
    INVALID(0),
    VALID(1);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613565);
    }

    public static ValidStatus findByValue(int i) {
        if (i != 0) {
            if (i != 1) {
                return null;
            }
            return VALID;
        }
        return INVALID;
    }

    ValidStatus(int i) {
        this.value = i;
    }
}
