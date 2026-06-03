package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum ShortArticleCheckPreType {
    NameDuplicate(1);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613439);
    }

    public static ShortArticleCheckPreType findByValue(int i) {
        if (i != 1) {
            return null;
        }
        return NameDuplicate;
    }

    ShortArticleCheckPreType(int i) {
        this.value = i;
    }
}
