package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum UgcActorType {
    Unregistered(1),
    Registered(2);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613491);
    }

    public static UgcActorType findByValue(int i) {
        if (i != 1) {
            if (i != 2) {
                return null;
            }
            return Registered;
        }
        return Unregistered;
    }

    UgcActorType(int i) {
        this.value = i;
    }
}
