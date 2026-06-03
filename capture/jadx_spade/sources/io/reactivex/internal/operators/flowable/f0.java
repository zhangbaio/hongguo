package io.reactivex.internal.operators.flowable;

import com.bytedance.covode.number.Covode;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class f0<T> extends Flowable<T> {
    private final Observable<T> a;

    static {
        Covode.recordClassIndex(656632);
    }

    static final class a<T> implements Observer<T>, Subscription {
        final Subscriber<? super T> a;
        Disposable b;

        static {
            Covode.recordClassIndex(656633);
        }

        public void request(long j) {
        }

        public void cancel() {
            this.b.dispose();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.a.onComplete();
        }

        a(Subscriber<? super T> subscriber) {
            this.a = subscriber;
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            this.a.onNext(t);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            this.b = disposable;
            this.a.onSubscribe(this);
        }
    }

    public f0(Observable<T> observable) {
        this.a = observable;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        this.a.subscribe(new a(subscriber));
    }
}
