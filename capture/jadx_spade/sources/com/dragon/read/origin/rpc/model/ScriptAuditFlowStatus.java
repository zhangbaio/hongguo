package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum ScriptAuditFlowStatus {
    IpModelAudit(10),
    SafeguardAudit(20),
    ReviewerAudit(30);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613399);
    }

    public static ScriptAuditFlowStatus findByValue(int i) {
        if (i != 10) {
            if (i != 20) {
                if (i != 30) {
                    return null;
                }
                return ReviewerAudit;
            }
            return SafeguardAudit;
        }
        return IpModelAudit;
    }

    ScriptAuditFlowStatus(int i) {
        this.value = i;
    }
}
