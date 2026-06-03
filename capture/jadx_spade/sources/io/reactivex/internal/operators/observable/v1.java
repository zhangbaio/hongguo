package io.reactivex.internal.operators.observable;

import com.bytedance.covode.number.Covode;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.subjects.UnicastSubject;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class v1<T> extends io.reactivex.internal.operators.observable.a<T, Observable<T>> {
    final long a;
    final long b;
    final TimeUnit c;
    final Scheduler d;
    final long e;
    final int f;
    final boolean g;

    static {
        Covode.recordClassIndex(657461);
    }

    static final class a<T> extends io.reactivex.internal.observers.j<T, Object, Observable<T>> implements Disposable {
        final long g;
        final TimeUnit h;
        final Scheduler i;
        final int j;
        final boolean k;
        final long l;
        final Scheduler.Worker m;
        long n;
        long o;
        Disposable p;
        UnicastSubject<T> q;
        volatile boolean r;
        final AtomicReference<Disposable> s;

        static {
            Covode.recordClassIndex(657462);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.d = true;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.d;
        }

        void l() {
            DisposableHelper.dispose(this.s);
            Scheduler.Worker worker = this.m;
            if (worker != null) {
                worker.dispose();
            }
        }

        /* renamed from: io.reactivex.internal.operators.observable.v1$a$a, reason: collision with other inner class name */
        static final class RunnableC0184a implements Runnable {
            final long a;
            final a<?> b;

            static {
                Covode.recordClassIndex(657463);
            }

            @Override // java.lang.Runnable
            public void run() {
                a<?> aVar = this.b;
                if (!((io.reactivex.internal.observers.j) aVar).d) {
                    ((io.reactivex.internal.observers.j) aVar).c.offer(this);
                } else {
                    aVar.r = true;
                    aVar.l();
                }
                if (aVar.f()) {
                    aVar.m();
                }
            }

            RunnableC0184a(long j, a<?> aVar) {
                this.a = j;
                this.b = aVar;
            }
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.e = true;
            if (f()) {
                m();
            }
            this.b.onComplete();
            l();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v0, types: [io.reactivex.subjects.UnicastSubject<T>] */
        void m() {
            boolean z;
            MpscLinkedQueue mpscLinkedQueue = (MpscLinkedQueue) this.c;
            Observer<? super V> observer = this.b;
            UnicastSubject<T> unicastSubject = this.q;
            int i = 1;
            while (!this.r) {
                boolean z2 = this.e;
                Object poll = mpscLinkedQueue.poll();
                if (poll == null) {
                    z = true;
                } else {
                    z = false;
                }
                boolean z3 = poll instanceof RunnableC0184a;
                if (z2 && (z || z3)) {
                    this.q = null;
                    mpscLinkedQueue.clear();
                    l();
                    Throwable th = this.f;
                    if (th != null) {
                        unicastSubject.onError(th);
                        return;
                    } else {
                        unicastSubject.onComplete();
                        return;
                    }
                }
                if (z) {
                    i = d(-i);
                    if (i == 0) {
                        return;
                    }
                } else if (z3) {
                    RunnableC0184a runnableC0184a = (RunnableC0184a) poll;
                    if (this.k || this.o == runnableC0184a.a) {
                        unicastSubject.onComplete();
                        this.n = 0L;
                        unicastSubject = (UnicastSubject<T>) UnicastSubject.c(this.j);
                        this.q = unicastSubject;
                        observer.onNext(unicastSubject);
                    }
                } else {
                    unicastSubject.onNext(NotificationLite.getValue(poll));
                    long j = this.n + 1;
                    if (j >= this.l) {
                        this.o++;
                        this.n = 0L;
                        unicastSubject.onComplete();
                        unicastSubject = (UnicastSubject<T>) UnicastSubject.c(this.j);
                        this.q = unicastSubject;
                        this.b.onNext(unicastSubject);
                        if (this.k) {
                            Disposable disposable = this.s.get();
                            disposable.dispose();
                            Scheduler.Worker worker = this.m;
                            RunnableC0184a runnableC0184a2 = new RunnableC0184a(this.o, this);
                            long j2 = this.g;
                            Disposable schedulePeriodically = worker.schedulePeriodically(runnableC0184a2, j2, j2, this.h);
                            if (!androidx.compose.animation.core.g1.a(this.s, disposable, schedulePeriodically)) {
                                schedulePeriodically.dispose();
                            }
                        }
                    } else {
                        this.n = j;
                    }
                }
            }
            this.p.dispose();
            mpscLinkedQueue.clear();
            l();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f = th;
            this.e = true;
            if (f()) {
                m();
            }
            this.b.onError(th);
            l();
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            if (this.r) {
                return;
            }
            if (g()) {
                UnicastSubject<T> unicastSubject = this.q;
                unicastSubject.onNext(t);
                long j = this.n + 1;
                if (j >= this.l) {
                    this.o++;
                    this.n = 0L;
                    unicastSubject.onComplete();
                    UnicastSubject<T> c = UnicastSubject.c(this.j);
                    this.q = c;
                    this.b.onNext(c);
                    if (this.k) {
                        this.s.get().dispose();
                        Scheduler.Worker worker = this.m;
                        RunnableC0184a runnableC0184a = new RunnableC0184a(this.o, this);
                        long j2 = this.g;
                        DisposableHelper.replace(this.s, worker.schedulePeriodically(runnableC0184a, j2, j2, this.h));
                    }
                } else {
                    this.n = j;
                }
                if (d(-1) == 0) {
                    return;
                }
            } else {
                this.c.offer(NotificationLite.next(t));
                if (!f()) {
                    return;
                }
            }
            m();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            Disposable schedulePeriodicallyDirect;
            if (DisposableHelper.validate(this.p, disposable)) {
                this.p = disposable;
                Observer<? super V> observer = this.b;
                observer.onSubscribe(this);
                if (this.d) {
                    return;
                }
                UnicastSubject<T> c = UnicastSubject.c(this.j);
                this.q = c;
                observer.onNext(c);
                RunnableC0184a runnableC0184a = new RunnableC0184a(this.o, this);
                if (this.k) {
                    Scheduler.Worker worker = this.m;
                    long j = this.g;
                    schedulePeriodicallyDirect = worker.schedulePeriodically(runnableC0184a, j, j, this.h);
                } else {
                    Scheduler scheduler = this.i;
                    long j2 = this.g;
                    schedulePeriodicallyDirect = scheduler.schedulePeriodicallyDirect(runnableC0184a, j2, j2, this.h);
                }
                DisposableHelper.replace(this.s, schedulePeriodicallyDirect);
            }
        }

        a(Observer<? super Observable<T>> observer, long j, TimeUnit timeUnit, Scheduler scheduler, int i, long j2, boolean z) {
            super(observer, new MpscLinkedQueue());
            this.s = new AtomicReference<>();
            this.g = j;
            this.h = timeUnit;
            this.i = scheduler;
            this.j = i;
            this.l = j2;
            this.k = z;
            if (z) {
                this.m = scheduler.createWorker();
            } else {
                this.m = null;
            }
        }
    }

    static final class b<T> extends io.reactivex.internal.observers.j<T, Object, Observable<T>> implements Disposable, Runnable {
        static final Object o;
        final long g;
        final TimeUnit h;
        final Scheduler i;
        final int j;
        Disposable k;
        UnicastSubject<T> l;
        final AtomicReference<Disposable> m;
        volatile boolean n;

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.d = true;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.d;
        }

        void j() {
            DisposableHelper.dispose(this.m);
        }

        static {
            Covode.recordClassIndex(657464);
            o = new Object();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.e = true;
            if (f()) {
                k();
            }
            j();
            this.b.onComplete();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.d) {
                this.n = true;
                j();
            }
            this.c.offer(o);
            if (f()) {
                k();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0026, code lost:
        
            r2.onError(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:11:?, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x002a, code lost:
        
            r2.onComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x002d, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:8:0x0019, code lost:
        
            r7.l = null;
            r0.clear();
            j();
            r0 = r7.f;
         */
        /* JADX WARN: Code restructure failed: missing block: B:9:0x0024, code lost:
        
            if (r0 == null) goto L11;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v0, types: [io.reactivex.subjects.UnicastSubject<T>] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        void k() {
            /*
                r7 = this;
                nm6.i<U> r0 = r7.c
                io.reactivex.internal.queue.MpscLinkedQueue r0 = (io.reactivex.internal.queue.MpscLinkedQueue) r0
                io.reactivex.Observer<? super V> r1 = r7.b
                io.reactivex.subjects.UnicastSubject<T> r2 = r7.l
                r3 = 1
            L9:
                boolean r4 = r7.n
                boolean r5 = r7.e
                java.lang.Object r6 = r0.poll()
                if (r5 == 0) goto L2e
                if (r6 == 0) goto L19
                java.lang.Object r5 = io.reactivex.internal.operators.observable.v1.b.o
                if (r6 != r5) goto L2e
            L19:
                r1 = 0
                r7.l = r1
                r0.clear()
                r7.j()
                java.lang.Throwable r0 = r7.f
                if (r0 == 0) goto L2a
                r2.onError(r0)
                goto L2d
            L2a:
                r2.onComplete()
            L2d:
                return
            L2e:
                if (r6 != 0) goto L38
                int r3 = -r3
                int r3 = r7.d(r3)
                if (r3 != 0) goto L9
                return
            L38:
                java.lang.Object r5 = io.reactivex.internal.operators.observable.v1.b.o
                if (r6 != r5) goto L53
                r2.onComplete()
                if (r4 != 0) goto L4d
                int r2 = r7.j
                io.reactivex.subjects.UnicastSubject r2 = io.reactivex.subjects.UnicastSubject.c(r2)
                r7.l = r2
                r1.onNext(r2)
                goto L9
            L4d:
                io.reactivex.disposables.Disposable r4 = r7.k
                r4.dispose()
                goto L9
            L53:
                java.lang.Object r4 = io.reactivex.internal.util.NotificationLite.getValue(r6)
                r2.onNext(r4)
                goto L9
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.v1.b.k():void");
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f = th;
            this.e = true;
            if (f()) {
                k();
            }
            j();
            this.b.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            if (this.n) {
                return;
            }
            if (g()) {
                this.l.onNext(t);
                if (d(-1) == 0) {
                    return;
                }
            } else {
                this.c.offer(NotificationLite.next(t));
                if (!f()) {
                    return;
                }
            }
            k();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.k, disposable)) {
                this.k = disposable;
                this.l = UnicastSubject.c(this.j);
                Observer<? super V> observer = this.b;
                observer.onSubscribe(this);
                observer.onNext(this.l);
                if (!this.d) {
                    Scheduler scheduler = this.i;
                    long j = this.g;
                    DisposableHelper.replace(this.m, scheduler.schedulePeriodicallyDirect(this, j, j, this.h));
                }
            }
        }

        b(Observer<? super Observable<T>> observer, long j, TimeUnit timeUnit, Scheduler scheduler, int i) {
            super(observer, new MpscLinkedQueue());
            this.m = new AtomicReference<>();
            this.g = j;
            this.h = timeUnit;
            this.i = scheduler;
            this.j = i;
        }
    }

    static final class c<T> extends io.reactivex.internal.observers.j<T, Object, Observable<T>> implements Disposable, Runnable {
        final long g;
        final long h;
        final TimeUnit i;
        final Scheduler.Worker j;
        final int k;
        final List<UnicastSubject<T>> l;
        Disposable m;
        volatile boolean n;

        static {
            Covode.recordClassIndex(657465);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.d = true;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.d;
        }

        final class a implements Runnable {
            private final UnicastSubject<T> a;

            static {
                Covode.recordClassIndex(657466);
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.j(this.a);
            }

            a(UnicastSubject<T> unicastSubject) {
                this.a = unicastSubject;
            }
        }

        void k() {
            this.j.dispose();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.e = true;
            if (f()) {
                l();
            }
            this.b.onComplete();
            k();
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar = new b(UnicastSubject.c(this.k), true);
            if (!this.d) {
                this.c.offer(bVar);
            }
            if (f()) {
                l();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        void l() {
            boolean z;
            MpscLinkedQueue mpscLinkedQueue = (MpscLinkedQueue) this.c;
            Observer<? super V> observer = this.b;
            List<UnicastSubject<T>> list = this.l;
            int i = 1;
            while (!this.n) {
                boolean z2 = this.e;
                Object poll = mpscLinkedQueue.poll();
                if (poll == null) {
                    z = true;
                } else {
                    z = false;
                }
                boolean z3 = poll instanceof b;
                if (z2 && (z || z3)) {
                    mpscLinkedQueue.clear();
                    Throwable th = this.f;
                    if (th != null) {
                        Iterator<UnicastSubject<T>> it2 = list.iterator();
                        while (it2.hasNext()) {
                            it2.next().onError(th);
                        }
                    } else {
                        Iterator<UnicastSubject<T>> it4 = list.iterator();
                        while (it4.hasNext()) {
                            it4.next().onComplete();
                        }
                    }
                    k();
                    list.clear();
                    return;
                }
                if (z) {
                    i = d(-i);
                    if (i == 0) {
                        return;
                    }
                } else if (z3) {
                    b bVar = (b) poll;
                    if (bVar.b) {
                        if (!this.d) {
                            UnicastSubject<T> c = UnicastSubject.c(this.k);
                            list.add(c);
                            observer.onNext(c);
                            this.j.schedule(new a(c), this.g, this.i);
                        }
                    } else {
                        list.remove(bVar.a);
                        bVar.a.onComplete();
                        if (list.isEmpty() && this.d) {
                            this.n = true;
                        }
                    }
                } else {
                    Iterator<UnicastSubject<T>> it5 = list.iterator();
                    while (it5.hasNext()) {
                        it5.next().onNext(poll);
                    }
                }
            }
            this.m.dispose();
            k();
            mpscLinkedQueue.clear();
            list.clear();
        }

        void j(UnicastSubject<T> unicastSubject) {
            this.c.offer(new b(unicastSubject, false));
            if (f()) {
                l();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f = th;
            this.e = true;
            if (f()) {
                l();
            }
            this.b.onError(th);
            k();
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            if (g()) {
                Iterator<UnicastSubject<T>> it2 = this.l.iterator();
                while (it2.hasNext()) {
                    it2.next().onNext(t);
                }
                if (d(-1) == 0) {
                    return;
                }
            } else {
                this.c.offer(t);
                if (!f()) {
                    return;
                }
            }
            l();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.m, disposable)) {
                this.m = disposable;
                this.b.onSubscribe(this);
                if (this.d) {
                    return;
                }
                UnicastSubject<T> c = UnicastSubject.c(this.k);
                this.l.add(c);
                this.b.onNext(c);
                this.j.schedule(new a(c), this.g, this.i);
                Scheduler.Worker worker = this.j;
                long j = this.h;
                worker.schedulePeriodically(this, j, j, this.i);
            }
        }

        static final class b<T> {
            final UnicastSubject<T> a;
            final boolean b;

            static {
                Covode.recordClassIndex(657467);
            }

            b(UnicastSubject<T> unicastSubject, boolean z) {
                this.a = unicastSubject;
                this.b = z;
            }
        }

        c(Observer<? super Observable<T>> observer, long j, long j2, TimeUnit timeUnit, Scheduler.Worker worker, int i) {
            super(observer, new MpscLinkedQueue());
            this.g = j;
            this.h = j2;
            this.i = timeUnit;
            this.j = worker;
            this.k = i;
            this.l = new LinkedList();
        }
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super Observable<T>> observer) {
        io.reactivex.observers.d dVar = new io.reactivex.observers.d(observer);
        if (this.a == this.b) {
            if (this.e == Long.MAX_VALUE) {
                this.source.subscribe(new b(dVar, this.a, this.c, this.d, this.f));
                return;
            } else {
                this.source.subscribe(new a(dVar, this.a, this.c, this.d, this.f, this.e, this.g));
                return;
            }
        }
        this.source.subscribe(new c(dVar, this.a, this.b, this.c, this.d.createWorker(), this.f));
    }

    public v1(ObservableSource<T> observableSource, long j, long j2, TimeUnit timeUnit, Scheduler scheduler, long j3, int i, boolean z) {
        super(observableSource);
        this.a = j;
        this.b = j2;
        this.c = timeUnit;
        this.d = scheduler;
        this.e = j3;
        this.f = i;
        this.g = z;
    }
}
