package io.reactivex.internal.schedulers;

import androidx.compose.animation.core.g1;
import com.bytedance.covode.number.Covode;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class j {
    public static final boolean a;
    public static final int b;
    static final AtomicReference<ScheduledExecutorService> c;
    static final Map<ScheduledThreadPoolExecutor, Object> d;

    public static void c() {
        e(a);
    }

    public static void b() {
        ScheduledExecutorService andSet = c.getAndSet(null);
        if (andSet != null) {
            andSet.shutdownNow();
        }
        d.clear();
    }

    static final class b implements Runnable {
        static {
            Covode.recordClassIndex(657669);
        }

        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it2 = new ArrayList(j.d.keySet()).iterator();
            while (it2.hasNext()) {
                ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = (ScheduledThreadPoolExecutor) it2.next();
                if (scheduledThreadPoolExecutor.isShutdown()) {
                    j.d.remove(scheduledThreadPoolExecutor);
                } else {
                    scheduledThreadPoolExecutor.purge();
                }
            }
        }
    }

    static {
        Covode.recordClassIndex(657667);
        c = new AtomicReference<>();
        d = new ConcurrentHashMap();
        Properties properties = System.getProperties();
        a aVar = new a();
        aVar.a(properties);
        a = aVar.a;
        b = aVar.b;
        c();
    }

    public static ScheduledExecutorService a(ThreadFactory threadFactory) {
        ScheduledExecutorService newScheduledThreadPool = PThreadExecutorsUtils.newScheduledThreadPool(1, threadFactory);
        d(a, newScheduledThreadPool);
        return newScheduledThreadPool;
    }

    static final class a {
        boolean a;
        int b;

        static {
            Covode.recordClassIndex(657668);
        }

        a() {
        }

        void a(Properties properties) {
            if (properties.containsKey("rx2.purge-enabled")) {
                this.a = Boolean.parseBoolean(properties.getProperty("rx2.purge-enabled"));
            } else {
                this.a = true;
            }
            if (this.a && properties.containsKey("rx2.purge-period-seconds")) {
                try {
                    this.b = Integer.parseInt(properties.getProperty("rx2.purge-period-seconds"));
                    return;
                } catch (NumberFormatException unused) {
                    this.b = 1;
                    return;
                }
            }
            this.b = 1;
        }
    }

    static void e(boolean z) {
        if (!z) {
            return;
        }
        while (true) {
            AtomicReference<ScheduledExecutorService> atomicReference = c;
            ScheduledExecutorService scheduledExecutorService = atomicReference.get();
            if (scheduledExecutorService != null) {
                return;
            }
            ScheduledExecutorService newScheduledThreadPool = PThreadExecutorsUtils.newScheduledThreadPool(1, new RxThreadFactory("RxSchedulerPurge"));
            if (g1.a(atomicReference, scheduledExecutorService, newScheduledThreadPool)) {
                b bVar = new b();
                int i = b;
                newScheduledThreadPool.scheduleAtFixedRate(bVar, i, i, TimeUnit.SECONDS);
                return;
            }
            newScheduledThreadPool.shutdownNow();
        }
    }

    static void d(boolean z, ScheduledExecutorService scheduledExecutorService) {
        if (z && (scheduledExecutorService instanceof ScheduledThreadPoolExecutor)) {
            d.put((ScheduledThreadPoolExecutor) scheduledExecutorService, scheduledExecutorService);
        }
    }
}
