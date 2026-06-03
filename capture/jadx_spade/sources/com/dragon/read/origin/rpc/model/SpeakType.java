package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum SpeakType {
    ORIGIN_SPEAK(0),
    REFERRAL_TRAFFIC(1);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613457);
    }

    public static SpeakType findByValue(int i) {
        if (i != 0) {
            if (i != 1) {
                return null;
            }
            return REFERRAL_TRAFFIC;
        }
        return ORIGIN_SPEAK;
    }

    SpeakType(int i) {
        this.value = i;
    }
}
