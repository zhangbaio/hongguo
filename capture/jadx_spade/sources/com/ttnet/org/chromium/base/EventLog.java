package com.ttnet.org.chromium.base;

import com.bytedance.covode.number.Covode;
import com.ttnet.org.chromium.base.annotations.JNINamespace;

@JNINamespace("base::android")
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class EventLog {
    static {
        Covode.recordClassIndex(654192);
    }

    public static void writeEvent(int i, int i2) {
        android.util.EventLog.writeEvent(i, i2);
    }
}
