package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum UgcTruncateFlag {
    NoTruncate(1),
    TruncateByLock(2),
    TruncateByContent(3),
    NoTrunCateByLock(4),
    NoTrunCateByUnLock(5);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613531);
    }

    public static UgcTruncateFlag findByValue(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        if (i != 5) {
                            return null;
                        }
                        return NoTrunCateByUnLock;
                    }
                    return NoTrunCateByLock;
                }
                return TruncateByContent;
            }
            return TruncateByLock;
        }
        return NoTruncate;
    }

    UgcTruncateFlag(int i) {
        this.value = i;
    }
}
