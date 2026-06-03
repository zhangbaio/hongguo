package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum PlayletVideoBindStatus {
    Unbound(0),
    Bound(1);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613304);
    }

    public static PlayletVideoBindStatus findByValue(int i) {
        if (i != 0) {
            if (i != 1) {
                return null;
            }
            return Bound;
        }
        return Unbound;
    }

    PlayletVideoBindStatus(int i) {
        this.value = i;
    }
}
