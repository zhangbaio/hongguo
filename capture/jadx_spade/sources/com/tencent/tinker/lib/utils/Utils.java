package com.tencent.tinker.lib.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.tencent.tinker.lib.MuteLog;
import com.tencent.tinker.lib.Muter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class Utils {
    private static String buildUniqueIdentify;

    static {
        Covode.recordClassIndex(653944);
        buildUniqueIdentify = "";
    }

    public static String getBuildUniqueIdentify() {
        if (!TextUtils.isEmpty(buildUniqueIdentify)) {
            return buildUniqueIdentify;
        }
        String reverseAndGet = reverseAndGet("tnirpregnif.dliub.or", "");
        if (TextUtils.isEmpty(reverseAndGet)) {
            reverseAndGet = reverseAndGet("dnarb.tcudorp.or", "unknown") + '/' + reverseAndGet("eman.tcudorp.or", "unknown") + '/' + reverseAndGet("ecived.tcudorp.or", "unknown") + '/' + reverseAndGet("esaeler.noisrev.dliub.or", "unknown") + '/' + reverseAndGet("di.dliub.or", "unknown") + '/' + reverseAndGet("latnemercni.noisrev.dliub.or", "unknown") + '/' + reverseAndGet("epyt.dliub.or", "unknown") + '/' + reverseAndGet("sgat.dliub.or", "unknown");
        }
        buildUniqueIdentify = reverseAndGet;
        return reverseAndGet;
    }

    public static PackageInfo gePackageInfo(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 37519);
        } catch (PackageManager.NameNotFoundException e) {
            MuteLog.e("Mute.Utils", "gePackageInfo failed, %s", e);
            return null;
        }
    }

    public static boolean isXposedExists(Throwable th) {
        for (StackTraceElement stackTraceElement : th.getStackTrace()) {
            String className = stackTraceElement.getClassName();
            if (className != null && className.contains("de.robv.android.xposed.XposedBridge")) {
                return true;
            }
        }
        return false;
    }

    public static PackageInfo getPackageInfo(int i) {
        try {
            return Muter.getAppContext().getPackageManager().getPackageInfo(Muter.getAppContext().getPackageName(), i | 33554432);
        } catch (PackageManager.NameNotFoundException e) {
            MuteLog.e("Mute.Utils", "getPackageInfo failed", e);
            return null;
        }
    }

    public static int getUpdateVersionCode(Context context) {
        if (context != null) {
            try {
                return ((Integer) context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.get("UPDATE_VERSION_CODE")).intValue();
            } catch (Exception e) {
                MuteLog.e("Mute.Utils", "getUpdateVersionCode failed. %s", e);
            }
        }
        return -1;
    }

    private static String reverseAndGet(String str, String str2) {
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length / 2; i++) {
            char c = charArray[i];
            int i2 = (length - 1) - i;
            charArray[i] = charArray[i2];
            charArray[i2] = c;
        }
        StringBuilder sb = new StringBuilder();
        for (char c2 : charArray) {
            sb.append(c2);
        }
        String sb2 = sb.toString();
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            if (TextUtils.isEmpty(str2)) {
                Method declaredMethod = cls.getDeclaredMethod("get", String.class);
                declaredMethod.setAccessible(true);
                return (String) declaredMethod.invoke(null, sb2);
            }
            Method declaredMethod2 = cls.getDeclaredMethod("get", String.class, String.class);
            declaredMethod2.setAccessible(true);
            return (String) declaredMethod2.invoke(null, sb2, str2);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return "";
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return "";
        } catch (NoSuchMethodException e3) {
            e3.printStackTrace();
            return "";
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
            return "";
        }
    }
}
