package com.tencent.tinker.lib.utils;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.tencent.tinker.lib.Muter;
import java.io.File;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class DirUtils {
    private static File sBaseDir;
    private static String sCurInstSet;

    static {
        Covode.recordClassIndex(653924);
    }

    public static File getPackageDir() {
        return buildPath(new String[0]);
    }

    public static boolean enableMute() {
        return !new PolarisFileWrapper(Muter.getAppContext().getFilesDir(), ".mute_disable").exists();
    }

    public static String getCurtInstSet() {
        String str = sCurInstSet;
        if (str != null) {
            return str;
        }
        try {
            sCurInstSet = (String) MethodUtils.invokeStaticMethod(Class.forName("dalvik.system.VMRuntime"), "getCurrentInstructionSet", new Object[0]);
        } catch (Exception unused) {
        }
        return sCurInstSet;
    }

    public static File getDownloadDir() {
        return ensureDirExists(new PolarisFileWrapper(Muter.getAppContext().getFilesDir(), ".tinker_patchs"));
    }

    private static void init() {
        if (sBaseDir == null) {
            PolarisFileWrapper polarisFileWrapper = new PolarisFileWrapper(Muter.getAppContext().getFilesDir(), "mute");
            sBaseDir = polarisFileWrapper;
            ensureDirExists(polarisFileWrapper);
        }
    }

    private static File ensureDirExists(File file) {
        if (file != null) {
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }
        return null;
    }

    public static File getComponentDiff(int i) {
        return new PolarisFileWrapper(getPkgVerDir(i), "component.diff");
    }

    public static File getSourceApk(int i) {
        return new PolarisFileWrapper(getPkgVerDir(i), "base-1.apk");
    }

    public static boolean openLockVersion(Context context) {
        return new PolarisFileWrapper(getPushDir(context), "open_lock_version").exists();
    }

    public static boolean openPushInstall(Context context) {
        return new PolarisFileWrapper(getPushDir(context), "open_push_install").exists();
    }

    public static boolean skipADEXInstall(Context context) {
        return new PolarisFileWrapper(getPushDir(context), "skip_adex_install").exists();
    }

    public static boolean skipODEXInstall(Context context) {
        return new PolarisFileWrapper(getPushDir(context), "skip_odex_install").exists();
    }

    public static File getPkgVerDir(int i) {
        return buildPath("version-" + i);
    }

    public static File getPushDir(Context context) {
        File externalFilesDir;
        try {
            if ("mounted".equals(Environment.getExternalStorageState()) && (externalFilesDir = context.getExternalFilesDir(".tinker_patchs")) != null) {
                return ensureDirExists(externalFilesDir);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static File buildPath(String... strArr) {
        init();
        File file = sBaseDir;
        if (strArr != null && strArr.length > 0) {
            for (String str : strArr) {
                if (!TextUtils.isEmpty(str)) {
                    file = new PolarisFileWrapper(file, str);
                }
            }
        }
        return ensureDirExists(file);
    }

    public static File getAlignApk(int i) {
        return new PolarisFileWrapper(buildPath("version-" + i, "align"), "base-2.apk");
    }

    public static File getNativeLibraryDir(int i) {
        return buildPath("version-" + i, "lib");
    }

    public static String getOatFileExt(String str) {
        String str2;
        String substring = str.substring(str.lastIndexOf("."));
        if (Build.VERSION.SDK_INT < 26) {
            str2 = ".dex";
        } else {
            str2 = ".odex";
        }
        if (".dex".equals(substring)) {
            return substring;
        }
        if (!".zip".equals(substring) && !".apk".equals(substring)) {
            return str + str2;
        }
        return str2;
    }

    public static File getOptDir(File file) {
        if (Build.VERSION.SDK_INT >= 26) {
            return new PolarisFileWrapper(new PolarisFileWrapper(file.getParent(), "oat"), getCurtInstSet());
        }
        return new PolarisFileWrapper(file.getParent(), "dalvik-cache");
    }

    public static File getSourceDir(int i) {
        return buildPath("version-" + i, "apk");
    }

    public static File getOatFile(File file) {
        String str;
        String[] split = file.getName().split("\\.");
        if (Build.VERSION.SDK_INT >= 26) {
            str = split[0] + ".odex";
        } else {
            str = split[0] + ".dex";
        }
        return new PolarisFileWrapper(getOptDir(file), str);
    }
}
