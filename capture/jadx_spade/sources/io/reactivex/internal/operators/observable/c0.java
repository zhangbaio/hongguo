package io.reactivex.internal.operators.observable;

import com.bytedance.covode.number.Covode;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class c0<T> extends Single<T> implements nm6.d<T> {
    final ObservableSource<T> a;
    final long b;
    final T c;

    static {
        Covode.recordClassIndex(657208);
    }

    static final class a<T> implements Observer<T>, Disposable {
        final SingleObserver<? super T> a;
        final long b;
        final T c;
        Disposable d;
        long e;
        boolean f;

        static {
            Covode.recordClassIndex(657209);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.d.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.d.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (!this.f) {
                this.f = true;
                T t = this.c;
                if (t != null) {
                    this.a.onSuccess(t);
                } else {
                    this.a.onError(new NoSuchElementException());
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.d, disposable)) {
                this.d = disposable;
                this.a.onSubscribe(this);
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.f) {
                RxJavaPlugins.onError(th);
            } else {
                this.f = true;
                this.a.onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            if (this.f) {
                return;
            }
            long j = this.e;
            if (j == this.b) {
                this.f = true;
                this.d.dispose();
                this.a.onSuccess(t);
                return;
            }
            this.e = j + 1;
        }

        a(SingleObserver<? super T> singleObserver, long j, T t) {
            this.a = singleObserver;
            this.b = j;
            this.c = t;
        }
    }

    @Override // nm6.d
    public Observable<T> b() {
        return RxJavaPlugins.onAssembly(new a0(this.a, this.b, this.c, true));
    }

    @Override // io.reactivex.Single
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.a.subscribe(new a(singleObserver, this.b, this.c));
    }

    public c0(ObservableSource<T> observableSource, long j, T t) {
        this.a = observableSource;
        this.b = j;
        this.c = t;
    }
}
