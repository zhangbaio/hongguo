package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum DetailPageType {
    OTHER(0),
    NOTICE(1),
    ACTIVITY(2),
    CLASS(3),
    HELP(4);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(612886);
    }

    public static DetailPageType findByValue(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            return null;
                        }
                        return HELP;
                    }
                    return CLASS;
                }
                return ACTIVITY;
            }
            return NOTICE;
        }
        return OTHER;
    }

    DetailPageType(int i) {
        this.value = i;
    }
}
