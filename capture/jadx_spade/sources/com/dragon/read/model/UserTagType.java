package com.dragon.read.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum UserTagType {
    None(0),
    GoldSensitive(1);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(612290);
    }

    public static UserTagType findByValue(int i) {
        if (i != 0) {
            if (i != 1) {
                return null;
            }
            return GoldSensitive;
        }
        return None;
    }

    UserTagType(int i) {
        this.value = i;
    }
}
