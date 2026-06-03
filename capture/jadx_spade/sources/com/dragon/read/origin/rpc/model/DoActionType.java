package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum DoActionType {
    Digg(1),
    UnDigg(2),
    Delete(3);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(612892);
    }

    public static DoActionType findByValue(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    return null;
                }
                return Delete;
            }
            return UnDigg;
        }
        return Digg;
    }

    DoActionType(int i) {
        this.value = i;
    }
}
