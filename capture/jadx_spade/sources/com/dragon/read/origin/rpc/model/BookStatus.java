package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum BookStatus {
    NONE(0),
    ONLINE(1),
    AUDIT(2),
    OFFLINE(3),
    FAILED(4);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(612782);
    }

    public static BookStatus findByValue(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            return null;
                        }
                        return FAILED;
                    }
                    return OFFLINE;
                }
                return AUDIT;
            }
            return ONLINE;
        }
        return NONE;
    }

    BookStatus(int i) {
        this.value = i;
    }
}
