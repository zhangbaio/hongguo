package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum MedalType {
    NewOne(1),
    Writing(2),
    Activity(3),
    Level(4);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613216);
    }

    public static MedalType findByValue(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        return null;
                    }
                    return Level;
                }
                return Activity;
            }
            return Writing;
        }
        return NewOne;
    }

    MedalType(int i) {
        this.value = i;
    }
}
