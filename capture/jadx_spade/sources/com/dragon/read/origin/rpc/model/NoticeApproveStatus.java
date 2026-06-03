package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum NoticeApproveStatus {
    UNKNOWN(0),
    PROCESSING(1),
    APPROVED(2),
    REJECTED(3);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613257);
    }

    public static NoticeApproveStatus findByValue(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return null;
                    }
                    return REJECTED;
                }
                return APPROVED;
            }
            return PROCESSING;
        }
        return UNKNOWN;
    }

    NoticeApproveStatus(int i) {
        this.value = i;
    }
}
