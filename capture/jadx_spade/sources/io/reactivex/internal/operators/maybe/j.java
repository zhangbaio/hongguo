package io.reactivex.internal.operators.maybe;

import com.bytedance.covode.number.Covode;
import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposables;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class j<T> extends Maybe<T> {
    final Throwable a;

    static {
        Covode.recordClassIndex(656943);
    }

    public j(Throwable th) {
        this.a = th;
    }

    @Override // io.reactivex.Maybe
    protected void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        maybeObserver.onSubscribe(Disposables.disposed());
        maybeObserver.onError(this.a);
    }
}
