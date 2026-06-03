package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum ActorPickType {
    Comment(1),
    Digg(2),
    Collect(3);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(612699);
    }

    public static ActorPickType findByValue(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    return null;
                }
                return Collect;
            }
            return Digg;
        }
        return Comment;
    }

    ActorPickType(int i) {
        this.value = i;
    }
}
