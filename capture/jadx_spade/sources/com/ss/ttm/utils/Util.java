package com.ss.ttm.utils;

import android.os.Build;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class Util {
    public static final String BARND;
    public static final String DEVICE;
    public static final String DEVICE_DEBUG_INFO;
    public static final String HARDWARE;
    public static final String MANUFACTURER;
    public static final String MODEL;
    public static final int SDK_INT;

    static {
        Covode.recordClassIndex(652240);
        int i = Build.VERSION.SDK_INT;
        SDK_INT = i;
        String str = Build.DEVICE;
        DEVICE = str;
        String str2 = Build.MANUFACTURER;
        MANUFACTURER = str2;
        String str3 = Build.MODEL;
        MODEL = str3;
        HARDWARE = Build.HARDWARE;
        BARND = Build.BRAND;
        DEVICE_DEBUG_INFO = str + ", " + str3 + ", " + str2 + ", " + i;
    }
}
