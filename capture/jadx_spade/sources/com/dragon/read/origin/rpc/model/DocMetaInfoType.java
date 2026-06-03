package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum DocMetaInfoType {
    SERIAL(0),
    STORY(1),
    WTT(2),
    PLAYLET(3);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(612895);
    }

    public static DocMetaInfoType findByValue(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return null;
                    }
                    return PLAYLET;
                }
                return WTT;
            }
            return STORY;
        }
        return SERIAL;
    }

    DocMetaInfoType(int i) {
        this.value = i;
    }
}
