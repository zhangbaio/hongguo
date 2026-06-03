package com.tencent.tinker.loader.utils;

import android.content.Context;
import android.os.Build;
import com.bytedance.covode.number.Covode;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.Closeable;
import java.io.File;
import java.util.zip.ZipFile;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class Utils {
    static {
        Covode.recordClassIndex(653969);
    }

    public static boolean isAndroidPHigher() {
        int i = Build.VERSION.SDK_INT;
        if (i < 28 && (i != 27 || Build.VERSION.PREVIEW_SDK_INT <= 0)) {
            return false;
        }
        return true;
    }

    public static final boolean deleteDir(String str) {
        if (str == null) {
            return false;
        }
        return deleteDir((File) new PolarisFileWrapper(str));
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

    public static int getUpdateVersionCode(Context context) {
        if (context != null) {
            try {
                return ((Integer) context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.get("UPDATE_VERSION_CODE")).intValue();
            } catch (Exception e) {
                ShareTinkerLog.e("Mute.Utils", "getUpdateVersionCode failed. %s", e);
            }
        }
        return -1;
    }

    public static void setFileOnlyReadable(File file) {
        if (file != null) {
            try {
                if (file.exists() && file.canWrite()) {
                    file.setWritable(false, false);
                    ShareTinkerLog.i("Mute.Utils", "ensure file(" + file.getName() + ") not write success~", new Object[0]);
                }
            } catch (Throwable unused) {
                ShareTinkerLog.e("Mute.Utils", "ensure file(" + file.getName() + ") not write fail~", new Object[0]);
                return;
            }
        }
        ShareTinkerLog.e("Mute.Utils", "ensure file(" + file.getName() + " == null) not write fail~", new Object[0]);
    }
}
