package com.ttnet.org.chromium.base.task;

import com.bytedance.covode.number.Covode;
import com.ttnet.org.chromium.base.TraceEvent;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class AsyncTask<Result> {
    public static final Executor a;
    public static final Executor b;
    private static final b c;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Status {
    }

    class a extends FutureTask<Result> {
        static {
            Covode.recordClassIndex(654393);
        }

        Class a() {
            throw null;
        }

        @Override // java.util.concurrent.FutureTask
        protected void done() {
            try {
                AsyncTask.f(null, get());
            } catch (InterruptedException e) {
                com.ttnet.org.chromium.base.h.m("AsyncTask", e.toString(), new Object[0]);
            } catch (CancellationException unused) {
                AsyncTask.f(null, null);
            } catch (ExecutionException e2) {
                throw new RuntimeException("An error occurred while executing doInBackground()", e2.getCause());
            }
        }

        @Override // java.util.concurrent.FutureTask, java.util.concurrent.RunnableFuture, java.lang.Runnable
        public void run() {
            TraceEvent k = TraceEvent.k("AsyncTask.run: " + AsyncTask.e(null).a().getName());
            try {
                super.run();
                if (k != null) {
                    k.close();
                }
            } catch (Throwable th) {
                if (k != null) {
                    try {
                        k.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
    }

    static {
        Covode.recordClassIndex(654392);
        a = new Executor() { // from class: com.ttnet.org.chromium.base.task.a
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                AsyncTask.g(runnable);
            }
        };
        b = new i();
        c = new b(null);
    }

    static /* synthetic */ AtomicBoolean b(AsyncTask asyncTask) {
        throw null;
    }

    static /* synthetic */ AtomicBoolean c(AsyncTask asyncTask) {
        throw null;
    }

    static /* synthetic */ a e(AsyncTask asyncTask) {
        throw null;
    }

    private static class b implements RejectedExecutionHandler {
        static {
            Covode.recordClassIndex(654395);
        }

        private b() {
        }

        /* synthetic */ b(com.ttnet.org.chromium.base.task.b bVar) {
            this();
        }

        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            AsyncTask.a.execute(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void g(Runnable runnable) {
        PostTask.e(o.h, runnable);
    }

    static /* synthetic */ void d(AsyncTask asyncTask, Object obj) {
        throw null;
    }

    static /* synthetic */ void f(AsyncTask asyncTask, Object obj) {
        throw null;
    }
}
