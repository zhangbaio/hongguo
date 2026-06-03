package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum CommentTagType {
    PreSet(1),
    AI(2),
    UserDefined(3);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(612833);
    }

    public static CommentTagType findByValue(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    return null;
                }
                return UserDefined;
            }
            return AI;
        }
        return PreSet;
    }

    CommentTagType(int i) {
        this.value = i;
    }
}
