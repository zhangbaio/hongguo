package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum VideoType {
    Series(1),
    Video(2);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613570);
    }

    public static VideoType findByValue(int i) {
        if (i != 1) {
            if (i != 2) {
                return null;
            }
            return Video;
        }
        return Series;
    }

    VideoType(int i) {
        this.value = i;
    }
}
