package com.dragon.read.kmp.utils;

import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;
import com.dragon.read.util.kotlin.StringKt;
import java.net.URLEncoder;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class f1 {
    public static final f1 a;

    static {
        Covode.recordClassIndex(609579);
        a = new f1();
    }

    private f1() {
    }

    public final String a(String str) {
        if (StringKt.isNotNullOrEmpty(str)) {
            try {
                return URLEncoder.encode(str, "UTF-8");
            } catch (Exception unused) {
                LogWrapper.e("SchemaBuilder, getEncodeParam error, value = %s", new Object[]{str});
            }
        }
        return str;
    }
}
