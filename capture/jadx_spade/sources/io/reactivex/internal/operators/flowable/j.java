package io.reactivex.internal.operators.flowable;

import com.bytedance.covode.number.Covode;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class j<T, U extends Collection<? super T>> extends io.reactivex.internal.operators.flowable.a<T, U> {
    final long b;
    final long c;
    final TimeUnit d;
    final Scheduler e;
    final Callable<U> f;
    final int g;
    final boolean h;

    static {
        Covode.recordClassIndex(656510);
    }

    static final class b<T, U extends Collection<? super T>> extends io.reactivex.internal.subscribers.h<T, U, U> implements Subscription, Runnable, Disposable {
        final Callable<U> h;
        final long i;
        final TimeUnit j;
        final Scheduler k;
        Subscription l;
        U m;
        final AtomicReference<Disposable> n;

        static {
            Covode.recordClassIndex(656512);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            cancel();
        }

        public void cancel() {
            this.e = true;
            this.l.cancel();
            DisposableHelper.dispose(this.n);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            if (this.n.get() == DisposableHelper.DISPOSED) {
                return true;
            }
            return false;
        }

        public void onComplete() {
            DisposableHelper.dispose(this.n);
            synchronized (this) {
                U u = this.m;
                if (u == null) {
                    return;
                }
                this.m = null;
                this.d.offer(u);
                this.f = true;
                if (g()) {
                    io.reactivex.internal.util.k.e(this.d, this.c, false, null, this);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                U u = (U) ObjectHelper.requireNonNull(this.h.call(), "The supplied buffer is null");
                synchronized (this) {
                    U u2 = this.m;
                    if (u2 == null) {
                        return;
                    }
                    this.m = u;
                    i(u2, false, this);
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                cancel();
                this.c.onError(th);
            }
        }

        public void request(long j) {
            k(j);
        }

        public void onNext(T t) {
            synchronized (this) {
                U u = this.m;
                if (u != null) {
                    u.add(t);
                }
            }
        }

        public void onError(Throwable th) {
            DisposableHelper.dispose(this.n);
            synchronized (this) {
                this.m = null;
            }
            this.c.onError(th);
        }

        @Override // io.reactivex.FlowableSubscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.l, subscription)) {
                this.l = subscription;
                try {
                    this.m = (U) ObjectHelper.requireNonNull(this.h.call(), "The supplied buffer is null");
                    this.c.onSubscribe(this);
                    if (!this.e) {
                        subscription.request(Long.MAX_VALUE);
                        Scheduler scheduler = this.k;
                        long j = this.i;
                        Disposable schedulePeriodicallyDirect = scheduler.schedulePeriodicallyDirect(this, j, j, this.j);
                        if (!androidx.compose.animation.core.g1.a(this.n, (Object) null, schedulePeriodicallyDirect)) {
                            schedulePeriodicallyDirect.dispose();
                        }
                    }
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    cancel();
                    EmptySubscription.error(th, this.c);
                }
            }
        }

        @Override // io.reactivex.internal.subscribers.h, io.reactivex.internal.util.j
        /* renamed from: l, reason: merged with bridge method [inline-methods] */
        public boolean f(Subscriber<? super U> subscriber, U u) {
            this.c.onNext(u);
            return true;
        }

        b(Subscriber<? super U> subscriber, Callable<U> callable, long j, TimeUnit timeUnit, Scheduler scheduler) {
            super(subscriber, new MpscLinkedQueue());
            this.n = new AtomicReference<>();
            this.h = callable;
            this.i = j;
            this.j = timeUnit;
            this.k = scheduler;
        }
    }

    static final class a<T, U extends Collection<? super T>> extends io.reactivex.internal.subscribers.h<T, U, U> implements Subscription, Runnable, Disposable {
        final Callable<U> h;
        final long i;
        final TimeUnit j;
        final int k;
        final boolean l;
        final Scheduler.Worker m;
        U n;
        Disposable o;
        Subscription p;
        long q;
        long r;

        static {
            Covode.recordClassIndex(656511);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.m.isDisposed();
        }

        public void cancel() {
            if (!this.e) {
                this.e = true;
                dispose();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            synchronized (this) {
                this.n = null;
            }
            this.p.cancel();
            this.m.dispose();
        }

        public void onComplete() {
            U u;
            synchronized (this) {
                u = this.n;
                this.n = null;
            }
            this.d.offer(u);
            this.f = true;
            if (g()) {
                io.reactivex.internal.util.k.e(this.d, this.c, false, this, this);
            }
            this.m.dispose();
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                U u = (U) ObjectHelper.requireNonNull(this.h.call(), "The supplied buffer is null");
                synchronized (this) {
                    U u2 = this.n;
                    if (u2 != null && this.q == this.r) {
                        this.n = u;
                        j(u2, false, this);
                    }
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                cancel();
                this.c.onError(th);
            }
        }

        public void request(long j) {
            k(j);
        }

        public void onError(Throwable th) {
            synchronized (this) {
                this.n = null;
            }
            this.c.onError(th);
            this.m.dispose();
        }

        public void onNext(T t) {
            synchronized (this) {
                U u = this.n;
                if (u == null) {
                    return;
                }
                u.add(t);
                if (u.size() < this.k) {
                    return;
                }
                this.n = null;
                this.q++;
                if (this.l) {
                    this.o.dispose();
                }
                j(u, false, this);
                try {
                    U u2 = (U) ObjectHelper.requireNonNull(this.h.call(), "The supplied buffer is null");
                    synchronized (this) {
                        this.n = u2;
                        this.r++;
                    }
                    if (this.l) {
                        Scheduler.Worker worker = this.m;
                        long j = this.i;
                        this.o = worker.schedulePeriodically(this, j, j, this.j);
                    }
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    cancel();
                    this.c.onError(th);
                }
            }
        }

        @Override // io.reactivex.FlowableSubscriber
        public void onSubscribe(Subscription subscription) {
            if (!SubscriptionHelper.validate(this.p, subscription)) {
                return;
            }
            this.p = subscription;
            try {
                this.n = (U) ObjectHelper.requireNonNull(this.h.call(), "The supplied buffer is null");
                this.c.onSubscribe(this);
                Scheduler.Worker worker = this.m;
                long j = this.i;
                this.o = worker.schedulePeriodically(this, j, j, this.j);
                subscription.request(Long.MAX_VALUE);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.m.dispose();
                subscription.cancel();
                EmptySubscription.error(th, this.c);
            }
        }

        @Override // io.reactivex.internal.subscribers.h, io.reactivex.internal.util.j
        /* renamed from: l, reason: merged with bridge method [inline-methods] */
        public boolean f(Subscriber<? super U> subscriber, U u) {
            subscriber.onNext(u);
            return true;
        }

        a(Subscriber<? super U> subscriber, Callable<U> callable, long j, TimeUnit timeUnit, int i, boolean z, Scheduler.Worker worker) {
            super(subscriber, new MpscLinkedQueue());
            this.h = callable;
            this.i = j;
            this.j = timeUnit;
            this.k = i;
            this.l = z;
            this.m = worker;
        }
    }

    static final class c<T, U extends Collection<? super T>> extends io.reactivex.internal.subscribers.h<T, U, U> implements Subscription, Runnable {
        final Callable<U> h;
        final long i;
        final long j;
        final TimeUnit k;
        final Scheduler.Worker l;
        final List<U> m;
        Subscription n;

        static {
            Covode.recordClassIndex(656513);
        }

        void n() {
            synchronized (this) {
                this.m.clear();
            }
        }

        final class a implements Runnable {
            private final U a;

            static {
                Covode.recordClassIndex(656514);
            }

            @Override // java.lang.Runnable
            public void run() {
                synchronized (c.this) {
                    c.this.m.remove(this.a);
                }
                c cVar = c.this;
                cVar.j(this.a, false, cVar.l);
            }

            a(U u) {
                this.a = u;
            }
        }

        public void cancel() {
            this.e = true;
            this.n.cancel();
            this.l.dispose();
            n();
        }

        public void onComplete() {
            ArrayList arrayList;
            synchronized (this) {
                arrayList = new ArrayList(this.m);
                this.m.clear();
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                this.d.offer((Collection) it2.next());
            }
            this.f = true;
            if (g()) {
                io.reactivex.internal.util.k.e(this.d, this.c, false, this.l, this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.e) {
                return;
            }
            try {
                Collection collection = (Collection) ObjectHelper.requireNonNull(this.h.call(), "The supplied buffer is null");
                synchronized (this) {
                    if (this.e) {
                        return;
                    }
                    this.m.add(collection);
                    this.l.schedule(new a(collection), this.i, this.k);
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                cancel();
                this.c.onError(th);
            }
        }

        public void request(long j) {
            k(j);
        }

        public void onError(Throwable th) {
            this.f = true;
            this.l.dispose();
            n();
            this.c.onError(th);
        }

        public void onNext(T t) {
            synchronized (this) {
                Iterator<U> it2 = this.m.iterator();
                while (it2.hasNext()) {
                    it2.next().add(t);
                }
            }
        }

        @Override // io.reactivex.FlowableSubscriber
        public void onSubscribe(Subscription subscription) {
            if (!SubscriptionHelper.validate(this.n, subscription)) {
                return;
            }
            this.n = subscription;
            try {
                Collection collection = (Collection) ObjectHelper.requireNonNull(this.h.call(), "The supplied buffer is null");
                this.m.add(collection);
                this.c.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
                Scheduler.Worker worker = this.l;
                long j = this.j;
                worker.schedulePeriodically(this, j, j, this.k);
                this.l.schedule(new a(collection), this.i, this.k);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.l.dispose();
                subscription.cancel();
                EmptySubscription.error(th, this.c);
            }
        }

        @Override // io.reactivex.internal.subscribers.h, io.reactivex.internal.util.j
        /* renamed from: l, reason: merged with bridge method [inline-methods] */
        public boolean f(Subscriber<? super U> subscriber, U u) {
            subscriber.onNext(u);
            return true;
        }

        c(Subscriber<? super U> subscriber, Callable<U> callable, long j, long j2, TimeUnit timeUnit, Scheduler.Worker worker) {
            super(subscriber, new MpscLinkedQueue());
            this.h = callable;
            this.i = j;
            this.j = j2;
            this.k = timeUnit;
            this.l = worker;
            this.m = new LinkedList();
        }
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super U> subscriber) {
        if (this.b == this.c && this.g == Integer.MAX_VALUE) {
            this.a.subscribe((FlowableSubscriber) new b(new io.reactivex.subscribers.d(subscriber), this.f, this.b, this.d, this.e));
            return;
        }
        Scheduler.Worker createWorker = this.e.createWorker();
        if (this.b == this.c) {
            this.a.subscribe((FlowableSubscriber) new a(new io.reactivex.subscribers.d(subscriber), this.f, this.b, this.d, this.g, this.h, createWorker));
        } else {
            this.a.subscribe((FlowableSubscriber) new c(new io.reactivex.subscribers.d(subscriber), this.f, this.b, this.c, this.d, createWorker));
        }
    }

    public j(Flowable<T> flowable, long j, long j2, TimeUnit timeUnit, Scheduler scheduler, Callable<U> callable, int i, boolean z) {
        super(flowable);
        this.b = j;
        this.c = j2;
        this.d = timeUnit;
        this.e = scheduler;
        this.f = callable;
        this.g = i;
        this.h = z;
    }
}
