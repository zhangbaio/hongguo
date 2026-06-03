package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum NoticeType {
    ALL(-1),
    NEWS(0),
    CLASS(1),
    ACTIVITY(2),
    INTERVIEW(3),
    DAGUAN(4),
    PLATFORM(5);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613260);
    }

    public static NoticeType findByValue(int i) {
        switch (i) {
            case -1:
                return ALL;
            case 0:
                return NEWS;
            case 1:
                return CLASS;
            case 2:
                return ACTIVITY;
            case 3:
                return INTERVIEW;
            case 4:
                return DAGUAN;
            case 5:
                return PLATFORM;
            default:
                return null;
        }
    }

    NoticeType(int i) {
        this.value = i;
    }
}
