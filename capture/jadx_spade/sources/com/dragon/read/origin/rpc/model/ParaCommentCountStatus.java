package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum ParaCommentCountStatus {
    LESSFIVE(0),
    OVERFIVE(1),
    OVERFIFTY(2);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613275);
    }

    public static ParaCommentCountStatus findByValue(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    return null;
                }
                return OVERFIFTY;
            }
            return OVERFIVE;
        }
        return LESSFIVE;
    }

    ParaCommentCountStatus(int i) {
        this.value = i;
    }
}
