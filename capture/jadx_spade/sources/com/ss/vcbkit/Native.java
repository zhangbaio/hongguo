package com.ss.vcbkit;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
class Native {
    static {
        Covode.recordClassIndex(652845);
    }

    Native() {
    }

    static native void nativeLog(int i, String str, String str2);

    static native void setConsoleLog(boolean z);

    static native void setHubbleTrace(long j, long j2);
}
