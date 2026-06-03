package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class cp {
    private static int a;

    private static int a(boolean z) {
        return z ? 1 : 0;
    }

    public static void a(final Context context, final String str, final boolean z, final long j, final int i, final long j2, final int i2, final String str2, final int i3) {
        ad.a(context).a(new Runnable() { // from class: com.xiaomi.push.cp.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    cp.c(context, str, z, j, i, j2, i2, str2, i3);
                } catch (Exception e) {
                    com.xiaomi.channel.commonutils.logger.b.m54a("DisconnectStatsSP onDisconnection exception: " + e.getMessage());
                }
            }
        });
    }

    private static String[] a(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        return str.split(";");
    }

    static {
        Covode.recordClassIndex(655421);
        a = 0;
    }

    /* renamed from: a, reason: collision with other method in class */
    private static SharedPreferences m253a(Context context) {
        return context.getSharedPreferences("sp_disconnect_stats", 0);
    }

    private static int a(Context context) {
        if (a <= 0) {
            a = j.b(context);
        }
        return a;
    }

    private static void b(Context context) {
        cm.a("resetAfterUpload");
        m253a(context).edit().putString("host", null).putString("network_state", null).putString("reason", null).putString("ping_interval", null).putString("network_type", null).putString("wifi_digest", null).putString("connected_network_type", null).putString("disconnect_time", null).putString("connected_time", null).putLong("last_discnt_time", 0L).putInt("discnt_count", 0).putInt("cnt_count", 0).putString("xmsf_vc", null).putString("android_vc", null).apply();
    }

    /* renamed from: a, reason: collision with other method in class */
    private static void m255a(Context context) {
        cm.a("upload");
        new co().a(context, m254a(context));
        b(context);
    }

    /* renamed from: a, reason: collision with other method in class */
    private static List<cn> m254a(Context context) {
        SharedPreferences m253a = m253a(context);
        String[] a2 = a(m253a.getString("host", null));
        if (a2 != null && a2.length > 0) {
            String[] a3 = a(m253a.getString("network_state", null));
            String[] a4 = a(m253a.getString("reason", null));
            String[] a5 = a(m253a.getString("ping_interval", null));
            String[] a6 = a(m253a.getString("network_type", null));
            String[] a7 = a(m253a.getString("wifi_digest", null));
            String[] a8 = a(m253a.getString("connected_network_type", null));
            String[] a9 = a(m253a.getString("disconnect_time", null));
            String[] a10 = a(m253a.getString("connected_time", null));
            String[] a11 = a(m253a.getString("xmsf_vc", null));
            String[] a12 = a(m253a.getString("android_vc", null));
            if (a3 != null && a4 != null && a5 != null && a6 != null && a7 != null && a8 != null && a9 != null && a10 != null && a11 != null && a12 != null && a2.length == a3.length && a2.length == a4.length && a2.length == a5.length && a2.length == a6.length && a2.length == a7.length && a2.length == a8.length && a2.length == a9.length && a2.length == a10.length && a2.length == a11.length && a2.length == a12.length) {
                ArrayList arrayList = new ArrayList(a2.length);
                int i = 0;
                while (i < a2.length) {
                    cn cnVar = new cn();
                    cnVar.a(1);
                    cnVar.a(a2[i]);
                    cnVar.b(r.a(a3[i], -1));
                    cnVar.c(r.a(a4[i], -1));
                    String[] strArr = a3;
                    String[] strArr2 = a2;
                    ArrayList arrayList2 = arrayList;
                    cnVar.a(r.a(a5[i], -1L));
                    cnVar.d(r.a(a6[i], -1));
                    cnVar.b(a7[i]);
                    cnVar.e(r.a(a8[i], -1));
                    long a13 = r.a(a9[i], -1L);
                    long a14 = r.a(a10[i], -1L);
                    cnVar.b(a14 - a13);
                    cnVar.c(a13);
                    cnVar.d(a14);
                    cnVar.f(r.a(a11[i], -1));
                    cnVar.g(r.a(a12[i], -1));
                    arrayList2.add(cnVar);
                    i++;
                    a3 = strArr;
                    arrayList = arrayList2;
                    a5 = a5;
                    a4 = a4;
                    a2 = strArr2;
                    a6 = a6;
                }
                return arrayList;
            }
            com.xiaomi.channel.commonutils.logger.b.m54a("DisconnectStatsSP Cached data incorrect,drop.");
            return null;
        }
        com.xiaomi.channel.commonutils.logger.b.m54a("DisconnectStatsSP Cached hosts data is empty,drop.");
        return null;
    }

    private static String a(String str, int i) {
        return a(str, String.valueOf(i));
    }

    private static String a(String str, long j) {
        return a(str, String.valueOf(j));
    }

    private static String a(String str, String str2) {
        if (str2 == null || str2.length() == 0) {
            str2 = "null";
        }
        if (str != null && str.length() > 0) {
            return str + ";" + str2;
        }
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void c(Context context, long j) {
        synchronized (cp.class) {
            SharedPreferences m253a = m253a(context);
            long j2 = m253a.getLong("start_time_for_day", 0L);
            if (j2 == 0) {
                m253a.edit().putLong("start_time_for_day", j).putLong("last_discnt_time", 0L).putInt("discnt_count_in_day", 0).putInt("discnt_count", 0).putInt("cnt_count", 0).apply();
                return;
            }
            int i = m253a.getInt("discnt_count", 0);
            int i2 = m253a.getInt("cnt_count", 0);
            if (i > i2) {
                m253a.edit().putInt("cnt_count", i2 + 1).putString("connected_time", a(m253a.getString("connected_time", null), j)).apply();
            }
            if (j - j2 >= 86400000) {
                m253a.edit().putLong("start_time_for_day", j).putInt("discnt_count_in_day", 0).apply();
                m255a(context);
            } else if (i >= 10) {
                m255a(context);
            }
        }
    }

    public static void a(final Context context, final long j) {
        ad.a(context).a(new Runnable() { // from class: com.xiaomi.push.cp.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    cp.c(context, j);
                } catch (Exception e) {
                    com.xiaomi.channel.commonutils.logger.b.m54a("DisconnectStatsSP onReconnection exception: " + e.getMessage());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void c(Context context, String str, boolean z, long j, int i, long j2, int i2, String str2, int i3) {
        synchronized (cp.class) {
            SharedPreferences m253a = m253a(context);
            long j3 = m253a.getLong("start_time_for_day", 0L);
            if (j3 == 0) {
                cm.a("recordDisconnection not initialized");
                return;
            }
            if (j - m253a.getLong("last_discnt_time", 0L) < 60000) {
                cm.a("recordDisconnection anti-shake");
                return;
            }
            if (j - j3 < 86400000) {
                int i4 = m253a.getInt("discnt_count_in_day", 0);
                if (i4 > 100) {
                    cm.a("recordDisconnection count > 100 in 24H cycle,abandon.");
                    return;
                } else {
                    m253a.edit().putInt("discnt_count_in_day", i4 + 1).apply();
                }
            } else {
                cm.a("recordDisconnection with the current time exceeds 24H cycle, go on.");
            }
            int i5 = m253a.getInt("discnt_count", 0);
            if (i5 == m253a.getInt("cnt_count", 0)) {
                a(context, str, a(z), j, i, j2, i2, str2, i3);
                m253a.edit().putLong("last_discnt_time", j).putInt("discnt_count", i5 + 1).apply();
            }
            cm.a("recordDisconnection complete");
        }
    }

    private static void a(Context context, String str, int i, long j, int i2, long j2, int i3, String str2, int i4) {
        cm.a(String.format(Locale.US, "recordDisconnectInfo host=%s, netState=%d, currentTimeMillis=%d, reason=%d, pingInterval=%d, netType=%d, wifiDigest=%s, connectedNetType=%d", str, Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2), Long.valueOf(j2), Integer.valueOf(i3), str2, Integer.valueOf(i4)));
        SharedPreferences m253a = m253a(context);
        String string = m253a.getString("host", null);
        String string2 = m253a.getString("network_state", null);
        String string3 = m253a.getString("reason", null);
        String string4 = m253a.getString("ping_interval", null);
        String string5 = m253a.getString("network_type", null);
        String string6 = m253a.getString("wifi_digest", null);
        String string7 = m253a.getString("connected_network_type", null);
        String string8 = m253a.getString("disconnect_time", null);
        String string9 = m253a.getString("xmsf_vc", null);
        String string10 = m253a.getString("android_vc", null);
        String a2 = a(string, str);
        String a3 = a(string2, i);
        String a4 = a(string3, i2);
        String a5 = a(string4, j2);
        String a6 = a(string5, i3);
        String a7 = a(string6, str2);
        String a8 = a(string7, i4);
        String a9 = a(string8, j);
        m253a.edit().putString("host", a2).putString("network_state", a3).putString("reason", a4).putString("ping_interval", a5).putString("network_type", a6).putString("wifi_digest", a7).putString("connected_network_type", a8).putString("disconnect_time", a9).putString("xmsf_vc", a(string9, a(context))).putString("android_vc", a(string10, Build.VERSION.SDK_INT)).apply();
    }
}
