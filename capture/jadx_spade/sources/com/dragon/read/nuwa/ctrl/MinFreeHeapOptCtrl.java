package com.dragon.read.nuwa.ctrl;

import android.os.Build;
import android.os.Process;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class MinFreeHeapOptCtrl {
    static {
        Covode.recordClassIndex(612609);
    }

    public static boolean enable() {
        if (Build.VERSION.SDK_INT <= 30 || !Process.is64Bit()) {
            return false;
        }
        return true;
    }
}
