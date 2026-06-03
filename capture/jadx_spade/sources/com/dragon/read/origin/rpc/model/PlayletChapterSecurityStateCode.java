package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum PlayletChapterSecurityStateCode {
    Passed(1),
    Risked(-1);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613291);
    }

    public static PlayletChapterSecurityStateCode findByValue(int i) {
        if (i != -1) {
            if (i != 1) {
                return null;
            }
            return Passed;
        }
        return Risked;
    }

    PlayletChapterSecurityStateCode(int i) {
        this.value = i;
    }
}
