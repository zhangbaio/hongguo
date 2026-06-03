package com.dragon.read.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum GoldBoxTab {
    Gold(0),
    AdFree(1);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(612119);
    }

    public static GoldBoxTab findByValue(int i) {
        if (i != 0) {
            if (i != 1) {
                return null;
            }
            return AdFree;
        }
        return Gold;
    }

    GoldBoxTab(int i) {
        this.value = i;
    }
}
