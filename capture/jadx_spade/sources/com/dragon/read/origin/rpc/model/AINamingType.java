package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum AINamingType {
    PersonalName(1),
    ObjectName(2),
    CustomName(100);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(612691);
    }

    public static AINamingType findByValue(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 100) {
                    return null;
                }
                return CustomName;
            }
            return ObjectName;
        }
        return PersonalName;
    }

    AINamingType(int i) {
        this.value = i;
    }
}
