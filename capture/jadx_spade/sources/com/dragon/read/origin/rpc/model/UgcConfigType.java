package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum UgcConfigType {
    ItemComment(1),
    BookComment(2),
    IdeaComment(3),
    IdeaCommentShow(4);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613503);
    }

    public static UgcConfigType findByValue(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        return null;
                    }
                    return IdeaCommentShow;
                }
                return IdeaComment;
            }
            return BookComment;
        }
        return ItemComment;
    }

    UgcConfigType(int i) {
        this.value = i;
    }
}
