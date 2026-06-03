package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum PlayletStrategyOplogAction {
    Insert(1),
    Delete(2),
    Modify(3),
    Publish(4),
    Unpublish(5);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613300);
    }

    public static PlayletStrategyOplogAction findByValue(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        if (i != 5) {
                            return null;
                        }
                        return Unpublish;
                    }
                    return Publish;
                }
                return Modify;
            }
            return Delete;
        }
        return Insert;
    }

    PlayletStrategyOplogAction(int i) {
        this.value = i;
    }
}
