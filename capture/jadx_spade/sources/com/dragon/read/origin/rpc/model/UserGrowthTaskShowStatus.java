package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum UserGrowthTaskShowStatus {
    Running(1),
    Finished(2),
    Rewarded(3),
    Expired(4);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613556);
    }

    public static UserGrowthTaskShowStatus findByValue(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        return null;
                    }
                    return Expired;
                }
                return Rewarded;
            }
            return Finished;
        }
        return Running;
    }

    UserGrowthTaskShowStatus(int i) {
        this.value = i;
    }
}
