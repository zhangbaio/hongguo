package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum PreAuditType {
    DEFAULT(0),
    QUALITY(1);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613324);
    }

    public static PreAuditType findByValue(int i) {
        if (i != 0) {
            if (i != 1) {
                return null;
            }
            return QUALITY;
        }
        return DEFAULT;
    }

    PreAuditType(int i) {
        this.value = i;
    }
}
