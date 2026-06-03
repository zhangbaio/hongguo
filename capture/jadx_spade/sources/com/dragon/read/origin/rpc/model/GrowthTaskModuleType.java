package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum GrowthTaskModuleType {
    Growing(1),
    Viewing(2),
    PublishingContinuously(3),
    Other(4);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613180);
    }

    public static GrowthTaskModuleType findByValue(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        return null;
                    }
                    return Other;
                }
                return PublishingContinuously;
            }
            return Viewing;
        }
        return Growing;
    }

    GrowthTaskModuleType(int i) {
        this.value = i;
    }
}
