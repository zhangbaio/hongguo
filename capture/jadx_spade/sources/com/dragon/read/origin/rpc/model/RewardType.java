package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum RewardType {
    CreateItem(0),
    AddRole(1),
    Lottery(2);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613373);
    }

    public static RewardType findByValue(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    return null;
                }
                return Lottery;
            }
            return AddRole;
        }
        return CreateItem;
    }

    RewardType(int i) {
        this.value = i;
    }
}
