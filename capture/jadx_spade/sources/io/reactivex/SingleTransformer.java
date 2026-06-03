package io.reactivex;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface SingleTransformer<Upstream, Downstream> {
    SingleSource<Downstream> apply(Single<Upstream> single);
}
