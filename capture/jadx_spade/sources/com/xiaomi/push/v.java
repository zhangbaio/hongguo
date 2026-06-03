package com.xiaomi.push;

import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.util.Date;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class v {
    public static final String[] a;

    static {
        Covode.recordClassIndex(655755);
        a = new String[]{"jpg", "png", "bmp", "gif", "webp"};
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    public static byte[] a(byte[] bArr) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.finish();
            gZIPOutputStream.close();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Exception unused) {
            return bArr;
        }
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0062: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]) (LINE:17104994), block:B:22:0x0062 */
    public static String a(File file) {
        InputStreamReader inputStreamReader;
        Closeable closeable;
        StringWriter stringWriter = new StringWriter();
        Closeable closeable2 = null;
        try {
            try {
                inputStreamReader = new InputStreamReader(new BufferedInputStream(new PolarisFileInputStreamWrapper(file)));
                try {
                    char[] cArr = new char[2048];
                    while (true) {
                        int read = inputStreamReader.read(cArr);
                        if (read != -1) {
                            stringWriter.write(cArr, 0, read);
                        } else {
                            String stringWriter2 = stringWriter.toString();
                            a(inputStreamReader);
                            a(stringWriter);
                            return stringWriter2;
                        }
                    }
                } catch (IOException e) {
                    e = e;
                    com.xiaomi.channel.commonutils.logger.b.c("read file :" + file.getAbsolutePath() + " failure :" + e.getMessage());
                    a(inputStreamReader);
                    a(stringWriter);
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                closeable2 = closeable;
                a(closeable2);
                a(stringWriter);
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            inputStreamReader = null;
        } catch (Throwable th2) {
            th = th2;
            a(closeable2);
            a(stringWriter);
            throw th;
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m769a(File file) {
        try {
            if (file.isDirectory()) {
                return false;
            }
            if (file.exists()) {
                return true;
            }
            File parentFile = file.getParentFile();
            if (!parentFile.exists() && !parentFile.mkdirs()) {
                return false;
            }
            return file.createNewFile();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static byte[] a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[8192];
        while (true) {
            try {
                try {
                    int read = inputStream.read(bArr, 0, 8192);
                    if (read > 0) {
                        byteArrayOutputStream.write(bArr, 0, read);
                    } else {
                        return byteArrayOutputStream.toByteArray();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    a((Closeable) inputStream);
                    a(byteArrayOutputStream);
                    return null;
                }
            } finally {
                a((Closeable) inputStream);
                a(byteArrayOutputStream);
            }
        }
    }

    public static void a(File file, File file2) {
        ZipOutputStream zipOutputStream;
        ZipOutputStream zipOutputStream2 = null;
        try {
            try {
                zipOutputStream = new ZipOutputStream(new PolarisFileOutputStreamWrapper(file, false));
            } catch (Throwable th) {
                th = th;
            }
            try {
                a(zipOutputStream, file2, null, null);
                a(zipOutputStream);
            } catch (FileNotFoundException unused) {
                zipOutputStream2 = zipOutputStream;
                a(zipOutputStream2);
            } catch (IOException e) {
                e = e;
                zipOutputStream2 = zipOutputStream;
                com.xiaomi.channel.commonutils.logger.b.m54a("zip file failure + " + e.getMessage());
                a(zipOutputStream2);
            } catch (Throwable th2) {
                th = th2;
                zipOutputStream2 = zipOutputStream;
                a(zipOutputStream2);
                throw th;
            }
        } catch (FileNotFoundException unused2) {
            a(zipOutputStream2);
        } catch (IOException e2) {
            e = e2;
        }
    }

    public static void b(File file, File file2) {
        PolarisFileOutputStreamWrapper polarisFileOutputStreamWrapper;
        if (file.getAbsolutePath().equals(file2.getAbsolutePath())) {
            return;
        }
        InputStream inputStream = null;
        try {
            InputStream polarisFileInputStreamWrapper = new PolarisFileInputStreamWrapper(file);
            try {
                polarisFileOutputStreamWrapper = new PolarisFileOutputStreamWrapper(file2);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = polarisFileInputStreamWrapper.read(bArr);
                        if (read >= 0) {
                            polarisFileOutputStreamWrapper.write(bArr, 0, read);
                        } else {
                            polarisFileInputStreamWrapper.close();
                            polarisFileOutputStreamWrapper.close();
                            return;
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    inputStream = polarisFileInputStreamWrapper;
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (polarisFileOutputStreamWrapper != null) {
                        polarisFileOutputStreamWrapper.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                polarisFileOutputStreamWrapper = null;
            }
        } catch (Throwable th3) {
            th = th3;
            polarisFileOutputStreamWrapper = null;
        }
    }

    public static void a(File file, String str) {
        BufferedWriter bufferedWriter;
        if (!file.exists()) {
            com.xiaomi.channel.commonutils.logger.b.c("mkdir " + file.getAbsolutePath());
            file.getParentFile().mkdirs();
        }
        BufferedWriter bufferedWriter2 = null;
        try {
            try {
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(new PolarisFileOutputStreamWrapper(file)));
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e) {
            e = e;
        }
        try {
            bufferedWriter.write(str);
            a(bufferedWriter);
        } catch (IOException e2) {
            e = e2;
            bufferedWriter2 = bufferedWriter;
            com.xiaomi.channel.commonutils.logger.b.c("write file :" + file.getAbsolutePath() + " failure :" + e.getMessage());
            a(bufferedWriter2);
        } catch (Throwable th2) {
            th = th2;
            bufferedWriter2 = bufferedWriter;
            a(bufferedWriter2);
            throw th;
        }
    }

    public static void a(ZipOutputStream zipOutputStream, File file, String str, FileFilter fileFilter) {
        File[] listFiles;
        String str2 = "";
        if (str == null) {
            str = "";
        }
        PolarisFileInputStreamWrapper polarisFileInputStreamWrapper = null;
        try {
            try {
                if (file.isDirectory()) {
                    if (fileFilter != null) {
                        listFiles = file.listFiles(fileFilter);
                    } else {
                        listFiles = file.listFiles();
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    String str3 = File.separator;
                    sb.append(str3);
                    zipOutputStream.putNextEntry(new ZipEntry(sb.toString()));
                    if (!TextUtils.isEmpty(str)) {
                        str2 = str + str3;
                    }
                    for (int i = 0; i < listFiles.length; i++) {
                        a(zipOutputStream, listFiles[i], str2 + listFiles[i].getName(), null);
                    }
                    File[] listFiles2 = file.listFiles(new FileFilter() { // from class: com.xiaomi.push.v.1
                        @Override // java.io.FileFilter
                        public boolean accept(File file2) {
                            return file2.isDirectory();
                        }
                    });
                    if (listFiles2 != null) {
                        for (File file2 : listFiles2) {
                            a(zipOutputStream, file2, str2 + File.separator + file2.getName(), fileFilter);
                        }
                    }
                } else {
                    if (!TextUtils.isEmpty(str)) {
                        zipOutputStream.putNextEntry(new ZipEntry(str));
                    } else {
                        zipOutputStream.putNextEntry(new ZipEntry(String.valueOf(new Date().getTime()) + ".txt"));
                    }
                    PolarisFileInputStreamWrapper polarisFileInputStreamWrapper2 = new PolarisFileInputStreamWrapper(file);
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = polarisFileInputStreamWrapper2.read(bArr);
                            if (read == -1) {
                                break;
                            } else {
                                zipOutputStream.write(bArr, 0, read);
                            }
                        }
                        polarisFileInputStreamWrapper = polarisFileInputStreamWrapper2;
                    } catch (IOException e) {
                        e = e;
                        polarisFileInputStreamWrapper = polarisFileInputStreamWrapper2;
                        com.xiaomi.channel.commonutils.logger.b.d("zipFiction failed with exception:" + e.toString());
                        a((Closeable) polarisFileInputStreamWrapper);
                    } catch (Throwable th) {
                        th = th;
                        polarisFileInputStreamWrapper = polarisFileInputStreamWrapper2;
                        a((Closeable) polarisFileInputStreamWrapper);
                        throw th;
                    }
                }
            } catch (IOException e2) {
                e = e2;
            }
            a((Closeable) polarisFileInputStreamWrapper);
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
