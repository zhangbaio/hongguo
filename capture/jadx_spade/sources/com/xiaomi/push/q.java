package com.xiaomi.push;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class q {
    private static Context a;

    /* renamed from: a, reason: collision with other field name */
    private static String f851a;

    /* renamed from: a, reason: collision with other method in class */
    public static Context m640a() {
        return a;
    }

    static {
        Covode.recordClassIndex(655627);
        f851a = null;
    }

    private static String b() {
        String a2 = p.a("ro.build.version.emui", "");
        f851a = a2;
        return a2;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m642a() {
        return TextUtils.equals((String) av.a("android.os.SystemProperties", "get", "sys.boot_completed"), "1");
    }

    /* renamed from: b, reason: collision with other method in class */
    public static boolean m644b() {
        try {
            return a(null, "miui.os.Build").getField("IS_GLOBAL_BUILD").getBoolean(Boolean.FALSE);
        } catch (ClassNotFoundException unused) {
            com.xiaomi.channel.commonutils.logger.b.d("miui.os.Build ClassNotFound");
            return false;
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            return false;
        }
    }

    public static int a() {
        try {
            Class<?> a2 = a(null, "miui.os.Build");
            if (a2.getField("IS_STABLE_VERSION").getBoolean(null)) {
                return 3;
            }
            if (a2.getField("IS_DEVELOPMENT_VERSION").getBoolean(null)) {
                return 2;
            }
            return 1;
        } catch (Exception unused) {
            return 0;
        }
    }

    private static String c() {
        String a2 = p.a("ro.build.version.opporom", "");
        if (!TextUtils.isEmpty(a2) && !a2.startsWith("ColorOS_")) {
            f851a = "ColorOS_" + a2;
        }
        return f851a;
    }

    private static String d() {
        String a2 = p.a("ro.vivo.os.version", "");
        if (!TextUtils.isEmpty(a2) && !a2.startsWith("FuntouchOS_")) {
            f851a = "FuntouchOS_" + a2;
        }
        return f851a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static synchronized String m641a() {
        synchronized (q.class) {
            String str = f851a;
            if (str != null) {
                return str;
            }
            String str2 = Build.VERSION.INCREMENTAL;
            if (a() <= 0) {
                String b = b();
                if (TextUtils.isEmpty(b)) {
                    b = c();
                    if (TextUtils.isEmpty(b)) {
                        b = d();
                        if (TextUtils.isEmpty(b)) {
                            str2 = String.valueOf(p.a("ro.product.brand", "Android") + "_" + str2);
                        }
                    }
                }
                str2 = b;
            }
            f851a = str2;
            return str2;
        }
    }

    public static void a(Context context) {
        a = context.getApplicationContext();
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m643a(Context context) {
        try {
            if ((context.getApplicationInfo().flags & 2) == 0) {
                return false;
            }
            return true;
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            return false;
        }
    }

    public static Class<?> a(Context context, String str) {
        boolean z;
        if (str != null && str.trim().length() != 0) {
            if (context != null) {
                z = true;
            } else {
                z = false;
            }
            if (z && Build.VERSION.SDK_INT >= 29) {
                try {
                    return context.getClassLoader().loadClass(str);
                } catch (Throwable unused) {
                }
            }
            try {
                return l3.a.q(str);
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.m54a(String.format("loadClass fail hasContext= %s, errMsg = %s", Boolean.valueOf(z), th.getLocalizedMessage()));
                throw new ClassNotFoundException("loadClass fail ", th);
            }
        }
        throw new ClassNotFoundException("class is empty");
    }
}
