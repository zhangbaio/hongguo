package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum PermissionExecutor {
    NONE(0),
    REQ_USER(1),
    OTHERS(2);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613279);
    }

    public static PermissionExecutor findByValue(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    return null;
                }
                return OTHERS;
            }
            return REQ_USER;
        }
        return NONE;
    }

    PermissionExecutor(int i) {
        this.value = i;
    }
}
