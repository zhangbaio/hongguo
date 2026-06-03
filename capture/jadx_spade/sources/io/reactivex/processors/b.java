package io.reactivex.processors;

import com.bytedance.covode.number.Covode;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class b<T> extends a<T> {
    final a<T> a;
    boolean b;
    io.reactivex.internal.util.a<Object> c;
    volatile boolean d;

    static {
        Covode.recordClassIndex(657788);
    }

    @Override // io.reactivex.processors.a
    public Throwable getThrowable() {
        return this.a.getThrowable();
    }

    @Override // io.reactivex.processors.a
    public boolean hasComplete() {
        return this.a.hasComplete();
    }

    @Override // io.reactivex.processors.a
    public boolean hasSubscribers() {
        return this.a.hasSubscribers();
    }

    @Override // io.reactivex.processors.a
    public boolean hasThrowable() {
        return this.a.hasThrowable();
    }

    void b() {
        io.reactivex.internal.util.a<Object> aVar;
        while (true) {
            synchronized (this) {
                aVar = this.c;
                if (aVar == null) {
                    this.b = false;
                    return;
                }
                this.c = null;
            }
            aVar.b(this.a);
        }
    }

    public void onComplete() {
        if (this.d) {
            return;
        }
        synchronized (this) {
            if (this.d) {
                return;
            }
            this.d = true;
            if (this.b) {
                io.reactivex.internal.util.a<Object> aVar = this.c;
                if (aVar == null) {
                    aVar = new io.reactivex.internal.util.a<>(4);
                    this.c = aVar;
                }
                aVar.c(NotificationLite.complete());
                return;
            }
            this.b = true;
            this.a.onComplete();
        }
    }

    b(a<T> aVar) {
        this.a = aVar;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        this.a.subscribe(subscriber);
    }

    public void onError(Throwable th) {
        if (this.d) {
            RxJavaPlugins.onError(th);
            return;
        }
        synchronized (this) {
            boolean z = true;
            if (!this.d) {
                this.d = true;
                if (this.b) {
                    io.reactivex.internal.util.a<Object> aVar = this.c;
                    if (aVar == null) {
                        aVar = new io.reactivex.internal.util.a<>(4);
                        this.c = aVar;
                    }
                    aVar.e(NotificationLite.error(th));
                    return;
                }
                this.b = true;
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
        if (this.d) {
            return;
        }
        synchronized (this) {
            if (this.d) {
                return;
            }
            if (this.b) {
                io.reactivex.internal.util.a<Object> aVar = this.c;
                if (aVar == null) {
                    aVar = new io.reactivex.internal.util.a<>(4);
                    this.c = aVar;
                }
                aVar.c(NotificationLite.next(t));
                return;
            }
            this.b = true;
            this.a.onNext(t);
            b();
        }
    }

    @Override // io.reactivex.FlowableSubscriber
    public void onSubscribe(Subscription subscription) {
        boolean z = true;
        if (!this.d) {
            synchronized (this) {
                if (!this.d) {
                    if (this.b) {
                        io.reactivex.internal.util.a<Object> aVar = this.c;
                        if (aVar == null) {
                            aVar = new io.reactivex.internal.util.a<>(4);
                            this.c = aVar;
                        }
                        aVar.c(NotificationLite.subscription(subscription));
                        return;
                    }
                    this.b = true;
                    z = false;
                }
            }
        }
        if (z) {
            subscription.cancel();
        } else {
            this.a.onSubscribe(subscription);
            b();
        }
    }
}
