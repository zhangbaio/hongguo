package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum RobotType {
    RobotTypeGeneralization(1),
    RobotTypeHeader(2),
    RobotTypeSearchBook(3);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613378);
    }

    public static RobotType findByValue(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    return null;
                }
                return RobotTypeSearchBook;
            }
            return RobotTypeHeader;
        }
        return RobotTypeGeneralization;
    }

    RobotType(int i) {
        this.value = i;
    }
}
