package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum PlayletGenre {
    ShortPlay(203),
    MotionComic(205);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613293);
    }

    public static PlayletGenre findByValue(int i) {
        if (i != 203) {
            if (i != 205) {
                return null;
            }
            return MotionComic;
        }
        return ShortPlay;
    }

    PlayletGenre(int i) {
        this.value = i;
    }
}
