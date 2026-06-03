package io.reactivex.internal.operators.flowable;

import com.bytedance.covode.number.Covode;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.Collection;
import java.util.concurrent.Callable;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class i<T, U extends Collection<? super T>, B> extends io.reactivex.internal.operators.flowable.a<T, U> {
    final Publisher<B> b;
    final Callable<U> c;

    static {
        Covode.recordClassIndex(656507);
    }

    static final class b<T, U extends Collection<? super T>, B> extends io.reactivex.internal.subscribers.h<T, U, U> implements Subscription, Disposable {
        final Callable<U> h;
        final Publisher<B> i;
        Subscription j;
        Disposable k;
        U l;

        static {
            Covode.recordClassIndex(656509);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            cancel();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.e;
        }

        public void cancel() {
            if (!this.e) {
                this.e = true;
                this.k.dispose();
                this.j.cancel();
                if (g()) {
                    this.d.clear();
                }
            }
        }

        void m() {
            try {
                U u = (U) ObjectHelper.requireNonNull(this.h.call(), "The buffer supplied is null");
                synchronized (this) {
                    U u2 = this.l;
                    if (u2 == null) {
                        return;
                    }
                    this.l = u;
                    i(u2, false, this);
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                cancel();
                this.c.onError(th);
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
            try {
                this.l = (U) ObjectHelper.requireNonNull(this.h.call(), "The buffer supplied is null");
                a aVar = new a(this);
                this.k = aVar;
                this.c.onSubscribe(this);
                if (!this.e) {
                    subscription.request(Long.MAX_VALUE);
                    this.i.subscribe(aVar);
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.e = true;
                subscription.cancel();
                EmptySubscription.error(th, this.c);
            }
        }

        @Override // io.reactivex.internal.subscribers.h, io.reactivex.internal.util.j
        /* renamed from: l, reason: merged with bridge method [inline-methods] */
        public boolean f(Subscriber<? super U> subscriber, U u) {
            this.c.onNext(u);
            return true;
        }

        b(Subscriber<? super U> subscriber, Callable<U> callable, Publisher<B> publisher) {
            super(subscriber, new MpscLinkedQueue());
            this.h = callable;
            this.i = publisher;
        }
    }

    static final class a<T, U extends Collection<? super T>, B> extends io.reactivex.subscribers.b<B> {
        final b<T, U, B> b;

        static {
            Covode.recordClassIndex(656508);
        }

        public void onComplete() {
            this.b.onComplete();
        }

        a(b<T, U, B> bVar) {
            this.b = bVar;
        }

        public void onError(Throwable th) {
            this.b.onError(th);
        }

        public void onNext(B b) {
            this.b.m();
        }
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super U> subscriber) {
        this.a.subscribe((FlowableSubscriber) new b(new io.reactivex.subscribers.d(subscriber), this.c, this.b));
    }

    public i(Flowable<T> flowable, Publisher<B> publisher, Callable<U> callable) {
        super(flowable);
        this.b = publisher;
        this.c = callable;
    }
}
