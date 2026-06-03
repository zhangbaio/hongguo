package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum Order {
    ACS(0),
    DESC(1);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613268);
    }

    public static Order findByValue(int i) {
        if (i != 0) {
            if (i != 1) {
                return null;
            }
            return DESC;
        }
        return ACS;
    }

    Order(int i) {
        this.value = i;
    }
}
