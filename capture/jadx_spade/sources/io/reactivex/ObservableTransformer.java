package io.reactivex;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface ObservableTransformer<Upstream, Downstream> {
    ObservableSource<Downstream> apply(Observable<Upstream> observable);
}
