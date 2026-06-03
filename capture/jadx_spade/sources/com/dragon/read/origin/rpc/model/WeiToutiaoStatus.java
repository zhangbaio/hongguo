package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum WeiToutiaoStatus {
    DEFAULT(-1),
    HOT(0),
    LOW(1),
    REVIEW(2),
    REJECT(3),
    DRAFT(4);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613574);
    }

    public static WeiToutiaoStatus findByValue(int i) {
        if (i != -1) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (i != 4) {
                                return null;
                            }
                            return DRAFT;
                        }
                        return REJECT;
                    }
                    return REVIEW;
                }
                return LOW;
            }
            return HOT;
        }
        return DEFAULT;
    }

    WeiToutiaoStatus(int i) {
        this.value = i;
    }
}
