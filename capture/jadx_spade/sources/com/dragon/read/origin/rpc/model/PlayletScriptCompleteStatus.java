package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum PlayletScriptCompleteStatus {
    Writing(0),
    Completable(1),
    Auditing(2),
    Passed(3),
    Rejected(4),
    Returned(5);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613296);
    }

    public static PlayletScriptCompleteStatus findByValue(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                return null;
                            }
                            return Returned;
                        }
                        return Rejected;
                    }
                    return Passed;
                }
                return Auditing;
            }
            return Completable;
        }
        return Writing;
    }

    PlayletScriptCompleteStatus(int i) {
        this.value = i;
    }
}
