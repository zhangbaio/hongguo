package com.ss.videoarch.liveplayer.log;

import android.util.Log;
import com.bytedance.covode.number.Covode;
import com.ss.videoarch.liveplayer.log.VeLivePlayerLogConfig;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class a {
    public static VeLivePlayerLogConfig.VeLivePlayerLogLevel a;

    static {
        Covode.recordClassIndex(653047);
        a = VeLivePlayerLogConfig.VeLivePlayerLogLevel.VeLivePlayerLogLevelInfo;
    }

    public static void d(VeLivePlayerLogConfig.VeLivePlayerLogLevel veLivePlayerLogLevel) {
        a = veLivePlayerLogLevel;
        b.h(veLivePlayerLogLevel);
    }

    public static void a(String str, String str2) {
        if (b.f()) {
            b.a(str, str2);
        } else if (VeLivePlayerLogConfig.VeLivePlayerLogLevel.VeLivePlayerLogLevelDebug.compareTo(a) >= 0) {
            Log.d(str, str2);
        }
    }

    public static void b(String str, String str2) {
        if (b.f()) {
            b.b(str, str2);
        } else if (VeLivePlayerLogConfig.VeLivePlayerLogLevel.VeLivePlayerLogLevelError.compareTo(a) >= 0) {
            Log.e(str, str2);
        }
    }

    public static void c(String str, String str2) {
        if (b.f()) {
            b.d(str, str2);
        } else if (VeLivePlayerLogConfig.VeLivePlayerLogLevel.VeLivePlayerLogLevelInfo.compareTo(a) >= 0) {
            Log.i(str, str2);
        }
    }

    public static void f(String str, String str2) {
        if (b.f()) {
            b.i(str, str2);
        } else if (VeLivePlayerLogConfig.VeLivePlayerLogLevel.VeLivePlayerLogLevelWarn.compareTo(a) >= 0) {
            Log.w(str, str2);
        }
    }

    public static void e(String str, String str2) {
        int i;
        if (VeLivePlayerLogConfig.VeLivePlayerLogLevel.VeLivePlayerLogLevelInfo.compareTo(a) >= 0 && str != null && str.length() != 0 && str2 != null && str2.length() != 0) {
            int length = str2.length();
            if (length <= 3072) {
                c(str, str2);
                return;
            }
            int i2 = 0;
            while (i2 < length) {
                int i3 = i2 + 3072;
                if (i3 <= length) {
                    i = i3;
                } else {
                    i = length;
                }
                c(str, str2.substring(i2, i));
                i2 = i3;
            }
        }
    }
}
