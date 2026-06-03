package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum HighlightsType {
    Default(0),
    Character(1),
    Scene(2),
    Pleasure(3);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613185);
    }

    public static HighlightsType findByValue(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return null;
                    }
                    return Pleasure;
                }
                return Scene;
            }
            return Character;
        }
        return Default;
    }

    HighlightsType(int i) {
        this.value = i;
    }
}
