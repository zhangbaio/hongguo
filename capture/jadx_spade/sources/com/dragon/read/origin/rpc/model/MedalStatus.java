package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum MedalStatus {
    Offline(0),
    Active(1);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613215);
    }

    public static MedalStatus findByValue(int i) {
        if (i != 0) {
            if (i != 1) {
                return null;
            }
            return Active;
        }
        return Offline;
    }

    MedalStatus(int i) {
        this.value = i;
    }
}
