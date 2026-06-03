package io.reactivex;

import com.bytedance.covode.number.Covode;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.schedulers.SchedulerWhen;
import io.reactivex.internal.schedulers.g;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class Scheduler {
    static final long CLOCK_DRIFT_TOLERANCE_NANOSECONDS;

    public abstract Worker createWorker();

    public void shutdown() {
    }

    public void start() {
    }

    static final class b implements Disposable, Runnable {
        final Runnable a;
        final Worker b;
        volatile boolean c;

        static {
            Covode.recordClassIndex(656234);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.c;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.c = true;
            this.b.dispose();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.c) {
                try {
                    this.a.run();
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.b.dispose();
                    throw ExceptionHelper.wrapOrThrow(th);
                }
            }
        }

        b(Runnable runnable, Worker worker) {
            this.a = runnable;
            this.b = worker;
        }
    }

    public static long clockDriftTolerance() {
        return CLOCK_DRIFT_TOLERANCE_NANOSECONDS;
    }

    static final class a implements Disposable, Runnable {
        final Runnable a;
        final Worker b;
        Thread c;

        static {
            Covode.recordClassIndex(656233);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.b.isDisposed();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.c == Thread.currentThread()) {
                Worker worker = this.b;
                if (worker instanceof g) {
                    ((g) worker).d();
                    return;
                }
            }
            this.b.dispose();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.c = Thread.currentThread();
            try {
                this.a.run();
            } finally {
                dispose();
                this.c = null;
            }
        }

        a(Runnable runnable, Worker worker) {
            this.a = runnable;
            this.b = worker;
        }
    }

    static {
        Covode.recordClassIndex(656232);
        CLOCK_DRIFT_TOLERANCE_NANOSECONDS = TimeUnit.MINUTES.toNanos(Long.getLong("rx2.scheduler.drift-tolerance", 15L).longValue());
    }

    public static abstract class Worker implements Disposable {
        static {
            Covode.recordClassIndex(656235);
        }

        public abstract Disposable schedule(Runnable runnable, long j, TimeUnit timeUnit);

        final class a implements Runnable {
            final Runnable a;
            final SequentialDisposable b;
            final long c;
            long d;
            long e;
            long f;

            static {
                Covode.recordClassIndex(656236);
            }

            @Override // java.lang.Runnable
            public void run() {
                long j;
                this.a.run();
                if (!this.b.isDisposed()) {
                    Worker worker = Worker.this;
                    TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                    long now = worker.now(timeUnit);
                    long j2 = Scheduler.CLOCK_DRIFT_TOLERANCE_NANOSECONDS;
                    long j3 = now + j2;
                    long j4 = this.e;
                    if (j3 >= j4) {
                        long j5 = this.c;
                        if (now < j4 + j5 + j2) {
                            long j6 = this.f;
                            long j7 = this.d + 1;
                            this.d = j7;
                            j = j6 + (j7 * j5);
                            this.e = now;
                            this.b.replace(Worker.this.schedule(this, j - now, timeUnit));
                        }
                    }
                    long j8 = this.c;
                    long j9 = now + j8;
                    long j10 = this.d + 1;
                    this.d = j10;
                    this.f = j9 - (j8 * j10);
                    j = j9;
                    this.e = now;
                    this.b.replace(Worker.this.schedule(this, j - now, timeUnit));
                }
            }

            a(long j, Runnable runnable, long j2, SequentialDisposable sequentialDisposable, long j3) {
                this.a = runnable;
                this.b = sequentialDisposable;
                this.c = j3;
                this.e = j2;
                this.f = j;
            }
        }

        public long now(TimeUnit timeUnit) {
            return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        public Disposable schedule(Runnable runnable) {
            return schedule(runnable, 0L, TimeUnit.NANOSECONDS);
        }

        public Disposable schedulePeriodically(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
            SequentialDisposable sequentialDisposable = new SequentialDisposable();
            SequentialDisposable sequentialDisposable2 = new SequentialDisposable(sequentialDisposable);
            Runnable onSchedule = RxJavaPlugins.onSchedule(runnable);
            long nanos = timeUnit.toNanos(j2);
            long now = now(TimeUnit.NANOSECONDS);
            Disposable schedule = schedule(new a(now + timeUnit.toNanos(j), onSchedule, now, sequentialDisposable2, nanos), j, timeUnit);
            if (schedule == EmptyDisposable.INSTANCE) {
                return schedule;
            }
            sequentialDisposable.replace(schedule);
            return sequentialDisposable2;
        }
    }

    public <S extends Scheduler & Disposable> S when(Function<Flowable<Flowable<Completable>>, Completable> function) {
        return new SchedulerWhen(function, this);
    }

    public long now(TimeUnit timeUnit) {
        return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    public Disposable scheduleDirect(Runnable runnable) {
        return scheduleDirect(runnable, 0L, TimeUnit.NANOSECONDS);
    }

    public Disposable scheduleDirect(Runnable runnable, long j, TimeUnit timeUnit) {
        Worker createWorker = createWorker();
        a aVar = new a(RxJavaPlugins.onSchedule(runnable), createWorker);
        createWorker.schedule(aVar, j, timeUnit);
        return aVar;
    }

    public Disposable schedulePeriodicallyDirect(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        Worker createWorker = createWorker();
        b bVar = new b(RxJavaPlugins.onSchedule(runnable), createWorker);
        Disposable schedulePeriodically = createWorker.schedulePeriodically(bVar, j, j2, timeUnit);
        if (schedulePeriodically == EmptyDisposable.INSTANCE) {
            return schedulePeriodically;
        }
        return bVar;
    }
}
