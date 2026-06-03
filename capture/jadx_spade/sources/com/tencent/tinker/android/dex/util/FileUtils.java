package com.tencent.tinker.android.dex.util;

import com.bytedance.covode.number.Covode;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class FileUtils {
    static {
        Covode.recordClassIndex(653626);
    }

    private FileUtils() {
    }

    public static byte[] readStream(InputStream inputStream) throws IOException {
        return readStream(inputStream, 32768);
    }

    public static byte[] readFile(String str) throws IOException {
        return readFile((File) new PolarisFileWrapper(str));
    }

    public static boolean hasArchiveSuffix(String str) {
        if (!str.endsWith(".zip") && !str.endsWith(".jar") && !str.endsWith(".apk")) {
            return false;
        }
        return true;
    }

    public static byte[] readFile(File file) throws IOException {
        if (file.exists()) {
            if (file.isFile()) {
                if (file.canRead()) {
                    long length = file.length();
                    int i = (int) length;
                    if (i == length) {
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i);
                        BufferedInputStream bufferedInputStream = null;
                        try {
                            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new PolarisFileInputStreamWrapper(file));
                            try {
                                byte[] bArr = new byte[8192];
                                while (true) {
                                    int read = bufferedInputStream2.read(bArr);
                                    if (read > 0) {
                                        byteArrayOutputStream.write(bArr, 0, read);
                                    } else {
                                        try {
                                            break;
                                        } catch (Exception unused) {
                                        }
                                    }
                                }
                                bufferedInputStream2.close();
                                return byteArrayOutputStream.toByteArray();
                            } catch (Throwable th) {
                                th = th;
                                bufferedInputStream = bufferedInputStream2;
                                if (bufferedInputStream != null) {
                                    try {
                                        bufferedInputStream.close();
                                    } catch (Exception unused2) {
                                    }
                                }
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } else {
                        throw new RuntimeException(file + ": file too long");
                    }
                } else {
                    throw new RuntimeException(file + ": file not readable");
                }
            } else {
                throw new RuntimeException(file + ": not a file");
            }
        } else {
            throw new RuntimeException(file + ": file not found");
        }
    }

    public static byte[] readStream(InputStream inputStream, int i) throws IOException {
        if (i <= 0) {
            i = 32768;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i);
        byte[] bArr = new byte[8192];
        while (true) {
            int read = inputStream.read(bArr);
            if (read > 0) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                return byteArrayOutputStream.toByteArray();
            }
        }
    }
}
