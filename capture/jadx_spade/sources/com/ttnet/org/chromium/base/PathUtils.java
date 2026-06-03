package com.ttnet.org.chromium.base;

import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Environment;
import android.os.storage.StorageManager;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ttnet.org.chromium.base.annotations.MainDex;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicBoolean;

@MainDex
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class PathUtils {
    private static final AtomicBoolean a;
    private static FutureTask<String[]> b;

    private PathUtils() {
    }

    public static String getCacheDirectory() {
        return a(2);
    }

    public static String getDataDirectory() {
        return a(0);
    }

    public static String getThumbnailCacheDirectory() {
        return a(1);
    }

    static {
        Covode.recordClassIndex(654243);
        a = new AtomicBoolean();
    }

    public static String getExternalStorageDirectory() {
        return Environment.getExternalStorageDirectory().getAbsolutePath();
    }

    public static String getAppExternalCacheDirectory() {
        File externalCacheDir = c.f().getExternalCacheDir();
        if (externalCacheDir == null) {
            return "";
        }
        return externalCacheDir.getAbsolutePath();
    }

    private static String getNativeLibraryDirectory() {
        ApplicationInfo applicationInfo = c.f().getApplicationInfo();
        int i = applicationInfo.flags;
        if ((i & 128) == 0 && (i & 1) != 0) {
            return "/system/lib/";
        }
        return applicationInfo.nativeLibraryDir;
    }

    private static String[] b() {
        if (!b.isDone()) {
            o d = o.d();
            try {
                b.run();
                if (d != null) {
                    d.close();
                }
            } catch (Throwable th) {
                if (d != null) {
                    try {
                        d.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
        try {
            return b.get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String[] getAllPrivateDownloadsDirectories() {
        List arrayList = new ArrayList();
        o d = o.d();
        try {
            File[] externalFilesDirs = c.f().getExternalFilesDirs(Environment.DIRECTORY_DOWNLOADS);
            if (externalFilesDirs != null) {
                arrayList = Arrays.asList(externalFilesDirs);
            }
            if (d != null) {
                d.close();
            }
            return c(arrayList);
        } catch (Throwable th) {
            if (d != null) {
                try {
                    d.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public static String getDownloadsDirectory() {
        String str;
        o c = o.c();
        try {
            if (Build.VERSION.SDK_INT >= 29) {
                String[] allPrivateDownloadsDirectories = getAllPrivateDownloadsDirectories();
                if (allPrivateDownloadsDirectories.length == 0) {
                    str = "";
                } else {
                    str = allPrivateDownloadsDirectories[0];
                }
                if (c != null) {
                    c.close();
                }
                return str;
            }
            String path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath();
            if (c != null) {
                c.close();
            }
            return path;
        } catch (Throwable th) {
            if (c != null) {
                try {
                    c.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public static String[] getExternalDownloadVolumesNames() {
        ArrayList arrayList = new ArrayList();
        for (String str : vj6.e.b(c.f())) {
            if (!TextUtils.isEmpty(str) && !str.contains("external_primary")) {
                File a2 = vj6.f.a((StorageManager) vj6.a.c(c.f(), StorageManager.class), MediaStore.Files.getContentUri(str));
                PolarisFileWrapper polarisFileWrapper = new PolarisFileWrapper(a2, Environment.DIRECTORY_DOWNLOADS);
                if (!polarisFileWrapper.isDirectory()) {
                    h.m("PathUtils", "Download dir missing: %s, parent dir:%s, isDirectory:%s", polarisFileWrapper.getAbsolutePath(), a2.getAbsolutePath(), Boolean.valueOf(a2.isDirectory()));
                }
                arrayList.add(polarisFileWrapper);
            }
        }
        return c(arrayList);
    }

    private static String a(int i) {
        return b()[i];
    }

    private static String[] c(List<File> list) {
        ArrayList arrayList = new ArrayList();
        for (File file : list) {
            if (file != null && !TextUtils.isEmpty(file.getAbsolutePath())) {
                arrayList.add(file.getAbsolutePath());
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }
}
