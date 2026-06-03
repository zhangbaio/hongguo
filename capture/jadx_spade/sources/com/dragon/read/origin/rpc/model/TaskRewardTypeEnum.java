package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum TaskRewardTypeEnum {
    None(0),
    Medal(1),
    FanqieSeed(2);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613470);
    }

    public static TaskRewardTypeEnum findByValue(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    return null;
                }
                return FanqieSeed;
            }
            return Medal;
        }
        return None;
    }

    TaskRewardTypeEnum(int i) {
        this.value = i;
    }
}
