package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum BannedModifyLocation {
    Cover(1),
    Name(2),
    Introduction(3);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(612765);
    }

    public static BannedModifyLocation findByValue(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    return null;
                }
                return Introduction;
            }
            return Name;
        }
        return Cover;
    }

    BannedModifyLocation(int i) {
        this.value = i;
    }
}
