package io.reactivex.internal.observers;

import com.bytedance.covode.number.Covode;
import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class o<T> implements CompletableObserver, Subscription {
    final Subscriber<? super T> a;
    Disposable b;

    static {
        Covode.recordClassIndex(656390);
    }

    public void request(long j) {
    }

    public void cancel() {
        this.b.dispose();
    }

    @Override // io.reactivex.CompletableObserver
    public void onComplete() {
        this.a.onComplete();
    }

    public o(Subscriber<? super T> subscriber) {
        this.a = subscriber;
    }

    @Override // io.reactivex.CompletableObserver
    public void onError(Throwable th) {
        this.a.onError(th);
    }

    @Override // io.reactivex.CompletableObserver
    public void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.b, disposable)) {
            this.b = disposable;
            this.a.onSubscribe(this);
        }
    }
}
