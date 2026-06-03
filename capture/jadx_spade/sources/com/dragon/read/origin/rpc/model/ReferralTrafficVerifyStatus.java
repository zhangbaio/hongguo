package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum ReferralTrafficVerifyStatus {
    REVIEWING(0),
    PASS(1),
    REJECT(2);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613365);
    }

    public static ReferralTrafficVerifyStatus findByValue(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    return null;
                }
                return REJECT;
            }
            return PASS;
        }
        return REVIEWING;
    }

    ReferralTrafficVerifyStatus(int i) {
        this.value = i;
    }
}
