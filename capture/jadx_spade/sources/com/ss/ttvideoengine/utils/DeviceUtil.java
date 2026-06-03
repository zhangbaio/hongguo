package com.ss.ttvideoengine.utils;

import android.os.Build;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class DeviceUtil {
    public static String sBoard;
    public static String sHardware;

    public static String getDeviceModel() {
        return Build.MODEL;
    }

    static {
        Covode.recordClassIndex(652739);
        sBoard = null;
        sHardware = null;
    }

    public static String getDeviceBoard() {
        try {
            if (sBoard == null) {
                sBoard = Build.BOARD;
            }
        } catch (Throwable unused) {
            sBoard = null;
        }
        return sBoard;
    }

    public static String getDeviceHardware() {
        try {
            if (sHardware == null) {
                sHardware = Build.HARDWARE;
            }
        } catch (Throwable unused) {
            sHardware = null;
        }
        return sHardware;
    }
}
