package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum PlayletChapterDuplicateStateCode {
    Passed(1),
    ParagraphDuplicated(-1),
    ChapterDuplicated(-2);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613288);
    }

    public static PlayletChapterDuplicateStateCode findByValue(int i) {
        if (i != -2) {
            if (i != -1) {
                if (i != 1) {
                    return null;
                }
                return Passed;
            }
            return ParagraphDuplicated;
        }
        return ChapterDuplicated;
    }

    PlayletChapterDuplicateStateCode(int i) {
        this.value = i;
    }
}
