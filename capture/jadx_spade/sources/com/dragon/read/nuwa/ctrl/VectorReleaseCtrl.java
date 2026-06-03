package com.dragon.read.nuwa.ctrl;

import android.os.Build;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class VectorReleaseCtrl {
    static {
        Covode.recordClassIndex(612613);
    }

    public static boolean enable() {
        if (Build.VERSION.SDK_INT <= 25) {
            return true;
        }
        return false;
    }
}
