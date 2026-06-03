package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum OriginAppLevel {
    INIT(0),
    PROCESSS(1),
    OBSERVE(2),
    GOOD(3),
    BAD(4),
    NORMAL(5);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613271);
    }

    public static OriginAppLevel findByValue(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                return null;
                            }
                            return NORMAL;
                        }
                        return BAD;
                    }
                    return GOOD;
                }
                return OBSERVE;
            }
            return PROCESSS;
        }
        return INIT;
    }

    OriginAppLevel(int i) {
        this.value = i;
    }
}
