package com.dragon.read.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum PlatformType {
    unknown(0),
    client(1),
    front_end(2);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(612192);
    }

    public static PlatformType findByValue(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    return null;
                }
                return front_end;
            }
            return client;
        }
        return unknown;
    }

    PlatformType(int i) {
        this.value = i;
    }
}
