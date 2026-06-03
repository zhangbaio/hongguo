package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum HasHideStatus {
    HIDE_NOTEXIST(-2),
    HIDE_DISABLE(-1),
    HIDE_ENABLE(0),
    HIDE_ACTIVE(1);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613183);
    }

    public static HasHideStatus findByValue(int i) {
        if (i != -2) {
            if (i != -1) {
                if (i != 0) {
                    if (i != 1) {
                        return null;
                    }
                    return HIDE_ACTIVE;
                }
                return HIDE_ENABLE;
            }
            return HIDE_DISABLE;
        }
        return HIDE_NOTEXIST;
    }

    HasHideStatus(int i) {
        this.value = i;
    }
}
