package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum GenType {
    AI(1);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(612934);
    }

    public static GenType findByValue(int i) {
        if (i != 1) {
            return null;
        }
        return AI;
    }

    GenType(int i) {
        this.value = i;
    }
}
