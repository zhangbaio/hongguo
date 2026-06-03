package io.reactivex.internal.operators.flowable;

import com.bytedance.covode.number.Covode;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.processors.UnicastProcessor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class h1<T, B, V> extends io.reactivex.internal.operators.flowable.a<T, Flowable<T>> {
    final Publisher<B> b;
    final Function<? super B, ? extends Publisher<V>> c;
    final int d;

    static {
        Covode.recordClassIndex(656874);
    }

    static final class b<T, B> extends io.reactivex.subscribers.b<B> {
        final c<T, B, ?> b;

        static {
            Covode.recordClassIndex(656876);
        }

        public void onComplete() {
            this.b.onComplete();
        }

        b(c<T, B, ?> cVar) {
            this.b = cVar;
        }

        public void onError(Throwable th) {
            this.b.n(th);
        }

        public void onNext(B b) {
            this.b.o(b);
        }
    }

    static final class a<T, V> extends io.reactivex.subscribers.b<V> {
        final c<T, ?, V> b;
        final UnicastProcessor<T> c;
        boolean d;

        static {
            Covode.recordClassIndex(656875);
        }

        public void onComplete() {
            if (this.d) {
                return;
            }
            this.d = true;
            this.b.l(this);
        }

        public void onNext(V v) {
            b();
            onComplete();
        }

        public void onError(Throwable th) {
            if (this.d) {
                RxJavaPlugins.onError(th);
            } else {
                this.d = true;
                this.b.n(th);
            }
        }

        a(c<T, ?, V> cVar, UnicastProcessor<T> unicastProcessor) {
            this.b = cVar;
            this.c = unicastProcessor;
        }
    }

    static final class c<T, B, V> extends io.reactivex.internal.subscribers.h<T, Object, Flowable<T>> implements Subscription {
        final Publisher<B> h;
        final Function<? super B, ? extends Publisher<V>> i;
        final int j;
        final CompositeDisposable k;
        Subscription l;
        final AtomicReference<Disposable> m;
        final List<UnicastProcessor<T>> n;
        final AtomicLong o;

        static {
            Covode.recordClassIndex(656877);
        }

        public void cancel() {
            this.e = true;
        }

        @Override // io.reactivex.internal.subscribers.h, io.reactivex.internal.util.j
        public boolean f(Subscriber<? super Flowable<T>> subscriber, Object obj) {
            return false;
        }

        void dispose() {
            this.k.dispose();
            DisposableHelper.dispose(this.m);
        }

        public void onComplete() {
            if (this.f) {
                return;
            }
            this.f = true;
            if (g()) {
                m();
            }
            if (this.o.decrementAndGet() == 0) {
                this.k.dispose();
            }
            this.c.onComplete();
        }

        /* JADX WARN: Multi-variable type inference failed */
        void m() {
            boolean z;
            nm6.j jVar = this.d;
            Subscriber<? super V> subscriber = this.c;
            List<UnicastProcessor<T>> list = this.n;
            int i = 1;
            while (true) {
                boolean z2 = this.f;
                Object poll = jVar.poll();
                if (poll == null) {
                    z = true;
                } else {
                    z = false;
                }
                if (z2 && z) {
                    dispose();
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
                    return;
                }
                if (z) {
                    i = d(-i);
                    if (i == 0) {
                        return;
                    }
                } else if (poll instanceof d) {
                    d dVar = (d) poll;
                    UnicastProcessor<T> unicastProcessor = dVar.a;
                    if (unicastProcessor != null) {
                        if (list.remove(unicastProcessor)) {
                            dVar.a.onComplete();
                            if (this.o.decrementAndGet() == 0) {
                                dispose();
                                return;
                            }
                        } else {
                            continue;
                        }
                    } else if (!this.e) {
                        UnicastProcessor<T> d = UnicastProcessor.d(this.j);
                        long requested = requested();
                        if (requested != 0) {
                            list.add(d);
                            subscriber.onNext(d);
                            if (requested != Long.MAX_VALUE) {
                                e(1L);
                            }
                            try {
                                Publisher publisher = (Publisher) ObjectHelper.requireNonNull(this.i.apply(dVar.b), "The publisher supplied is null");
                                a aVar = new a(this, d);
                                if (this.k.add(aVar)) {
                                    this.o.getAndIncrement();
                                    publisher.subscribe(aVar);
                                }
                            } catch (Throwable th2) {
                                this.e = true;
                                subscriber.onError(th2);
                            }
                        } else {
                            this.e = true;
                            subscriber.onError(new MissingBackpressureException("Could not deliver new window due to lack of requests"));
                        }
                    }
                } else {
                    Iterator<UnicastProcessor<T>> it5 = list.iterator();
                    while (it5.hasNext()) {
                        it5.next().onNext(NotificationLite.getValue(poll));
                    }
                }
            }
        }

        public void request(long j) {
            k(j);
        }

        void l(a<T, V> aVar) {
            this.k.delete(aVar);
            this.d.offer(new d(aVar.c, null));
            if (g()) {
                m();
            }
        }

        void n(Throwable th) {
            this.l.cancel();
            this.k.dispose();
            DisposableHelper.dispose(this.m);
            this.c.onError(th);
        }

        void o(B b) {
            this.d.offer(new d(null, b));
            if (g()) {
                m();
            }
        }

        public void onError(Throwable th) {
            if (this.f) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.g = th;
            this.f = true;
            if (g()) {
                m();
            }
            if (this.o.decrementAndGet() == 0) {
                this.k.dispose();
            }
            this.c.onError(th);
        }

        public void onNext(T t) {
            if (this.f) {
                return;
            }
            if (h()) {
                Iterator<UnicastProcessor<T>> it2 = this.n.iterator();
                while (it2.hasNext()) {
                    it2.next().onNext(t);
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
            m();
        }

        @Override // io.reactivex.FlowableSubscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.l, subscription)) {
                this.l = subscription;
                this.c.onSubscribe(this);
                if (this.e) {
                    return;
                }
                b bVar = new b(this);
                if (androidx.compose.animation.core.g1.a(this.m, (Object) null, bVar)) {
                    this.o.getAndIncrement();
                    subscription.request(Long.MAX_VALUE);
                    this.h.subscribe(bVar);
                }
            }
        }

        c(Subscriber<? super Flowable<T>> subscriber, Publisher<B> publisher, Function<? super B, ? extends Publisher<V>> function, int i) {
            super(subscriber, new MpscLinkedQueue());
            this.m = new AtomicReference<>();
            AtomicLong atomicLong = new AtomicLong();
            this.o = atomicLong;
            this.h = publisher;
            this.i = function;
            this.j = i;
            this.k = new CompositeDisposable();
            this.n = new ArrayList();
            atomicLong.lazySet(1L);
        }
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super Flowable<T>> subscriber) {
        this.a.subscribe((FlowableSubscriber) new c(new io.reactivex.subscribers.d(subscriber), this.b, this.c, this.d));
    }

    static final class d<T, B> {
        final UnicastProcessor<T> a;
        final B b;

        static {
            Covode.recordClassIndex(656878);
        }

        d(UnicastProcessor<T> unicastProcessor, B b) {
            this.a = unicastProcessor;
            this.b = b;
        }
    }

    public h1(Flowable<T> flowable, Publisher<B> publisher, Function<? super B, ? extends Publisher<V>> function, int i) {
        super(flowable);
        this.b = publisher;
        this.c = function;
        this.d = i;
    }
}
