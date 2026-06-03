package io.reactivex;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface FlowableConverter<T, R> {
    R apply(Flowable<T> flowable);
}
