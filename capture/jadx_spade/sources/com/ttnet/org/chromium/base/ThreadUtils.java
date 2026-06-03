package com.ttnet.org.chromium.base;

import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import com.bytedance.covode.number.Covode;
import com.ss.android.ugc.bytex.taskmonitor.proxy.HandlerDelegate;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class ThreadUtils {
    private static final Object a;
    private static boolean b;
    private static Handler c;

    public static void a() {
    }

    public static void b() {
    }

    public static class a {
        private final long a = Process.myTid();

        public void a() {
        }

        static {
            Covode.recordClassIndex(654267);
        }
    }

    static {
        Covode.recordClassIndex(654266);
        a = new Object();
    }

    public static Looper d() {
        return c().getLooper();
    }

    public static boolean k() {
        if (c().getLooper() == Looper.myLooper()) {
            return true;
        }
        return false;
    }

    public static Handler c() {
        boolean z;
        synchronized (a) {
            if (c == null) {
                if (!b) {
                    c = new HandlerDelegate(Looper.getMainLooper());
                    z = true;
                } else {
                    throw new RuntimeException("Did not yet override the UI thread");
                }
            } else {
                z = false;
            }
        }
        if (z) {
            TraceEvent.i();
        }
        return c;
    }

    public static <T> FutureTask<T> e(FutureTask<T> futureTask) {
        c().post(futureTask);
        return futureTask;
    }

    public static void f(Runnable runnable) {
        c().post(runnable);
    }

    public static void setThreadPriorityAudio(int i) {
        Process.setThreadPriority(i, -16);
    }

    public static <T> FutureTask<T> g(FutureTask<T> futureTask) {
        if (k()) {
            futureTask.run();
        } else {
            e(futureTask);
        }
        return futureTask;
    }

    private static boolean isThreadPriorityAudio(int i) {
        if (Process.getThreadPriority(i) == -16) {
            return true;
        }
        return false;
    }

    public static <T> T j(Callable<T> callable) {
        try {
            return (T) i(callable);
        } catch (ExecutionException e) {
            throw new RuntimeException("Error occurred waiting for callable", e);
        }
    }

    public static void h(Runnable runnable) {
        if (k()) {
            runnable.run();
        } else {
            c().post(runnable);
        }
    }

    public static <T> T i(Callable<T> callable) throws ExecutionException {
        FutureTask futureTask = new FutureTask(callable);
        g(futureTask);
        try {
            return (T) futureTask.get();
        } catch (InterruptedException e) {
            throw new RuntimeException("Interrupted waiting for callable", e);
        }
    }
}
