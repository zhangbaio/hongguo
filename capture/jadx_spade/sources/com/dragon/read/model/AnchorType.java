package com.dragon.read.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum AnchorType {
    EpisodeEndInnerNormal(1),
    EpisodeEndInnerMarquee(2),
    EpisodeEndInnerNormalCommentList(3);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(612009);
    }

    public static AnchorType findByValue(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    return null;
                }
                return EpisodeEndInnerNormalCommentList;
            }
            return EpisodeEndInnerMarquee;
        }
        return EpisodeEndInnerNormal;
    }

    AnchorType(int i) {
        this.value = i;
    }
}
