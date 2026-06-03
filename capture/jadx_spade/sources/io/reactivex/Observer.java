package io.reactivex;

import io.reactivex.disposables.Disposable;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface Observer<T> {
    void onComplete();

    void onError(Throwable th);

    void onNext(T t);

    void onSubscribe(Disposable disposable);
}
