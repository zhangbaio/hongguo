package io.reactivex.subscribers;

import com.bytedance.covode.number.Covode;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class d<T> implements FlowableSubscriber<T>, Subscription {
    final Subscriber<? super T> a;
    final boolean b;
    Subscription c;
    boolean d;
    io.reactivex.internal.util.a<Object> e;
    volatile boolean f;

    static {
        Covode.recordClassIndex(657834);
    }

    public void cancel() {
        this.c.cancel();
    }

    void a() {
        io.reactivex.internal.util.a<Object> aVar;
        do {
            synchronized (this) {
                aVar = this.e;
                if (aVar == null) {
                    this.d = false;
                    return;
                }
                this.e = null;
            }
        } while (!aVar.b(this.a));
    }

    public void onComplete() {
        if (this.f) {
            return;
        }
        synchronized (this) {
            if (this.f) {
                return;
            }
            if (this.d) {
                io.reactivex.internal.util.a<Object> aVar = this.e;
                if (aVar == null) {
                    aVar = new io.reactivex.internal.util.a<>(4);
                    this.e = aVar;
                }
                aVar.c(NotificationLite.complete());
                return;
            }
            this.f = true;
            this.d = true;
            this.a.onComplete();
        }
    }

    public d(Subscriber<? super T> subscriber) {
        this(subscriber, false);
    }

    public void request(long j) {
        this.c.request(j);
    }

    @Override // io.reactivex.FlowableSubscriber
    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.c, subscription)) {
            this.c = subscription;
            this.a.onSubscribe(this);
        }
    }

    public void onError(Throwable th) {
        if (this.f) {
            RxJavaPlugins.onError(th);
            return;
        }
        synchronized (this) {
            boolean z = true;
            if (!this.f) {
                if (this.d) {
                    this.f = true;
                    io.reactivex.internal.util.a<Object> aVar = this.e;
                    if (aVar == null) {
                        aVar = new io.reactivex.internal.util.a<>(4);
                        this.e = aVar;
                    }
                    Object error = NotificationLite.error(th);
                    if (this.b) {
                        aVar.c(error);
                    } else {
                        aVar.e(error);
                    }
                    return;
                }
                this.f = true;
                this.d = true;
                z = false;
            }
            if (z) {
                RxJavaPlugins.onError(th);
            } else {
                this.a.onError(th);
            }
        }
    }

    public void onNext(T t) {
        if (this.f) {
            return;
        }
        if (t == null) {
            this.c.cancel();
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return;
        }
        synchronized (this) {
            if (this.f) {
                return;
            }
            if (this.d) {
                io.reactivex.internal.util.a<Object> aVar = this.e;
                if (aVar == null) {
                    aVar = new io.reactivex.internal.util.a<>(4);
                    this.e = aVar;
                }
                aVar.c(NotificationLite.next(t));
                return;
            }
            this.d = true;
            this.a.onNext(t);
            a();
        }
    }

    public d(Subscriber<? super T> subscriber, boolean z) {
        this.a = subscriber;
        this.b = z;
    }
}
