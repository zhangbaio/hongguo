package io.reactivex;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface MaybeTransformer<Upstream, Downstream> {
    MaybeSource<Downstream> apply(Maybe<Upstream> maybe);
}
