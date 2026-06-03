package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum AuthorizeType {
    UNAUTHRIZED(0),
    AUTHRIZED(1);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(612760);
    }

    public static AuthorizeType findByValue(int i) {
        if (i != 0) {
            if (i != 1) {
                return null;
            }
            return AUTHRIZED;
        }
        return UNAUTHRIZED;
    }

    AuthorizeType(int i) {
        this.value = i;
    }
}
