package io.reactivex.internal.operators.observable;

import com.bytedance.covode.number.Covode;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class n1<T> extends io.reactivex.internal.operators.observable.a<T, T> {
    final long a;

    static {
        Covode.recordClassIndex(657404);
    }

    static final class a<T> implements Observer<T>, Disposable {
        final Observer<? super T> a;
        boolean b;
        Disposable c;
        long d;

        static {
            Covode.recordClassIndex(657405);
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
            if (!this.b) {
                this.b = true;
                this.c.dispose();
                this.a.onComplete();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.b) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.b = true;
            this.c.dispose();
            this.a.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            boolean z;
            if (!this.b) {
                long j = this.d;
                long j2 = j - 1;
                this.d = j2;
                if (j > 0) {
                    if (j2 == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    this.a.onNext(t);
                    if (z) {
                        onComplete();
                    }
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.c, disposable)) {
                this.c = disposable;
                if (this.d == 0) {
                    this.b = true;
                    disposable.dispose();
                    EmptyDisposable.complete(this.a);
                    return;
                }
                this.a.onSubscribe(this);
            }
        }

        a(Observer<? super T> observer, long j) {
            this.a = observer;
            this.d = j;
        }
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new a(observer, this.a));
    }

    public n1(ObservableSource<T> observableSource, long j) {
        super(observableSource);
        this.a = j;
    }
}
