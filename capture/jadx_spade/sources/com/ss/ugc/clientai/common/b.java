package com.ss.ugc.clientai.common;

import android.content.Context;
import com.bytedance.covode.number.Covode;
import com.ss.ugc.clientai.common.a;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class b {
    public static final boolean a;
    private static a.C0096a b;

    private static class a {
        public static a.C0096a a;

        static {
            Covode.recordClassIndex(652802);
            a = new a.C0096a();
        }
    }

    static {
        Covode.recordClassIndex(652801);
        a = com.ss.ugc.clientai.common.a.a();
        b = null;
    }

    private static a.C0096a d() {
        a.C0096a c0096a = b;
        if (c0096a != null) {
            return c0096a;
        }
        Context context = com.ss.ugc.clientai.common.a.a;
        return a.a;
    }

    public static void a(String str, String str2) {
        d().a(str, str2);
    }

    public static void b(String str, String str2) {
        c(str, str2, null);
    }

    public static void e(String str, String str2) {
        f(str, str2, null);
    }

    public static void c(String str, String str2, Throwable th) {
        d().b(str, str2, th);
    }

    public static void f(String str, String str2, Throwable th) {
        d().c(str, str2, th);
    }
}
