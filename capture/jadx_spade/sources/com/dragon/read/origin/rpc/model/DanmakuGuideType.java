package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum DanmakuGuideType {
    Default(0),
    Official(1),
    Comment(2);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(612865);
    }

    public static DanmakuGuideType findByValue(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    return null;
                }
                return Comment;
            }
            return Official;
        }
        return Default;
    }

    DanmakuGuideType(int i) {
        this.value = i;
    }
}
