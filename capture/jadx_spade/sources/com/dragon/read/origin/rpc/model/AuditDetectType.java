package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum AuditDetectType {
    TimerPreview(1);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(612748);
    }

    public static AuditDetectType findByValue(int i) {
        if (i != 1) {
            return null;
        }
        return TimerPreview;
    }

    AuditDetectType(int i) {
        this.value = i;
    }
}
