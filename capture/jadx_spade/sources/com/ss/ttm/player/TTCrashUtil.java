package com.ss.ttm.player;

import android.content.Context;
import android.util.Base64;
import android.util.Log;
import com.bytedance.covode.number.Covode;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWriterWrapper;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Locale;
import java.util.zip.GZIPOutputStream;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class TTCrashUtil {
    static {
        Covode.recordClassIndex(652176);
    }

    private static void deleteTrackFile(String str) {
        PolarisFileWrapper polarisFileWrapper = new PolarisFileWrapper(str);
        if (polarisFileWrapper.exists()) {
            polarisFileWrapper.delete();
        }
    }

    public static String getBase64SampleCrash(String str) {
        return Base64.encodeToString(str.getBytes(), 0);
    }

    public static void checkTrackDir(String str) {
        PolarisFileWrapper polarisFileWrapper = new PolarisFileWrapper(String.format("%s/ttplayer_logs", str));
        if (!polarisFileWrapper.exists()) {
            polarisFileWrapper.mkdir();
        }
    }

    public static final String existsCrashFilePath(Context context) {
        if (TTPlayerConfiger.getValue(18, 1) == 1) {
            String appCrashFilePath = TTPlayerConfiger.getAppCrashFilePath(context);
            if (appCrashFilePath == null || !new PolarisFileWrapper(appCrashFilePath).exists()) {
                return null;
            }
            return appCrashFilePath;
        }
        String appCrashFilePath2 = TTPlayerConfiger.getAppCrashFilePath2(context);
        if (appCrashFilePath2 != null && new PolarisFileWrapper(appCrashFilePath2).exists()) {
            return appCrashFilePath2;
        }
        String plugerCrashFilePath = TTPlayerConfiger.getPlugerCrashFilePath(context);
        if (plugerCrashFilePath != null && new PolarisFileWrapper(plugerCrashFilePath).exists()) {
            return plugerCrashFilePath;
        }
        String externalStorageDirectoryCrashFilePath = TTPlayerConfiger.getExternalStorageDirectoryCrashFilePath(context);
        if (externalStorageDirectoryCrashFilePath != null && !new PolarisFileWrapper(externalStorageDirectoryCrashFilePath).exists()) {
            return null;
        }
        return externalStorageDirectoryCrashFilePath;
    }

    public static void checkLogDir(String str) {
        PolarisFileWrapper polarisFileWrapper = new PolarisFileWrapper(String.format("%s/ttplayer_logs", str));
        if (polarisFileWrapper.exists()) {
            if (polarisFileWrapper.isDirectory()) {
                File[] listFiles = polarisFileWrapper.listFiles();
                if (listFiles != null) {
                    for (File file : listFiles) {
                        boolean delete = file.delete();
                        if (!delete) {
                            Log.d("ttmp", "delete file:" + file.getName() + "," + delete);
                        }
                    }
                }
                boolean delete2 = polarisFileWrapper.delete();
                if (!delete2) {
                    Log.d("ttmp", "delete dir file:" + polarisFileWrapper.getName() + "," + delete2);
                    return;
                }
                return;
            }
            return;
        }
        boolean mkdir = polarisFileWrapper.mkdir();
        if (!mkdir) {
            Log.d("ttmp", "mkdir:" + polarisFileWrapper.getName() + "," + mkdir);
        }
    }

    public static void deleteDebugTrackFile(long j, String str) {
        deleteTrackFile(getDebugTrackFilePath(j, str));
    }

    public static void deleteTrackFile(long j, String str) {
        deleteTrackFile(getTrackFilePath(j, str));
    }

    public static void deleteCrashFile(Context context, String str) {
        PolarisFileWrapper polarisFileWrapper = new PolarisFileWrapper(str);
        if (polarisFileWrapper.exists()) {
            polarisFileWrapper.delete();
        }
    }

    public static boolean existsCrashFile(Context context, String str) {
        if (context == null && str == null) {
            return false;
        }
        return new PolarisFileWrapper(str).exists();
    }

    public static boolean existsTrackFile(long j, String str) {
        return new PolarisFileWrapper(getTrackFilePath(j, str)).exists();
    }

    public static void compress(InputStream inputStream, OutputStream outputStream) throws Exception {
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
        byte[] bArr = new byte[10240];
        while (true) {
            int read = inputStream.read(bArr, 0, 10240);
            if (read != -1) {
                gZIPOutputStream.write(bArr, 0, read);
            } else {
                gZIPOutputStream.flush();
                gZIPOutputStream.finish();
                gZIPOutputStream.close();
                return;
            }
        }
    }

    private static String getDebugTrackFilePath(long j, String str) {
        return String.format(Locale.US, "%s/ttplayer_logs/%d_d.log", str, Long.valueOf(j));
    }

    public static String getTrackFilePath(long j, String str) {
        return String.format(Locale.US, "%s/ttplayer_logs/%d.log", str, Long.valueOf(j));
    }

    private static boolean getTrackFileInfos(File file, StringBuilder sb) {
        int read;
        FileReader fileReader = null;
        try {
            if (!file.exists()) {
                return false;
            }
            char[] cArr = new char[1024];
            FileReader polarisFileReaderWrapper = new PolarisFileReaderWrapper(file);
            do {
                try {
                    read = polarisFileReaderWrapper.read(cArr);
                    if (read <= 0) {
                        break;
                    }
                    sb.append(cArr, 0, read);
                } catch (Throwable th) {
                    th = th;
                    fileReader = polarisFileReaderWrapper;
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (Exception unused) {
                        }
                    }
                    sb.append("track message:");
                    sb.append(th.getMessage());
                    sb.append("\r\n");
                    return true;
                }
            } while (read >= 1024);
            polarisFileReaderWrapper.close();
            return true;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean existLogsFile(long j, String str) {
        File[] listFiles;
        String valueOf = String.valueOf(j);
        PolarisFileWrapper polarisFileWrapper = new PolarisFileWrapper(String.format("%s/ttplayer_logs", str));
        if (!polarisFileWrapper.exists() || !polarisFileWrapper.isDirectory() || (listFiles = polarisFileWrapper.listFiles()) == null) {
            return false;
        }
        for (File file : listFiles) {
            String name = file.getName();
            Log.i("ttmp", "<TTCrashUtils,existLogsFile,375>file:" + name + ",pname:" + valueOf);
            if (name != null && !name.startsWith(valueOf)) {
                return true;
            }
        }
        return false;
    }

    private static boolean getTrackFileInfos(String str, StringBuilder sb) {
        int read;
        FileReader fileReader = null;
        try {
            PolarisFileWrapper polarisFileWrapper = new PolarisFileWrapper(str);
            if (!polarisFileWrapper.exists()) {
                sb.append("path");
                sb.append(str);
                sb.append(" not exists.\r\n");
                return false;
            }
            char[] cArr = new char[1024];
            FileReader polarisFileReaderWrapper = new PolarisFileReaderWrapper(polarisFileWrapper);
            do {
                try {
                    read = polarisFileReaderWrapper.read(cArr);
                    if (read <= 0) {
                        break;
                    }
                    sb.append(cArr, 0, read);
                } catch (Throwable th) {
                    th = th;
                    fileReader = polarisFileReaderWrapper;
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (Exception unused) {
                        }
                    }
                    sb.append("track message:");
                    sb.append(th.getMessage());
                    sb.append("\r\n");
                    return true;
                }
            } while (read >= 1024);
            polarisFileReaderWrapper.close();
            return true;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static final void saveException(Throwable th, String str) {
        PolarisFileOutputStreamWrapper polarisFileOutputStreamWrapper;
        if (str == null) {
            return;
        }
        PolarisFileWrapper polarisFileWrapper = new PolarisFileWrapper(str);
        if (polarisFileWrapper.exists()) {
            return;
        }
        PrintStream printStream = null;
        try {
            try {
                polarisFileOutputStreamWrapper = new PolarisFileOutputStreamWrapper(polarisFileWrapper);
                try {
                    PrintStream printStream2 = new PrintStream((OutputStream) polarisFileOutputStreamWrapper);
                    try {
                        printStream2.write("EXCE".getBytes());
                        th.printStackTrace(printStream2);
                        printStream2.close();
                        polarisFileOutputStreamWrapper.close();
                    } catch (Exception unused) {
                        printStream = printStream2;
                        if (printStream != null) {
                            printStream.close();
                        }
                        if (polarisFileOutputStreamWrapper != null) {
                            polarisFileOutputStreamWrapper.close();
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        printStream = printStream2;
                        if (printStream != null) {
                            printStream.close();
                        }
                        if (polarisFileOutputStreamWrapper != null) {
                            try {
                                polarisFileOutputStreamWrapper.close();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Exception unused2) {
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } catch (Exception unused3) {
            polarisFileOutputStreamWrapper = null;
        } catch (Throwable th4) {
            th = th4;
            polarisFileOutputStreamWrapper = null;
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x003d -> B:13:0x0040). Please report as a decompilation issue!!! */
    public static void saveLowMemoryInfo(int i, String str) {
        PolarisFileWriterWrapper polarisFileWriterWrapper;
        PolarisFileWrapper polarisFileWrapper = new PolarisFileWrapper(str);
        if (polarisFileWrapper.exists()) {
            return;
        }
        PolarisFileWriterWrapper polarisFileWriterWrapper2 = null;
        try {
            try {
                try {
                    polarisFileWriterWrapper = new PolarisFileWriterWrapper(polarisFileWrapper);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (IOException e) {
                e = e;
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        try {
            polarisFileWriterWrapper2 = new StringBuilder();
            polarisFileWriterWrapper2.append("LOWM\r\nrecv low memory warring info.level:");
            polarisFileWriterWrapper2.append(i);
            polarisFileWriterWrapper.write(polarisFileWriterWrapper2.toString());
            polarisFileWriterWrapper.close();
        } catch (IOException e3) {
            e = e3;
            polarisFileWriterWrapper2 = polarisFileWriterWrapper;
            e.printStackTrace();
            if (polarisFileWriterWrapper2 != null) {
                polarisFileWriterWrapper2.close();
            }
        } catch (Throwable th2) {
            th = th2;
            polarisFileWriterWrapper2 = polarisFileWriterWrapper;
            if (polarisFileWriterWrapper2 != null) {
                try {
                    polarisFileWriterWrapper2.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0055 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x004e -> B:12:0x0051). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void saveStopInfo(java.lang.String r2, java.lang.String r3) {
        /*
            com.bytedance.security.android.aopcheck.PolarisFileWrapper r0 = new com.bytedance.security.android.aopcheck.PolarisFileWrapper
            r0.<init>(r2)
            boolean r2 = r0.exists()
            if (r2 == 0) goto Lc
            return
        Lc:
            r2 = 0
            com.bytedance.security.android.aopcheck.PolarisFileWriterWrapper r1 = new com.bytedance.security.android.aopcheck.PolarisFileWriterWrapper     // Catch: java.lang.Throwable -> L3d java.io.IOException -> L41
            r1.<init>(r0)     // Catch: java.lang.Throwable -> L3d java.io.IOException -> L41
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.io.IOException -> L3b java.lang.Throwable -> L52
            r2.<init>()     // Catch: java.io.IOException -> L3b java.lang.Throwable -> L52
            java.lang.String r0 = "STOP recv stop info:"
            r2.append(r0)     // Catch: java.io.IOException -> L3b java.lang.Throwable -> L52
            r2.append(r3)     // Catch: java.io.IOException -> L3b java.lang.Throwable -> L52
            java.lang.String r3 = ".time:"
            r2.append(r3)     // Catch: java.io.IOException -> L3b java.lang.Throwable -> L52
            java.lang.String r3 = com.ss.ttm.utils.AVTime.getFormatNow()     // Catch: java.io.IOException -> L3b java.lang.Throwable -> L52
            r2.append(r3)     // Catch: java.io.IOException -> L3b java.lang.Throwable -> L52
            java.lang.String r3 = "\r\n"
            r2.append(r3)     // Catch: java.io.IOException -> L3b java.lang.Throwable -> L52
            java.lang.String r2 = r2.toString()     // Catch: java.io.IOException -> L3b java.lang.Throwable -> L52
            r1.write(r2)     // Catch: java.io.IOException -> L3b java.lang.Throwable -> L52
            r1.close()     // Catch: java.io.IOException -> L4d
            goto L51
        L3b:
            r2 = move-exception
            goto L44
        L3d:
            r3 = move-exception
            r1 = r2
            r2 = r3
            goto L53
        L41:
            r3 = move-exception
            r1 = r2
            r2 = r3
        L44:
            r2.printStackTrace()     // Catch: java.lang.Throwable -> L52
            if (r1 == 0) goto L51
            r1.close()     // Catch: java.io.IOException -> L4d
            goto L51
        L4d:
            r2 = move-exception
            r2.printStackTrace()
        L51:
            return
        L52:
            r2 = move-exception
        L53:
            if (r1 == 0) goto L5d
            r1.close()     // Catch: java.io.IOException -> L59
            goto L5d
        L59:
            r3 = move-exception
            r3.printStackTrace()
        L5d:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.ttm.player.TTCrashUtil.saveStopInfo(java.lang.String, java.lang.String):void");
    }

    public static final boolean moveFile(String str, String str2, boolean z) {
        return copyFile(str, str2, z, true);
    }

    public static void addTrackInfo(long j, String str, String str2) {
        appendTrackInfo(getTrackFilePath(j, str), true, str2);
    }

    public static boolean readDebugTrackInfos(long j, String str, StringBuilder sb) {
        return getTrackFileInfos(getDebugTrackFilePath(j, str), sb);
    }

    public static boolean readTrackInfos(long j, String str, StringBuilder sb) {
        return getTrackFileInfos(getTrackFilePath(j, str), sb);
    }

    public static boolean moveTrackFile(long j, long j2, String str) {
        return new PolarisFileWrapper(getTrackFilePath(j, str)).renameTo(new PolarisFileWrapper(getTrackFilePath(j2, str)));
    }

    private static void appendTrackInfo(String str, boolean z, String str2) {
        FileWriter fileWriter = null;
        try {
            try {
                FileWriter polarisFileWriterWrapper = new PolarisFileWriterWrapper(str, z);
                try {
                    polarisFileWriterWrapper.write(str2);
                    polarisFileWriterWrapper.close();
                } catch (Exception unused) {
                    fileWriter = polarisFileWriterWrapper;
                    fileWriter.close();
                } catch (Throwable th) {
                    th = th;
                    fileWriter = polarisFileWriterWrapper;
                    try {
                        fileWriter.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    throw th;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } catch (Exception unused2) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String getCrashFileContext(Context context, String str, StringBuilder sb) {
        PolarisFileInputStreamWrapper polarisFileInputStreamWrapper;
        if (context == null && str == null) {
            sb.append("context or path is null.\r\n");
            return null;
        }
        PolarisFileWrapper polarisFileWrapper = new PolarisFileWrapper(str);
        if (!polarisFileWrapper.exists()) {
            sb.append("file not exist.path:");
            sb.append(str);
            sb.append("\r\n");
            return null;
        }
        if (polarisFileWrapper.length() == 0) {
            sb.append("file size is zore.");
            sb.append("\r\n");
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            polarisFileInputStreamWrapper = new PolarisFileInputStreamWrapper(polarisFileWrapper);
        } catch (Exception e) {
            e = e;
            polarisFileInputStreamWrapper = null;
        }
        try {
            compress(polarisFileInputStreamWrapper, byteArrayOutputStream);
            polarisFileInputStreamWrapper.close();
            String encodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
            byteArrayOutputStream.close();
            return encodeToString;
        } catch (Exception e2) {
            e = e2;
            e.printStackTrace();
            if (polarisFileInputStreamWrapper != null) {
                try {
                    polarisFileInputStreamWrapper.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
            try {
                byteArrayOutputStream.close();
            } catch (IOException unused) {
            }
            sb.append("gzip file is error.error:");
            sb.append(e.getMessage());
            return null;
        }
    }

    public static boolean readLogsInfo(long j, String str, StringBuilder sb) {
        File[] listFiles;
        String valueOf = String.valueOf(j);
        PolarisFileWrapper polarisFileWrapper = new PolarisFileWrapper(String.format("%s/ttplayer_logs", str));
        if (!polarisFileWrapper.exists() || !polarisFileWrapper.isDirectory() || (listFiles = polarisFileWrapper.listFiles()) == null) {
            return false;
        }
        for (File file : listFiles) {
            String name = file.getName();
            if (name != null && !name.startsWith(valueOf) && getTrackFileInfos(file, sb)) {
                boolean delete = file.delete();
                if (!delete) {
                    Log.d("ttmp", "delete file:" + file.getName() + "," + delete);
                }
                return delete;
            }
        }
        return false;
    }

    public static void addDebugTrackInfo(long j, String str, String str2, boolean z) {
        appendTrackInfo(getDebugTrackFilePath(j, str), z, str2);
    }

    public static void addTrackInfo(long j, String str, String str2, boolean z) {
        appendTrackInfo(getTrackFilePath(j, str), z, str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x0082 A[Catch: IOException -> 0x007e, TRY_LEAVE, TryCatch #12 {IOException -> 0x007e, blocks: (B:66:0x007a, B:59:0x0082), top: B:65:0x007a }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x007a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean copyFile(java.lang.String r4, java.lang.String r5, boolean r6, boolean r7) {
        /*
            com.bytedance.security.android.aopcheck.PolarisFileWrapper r0 = new com.bytedance.security.android.aopcheck.PolarisFileWrapper
            r0.<init>(r5)
            boolean r5 = r0.exists()
            r1 = 0
            if (r5 != 0) goto Ld
            return r1
        Ld:
            boolean r5 = r0.isFile()
            if (r5 != 0) goto L14
            return r1
        L14:
            com.bytedance.security.android.aopcheck.PolarisFileWrapper r5 = new com.bytedance.security.android.aopcheck.PolarisFileWrapper
            r5.<init>(r4)
            boolean r2 = r5.exists()
            if (r2 == 0) goto L2a
            if (r6 == 0) goto L3f
            com.bytedance.security.android.aopcheck.PolarisFileWrapper r6 = new com.bytedance.security.android.aopcheck.PolarisFileWrapper
            r6.<init>(r4)
            r6.delete()
            goto L3f
        L2a:
            java.io.File r4 = r5.getParentFile()
            boolean r4 = r4.exists()
            if (r4 != 0) goto L3f
            java.io.File r4 = r5.getParentFile()
            boolean r4 = r4.mkdirs()
            if (r4 != 0) goto L3f
            return r1
        L3f:
            r4 = 0
            com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper r6 = new com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper     // Catch: java.lang.Throwable -> L74 java.io.IOException -> L8a java.io.FileNotFoundException -> L9d
            r6.<init>(r0)     // Catch: java.lang.Throwable -> L74 java.io.IOException -> L8a java.io.FileNotFoundException -> L9d
            com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper r2 = new com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper     // Catch: java.lang.Throwable -> L71 java.io.IOException -> L8b java.io.FileNotFoundException -> L9e
            r2.<init>(r5)     // Catch: java.lang.Throwable -> L71 java.io.IOException -> L8b java.io.FileNotFoundException -> L9e
            r4 = 1024(0x400, float:1.435E-42)
            byte[] r4 = new byte[r4]     // Catch: java.lang.Throwable -> L6b java.io.IOException -> L6d java.io.FileNotFoundException -> L6f
        L4e:
            int r5 = r6.read(r4)     // Catch: java.lang.Throwable -> L6b java.io.IOException -> L6d java.io.FileNotFoundException -> L6f
            r3 = -1
            if (r5 == r3) goto L59
            r2.write(r4, r1, r5)     // Catch: java.lang.Throwable -> L6b java.io.IOException -> L6d java.io.FileNotFoundException -> L6f
            goto L4e
        L59:
            if (r7 == 0) goto L5e
            r0.delete()     // Catch: java.lang.Throwable -> L6b java.io.IOException -> L6d java.io.FileNotFoundException -> L6f
        L5e:
            r2.close()     // Catch: java.io.IOException -> L65
            r6.close()     // Catch: java.io.IOException -> L65
            goto L69
        L65:
            r4 = move-exception
            r4.printStackTrace()
        L69:
            r4 = 1
            return r4
        L6b:
            r4 = move-exception
            goto L78
        L6d:
            r4 = r2
            goto L8b
        L6f:
            r4 = r2
            goto L9e
        L71:
            r5 = move-exception
            r2 = r4
            goto L77
        L74:
            r5 = move-exception
            r6 = r4
            r2 = r6
        L77:
            r4 = r5
        L78:
            if (r2 == 0) goto L80
            r2.close()     // Catch: java.io.IOException -> L7e
            goto L80
        L7e:
            r5 = move-exception
            goto L86
        L80:
            if (r6 == 0) goto L89
            r6.close()     // Catch: java.io.IOException -> L7e
            goto L89
        L86:
            r5.printStackTrace()
        L89:
            throw r4
        L8a:
            r6 = r4
        L8b:
            if (r4 == 0) goto L93
            r4.close()     // Catch: java.io.IOException -> L91
            goto L93
        L91:
            r4 = move-exception
            goto L99
        L93:
            if (r6 == 0) goto L9c
            r6.close()     // Catch: java.io.IOException -> L91
            goto L9c
        L99:
            r4.printStackTrace()
        L9c:
            return r1
        L9d:
            r6 = r4
        L9e:
            if (r4 == 0) goto La6
            r4.close()     // Catch: java.io.IOException -> La4
            goto La6
        La4:
            r4 = move-exception
            goto Lac
        La6:
            if (r6 == 0) goto Laf
            r6.close()     // Catch: java.io.IOException -> La4
            goto Laf
        Lac:
            r4.printStackTrace()
        Laf:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.ttm.player.TTCrashUtil.copyFile(java.lang.String, java.lang.String, boolean, boolean):boolean");
    }
}
