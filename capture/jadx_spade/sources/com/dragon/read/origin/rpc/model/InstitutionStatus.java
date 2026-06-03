package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum InstitutionStatus {
    UNCERTIFIED(0),
    CERTIFYING(1),
    NORMAL(2),
    CANCELLED(3);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613203);
    }

    public static InstitutionStatus findByValue(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return null;
                    }
                    return CANCELLED;
                }
                return NORMAL;
            }
            return CERTIFYING;
        }
        return UNCERTIFIED;
    }

    InstitutionStatus(int i) {
        this.value = i;
    }
}
