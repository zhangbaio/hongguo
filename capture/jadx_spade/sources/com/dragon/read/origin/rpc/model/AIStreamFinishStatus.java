package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum AIStreamFinishStatus {
    Unknown(0),
    Running(1),
    Success(2),
    Error(3);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(612696);
    }

    public static AIStreamFinishStatus findByValue(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return null;
                    }
                    return Error;
                }
                return Success;
            }
            return Running;
        }
        return Unknown;
    }

    AIStreamFinishStatus(int i) {
        this.value = i;
    }
}
