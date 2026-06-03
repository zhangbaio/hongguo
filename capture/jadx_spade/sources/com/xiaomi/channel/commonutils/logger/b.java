package com.xiaomi.channel.commonutils.logger;

import android.content.Context;
import android.os.Process;
import android.util.Log;
import com.bytedance.covode.number.Covode;
import com.xiaomi.push.j;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class b {
    private static int a;

    /* renamed from: a, reason: collision with other field name */
    private static Context f1a;

    /* renamed from: a, reason: collision with other field name */
    private static LoggerInterface f2a;

    /* renamed from: a, reason: collision with other field name */
    private static final Integer f3a;

    /* renamed from: a, reason: collision with other field name */
    private static String f4a;

    /* renamed from: a, reason: collision with other field name */
    private static final HashMap<Integer, Long> f5a;

    /* renamed from: a, reason: collision with other field name */
    private static AtomicInteger f6a;

    /* renamed from: a, reason: collision with other field name */
    private static boolean f7a;
    private static final HashMap<Integer, String> b;

    /* renamed from: b, reason: collision with other field name */
    private static boolean f8b;

    /* renamed from: a, reason: collision with other method in class */
    private static boolean m57a() {
        return false;
    }

    public static int a() {
        return a;
    }

    /* renamed from: a, reason: collision with other method in class */
    private static boolean m58a(int i) {
        return i >= a || m57a();
    }

    /* renamed from: a, reason: collision with other method in class */
    public static void m54a(String str) {
        if (m58a(2)) {
            a(2, m53a(str));
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public static void m55a(String str, String str2) {
        if (m58a(2)) {
            a(2, b(str, str2));
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public static void m56a(String str, Object... objArr) {
        if (m58a(2)) {
            a(2, a(str, objArr));
        }
    }

    public static void a(String str, Throwable th) {
        if (m58a(4)) {
            a(4, m53a(str), th);
        }
    }

    public static void a(Throwable th) {
        if (m58a(4)) {
            a(4, th);
        }
    }

    public static void a(Integer num) {
        if (a <= 1) {
            HashMap<Integer, Long> hashMap = f5a;
            if (hashMap.containsKey(num)) {
                long longValue = hashMap.remove(num).longValue();
                String remove = b.remove(num);
                long currentTimeMillis = System.currentTimeMillis() - longValue;
                f2a.log(remove + " ends in " + currentTimeMillis + " ms");
            }
        }
    }

    public static void a(int i, Throwable th) {
        if (i >= a) {
            f2a.log("", th);
            return;
        }
        if (m57a()) {
            Log.w("MyLog", "-->log(" + i + "): ", th);
        }
    }

    public static void a(Context context) {
        f1a = context;
        if (j.m631a(context)) {
            f7a = true;
        }
        if (j.m630a()) {
            f8b = true;
        }
    }

    static class a implements LoggerInterface {
        private String a = b.f4a;

        static {
            Covode.recordClassIndex(655241);
        }

        a() {
        }

        @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
        public void setTag(String str) {
            this.a = str;
        }

        @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
        public void log(String str) {
            Log.v(this.a, str);
        }

        @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
        public void log(String str, Throwable th) {
            Log.v(this.a, str, th);
        }
    }

    private static String b() {
        return "[Tid:" + Thread.currentThread().getId() + "] ";
    }

    static {
        Covode.recordClassIndex(655240);
        a = 2;
        f7a = false;
        f8b = false;
        f4a = "XMPush-" + Process.myPid();
        f2a = new a();
        f5a = new HashMap<>();
        b = new HashMap<>();
        f3a = -1;
        f6a = new AtomicInteger(1);
    }

    public static void a(LoggerInterface loggerInterface) {
        f2a = loggerInterface;
    }

    public static void b(String str) {
        if (m58a(0)) {
            a(0, m53a(str));
        }
    }

    public static void c(String str) {
        if (m58a(0)) {
            a(1, m53a(str));
        }
    }

    public static void d(String str) {
        if (m58a(4)) {
            a(4, m53a(str));
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    private static String m53a(String str) {
        return b() + str;
    }

    public static void e(String str) {
        if (f7a) {
            m54a(str);
            return;
        }
        Log.w(f4a, m53a(str));
        if (!f8b) {
            m54a(str);
        }
    }

    public static Integer a(String str) {
        if (a <= 1) {
            Integer valueOf = Integer.valueOf(f6a.incrementAndGet());
            f5a.put(valueOf, Long.valueOf(System.currentTimeMillis()));
            b.put(valueOf, str);
            f2a.log(str + " starts");
            return valueOf;
        }
        return f3a;
    }

    public static void a(int i) {
        if (i < 0 || i > 5) {
            a(2, "set log level as " + i);
        }
        a = i;
    }

    public static void c(String str, String str2) {
        if (m58a(4)) {
            a(4, b(str, str2));
        }
    }

    public static void d(String str, String str2) {
        if (f7a) {
            m55a(str, str2);
            return;
        }
        Log.w(f4a, b(str, str2));
        if (!f8b) {
            m55a(str, str2);
        }
    }

    private static String b(String str, String str2) {
        return b() + a(str, str2);
    }

    public static String a(String str, String str2) {
        return "[" + str + "] " + str2;
    }

    /* renamed from: b, reason: collision with other method in class */
    public static void m59b(String str, String str2) {
        if (m58a(1)) {
            a(1, b(str, str2));
        }
    }

    private static String a(String str, Object... objArr) {
        StringBuilder sb = new StringBuilder();
        sb.append("[Tid:");
        sb.append(Thread.currentThread().getId());
        sb.append("] ");
        sb.append("[");
        sb.append(str);
        sb.append("] ");
        if (objArr != null && objArr.length > 0) {
            for (Object obj : objArr) {
                sb.append(obj);
            }
        }
        return sb.toString();
    }

    public static void b(String str, Object... objArr) {
        if (m58a(1)) {
            a(1, a(str, objArr));
        }
    }

    public static void a(int i, String str) {
        if (i >= a) {
            f2a.log(str);
            return;
        }
        if (m57a()) {
            Log.d("MyLog", "-->log(" + i + "): " + str);
        }
    }

    public static void a(int i, String str, Throwable th) {
        if (i >= a) {
            f2a.log(str, th);
            return;
        }
        if (m57a()) {
            Log.w("MyLog", "-->log(" + i + "): " + str, th);
        }
    }
}
