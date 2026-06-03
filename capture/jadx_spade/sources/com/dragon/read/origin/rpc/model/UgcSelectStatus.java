package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum UgcSelectStatus {
    None(1),
    Done(2),
    Ban(3);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613521);
    }

    public static UgcSelectStatus findByValue(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    return null;
                }
                return Ban;
            }
            return Done;
        }
        return None;
    }

    UgcSelectStatus(int i) {
        this.value = i;
    }
}
