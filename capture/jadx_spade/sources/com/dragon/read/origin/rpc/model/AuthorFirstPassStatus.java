package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum AuthorFirstPassStatus {
    REJECT(0),
    PASS(1),
    REVIEWING(2),
    ABNORMAL(3);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(612753);
    }

    public static AuthorFirstPassStatus findByValue(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return null;
                    }
                    return ABNORMAL;
                }
                return REVIEWING;
            }
            return PASS;
        }
        return REJECT;
    }

    AuthorFirstPassStatus(int i) {
        this.value = i;
    }
}
