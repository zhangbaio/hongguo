package com.ttnet.org.chromium.base;

import android.util.Log;
import com.bytedance.covode.number.Covode;
import java.util.Locale;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class h {
    static {
        Covode.recordClassIndex(654227);
    }

    private static boolean i() {
        return false;
    }

    private h() {
    }

    private static String e() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String name = h.class.getName();
        int i = 0;
        while (true) {
            if (i >= stackTrace.length) {
                break;
            }
            if (stackTrace[i].getClassName().equals(name)) {
                i += 3;
                break;
            }
            i++;
        }
        return stackTrace[i].getFileName() + ":" + stackTrace[i].getLineNumber();
    }

    public static String f(Throwable th) {
        return Log.getStackTraceString(th);
    }

    private static Throwable g(Object[] objArr) {
        if (objArr == null || objArr.length == 0) {
            return null;
        }
        Object obj = objArr[objArr.length - 1];
        if (!(obj instanceof Throwable)) {
            return null;
        }
        return (Throwable) obj;
    }

    public static String k(String str) {
        int i;
        if (str.startsWith("cr_")) {
            return str;
        }
        if (str.startsWith("cr.")) {
            i = 3;
        } else {
            i = 0;
        }
        return "cr_" + str.substring(i, str.length());
    }

    public static boolean j(String str, int i) {
        if (!i() && i <= 4) {
            return false;
        }
        return Log.isLoggable(str, i);
    }

    public static void b(String str, String str2, Object... objArr) {
        Throwable g = g(objArr);
        String c = c(str2, g, objArr);
        if (g != null) {
            Log.e(k(str), c, g);
        } else {
            Log.e(k(str), c);
        }
    }

    private static String c(String str, Throwable th, Object... objArr) {
        if (objArr != null) {
            if ((th == null && objArr.length > 0) || objArr.length > 1) {
                return String.format(Locale.US, str, objArr);
            }
            return str;
        }
        return str;
    }

    public static void h(String str, String str2, Object... objArr) {
        Throwable g = g(objArr);
        String c = c(str2, g, objArr);
        if (g != null) {
            Log.i(k(str), c, g);
        } else {
            Log.i(k(str), c);
        }
    }

    public static void m(String str, String str2, Object... objArr) {
        Throwable g = g(objArr);
        String c = c(str2, g, objArr);
        if (g != null) {
            Log.w(k(str), c, g);
        } else {
            Log.w(k(str), c);
        }
    }

    public static void a(String str, String str2, Object... objArr) {
        if (!i()) {
            return;
        }
        Throwable g = g(objArr);
        String d = d(str2, g, objArr);
        if (g != null) {
            Log.d(k(str), d, g);
        } else {
            Log.d(k(str), d);
        }
    }

    private static String d(String str, Throwable th, Object... objArr) {
        return "[" + e() + "] " + c(str, th, objArr);
    }

    public static void l(String str, String str2, Object... objArr) {
        if (!i()) {
            return;
        }
        Throwable g = g(objArr);
        String d = d(str2, g, objArr);
        if (g != null) {
            Log.v(k(str), d, g);
        } else {
            Log.v(k(str), d);
        }
    }
}
