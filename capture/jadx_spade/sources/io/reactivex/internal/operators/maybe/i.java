package io.reactivex.internal.operators.maybe;

import com.bytedance.covode.number.Covode;
import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.internal.disposables.EmptyDisposable;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class i extends Maybe<Object> implements nm6.h<Object> {
    public static final i a;

    @Override // nm6.h, java.util.concurrent.Callable
    public Object call() {
        return null;
    }

    static {
        Covode.recordClassIndex(656939);
        a = new i();
    }

    @Override // io.reactivex.Maybe
    protected void subscribeActual(MaybeObserver<? super Object> maybeObserver) {
        EmptyDisposable.complete(maybeObserver);
    }
}
