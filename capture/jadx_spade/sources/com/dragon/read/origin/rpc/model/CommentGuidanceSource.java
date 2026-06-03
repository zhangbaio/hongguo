package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum CommentGuidanceSource {
    ItemInnerFeed(1);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(612831);
    }

    public static CommentGuidanceSource findByValue(int i) {
        if (i != 1) {
            return null;
        }
        return ItemInnerFeed;
    }

    CommentGuidanceSource(int i) {
        this.value = i;
    }
}
