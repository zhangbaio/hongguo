package io.reactivex.internal.operators.single;

import com.bytedance.covode.number.Covode;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class p<T> extends Single<T> {
    final Publisher<? extends T> a;

    static {
        Covode.recordClassIndex(657586);
    }

    static final class a<T> implements FlowableSubscriber<T>, Disposable {
        final SingleObserver<? super T> a;
        Subscription b;
        T c;
        boolean d;
        volatile boolean e;

        static {
            Covode.recordClassIndex(657587);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.e;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.e = true;
            this.b.cancel();
        }

        public void onComplete() {
            if (this.d) {
                return;
            }
            this.d = true;
            T t = this.c;
            this.c = null;
            if (t == null) {
                this.a.onError(new NoSuchElementException("The source Publisher is empty"));
            } else {
                this.a.onSuccess(t);
            }
        }

        a(SingleObserver<? super T> singleObserver) {
            this.a = singleObserver;
        }

        public void onError(Throwable th) {
            if (this.d) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.d = true;
            this.c = null;
            this.a.onError(th);
        }

        @Override // io.reactivex.FlowableSubscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.b, subscription)) {
                this.b = subscription;
                this.a.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public void onNext(T t) {
            if (this.d) {
                return;
            }
            if (this.c != null) {
                this.b.cancel();
                this.d = true;
                this.c = null;
                this.a.onError(new IndexOutOfBoundsException("Too many elements in the Publisher"));
                return;
            }
            this.c = t;
        }
    }

    public p(Publisher<? extends T> publisher) {
        this.a = publisher;
    }

    @Override // io.reactivex.Single
    protected void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.a.subscribe(new a(singleObserver));
    }
}
