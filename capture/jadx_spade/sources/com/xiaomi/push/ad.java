package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.covode.number.Covode;
import com.ss.android.ugc.bytex.taskmonitor.proxy.PThreadScheduledThreadPoolExecutorDelegate;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class ad {
    private static volatile ad a;

    /* renamed from: a, reason: collision with other field name */
    private SharedPreferences f85a;

    /* renamed from: a, reason: collision with other field name */
    private ScheduledThreadPoolExecutor f88a = new PThreadScheduledThreadPoolExecutorDelegate(1, new DefaultThreadFactory("iaomi/push/ad"));

    /* renamed from: a, reason: collision with other field name */
    private Map<String, ScheduledFuture> f87a = new HashMap();

    /* renamed from: a, reason: collision with other field name */
    private Object f86a = new Object();

    public static abstract class a implements Runnable {
        static {
            Covode.recordClassIndex(655331);
        }

        /* renamed from: a */
        public abstract String mo187a();
    }

    static {
        Covode.recordClassIndex(655330);
    }

    public boolean a(a aVar, int i, int i2) {
        return a(aVar, i, i2, false);
    }

    public boolean a(a aVar, int i, int i2, final boolean z) {
        if (aVar == null || a(aVar) != null) {
            return false;
        }
        final String a2 = a(aVar.mo187a());
        b bVar = new b(aVar) { // from class: com.xiaomi.push.ad.1
            @Override // com.xiaomi.push.ad.b
            void a() {
                super.a();
            }

            @Override // com.xiaomi.push.ad.b
            void b() {
                if (!z) {
                    ad.this.f85a.edit().putLong(a2, System.currentTimeMillis()).commit();
                }
            }
        };
        if (!z) {
            long abs = Math.abs(System.currentTimeMillis() - this.f85a.getLong(a2, 0L)) / 1000;
            if (abs < i - i2) {
                i2 = (int) (i - abs);
            }
        }
        try {
            ScheduledFuture<?> scheduleAtFixedRate = this.f88a.scheduleAtFixedRate(bVar, i2, i, TimeUnit.SECONDS);
            synchronized (this.f86a) {
                this.f87a.put(aVar.mo187a(), scheduleAtFixedRate);
            }
            return true;
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            return true;
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m135a(String str) {
        synchronized (this.f86a) {
            ScheduledFuture scheduledFuture = this.f87a.get(str);
            if (scheduledFuture == null) {
                return false;
            }
            this.f87a.remove(str);
            return scheduledFuture.cancel(false);
        }
    }

    private static class b implements Runnable {
        a a;

        static {
            Covode.recordClassIndex(655332);
        }

        void a() {
        }

        void b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a();
            this.a.run();
            b();
        }

        public b(a aVar) {
            this.a = aVar;
        }
    }

    public static ad a(Context context) {
        if (a == null) {
            synchronized (ad.class) {
                if (a == null) {
                    a = new ad(context);
                }
            }
        }
        return a;
    }

    private ad(Context context) {
        this.f85a = context.getSharedPreferences("mipush_extra", 0);
    }

    private static String a(String str) {
        return "last_job_time" + str;
    }

    private ScheduledFuture a(a aVar) {
        ScheduledFuture scheduledFuture;
        synchronized (this.f86a) {
            scheduledFuture = this.f87a.get(aVar.mo187a());
        }
        return scheduledFuture;
    }

    public void a(Runnable runnable) {
        a(runnable, 0);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m134a(a aVar) {
        return b(aVar, 0);
    }

    public boolean b(a aVar, int i) {
        if (aVar != null && a(aVar) == null) {
            ScheduledFuture<?> schedule = this.f88a.schedule(new b(aVar) { // from class: com.xiaomi.push.ad.2
                @Override // com.xiaomi.push.ad.b
                void b() {
                    synchronized (ad.this.f86a) {
                        ad.this.f87a.remove(super.a.mo187a());
                    }
                }
            }, i, TimeUnit.SECONDS);
            synchronized (this.f86a) {
                this.f87a.put(aVar.mo187a(), schedule);
            }
            return true;
        }
        return false;
    }

    public void a(Runnable runnable, int i) {
        this.f88a.schedule(runnable, i, TimeUnit.SECONDS);
    }

    public boolean a(a aVar, int i) {
        return a(aVar, i, 0);
    }
}
