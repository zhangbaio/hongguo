package io.reactivex.internal.schedulers;

import androidx.compose.animation.core.g1;
import com.bytedance.covode.number.Covode;
import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.schedulers.i;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class a extends Scheduler implements i {
    static final b c;
    static final RxThreadFactory d;
    static final int e;
    static final c f;
    final ThreadFactory a;
    final AtomicReference<b> b;

    static int b(int i, int i2) {
        return (i2 <= 0 || i2 > i) ? i : i2;
    }

    /* renamed from: io.reactivex.internal.schedulers.a$a, reason: collision with other inner class name */
    static final class C0191a extends Scheduler.Worker {
        private final mm6.b a;
        private final CompositeDisposable b;
        private final mm6.b c;
        private final c d;
        volatile boolean e;

        static {
            Covode.recordClassIndex(657639);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.e;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (!this.e) {
                this.e = true;
                this.c.dispose();
            }
        }

        @Override // io.reactivex.Scheduler.Worker
        public Disposable schedule(Runnable runnable) {
            if (this.e) {
                return EmptyDisposable.INSTANCE;
            }
            return this.d.a(runnable, 0L, TimeUnit.MILLISECONDS, this.a);
        }

        C0191a(c cVar) {
            this.d = cVar;
            mm6.b bVar = new mm6.b();
            this.a = bVar;
            CompositeDisposable compositeDisposable = new CompositeDisposable();
            this.b = compositeDisposable;
            mm6.b bVar2 = new mm6.b();
            this.c = bVar2;
            bVar2.add(bVar);
            bVar2.add(compositeDisposable);
        }

        @Override // io.reactivex.Scheduler.Worker
        public Disposable schedule(Runnable runnable, long j, TimeUnit timeUnit) {
            if (this.e) {
                return EmptyDisposable.INSTANCE;
            }
            return this.d.a(runnable, j, timeUnit, this.b);
        }
    }

    public a() {
        this(d);
    }

    static final class b implements i {
        final int a;
        final c[] b;
        long c;

        static {
            Covode.recordClassIndex(657640);
        }

        public void c() {
            for (c cVar : this.b) {
                cVar.dispose();
            }
        }

        public c b() {
            int i = this.a;
            if (i == 0) {
                return a.f;
            }
            c[] cVarArr = this.b;
            long j = this.c;
            this.c = 1 + j;
            return cVarArr[(int) (j % i)];
        }

        b(int i, ThreadFactory threadFactory) {
            this.a = i;
            this.b = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.b[i2] = new c(threadFactory);
            }
        }

        @Override // io.reactivex.internal.schedulers.i
        public void a(int i, i.a aVar) {
            int i2 = this.a;
            if (i2 == 0) {
                for (int i3 = 0; i3 < i; i3++) {
                    aVar.a(i3, a.f);
                }
                return;
            }
            int i4 = ((int) this.c) % i2;
            for (int i5 = 0; i5 < i; i5++) {
                aVar.a(i5, new C0191a(this.b[i4]));
                i4++;
                if (i4 == i2) {
                    i4 = 0;
                }
            }
            this.c = i4;
        }
    }

    @Override // io.reactivex.Scheduler
    public Scheduler.Worker createWorker() {
        return new C0191a(this.b.get().b());
    }

    @Override // io.reactivex.Scheduler
    public void shutdown() {
        b bVar;
        b bVar2;
        do {
            bVar = this.b.get();
            bVar2 = c;
            if (bVar == bVar2) {
                return;
            }
        } while (!g1.a(this.b, bVar, bVar2));
        bVar.c();
    }

    @Override // io.reactivex.Scheduler
    public void start() {
        b bVar = new b(e, this.a);
        if (!g1.a(this.b, c, bVar)) {
            bVar.c();
        }
    }

    static {
        Covode.recordClassIndex(657638);
        e = b(Runtime.getRuntime().availableProcessors(), Integer.getInteger("rx2.computation-threads", 0).intValue());
        c cVar = new c(new RxThreadFactory("RxComputationShutdown"));
        f = cVar;
        cVar.dispose();
        RxThreadFactory rxThreadFactory = new RxThreadFactory("RxComputationThreadPool", Math.max(1, Math.min(10, Integer.getInteger("rx2.computation-priority", 5).intValue())), true);
        d = rxThreadFactory;
        b bVar = new b(0, rxThreadFactory);
        c = bVar;
        bVar.c();
    }

    static final class c extends g {
        static {
            Covode.recordClassIndex(657641);
        }

        c(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }

    public a(ThreadFactory threadFactory) {
        this.a = threadFactory;
        this.b = new AtomicReference<>(c);
        start();
    }

    @Override // io.reactivex.internal.schedulers.i
    public void a(int i, i.a aVar) {
        ObjectHelper.verifyPositive(i, "number > 0 required");
        this.b.get().a(i, aVar);
    }

    @Override // io.reactivex.Scheduler
    public Disposable scheduleDirect(Runnable runnable, long j, TimeUnit timeUnit) {
        return this.b.get().b().b(runnable, j, timeUnit);
    }

    @Override // io.reactivex.Scheduler
    public Disposable schedulePeriodicallyDirect(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return this.b.get().b().c(runnable, j, j2, timeUnit);
    }
}
