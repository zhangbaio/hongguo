package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum AIInsetType {
    Text2Image(0),
    Image2Image(1);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(612690);
    }

    public static AIInsetType findByValue(int i) {
        if (i != 0) {
            if (i != 1) {
                return null;
            }
            return Image2Image;
        }
        return Text2Image;
    }

    AIInsetType(int i) {
        this.value = i;
    }
}
