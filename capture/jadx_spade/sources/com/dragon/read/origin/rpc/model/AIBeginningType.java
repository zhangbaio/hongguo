package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum AIBeginningType {
    OneWord(1),
    Outline(2);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(612660);
    }

    public static AIBeginningType findByValue(int i) {
        if (i != 1) {
            if (i != 2) {
                return null;
            }
            return Outline;
        }
        return OneWord;
    }

    AIBeginningType(int i) {
        this.value = i;
    }
}
