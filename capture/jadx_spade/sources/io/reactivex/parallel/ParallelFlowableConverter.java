package io.reactivex.parallel;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface ParallelFlowableConverter<T, R> {
    R apply(ParallelFlowable<T> parallelFlowable);
}
