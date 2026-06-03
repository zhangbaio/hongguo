package io.reactivex.parallel;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface a<Upstream, Downstream> {
    ParallelFlowable<Downstream> apply(ParallelFlowable<Upstream> parallelFlowable);
}
