package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum RankListGroup {
    OVERALL(1),
    CLASSIFICATION(2),
    ORIGIN(3),
    DIANFENG(4);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613352);
    }

    public static RankListGroup findByValue(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        return null;
                    }
                    return DIANFENG;
                }
                return ORIGIN;
            }
            return CLASSIFICATION;
        }
        return OVERALL;
    }

    RankListGroup(int i) {
        this.value = i;
    }
}
