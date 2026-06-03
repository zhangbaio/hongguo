package com.ttnet.org.chromium.base;

import android.app.ActivityManager;
import android.os.Build;
import android.os.StrictMode;
import android.util.Log;
import com.bytedance.covode.number.Covode;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.MainDex;
import java.io.BufferedReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@JNINamespace("base::android")
@MainDex
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class SysUtils {
    private static Boolean a;
    private static Integer b;

    private SysUtils() {
    }

    static {
        Covode.recordClassIndex(654258);
    }

    public static int amountOfPhysicalMemoryKB() {
        if (b == null) {
            b = Integer.valueOf(a());
        }
        return b.intValue();
    }

    public static boolean isCurrentlyLowMemory() {
        ActivityManager activityManager = (ActivityManager) c.f().getSystemService("activity");
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo.lowMemory;
    }

    public static boolean isLowEndDevice() {
        if (a == null) {
            a = Boolean.valueOf(b());
        }
        return a.booleanValue();
    }

    private static int a() {
        Pattern compile = Pattern.compile("^MemTotal:\\s+([0-9]+) kB$");
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            try {
                PolarisFileReaderWrapper polarisFileReaderWrapper = new PolarisFileReaderWrapper("/proc/meminfo");
                try {
                    BufferedReader bufferedReader = new BufferedReader(polarisFileReaderWrapper);
                    while (true) {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                Log.w("SysUtils", "/proc/meminfo lacks a MemTotal entry?");
                                break;
                            }
                            Matcher matcher = compile.matcher(readLine);
                            if (matcher.find()) {
                                int parseInt = Integer.parseInt(matcher.group(1));
                                if (parseInt <= 1024) {
                                    Log.w("SysUtils", "Invalid /proc/meminfo total size in kB: " + matcher.group(1));
                                } else {
                                    return parseInt;
                                }
                            }
                        } finally {
                            bufferedReader.close();
                        }
                    }
                } finally {
                    polarisFileReaderWrapper.close();
                }
            } catch (Exception e) {
                Log.w("SysUtils", "Cannot get total physical size from /proc/meminfo", e);
            }
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            return 0;
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }

    private static boolean b() {
        boolean z;
        boolean z2;
        boolean z3 = true;
        if (b.a().b("enable-low-end-device-mode")) {
            return true;
        }
        if (b.a().b("disable-low-end-device-mode")) {
            return false;
        }
        Integer valueOf = Integer.valueOf(a());
        b = valueOf;
        if (valueOf.intValue() <= 0 || (Build.VERSION.SDK_INT < 26 ? b.intValue() / 1024 > 512 : b.intValue() / 1024 > 1024)) {
            z = false;
        } else {
            z = true;
        }
        if (c.f() != null) {
            z2 = ((ActivityManager) c.f().getSystemService("activity")).isLowRamDevice();
        } else {
            z2 = false;
        }
        if (z != z2) {
            z3 = false;
        }
        com.ttnet.org.chromium.base.metrics.a.b("Android.SysUtilsLowEndMatches", z3);
        return z;
    }
}
