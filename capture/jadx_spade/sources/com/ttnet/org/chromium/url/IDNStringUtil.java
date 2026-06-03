package com.ttnet.org.chromium.url;

import com.bytedance.covode.number.Covode;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import java.net.IDN;

@JNINamespace("url::android")
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class IDNStringUtil {
    static {
        Covode.recordClassIndex(654696);
    }

    private static String idnToASCII(String str) {
        try {
            return IDN.toASCII(str, 2);
        } catch (Exception unused) {
            return null;
        }
    }
}
