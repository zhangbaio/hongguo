package io.reactivex.internal.operators.observable;

import com.bytedance.covode.number.Covode;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class a0<T> extends io.reactivex.internal.operators.observable.a<T, T> {
    final long a;
    final T b;
    final boolean c;

    static {
        Covode.recordClassIndex(657204);
    }

    static final class a<T> implements Observer<T>, Disposable {
        final Observer<? super T> a;
        final long b;
        final T c;
        final boolean d;
        Disposable e;
        long f;
        boolean g;

        static {
            Covode.recordClassIndex(657205);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.e.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.e.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (!this.g) {
                this.g = true;
                T t = this.c;
                if (t == null && this.d) {
                    this.a.onError(new NoSuchElementException());
                    return;
                }
                if (t != null) {
                    this.a.onNext(t);
                }
                this.a.onComplete();
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.e, disposable)) {
                this.e = disposable;
                this.a.onSubscribe(this);
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.g) {
                RxJavaPlugins.onError(th);
            } else {
                this.g = true;
                this.a.onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            if (this.g) {
                return;
            }
            long j = this.f;
            if (j == this.b) {
                this.g = true;
                this.e.dispose();
                this.a.onNext(t);
                this.a.onComplete();
                return;
            }
            this.f = j + 1;
        }

        a(Observer<? super T> observer, long j, T t, boolean z) {
            this.a = observer;
            this.b = j;
            this.c = t;
            this.d = z;
        }
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new a(observer, this.a, this.b, this.c));
    }

    public a0(ObservableSource<T> observableSource, long j, T t, boolean z) {
        super(observableSource);
        this.a = j;
        this.b = t;
        this.c = z;
    }
}
