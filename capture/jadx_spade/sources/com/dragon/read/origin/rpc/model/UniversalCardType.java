package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum UniversalCardType {
    StoryRankCard(1),
    StoryTopicCard(2),
    StoryTopCard(3);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613537);
    }

    public static UniversalCardType findByValue(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    return null;
                }
                return StoryTopCard;
            }
            return StoryTopicCard;
        }
        return StoryRankCard;
    }

    UniversalCardType(int i) {
        this.value = i;
    }
}
