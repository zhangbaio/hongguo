package com.tencent.tinker.lib;

import android.util.Log;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class Logger {
    static {
        Covode.recordClassIndex(653695);
    }

    public static void d(String str, String str2) {
        System.out.println(str + " >>> " + str2);
    }

    public static void e(String str, String str2) {
        System.err.println(str + " >>> " + str2);
    }

    public static void i(String str, String str2) {
        System.out.println(str + " >>> " + str2);
    }

    public static void v(String str, String str2) {
        System.out.println(str + " >>> " + str2);
    }

    public static void w(String str, String str2) {
        System.out.println(str + " >>> " + str2);
    }

    public static void d(String str, String str2, Throwable th) {
        System.out.println(str + " >>> " + str2 + '\n' + Log.getStackTraceString(th));
    }

    public static void e(String str, String str2, Throwable th) {
        System.err.println(str + " >>> " + str2 + '\n' + Log.getStackTraceString(th));
    }

    public static void i(String str, String str2, Throwable th) {
        System.out.println(str + " >>> " + str2 + '\n' + Log.getStackTraceString(th));
    }

    public static void v(String str, String str2, Throwable th) {
        System.out.println(str + " >>> " + str2 + '\n' + Log.getStackTraceString(th));
    }

    public static void w(String str, String str2, Throwable th) {
        System.out.println(str + " >>> " + str2 + '\n' + Log.getStackTraceString(th));
    }
}
