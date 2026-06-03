package com.ss.videoarch.strategy.utils;

import android.util.Log;
import com.bytedance.covode.number.Covode;

@JNINamespace("jni")
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class TTClassLoad {
    private static ClassLoader mLoader;

    static Object getObjectLoader() {
        return mLoader;
    }

    static {
        Covode.recordClassIndex(653228);
        mLoader = TTClassLoad.class.getClassLoader();
    }

    public static void init() {
        if (mLoader == null) {
            try {
                mLoader = l3.a.q("com.ss.videoarch.strategy.utils.TTClassLoad").getClassLoader();
            } catch (Exception e) {
                Log.e("TTClassLoad", "init: forName:" + e.getMessage());
            }
            Log.e("TTClassLoad", "init fail:loader is null");
            return;
        }
        Log.w("TTClassLoad", "init success!");
    }
}
