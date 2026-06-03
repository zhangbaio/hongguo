package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum ShortArticleTimeSortStatus {
    CREATE_TIME_DESC(0),
    CREATE_TIME_ASC(1);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613449);
    }

    public static ShortArticleTimeSortStatus findByValue(int i) {
        if (i != 0) {
            if (i != 1) {
                return null;
            }
            return CREATE_TIME_ASC;
        }
        return CREATE_TIME_DESC;
    }

    ShortArticleTimeSortStatus(int i) {
        this.value = i;
    }
}
