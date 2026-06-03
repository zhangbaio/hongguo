package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum DividerType {
    Default(0),
    VerticalLine(1),
    Point(2);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(612891);
    }

    public static DividerType findByValue(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    return null;
                }
                return Point;
            }
            return VerticalLine;
        }
        return Default;
    }

    DividerType(int i) {
        this.value = i;
    }
}
