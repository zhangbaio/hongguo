package io.reactivex.internal.operators.observable;

import com.bytedance.covode.number.Covode;
import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class b0<T> extends Maybe<T> implements nm6.d<T> {
    final ObservableSource<T> a;
    final long b;

    static {
        Covode.recordClassIndex(657206);
    }

    static final class a<T> implements Observer<T>, Disposable {
        final MaybeObserver<? super T> a;
        final long b;
        Disposable c;
        long d;
        boolean e;

        static {
            Covode.recordClassIndex(657207);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.c.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.c.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (!this.e) {
                this.e = true;
                this.a.onComplete();
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.c, disposable)) {
                this.c = disposable;
                this.a.onSubscribe(this);
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.e) {
                RxJavaPlugins.onError(th);
            } else {
                this.e = true;
                this.a.onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            if (this.e) {
                return;
            }
            long j = this.d;
            if (j == this.b) {
                this.e = true;
                this.c.dispose();
                this.a.onSuccess(t);
                return;
            }
            this.d = j + 1;
        }

        a(MaybeObserver<? super T> maybeObserver, long j) {
            this.a = maybeObserver;
            this.b = j;
        }
    }

    @Override // nm6.d
    public Observable<T> b() {
        return RxJavaPlugins.onAssembly(new a0(this.a, this.b, null, false));
    }

    @Override // io.reactivex.Maybe
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.a.subscribe(new a(maybeObserver, this.b));
    }

    public b0(ObservableSource<T> observableSource, long j) {
        this.a = observableSource;
        this.b = j;
    }
}
