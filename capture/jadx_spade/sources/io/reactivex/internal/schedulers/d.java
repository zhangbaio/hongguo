package io.reactivex.internal.schedulers;

import androidx.compose.animation.core.g1;
import com.bytedance.covode.number.Covode;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.Functions;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class d implements Callable<Void>, Disposable {
    static final FutureTask<Void> f;
    final Runnable a;
    final ExecutorService d;
    Thread e;
    final AtomicReference<Future<?>> c = new AtomicReference<>();
    final AtomicReference<Future<?>> b = new AtomicReference<>();

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        if (this.c.get() == f) {
            return true;
        }
        return false;
    }

    static {
        Covode.recordClassIndex(657652);
        f = new FutureTask<>(Functions.EMPTY_RUNNABLE, null);
    }

    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        this.e = Thread.currentThread();
        try {
            this.a.run();
            b(this.d.submit(this));
            this.e = null;
        } catch (Throwable th) {
            this.e = null;
            RxJavaPlugins.onError(th);
        }
        return null;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        boolean z;
        AtomicReference<Future<?>> atomicReference = this.c;
        FutureTask<Void> futureTask = f;
        Future<?> andSet = atomicReference.getAndSet(futureTask);
        boolean z2 = true;
        if (andSet != null && andSet != futureTask) {
            if (this.e != Thread.currentThread()) {
                z = true;
            } else {
                z = false;
            }
            andSet.cancel(z);
        }
        Future<?> andSet2 = this.b.getAndSet(futureTask);
        if (andSet2 != null && andSet2 != futureTask) {
            if (this.e == Thread.currentThread()) {
                z2 = false;
            }
            andSet2.cancel(z2);
        }
    }

    void a(Future<?> future) {
        Future<?> future2;
        boolean z;
        do {
            future2 = this.c.get();
            if (future2 == f) {
                if (this.e != Thread.currentThread()) {
                    z = true;
                } else {
                    z = false;
                }
                future.cancel(z);
                return;
            }
        } while (!g1.a(this.c, future2, future));
    }

    void b(Future<?> future) {
        Future<?> future2;
        boolean z;
        do {
            future2 = this.b.get();
            if (future2 == f) {
                if (this.e != Thread.currentThread()) {
                    z = true;
                } else {
                    z = false;
                }
                future.cancel(z);
                return;
            }
        } while (!g1.a(this.b, future2, future));
    }

    d(Runnable runnable, ExecutorService executorService) {
        this.a = runnable;
        this.d = executorService;
    }
}
