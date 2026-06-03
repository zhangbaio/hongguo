package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum FoldType {
    Normal(0),
    Unfold(1),
    Fold(2);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(612931);
    }

    public static FoldType findByValue(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    return null;
                }
                return Fold;
            }
            return Unfold;
        }
        return Normal;
    }

    FoldType(int i) {
        this.value = i;
    }
}
