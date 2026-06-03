package io.reactivex;

import io.reactivex.disposables.Disposable;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface SingleObserver<T> {
    void onError(Throwable th);

    void onSubscribe(Disposable disposable);

    void onSuccess(T t);
}
