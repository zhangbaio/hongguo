package io.reactivex.internal.operators.observable;

import com.bytedance.covode.number.Covode;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subjects.UnicastSubject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class u1<T, B, V> extends io.reactivex.internal.operators.observable.a<T, Observable<T>> {
    final ObservableSource<B> a;
    final Function<? super B, ? extends ObservableSource<V>> b;
    final int c;

    static {
        Covode.recordClassIndex(657453);
    }

    static final class c<T, B, V> extends io.reactivex.internal.observers.j<T, Object, Observable<T>> implements Disposable {
        final ObservableSource<B> g;
        final Function<? super B, ? extends ObservableSource<V>> h;
        final int i;
        final CompositeDisposable j;
        Disposable k;
        final AtomicReference<Disposable> l;
        final List<UnicastSubject<T>> m;
        final AtomicLong n;

        static {
            Covode.recordClassIndex(657456);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.d = true;
        }

        @Override // io.reactivex.internal.observers.j, io.reactivex.internal.util.h
        public void e(Observer<? super Observable<T>> observer, Object obj) {
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.d;
        }

        void k() {
            this.j.dispose();
            DisposableHelper.dispose(this.l);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.e) {
                return;
            }
            this.e = true;
            if (f()) {
                l();
            }
            if (this.n.decrementAndGet() == 0) {
                this.j.dispose();
            }
            this.b.onComplete();
        }

        /* JADX WARN: Multi-variable type inference failed */
        void l() {
            boolean z;
            MpscLinkedQueue mpscLinkedQueue = (MpscLinkedQueue) this.c;
            Observer<? super V> observer = this.b;
            List<UnicastSubject<T>> list = this.m;
            int i = 1;
            while (true) {
                boolean z2 = this.e;
                Object poll = mpscLinkedQueue.poll();
                if (poll == null) {
                    z = true;
                } else {
                    z = false;
                }
                if (z2 && z) {
                    k();
                    Throwable th = this.f;
                    if (th != null) {
                        Iterator<UnicastSubject<T>> it2 = list.iterator();
                        while (it2.hasNext()) {
                            it2.next().onError(th);
                        }
                    } else {
                        Iterator<UnicastSubject<T>> it4 = list.iterator();
                        while (it4.hasNext()) {
                            it4.next().onComplete();
                        }
                    }
                    list.clear();
                    return;
                }
                if (z) {
                    i = d(-i);
                    if (i == 0) {
                        return;
                    }
                } else if (poll instanceof d) {
                    d dVar = (d) poll;
                    UnicastSubject<T> unicastSubject = dVar.a;
                    if (unicastSubject != null) {
                        if (list.remove(unicastSubject)) {
                            dVar.a.onComplete();
                            if (this.n.decrementAndGet() == 0) {
                                k();
                                return;
                            }
                        } else {
                            continue;
                        }
                    } else if (!this.d) {
                        UnicastSubject<T> c = UnicastSubject.c(this.i);
                        list.add(c);
                        observer.onNext(c);
                        try {
                            ObservableSource observableSource = (ObservableSource) ObjectHelper.requireNonNull(this.h.apply(dVar.b), "The ObservableSource supplied is null");
                            a aVar = new a(this, c);
                            if (this.j.add(aVar)) {
                                this.n.getAndIncrement();
                                observableSource.subscribe(aVar);
                            }
                        } catch (Throwable th2) {
                            Exceptions.throwIfFatal(th2);
                            this.d = true;
                            observer.onError(th2);
                        }
                    }
                } else {
                    Iterator<UnicastSubject<T>> it5 = list.iterator();
                    while (it5.hasNext()) {
                        it5.next().onNext(NotificationLite.getValue(poll));
                    }
                }
            }
        }

        void m(Throwable th) {
            this.k.dispose();
            this.j.dispose();
            onError(th);
        }

        void j(a<T, V> aVar) {
            this.j.delete(aVar);
            this.c.offer(new d(aVar.c, null));
            if (f()) {
                l();
            }
        }

        void n(B b) {
            this.c.offer(new d(null, b));
            if (f()) {
                l();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.e) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.f = th;
            this.e = true;
            if (f()) {
                l();
            }
            if (this.n.decrementAndGet() == 0) {
                this.j.dispose();
            }
            this.b.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            if (g()) {
                Iterator<UnicastSubject<T>> it2 = this.m.iterator();
                while (it2.hasNext()) {
                    it2.next().onNext(t);
                }
                if (d(-1) == 0) {
                    return;
                }
            } else {
                this.c.offer(NotificationLite.next(t));
                if (!f()) {
                    return;
                }
            }
            l();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.k, disposable)) {
                this.k = disposable;
                this.b.onSubscribe(this);
                if (this.d) {
                    return;
                }
                b bVar = new b(this);
                if (androidx.compose.animation.core.g1.a(this.l, (Object) null, bVar)) {
                    this.n.getAndIncrement();
                    this.g.subscribe(bVar);
                }
            }
        }

        c(Observer<? super Observable<T>> observer, ObservableSource<B> observableSource, Function<? super B, ? extends ObservableSource<V>> function, int i) {
            super(observer, new MpscLinkedQueue());
            this.l = new AtomicReference<>();
            AtomicLong atomicLong = new AtomicLong();
            this.n = atomicLong;
            this.g = observableSource;
            this.h = function;
            this.i = i;
            this.j = new CompositeDisposable();
            this.m = new ArrayList();
            atomicLong.lazySet(1L);
        }
    }

    static final class b<T, B> extends io.reactivex.observers.b<B> {
        final c<T, B, ?> b;

        static {
            Covode.recordClassIndex(657455);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.b.onComplete();
        }

        b(c<T, B, ?> cVar) {
            this.b = cVar;
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.b.m(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(B b) {
            this.b.n(b);
        }
    }

    static final class a<T, V> extends io.reactivex.observers.b<V> {
        final c<T, ?, V> b;
        final UnicastSubject<T> c;
        boolean d;

        static {
            Covode.recordClassIndex(657454);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.d) {
                return;
            }
            this.d = true;
            this.b.j(this);
        }

        @Override // io.reactivex.Observer
        public void onNext(V v) {
            dispose();
            onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.d) {
                RxJavaPlugins.onError(th);
            } else {
                this.d = true;
                this.b.m(th);
            }
        }

        a(c<T, ?, V> cVar, UnicastSubject<T> unicastSubject) {
            this.b = cVar;
            this.c = unicastSubject;
        }
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super Observable<T>> observer) {
        this.source.subscribe(new c(new io.reactivex.observers.d(observer), this.a, this.b, this.c));
    }

    static final class d<T, B> {
        final UnicastSubject<T> a;
        final B b;

        static {
            Covode.recordClassIndex(657457);
        }

        d(UnicastSubject<T> unicastSubject, B b) {
            this.a = unicastSubject;
            this.b = b;
        }
    }

    public u1(ObservableSource<T> observableSource, ObservableSource<B> observableSource2, Function<? super B, ? extends ObservableSource<V>> function, int i) {
        super(observableSource);
        this.a = observableSource2;
        this.b = function;
        this.c = i;
    }
}
