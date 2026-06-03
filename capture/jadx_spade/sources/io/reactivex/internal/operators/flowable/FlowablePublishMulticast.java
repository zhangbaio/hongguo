package io.reactivex.internal.operators.flowable;

import com.bytedance.covode.number.Covode;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class FlowablePublishMulticast<T, R> extends io.reactivex.internal.operators.flowable.a<T, R> {
    final Function<? super Flowable<T>, ? extends Publisher<? extends R>> b;
    final int c;
    final boolean d;

    static {
        Covode.recordClassIndex(656724);
    }

    static final class MulticastSubscription<T> extends AtomicLong implements Subscription {
        private static final long serialVersionUID = 8664815189257569791L;
        final Subscriber<? super T> downstream;
        long emitted;
        final a<T> parent;

        static {
            Covode.recordClassIndex(656726);
        }

        public boolean isCancelled() {
            if (get() == Long.MIN_VALUE) {
                return true;
            }
            return false;
        }

        public void cancel() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.parent.f(this);
                this.parent.d();
            }
        }

        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                io.reactivex.internal.util.b.b(this, j);
                this.parent.d();
            }
        }

        MulticastSubscription(Subscriber<? super T> subscriber, a<T> aVar) {
            this.downstream = subscriber;
            this.parent = aVar;
        }
    }

    static final class a<T> extends Flowable<T> implements FlowableSubscriber<T>, Disposable {
        static final MulticastSubscription[] l;
        static final MulticastSubscription[] m;
        final int c;
        final int d;
        final boolean e;
        volatile nm6.j<T> g;
        int h;
        volatile boolean i;
        Throwable j;
        int k;
        final AtomicInteger a = new AtomicInteger();
        final AtomicReference<Subscription> f = new AtomicReference<>();
        final AtomicReference<MulticastSubscription<T>[]> b = new AtomicReference<>(l);

        static {
            Covode.recordClassIndex(656725);
            l = new MulticastSubscription[0];
            m = new MulticastSubscription[0];
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            if (this.f.get() == SubscriptionHelper.CANCELLED) {
                return true;
            }
            return false;
        }

        public void onComplete() {
            if (!this.i) {
                this.i = true;
                d();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            nm6.j<T> jVar;
            SubscriptionHelper.cancel(this.f);
            if (this.a.getAndIncrement() == 0 && (jVar = this.g) != null) {
                jVar.clear();
            }
        }

        void c() {
            for (MulticastSubscription<T> multicastSubscription : this.b.getAndSet(m)) {
                if (multicastSubscription.get() != Long.MIN_VALUE) {
                    multicastSubscription.downstream.onComplete();
                }
            }
        }

        void d() {
            boolean z;
            AtomicReference<MulticastSubscription<T>[]> atomicReference;
            Throwable th;
            boolean z2;
            Throwable th2;
            if (this.a.getAndIncrement() != 0) {
                return;
            }
            nm6.j<T> jVar = this.g;
            int i = this.k;
            int i2 = this.d;
            if (this.h != 1) {
                z = true;
            } else {
                z = false;
            }
            AtomicReference<MulticastSubscription<T>[]> atomicReference2 = this.b;
            MulticastSubscription<T>[] multicastSubscriptionArr = atomicReference2.get();
            int i3 = 1;
            while (true) {
                int length = multicastSubscriptionArr.length;
                if (jVar != null && length != 0) {
                    int length2 = multicastSubscriptionArr.length;
                    long j = Long.MAX_VALUE;
                    long j2 = Long.MAX_VALUE;
                    int i4 = 0;
                    while (i4 < length2) {
                        MulticastSubscription<T> multicastSubscription = multicastSubscriptionArr[i4];
                        AtomicReference<MulticastSubscription<T>[]> atomicReference3 = atomicReference2;
                        long j3 = multicastSubscription.get() - multicastSubscription.emitted;
                        if (j3 != Long.MIN_VALUE) {
                            if (j2 > j3) {
                                j2 = j3;
                            }
                        } else {
                            length--;
                        }
                        i4++;
                        atomicReference2 = atomicReference3;
                    }
                    atomicReference = atomicReference2;
                    long j4 = 0;
                    if (length == 0) {
                        j2 = 0;
                    }
                    while (j2 != j4) {
                        if (isDisposed()) {
                            jVar.clear();
                            return;
                        }
                        boolean z3 = this.i;
                        if (z3 && !this.e && (th2 = this.j) != null) {
                            e(th2);
                            return;
                        }
                        try {
                            T poll = jVar.poll();
                            if (poll == null) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            if (z3 && z2) {
                                Throwable th3 = this.j;
                                if (th3 != null) {
                                    e(th3);
                                    return;
                                } else {
                                    c();
                                    return;
                                }
                            }
                            if (z2) {
                                break;
                            }
                            int length3 = multicastSubscriptionArr.length;
                            int i5 = 0;
                            boolean z4 = false;
                            while (i5 < length3) {
                                MulticastSubscription<T> multicastSubscription2 = multicastSubscriptionArr[i5];
                                long j5 = multicastSubscription2.get();
                                if (j5 != Long.MIN_VALUE) {
                                    if (j5 != j) {
                                        multicastSubscription2.emitted++;
                                    }
                                    multicastSubscription2.downstream.onNext(poll);
                                } else {
                                    z4 = true;
                                }
                                i5++;
                                j = Long.MAX_VALUE;
                            }
                            j2--;
                            if (z && (i = i + 1) == i2) {
                                this.f.get().request(i2);
                                i = 0;
                            }
                            MulticastSubscription<T>[] multicastSubscriptionArr2 = atomicReference.get();
                            if (!z4 && multicastSubscriptionArr2 == multicastSubscriptionArr) {
                                j4 = 0;
                                j = Long.MAX_VALUE;
                            } else {
                                multicastSubscriptionArr = multicastSubscriptionArr2;
                                break;
                            }
                        } catch (Throwable th4) {
                            Exceptions.throwIfFatal(th4);
                            SubscriptionHelper.cancel(this.f);
                            e(th4);
                            return;
                        }
                    }
                    if (j2 == j4) {
                        if (isDisposed()) {
                            jVar.clear();
                            return;
                        }
                        boolean z5 = this.i;
                        if (z5 && !this.e && (th = this.j) != null) {
                            e(th);
                            return;
                        }
                        if (z5 && jVar.isEmpty()) {
                            Throwable th5 = this.j;
                            if (th5 != null) {
                                e(th5);
                                return;
                            } else {
                                c();
                                return;
                            }
                        }
                    }
                } else {
                    atomicReference = atomicReference2;
                }
                this.k = i;
                i3 = this.a.addAndGet(-i3);
                if (i3 == 0) {
                    return;
                }
                if (jVar == null) {
                    jVar = this.g;
                }
                multicastSubscriptionArr = atomicReference.get();
                atomicReference2 = atomicReference;
            }
        }

        public void onError(Throwable th) {
            if (this.i) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.j = th;
            this.i = true;
            d();
        }

        boolean b(MulticastSubscription<T> multicastSubscription) {
            MulticastSubscription<T>[] multicastSubscriptionArr;
            MulticastSubscription[] multicastSubscriptionArr2;
            do {
                multicastSubscriptionArr = this.b.get();
                if (multicastSubscriptionArr == m) {
                    return false;
                }
                int length = multicastSubscriptionArr.length;
                multicastSubscriptionArr2 = new MulticastSubscription[length + 1];
                System.arraycopy(multicastSubscriptionArr, 0, multicastSubscriptionArr2, 0, length);
                multicastSubscriptionArr2[length] = multicastSubscription;
            } while (!androidx.compose.animation.core.g1.a(this.b, multicastSubscriptionArr, multicastSubscriptionArr2));
            return true;
        }

        void e(Throwable th) {
            for (MulticastSubscription<T> multicastSubscription : this.b.getAndSet(m)) {
                if (multicastSubscription.get() != Long.MIN_VALUE) {
                    multicastSubscription.downstream.onError(th);
                }
            }
        }

        void f(MulticastSubscription<T> multicastSubscription) {
            MulticastSubscription<T>[] multicastSubscriptionArr;
            MulticastSubscription[] multicastSubscriptionArr2;
            do {
                multicastSubscriptionArr = this.b.get();
                int length = multicastSubscriptionArr.length;
                if (length == 0) {
                    return;
                }
                int i = 0;
                while (true) {
                    if (i < length) {
                        if (multicastSubscriptionArr[i] == multicastSubscription) {
                            break;
                        } else {
                            i++;
                        }
                    } else {
                        i = -1;
                        break;
                    }
                }
                if (i < 0) {
                    return;
                }
                if (length == 1) {
                    multicastSubscriptionArr2 = l;
                } else {
                    MulticastSubscription[] multicastSubscriptionArr3 = new MulticastSubscription[length - 1];
                    System.arraycopy(multicastSubscriptionArr, 0, multicastSubscriptionArr3, 0, i);
                    System.arraycopy(multicastSubscriptionArr, i + 1, multicastSubscriptionArr3, i, (length - i) - 1);
                    multicastSubscriptionArr2 = multicastSubscriptionArr3;
                }
            } while (!androidx.compose.animation.core.g1.a(this.b, multicastSubscriptionArr, multicastSubscriptionArr2));
        }

        public void onNext(T t) {
            if (this.i) {
                return;
            }
            if (this.h == 0 && !this.g.offer(t)) {
                this.f.get().cancel();
                onError(new MissingBackpressureException());
            } else {
                d();
            }
        }

        @Override // io.reactivex.FlowableSubscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this.f, subscription)) {
                if (subscription instanceof nm6.g) {
                    nm6.g gVar = (nm6.g) subscription;
                    int requestFusion = gVar.requestFusion(3);
                    if (requestFusion == 1) {
                        this.h = requestFusion;
                        this.g = gVar;
                        this.i = true;
                        d();
                        return;
                    }
                    if (requestFusion == 2) {
                        this.h = requestFusion;
                        this.g = gVar;
                        io.reactivex.internal.util.k.j(subscription, this.c);
                        return;
                    }
                }
                this.g = io.reactivex.internal.util.k.c(this.c);
                io.reactivex.internal.util.k.j(subscription, this.c);
            }
        }

        @Override // io.reactivex.Flowable
        protected void subscribeActual(Subscriber<? super T> subscriber) {
            MulticastSubscription<T> multicastSubscription = new MulticastSubscription<>(subscriber, this);
            subscriber.onSubscribe(multicastSubscription);
            if (b(multicastSubscription)) {
                if (multicastSubscription.isCancelled()) {
                    f(multicastSubscription);
                    return;
                } else {
                    d();
                    return;
                }
            }
            Throwable th = this.j;
            if (th != null) {
                subscriber.onError(th);
            } else {
                subscriber.onComplete();
            }
        }

        a(int i, boolean z) {
            this.c = i;
            this.d = i - (i >> 2);
            this.e = z;
        }
    }

    static final class b<R> implements FlowableSubscriber<R>, Subscription {
        final Subscriber<? super R> a;
        final a<?> b;
        Subscription c;

        static {
            Covode.recordClassIndex(656727);
        }

        public void cancel() {
            this.c.cancel();
            this.b.dispose();
        }

        public void onComplete() {
            this.a.onComplete();
            this.b.dispose();
        }

        public void onNext(R r) {
            this.a.onNext(r);
        }

        public void request(long j) {
            this.c.request(j);
        }

        public void onError(Throwable th) {
            this.a.onError(th);
            this.b.dispose();
        }

        @Override // io.reactivex.FlowableSubscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.c, subscription)) {
                this.c = subscription;
                this.a.onSubscribe(this);
            }
        }

        b(Subscriber<? super R> subscriber, a<?> aVar) {
            this.a = subscriber;
            this.b = aVar;
        }
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super R> subscriber) {
        a aVar = new a(this.c, this.d);
        try {
            ((Publisher) ObjectHelper.requireNonNull(this.b.apply(aVar), "selector returned a null Publisher")).subscribe(new b(subscriber, aVar));
            this.a.subscribe((FlowableSubscriber) aVar);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptySubscription.error(th, subscriber);
        }
    }

    public FlowablePublishMulticast(Flowable<T> flowable, Function<? super Flowable<T>, ? extends Publisher<? extends R>> function, int i, boolean z) {
        super(flowable);
        this.b = function;
        this.c = i;
        this.d = z;
    }
}
