package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum ColdStartAuditStatus {
    INIT(0),
    AUDITING(1),
    FAILED(2),
    SUCCEEDED(3);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(612828);
    }

    public static ColdStartAuditStatus findByValue(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return null;
                    }
                    return SUCCEEDED;
                }
                return FAILED;
            }
            return AUDITING;
        }
        return INIT;
    }

    ColdStartAuditStatus(int i) {
        this.value = i;
    }
}
