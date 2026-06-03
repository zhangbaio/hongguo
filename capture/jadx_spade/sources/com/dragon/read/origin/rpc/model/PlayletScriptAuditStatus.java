package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum PlayletScriptAuditStatus {
    Passed(3),
    Rejected(4),
    Returned(5);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613294);
    }

    public static PlayletScriptAuditStatus findByValue(int i) {
        if (i != 3) {
            if (i != 4) {
                if (i != 5) {
                    return null;
                }
                return Returned;
            }
            return Rejected;
        }
        return Passed;
    }

    PlayletScriptAuditStatus(int i) {
        this.value = i;
    }
}
