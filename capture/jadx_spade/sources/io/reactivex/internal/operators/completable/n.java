package io.reactivex.internal.operators.completable;

import com.bytedance.covode.number.Covode;
import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class n<T> extends Completable {
    final SingleSource<T> a;

    static {
        Covode.recordClassIndex(656428);
    }

    static final class a<T> implements SingleObserver<T> {
        final CompletableObserver a;

        static {
            Covode.recordClassIndex(656429);
        }

        a(CompletableObserver completableObserver) {
            this.a = completableObserver;
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // io.reactivex.SingleObserver
        public void onSubscribe(Disposable disposable) {
            this.a.onSubscribe(disposable);
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(T t) {
            this.a.onComplete();
        }
    }

    public n(SingleSource<T> singleSource) {
        this.a = singleSource;
    }

    @Override // io.reactivex.Completable
    protected void subscribeActual(CompletableObserver completableObserver) {
        this.a.subscribe(new a(completableObserver));
    }
}
