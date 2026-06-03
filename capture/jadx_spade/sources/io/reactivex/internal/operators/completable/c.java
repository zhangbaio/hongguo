package io.reactivex.internal.operators.completable;

import com.bytedance.covode.number.Covode;
import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class c extends Completable {
    final CompletableSource a;

    static {
        Covode.recordClassIndex(656410);
    }

    static final class a implements CompletableObserver, Disposable {
        CompletableObserver a;
        Disposable b;

        static {
            Covode.recordClassIndex(656411);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.b.isDisposed();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.a = null;
            this.b.dispose();
            this.b = DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.CompletableObserver
        public void onComplete() {
            this.b = DisposableHelper.DISPOSED;
            CompletableObserver completableObserver = this.a;
            if (completableObserver != null) {
                this.a = null;
                completableObserver.onComplete();
            }
        }

        a(CompletableObserver completableObserver) {
            this.a = completableObserver;
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(Throwable th) {
            this.b = DisposableHelper.DISPOSED;
            CompletableObserver completableObserver = this.a;
            if (completableObserver != null) {
                this.a = null;
                completableObserver.onError(th);
            }
        }

        @Override // io.reactivex.CompletableObserver
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.b, disposable)) {
                this.b = disposable;
                this.a.onSubscribe(this);
            }
        }
    }

    public c(CompletableSource completableSource) {
        this.a = completableSource;
    }

    @Override // io.reactivex.Completable
    protected void subscribeActual(CompletableObserver completableObserver) {
        this.a.subscribe(new a(completableObserver));
    }
}
