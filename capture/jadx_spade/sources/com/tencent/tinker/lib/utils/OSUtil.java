package com.tencent.tinker.lib.utils;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class OSUtil {
    static {
        Covode.recordClassIndex(653930);
    }

    public static boolean isAndroidHHigher() {
        return true;
    }

    public static boolean isAndroidIHigher() {
        return true;
    }

    public static boolean isAndroidI_MR1Higher() {
        return true;
    }

    public static boolean isAndroidIceMr1Higher() {
        return false;
    }

    public static boolean isAndroidJ() {
        return false;
    }

    public static boolean isAndroidJLower() {
        return false;
    }

    public static boolean isAndroidJ_MR1Higher() {
        return true;
    }

    public static boolean isAndroidJ_MR2Higher() {
        return true;
    }

    public static boolean isAndroidKHigher() {
        return true;
    }

    public static boolean isAndroidKLower() {
        return false;
    }

    public static boolean isAndroidLHigher() {
        return true;
    }

    public static boolean isAndroidLLower() {
        return false;
    }

    public static boolean isOatRightVersion(int i) {
        return i >= 21 && i < 26;
    }

    public static boolean isAndroidJ_Q() {
        if (Build.VERSION.SDK_INT < 29) {
            return true;
        }
        return false;
    }

    public static boolean isAndroidLM() {
        if (Build.VERSION.SDK_INT <= 23) {
            return true;
        }
        return false;
    }

    public static boolean isAndroidLN() {
        if (Build.VERSION.SDK_INT <= 25) {
            return true;
        }
        return false;
    }

    public static boolean isAndroidLP() {
        if (Build.VERSION.SDK_INT <= 28) {
            return true;
        }
        return false;
    }

    public static boolean isAndroidL_M() {
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        return false;
    }

    public static boolean isAndroidMHigher() {
        if (Build.VERSION.SDK_INT > 23) {
            return true;
        }
        return false;
    }

    public static boolean isAndroidMLower() {
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        return false;
    }

    public static boolean isAndroidMOrHigher() {
        if (Build.VERSION.SDK_INT >= 23) {
            return true;
        }
        return false;
    }

    public static boolean isAndroidNHigher() {
        if (Build.VERSION.SDK_INT >= 24) {
            return true;
        }
        return false;
    }

    public static boolean isAndroidNMR1() {
        int i = Build.VERSION.SDK_INT;
        if (i >= 24 && i <= 25) {
            return true;
        }
        return false;
    }

    public static boolean isAndroidNP() {
        int i = Build.VERSION.SDK_INT;
        if (i >= 24 && i <= 28) {
            return true;
        }
        return false;
    }

    public static boolean isAndroidN_MR1Higher() {
        if (Build.VERSION.SDK_INT > 25) {
            return true;
        }
        return false;
    }

    public static boolean isAndroidO() {
        int i = Build.VERSION.SDK_INT;
        if (i >= 26 && i <= 27) {
            return true;
        }
        return false;
    }

    public static boolean isAndroidOLow() {
        if (Build.VERSION.SDK_INT < 27) {
            return true;
        }
        return false;
    }

    public static boolean isAndroidPLow() {
        if (Build.VERSION.SDK_INT <= 28) {
            return true;
        }
        return false;
    }

    public static boolean isAndroidQLower() {
        if (Build.VERSION.SDK_INT < 29) {
            return true;
        }
        return false;
    }

    public static boolean isAndroidTLower() {
        if (Build.VERSION.SDK_INT <= 33) {
            return true;
        }
        return false;
    }

    public static boolean isGoogle() {
        return TextUtils.equals(Build.BRAND.toLowerCase(), "google");
    }

    public static boolean isHonor() {
        return TextUtils.equals(Build.BOARD.toLowerCase(), "honor");
    }

    public static boolean isHtc() {
        return TextUtils.equals(Build.BRAND.toLowerCase(), "htc");
    }

    public static boolean isHuawei() {
        return TextUtils.equals(Build.BRAND.toLowerCase(), "huawei");
    }

    public static boolean isNova() {
        return TextUtils.equals(Build.BOARD.toLowerCase(), "nova");
    }

    public static boolean isOppo() {
        return TextUtils.equals(Build.BRAND.toLowerCase(), "oppo");
    }

    public static boolean isSamsung() {
        return TextUtils.equals(Build.BRAND.toLowerCase(), "samsung");
    }

    public static boolean isAndroidNOHigher() {
        int i = Build.VERSION.SDK_INT;
        if (i <= 25 && (i != 25 || Build.VERSION.PREVIEW_SDK_INT <= 0)) {
            return false;
        }
        return true;
    }

    public static boolean isAndroidOHigher() {
        int i = Build.VERSION.SDK_INT;
        if (i < 26 && (i != 25 || Build.VERSION.PREVIEW_SDK_INT <= 0)) {
            return false;
        }
        return true;
    }

    public static boolean isAndroidPHigher() {
        int i = Build.VERSION.SDK_INT;
        if (i < 28 && (i != 27 || Build.VERSION.PREVIEW_SDK_INT <= 0)) {
            return false;
        }
        return true;
    }

    public static boolean isAndroidQHigher() {
        int i = Build.VERSION.SDK_INT;
        if (i < 29 && (i != 28 || Build.VERSION.PREVIEW_SDK_INT <= 0)) {
            return false;
        }
        return true;
    }

    public static boolean isAndroidQR() {
        int i = Build.VERSION.SDK_INT;
        if ((i >= 29 || (i == 28 && Build.VERSION.PREVIEW_SDK_INT > 0)) && i <= 30) {
            return true;
        }
        return false;
    }

    public static boolean isAndroidR() {
        int i = Build.VERSION.SDK_INT;
        if (i != 30 && (i != 29 || Build.VERSION.PREVIEW_SDK_INT <= 0)) {
            return false;
        }
        return true;
    }

    public static boolean isAndroidRHigher() {
        int i = Build.VERSION.SDK_INT;
        if (i < 30 && (i != 29 || Build.VERSION.PREVIEW_SDK_INT <= 0)) {
            return false;
        }
        return true;
    }

    public static boolean isAndroidS() {
        int i = Build.VERSION.SDK_INT;
        if (i != 31 && i != 32 && (i != 30 || Build.VERSION.PREVIEW_SDK_INT <= 0)) {
            return false;
        }
        return true;
    }

    public static boolean isAndroidSHigher() {
        int i = Build.VERSION.SDK_INT;
        if (i < 31 && (i != 30 || Build.VERSION.PREVIEW_SDK_INT <= 0)) {
            return false;
        }
        return true;
    }

    public static boolean isAndroidT() {
        int i = Build.VERSION.SDK_INT;
        if (i != 33 && (i != 32 || Build.VERSION.PREVIEW_SDK_INT <= 0)) {
            return false;
        }
        return true;
    }

    public static boolean isAndroidTHigher() {
        int i = Build.VERSION.SDK_INT;
        if (i < 33 && (i != 32 || Build.VERSION.PREVIEW_SDK_INT <= 0)) {
            return false;
        }
        return true;
    }

    public static boolean isAndroidUHigher() {
        int i = Build.VERSION.SDK_INT;
        if (i < 34 && (i != 33 || Build.VERSION.PREVIEW_SDK_INT <= 0)) {
            return false;
        }
        return true;
    }

    public static boolean isAndroidVHigher() {
        int i = Build.VERSION.SDK_INT;
        if (i < 35 && (i != 34 || Build.VERSION.PREVIEW_SDK_INT <= 0)) {
            return false;
        }
        return true;
    }

    public static boolean isNewerOrEqualThanVersion(int i) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 23) {
            if (i2 < i && (i2 != i - 1 || Build.VERSION.PREVIEW_SDK_INT <= 0)) {
                return false;
            }
            return true;
        }
        if (i2 < i) {
            return false;
        }
        return true;
    }
}
