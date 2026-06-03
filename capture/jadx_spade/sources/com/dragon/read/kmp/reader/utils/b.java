package com.dragon.read.kmp.reader.utils;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.utils.AppUtils;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b {
    public static final b a;

    static {
        Covode.recordClassIndex(608649);
        a = new b();
    }

    private b() {
    }

    private final gj4.a a(String str) {
        return com.dragon.read.kmp.local.a.a.c(AppUtils.a.a(), "crypt_key_kv_" + str);
    }

    public final int b(String str) {
        boolean z;
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            return 0;
        }
        return a(str).getInt("key_timestamp", 0);
    }
}
