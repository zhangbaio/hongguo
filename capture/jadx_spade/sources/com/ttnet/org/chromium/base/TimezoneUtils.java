package com.ttnet.org.chromium.base;

import android.os.StrictMode;
import com.bytedance.covode.number.Covode;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.MainDex;
import java.util.TimeZone;

@JNINamespace("base::android")
@MainDex
/* loaded from: D:\code\hongguo\capture\classes16.dex */
class TimezoneUtils {
    static {
        Covode.recordClassIndex(654274);
    }

    private TimezoneUtils() {
    }

    private static String getDefaultTimeZoneId() {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        String id = TimeZone.getDefault().getID();
        StrictMode.setThreadPolicy(allowThreadDiskReads);
        return id;
    }
}
