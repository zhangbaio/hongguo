package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum MessageSubType {
    INVITE_BOOK_COMMENT_NOTIFY(1),
    TOP_COMMENTATOR_NOTIFY(2);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613218);
    }

    public static MessageSubType findByValue(int i) {
        if (i != 1) {
            if (i != 2) {
                return null;
            }
            return TOP_COMMENTATOR_NOTIFY;
        }
        return INVITE_BOOK_COMMENT_NOTIFY;
    }

    MessageSubType(int i) {
        this.value = i;
    }
}
