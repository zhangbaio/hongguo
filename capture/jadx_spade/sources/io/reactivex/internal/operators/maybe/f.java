package io.reactivex.internal.operators.maybe;

import com.bytedance.covode.number.Covode;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class f<T> extends io.reactivex.internal.operators.maybe.a<T, T> {
    static {
        Covode.recordClassIndex(656931);
    }

    static final class a<T> implements MaybeObserver<T>, Disposable {
        MaybeObserver<? super T> a;
        Disposable b;

        static {
            Covode.recordClassIndex(656932);
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

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            this.b = DisposableHelper.DISPOSED;
            MaybeObserver<? super T> maybeObserver = this.a;
            if (maybeObserver != null) {
                this.a = null;
                maybeObserver.onComplete();
            }
        }

        a(MaybeObserver<? super T> maybeObserver) {
            this.a = maybeObserver;
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            this.b = DisposableHelper.DISPOSED;
            MaybeObserver<? super T> maybeObserver = this.a;
            if (maybeObserver != null) {
                this.a = null;
                maybeObserver.onError(th);
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.b, disposable)) {
                this.b = disposable;
                this.a.onSubscribe(this);
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(T t) {
            this.b = DisposableHelper.DISPOSED;
            MaybeObserver<? super T> maybeObserver = this.a;
            if (maybeObserver != null) {
                this.a = null;
                maybeObserver.onSuccess(t);
            }
        }
    }

    public f(MaybeSource<T> maybeSource) {
        super(maybeSource);
    }

    @Override // io.reactivex.Maybe
    protected void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.a.subscribe(new a(maybeObserver));
    }
}
