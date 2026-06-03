package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum ShootingRecommend {
    Default(0),
    Recommend(1),
    NotRecommend(2);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613424);
    }

    public static ShootingRecommend findByValue(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    return null;
                }
                return NotRecommend;
            }
            return Recommend;
        }
        return Default;
    }

    ShootingRecommend(int i) {
        this.value = i;
    }
}
