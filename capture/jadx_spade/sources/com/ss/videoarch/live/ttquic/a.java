package com.ss.videoarch.live.ttquic;

import android.text.TextUtils;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
class a {
    private static final String a;

    a() {
    }

    static {
        Covode.recordClassIndex(652880);
        a = a.class.getSimpleName();
    }

    public static void a(String str) throws Exception {
        if (!TextUtils.isEmpty(str)) {
            System.loadLibrary(str);
            return;
        }
        throw new Exception("Invalid library name.");
    }
}
