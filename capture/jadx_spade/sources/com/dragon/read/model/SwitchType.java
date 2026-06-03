package com.dragon.read.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum SwitchType {
    DAILYOPEN(10),
    DAILYCLOSE(11),
    CLOSE(20),
    REOPEN(21);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(612259);
    }

    public static SwitchType findByValue(int i) {
        if (i != 10) {
            if (i != 11) {
                if (i != 20) {
                    if (i != 21) {
                        return null;
                    }
                    return REOPEN;
                }
                return CLOSE;
            }
            return DAILYCLOSE;
        }
        return DAILYOPEN;
    }

    SwitchType(int i) {
        this.value = i;
    }
}
