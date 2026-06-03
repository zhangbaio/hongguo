package io.reactivex.internal.operators.flowable;

import com.bytedance.covode.number.Covode;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class FlowableRefCount<T> extends Flowable<T> {
    final km6.a<T> a;
    final int b;
    final long c;
    final TimeUnit d;
    final Scheduler e;
    RefConnection f;

    static {
        Covode.recordClassIndex(656743);
    }

    static final class RefConnection extends AtomicReference<Disposable> implements Runnable, Consumer<Disposable> {
        private static final long serialVersionUID = -4552101107598366241L;
        boolean connected;
        boolean disconnectedEarly;
        final FlowableRefCount<?> parent;
        long subscriberCount;
        Disposable timer;

        static {
            Covode.recordClassIndex(656744);
        }

        @Override // java.lang.Runnable
        public void run() {
            this.parent.d(this);
        }

        RefConnection(FlowableRefCount<?> flowableRefCount) {
            this.parent = flowableRefCount;
        }

        @Override // io.reactivex.functions.Consumer
        public void accept(Disposable disposable) throws Exception {
            DisposableHelper.replace(this, disposable);
            synchronized (this.parent) {
                if (this.disconnectedEarly) {
                    ((mm6.c) this.parent.a).a(disposable);
                }
            }
        }
    }

    static final class RefCountSubscriber<T> extends AtomicBoolean implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -7419642935409022375L;
        final RefConnection connection;
        final Subscriber<? super T> downstream;
        final FlowableRefCount<T> parent;
        Subscription upstream;

        static {
            Covode.recordClassIndex(656745);
        }

        public void cancel() {
            this.upstream.cancel();
            if (compareAndSet(false, true)) {
                this.parent.b(this.connection);
            }
        }

        public void onComplete() {
            if (compareAndSet(false, true)) {
                this.parent.c(this.connection);
                this.downstream.onComplete();
            }
        }

        public void onNext(T t) {
            this.downstream.onNext(t);
        }

        public void request(long j) {
            this.upstream.request(j);
        }

        @Override // io.reactivex.FlowableSubscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.downstream.onSubscribe(this);
            }
        }

        public void onError(Throwable th) {
            if (compareAndSet(false, true)) {
                this.parent.c(this.connection);
                this.downstream.onError(th);
            } else {
                RxJavaPlugins.onError(th);
            }
        }

        RefCountSubscriber(Subscriber<? super T> subscriber, FlowableRefCount<T> flowableRefCount, RefConnection refConnection) {
            this.downstream = subscriber;
            this.parent = flowableRefCount;
            this.connection = refConnection;
        }
    }

    public FlowableRefCount(km6.a<T> aVar) {
        this(aVar, 1, 0L, TimeUnit.NANOSECONDS, Schedulers.trampoline());
    }

    void c(RefConnection refConnection) {
        synchronized (this) {
            RefConnection refConnection2 = this.f;
            if (refConnection2 != null && refConnection2 == refConnection) {
                this.f = null;
                Disposable disposable = refConnection.timer;
                if (disposable != null) {
                    disposable.dispose();
                }
            }
            long j = refConnection.subscriberCount - 1;
            refConnection.subscriberCount = j;
            if (j == 0) {
                km6.a<T> aVar = this.a;
                if (aVar instanceof Disposable) {
                    ((Disposable) aVar).dispose();
                } else if (aVar instanceof mm6.c) {
                    ((mm6.c) aVar).a(refConnection.get());
                }
            }
        }
    }

    void d(RefConnection refConnection) {
        synchronized (this) {
            if (refConnection.subscriberCount == 0 && refConnection == this.f) {
                this.f = null;
                Disposable disposable = refConnection.get();
                DisposableHelper.dispose(refConnection);
                km6.a<T> aVar = this.a;
                if (aVar instanceof Disposable) {
                    ((Disposable) aVar).dispose();
                } else if (aVar instanceof mm6.c) {
                    if (disposable == null) {
                        refConnection.disconnectedEarly = true;
                    } else {
                        ((mm6.c) aVar).a(disposable);
                    }
                }
            }
        }
    }

    void b(RefConnection refConnection) {
        synchronized (this) {
            RefConnection refConnection2 = this.f;
            if (refConnection2 != null && refConnection2 == refConnection) {
                long j = refConnection.subscriberCount - 1;
                refConnection.subscriberCount = j;
                if (j == 0 && refConnection.connected) {
                    if (this.c == 0) {
                        d(refConnection);
                        return;
                    }
                    SequentialDisposable sequentialDisposable = new SequentialDisposable();
                    refConnection.timer = sequentialDisposable;
                    sequentialDisposable.replace(this.e.scheduleDirect(refConnection, this.c, this.d));
                }
            }
        }
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        RefConnection refConnection;
        boolean z;
        Disposable disposable;
        synchronized (this) {
            refConnection = this.f;
            if (refConnection == null) {
                refConnection = new RefConnection(this);
                this.f = refConnection;
            }
            long j = refConnection.subscriberCount;
            if (j == 0 && (disposable = refConnection.timer) != null) {
                disposable.dispose();
            }
            long j2 = j + 1;
            refConnection.subscriberCount = j2;
            if (!refConnection.connected && j2 == this.b) {
                z = true;
                refConnection.connected = true;
            } else {
                z = false;
            }
        }
        this.a.subscribe((FlowableSubscriber) new RefCountSubscriber(subscriber, this, refConnection));
        if (z) {
            this.a.b(refConnection);
        }
    }

    public FlowableRefCount(km6.a<T> aVar, int i, long j, TimeUnit timeUnit, Scheduler scheduler) {
        this.a = aVar;
        this.b = i;
        this.c = j;
        this.d = timeUnit;
        this.e = scheduler;
    }
}
