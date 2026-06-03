package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum PlayletType {
    Normal(1),
    Customized(2);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613302);
    }

    public static PlayletType findByValue(int i) {
        if (i != 1) {
            if (i != 2) {
                return null;
            }
            return Customized;
        }
        return Normal;
    }

    PlayletType(int i) {
        this.value = i;
    }
}
