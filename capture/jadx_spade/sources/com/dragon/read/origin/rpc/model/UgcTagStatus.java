package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum UgcTagStatus {
    Reviewing(0),
    Pass(1),
    Reject(2),
    Deleted(3);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613529);
    }

    public static UgcTagStatus findByValue(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return null;
                    }
                    return Deleted;
                }
                return Reject;
            }
            return Pass;
        }
        return Reviewing;
    }

    UgcTagStatus(int i) {
        this.value = i;
    }
}
