package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum ChatRecordMessageType {
    Normal(1),
    IsHint(2);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(612808);
    }

    public static ChatRecordMessageType findByValue(int i) {
        if (i != 1) {
            if (i != 2) {
                return null;
            }
            return IsHint;
        }
        return Normal;
    }

    ChatRecordMessageType(int i) {
        this.value = i;
    }
}
