package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum ScriptReturnStatus {
    UNKNOWN(0),
    IpModel(1),
    SafeGuard(2),
    Reviewer(3);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613400);
    }

    public static ScriptReturnStatus findByValue(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return null;
                    }
                    return Reviewer;
                }
                return SafeGuard;
            }
            return IpModel;
        }
        return UNKNOWN;
    }

    ScriptReturnStatus(int i) {
        this.value = i;
    }
}
