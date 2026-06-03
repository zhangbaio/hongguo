package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum PosterType {
    UNKNOWN(0),
    BOOK_POSTER(1);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613312);
    }

    public static PosterType findByValue(int i) {
        if (i != 0) {
            if (i != 1) {
                return null;
            }
            return BOOK_POSTER;
        }
        return UNKNOWN;
    }

    PosterType(int i) {
        this.value = i;
    }
}
