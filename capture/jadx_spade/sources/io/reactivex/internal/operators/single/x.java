package io.reactivex.internal.operators.single;

import com.bytedance.covode.number.Covode;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class x<T> extends Single<T> {
    final SingleSource<? extends T> a;
    final Function<? super Throwable, ? extends T> b;
    final T c;

    static {
        Covode.recordClassIndex(657605);
    }

    final class a implements SingleObserver<T> {
        private final SingleObserver<? super T> a;

        static {
            Covode.recordClassIndex(657606);
        }

        @Override // io.reactivex.SingleObserver
        public void onSubscribe(Disposable disposable) {
            this.a.onSubscribe(disposable);
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(T t) {
            this.a.onSuccess(t);
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable th) {
            T apply;
            x xVar = x.this;
            Function<? super Throwable, ? extends T> function = xVar.b;
            if (function != null) {
                try {
                    apply = function.apply(th);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.a.onError(new CompositeException(th, th2));
                    return;
                }
            } else {
                apply = xVar.c;
            }
            if (apply == null) {
                NullPointerException nullPointerException = new NullPointerException("Value supplied was null");
                nullPointerException.initCause(th);
                this.a.onError(nullPointerException);
                return;
            }
            this.a.onSuccess(apply);
        }

        a(SingleObserver<? super T> singleObserver) {
            this.a = singleObserver;
        }
    }

    @Override // io.reactivex.Single
    protected void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.a.subscribe(new a(singleObserver));
    }

    public x(SingleSource<? extends T> singleSource, Function<? super Throwable, ? extends T> function, T t) {
        this.a = singleSource;
        this.b = function;
        this.c = t;
    }
}
