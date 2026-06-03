package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum AICategoryType {
    MainCategory(1),
    NoSelect(2);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(612661);
    }

    public static AICategoryType findByValue(int i) {
        if (i != 1) {
            if (i != 2) {
                return null;
            }
            return NoSelect;
        }
        return MainCategory;
    }

    AICategoryType(int i) {
        this.value = i;
    }
}
