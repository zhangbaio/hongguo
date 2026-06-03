package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum UserType {
    DeviceNone(0),
    Android(1),
    iOS(2);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613563);
    }

    public static UserType findByValue(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    return null;
                }
                return iOS;
            }
            return Android;
        }
        return DeviceNone;
    }

    UserType(int i) {
        this.value = i;
    }
}
