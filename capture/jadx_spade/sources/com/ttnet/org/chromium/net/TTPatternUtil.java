package com.ttnet.org.chromium.net;

import com.bytedance.covode.number.Covode;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import java.util.regex.Pattern;

@JNINamespace("net")
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class TTPatternUtil {
    static {
        Covode.recordClassIndex(654531);
    }

    public static boolean isPatternStringValid(String str) {
        try {
            Pattern.compile(str);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
