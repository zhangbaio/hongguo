package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum AIDescribeType {
    Character(1),
    Scene(2),
    Custom(100);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(612669);
    }

    public static AIDescribeType findByValue(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 100) {
                    return null;
                }
                return Custom;
            }
            return Scene;
        }
        return Character;
    }

    AIDescribeType(int i) {
        this.value = i;
    }
}
