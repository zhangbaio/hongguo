package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum ArticleTimerType {
    POST_NOW(0),
    TIMER(1);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(612736);
    }

    public static ArticleTimerType findByValue(int i) {
        if (i != 0) {
            if (i != 1) {
                return null;
            }
            return TIMER;
        }
        return POST_NOW;
    }

    ArticleTimerType(int i) {
        this.value = i;
    }
}
