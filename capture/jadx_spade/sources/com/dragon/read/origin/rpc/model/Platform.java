package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum Platform {
    WEB(0),
    APP(1);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613286);
    }

    public static Platform findByValue(int i) {
        if (i != 0) {
            if (i != 1) {
                return null;
            }
            return APP;
        }
        return WEB;
    }

    Platform(int i) {
        this.value = i;
    }
}
