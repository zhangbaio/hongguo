package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum RealLevel {
    RealLevel1Comment(1),
    RealLevel2ReplyL1(2),
    RealLevel3ReplyL2(3);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613358);
    }

    public static RealLevel findByValue(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    return null;
                }
                return RealLevel3ReplyL2;
            }
            return RealLevel2ReplyL1;
        }
        return RealLevel1Comment;
    }

    RealLevel(int i) {
        this.value = i;
    }
}
