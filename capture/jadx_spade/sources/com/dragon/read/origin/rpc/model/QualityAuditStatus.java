package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum QualityAuditStatus {
    Audit(1),
    Failed(2),
    Pass(3);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613348);
    }

    public static QualityAuditStatus findByValue(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    return null;
                }
                return Pass;
            }
            return Failed;
        }
        return Audit;
    }

    QualityAuditStatus(int i) {
        this.value = i;
    }
}
