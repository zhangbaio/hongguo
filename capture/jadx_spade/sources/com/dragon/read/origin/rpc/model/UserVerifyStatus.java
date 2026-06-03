package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum UserVerifyStatus {
    NOT_VERIFY(0),
    SUCCEED(1),
    REVIEWING(2),
    FAILED(3);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613564);
    }

    public static UserVerifyStatus findByValue(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return null;
                    }
                    return FAILED;
                }
                return REVIEWING;
            }
            return SUCCEED;
        }
        return NOT_VERIFY;
    }

    UserVerifyStatus(int i) {
        this.value = i;
    }
}
