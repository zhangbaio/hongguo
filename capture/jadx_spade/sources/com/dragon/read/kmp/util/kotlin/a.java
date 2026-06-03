package com.dragon.read.kmp.util.kotlin;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {
    static {
        Covode.recordClassIndex(609497);
    }

    public static final String a(Object obj) {
        String num;
        if (obj == null || (num = Integer.valueOf(obj.hashCode()).toString()) == null) {
            return "0";
        }
        return num;
    }
}
