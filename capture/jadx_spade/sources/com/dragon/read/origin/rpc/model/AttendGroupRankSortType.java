package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum AttendGroupRankSortType {
    WordNumber(1),
    StarValue(2);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(612741);
    }

    public static AttendGroupRankSortType findByValue(int i) {
        if (i != 1) {
            if (i != 2) {
                return null;
            }
            return StarValue;
        }
        return WordNumber;
    }

    AttendGroupRankSortType(int i) {
        this.value = i;
    }
}
