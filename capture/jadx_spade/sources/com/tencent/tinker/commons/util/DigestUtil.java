package com.tencent.tinker.commons.util;

import com.bytedance.covode.number.Covode;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.CRC32;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class DigestUtil {
    static {
        Covode.recordClassIndex(653678);
    }

    private DigestUtil() {
        throw new UnsupportedOperationException();
    }

    public static long getCRC32(File file) throws IOException {
        BufferedInputStream bufferedInputStream = null;
        try {
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new PolarisFileInputStreamWrapper(file));
            try {
                long crc32 = getCRC32(bufferedInputStream2);
                IOHelper.closeQuietly(bufferedInputStream2);
                return crc32;
            } catch (Throwable th) {
                th = th;
                bufferedInputStream = bufferedInputStream2;
                IOHelper.closeQuietly(bufferedInputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static long getCRC32(InputStream inputStream) throws IOException {
        CRC32 crc32 = new CRC32();
        byte[] bArr = new byte[4096];
        while (true) {
            int read = inputStream.read(bArr);
            if (read > 0) {
                crc32.update(bArr, 0, read);
            } else {
                return crc32.getValue();
            }
        }
    }

    public static long getCRC32(byte[] bArr, int i, int i2) {
        CRC32 crc32 = new CRC32();
        crc32.update(bArr, i, i2);
        return crc32.getValue();
    }
}
