package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum InstitutionAuditStatus {
    AUDITING(0),
    PASS(1),
    REJECT(2);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613201);
    }

    public static InstitutionAuditStatus findByValue(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    return null;
                }
                return REJECT;
            }
            return PASS;
        }
        return AUDITING;
    }

    InstitutionAuditStatus(int i) {
        this.value = i;
    }
}
