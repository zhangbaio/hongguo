package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum AIContentType {
    Image(1),
    Video(2),
    MultiImage(3);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(612667);
    }

    public static AIContentType findByValue(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    return null;
                }
                return MultiImage;
            }
            return Video;
        }
        return Image;
    }

    AIContentType(int i) {
        this.value = i;
    }
}
