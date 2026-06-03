package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum AICharacterSortType {
    Time(1),
    LetterASC(2),
    LetterDES(3),
    MainCharacter(4);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(612664);
    }

    public static AICharacterSortType findByValue(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        return null;
                    }
                    return MainCharacter;
                }
                return LetterDES;
            }
            return LetterASC;
        }
        return Time;
    }

    AICharacterSortType(int i) {
        this.value = i;
    }
}
