package io.reactivex.internal.operators.observable;

import com.bytedance.covode.number.Covode;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.Callable;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class e0<T> extends Observable<T> {
    final Callable<? extends Throwable> a;

    static {
        Covode.recordClassIndex(657211);
    }

    public e0(Callable<? extends Throwable> callable) {
        this.a = callable;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        try {
            th = (Throwable) ObjectHelper.requireNonNull(this.a.call(), "Callable returned null throwable. Null values are generally not allowed in 2.x operators and sources.");
        } catch (Throwable th) {
            th = th;
            Exceptions.throwIfFatal(th);
        }
        EmptyDisposable.error(th, observer);
    }
}
