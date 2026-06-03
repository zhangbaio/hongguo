package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum ButtonTextType {
    Participation(0),
    Creation(1);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(612784);
    }

    public static ButtonTextType findByValue(int i) {
        if (i != 0) {
            if (i != 1) {
                return null;
            }
            return Creation;
        }
        return Participation;
    }

    ButtonTextType(int i) {
        this.value = i;
    }
}
