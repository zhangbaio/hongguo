package com.xiaomi.push;

import android.content.Context;
import android.os.Build;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class dh {
    static {
        Covode.recordClassIndex(655443);
    }

    private static void a(byte[] bArr) {
        if (bArr.length >= 2) {
            bArr[0] = 99;
            bArr[1] = 100;
        }
    }

    public static byte[] b(String str, byte[] bArr) {
        byte[] m165a = ax.m165a(str);
        try {
            a(m165a);
            return h.b(m165a, bArr);
        } catch (Exception unused) {
            return null;
        }
    }

    public static byte[] a(String str, byte[] bArr) {
        byte[] m165a = ax.m165a(str);
        try {
            a(m165a);
            return h.a(m165a, bArr);
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean a(Context context, String str, long j) {
        if (!com.xiaomi.push.service.ah.a(context).a(gj.DCJobMutualSwitch.a(), false)) {
            return false;
        }
        if ((Build.VERSION.SDK_INT >= 29 && context.getApplicationInfo().targetSdkVersion >= 29) || ab.a(context, str, j)) {
            return false;
        }
        return true;
    }
}
