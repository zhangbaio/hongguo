package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum AICharacterClassification {
    MainCharacter(1),
    Villain(2),
    Protagonist(3),
    Neutral(4),
    Unset(0);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(612662);
    }

    public static AICharacterClassification findByValue(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            return null;
                        }
                        return Neutral;
                    }
                    return Protagonist;
                }
                return Villain;
            }
            return MainCharacter;
        }
        return Unset;
    }

    AICharacterClassification(int i) {
        this.value = i;
    }
}
