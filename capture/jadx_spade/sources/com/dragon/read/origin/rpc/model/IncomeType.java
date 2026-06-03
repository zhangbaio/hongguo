package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum IncomeType {
    INCOME_NONE(0),
    TOMATO(1),
    TOUTIAO(2),
    ALL(3);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613194);
    }

    public static IncomeType findByValue(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return null;
                    }
                    return ALL;
                }
                return TOUTIAO;
            }
            return TOMATO;
        }
        return INCOME_NONE;
    }

    IncomeType(int i) {
        this.value = i;
    }
}
