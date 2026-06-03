package com.ss.videoarch.liveplayer.utils;

import com.bytedance.covode.number.Covode;
import com.ss.android.ugc.bytex.taskmonitor.proxy.PThreadPoolExecutorDelegate;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class c {
    private static volatile ThreadPoolExecutor a;
    private static Deque<a> b;
    private static Deque<a> c;

    public static class a implements Runnable {
        private Runnable a;

        static {
            Covode.recordClassIndex(653099);
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.run();
            c.a(this);
        }

        public a(Runnable runnable) {
            this.a = runnable;
        }
    }

    public static int f() {
        if (a == null) {
            e();
        }
        return a.getPoolSize();
    }

    static {
        Covode.recordClassIndex(653098);
        b = new ArrayDeque();
        c = new ArrayDeque();
    }

    private static void b() {
        if (b.size() > 0) {
            Iterator<a> it2 = b.iterator();
            if (it2.hasNext()) {
                a next = it2.next();
                it2.remove();
                c.add(next);
                a.execute(next);
            }
        }
    }

    public static ThreadPoolExecutor e() {
        if (a == null) {
            synchronized (c.class) {
                if (a == null) {
                    a = new PThreadPoolExecutorDelegate(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), new DefaultThreadFactory("iveThreadPool"));
                }
            }
        }
        return a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void a(a aVar) {
        synchronized (c.class) {
            c.remove(aVar);
            b();
        }
    }

    public static synchronized Future d(Runnable runnable) {
        synchronized (c.class) {
            if (runnable == null) {
                return null;
            }
            if (a == null) {
                e();
            }
            com.ss.videoarch.liveplayer.log.a.a("LiveThreadPool", "addExecuteTask,cur thread num:" + f());
            a aVar = new a(runnable);
            if (c.size() >= 5) {
                b.add(aVar);
                return null;
            }
            c.add(aVar);
            return a.submit(aVar);
        }
    }
}
