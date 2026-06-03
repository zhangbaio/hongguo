package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum ChapterAdType {
    IndustryWord(1),
    KeyWord(2);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(612790);
    }

    public static ChapterAdType findByValue(int i) {
        if (i != 1) {
            if (i != 2) {
                return null;
            }
            return KeyWord;
        }
        return IndustryWord;
    }

    ChapterAdType(int i) {
        this.value = i;
    }
}
