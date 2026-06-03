package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum AIGCImageStatus {
    UnUsed(1),
    Used(2),
    Deleted(3),
    PreProduce(4);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(612678);
    }

    public static AIGCImageStatus findByValue(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        return null;
                    }
                    return PreProduce;
                }
                return Deleted;
            }
            return Used;
        }
        return UnUsed;
    }

    AIGCImageStatus(int i) {
        this.value = i;
    }
}
