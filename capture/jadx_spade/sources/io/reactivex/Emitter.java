package io.reactivex;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface Emitter<T> {
    void onComplete();

    void onError(Throwable th);

    void onNext(T t);
}
