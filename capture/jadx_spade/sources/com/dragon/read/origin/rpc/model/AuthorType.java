package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum AuthorType {
    Unknown(0),
    Institution(1),
    Individual(2);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(612759);
    }

    public static AuthorType findByValue(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    return null;
                }
                return Individual;
            }
            return Institution;
        }
        return Unknown;
    }

    AuthorType(int i) {
        this.value = i;
    }
}
