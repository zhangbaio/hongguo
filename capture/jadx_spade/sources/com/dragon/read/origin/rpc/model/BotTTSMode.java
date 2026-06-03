package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum BotTTSMode {
    AutoPlay(1),
    ManualPlay(2);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(612783);
    }

    public static BotTTSMode findByValue(int i) {
        if (i != 1) {
            if (i != 2) {
                return null;
            }
            return ManualPlay;
        }
        return AutoPlay;
    }

    BotTTSMode(int i) {
        this.value = i;
    }
}
