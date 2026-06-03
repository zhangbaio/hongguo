package com.xiaomi.push;

import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class az {
    static {
        Covode.recordClassIndex(655367);
    }

    /* renamed from: a, reason: collision with other method in class */
    public static byte[] m166a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(str.getBytes());
                return messageDigest.digest();
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }

    public static String b(String str) {
        return a(str).subSequence(8, 24).toString();
    }

    private static String a(byte b) {
        int i;
        String str;
        int i2 = b & Byte.MAX_VALUE;
        if (b < 0) {
            i = 128;
        } else {
            i = 0;
        }
        int i3 = i2 + i;
        StringBuilder sb = new StringBuilder();
        if (i3 < 16) {
            str = "0";
        } else {
            str = "";
        }
        sb.append(str);
        sb.append(Integer.toHexString(i3).toLowerCase());
        return sb.toString();
    }

    public static String a(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            StringBuffer stringBuffer = new StringBuffer();
            messageDigest.update(str.getBytes(), 0, str.length());
            for (byte b : messageDigest.digest()) {
                stringBuffer.append(a(b));
            }
            return stringBuffer.toString();
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }
}
