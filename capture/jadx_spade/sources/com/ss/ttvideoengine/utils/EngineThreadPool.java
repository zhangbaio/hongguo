package com.ss.ttvideoengine.utils;

import com.bytedance.covode.number.Covode;
import com.ss.android.ugc.bytex.taskmonitor.proxy.PThreadPoolExecutorDelegate;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class EngineThreadPool {
    private static volatile boolean mEnableLockOptimize;
    private static volatile boolean mEnableThreadPoolOptimize;
    private static volatile ThreadPoolExecutor mExecutorInstance;
    private static Deque<AsyncRunnable> mReadyRunnables;
    private static Deque<AsyncRunnable> mRunningRunnables;

    public static class AsyncRunnable implements Runnable {
        private Runnable mRunnable;

        static {
            Covode.recordClassIndex(652743);
        }

        @Override // java.lang.Runnable
        public void run() {
            this.mRunnable.run();
            EngineThreadPool._finished(this);
        }

        public AsyncRunnable(Runnable runnable) {
            this.mRunnable = runnable;
        }
    }

    public static int getPoolSize() {
        if (mExecutorInstance == null) {
            getExecutorInstance();
        }
        return mExecutorInstance.getPoolSize();
    }

    public static void shutdown() {
        if (mExecutorInstance != null) {
            mExecutorInstance.shutdown();
        }
    }

    static {
        Covode.recordClassIndex(652742);
        mReadyRunnables = new ArrayDeque();
        mRunningRunnables = new ArrayDeque();
        mEnableThreadPoolOptimize = true;
    }

    private static void _promoteRunnable() {
        if (mReadyRunnables.size() > 0) {
            Iterator<AsyncRunnable> it2 = mReadyRunnables.iterator();
            if (it2.hasNext()) {
                AsyncRunnable next = it2.next();
                it2.remove();
                mRunningRunnables.add(next);
                mExecutorInstance.execute(next);
            }
        }
    }

    public static ThreadPoolExecutor getExecutorInstance() {
        if (mExecutorInstance == null) {
            synchronized (EngineThreadPool.class) {
                if (mExecutorInstance == null) {
                    if (mEnableThreadPoolOptimize) {
                        TTVideoEngineInternalLog.i("EngineThreadPool", "mEnableThreadPoolOptimize true");
                        mExecutorInstance = new PThreadPoolExecutorDelegate(5, 5, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new DefaultThreadFactory("EngineThreadPool"));
                        mExecutorInstance.allowCoreThreadTimeOut(true);
                    } else {
                        mExecutorInstance = new PThreadPoolExecutorDelegate(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), new DefaultThreadFactory("EngineThreadPool"));
                    }
                }
            }
        }
        return mExecutorInstance;
    }

    public static void setOptimizeLock(boolean z) {
        mEnableLockOptimize = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void _finished(AsyncRunnable asyncRunnable) {
        synchronized (EngineThreadPool.class) {
            mRunningRunnables.remove(asyncRunnable);
            _promoteRunnable();
        }
    }

    public static void setExecutorInstance(ThreadPoolExecutor threadPoolExecutor) {
        synchronized (EngineThreadPool.class) {
            mExecutorInstance = threadPoolExecutor;
        }
    }

    public static synchronized void setOptimizeEnabled(boolean z) {
        synchronized (EngineThreadPool.class) {
            mEnableThreadPoolOptimize = z;
        }
    }

    public static Future addExecuteTask(Runnable runnable) {
        Future addExecuteTaskInternal;
        if (mEnableLockOptimize) {
            return addExecuteTaskInternal(runnable);
        }
        synchronized (EngineThreadPool.class) {
            addExecuteTaskInternal = addExecuteTaskInternal(runnable);
        }
        return addExecuteTaskInternal;
    }

    private static Future addExecuteTaskInternal(Runnable runnable) {
        if (runnable == null) {
            return null;
        }
        if (mExecutorInstance == null) {
            getExecutorInstance();
        }
        try {
            TTVideoEngineInternalLog.i("EngineThreadPool", "addExecuteTask,pool size:" + getPoolSize() + ", active:" + mExecutorInstance.getActiveCount());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (mEnableThreadPoolOptimize) {
            return mExecutorInstance.submit(runnable);
        }
        synchronized (EngineThreadPool.class) {
            TTVideoEngineInternalLog.i("EngineThreadPool", "running:" + mRunningRunnables.size() + ", ready:" + mReadyRunnables.size());
            AsyncRunnable asyncRunnable = new AsyncRunnable(runnable);
            if (mRunningRunnables.size() >= 5) {
                mReadyRunnables.add(asyncRunnable);
                return null;
            }
            mRunningRunnables.add(asyncRunnable);
            return mExecutorInstance.submit(asyncRunnable);
        }
    }

    public static Future addExecuteTaskSync(Runnable runnable, long j) {
        Future addExecuteTaskSyncInternal;
        if (mEnableLockOptimize) {
            return addExecuteTaskSyncInternal(runnable, j);
        }
        synchronized (EngineThreadPool.class) {
            addExecuteTaskSyncInternal = addExecuteTaskSyncInternal(runnable, j);
        }
        return addExecuteTaskSyncInternal;
    }

    private static Future addExecuteTaskSyncInternal(Runnable runnable, long j) {
        TTVideoEngineInternalLog.i("EngineThreadPool", "addExecuteTaskSync timeout:" + j);
        Future addExecuteTaskInternal = addExecuteTaskInternal(runnable);
        if (addExecuteTaskInternal != null) {
            try {
                addExecuteTaskInternal.get(j, TimeUnit.MILLISECONDS);
            } catch (InterruptedException | ExecutionException | TimeoutException unused) {
                TTVideoEngineInternalLog.e("EngineThreadPool", "set surface time out");
            }
        }
        return addExecuteTaskInternal;
    }
}
