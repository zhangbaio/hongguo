package com.ttnet.org.chromium.net.impl;

import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class j {
    private static Map<String, CronetUrlRequest> a;

    static {
        Covode.recordClassIndex(654618);
        a = new ConcurrentHashMap();
    }

    public static void c(String str) {
        if (!TextUtils.isEmpty(str)) {
            a.remove(str);
        }
    }

    public static CronetUrlRequest b(String str) {
        if (!TextUtils.isEmpty(str)) {
            return a.get(str);
        }
        return null;
    }

    public static void a(String str, CronetUrlRequest cronetUrlRequest) {
        if (!TextUtils.isEmpty(str) && cronetUrlRequest != null) {
            a.put(str, cronetUrlRequest);
        }
    }
}
