package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum TopHideAction {
    SETTOP(1),
    UNSETTOP(2),
    SETHIDE(3),
    ENSETHIDE(4);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613478);
    }

    public static TopHideAction findByValue(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        return null;
                    }
                    return ENSETHIDE;
                }
                return SETHIDE;
            }
            return UNSETTOP;
        }
        return SETTOP;
    }

    TopHideAction(int i) {
        this.value = i;
    }
}
