package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum StickPosition {
    UnStick(0),
    OpStick(1),
    AuthorStick(2);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613461);
    }

    public static StickPosition findByValue(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    return null;
                }
                return AuthorStick;
            }
            return OpStick;
        }
        return UnStick;
    }

    StickPosition(int i) {
        this.value = i;
    }
}
