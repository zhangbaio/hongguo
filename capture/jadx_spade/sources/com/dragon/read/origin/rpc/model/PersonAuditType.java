package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum PersonAuditType {
    ShortArticle(1);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613282);
    }

    public static PersonAuditType findByValue(int i) {
        if (i != 1) {
            return null;
        }
        return ShortArticle;
    }

    PersonAuditType(int i) {
        this.value = i;
    }
}
