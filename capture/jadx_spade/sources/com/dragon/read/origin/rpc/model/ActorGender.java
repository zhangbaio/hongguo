package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum ActorGender {
    Male(1),
    Female(2);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(612697);
    }

    public static ActorGender findByValue(int i) {
        if (i != 1) {
            if (i != 2) {
                return null;
            }
            return Female;
        }
        return Male;
    }

    ActorGender(int i) {
        this.value = i;
    }
}
