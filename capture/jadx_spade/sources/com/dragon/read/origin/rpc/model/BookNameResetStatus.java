package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum BookNameResetStatus {
    NO_RESET(0),
    RESET_DEFAULT_FORMAT(1);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(612778);
    }

    public static BookNameResetStatus findByValue(int i) {
        if (i != 0) {
            if (i != 1) {
                return null;
            }
            return RESET_DEFAULT_FORMAT;
        }
        return NO_RESET;
    }

    BookNameResetStatus(int i) {
        this.value = i;
    }
}
