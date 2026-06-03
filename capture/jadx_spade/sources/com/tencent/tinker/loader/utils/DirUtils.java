package com.tencent.tinker.loader.utils;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.tencent.tinker.loader.MuteApplication;
import java.io.File;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class DirUtils {
    private static File sBaseDir;
    private static String sCurInstSet;

    static {
        Covode.recordClassIndex(653960);
    }

    public static File getPackageDir() {
        return buildPath(new String[0]);
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

    private static void init() {
        if (sBaseDir == null) {
            PolarisFileWrapper polarisFileWrapper = new PolarisFileWrapper(MuteApplication.getInstance().getFilesDir(), "mute");
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

    public static File getSourceApk(int i) {
        return new PolarisFileWrapper(getPkgVerDir(i), "base-1.apk");
    }

    public static File getPkgVerDir(int i) {
        return buildPath("version-" + i);
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

    public static File getOptDir(File file) {
        if (Build.VERSION.SDK_INT >= 26) {
            return new PolarisFileWrapper(new PolarisFileWrapper(file.getParent(), "oat"), getCurtInstSet());
        }
        return new PolarisFileWrapper(file.getParent(), "dalvik-cache");
    }
}
