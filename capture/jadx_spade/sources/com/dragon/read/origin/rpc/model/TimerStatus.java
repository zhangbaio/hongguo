package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum TimerStatus {
    IMMEDIATELY(0),
    DELAY(1);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613476);
    }

    public static TimerStatus findByValue(int i) {
        if (i != 0) {
            if (i != 1) {
                return null;
            }
            return DELAY;
        }
        return IMMEDIATELY;
    }

    TimerStatus(int i) {
        this.value = i;
    }
}
