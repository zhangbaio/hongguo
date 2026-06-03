package io.reactivex.internal.operators.flowable;

import com.bytedance.covode.number.Covode;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class FlowableCache<T> extends io.reactivex.internal.operators.flowable.a<T, T> implements FlowableSubscriber<T> {
    static final CacheSubscription[] k;
    static final CacheSubscription[] l;
    final AtomicBoolean b;
    final int c;
    final AtomicReference<CacheSubscription<T>[]> d;
    public volatile long e;
    final a<T> f;
    a<T> g;
    int h;
    Throwable i;
    volatile boolean j;

    static {
        Covode.recordClassIndex(656515);
        k = new CacheSubscription[0];
        l = new CacheSubscription[0];
    }

    static final class CacheSubscription<T> extends AtomicInteger implements Subscription {
        private static final long serialVersionUID = 6770240836423125754L;
        final Subscriber<? super T> downstream;
        long index;
        a<T> node;
        int offset;
        final FlowableCache<T> parent;
        final AtomicLong requested = new AtomicLong();

        static {
            Covode.recordClassIndex(656516);
        }

        public void cancel() {
            if (this.requested.getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.parent.c(this);
            }
        }

        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                io.reactivex.internal.util.b.b(this.requested, j);
                this.parent.d(this);
            }
        }

        CacheSubscription(Subscriber<? super T> subscriber, FlowableCache<T> flowableCache) {
            this.downstream = subscriber;
            this.parent = flowableCache;
            this.node = flowableCache.f;
        }
    }

    public void onComplete() {
        this.j = true;
        for (CacheSubscription<T> cacheSubscription : this.d.getAndSet(l)) {
            d(cacheSubscription);
        }
    }

    static final class a<T> {
        final T[] a;
        volatile a<T> b;

        static {
            Covode.recordClassIndex(656517);
        }

        a(int i) {
            this.a = (T[]) new Object[i];
        }
    }

    @Override // io.reactivex.FlowableSubscriber
    public void onSubscribe(Subscription subscription) {
        subscription.request(Long.MAX_VALUE);
    }

    void b(CacheSubscription<T> cacheSubscription) {
        CacheSubscription<T>[] cacheSubscriptionArr;
        CacheSubscription[] cacheSubscriptionArr2;
        do {
            cacheSubscriptionArr = this.d.get();
            if (cacheSubscriptionArr == l) {
                return;
            }
            int length = cacheSubscriptionArr.length;
            cacheSubscriptionArr2 = new CacheSubscription[length + 1];
            System.arraycopy(cacheSubscriptionArr, 0, cacheSubscriptionArr2, 0, length);
            cacheSubscriptionArr2[length] = cacheSubscription;
        } while (!androidx.compose.animation.core.g1.a(this.d, cacheSubscriptionArr, cacheSubscriptionArr2));
    }

    void c(CacheSubscription<T> cacheSubscription) {
        CacheSubscription<T>[] cacheSubscriptionArr;
        CacheSubscription[] cacheSubscriptionArr2;
        do {
            cacheSubscriptionArr = this.d.get();
            int length = cacheSubscriptionArr.length;
            if (length == 0) {
                return;
            }
            int i = 0;
            while (true) {
                if (i < length) {
                    if (cacheSubscriptionArr[i] == cacheSubscription) {
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
                cacheSubscriptionArr2 = k;
            } else {
                CacheSubscription[] cacheSubscriptionArr3 = new CacheSubscription[length - 1];
                System.arraycopy(cacheSubscriptionArr, 0, cacheSubscriptionArr3, 0, i);
                System.arraycopy(cacheSubscriptionArr, i + 1, cacheSubscriptionArr3, i, (length - i) - 1);
                cacheSubscriptionArr2 = cacheSubscriptionArr3;
            }
        } while (!androidx.compose.animation.core.g1.a(this.d, cacheSubscriptionArr, cacheSubscriptionArr2));
    }

    public void onError(Throwable th) {
        if (this.j) {
            RxJavaPlugins.onError(th);
            return;
        }
        this.i = th;
        this.j = true;
        for (CacheSubscription<T> cacheSubscription : this.d.getAndSet(l)) {
            d(cacheSubscription);
        }
    }

    public void onNext(T t) {
        int i = this.h;
        if (i == this.c) {
            a<T> aVar = new a<>(i);
            aVar.a[0] = t;
            this.h = 1;
            this.g.b = aVar;
            this.g = aVar;
        } else {
            this.g.a[i] = t;
            this.h = i + 1;
        }
        this.e++;
        for (CacheSubscription<T> cacheSubscription : this.d.get()) {
            d(cacheSubscription);
        }
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        CacheSubscription<T> cacheSubscription = new CacheSubscription<>(subscriber, this);
        subscriber.onSubscribe(cacheSubscription);
        b(cacheSubscription);
        if (!this.b.get() && this.b.compareAndSet(false, true)) {
            this.a.subscribe((FlowableSubscriber) this);
        } else {
            d(cacheSubscription);
        }
    }

    void d(CacheSubscription<T> cacheSubscription) {
        boolean z;
        if (cacheSubscription.getAndIncrement() != 0) {
            return;
        }
        long j = cacheSubscription.index;
        int i = cacheSubscription.offset;
        a<T> aVar = cacheSubscription.node;
        AtomicLong atomicLong = cacheSubscription.requested;
        Subscriber<? super T> subscriber = cacheSubscription.downstream;
        int i2 = this.c;
        int i3 = 1;
        while (true) {
            boolean z2 = this.j;
            if (this.e == j) {
                z = true;
            } else {
                z = false;
            }
            if (z2 && z) {
                cacheSubscription.node = null;
                Throwable th = this.i;
                if (th != null) {
                    subscriber.onError(th);
                    return;
                } else {
                    subscriber.onComplete();
                    return;
                }
            }
            if (!z) {
                long j2 = atomicLong.get();
                if (j2 == Long.MIN_VALUE) {
                    cacheSubscription.node = null;
                    return;
                } else if (j2 != j) {
                    if (i == i2) {
                        aVar = aVar.b;
                        i = 0;
                    }
                    subscriber.onNext(aVar.a[i]);
                    i++;
                    j++;
                }
            }
            cacheSubscription.index = j;
            cacheSubscription.offset = i;
            cacheSubscription.node = aVar;
            i3 = cacheSubscription.addAndGet(-i3);
            if (i3 == 0) {
                return;
            }
        }
    }

    public FlowableCache(Flowable<T> flowable, int i) {
        super(flowable);
        this.c = i;
        this.b = new AtomicBoolean();
        a<T> aVar = new a<>(i);
        this.f = aVar;
        this.g = aVar;
        this.d = new AtomicReference<>(k);
    }
}
