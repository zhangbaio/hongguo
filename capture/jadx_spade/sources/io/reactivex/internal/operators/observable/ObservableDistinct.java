package io.reactivex.internal.operators.observable;

import com.bytedance.covode.number.Covode;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Collection;
import java.util.concurrent.Callable;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class ObservableDistinct<T, K> extends io.reactivex.internal.operators.observable.a<T, T> {
    final Callable<? extends Collection<? super K>> collectionSupplier;
    final Function<? super T, K> keySelector;

    static {
        Covode.recordClassIndex(657193);
    }

    static final class a<T, K> extends io.reactivex.internal.observers.a<T, T> {
        final Collection<? super K> f;
        final Function<? super T, K> g;

        static {
            Covode.recordClassIndex(657194);
        }

        @Override // io.reactivex.internal.observers.a, nm6.j
        public void clear() {
            this.f.clear();
            super.clear();
        }

        @Override // io.reactivex.internal.observers.a, io.reactivex.Observer
        public void onComplete() {
            if (!this.d) {
                this.d = true;
                this.f.clear();
                this.a.onComplete();
            }
        }

        @Override // nm6.j
        public T poll() throws Exception {
            T poll;
            do {
                poll = this.c.poll();
                if (poll == null) {
                    break;
                }
            } while (!this.f.add((Object) ObjectHelper.requireNonNull(this.g.apply(poll), "The keySelector returned a null key")));
            return poll;
        }

        @Override // nm6.f
        public int requestFusion(int i) {
            return d(i);
        }

        @Override // io.reactivex.internal.observers.a, io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.d) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.d = true;
            this.f.clear();
            this.a.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            if (this.d) {
                return;
            }
            if (this.e == 0) {
                try {
                    if (this.f.add(ObjectHelper.requireNonNull(this.g.apply(t), "The keySelector returned a null key"))) {
                        this.a.onNext(t);
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    c(th);
                    return;
                }
            }
            this.a.onNext(null);
        }

        a(Observer<? super T> observer, Function<? super T, K> function, Collection<? super K> collection) {
            super(observer);
            this.g = function;
            this.f = collection;
        }
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super T> observer) {
        try {
            this.source.subscribe(new a(observer, this.keySelector, (Collection) ObjectHelper.requireNonNull(this.collectionSupplier.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.")));
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptyDisposable.error(th, observer);
        }
    }

    public ObservableDistinct(ObservableSource<T> observableSource, Function<? super T, K> function, Callable<? extends Collection<? super K>> callable) {
        super(observableSource);
        this.keySelector = function;
        this.collectionSupplier = callable;
    }
}
