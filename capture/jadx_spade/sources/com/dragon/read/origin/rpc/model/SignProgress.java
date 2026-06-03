package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum SignProgress {
    INIT(0),
    PROCESS(1),
    FAILED(2),
    SUCCESS(3);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613453);
    }

    public static SignProgress findByValue(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return null;
                    }
                    return SUCCESS;
                }
                return FAILED;
            }
            return PROCESS;
        }
        return INIT;
    }

    SignProgress(int i) {
        this.value = i;
    }
}
