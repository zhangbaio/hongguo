package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum AIGCVideoType {
    PPTVideo(1),
    LiveVideo(2);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(612683);
    }

    public static AIGCVideoType findByValue(int i) {
        if (i != 1) {
            if (i != 2) {
                return null;
            }
            return LiveVideo;
        }
        return PPTVideo;
    }

    AIGCVideoType(int i) {
        this.value = i;
    }
}
