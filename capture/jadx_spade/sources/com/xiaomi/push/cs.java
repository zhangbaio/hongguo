package com.xiaomi.push;

import android.content.Context;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class cs {
    private static ck a;

    /* renamed from: a, reason: collision with other field name */
    private static cl f217a;

    static {
        Covode.recordClassIndex(655424);
    }

    static void a(String str) {
        cj.a("Push-PowerStats", str);
    }

    /* renamed from: b, reason: collision with other method in class */
    private static boolean m257b(Context context) {
        return cj.a(context);
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m256a(Context context) {
        return i.m624b(context);
    }

    public static void a(Context context) {
        a("onSendMsg");
        if (!m257b(context)) {
            return;
        }
        cv.a(context, System.currentTimeMillis(), m256a(context));
    }

    public static void b(Context context) {
        a("onReceiveMsg");
        if (!m257b(context)) {
            return;
        }
        cv.b(context, System.currentTimeMillis(), m256a(context));
    }

    public static void c(Context context) {
        a("onPing");
        if (!m257b(context)) {
            return;
        }
        cv.c(context, System.currentTimeMillis(), m256a(context));
    }

    public static void d(Context context) {
        a("onPong");
        if (!m257b(context)) {
            return;
        }
        cv.d(context, System.currentTimeMillis(), m256a(context));
    }

    public static void a(Context context, ez ezVar) {
        if (m257b(context)) {
            if (a == null) {
                a = new ck(context);
            }
            if (f217a == null) {
                f217a = new cl(context);
            }
            ck ckVar = a;
            ezVar.a(ckVar, ckVar);
            cl clVar = f217a;
            ezVar.b(clVar, clVar);
            a("startStats");
        }
    }

    public static void b(Context context, ez ezVar) {
        ck ckVar = a;
        if (ckVar != null) {
            ezVar.a(ckVar);
            a = null;
        }
        cl clVar = f217a;
        if (clVar != null) {
            ezVar.b(clVar);
            f217a = null;
        }
        a("stopStats");
    }
}
