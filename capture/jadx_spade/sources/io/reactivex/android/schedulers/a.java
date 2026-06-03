package io.reactivex.android.schedulers;

import android.os.Handler;
import android.os.Message;
import com.bytedance.covode.number.Covode;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class a extends Scheduler {
    private final Handler a;
    private final boolean b;

    static {
        Covode.recordClassIndex(656249);
    }

    /* renamed from: io.reactivex.android.schedulers.a$a, reason: collision with other inner class name */
    private static final class C0174a extends Scheduler.Worker {
        private final Handler a;
        private final boolean b;
        private volatile boolean c;

        static {
            Covode.recordClassIndex(656250);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.c;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.c = true;
            this.a.removeCallbacksAndMessages(this);
        }

        C0174a(Handler handler, boolean z) {
            this.a = handler;
            this.b = z;
        }

        @Override // io.reactivex.Scheduler.Worker
        public Disposable schedule(Runnable runnable, long j, TimeUnit timeUnit) {
            if (runnable != null) {
                if (timeUnit != null) {
                    if (this.c) {
                        return Disposables.disposed();
                    }
                    b bVar = new b(this.a, RxJavaPlugins.onSchedule(runnable));
                    Message obtain = Message.obtain(this.a, bVar);
                    obtain.obj = this;
                    if (this.b) {
                        obtain.setAsynchronous(true);
                    }
                    this.a.sendMessageDelayed(obtain, timeUnit.toMillis(j));
                    if (this.c) {
                        this.a.removeCallbacks(bVar);
                        return Disposables.disposed();
                    }
                    return bVar;
                }
                throw new NullPointerException("unit == null");
            }
            throw new NullPointerException("run == null");
        }
    }

    private static final class b implements Runnable, Disposable {
        private final Handler a;
        private final Runnable b;
        private volatile boolean c;

        static {
            Covode.recordClassIndex(656251);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.c;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.a.removeCallbacks(this);
            this.c = true;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.b.run();
            } catch (Throwable th) {
                RxJavaPlugins.onError(th);
            }
        }

        b(Handler handler, Runnable runnable) {
            this.a = handler;
            this.b = runnable;
        }
    }

    @Override // io.reactivex.Scheduler
    public Scheduler.Worker createWorker() {
        return new C0174a(this.a, this.b);
    }

    a(Handler handler, boolean z) {
        this.a = handler;
        this.b = z;
    }

    @Override // io.reactivex.Scheduler
    public Disposable scheduleDirect(Runnable runnable, long j, TimeUnit timeUnit) {
        if (runnable != null) {
            if (timeUnit != null) {
                b bVar = new b(this.a, RxJavaPlugins.onSchedule(runnable));
                this.a.postDelayed(bVar, timeUnit.toMillis(j));
                return bVar;
            }
            throw new NullPointerException("unit == null");
        }
        throw new NullPointerException("run == null");
    }
}
