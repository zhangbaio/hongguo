package io.reactivex.internal.operators.single;

import com.bytedance.covode.number.Covode;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.Callable;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class c<T> extends Single<T> {
    final Callable<? extends SingleSource<? extends T>> a;

    static {
        Covode.recordClassIndex(657535);
    }

    public c(Callable<? extends SingleSource<? extends T>> callable) {
        this.a = callable;
    }

    @Override // io.reactivex.Single
    protected void subscribeActual(SingleObserver<? super T> singleObserver) {
        try {
            ((SingleSource) ObjectHelper.requireNonNull(this.a.call(), "The singleSupplier returned a null SingleSource")).subscribe(singleObserver);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptyDisposable.error(th, singleObserver);
        }
    }
}
