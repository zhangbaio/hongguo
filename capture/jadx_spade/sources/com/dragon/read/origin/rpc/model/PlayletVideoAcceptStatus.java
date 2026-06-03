package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum PlayletVideoAcceptStatus {
    Accepted(2),
    Rejected(3),
    Timeout(4);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613303);
    }

    public static PlayletVideoAcceptStatus findByValue(int i) {
        if (i != 2) {
            if (i != 3) {
                if (i != 4) {
                    return null;
                }
                return Timeout;
            }
            return Rejected;
        }
        return Accepted;
    }

    PlayletVideoAcceptStatus(int i) {
        this.value = i;
    }
}
