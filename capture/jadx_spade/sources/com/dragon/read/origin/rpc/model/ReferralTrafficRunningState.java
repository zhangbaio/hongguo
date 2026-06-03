package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum ReferralTrafficRunningState {
    INIT(0),
    RUNNING(1),
    STOP(2);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613364);
    }

    public static ReferralTrafficRunningState findByValue(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    return null;
                }
                return STOP;
            }
            return RUNNING;
        }
        return INIT;
    }

    ReferralTrafficRunningState(int i) {
        this.value = i;
    }
}
