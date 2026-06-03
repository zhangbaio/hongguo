package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum CreationStatus {
    OVER(0),
    SERIALIZING(1);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(612863);
    }

    public static CreationStatus findByValue(int i) {
        if (i != 0) {
            if (i != 1) {
                return null;
            }
            return SERIALIZING;
        }
        return OVER;
    }

    CreationStatus(int i) {
        this.value = i;
    }
}
