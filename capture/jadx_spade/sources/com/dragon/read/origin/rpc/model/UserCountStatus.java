package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum UserCountStatus {
    OVERSEVERN(0),
    LESSSEVEN(1);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613554);
    }

    public static UserCountStatus findByValue(int i) {
        if (i != 0) {
            if (i != 1) {
                return null;
            }
            return LESSSEVEN;
        }
        return OVERSEVERN;
    }

    UserCountStatus(int i) {
        this.value = i;
    }
}
