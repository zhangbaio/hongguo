package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum ExposedPos {
    DetailPanelHotComment(1),
    DetailPanelAbstract(2),
    PlayerRecTags(3),
    PlayerRecTagsLower(4);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(612924);
    }

    public static ExposedPos findByValue(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        return null;
                    }
                    return PlayerRecTagsLower;
                }
                return PlayerRecTags;
            }
            return DetailPanelAbstract;
        }
        return DetailPanelHotComment;
    }

    ExposedPos(int i) {
        this.value = i;
    }
}
