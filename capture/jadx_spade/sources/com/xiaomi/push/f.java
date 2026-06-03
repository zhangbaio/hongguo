package com.xiaomi.push;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class f {
    static final int a;
    static final int b;
    static final int c;
    static final int d;

    static int a(int i) {
        return i & 7;
    }

    static int a(int i, int i2) {
        return (i << 3) | i2;
    }

    public static int b(int i) {
        return i >>> 3;
    }

    static {
        Covode.recordClassIndex(655514);
        a = a(1, 3);
        b = a(1, 4);
        c = a(2, 0);
        d = a(3, 2);
    }
}
