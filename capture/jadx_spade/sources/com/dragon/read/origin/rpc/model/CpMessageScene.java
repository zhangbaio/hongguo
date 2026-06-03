package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum CpMessageScene {
    PlayletMaterialQualityAudit(10001);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(612854);
    }

    public static CpMessageScene findByValue(int i) {
        if (i != 10001) {
            return null;
        }
        return PlayletMaterialQualityAudit;
    }

    CpMessageScene(int i) {
        this.value = i;
    }
}
