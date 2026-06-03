package io.reactivex.internal.schedulers;

import androidx.compose.animation.core.g1;
import com.bytedance.covode.number.Covode;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class e extends Scheduler {
    static final RxThreadFactory c;
    static final RxThreadFactory d;
    private static final long e;
    private static final TimeUnit f;
    static final c g;
    static final a h;
    final ThreadFactory a;
    final AtomicReference<a> b;

    static final class a implements Runnable {
        private final long a;
        private final ConcurrentLinkedQueue<c> b;
        final CompositeDisposable c;
        private final ScheduledExecutorService d;
        private final Future<?> e;
        private final ThreadFactory f;

        static {
            Covode.recordClassIndex(657654);
        }

        @Override // java.lang.Runnable
        public void run() {
            a();
        }

        long c() {
            return System.nanoTime();
        }

        void e() {
            this.c.dispose();
            Future<?> future = this.e;
            if (future != null) {
                future.cancel(true);
            }
            ScheduledExecutorService scheduledExecutorService = this.d;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdownNow();
            }
        }

        void a() {
            if (!this.b.isEmpty()) {
                long c = c();
                Iterator<c> it2 = this.b.iterator();
                while (it2.hasNext()) {
                    c next = it2.next();
                    if (next.c <= c) {
                        if (this.b.remove(next)) {
                            this.c.remove(next);
                        }
                    } else {
                        return;
                    }
                }
            }
        }

        c b() {
            if (this.c.isDisposed()) {
                return e.g;
            }
            while (!this.b.isEmpty()) {
                c poll = this.b.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.f);
            this.c.add(cVar);
            return cVar;
        }

        void d(c cVar) {
            cVar.c = c() + this.a;
            this.b.offer(cVar);
        }

        a(long j, TimeUnit timeUnit, ThreadFactory threadFactory) {
            long j2;
            ScheduledExecutorService scheduledExecutorService;
            ScheduledFuture<?> scheduledFuture;
            if (timeUnit != null) {
                j2 = timeUnit.toNanos(j);
            } else {
                j2 = 0;
            }
            long j3 = j2;
            this.a = j3;
            this.b = new ConcurrentLinkedQueue<>();
            this.c = new CompositeDisposable();
            this.f = threadFactory;
            if (timeUnit != null) {
                scheduledExecutorService = PThreadExecutorsUtils.newScheduledThreadPool(1, e.d);
                scheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(this, j3, j3, TimeUnit.NANOSECONDS);
            } else {
                scheduledExecutorService = null;
                scheduledFuture = null;
            }
            this.d = scheduledExecutorService;
            this.e = scheduledFuture;
        }
    }

    static final class b extends Scheduler.Worker {
        private final a b;
        private final c c;
        final AtomicBoolean d = new AtomicBoolean();
        private final CompositeDisposable a = new CompositeDisposable();

        static {
            Covode.recordClassIndex(657655);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.d.get();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.d.compareAndSet(false, true)) {
                this.a.dispose();
                this.b.d(this.c);
            }
        }

        b(a aVar) {
            this.b = aVar;
            this.c = aVar.b();
        }

        @Override // io.reactivex.Scheduler.Worker
        public Disposable schedule(Runnable runnable, long j, TimeUnit timeUnit) {
            if (this.a.isDisposed()) {
                return EmptyDisposable.INSTANCE;
            }
            return this.c.a(runnable, j, timeUnit, this.a);
        }
    }

    public e() {
        this(c);
    }

    @Override // io.reactivex.Scheduler
    public Scheduler.Worker createWorker() {
        return new b(this.b.get());
    }

    @Override // io.reactivex.Scheduler
    public void shutdown() {
        a aVar;
        a aVar2;
        do {
            aVar = this.b.get();
            aVar2 = h;
            if (aVar == aVar2) {
                return;
            }
        } while (!g1.a(this.b, aVar, aVar2));
        aVar.e();
    }

    @Override // io.reactivex.Scheduler
    public void start() {
        a aVar = new a(e, f, this.a);
        if (!g1.a(this.b, h, aVar)) {
            aVar.e();
        }
    }

    static {
        Covode.recordClassIndex(657653);
        f = TimeUnit.SECONDS;
        e = Long.getLong("rx2.io-keep-alive-time", 60L).longValue();
        c cVar = new c(new RxThreadFactory("RxCachedThreadSchedulerShutdown"));
        g = cVar;
        cVar.dispose();
        int max = Math.max(1, Math.min(10, Integer.getInteger("rx2.io-priority", 5).intValue()));
        RxThreadFactory rxThreadFactory = new RxThreadFactory("RxCachedThreadScheduler", max);
        c = rxThreadFactory;
        d = new RxThreadFactory("RxCachedWorkerPoolEvictor", max);
        a aVar = new a(0L, null, rxThreadFactory);
        h = aVar;
        aVar.e();
    }

    static final class c extends g {
        public long c;

        static {
            Covode.recordClassIndex(657656);
        }

        c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.c = 0L;
        }
    }

    public e(ThreadFactory threadFactory) {
        this.a = threadFactory;
        this.b = new AtomicReference<>(h);
        start();
    }
}
