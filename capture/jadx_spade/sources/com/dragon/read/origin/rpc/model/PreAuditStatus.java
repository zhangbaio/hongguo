package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum PreAuditStatus {
    DEFAULT(0),
    AUDITING(1),
    SUCCESS(2),
    FAIL(3);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613323);
    }

    public static PreAuditStatus findByValue(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return null;
                    }
                    return FAIL;
                }
                return SUCCESS;
            }
            return AUDITING;
        }
        return DEFAULT;
    }

    PreAuditStatus(int i) {
        this.value = i;
    }
}
