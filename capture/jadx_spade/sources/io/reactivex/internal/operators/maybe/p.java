package io.reactivex.internal.operators.maybe;

import com.bytedance.covode.number.Covode;
import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class p<T> extends Maybe<T> implements Callable<T> {
    final Callable<? extends T> a;

    static {
        Covode.recordClassIndex(656971);
    }

    @Override // java.util.concurrent.Callable
    public T call() throws Exception {
        return this.a.call();
    }

    public p(Callable<? extends T> callable) {
        this.a = callable;
    }

    @Override // io.reactivex.Maybe
    protected void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        Disposable empty = Disposables.empty();
        maybeObserver.onSubscribe(empty);
        if (!empty.isDisposed()) {
            try {
                T call = this.a.call();
                if (!empty.isDisposed()) {
                    if (call == null) {
                        maybeObserver.onComplete();
                    } else {
                        maybeObserver.onSuccess(call);
                    }
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                if (!empty.isDisposed()) {
                    maybeObserver.onError(th);
                } else {
                    RxJavaPlugins.onError(th);
                }
            }
        }
    }
}
