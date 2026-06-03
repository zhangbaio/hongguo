package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum OperateBookRecommendType {
    CONFIRM_THUMB(0),
    START_BOOK_RECOMMEND(1);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613264);
    }

    public static OperateBookRecommendType findByValue(int i) {
        if (i != 0) {
            if (i != 1) {
                return null;
            }
            return START_BOOK_RECOMMEND;
        }
        return CONFIRM_THUMB;
    }

    OperateBookRecommendType(int i) {
        this.value = i;
    }
}
