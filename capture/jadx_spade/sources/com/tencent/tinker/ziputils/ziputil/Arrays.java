package com.tencent.tinker.ziputils.ziputil;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class Arrays {
    static {
        Covode.recordClassIndex(653971);
    }

    public static void checkOffsetAndCount(int i, int i2, int i3) {
        if ((i2 | i3) >= 0 && i2 <= i && i - i2 >= i3) {
        } else {
            throw new ArrayIndexOutOfBoundsException(i2);
        }
    }
}
