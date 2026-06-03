package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum ShortArticleAuditFailType {
    TITLE(0),
    CONTENT(1),
    THUMBURI(2),
    BOOK_THUMBURI(3);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613434);
    }

    public static ShortArticleAuditFailType findByValue(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return null;
                    }
                    return BOOK_THUMBURI;
                }
                return THUMBURI;
            }
            return CONTENT;
        }
        return TITLE;
    }

    ShortArticleAuditFailType(int i) {
        this.value = i;
    }
}
