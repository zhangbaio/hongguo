package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum AuthorSpeakRefuseType {
    NotSet(0),
    Text(1),
    Picture(2);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(612757);
    }

    public static AuthorSpeakRefuseType findByValue(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    return null;
                }
                return Picture;
            }
            return Text;
        }
        return NotSet;
    }

    AuthorSpeakRefuseType(int i) {
        this.value = i;
    }
}
