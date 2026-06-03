package com.unionpay.utils;

import com.bytedance.covode.number.Covode;
import java.util.Locale;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class k {
    private static k f;
    public String a = "";
    public String b = "";
    public String c = "";
    public String d = "";
    public String e = "";

    static {
        Covode.recordClassIndex(654941);
        f = null;
    }

    public static k a() {
        if (f == null) {
            f = Locale.getDefault().toString().startsWith("zh") ? new l() : new m();
        }
        return f;
    }
}
