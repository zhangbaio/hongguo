package io.reactivex.internal.operators.maybe;

import com.bytedance.covode.number.Covode;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class i0<T> extends a<T, T> {
    static {
        Covode.recordClassIndex(657042);
    }

    public i0(MaybeSource<T> maybeSource) {
        super(maybeSource);
    }

    @Override // io.reactivex.Maybe
    protected void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.a.subscribe(maybeObserver);
    }
}
