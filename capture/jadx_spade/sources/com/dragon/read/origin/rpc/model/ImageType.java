package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum ImageType {
    Static(0),
    PNG(1),
    GIF(2),
    Expand(3),
    User(4);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613193);
    }

    public static ImageType findByValue(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            return null;
                        }
                        return User;
                    }
                    return Expand;
                }
                return GIF;
            }
            return PNG;
        }
        return Static;
    }

    ImageType(int i) {
        this.value = i;
    }
}
