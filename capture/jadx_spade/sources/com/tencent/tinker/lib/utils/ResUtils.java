package com.tencent.tinker.lib.utils;

import android.content.res.AssetManager;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.tencent.tinker.lib.MuteLog;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class ResUtils {
    static {
        Covode.recordClassIndex(653934);
    }

    public static String[] getDefaultAssetPaths() {
        AssetManager assetManager;
        try {
            assetManager = (AssetManager) AssetManager.class.newInstance();
        } catch (Exception e) {
            MuteLog.e("Mute.ResUtils", "Execute 'AssetManager.class.newInstance()' failed, %s", e);
            assetManager = null;
        }
        return getApkPaths(assetManager);
    }

    public static String formatAssetsStr(AssetManager assetManager) {
        return formatAssetsStr(getApkPaths(assetManager));
    }

    public static String formatAssetsStr(String[] strArr) {
        if (strArr != null && strArr.length != 0) {
            StringBuilder sb = new StringBuilder("[");
            for (int i = 0; i < strArr.length; i++) {
                sb.append(strArr[i]);
                if (i < strArr.length - 1) {
                    sb.append(", ");
                }
            }
            sb.append("]");
            return sb.toString();
        }
        return "[]";
    }

    public static String[] getApkPaths(AssetManager assetManager) {
        try {
            if (OSUtil.isAndroidQHigher()) {
                return (String[]) MethodUtils.invokeMethod(assetManager, "getApkPaths", new Object[0]);
            }
            if (OSUtil.isAndroidPHigher()) {
                Object[] objArr = (Object[]) MethodUtils.invokeMethod(assetManager, "getApkAssets", new Object[0]);
                if (objArr == null || objArr.length <= 0) {
                    return null;
                }
                String[] strArr = new String[objArr.length];
                for (int i = 0; i < objArr.length; i++) {
                    strArr[i] = (String) MethodUtils.invokeMethod(objArr[i], "getAssetPath", new Object[0]);
                }
                return strArr;
            }
            int intValue = ((Integer) MethodUtils.invokeMethod(assetManager, "getStringBlockCount", new Object[0])).intValue();
            if (intValue <= 0) {
                return null;
            }
            String[] strArr2 = new String[intValue];
            int i2 = 0;
            while (i2 < intValue) {
                int i3 = i2 + 1;
                String str = (String) MethodUtils.invokeMethod(assetManager, "getCookieName", Integer.valueOf(i3));
                if (!TextUtils.isEmpty(str)) {
                    strArr2[i2] = str;
                }
                i2 = i3;
            }
            return strArr2;
        } catch (Throwable th) {
            MuteLog.e("Mute.ResUtils", "getApkPaths failed, %s", th);
            return null;
        }
    }

    public static boolean assetsContainsPath(AssetManager assetManager, String str) {
        String[] apkPaths = getApkPaths(assetManager);
        if (apkPaths != null && apkPaths.length > 0) {
            try {
                String canonicalPath = new PolarisFileWrapper(str).getCanonicalPath();
                for (String str2 : apkPaths) {
                    if (TextUtils.equals(new PolarisFileWrapper(str2).getCanonicalPath(), canonicalPath)) {
                        return true;
                    }
                }
            } catch (IOException e) {
                MuteLog.w("Mute.ResUtils", "assetsContainsPath failed, %s", e);
            }
        }
        return false;
    }

    public static boolean assetsEquals(AssetManager assetManager, AssetManager assetManager2) {
        if (assetManager == assetManager2) {
            return true;
        }
        String[] apkPaths = getApkPaths(assetManager);
        String[] apkPaths2 = getApkPaths(assetManager2);
        if (apkPaths != null && apkPaths2 != null) {
            if (apkPaths.length != apkPaths2.length) {
                return false;
            }
            return new HashSet(Arrays.asList(apkPaths)).equals(new HashSet(Arrays.asList(apkPaths2)));
        }
        if (apkPaths == apkPaths2) {
            return true;
        }
        return false;
    }
}
