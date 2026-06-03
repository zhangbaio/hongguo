package com.ttnet.org.chromium.base.task;

import android.os.Process;
import com.bytedance.covode.number.Covode;
import com.ss.android.ugc.bytex.taskmonitor.proxy.PThreadPoolExecutorDelegate;
import com.ttnet.org.chromium.base.task.AsyncTask;
import com.ttnet.org.chromium.base.task.e;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
class e extends PThreadPoolExecutorDelegate {
    private static final int a;
    private static final int b;
    private static final int c;
    private static final ThreadFactory d;
    private static final BlockingQueue<Runnable> e;

    class a implements ThreadFactory {
        private final AtomicInteger a = new AtomicInteger(1);

        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void b(Runnable runnable) {
            Process.setThreadPriority(10);
            runnable.run();
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(final Runnable runnable) {
            return new Thread(new Runnable() { // from class: com.ttnet.org.chromium.base.task.d
                @Override // java.lang.Runnable
                public final void run() {
                    e.a.b(runnable);
                }
            }, "CrAsyncTask #" + this.a.getAndIncrement());
        }
    }

    e() {
        this(b, c, 30L, TimeUnit.SECONDS, e, d);
    }

    static {
        Covode.recordClassIndex(654399);
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        a = availableProcessors;
        b = Math.max(2, Math.min(availableProcessors - 1, 4));
        c = (availableProcessors * 2) + 1;
        d = new a();
        e = new ArrayBlockingQueue(128);
    }

    private Map<String, Integer> c() {
        int i;
        HashMap hashMap = new HashMap();
        for (Runnable runnable : (Runnable[]) getQueue().toArray(new Runnable[0])) {
            String b2 = b(runnable);
            if (hashMap.containsKey(b2)) {
                i = ((Integer) hashMap.get(b2)).intValue();
            } else {
                i = 0;
            }
            hashMap.put(b2, Integer.valueOf(i + 1));
        }
        return hashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void execute(Runnable runnable) {
        try {
            super/*java.util.concurrent.ThreadPoolExecutor*/.execute(runnable);
        } catch (RejectedExecutionException e2) {
            throw new RejectedExecutionException("Prominent classes in AsyncTask: " + a(c()), e2);
        }
    }

    private String a(Map<String, Integer> map) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue().intValue() > 32) {
                sb.append(entry.getKey());
                sb.append(' ');
            }
        }
        if (sb.length() == 0) {
            return "NO CLASSES FOUND";
        }
        return sb.toString();
    }

    private static String b(Runnable runnable) {
        Class cls;
        Class cls2 = runnable.getClass();
        try {
        } catch (IllegalAccessException e2) {
            if (xj6.a.a) {
                throw new RuntimeException(e2);
            }
        } catch (NoSuchFieldException e3) {
            if (xj6.a.a) {
                throw new RuntimeException(e3);
            }
        }
        if (cls2 == AsyncTask.a.class) {
            cls = ((AsyncTask.a) runnable).a();
        } else {
            if (cls2.getEnclosingClass() == android.os.AsyncTask.class) {
                Field declaredField = cls2.getDeclaredField("this$0");
                declaredField.setAccessible(true);
                cls = declaredField.get(runnable).getClass();
            }
            return cls2.getName();
        }
        cls2 = cls;
        return cls2.getName();
    }

    e(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
        super(i, i2, j, timeUnit, blockingQueue, threadFactory);
        allowCoreThreadTimeOut(true);
    }
}
