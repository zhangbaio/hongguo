package com.ss.videoarch.strategy.utils;

import android.text.TextUtils;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class a {
    static {
        Covode.recordClassIndex(653225);
    }

    public static void a(String str) throws Exception {
        if (!TextUtils.isEmpty(str)) {
            System.loadLibrary(str);
            return;
        }
        throw new Exception("Invalid library name.");
    }
}
