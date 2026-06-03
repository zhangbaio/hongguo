package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum SetTopStatus {
    SETTOP_NOTEXIST(-2),
    SETTOP_DISABLE(-1),
    SETTOP_ENABLE(0),
    SETTOP_ACTIVE(1);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613423);
    }

    public static SetTopStatus findByValue(int i) {
        if (i != -2) {
            if (i != -1) {
                if (i != 0) {
                    if (i != 1) {
                        return null;
                    }
                    return SETTOP_ACTIVE;
                }
                return SETTOP_ENABLE;
            }
            return SETTOP_DISABLE;
        }
        return SETTOP_NOTEXIST;
    }

    SetTopStatus(int i) {
        this.value = i;
    }
}
