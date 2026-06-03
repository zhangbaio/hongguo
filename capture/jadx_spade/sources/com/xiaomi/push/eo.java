package com.xiaomi.push;

import android.os.SystemClock;
import com.bytedance.covode.number.Covode;
import com.xiaomi.push.el;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.am;
import java.util.Hashtable;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class eo {
    private static final int a;

    /* renamed from: a, reason: collision with other field name */
    private static long f392a;

    /* renamed from: a, reason: collision with other method in class */
    public static byte[] m392a() {
        ej m389a = en.m386a().m389a();
        if (m389a != null) {
            return ho.a(m389a);
        }
        return null;
    }

    static class a {
        static Hashtable<Integer, Long> a;

        static {
            Covode.recordClassIndex(655496);
            a = new Hashtable<>();
        }
    }

    public static void b() {
        a(0, a, null, -1);
    }

    static {
        Covode.recordClassIndex(655495);
        a = eh.PING_RTT.a();
        f392a = 0L;
    }

    public static void a() {
        if (f392a == 0 || SystemClock.elapsedRealtime() - f392a > 7200000) {
            f392a = SystemClock.elapsedRealtime();
            a(0, a);
        }
    }

    public static void a(int i) {
        ei m388a = en.m386a().m388a();
        m388a.a(eh.CHANNEL_STATS_COUNTER.a());
        m388a.c(i);
        en.m386a().a(m388a);
    }

    public static void a(XMPushService xMPushService, am.b bVar) {
        new ek(xMPushService, bVar).a();
    }

    public static synchronized void a(int i, int i2) {
        synchronized (eo.class) {
            if (i2 < 16777215) {
                a.a.put(Integer.valueOf((i << 24) | i2), Long.valueOf(System.currentTimeMillis()));
            } else {
                com.xiaomi.channel.commonutils.logger.b.d("stats key should less than 16777215");
            }
        }
    }

    public static void b(String str, Exception exc) {
        int i;
        try {
            el.a d = el.d(exc);
            ei m388a = en.m386a().m388a();
            m388a.a(d.a.a());
            m388a.c(d.f381a);
            m388a.b(str);
            if (en.a() != null && en.a().f384a != null) {
                if (at.b(en.a().f384a)) {
                    i = 1;
                } else {
                    i = 0;
                }
                m388a.c(i);
            }
            en.m386a().a(m388a);
        } catch (NullPointerException unused) {
        }
    }

    public static void a(String str, Exception exc) {
        int i;
        try {
            el.a b = el.b(exc);
            ei m388a = en.m386a().m388a();
            m388a.a(b.a.a());
            m388a.c(b.f381a);
            m388a.b(str);
            if (en.a() != null && en.a().f384a != null) {
                if (at.b(en.a().f384a)) {
                    i = 1;
                } else {
                    i = 0;
                }
                m388a.c(i);
            }
            en.m386a().a(m388a);
        } catch (NullPointerException unused) {
        }
    }

    public static void a(String str, int i, Exception exc) {
        ei m388a = en.m386a().m388a();
        if (en.a() != null && en.a().f384a != null) {
            m388a.c(at.b(en.a().f384a) ? 1 : 0);
        }
        if (i > 0) {
            m388a.a(eh.GSLB_REQUEST_SUCCESS.a());
            m388a.b(str);
            m388a.b(i);
            en.m386a().a(m388a);
            return;
        }
        try {
            el.a a2 = el.a(exc);
            m388a.a(a2.a.a());
            m388a.c(a2.f381a);
            m388a.b(str);
            en.m386a().a(m388a);
        } catch (NullPointerException unused) {
        }
    }

    public static synchronized void a(int i, int i2, String str, int i3) {
        synchronized (eo.class) {
            long currentTimeMillis = System.currentTimeMillis();
            int i4 = (i << 24) | i2;
            if (a.a.containsKey(Integer.valueOf(i4))) {
                ei m388a = en.m386a().m388a();
                m388a.a(i2);
                m388a.b((int) (currentTimeMillis - a.a.get(Integer.valueOf(i4)).longValue()));
                m388a.b(str);
                if (i3 > -1) {
                    m388a.c(i3);
                }
                en.m386a().a(m388a);
                a.a.remove(Integer.valueOf(i2));
            } else {
                com.xiaomi.channel.commonutils.logger.b.d("stats key not found");
            }
        }
    }

    public static void a(int i, int i2, int i3, String str, int i4) {
        ei m388a = en.m386a().m388a();
        m388a.a((byte) i);
        m388a.a(i2);
        m388a.b(i3);
        m388a.b(str);
        m388a.c(i4);
        en.m386a().a(m388a);
    }
}
