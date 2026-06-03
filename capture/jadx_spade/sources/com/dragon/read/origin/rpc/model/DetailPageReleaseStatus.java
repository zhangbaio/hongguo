package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum DetailPageReleaseStatus {
    DRAFT(0),
    RELEASE(1);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(612884);
    }

    public static DetailPageReleaseStatus findByValue(int i) {
        if (i != 0) {
            if (i != 1) {
                return null;
            }
            return RELEASE;
        }
        return DRAFT;
    }

    DetailPageReleaseStatus(int i) {
        this.value = i;
    }
}
