package io.reactivex.internal.operators.flowable;

import com.bytedance.covode.number.Covode;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscription;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class x<T> extends Maybe<T> implements nm6.b<T> {
    final Flowable<T> a;
    final long b;

    static {
        Covode.recordClassIndex(656595);
    }

    static final class a<T> implements FlowableSubscriber<T>, Disposable {
        final MaybeObserver<? super T> a;
        final long b;
        Subscription c;
        long d;
        boolean e;

        static {
            Covode.recordClassIndex(656596);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.c.cancel();
            this.c = SubscriptionHelper.CANCELLED;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            if (this.c == SubscriptionHelper.CANCELLED) {
                return true;
            }
            return false;
        }

        public void onComplete() {
            this.c = SubscriptionHelper.CANCELLED;
            if (!this.e) {
                this.e = true;
                this.a.onComplete();
            }
        }

        public void onError(Throwable th) {
            if (this.e) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.e = true;
            this.c = SubscriptionHelper.CANCELLED;
            this.a.onError(th);
        }

        @Override // io.reactivex.FlowableSubscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.c, subscription)) {
                this.c = subscription;
                this.a.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public void onNext(T t) {
            if (this.e) {
                return;
            }
            long j = this.d;
            if (j == this.b) {
                this.e = true;
                this.c.cancel();
                this.c = SubscriptionHelper.CANCELLED;
                this.a.onSuccess(t);
                return;
            }
            this.d = j + 1;
        }

        a(MaybeObserver<? super T> maybeObserver, long j) {
            this.a = maybeObserver;
            this.b = j;
        }
    }

    @Override // nm6.b
    public Flowable<T> c() {
        return RxJavaPlugins.onAssembly(new FlowableElementAt(this.a, this.b, null, false));
    }

    @Override // io.reactivex.Maybe
    protected void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.a.subscribe((FlowableSubscriber) new a(maybeObserver, this.b));
    }

    public x(Flowable<T> flowable, long j) {
        this.a = flowable;
        this.b = j;
    }
}
