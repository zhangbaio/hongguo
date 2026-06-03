package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum CelebrityListType {
    All(1),
    Hot(2),
    MainCreators(3);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(612789);
    }

    public static CelebrityListType findByValue(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    return null;
                }
                return MainCreators;
            }
            return Hot;
        }
        return All;
    }

    CelebrityListType(int i) {
        this.value = i;
    }
}
