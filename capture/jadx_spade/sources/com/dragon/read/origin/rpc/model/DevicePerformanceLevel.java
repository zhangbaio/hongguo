package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum DevicePerformanceLevel {
    Low(1),
    Middle(2),
    High(3);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(612890);
    }

    public static DevicePerformanceLevel findByValue(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    return null;
                }
                return High;
            }
            return Middle;
        }
        return Low;
    }

    DevicePerformanceLevel(int i) {
        this.value = i;
    }
}
