package com.dragon.read.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum DowngradeType {
    wallet(1);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(612075);
    }

    public static DowngradeType findByValue(int i) {
        if (i != 1) {
            return null;
        }
        return wallet;
    }

    DowngradeType(int i) {
        this.value = i;
    }
}
