package io.reactivex.internal.operators.flowable;

import com.bytedance.covode.number.Covode;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Notification;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class q<T, R> extends io.reactivex.internal.operators.flowable.a<T, R> {
    final Function<? super T, ? extends Notification<R>> b;

    static {
        Covode.recordClassIndex(656573);
    }

    static final class a<T, R> implements FlowableSubscriber<T>, Subscription {
        final Subscriber<? super R> a;
        final Function<? super T, ? extends Notification<R>> b;
        boolean c;
        Subscription d;

        static {
            Covode.recordClassIndex(656574);
        }

        public void cancel() {
            this.d.cancel();
        }

        public void onComplete() {
            if (this.c) {
                return;
            }
            this.c = true;
            this.a.onComplete();
        }

        public void request(long j) {
            this.d.request(j);
        }

        @Override // io.reactivex.FlowableSubscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.d, subscription)) {
                this.d = subscription;
                this.a.onSubscribe(this);
            }
        }

        public void onError(Throwable th) {
            if (this.c) {
                RxJavaPlugins.onError(th);
            } else {
                this.c = true;
                this.a.onError(th);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void onNext(T t) {
            if (this.c) {
                if (t instanceof Notification) {
                    Notification notification = (Notification) t;
                    if (notification.isOnError()) {
                        RxJavaPlugins.onError(notification.getError());
                        return;
                    }
                    return;
                }
                return;
            }
            try {
                Notification notification2 = (Notification) ObjectHelper.requireNonNull(this.b.apply(t), "The selector returned a null Notification");
                if (notification2.isOnError()) {
                    this.d.cancel();
                    onError(notification2.getError());
                } else if (notification2.isOnComplete()) {
                    this.d.cancel();
                    onComplete();
                } else {
                    this.a.onNext(notification2.getValue());
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.d.cancel();
                onError(th);
            }
        }

        a(Subscriber<? super R> subscriber, Function<? super T, ? extends Notification<R>> function) {
            this.a = subscriber;
            this.b = function;
        }
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super R> subscriber) {
        this.a.subscribe((FlowableSubscriber) new a(subscriber, this.b));
    }

    public q(Flowable<T> flowable, Function<? super T, ? extends Notification<R>> function) {
        super(flowable);
        this.b = function;
    }
}
