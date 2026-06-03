package com.tencent.open.utils;

import android.os.Handler;
import android.os.HandlerThread;
import com.bytedance.covode.number.Covode;
import com.ss.android.ugc.bytex.taskmonitor.proxy.HandlerDelegate;
import com.ss.android.ugc.bytex.taskmonitor.proxy.PThreadPoolExecutorDelegate;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class l {
    public static final Executor a;
    private static Object b;
    private static Handler c;
    private static HandlerThread d;

    public static Executor b() {
        return new a();
    }

    private static class a implements Executor {
        final Queue<Runnable> a;
        Runnable b;

        static {
            Covode.recordClassIndex(653566);
        }

        private a() {
            this.a = new LinkedList();
        }

        protected synchronized void a() {
            Runnable poll = this.a.poll();
            this.b = poll;
            if (poll != null) {
                l.a.execute(poll);
            }
        }

        @Override // java.util.concurrent.Executor
        public synchronized void execute(final Runnable runnable) {
            this.a.offer(new Runnable() { // from class: com.tencent.open.utils.l.a.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        runnable.run();
                    } finally {
                        a.this.a();
                    }
                }
            });
            if (this.b == null) {
                a();
            }
        }
    }

    static {
        Covode.recordClassIndex(653565);
        b = new Object();
        a = c();
    }

    private static Executor c() {
        return new PThreadPoolExecutorDelegate(0, 3, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new DefaultThreadFactory("/open/utils/l"));
    }

    public static Handler a() {
        if (c == null) {
            synchronized (l.class) {
                HandlerThread handlerThread = new HandlerThread("SDK_SUB");
                d = handlerThread;
                handlerThread.start();
                c = new HandlerDelegate(d.getLooper());
            }
        }
        return c;
    }

    public static void a(Runnable runnable) {
        try {
            a.execute(runnable);
        } catch (RejectedExecutionException unused) {
        }
    }

    public static void b(Runnable runnable) {
        a().post(runnable);
    }
}
