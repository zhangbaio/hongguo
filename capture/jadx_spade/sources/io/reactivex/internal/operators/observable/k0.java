package io.reactivex.internal.operators.observable;

import com.bytedance.covode.number.Covode;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.Iterator;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class k0<T> extends Observable<T> {
    final Iterable<? extends T> a;

    static {
        Covode.recordClassIndex(657235);
    }

    static final class a<T> extends io.reactivex.internal.observers.b<T> {
        final Observer<? super T> a;
        final Iterator<? extends T> b;
        volatile boolean c;
        boolean d;
        boolean e;
        boolean f;

        static {
            Covode.recordClassIndex(657236);
        }

        @Override // nm6.j
        public void clear() {
            this.e = true;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.c = true;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.c;
        }

        @Override // nm6.j
        public boolean isEmpty() {
            return this.e;
        }

        @Override // nm6.j
        public T poll() {
            if (this.e) {
                return null;
            }
            if (this.f) {
                if (!this.b.hasNext()) {
                    this.e = true;
                    return null;
                }
            } else {
                this.f = true;
            }
            return (T) ObjectHelper.requireNonNull(this.b.next(), "The iterator returned a null value");
        }

        void a() {
            while (!isDisposed()) {
                try {
                    this.a.onNext(ObjectHelper.requireNonNull(this.b.next(), "The iterator returned a null value"));
                    if (isDisposed()) {
                        return;
                    }
                    try {
                        if (!this.b.hasNext()) {
                            if (!isDisposed()) {
                                this.a.onComplete();
                                return;
                            }
                            return;
                        }
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        this.a.onError(th);
                        return;
                    }
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.a.onError(th2);
                    return;
                }
            }
        }

        @Override // nm6.f
        public int requestFusion(int i) {
            if ((i & 1) != 0) {
                this.d = true;
                return 1;
            }
            return 0;
        }

        a(Observer<? super T> observer, Iterator<? extends T> it2) {
            this.a = observer;
            this.b = it2;
        }
    }

    public k0(Iterable<? extends T> iterable) {
        this.a = iterable;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        try {
            Iterator<? extends T> it2 = this.a.iterator();
            try {
                if (!it2.hasNext()) {
                    EmptyDisposable.complete(observer);
                    return;
                }
                a aVar = new a(observer, it2);
                observer.onSubscribe(aVar);
                if (!aVar.d) {
                    aVar.a();
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                EmptyDisposable.error(th, observer);
            }
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            EmptyDisposable.error(th2, observer);
        }
    }
}
