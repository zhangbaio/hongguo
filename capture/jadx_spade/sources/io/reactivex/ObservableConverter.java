package io.reactivex;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface ObservableConverter<T, R> {
    R apply(Observable<T> observable);
}
