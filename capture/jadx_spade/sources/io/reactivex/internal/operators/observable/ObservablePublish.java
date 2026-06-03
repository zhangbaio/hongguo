package io.reactivex.internal.operators.observable;

import com.bytedance.covode.number.Covode;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.HasUpstreamObservableSource;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class ObservablePublish<T> extends ConnectableObservable<T> implements HasUpstreamObservableSource<T> {
    final AtomicReference<a<T>> current;
    final ObservableSource<T> onSubscribe;
    final ObservableSource<T> source;

    static {
        Covode.recordClassIndex(657308);
    }

    @Override // io.reactivex.internal.fuseable.HasUpstreamObservableSource
    public ObservableSource<T> source() {
        return this.source;
    }

    static final class InnerDisposable<T> extends AtomicReference<Object> implements Disposable {
        private static final long serialVersionUID = -1100270633763673112L;
        final Observer<? super T> child;

        static {
            Covode.recordClassIndex(657309);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            Object andSet = getAndSet(this);
            if (andSet != null && andSet != this) {
                ((a) andSet).b(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            if (get() == this) {
                return true;
            }
            return false;
        }

        InnerDisposable(Observer<? super T> observer) {
            this.child = observer;
        }

        void setParent(a<T> aVar) {
            if (!compareAndSet(null, aVar)) {
                aVar.b(this);
            }
        }
    }

    static final class a<T> implements Observer<T>, Disposable {
        static final InnerDisposable[] e;
        static final InnerDisposable[] f;
        final AtomicReference<a<T>> a;
        final AtomicReference<Disposable> d = new AtomicReference<>();
        final AtomicReference<InnerDisposable<T>[]> b = new AtomicReference<>(e);
        final AtomicBoolean c = new AtomicBoolean();

        static {
            Covode.recordClassIndex(657310);
            e = new InnerDisposable[0];
            f = new InnerDisposable[0];
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            if (this.b.get() == f) {
                return true;
            }
            return false;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            AtomicReference<InnerDisposable<T>[]> atomicReference = this.b;
            InnerDisposable<T>[] innerDisposableArr = f;
            if (atomicReference.getAndSet(innerDisposableArr) != innerDisposableArr) {
                androidx.compose.animation.core.g1.a(this.a, this, (Object) null);
                DisposableHelper.dispose(this.d);
            }
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            androidx.compose.animation.core.g1.a(this.a, this, (Object) null);
            for (InnerDisposable<T> innerDisposable : this.b.getAndSet(f)) {
                innerDisposable.child.onComplete();
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.d, disposable);
        }

        a(AtomicReference<a<T>> atomicReference) {
            this.a = atomicReference;
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            for (InnerDisposable<T> innerDisposable : this.b.get()) {
                innerDisposable.child.onNext(t);
            }
        }

        boolean a(InnerDisposable<T> innerDisposable) {
            InnerDisposable<T>[] innerDisposableArr;
            InnerDisposable[] innerDisposableArr2;
            do {
                innerDisposableArr = this.b.get();
                if (innerDisposableArr == f) {
                    return false;
                }
                int length = innerDisposableArr.length;
                innerDisposableArr2 = new InnerDisposable[length + 1];
                System.arraycopy(innerDisposableArr, 0, innerDisposableArr2, 0, length);
                innerDisposableArr2[length] = innerDisposable;
            } while (!androidx.compose.animation.core.g1.a(this.b, innerDisposableArr, innerDisposableArr2));
            return true;
        }

        void b(InnerDisposable<T> innerDisposable) {
            InnerDisposable<T>[] innerDisposableArr;
            InnerDisposable[] innerDisposableArr2;
            do {
                innerDisposableArr = this.b.get();
                int length = innerDisposableArr.length;
                if (length == 0) {
                    return;
                }
                int i = 0;
                while (true) {
                    if (i < length) {
                        if (innerDisposableArr[i].equals(innerDisposable)) {
                            break;
                        } else {
                            i++;
                        }
                    } else {
                        i = -1;
                        break;
                    }
                }
                if (i < 0) {
                    return;
                }
                if (length == 1) {
                    innerDisposableArr2 = e;
                } else {
                    InnerDisposable[] innerDisposableArr3 = new InnerDisposable[length - 1];
                    System.arraycopy(innerDisposableArr, 0, innerDisposableArr3, 0, i);
                    System.arraycopy(innerDisposableArr, i + 1, innerDisposableArr3, i, (length - i) - 1);
                    innerDisposableArr2 = innerDisposableArr3;
                }
            } while (!androidx.compose.animation.core.g1.a(this.b, innerDisposableArr, innerDisposableArr2));
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            androidx.compose.animation.core.g1.a(this.a, this, (Object) null);
            InnerDisposable<T>[] andSet = this.b.getAndSet(f);
            if (andSet.length != 0) {
                for (InnerDisposable<T> innerDisposable : andSet) {
                    innerDisposable.child.onError(th);
                }
                return;
            }
            RxJavaPlugins.onError(th);
        }
    }

    static final class b<T> implements ObservableSource<T> {
        private final AtomicReference<a<T>> a;

        static {
            Covode.recordClassIndex(657311);
        }

        b(AtomicReference<a<T>> atomicReference) {
            this.a = atomicReference;
        }

        @Override // io.reactivex.ObservableSource
        public void subscribe(Observer<? super T> observer) {
            InnerDisposable innerDisposable = new InnerDisposable(observer);
            observer.onSubscribe(innerDisposable);
            while (true) {
                a<T> aVar = this.a.get();
                if (aVar == null || aVar.isDisposed()) {
                    a<T> aVar2 = new a<>(this.a);
                    if (androidx.compose.animation.core.g1.a(this.a, aVar, aVar2)) {
                        aVar = aVar2;
                    } else {
                        continue;
                    }
                }
                if (aVar.a(innerDisposable)) {
                    innerDisposable.setParent(aVar);
                    return;
                }
            }
        }
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super T> observer) {
        this.onSubscribe.subscribe(observer);
    }

    public static <T> ConnectableObservable<T> create(ObservableSource<T> observableSource) {
        AtomicReference atomicReference = new AtomicReference();
        return RxJavaPlugins.onAssembly((ConnectableObservable) new ObservablePublish(new b(atomicReference), observableSource, atomicReference));
    }

    @Override // io.reactivex.observables.ConnectableObservable
    public void connect(Consumer<? super Disposable> consumer) {
        a<T> aVar;
        while (true) {
            aVar = this.current.get();
            if (aVar != null && !aVar.isDisposed()) {
                break;
            }
            a<T> aVar2 = new a<>(this.current);
            if (androidx.compose.animation.core.g1.a(this.current, aVar, aVar2)) {
                aVar = aVar2;
                break;
            }
        }
        boolean z = false;
        if (!aVar.c.get() && aVar.c.compareAndSet(false, true)) {
            z = true;
        }
        try {
            consumer.accept(aVar);
            if (z) {
                this.source.subscribe(aVar);
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            throw ExceptionHelper.wrapOrThrow(th);
        }
    }

    private ObservablePublish(ObservableSource<T> observableSource, ObservableSource<T> observableSource2, AtomicReference<a<T>> atomicReference) {
        this.onSubscribe = observableSource;
        this.source = observableSource2;
        this.current = atomicReference;
    }
}
