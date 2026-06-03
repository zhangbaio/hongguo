package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum EditArticleFromSource {
    DEFAULT(0),
    BOOK_PROBLEM_MARK(1),
    BOOK_COPYRIGHT_PROBLEM_MARK(2);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(612906);
    }

    public static EditArticleFromSource findByValue(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    return null;
                }
                return BOOK_COPYRIGHT_PROBLEM_MARK;
            }
            return BOOK_PROBLEM_MARK;
        }
        return DEFAULT;
    }

    EditArticleFromSource(int i) {
        this.value = i;
    }
}
