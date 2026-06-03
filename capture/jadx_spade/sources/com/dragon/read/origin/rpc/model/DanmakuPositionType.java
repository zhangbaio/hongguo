package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum DanmakuPositionType {
    Rolling(0),
    Bottom(1),
    Top(2);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(612866);
    }

    public static DanmakuPositionType findByValue(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    return null;
                }
                return Top;
            }
            return Bottom;
        }
        return Rolling;
    }

    DanmakuPositionType(int i) {
        this.value = i;
    }
}
