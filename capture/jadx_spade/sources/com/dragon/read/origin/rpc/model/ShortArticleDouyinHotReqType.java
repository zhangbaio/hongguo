package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum ShortArticleDouyinHotReqType {
    All(0),
    ClassicHot(1),
    DarkHorseIncrease(2);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613443);
    }

    public static ShortArticleDouyinHotReqType findByValue(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    return null;
                }
                return DarkHorseIncrease;
            }
            return ClassicHot;
        }
        return All;
    }

    ShortArticleDouyinHotReqType(int i) {
        this.value = i;
    }
}
