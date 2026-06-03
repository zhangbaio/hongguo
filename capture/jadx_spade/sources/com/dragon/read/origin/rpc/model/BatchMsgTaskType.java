package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum BatchMsgTaskType {
    INBOX_MSG(0),
    SMS(1);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(612770);
    }

    public static BatchMsgTaskType findByValue(int i) {
        if (i != 0) {
            if (i != 1) {
                return null;
            }
            return SMS;
        }
        return INBOX_MSG;
    }

    BatchMsgTaskType(int i) {
        this.value = i;
    }
}
