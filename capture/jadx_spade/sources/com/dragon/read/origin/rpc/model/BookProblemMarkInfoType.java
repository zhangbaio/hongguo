package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum BookProblemMarkInfoType {
    SAFE(1),
    COPYRIGHT(2);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(612781);
    }

    public static BookProblemMarkInfoType findByValue(int i) {
        if (i != 1) {
            if (i != 2) {
                return null;
            }
            return COPYRIGHT;
        }
        return SAFE;
    }

    BookProblemMarkInfoType(int i) {
        this.value = i;
    }
}
