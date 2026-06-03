package com.xiaomi.push;

import android.content.Context;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class aa {
    static final char[] a;

    static {
        Covode.recordClassIndex(655327);
        a = "0123456789ABCDEF".toCharArray();
    }

    public static boolean a(Context context) {
        return z.a;
    }

    public static String a(byte[] bArr, int i, int i2) {
        StringBuilder sb = new StringBuilder(i2 * 2);
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = bArr[i + i3] & 255;
            char[] cArr = a;
            sb.append(cArr[i4 >> 4]);
            sb.append(cArr[i4 & 15]);
        }
        return sb.toString();
    }
}
