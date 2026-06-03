package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum ConfirmStatus {
    UNCONFIRMED(0),
    CONFIRM(1);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(612837);
    }

    public static ConfirmStatus findByValue(int i) {
        if (i != 0) {
            if (i != 1) {
                return null;
            }
            return CONFIRM;
        }
        return UNCONFIRMED;
    }

    ConfirmStatus(int i) {
        this.value = i;
    }
}
