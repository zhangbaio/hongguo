package com.vivo.push.util;

import android.content.Context;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class t {
    public static final s a;
    private static boolean b;
    private static boolean c;

    public static boolean a() {
        return b;
    }

    static {
        Covode.recordClassIndex(655205);
        a = new r();
        b = ah.b("persist.sys.log.ctrl", "no").equals("yes");
    }

    public static boolean b() {
        if (b && c) {
            return true;
        }
        return false;
    }

    public static void b(String str) {
        if (b) {
            a.c("VIVO.PUSH.PROFILE.SYNC", str);
        }
    }

    public static void a(String str) {
        if (b) {
            a.c("VIVO.PUSH.MSG_NODE", str);
        }
    }

    public static int a(String str, String str2) {
        return a.a(str, str2);
    }

    public static int b(String str, String str2) {
        return a.b(str, str2);
    }

    public static int c(String str, String str2) {
        return a.c(str, str2);
    }

    public static int d(String str, String str2) {
        return a.d(str, str2);
    }

    public static int e(String str, String str2) {
        return a.e(str, str2);
    }

    public static void c(Context context, String str) {
        a.c(context, str);
    }

    public static int a(String str, Throwable th) {
        return a.a(str, th);
    }

    public static void b(Context context, String str) {
        a.b(context, str);
    }

    public static void a(int i, String str) {
        a("RunTimeException", "code: " + i + ", exceptionMsg: " + str);
    }

    public static void a(Context context, String str) {
        a.a(context, str);
    }

    public static int a(String str, String str2, Throwable th) {
        return a.a(str, str2, th);
    }

    public static int b(String str, String str2, Throwable th) {
        return a.b(str, str2, th);
    }
}
