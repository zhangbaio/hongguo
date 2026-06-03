package io.reactivex.internal.operators.observable;

import com.bytedance.covode.number.Covode;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class f<T> extends Single<Boolean> implements nm6.d<Boolean> {
    final ObservableSource<T> a;
    final Predicate<? super T> b;

    static {
        Covode.recordClassIndex(657114);
    }

    static final class a<T> implements Observer<T>, Disposable {
        final SingleObserver<? super Boolean> a;
        final Predicate<? super T> b;
        Disposable c;
        boolean d;

        static {
            Covode.recordClassIndex(657115);
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
            if (this.d) {
                return;
            }
            this.d = true;
            this.a.onSuccess(Boolean.TRUE);
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
            if (this.d) {
                RxJavaPlugins.onError(th);
            } else {
                this.d = true;
                this.a.onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            if (this.d) {
                return;
            }
            try {
                if (!this.b.test(t)) {
                    this.d = true;
                    this.c.dispose();
                    this.a.onSuccess(Boolean.FALSE);
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.c.dispose();
                onError(th);
            }
        }

        a(SingleObserver<? super Boolean> singleObserver, Predicate<? super T> predicate) {
            this.a = singleObserver;
            this.b = predicate;
        }
    }

    @Override // nm6.d
    public Observable<Boolean> b() {
        return RxJavaPlugins.onAssembly(new e(this.a, this.b));
    }

    @Override // io.reactivex.Single
    protected void subscribeActual(SingleObserver<? super Boolean> singleObserver) {
        this.a.subscribe(new a(singleObserver, this.b));
    }

    public f(ObservableSource<T> observableSource, Predicate<? super T> predicate) {
        this.a = observableSource;
        this.b = predicate;
    }
}
