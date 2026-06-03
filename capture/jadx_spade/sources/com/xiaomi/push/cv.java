package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class cv {
    private static int a;

    /* renamed from: a, reason: collision with other field name */
    private static boolean f222a;

    private static int a(boolean z) {
        return z ? 1 : 0;
    }

    static {
        Covode.recordClassIndex(655427);
        a = 0;
        f222a = true;
    }

    private static int a(Context context) {
        if (a <= 0) {
            a = j.b(context);
        }
        return a;
    }

    /* renamed from: a, reason: collision with other method in class */
    private static SharedPreferences m262a(Context context) {
        return context.getSharedPreferences("sp_power_stats", 0);
    }

    /* renamed from: a, reason: collision with other method in class */
    private static ct m263a(Context context) {
        SharedPreferences m262a = m262a(context);
        ct ctVar = new ct();
        ctVar.a(m262a.getInt("off_up_count", 0));
        ctVar.b(m262a.getInt("off_down_count", 0));
        ctVar.c(m262a.getInt("off_ping_count", 0));
        ctVar.d(m262a.getInt("off_pong_count", 0));
        ctVar.a(m262a.getLong("off_duration", 0L));
        ctVar.e(m262a.getInt("on_up_count", 0));
        ctVar.f(m262a.getInt("on_down_count", 0));
        ctVar.g(m262a.getInt("on_ping_count", 0));
        ctVar.h(m262a.getInt("on_pong_count", 0));
        ctVar.b(m262a.getLong("on_duration", 0L));
        ctVar.c(m262a.getLong("start_time", 0L));
        ctVar.d(m262a.getLong("end_time", 0L));
        ctVar.i(m262a.getInt("xmsf_vc", 0));
        ctVar.j(m262a.getInt("android_vc", 0));
        return ctVar;
    }

    /* renamed from: a, reason: collision with other method in class */
    private static boolean m264a(Context context) {
        boolean z = false;
        if (f222a) {
            f222a = false;
            SharedPreferences m262a = m262a(context);
            int i = m262a.getInt("xmsf_vc", 0);
            int i2 = m262a.getInt("android_vc", 0);
            if (i != 0 && i2 != 0 && (i != a(context) || i2 != Build.VERSION.SDK_INT)) {
                z = true;
            }
        }
        cs.a("isVcChanged = " + z);
        return z;
    }

    public static void b(final Context context, final long j, final boolean z) {
        ad.a(context).a(new Runnable() { // from class: com.xiaomi.push.cv.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    cv.j(context, j, z);
                } catch (Exception e) {
                    com.xiaomi.channel.commonutils.logger.b.m54a("PowerStatsSP onReceiveMsg exception: " + e.getMessage());
                }
            }
        });
    }

    public static void c(final Context context, final long j, final boolean z) {
        ad.a(context).a(new Runnable() { // from class: com.xiaomi.push.cv.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    cv.k(context, j, z);
                } catch (Exception e) {
                    com.xiaomi.channel.commonutils.logger.b.m54a("PowerStatsSP onPing exception: " + e.getMessage());
                }
            }
        });
    }

    public static void d(final Context context, final long j, final boolean z) {
        ad.a(context).a(new Runnable() { // from class: com.xiaomi.push.cv.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    cv.l(context, j, z);
                } catch (Exception e) {
                    com.xiaomi.channel.commonutils.logger.b.m54a("PowerStatsSP onPong exception: " + e.getMessage());
                }
            }
        });
    }

    private static void a(Context context, long j, int i) {
        cs.a("upload");
        new cu().a(context, m263a(context));
        b(context, j, i);
    }

    private static void b(Context context, long j, int i) {
        cs.a("reset");
        m262a(context).edit().clear().putLong("start_time", j).putInt("current_screen_state", i).putLong("current_screen_state_start_time", j).putInt("xmsf_vc", a(context)).putInt("android_vc", Build.VERSION.SDK_INT).apply();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void i(Context context, long j, boolean z) {
        int i;
        synchronized (cv.class) {
            cs.a("recordSendMsg start");
            int a2 = a(z);
            SharedPreferences m262a = m262a(context);
            long j2 = m262a.getLong("start_time", 0L);
            if (j2 <= 0) {
                a(context, m262a, j, a2);
            }
            if (a2 == 1) {
                i = m262a.getInt("on_up_count", 0) + 1;
                m262a.edit().putInt("on_up_count", i).apply();
            } else {
                i = m262a.getInt("off_up_count", 0) + 1;
                m262a.edit().putInt("off_up_count", i).apply();
            }
            a(context, j2, j, i, a2);
            cs.a("recordSendMsg complete");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void j(Context context, long j, boolean z) {
        int i;
        synchronized (cv.class) {
            cs.a("recordReceiveMsg start");
            int a2 = a(z);
            SharedPreferences m262a = m262a(context);
            long j2 = m262a.getLong("start_time", 0L);
            if (j2 <= 0) {
                a(context, m262a, j, a2);
            }
            if (a2 == 1) {
                i = m262a.getInt("on_down_count", 0) + 1;
                m262a.edit().putInt("on_down_count", i).apply();
            } else {
                i = m262a.getInt("off_down_count", 0) + 1;
                m262a.edit().putInt("off_down_count", i).apply();
            }
            a(context, j2, j, i, a2);
            cs.a("recordReceiveMsg complete");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void k(Context context, long j, boolean z) {
        int i;
        synchronized (cv.class) {
            cs.a("recordPing start");
            int a2 = a(z);
            SharedPreferences m262a = m262a(context);
            long j2 = m262a.getLong("start_time", 0L);
            if (j2 <= 0) {
                a(context, m262a, j, a2);
            }
            if (a2 == 1) {
                i = m262a.getInt("on_ping_count", 0) + 1;
                m262a.edit().putInt("on_ping_count", i).apply();
            } else {
                i = m262a.getInt("off_ping_count", 0) + 1;
                m262a.edit().putInt("off_ping_count", i).apply();
            }
            a(context, j2, j, i, a2);
            cs.a("recordPing complete");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void l(Context context, long j, boolean z) {
        int i;
        synchronized (cv.class) {
            cs.a("recordPong start");
            int a2 = a(z);
            SharedPreferences m262a = m262a(context);
            long j2 = m262a.getLong("start_time", 0L);
            if (j2 <= 0) {
                a(context, m262a, j, a2);
            }
            if (a2 == 1) {
                i = m262a.getInt("on_pong_count", 0) + 1;
                m262a.edit().putInt("on_pong_count", i).apply();
            } else {
                i = m262a.getInt("off_pong_count", 0) + 1;
                m262a.edit().putInt("off_pong_count", i).apply();
            }
            a(context, j2, j, i, a2);
            cs.a("recordPong complete");
        }
    }

    public static void a(final Context context, final long j, final boolean z) {
        ad.a(context).a(new Runnable() { // from class: com.xiaomi.push.cv.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    cv.i(context, j, z);
                } catch (Exception e) {
                    com.xiaomi.channel.commonutils.logger.b.m54a("PowerStatsSP onSendMsg exception: " + e.getMessage());
                }
            }
        });
    }

    private static void a(Context context, SharedPreferences sharedPreferences, long j, int i) {
        cs.a("recordInit");
        sharedPreferences.edit().putLong("start_time", j).putInt("current_screen_state", i).putLong("current_screen_state_start_time", j).putInt("xmsf_vc", a(context)).putInt("android_vc", Build.VERSION.SDK_INT).apply();
    }

    private static void a(Context context, long j, long j2, int i, int i2) {
        if (j > 0) {
            if (m264a(context) || i >= 1073741823 || j2 - j >= 86400000) {
                m262a(context).edit().putLong("end_time", j2).apply();
                a(context, j2, i2);
            }
        }
    }
}
