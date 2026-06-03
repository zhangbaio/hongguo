package com.unionpay.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.bytedance.covode.number.Covode;
import java.security.MessageDigest;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class UPUtils {
    static {
        Covode.recordClassIndex(654930);
    }

    public static String a(int i) {
        try {
            return f(forUrl(i, Build.VERSION.SDK_INT >= 23));
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static String b(int i, String str) {
        try {
            return f(forConfig(i, str));
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static String c(Context context, String str) {
        if (context == null) {
            return null;
        }
        String i = i(context.getSharedPreferences("UnionPayPluginEx.pref", 0).getString(str, ""), ("0000000023456789abcdef12123456786789abcd").substring(0, 32));
        return (i != null && i.endsWith("00000000")) ? i.substring(0, i.length() - 8) : "";
    }

    public static String d(String str) {
        try {
            byte[] bytes = str.getBytes();
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            messageDigest.reset();
            messageDigest.update(bytes);
            return a.a(messageDigest.digest());
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String e(String str, String str2) {
        try {
            return a.a(d.b(a.b(str2), str.getBytes("utf-8")));
        } catch (Throwable unused) {
            return "";
        }
    }

    private static String f(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        try {
            return new String(bArr, "utf-8");
        } catch (Throwable unused) {
            j.d("uppay", "convert byteMsg to utf-8 String error!!!!");
            return "";
        }
    }

    public static native synchronized byte[] forCallingAppUrl(int i, boolean z);

    public static native synchronized byte[] forConfig(int i, String str);

    public static native synchronized byte[] forDirectAppsUrl(int i, boolean z);

    public static native synchronized byte[] forScanUrl(int i, boolean z);

    public static native synchronized byte[] forUrl(int i, boolean z);

    public static native synchronized byte[] forWap(int i, String str);

    public static void g(Context context, String str, String str2) {
        if (context != null) {
            String e = e(str + "00000000", ("0000000023456789abcdef12123456786789abcd").substring(0, 32));
            if (e == null) {
                e = "";
            }
            SharedPreferences.Editor edit = context.getSharedPreferences("UnionPayPluginEx.pref", 0).edit();
            edit.putString(str2, e);
            edit.commit();
        }
    }

    public static native synchronized String getIssuer(int i);

    public static native synchronized String getSubject(int i);

    public static native synchronized String getTalkingDataIdForAssist(int i);

    public static String h(int i, String str) {
        try {
            return f(forWap(i, str));
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private static String i(String str, String str2) {
        try {
            return new String(d.c(a.b(str2), a.b(str)), "utf-8").trim();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static void j(Context context, String str) {
        if (context != null) {
            SharedPreferences.Editor edit = context.getSharedPreferences("UnionPayPluginEx.pref", 0).edit();
            edit.remove(str);
            edit.commit();
        }
    }

    public static String k(int i) {
        try {
            return f(forCallingAppUrl(i, Build.VERSION.SDK_INT >= 23));
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
