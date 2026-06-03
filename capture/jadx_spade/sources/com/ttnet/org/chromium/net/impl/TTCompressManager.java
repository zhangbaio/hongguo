package com.ttnet.org.chromium.net.impl;

import com.bytedance.covode.number.Covode;
import com.ttnet.org.chromium.base.annotations.JNINamespace;

@JNINamespace("cronet")
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class TTCompressManager {
    static {
        Covode.recordClassIndex(654650);
    }

    private static native byte[] nativeCompressData(byte[] bArr, int i, int i2, int i3);

    private static native byte[] nativeDecompressData(byte[] bArr, int i, int i2);

    public enum CompressType {
        GZIP(1),
        BROTLI(2),
        ZSTD(3);

        final int mType;

        public int getValue() {
            return this.mType;
        }

        static {
            Covode.recordClassIndex(654651);
        }

        CompressType(int i) {
            this.mType = i;
        }
    }

    public static byte[] b(byte[] bArr, int i, CompressType compressType) {
        return nativeDecompressData(bArr, i, compressType.getValue());
    }

    public static byte[] a(byte[] bArr, int i, int i2, CompressType compressType) {
        return nativeCompressData(bArr, i, i2, compressType.getValue());
    }
}
