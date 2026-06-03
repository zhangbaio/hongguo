package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum PublishStatus {
    DRAFT(0),
    PUBLISH(1);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613347);
    }

    public static PublishStatus findByValue(int i) {
        if (i != 0) {
            if (i != 1) {
                return null;
            }
            return PUBLISH;
        }
        return DRAFT;
    }

    PublishStatus(int i) {
        this.value = i;
    }
}
