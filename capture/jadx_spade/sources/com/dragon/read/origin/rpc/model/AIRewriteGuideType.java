package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum AIRewriteGuideType {
    Lighthearted(1),
    Serious(2),
    Rhetorical(3),
    CustomGuide(100);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(612695);
    }

    public static AIRewriteGuideType findByValue(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 100) {
                        return null;
                    }
                    return CustomGuide;
                }
                return Rhetorical;
            }
            return Serious;
        }
        return Lighthearted;
    }

    AIRewriteGuideType(int i) {
        this.value = i;
    }
}
