package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum RoleType {
    UNKNOWN(0),
    PERSONAL(1),
    MANAGEMENT(2);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613379);
    }

    public static RoleType findByValue(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    return null;
                }
                return MANAGEMENT;
            }
            return PERSONAL;
        }
        return UNKNOWN;
    }

    RoleType(int i) {
        this.value = i;
    }
}
