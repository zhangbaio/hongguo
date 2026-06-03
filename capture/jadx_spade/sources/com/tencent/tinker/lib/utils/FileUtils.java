package com.tencent.tinker.lib.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWriterWrapper;
import com.tencent.tinker.lib.MuteLog;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class FileUtils {
    private static char[] hexDigits;

    static {
        Covode.recordClassIndex(653926);
        hexDigits = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    }

    public static boolean checkIfMd5Valid(String str) {
        if (str != null && str.length() == 32) {
            return true;
        }
        return false;
    }

    public static final boolean deleteDir(String str) {
        if (str == null) {
            return false;
        }
        return deleteDir((File) new PolarisFileWrapper(str));
    }

    public static boolean mkdirs(File file) {
        if (file == null) {
            return false;
        }
        return file.mkdirs();
    }

    public static boolean checkElfFile(File file) {
        try {
            closeQuietly(new ShareElfFile(file));
            return true;
        } catch (IOException unused) {
            closeQuietly(null);
            return false;
        } catch (Throwable th) {
            closeQuietly(null);
            throw th;
        }
    }

    public static File getPatchInfoFile(String str) {
        return new PolarisFileWrapper(str + "/patch.info");
    }

    public static File getPatchInfoLockFile(String str) {
        return new PolarisFileWrapper(str + "/info.lock");
    }

    private static boolean makeSureFileExist(File file) {
        if (makesureParentDirExist(file)) {
            if (file.isFile()) {
                try {
                    return file.createNewFile();
                } catch (IOException unused) {
                    return false;
                }
            }
            if (file.isDirectory()) {
                return file.mkdir();
            }
        }
        return false;
    }

    private static boolean makesureParentDirExist(File file) {
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists()) {
            return mkdirs(parentFile);
        }
        return true;
    }

    public static final boolean safeDeleteFile(File file) {
        boolean z = true;
        if (file == null) {
            return true;
        }
        if (file.exists() && !(z = file.delete())) {
            file.deleteOnExit();
        }
        return z;
    }

    public static void closeQuietly(Object obj) {
        if (obj == null) {
            return;
        }
        try {
            if (obj instanceof Closeable) {
                ((Closeable) obj).close();
            } else if (obj instanceof AutoCloseable) {
                ((AutoCloseable) obj).close();
            } else if (obj instanceof ZipFile) {
                ((ZipFile) obj).close();
            } else {
                throw new IllegalArgumentException("obj: " + obj + " cannot be closed.");
            }
        } catch (Throwable unused) {
        }
    }

    public static final boolean deleteDir(File file) {
        File[] listFiles;
        if (file == null || !file.exists()) {
            return false;
        }
        if (file.isFile()) {
            safeDeleteFile(file);
            return true;
        }
        if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                deleteDir(file2);
            }
            safeDeleteFile(file);
            return true;
        }
        return true;
    }

    public static String getMD5(File file) {
        PolarisFileInputStreamWrapper polarisFileInputStreamWrapper;
        PolarisFileInputStreamWrapper polarisFileInputStreamWrapper2 = null;
        if (file == null || !file.exists()) {
            return null;
        }
        try {
            polarisFileInputStreamWrapper = new PolarisFileInputStreamWrapper(file);
            try {
                try {
                    String md5 = getMD5((InputStream) polarisFileInputStreamWrapper);
                    closeQuietly(polarisFileInputStreamWrapper);
                    return md5;
                } catch (Exception e) {
                    e = e;
                    MuteLog.e("Mute.Utils", "getMD5 err, %s", e);
                    closeQuietly(polarisFileInputStreamWrapper);
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                polarisFileInputStreamWrapper2 = polarisFileInputStreamWrapper;
                closeQuietly(polarisFileInputStreamWrapper2);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            polarisFileInputStreamWrapper = null;
        } catch (Throwable th2) {
            th = th2;
            closeQuietly(polarisFileInputStreamWrapper2);
            throw th;
        }
    }

    public static File getPatchDirectory(Context context) {
        String str;
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (applicationInfo == null) {
            return null;
        }
        if ("oppo".equalsIgnoreCase(Build.MANUFACTURER) && Build.VERSION.SDK_INT == 22) {
            str = "wc_tinker_dir";
        } else {
            str = "tinker";
        }
        return new PolarisFileWrapper(applicationInfo.dataDir, str);
    }

    public static final boolean isLegalFile(File file) {
        if (file != null && file.exists() && file.canRead() && file.isFile() && file.length() > 0) {
            return true;
        }
        return false;
    }

    public static final String getMD5(InputStream inputStream) {
        int i;
        if (inputStream == null) {
            return null;
        }
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            StringBuilder sb = new StringBuilder(32);
            byte[] bArr = new byte[102400];
            while (true) {
                int read = bufferedInputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                messageDigest.update(bArr, 0, read);
            }
            for (byte b : messageDigest.digest()) {
                sb.append(Integer.toString((b & 255) + 256, 16).substring(1));
            }
            return sb.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    public static void setOnlyReadable(File file) {
        if (file != null) {
            try {
                if (file.exists() && file.canWrite()) {
                    file.setWritable(false, false);
                    MuteLog.i("Mute.Utils", "ensure file(" + file.getName() + ") not write success~", new Object[0]);
                }
            } catch (Throwable unused) {
                MuteLog.e("Mute.Utils", "ensure file(" + file.getName() + ") not write fail~", new Object[0]);
                return;
            }
        }
        MuteLog.e("Mute.Utils", "ensure file(" + file.getName() + " == null) not write fail~", new Object[0]);
    }

    public static String getMD5(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            byte[] digest = messageDigest.digest();
            char[] cArr = new char[digest.length * 2];
            int i = 0;
            for (byte b : digest) {
                int i2 = i + 1;
                char[] cArr2 = hexDigits;
                cArr[i] = cArr2[(b >>> 4) & 15];
                i = i2 + 1;
                cArr[i2] = cArr2[b & 15];
            }
            return new String(cArr);
        } catch (Exception unused) {
            return null;
        }
    }

    public static String readFile(File file) throws IOException {
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
                                return byteArrayOutputStream.toString();
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

    public static File renameFile(File file, String str) {
        PolarisFileWrapper polarisFileWrapper = new PolarisFileWrapper(str);
        if (file.renameTo(polarisFileWrapper)) {
            return polarisFileWrapper;
        }
        return null;
    }

    public static void copyFileUsingStream(File file, File file2) throws IOException {
        PolarisFileOutputStreamWrapper polarisFileOutputStreamWrapper;
        if (!isLegalFile(file) || file2 == null || file.getAbsolutePath().equals(file2.getAbsolutePath())) {
            return;
        }
        File parentFile = file2.getParentFile();
        if (parentFile != null && !parentFile.exists()) {
            parentFile.mkdirs();
        }
        PolarisFileInputStreamWrapper polarisFileInputStreamWrapper = null;
        try {
            PolarisFileInputStreamWrapper polarisFileInputStreamWrapper2 = new PolarisFileInputStreamWrapper(file);
            try {
                polarisFileOutputStreamWrapper = new PolarisFileOutputStreamWrapper(file2, false);
                try {
                    byte[] bArr = new byte[16384];
                    while (true) {
                        int read = polarisFileInputStreamWrapper2.read(bArr);
                        if (read > 0) {
                            polarisFileOutputStreamWrapper.write(bArr, 0, read);
                        } else {
                            closeQuietly(polarisFileInputStreamWrapper2);
                            closeQuietly(polarisFileOutputStreamWrapper);
                            return;
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    polarisFileInputStreamWrapper = polarisFileInputStreamWrapper2;
                    closeQuietly(polarisFileInputStreamWrapper);
                    closeQuietly(polarisFileOutputStreamWrapper);
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

    public static void unZipFolder(File file, File file2) throws Exception {
        ZipInputStream zipInputStream = new ZipInputStream(new PolarisFileInputStreamWrapper(file));
        while (true) {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            if (nextEntry != null) {
                String name = nextEntry.getName();
                if (!name.isEmpty()) {
                    if (nextEntry.isDirectory()) {
                        new PolarisFileWrapper(file2, name.substring(0, name.length() - 1)).mkdirs();
                    } else {
                        PolarisFileWrapper polarisFileWrapper = new PolarisFileWrapper(file2, name);
                        if (!polarisFileWrapper.exists()) {
                            polarisFileWrapper.getParentFile().mkdirs();
                            polarisFileWrapper.createNewFile();
                        }
                        PolarisFileOutputStreamWrapper polarisFileOutputStreamWrapper = new PolarisFileOutputStreamWrapper(polarisFileWrapper);
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = zipInputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            polarisFileOutputStreamWrapper.write(bArr, 0, read);
                            polarisFileOutputStreamWrapper.flush();
                        }
                        polarisFileOutputStreamWrapper.close();
                    }
                }
            } else {
                zipInputStream.close();
                return;
            }
        }
    }

    public static boolean verifyFileValidInDir(File file, String str, long j) {
        File[] listFiles;
        if (file != null && file.exists() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                if (file2 != null && TextUtils.equals(file2.getName(), str)) {
                    if (!file2.exists() || !file2.canRead() || !file2.isFile() || file2.length() != j) {
                        return false;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public static synchronized void writeFile(String str, String str2, boolean z) {
        FileWriter polarisFileWriterWrapper;
        synchronized (FileUtils.class) {
            if (str == null) {
                return;
            }
            if (str2 == null) {
                return;
            }
            PolarisFileWrapper polarisFileWrapper = new PolarisFileWrapper(str);
            FileWriter fileWriter = null;
            try {
                try {
                    if (!polarisFileWrapper.exists()) {
                        makeSureFileExist(polarisFileWrapper);
                    }
                    polarisFileWriterWrapper = new PolarisFileWriterWrapper(polarisFileWrapper, z);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (IOException e) {
                e = e;
            }
            try {
                polarisFileWriterWrapper.write(str2);
                polarisFileWriterWrapper.flush();
                try {
                    polarisFileWriterWrapper.close();
                } catch (IOException e2) {
                    e = e2;
                    e.printStackTrace();
                }
            } catch (IOException e3) {
                e = e3;
                fileWriter = polarisFileWriterWrapper;
                e.printStackTrace();
                if (fileWriter != null) {
                    try {
                        fileWriter.close();
                    } catch (IOException e4) {
                        e = e4;
                        e.printStackTrace();
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                fileWriter = polarisFileWriterWrapper;
                if (fileWriter != null) {
                    try {
                        fileWriter.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
                throw th;
            }
        }
    }
}
