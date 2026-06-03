package com.tencent.tinker.lib;

import com.bytedance.covode.number.Covode;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class MuteBoostExecutor {
    private static ExecutorService PRELOAD_EXECUTORS;
    private static ExecutorService SINGLE_EXECUTORS;

    static {
        Covode.recordClassIndex(653698);
        SINGLE_EXECUTORS = PThreadExecutorsUtils.newFixedThreadPool(1, new ThreadFactory() { // from class: com.tencent.tinker.lib.MuteBoostExecutor.1
            private final AtomicInteger threadNumber = new AtomicInteger(1);

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                return new Thread(new ThreadGroup("a"), runnable, "MuteBooster-" + this.threadNumber.getAndIncrement(), 0L);
            }
        });
        PRELOAD_EXECUTORS = PThreadExecutorsUtils.newFixedThreadPool(2, new ThreadFactory() { // from class: com.tencent.tinker.lib.MuteBoostExecutor.2
            private final AtomicInteger threadNumber = new AtomicInteger(1);

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable);
                thread.setName("MutePreload-" + this.threadNumber.getAndIncrement());
                return thread;
            }
        });
    }

    public static Future<?> boostSerial(Runnable runnable) {
        return SINGLE_EXECUTORS.submit(runnable);
    }

    public static <T> Future<T> preload(Callable<T> callable) {
        return PRELOAD_EXECUTORS.submit(callable);
    }

    public static <T> Future<T> boostSerial(Callable<T> callable) {
        return SINGLE_EXECUTORS.submit(callable);
    }

    public static void preload(Runnable runnable) {
        PRELOAD_EXECUTORS.submit(runnable);
    }
}
