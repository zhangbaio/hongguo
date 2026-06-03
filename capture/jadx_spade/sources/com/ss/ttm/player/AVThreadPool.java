package com.ss.ttm.player;

import com.bytedance.covode.number.Covode;
import com.ss.android.ugc.bytex.taskmonitor.proxy.PThreadPoolExecutorDelegate;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class AVThreadPool {
    private static ThreadPoolExecutor mExecutorInstance;
    private static volatile ExecutorService mExtExecutorInstance;

    static {
        Covode.recordClassIndex(652084);
    }

    private static synchronized ExecutorService getExecutorInstance() {
        ExecutorService executorService;
        synchronized (AVThreadPool.class) {
            if (mExtExecutorInstance != null) {
                executorService = mExtExecutorInstance;
            } else {
                if (mExecutorInstance == null) {
                    mExecutorInstance = new PThreadPoolExecutorDelegate(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), new DefaultThreadFactory("/AVThreadPool"));
                }
                executorService = mExecutorInstance;
            }
        }
        return executorService;
    }

    public static synchronized Future<String> addTask(Callable<String> callable) {
        Future<String> submit;
        synchronized (AVThreadPool.class) {
            submit = getExecutorInstance().submit(callable);
        }
        return submit;
    }

    public static synchronized void setExecutorInstance(ExecutorService executorService) {
        synchronized (AVThreadPool.class) {
            mExtExecutorInstance = executorService;
        }
    }

    public static synchronized void addTask(Runnable runnable) {
        synchronized (AVThreadPool.class) {
            getExecutorInstance().submit(runnable);
        }
    }
}
