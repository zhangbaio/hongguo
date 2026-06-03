package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum AIConsultFirstRecommendQuestionType {
    Beginning(1),
    CommonWrite(2);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(612665);
    }

    public static AIConsultFirstRecommendQuestionType findByValue(int i) {
        if (i != 1) {
            if (i != 2) {
                return null;
            }
            return CommonWrite;
        }
        return Beginning;
    }

    AIConsultFirstRecommendQuestionType(int i) {
        this.value = i;
    }
}
