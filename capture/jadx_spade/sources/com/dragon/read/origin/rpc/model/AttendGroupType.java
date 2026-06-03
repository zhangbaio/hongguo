package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum AttendGroupType {
    Moren(0),
    Pinzi(1),
    Daka(2);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(612744);
    }

    public static AttendGroupType findByValue(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    return null;
                }
                return Daka;
            }
            return Pinzi;
        }
        return Moren;
    }

    AttendGroupType(int i) {
        this.value = i;
    }
}
