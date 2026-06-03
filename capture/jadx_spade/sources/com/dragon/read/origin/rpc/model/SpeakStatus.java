package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum SpeakStatus {
    REVIEWING(0),
    PASS(1),
    REJECT(2),
    DRAFT(3);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613456);
    }

    public static SpeakStatus findByValue(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return null;
                    }
                    return DRAFT;
                }
                return REJECT;
            }
            return PASS;
        }
        return REVIEWING;
    }

    SpeakStatus(int i) {
        this.value = i;
    }
}
