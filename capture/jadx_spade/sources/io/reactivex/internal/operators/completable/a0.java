package io.reactivex.internal.operators.completable;

import com.bytedance.covode.number.Covode;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import java.util.concurrent.Callable;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class a0<T> extends Single<T> {
    final CompletableSource a;
    final Callable<? extends T> b;
    final T c;

    static {
        Covode.recordClassIndex(656468);
    }

    final class a implements CompletableObserver {
        private final SingleObserver<? super T> a;

        static {
            Covode.recordClassIndex(656469);
        }

        @Override // io.reactivex.CompletableObserver
        public void onComplete() {
            T call;
            a0 a0Var = a0.this;
            Callable<? extends T> callable = a0Var.b;
            if (callable != null) {
                try {
                    call = callable.call();
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.a.onError(th);
                    return;
                }
            } else {
                call = a0Var.c;
            }
            if (call == null) {
                this.a.onError(new NullPointerException("The value supplied is null"));
            } else {
                this.a.onSuccess(call);
            }
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // io.reactivex.CompletableObserver
        public void onSubscribe(Disposable disposable) {
            this.a.onSubscribe(disposable);
        }

        a(SingleObserver<? super T> singleObserver) {
            this.a = singleObserver;
        }
    }

    @Override // io.reactivex.Single
    protected void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.a.subscribe(new a(singleObserver));
    }

    public a0(CompletableSource completableSource, Callable<? extends T> callable, T t) {
        this.a = completableSource;
        this.c = t;
        this.b = callable;
    }
}
