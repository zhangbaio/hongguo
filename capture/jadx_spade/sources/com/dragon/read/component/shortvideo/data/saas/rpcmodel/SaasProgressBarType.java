package com.dragon.read.component.shortvideo.data.saas.rpcmodel;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum SaasProgressBarType {
    All(0),
    HighLight(1);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(599103);
    }

    public static SaasProgressBarType findByValue(int i) {
        if (i != 0) {
            if (i != 1) {
                return null;
            }
            return HighLight;
        }
        return All;
    }

    SaasProgressBarType(int i) {
        this.value = i;
    }
}
