package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum AIInsetScene {
    Default(0),
    Cover(1),
    Character(2),
    NovelUserInteraction(3),
    ShortArticleCover(4);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(612688);
    }

    public static AIInsetScene findByValue(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            return null;
                        }
                        return ShortArticleCover;
                    }
                    return NovelUserInteraction;
                }
                return Character;
            }
            return Cover;
        }
        return Default;
    }

    AIInsetScene(int i) {
        this.value = i;
    }
}
