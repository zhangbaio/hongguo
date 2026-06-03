package io.reactivex.internal.operators.flowable;

import com.bytedance.covode.number.Covode;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class h<T, U extends Collection<? super T>, B> extends io.reactivex.internal.operators.flowable.a<T, U> {
    final Callable<? extends Publisher<B>> b;
    final Callable<U> c;

    static {
        Covode.recordClassIndex(656504);
    }

    static final class b<T, U extends Collection<? super T>, B> extends io.reactivex.internal.subscribers.h<T, U, U> implements Subscription, Disposable {
        final Callable<U> h;
        final Callable<? extends Publisher<B>> i;
        Subscription j;
        final AtomicReference<Disposable> k;
        U l;

        static {
            Covode.recordClassIndex(656506);
        }

        void m() {
            DisposableHelper.dispose(this.k);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.j.cancel();
            m();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            if (this.k.get() == DisposableHelper.DISPOSED) {
                return true;
            }
            return false;
        }

        public void cancel() {
            if (!this.e) {
                this.e = true;
                this.j.cancel();
                m();
                if (g()) {
                    this.d.clear();
                }
            }
        }

        public void onComplete() {
            synchronized (this) {
                U u = this.l;
                if (u == null) {
                    return;
                }
                this.l = null;
                this.d.offer(u);
                this.f = true;
                if (g()) {
                    io.reactivex.internal.util.k.e(this.d, this.c, false, this, this);
                }
            }
        }

        void n() {
            try {
                U u = (U) ObjectHelper.requireNonNull(this.h.call(), "The buffer supplied is null");
                try {
                    Publisher publisher = (Publisher) ObjectHelper.requireNonNull(this.i.call(), "The boundary publisher supplied is null");
                    a aVar = new a(this);
                    if (DisposableHelper.replace(this.k, aVar)) {
                        synchronized (this) {
                            U u2 = this.l;
                            if (u2 == null) {
                                return;
                            }
                            this.l = u;
                            publisher.subscribe(aVar);
                            i(u2, false, this);
                        }
                    }
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.e = true;
                    this.j.cancel();
                    this.c.onError(th);
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                cancel();
                this.c.onError(th2);
            }
        }

        public void request(long j) {
            k(j);
        }

        public void onError(Throwable th) {
            cancel();
            this.c.onError(th);
        }

        public void onNext(T t) {
            synchronized (this) {
                U u = this.l;
                if (u == null) {
                    return;
                }
                u.add(t);
            }
        }

        @Override // io.reactivex.FlowableSubscriber
        public void onSubscribe(Subscription subscription) {
            if (!SubscriptionHelper.validate(this.j, subscription)) {
                return;
            }
            this.j = subscription;
            Subscriber<? super V> subscriber = this.c;
            try {
                this.l = (U) ObjectHelper.requireNonNull(this.h.call(), "The buffer supplied is null");
                try {
                    Publisher publisher = (Publisher) ObjectHelper.requireNonNull(this.i.call(), "The boundary publisher supplied is null");
                    a aVar = new a(this);
                    this.k.set(aVar);
                    subscriber.onSubscribe(this);
                    if (!this.e) {
                        subscription.request(Long.MAX_VALUE);
                        publisher.subscribe(aVar);
                    }
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.e = true;
                    subscription.cancel();
                    EmptySubscription.error(th, subscriber);
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.e = true;
                subscription.cancel();
                EmptySubscription.error(th2, subscriber);
            }
        }

        @Override // io.reactivex.internal.subscribers.h, io.reactivex.internal.util.j
        /* renamed from: l, reason: merged with bridge method [inline-methods] */
        public boolean f(Subscriber<? super U> subscriber, U u) {
            this.c.onNext(u);
            return true;
        }

        b(Subscriber<? super U> subscriber, Callable<U> callable, Callable<? extends Publisher<B>> callable2) {
            super(subscriber, new MpscLinkedQueue());
            this.k = new AtomicReference<>();
            this.h = callable;
            this.i = callable2;
        }
    }

    static final class a<T, U extends Collection<? super T>, B> extends io.reactivex.subscribers.b<B> {
        final b<T, U, B> b;
        boolean c;

        static {
            Covode.recordClassIndex(656505);
        }

        public void onComplete() {
            if (this.c) {
                return;
            }
            this.c = true;
            this.b.n();
        }

        a(b<T, U, B> bVar) {
            this.b = bVar;
        }

        public void onError(Throwable th) {
            if (this.c) {
                RxJavaPlugins.onError(th);
            } else {
                this.c = true;
                this.b.onError(th);
            }
        }

        public void onNext(B b) {
            if (this.c) {
                return;
            }
            this.c = true;
            b();
            this.b.n();
        }
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super U> subscriber) {
        this.a.subscribe((FlowableSubscriber) new b(new io.reactivex.subscribers.d(subscriber), this.c, this.b));
    }

    public h(Flowable<T> flowable, Callable<? extends Publisher<B>> callable, Callable<U> callable2) {
        super(flowable);
        this.b = callable;
        this.c = callable2;
    }
}
