package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum SaasVoteType {
    Pk(1),
    Reward(2),
    OptionList(3);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613387);
    }

    public static SaasVoteType findByValue(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    return null;
                }
                return OptionList;
            }
            return Reward;
        }
        return Pk;
    }

    SaasVoteType(int i) {
        this.value = i;
    }
}
