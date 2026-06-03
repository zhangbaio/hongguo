package io.reactivex.processors;

import com.bytedance.covode.number.Covode;
import io.reactivex.Flowable;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class UnicastProcessor<T> extends a<T> {
    final io.reactivex.internal.queue.a<T> a;
    final AtomicReference<Runnable> b;
    final boolean c;
    volatile boolean d;
    Throwable e;
    final AtomicReference<Subscriber<? super T>> f;
    volatile boolean g;
    final AtomicBoolean h;
    final BasicIntQueueSubscription<T> i;
    final AtomicLong j;
    boolean k;

    static {
        Covode.recordClassIndex(657789);
    }

    final class UnicastQueueSubscription extends BasicIntQueueSubscription<T> {
        private static final long serialVersionUID = -4896760517184205454L;

        static {
            Covode.recordClassIndex(657790);
        }

        @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, nm6.j
        public void clear() {
            UnicastProcessor.this.a.clear();
        }

        @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, nm6.j
        public boolean isEmpty() {
            return UnicastProcessor.this.a.isEmpty();
        }

        @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, nm6.j
        public T poll() {
            return UnicastProcessor.this.a.poll();
        }

        public void cancel() {
            if (UnicastProcessor.this.g) {
                return;
            }
            UnicastProcessor.this.g = true;
            UnicastProcessor.this.f();
            UnicastProcessor unicastProcessor = UnicastProcessor.this;
            if (!unicastProcessor.k && unicastProcessor.i.getAndIncrement() == 0) {
                UnicastProcessor.this.a.clear();
                UnicastProcessor.this.f.lazySet(null);
            }
        }

        UnicastQueueSubscription() {
        }

        @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, nm6.f
        public int requestFusion(int i) {
            if ((i & 2) != 0) {
                UnicastProcessor.this.k = true;
                return 2;
            }
            return 0;
        }

        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                io.reactivex.internal.util.b.a(UnicastProcessor.this.j, j);
                UnicastProcessor.this.g();
            }
        }
    }

    @CheckReturnValue
    public static <T> UnicastProcessor<T> c() {
        return new UnicastProcessor<>(Flowable.bufferSize());
    }

    void f() {
        Runnable andSet = this.b.getAndSet(null);
        if (andSet != null) {
            andSet.run();
        }
    }

    @Override // io.reactivex.processors.a
    public Throwable getThrowable() {
        if (this.d) {
            return this.e;
        }
        return null;
    }

    @Override // io.reactivex.processors.a
    public boolean hasComplete() {
        if (this.d && this.e == null) {
            return true;
        }
        return false;
    }

    @Override // io.reactivex.processors.a
    public boolean hasSubscribers() {
        if (this.f.get() != null) {
            return true;
        }
        return false;
    }

    @Override // io.reactivex.processors.a
    public boolean hasThrowable() {
        if (this.d && this.e != null) {
            return true;
        }
        return false;
    }

    public void onComplete() {
        if (!this.d && !this.g) {
            this.d = true;
            f();
            g();
        }
    }

    void g() {
        if (this.i.getAndIncrement() != 0) {
            return;
        }
        Subscriber<? super T> subscriber = this.f.get();
        int i = 1;
        while (subscriber == null) {
            i = this.i.addAndGet(-i);
            if (i == 0) {
                return;
            } else {
                subscriber = this.f.get();
            }
        }
        if (this.k) {
            h(subscriber);
        } else {
            i(subscriber);
        }
    }

    UnicastProcessor(int i) {
        this(i, null, true);
    }

    @CheckReturnValue
    public static <T> UnicastProcessor<T> d(int i) {
        return new UnicastProcessor<>(i);
    }

    public void onError(Throwable th) {
        ObjectHelper.requireNonNull(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!this.d && !this.g) {
            this.e = th;
            this.d = true;
            f();
            g();
            return;
        }
        RxJavaPlugins.onError(th);
    }

    public void onNext(T t) {
        ObjectHelper.requireNonNull(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!this.d && !this.g) {
            this.a.offer(t);
            g();
        }
    }

    @Override // io.reactivex.FlowableSubscriber
    public void onSubscribe(Subscription subscription) {
        if (!this.d && !this.g) {
            subscription.request(Long.MAX_VALUE);
        } else {
            subscription.cancel();
        }
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        if (!this.h.get() && this.h.compareAndSet(false, true)) {
            subscriber.onSubscribe(this.i);
            this.f.set(subscriber);
            if (this.g) {
                this.f.lazySet(null);
                return;
            } else {
                g();
                return;
            }
        }
        EmptySubscription.error(new IllegalStateException("This processor allows only a single Subscriber"), subscriber);
    }

    void h(Subscriber<? super T> subscriber) {
        io.reactivex.internal.queue.a<T> aVar = this.a;
        int i = 1;
        boolean z = !this.c;
        while (!this.g) {
            boolean z2 = this.d;
            if (z && z2 && this.e != null) {
                aVar.clear();
                this.f.lazySet(null);
                subscriber.onError(this.e);
                return;
            }
            subscriber.onNext((Object) null);
            if (z2) {
                this.f.lazySet(null);
                Throwable th = this.e;
                if (th != null) {
                    subscriber.onError(th);
                    return;
                } else {
                    subscriber.onComplete();
                    return;
                }
            }
            i = this.i.addAndGet(-i);
            if (i == 0) {
                return;
            }
        }
        aVar.clear();
        this.f.lazySet(null);
    }

    void i(Subscriber<? super T> subscriber) {
        long j;
        boolean z;
        io.reactivex.internal.queue.a<T> aVar = this.a;
        boolean z2 = !this.c;
        int i = 1;
        do {
            long j2 = this.j.get();
            long j3 = 0;
            while (true) {
                if (j2 != j3) {
                    boolean z3 = this.d;
                    T poll = aVar.poll();
                    if (poll == null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    j = j3;
                    if (b(z2, z3, z, subscriber, aVar)) {
                        return;
                    }
                    if (z) {
                        break;
                    }
                    subscriber.onNext(poll);
                    j3 = 1 + j;
                } else {
                    j = j3;
                    break;
                }
            }
            if (j2 == j3 && b(z2, this.d, aVar.isEmpty(), subscriber, aVar)) {
                return;
            }
            if (j != 0 && j2 != Long.MAX_VALUE) {
                this.j.addAndGet(-j);
            }
            i = this.i.addAndGet(-i);
        } while (i != 0);
    }

    UnicastProcessor(int i, Runnable runnable) {
        this(i, runnable, true);
    }

    @CheckReturnValue
    public static <T> UnicastProcessor<T> e(int i, Runnable runnable) {
        ObjectHelper.requireNonNull(runnable, "onTerminate");
        return new UnicastProcessor<>(i, runnable);
    }

    UnicastProcessor(int i, Runnable runnable, boolean z) {
        this.a = new io.reactivex.internal.queue.a<>(ObjectHelper.verifyPositive(i, "capacityHint"));
        this.b = new AtomicReference<>(runnable);
        this.c = z;
        this.f = new AtomicReference<>();
        this.h = new AtomicBoolean();
        this.i = new UnicastQueueSubscription();
        this.j = new AtomicLong();
    }

    boolean b(boolean z, boolean z2, boolean z3, Subscriber<? super T> subscriber, io.reactivex.internal.queue.a<T> aVar) {
        if (this.g) {
            aVar.clear();
            this.f.lazySet(null);
            return true;
        }
        if (z2) {
            if (z && this.e != null) {
                aVar.clear();
                this.f.lazySet(null);
                subscriber.onError(this.e);
                return true;
            }
            if (z3) {
                Throwable th = this.e;
                this.f.lazySet(null);
                if (th != null) {
                    subscriber.onError(th);
                } else {
                    subscriber.onComplete();
                }
                return true;
            }
            return false;
        }
        return false;
    }
}
