package com.ttreader.tttext;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class s {
    public static float a;

    static {
        Covode.recordClassIndex(654829);
        a = 1.0f;
    }

    public static float b(float f) {
        return f / a;
    }

    public static float a(float f) {
        return f * a;
    }

    public static void c(float f) {
        synchronized (s.class) {
            a = f / 160.0f;
        }
    }
}
