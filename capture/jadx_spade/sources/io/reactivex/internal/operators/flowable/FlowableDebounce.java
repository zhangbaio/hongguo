package io.reactivex.internal.operators.flowable;

import com.bytedance.covode.number.Covode;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class FlowableDebounce<T, U> extends a<T, T> {
    final Function<? super T, ? extends Publisher<U>> b;

    static {
        Covode.recordClassIndex(656558);
    }

    static final class DebounceSubscriber<T, U> extends AtomicLong implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = 6725975399620862591L;
        final Function<? super T, ? extends Publisher<U>> debounceSelector;
        final AtomicReference<Disposable> debouncer = new AtomicReference<>();
        boolean done;
        final Subscriber<? super T> downstream;
        volatile long index;
        Subscription upstream;

        static {
            Covode.recordClassIndex(656559);
        }

        static final class a<T, U> extends io.reactivex.subscribers.b<U> {
            final DebounceSubscriber<T, U> b;
            final long c;
            final T d;
            boolean e;
            final AtomicBoolean f = new AtomicBoolean();

            static {
                Covode.recordClassIndex(656560);
            }

            public void onComplete() {
                if (this.e) {
                    return;
                }
                this.e = true;
                d();
            }

            void d() {
                if (this.f.compareAndSet(false, true)) {
                    this.b.emit(this.c, this.d);
                }
            }

            public void onNext(U u) {
                if (this.e) {
                    return;
                }
                this.e = true;
                b();
                d();
            }

            public void onError(Throwable th) {
                if (this.e) {
                    RxJavaPlugins.onError(th);
                } else {
                    this.e = true;
                    this.b.onError(th);
                }
            }

            a(DebounceSubscriber<T, U> debounceSubscriber, long j, T t) {
                this.b = debounceSubscriber;
                this.c = j;
                this.d = t;
            }
        }

        public void cancel() {
            this.upstream.cancel();
            DisposableHelper.dispose(this.debouncer);
        }

        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            Disposable disposable = this.debouncer.get();
            if (!DisposableHelper.isDisposed(disposable)) {
                ((a) disposable).d();
                DisposableHelper.dispose(this.debouncer);
                this.downstream.onComplete();
            }
        }

        public void onError(Throwable th) {
            DisposableHelper.dispose(this.debouncer);
            this.downstream.onError(th);
        }

        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                io.reactivex.internal.util.b.a(this, j);
            }
        }

        @Override // io.reactivex.FlowableSubscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.downstream.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public void onNext(T t) {
            if (this.done) {
                return;
            }
            long j = this.index + 1;
            this.index = j;
            Disposable disposable = this.debouncer.get();
            if (disposable != null) {
                disposable.dispose();
            }
            try {
                Publisher publisher = (Publisher) ObjectHelper.requireNonNull(this.debounceSelector.apply(t), "The publisher supplied is null");
                a aVar = new a(this, j, t);
                if (androidx.compose.animation.core.g1.a(this.debouncer, disposable, aVar)) {
                    publisher.subscribe(aVar);
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                cancel();
                this.downstream.onError(th);
            }
        }

        DebounceSubscriber(Subscriber<? super T> subscriber, Function<? super T, ? extends Publisher<U>> function) {
            this.downstream = subscriber;
            this.debounceSelector = function;
        }

        void emit(long j, T t) {
            if (j == this.index) {
                if (get() != 0) {
                    this.downstream.onNext(t);
                    io.reactivex.internal.util.b.e(this, 1L);
                } else {
                    cancel();
                    this.downstream.onError(new MissingBackpressureException("Could not deliver value due to lack of requests"));
                }
            }
        }
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        this.a.subscribe((FlowableSubscriber) new DebounceSubscriber(new io.reactivex.subscribers.d(subscriber), this.b));
    }

    public FlowableDebounce(Flowable<T> flowable, Function<? super T, ? extends Publisher<U>> function) {
        super(flowable);
        this.b = function;
    }
}
