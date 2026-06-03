package io.reactivex.internal.operators.observable;

import com.bytedance.covode.number.Covode;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class e<T> extends io.reactivex.internal.operators.observable.a<T, Boolean> {
    final Predicate<? super T> a;

    static {
        Covode.recordClassIndex(657112);
    }

    static final class a<T> implements Observer<T>, Disposable {
        final Observer<? super Boolean> a;
        final Predicate<? super T> b;
        Disposable c;
        boolean d;

        static {
            Covode.recordClassIndex(657113);
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
            this.a.onNext(Boolean.TRUE);
            this.a.onComplete();
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
                    this.a.onNext(Boolean.FALSE);
                    this.a.onComplete();
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.c.dispose();
                onError(th);
            }
        }

        a(Observer<? super Boolean> observer, Predicate<? super T> predicate) {
            this.a = observer;
            this.b = predicate;
        }
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super Boolean> observer) {
        this.source.subscribe(new a(observer, this.a));
    }

    public e(ObservableSource<T> observableSource, Predicate<? super T> predicate) {
        super(observableSource);
        this.a = predicate;
    }
}
