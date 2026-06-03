package com.tencent.tinker.android.dex;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class DexFormat {
    static {
        Covode.recordClassIndex(653607);
    }

    private DexFormat() {
    }

    public static String apiToMagic(int i) {
        String str;
        if (i >= 14) {
            str = "036";
        } else {
            str = "035";
        }
        return "dex\n" + str + "\u0000";
    }

    public static int magicToApi(byte[] bArr) {
        if (bArr.length == 8 && bArr[0] == 100 && bArr[1] == 101 && bArr[2] == 120 && bArr[3] == 10 && bArr[7] == 0) {
            String str = "" + ((char) bArr[4]) + ((char) bArr[5]) + ((char) bArr[6]);
            if (str.equals("036")) {
                return 14;
            }
            if (str.equals("035")) {
                return 13;
            }
        }
        return -1;
    }
}
