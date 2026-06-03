package com.ss.ttvideoengine.utils;

import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.covode.number.Covode;
import java.util.Random;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class SessionIDGenerator {
    static {
        Covode.recordClassIndex(652756);
    }

    public static String generateTrackID(String str) {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            sb.append("T");
        }
        sb.append(Long.toString(System.currentTimeMillis()));
        sb.append("T");
        sb.append(Integer.toString((int) (Math.random() * 65535.0d)));
        return sb.toString();
    }

    public static String generateSessionID(String str) {
        String str2 = new String();
        if (str != null) {
            str2 = str2 + str;
        }
        return Base64.encodeToString(((str2 + new Random().nextInt()) + System.currentTimeMillis()).getBytes(), 2);
    }
}
