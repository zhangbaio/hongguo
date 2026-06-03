package com.ss.videoarch.strategy.network;

import com.bytedance.covode.number.Covode;
import com.ss.android.ugc.bytex.taskmonitor.proxy.PThreadPoolExecutorDelegate;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class e {
    private final ThreadPoolExecutor a = new PThreadPoolExecutorDelegate(3, 5, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new b());

    static {
        Covode.recordClassIndex(653157);
    }

    private static class b implements ThreadFactory {
        private final ThreadGroup a;
        private final AtomicInteger b;
        private final String c;

        static {
            Covode.recordClassIndex(653158);
        }

        private b() {
            ThreadGroup threadGroup;
            this.b = new AtomicInteger(1);
            SecurityManager securityManager = System.getSecurityManager();
            if (securityManager != null) {
                threadGroup = securityManager.getThreadGroup();
            } else {
                threadGroup = Thread.currentThread().getThreadGroup();
            }
            this.a = threadGroup;
            this.c = "live-strategy-network-";
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(this.a, runnable, this.c + this.b.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 5) {
                thread.setPriority(5);
            }
            return thread;
        }
    }

    public void a(Runnable runnable) {
        this.a.execute(runnable);
    }
}
