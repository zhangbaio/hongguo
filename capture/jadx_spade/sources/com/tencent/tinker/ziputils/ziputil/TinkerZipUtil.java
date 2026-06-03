package com.tencent.tinker.ziputils.ziputil;

import com.bytedance.covode.number.Covode;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class TinkerZipUtil {
    static {
        Covode.recordClassIndex(653983);
    }

    public static boolean validateZipEntryName(File file, String str) {
        if (str != null && !str.isEmpty()) {
            try {
                String canonicalPath = file.getCanonicalPath();
                return file.toPath().resolve(str).toFile().getCanonicalPath().startsWith(canonicalPath + File.separator);
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static void extractTinkerEntry(TinkerZipFile tinkerZipFile, TinkerZipEntry tinkerZipEntry, TinkerZipOutputStream tinkerZipOutputStream) throws IOException {
        extractTinkerEntryWithNewName(tinkerZipFile, tinkerZipEntry, tinkerZipOutputStream, tinkerZipEntry.name);
    }

    public static void extractTinkerEntryWithNewName(TinkerZipFile tinkerZipFile, TinkerZipEntry tinkerZipEntry, TinkerZipOutputStream tinkerZipOutputStream, String str) throws IOException {
        InputStream inputStream;
        try {
            inputStream = tinkerZipFile.getInputStream(tinkerZipEntry);
            try {
                TinkerZipEntry tinkerZipEntry2 = new TinkerZipEntry(tinkerZipEntry);
                tinkerZipEntry2.name = str;
                tinkerZipOutputStream.putNextEntry(tinkerZipEntry2);
                byte[] bArr = new byte[16384];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read != -1) {
                        tinkerZipOutputStream.write(bArr, 0, read);
                    } else {
                        tinkerZipOutputStream.closeEntry();
                        inputStream.close();
                        return;
                    }
                }
            } catch (Throwable th) {
                th = th;
                if (inputStream != null) {
                    inputStream.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
        }
    }

    public static void extractLargeModifyFile(TinkerZipEntry tinkerZipEntry, File file, long j, TinkerZipOutputStream tinkerZipOutputStream) throws IOException {
        TinkerZipEntry tinkerZipEntry2 = new TinkerZipEntry(tinkerZipEntry);
        tinkerZipEntry2.setMethod(0);
        tinkerZipEntry2.setSize(file.length());
        tinkerZipEntry2.setCompressedSize(file.length());
        tinkerZipEntry2.setCrc(j);
        BufferedInputStream bufferedInputStream = null;
        try {
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new PolarisFileInputStreamWrapper(file));
            try {
                tinkerZipOutputStream.putNextEntry(new TinkerZipEntry(tinkerZipEntry2));
                byte[] bArr = new byte[16384];
                while (true) {
                    int read = bufferedInputStream2.read(bArr);
                    if (read != -1) {
                        tinkerZipOutputStream.write(bArr, 0, read);
                    } else {
                        tinkerZipOutputStream.closeEntry();
                        bufferedInputStream2.close();
                        return;
                    }
                }
            } catch (Throwable th) {
                th = th;
                bufferedInputStream = bufferedInputStream2;
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
