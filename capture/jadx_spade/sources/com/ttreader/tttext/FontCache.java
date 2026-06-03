package com.ttreader.tttext;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class FontCache {
    private static native void nativeClearCache();

    private static native long nativeGetHitCount();

    private static native long nativeGetMissCount();

    private static native void nativeSetChineseMeasureOpt(boolean z);

    static {
        Covode.recordClassIndex(654787);
        System.loadLibrary("tttext");
    }

    public static void a() {
        JavaFontManager.GetInstance().clearCache();
        nativeClearCache();
    }
}
