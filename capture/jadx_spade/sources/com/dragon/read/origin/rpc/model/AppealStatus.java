package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum AppealStatus {
    Default(0),
    CanApply(1),
    Reviewing(2),
    Timeout(3);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(612732);
    }

    public static AppealStatus findByValue(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return null;
                    }
                    return Timeout;
                }
                return Reviewing;
            }
            return CanApply;
        }
        return Default;
    }

    AppealStatus(int i) {
        this.value = i;
    }
}
