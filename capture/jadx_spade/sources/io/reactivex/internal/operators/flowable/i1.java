package io.reactivex.internal.operators.flowable;

import com.bytedance.covode.number.Covode;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.processors.UnicastProcessor;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class i1<T> extends io.reactivex.internal.operators.flowable.a<T, Flowable<T>> {
    final long b;
    final long c;
    final TimeUnit d;
    final Scheduler e;
    final long f;
    final int g;
    final boolean h;

    static {
        Covode.recordClassIndex(656882);
    }

    static final class c<T> extends io.reactivex.internal.subscribers.h<T, Object, Flowable<T>> implements Subscription, Runnable {
        final long h;
        final long i;
        final TimeUnit j;
        final Scheduler.Worker k;
        final int l;
        final List<UnicastProcessor<T>> m;
        Subscription n;
        volatile boolean o;

        static {
            Covode.recordClassIndex(656886);
        }

        public void cancel() {
            this.e = true;
        }

        final class a implements Runnable {
            private final UnicastProcessor<T> a;

            static {
                Covode.recordClassIndex(656887);
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.l(this.a);
            }

            a(UnicastProcessor<T> unicastProcessor) {
                this.a = unicastProcessor;
            }
        }

        public void dispose() {
            this.k.dispose();
        }

        public void onComplete() {
            this.f = true;
            if (g()) {
                m();
            }
            this.c.onComplete();
            dispose();
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar = new b(UnicastProcessor.d(this.l), true);
            if (!this.e) {
                this.d.offer(bVar);
            }
            if (g()) {
                m();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        void m() {
            boolean z;
            nm6.j jVar = this.d;
            Subscriber<? super V> subscriber = this.c;
            List<UnicastProcessor<T>> list = this.m;
            int i = 1;
            while (!this.o) {
                boolean z2 = this.f;
                Object poll = jVar.poll();
                if (poll == null) {
                    z = true;
                } else {
                    z = false;
                }
                boolean z3 = poll instanceof b;
                if (z2 && (z || z3)) {
                    jVar.clear();
                    Throwable th = this.g;
                    if (th != null) {
                        Iterator<UnicastProcessor<T>> it2 = list.iterator();
                        while (it2.hasNext()) {
                            it2.next().onError(th);
                        }
                    } else {
                        Iterator<UnicastProcessor<T>> it4 = list.iterator();
                        while (it4.hasNext()) {
                            it4.next().onComplete();
                        }
                    }
                    list.clear();
                    dispose();
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
                        if (!this.e) {
                            long requested = requested();
                            if (requested != 0) {
                                UnicastProcessor<T> d = UnicastProcessor.d(this.l);
                                list.add(d);
                                subscriber.onNext(d);
                                if (requested != Long.MAX_VALUE) {
                                    e(1L);
                                }
                                this.k.schedule(new a(d), this.h, this.j);
                            } else {
                                subscriber.onError(new MissingBackpressureException("Can't emit window due to lack of requests"));
                            }
                        }
                    } else {
                        list.remove(bVar.a);
                        bVar.a.onComplete();
                        if (list.isEmpty() && this.e) {
                            this.o = true;
                        }
                    }
                } else {
                    Iterator<UnicastProcessor<T>> it5 = list.iterator();
                    while (it5.hasNext()) {
                        it5.next().onNext(poll);
                    }
                }
            }
            this.n.cancel();
            dispose();
            jVar.clear();
            list.clear();
        }

        public void request(long j) {
            k(j);
        }

        void l(UnicastProcessor<T> unicastProcessor) {
            this.d.offer(new b(unicastProcessor, false));
            if (g()) {
                m();
            }
        }

        public void onError(Throwable th) {
            this.g = th;
            this.f = true;
            if (g()) {
                m();
            }
            this.c.onError(th);
            dispose();
        }

        public void onNext(T t) {
            if (h()) {
                Iterator<UnicastProcessor<T>> it2 = this.m.iterator();
                while (it2.hasNext()) {
                    it2.next().onNext(t);
                }
                if (d(-1) == 0) {
                    return;
                }
            } else {
                this.d.offer(t);
                if (!g()) {
                    return;
                }
            }
            m();
        }

        @Override // io.reactivex.FlowableSubscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.n, subscription)) {
                this.n = subscription;
                this.c.onSubscribe(this);
                if (this.e) {
                    return;
                }
                long requested = requested();
                if (requested != 0) {
                    UnicastProcessor<T> d = UnicastProcessor.d(this.l);
                    this.m.add(d);
                    this.c.onNext(d);
                    if (requested != Long.MAX_VALUE) {
                        e(1L);
                    }
                    this.k.schedule(new a(d), this.h, this.j);
                    Scheduler.Worker worker = this.k;
                    long j = this.i;
                    worker.schedulePeriodically(this, j, j, this.j);
                    subscription.request(Long.MAX_VALUE);
                    return;
                }
                subscription.cancel();
                this.c.onError(new MissingBackpressureException("Could not emit the first window due to lack of requests"));
            }
        }

        static final class b<T> {
            final UnicastProcessor<T> a;
            final boolean b;

            static {
                Covode.recordClassIndex(656888);
            }

            b(UnicastProcessor<T> unicastProcessor, boolean z) {
                this.a = unicastProcessor;
                this.b = z;
            }
        }

        c(Subscriber<? super Flowable<T>> subscriber, long j, long j2, TimeUnit timeUnit, Scheduler.Worker worker, int i) {
            super(subscriber, new MpscLinkedQueue());
            this.h = j;
            this.i = j2;
            this.j = timeUnit;
            this.k = worker;
            this.l = i;
            this.m = new LinkedList();
        }
    }

    static final class b<T> extends io.reactivex.internal.subscribers.h<T, Object, Flowable<T>> implements Subscription, Runnable {
        static final Object p;
        final long h;
        final TimeUnit i;
        final Scheduler j;
        final int k;
        Subscription l;
        UnicastProcessor<T> m;
        final SequentialDisposable n;
        volatile boolean o;

        public void cancel() {
            this.e = true;
        }

        public void dispose() {
            DisposableHelper.dispose(this.n);
        }

        static {
            Covode.recordClassIndex(656885);
            p = new Object();
        }

        public void onComplete() {
            this.f = true;
            if (g()) {
                l();
            }
            this.c.onComplete();
            dispose();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.e) {
                this.o = true;
                dispose();
            }
            this.d.offer(p);
            if (g()) {
                l();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0024, code lost:
        
            r2.onError(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:11:?, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x0028, code lost:
        
            r2.onComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x002b, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:8:0x0018, code lost:
        
            r10.m = null;
            r0.clear();
            dispose();
            r0 = r10.g;
         */
        /* JADX WARN: Code restructure failed: missing block: B:9:0x0022, code lost:
        
            if (r0 == null) goto L11;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        void l() {
            /*
                r10 = this;
                nm6.i<U> r0 = r10.d
                org.reactivestreams.Subscriber<? super V> r1 = r10.c
                io.reactivex.processors.UnicastProcessor<T> r2 = r10.m
                r3 = 1
            L7:
                boolean r4 = r10.o
                boolean r5 = r10.f
                java.lang.Object r6 = r0.poll()
                r7 = 0
                if (r5 == 0) goto L2c
                if (r6 == 0) goto L18
                java.lang.Object r5 = io.reactivex.internal.operators.flowable.i1.b.p
                if (r6 != r5) goto L2c
            L18:
                r10.m = r7
                r0.clear()
                r10.dispose()
                java.lang.Throwable r0 = r10.g
                if (r0 == 0) goto L28
                r2.onError(r0)
                goto L2b
            L28:
                r2.onComplete()
            L2b:
                return
            L2c:
                if (r6 != 0) goto L36
                int r3 = -r3
                int r3 = r10.d(r3)
                if (r3 != 0) goto L7
                return
            L36:
                java.lang.Object r5 = io.reactivex.internal.operators.flowable.i1.b.p
                if (r6 != r5) goto L83
                r2.onComplete()
                if (r4 != 0) goto L7d
                int r2 = r10.k
                io.reactivex.processors.UnicastProcessor r2 = io.reactivex.processors.UnicastProcessor.d(r2)
                r10.m = r2
                long r4 = r10.requested()
                r8 = 0
                int r6 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
                if (r6 == 0) goto L63
                r1.onNext(r2)
                r6 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                if (r8 == 0) goto L7
                r4 = 1
                r10.e(r4)
                goto L7
            L63:
                r10.m = r7
                nm6.i<U> r0 = r10.d
                r0.clear()
                org.reactivestreams.Subscription r0 = r10.l
                r0.cancel()
                r10.dispose()
                io.reactivex.exceptions.MissingBackpressureException r0 = new io.reactivex.exceptions.MissingBackpressureException
                java.lang.String r2 = "Could not deliver first window due to lack of requests."
                r0.<init>(r2)
                r1.onError(r0)
                return
            L7d:
                org.reactivestreams.Subscription r4 = r10.l
                r4.cancel()
                goto L7
            L83:
                java.lang.Object r4 = io.reactivex.internal.util.NotificationLite.getValue(r6)
                r2.onNext(r4)
                goto L7
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.i1.b.l():void");
        }

        public void request(long j) {
            k(j);
        }

        public void onError(Throwable th) {
            this.g = th;
            this.f = true;
            if (g()) {
                l();
            }
            this.c.onError(th);
            dispose();
        }

        public void onNext(T t) {
            if (this.o) {
                return;
            }
            if (h()) {
                this.m.onNext(t);
                if (d(-1) == 0) {
                    return;
                }
            } else {
                this.d.offer(NotificationLite.next(t));
                if (!g()) {
                    return;
                }
            }
            l();
        }

        @Override // io.reactivex.FlowableSubscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.l, subscription)) {
                this.l = subscription;
                this.m = UnicastProcessor.d(this.k);
                Subscriber<? super V> subscriber = this.c;
                subscriber.onSubscribe(this);
                long requested = requested();
                if (requested != 0) {
                    subscriber.onNext(this.m);
                    if (requested != Long.MAX_VALUE) {
                        e(1L);
                    }
                    if (!this.e) {
                        SequentialDisposable sequentialDisposable = this.n;
                        Scheduler scheduler = this.j;
                        long j = this.h;
                        if (sequentialDisposable.replace(scheduler.schedulePeriodicallyDirect(this, j, j, this.i))) {
                            subscription.request(Long.MAX_VALUE);
                            return;
                        }
                        return;
                    }
                    return;
                }
                this.e = true;
                subscription.cancel();
                subscriber.onError(new MissingBackpressureException("Could not deliver first window due to lack of requests."));
            }
        }

        b(Subscriber<? super Flowable<T>> subscriber, long j, TimeUnit timeUnit, Scheduler scheduler, int i) {
            super(subscriber, new MpscLinkedQueue());
            this.n = new SequentialDisposable();
            this.h = j;
            this.i = timeUnit;
            this.j = scheduler;
            this.k = i;
        }
    }

    static final class a<T> extends io.reactivex.internal.subscribers.h<T, Object, Flowable<T>> implements Subscription {
        final long h;
        final TimeUnit i;
        final Scheduler j;
        final int k;
        final boolean l;
        final long m;
        final Scheduler.Worker n;
        long o;
        long p;
        Subscription q;
        UnicastProcessor<T> r;
        volatile boolean s;
        final SequentialDisposable t;

        static {
            Covode.recordClassIndex(656883);
        }

        public void cancel() {
            this.e = true;
        }

        public void dispose() {
            DisposableHelper.dispose(this.t);
            Scheduler.Worker worker = this.n;
            if (worker != null) {
                worker.dispose();
            }
        }

        /* renamed from: io.reactivex.internal.operators.flowable.i1$a$a, reason: collision with other inner class name */
        static final class RunnableC0178a implements Runnable {
            final long a;
            final a<?> b;

            static {
                Covode.recordClassIndex(656884);
            }

            @Override // java.lang.Runnable
            public void run() {
                a<?> aVar = this.b;
                if (!((io.reactivex.internal.subscribers.h) aVar).e) {
                    ((io.reactivex.internal.subscribers.h) aVar).d.offer(this);
                } else {
                    aVar.s = true;
                    aVar.dispose();
                }
                if (aVar.g()) {
                    aVar.n();
                }
            }

            RunnableC0178a(long j, a<?> aVar) {
                this.a = j;
                this.b = aVar;
            }
        }

        public void onComplete() {
            this.f = true;
            if (g()) {
                n();
            }
            this.c.onComplete();
            dispose();
        }

        /* JADX WARN: Multi-variable type inference failed */
        void n() {
            boolean z;
            nm6.j jVar = this.d;
            Subscriber<? super V> subscriber = this.c;
            UnicastProcessor<T> unicastProcessor = this.r;
            int i = 1;
            while (!this.s) {
                boolean z2 = this.f;
                Object poll = jVar.poll();
                if (poll == null) {
                    z = true;
                } else {
                    z = false;
                }
                boolean z3 = poll instanceof RunnableC0178a;
                if (z2 && (z || z3)) {
                    this.r = null;
                    jVar.clear();
                    Throwable th = this.g;
                    if (th != null) {
                        unicastProcessor.onError(th);
                    } else {
                        unicastProcessor.onComplete();
                    }
                    dispose();
                    return;
                }
                if (z) {
                    i = d(-i);
                    if (i == 0) {
                        return;
                    }
                } else {
                    int i2 = i;
                    if (z3) {
                        RunnableC0178a runnableC0178a = (RunnableC0178a) poll;
                        if (this.l || this.p == runnableC0178a.a) {
                            unicastProcessor.onComplete();
                            this.o = 0L;
                            unicastProcessor = (UnicastProcessor<T>) UnicastProcessor.d(this.k);
                            this.r = unicastProcessor;
                            long requested = requested();
                            if (requested != 0) {
                                subscriber.onNext(unicastProcessor);
                                if (requested != Long.MAX_VALUE) {
                                    e(1L);
                                }
                            } else {
                                this.r = null;
                                this.d.clear();
                                this.q.cancel();
                                subscriber.onError(new MissingBackpressureException("Could not deliver first window due to lack of requests."));
                                dispose();
                                return;
                            }
                        }
                    } else {
                        unicastProcessor.onNext(NotificationLite.getValue(poll));
                        long j = this.o + 1;
                        if (j >= this.m) {
                            this.p++;
                            this.o = 0L;
                            unicastProcessor.onComplete();
                            long requested2 = requested();
                            if (requested2 != 0) {
                                UnicastProcessor<T> d = UnicastProcessor.d(this.k);
                                this.r = d;
                                this.c.onNext(d);
                                if (requested2 != Long.MAX_VALUE) {
                                    e(1L);
                                }
                                if (this.l) {
                                    this.t.get().dispose();
                                    Scheduler.Worker worker = this.n;
                                    RunnableC0178a runnableC0178a2 = new RunnableC0178a(this.p, this);
                                    long j2 = this.h;
                                    this.t.replace(worker.schedulePeriodically(runnableC0178a2, j2, j2, this.i));
                                }
                                unicastProcessor = d;
                            } else {
                                this.r = null;
                                this.q.cancel();
                                this.c.onError(new MissingBackpressureException("Could not deliver window due to lack of requests"));
                                dispose();
                                return;
                            }
                        } else {
                            this.o = j;
                        }
                    }
                    i = i2;
                }
            }
            this.q.cancel();
            jVar.clear();
            dispose();
        }

        public void request(long j) {
            k(j);
        }

        public void onError(Throwable th) {
            this.g = th;
            this.f = true;
            if (g()) {
                n();
            }
            this.c.onError(th);
            dispose();
        }

        @Override // io.reactivex.FlowableSubscriber
        public void onSubscribe(Subscription subscription) {
            Disposable schedulePeriodicallyDirect;
            if (SubscriptionHelper.validate(this.q, subscription)) {
                this.q = subscription;
                Subscriber<? super V> subscriber = this.c;
                subscriber.onSubscribe(this);
                if (this.e) {
                    return;
                }
                UnicastProcessor<T> d = UnicastProcessor.d(this.k);
                this.r = d;
                long requested = requested();
                if (requested != 0) {
                    subscriber.onNext(d);
                    if (requested != Long.MAX_VALUE) {
                        e(1L);
                    }
                    RunnableC0178a runnableC0178a = new RunnableC0178a(this.p, this);
                    if (this.l) {
                        Scheduler.Worker worker = this.n;
                        long j = this.h;
                        schedulePeriodicallyDirect = worker.schedulePeriodically(runnableC0178a, j, j, this.i);
                    } else {
                        Scheduler scheduler = this.j;
                        long j2 = this.h;
                        schedulePeriodicallyDirect = scheduler.schedulePeriodicallyDirect(runnableC0178a, j2, j2, this.i);
                    }
                    if (this.t.replace(schedulePeriodicallyDirect)) {
                        subscription.request(Long.MAX_VALUE);
                        return;
                    }
                    return;
                }
                this.e = true;
                subscription.cancel();
                subscriber.onError(new MissingBackpressureException("Could not deliver initial window due to lack of requests."));
            }
        }

        public void onNext(T t) {
            if (this.s) {
                return;
            }
            if (h()) {
                UnicastProcessor<T> unicastProcessor = this.r;
                unicastProcessor.onNext(t);
                long j = this.o + 1;
                if (j >= this.m) {
                    this.p++;
                    this.o = 0L;
                    unicastProcessor.onComplete();
                    long requested = requested();
                    if (requested != 0) {
                        UnicastProcessor<T> d = UnicastProcessor.d(this.k);
                        this.r = d;
                        this.c.onNext(d);
                        if (requested != Long.MAX_VALUE) {
                            e(1L);
                        }
                        if (this.l) {
                            this.t.get().dispose();
                            Scheduler.Worker worker = this.n;
                            RunnableC0178a runnableC0178a = new RunnableC0178a(this.p, this);
                            long j2 = this.h;
                            this.t.replace(worker.schedulePeriodically(runnableC0178a, j2, j2, this.i));
                        }
                    } else {
                        this.r = null;
                        this.q.cancel();
                        this.c.onError(new MissingBackpressureException("Could not deliver window due to lack of requests"));
                        dispose();
                        return;
                    }
                } else {
                    this.o = j;
                }
                if (d(-1) == 0) {
                    return;
                }
            } else {
                this.d.offer(NotificationLite.next(t));
                if (!g()) {
                    return;
                }
            }
            n();
        }

        a(Subscriber<? super Flowable<T>> subscriber, long j, TimeUnit timeUnit, Scheduler scheduler, int i, long j2, boolean z) {
            super(subscriber, new MpscLinkedQueue());
            this.t = new SequentialDisposable();
            this.h = j;
            this.i = timeUnit;
            this.j = scheduler;
            this.k = i;
            this.m = j2;
            this.l = z;
            if (z) {
                this.n = scheduler.createWorker();
            } else {
                this.n = null;
            }
        }
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super Flowable<T>> subscriber) {
        io.reactivex.subscribers.d dVar = new io.reactivex.subscribers.d(subscriber);
        if (this.b == this.c) {
            if (this.f == Long.MAX_VALUE) {
                this.a.subscribe((FlowableSubscriber) new b(dVar, this.b, this.d, this.e, this.g));
                return;
            } else {
                this.a.subscribe((FlowableSubscriber) new a(dVar, this.b, this.d, this.e, this.g, this.f, this.h));
                return;
            }
        }
        this.a.subscribe((FlowableSubscriber) new c(dVar, this.b, this.c, this.d, this.e.createWorker(), this.g));
    }

    public i1(Flowable<T> flowable, long j, long j2, TimeUnit timeUnit, Scheduler scheduler, long j3, int i, boolean z) {
        super(flowable);
        this.b = j;
        this.c = j2;
        this.d = timeUnit;
        this.e = scheduler;
        this.f = j3;
        this.g = i;
        this.h = z;
    }
}
