package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum Gender {
    NOT_SET(-1),
    FEMALE(0),
    MALE(1),
    General(2);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(612935);
    }

    public static Gender findByValue(int i) {
        if (i != -1) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        return null;
                    }
                    return General;
                }
                return MALE;
            }
            return FEMALE;
        }
        return NOT_SET;
    }

    Gender(int i) {
        this.value = i;
    }
}
