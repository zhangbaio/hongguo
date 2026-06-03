package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum InstitutionMemberAuditStatus {
    AUDITING(0),
    PASS(1),
    REJECT(2);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613202);
    }

    public static InstitutionMemberAuditStatus findByValue(int i) {
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

    InstitutionMemberAuditStatus(int i) {
        this.value = i;
    }
}
