package com.ss.ttm.ttvideodecode;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class Native {
    static {
        Covode.recordClassIndex(652221);
    }

    private static native byte[] _encryptAesCbc128(byte[] bArr, byte[] bArr2);

    private static native String _getDecodedStr(byte[] bArr, byte[] bArr2);

    private static native byte[] _getSignature(String str);

    private static native int _getSupportedMethod();

    public static int getSupportedMethod() {
        return _getSupportedMethod();
    }

    public static byte[] getSignature(String str) {
        return _getSignature(str);
    }

    public static byte[] encryptAesCbc128(byte[] bArr, byte[] bArr2) {
        return _encryptAesCbc128(bArr, bArr2);
    }

    public static String getDecodedStr(byte[] bArr, byte[] bArr2) {
        return _getDecodedStr(bArr, bArr2);
    }
}
