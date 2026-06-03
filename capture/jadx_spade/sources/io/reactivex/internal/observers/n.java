package io.reactivex.internal.observers;

import com.bytedance.covode.number.Covode;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class n<T> implements SingleObserver<T> {
    final AtomicReference<Disposable> a;
    final SingleObserver<? super T> b;

    static {
        Covode.recordClassIndex(656389);
    }

    @Override // io.reactivex.SingleObserver
    public void onError(Throwable th) {
        this.b.onError(th);
    }

    @Override // io.reactivex.SingleObserver
    public void onSubscribe(Disposable disposable) {
        DisposableHelper.replace(this.a, disposable);
    }

    @Override // io.reactivex.SingleObserver
    public void onSuccess(T t) {
        this.b.onSuccess(t);
    }

    public n(AtomicReference<Disposable> atomicReference, SingleObserver<? super T> singleObserver) {
        this.a = atomicReference;
        this.b = singleObserver;
    }
}
