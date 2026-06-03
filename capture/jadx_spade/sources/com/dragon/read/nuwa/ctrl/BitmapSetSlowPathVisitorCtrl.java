package com.dragon.read.nuwa.ctrl;

import android.os.Build;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class BitmapSetSlowPathVisitorCtrl {
    static {
        Covode.recordClassIndex(612600);
    }

    public static boolean enable() {
        if (Build.VERSION.SDK_INT <= 24) {
            return true;
        }
        return false;
    }
}
