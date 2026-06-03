package io.reactivex.internal.operators.observable;

import com.bytedance.covode.number.Covode;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class ObservableCache<T> extends io.reactivex.internal.operators.observable.a<T, T> implements Observer<T> {
    static final CacheDisposable[] j;
    static final CacheDisposable[] k;
    final AtomicBoolean a;
    final int b;
    final AtomicReference<CacheDisposable<T>[]> c;
    public volatile long d;
    final a<T> e;
    a<T> f;
    int g;
    Throwable h;
    volatile boolean i;

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable disposable) {
    }

    static final class CacheDisposable<T> extends AtomicInteger implements Disposable {
        private static final long serialVersionUID = 6770240836423125754L;
        volatile boolean disposed;
        final Observer<? super T> downstream;
        long index;
        a<T> node;
        int offset;
        final ObservableCache<T> parent;

        static {
            Covode.recordClassIndex(657145);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.disposed;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (!this.disposed) {
                this.disposed = true;
                this.parent.c(this);
            }
        }

        CacheDisposable(Observer<? super T> observer, ObservableCache<T> observableCache) {
            this.downstream = observer;
            this.parent = observableCache;
            this.node = observableCache.e;
        }
    }

    static {
        Covode.recordClassIndex(657144);
        j = new CacheDisposable[0];
        k = new CacheDisposable[0];
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        this.i = true;
        for (CacheDisposable<T> cacheDisposable : this.c.getAndSet(k)) {
            d(cacheDisposable);
        }
    }

    static final class a<T> {
        final T[] a;
        volatile a<T> b;

        static {
            Covode.recordClassIndex(657146);
        }

        a(int i) {
            this.a = (T[]) new Object[i];
        }
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable th) {
        this.h = th;
        this.i = true;
        for (CacheDisposable<T> cacheDisposable : this.c.getAndSet(k)) {
            d(cacheDisposable);
        }
    }

    void b(CacheDisposable<T> cacheDisposable) {
        CacheDisposable<T>[] cacheDisposableArr;
        CacheDisposable[] cacheDisposableArr2;
        do {
            cacheDisposableArr = this.c.get();
            if (cacheDisposableArr == k) {
                return;
            }
            int length = cacheDisposableArr.length;
            cacheDisposableArr2 = new CacheDisposable[length + 1];
            System.arraycopy(cacheDisposableArr, 0, cacheDisposableArr2, 0, length);
            cacheDisposableArr2[length] = cacheDisposable;
        } while (!androidx.compose.animation.core.g1.a(this.c, cacheDisposableArr, cacheDisposableArr2));
    }

    void c(CacheDisposable<T> cacheDisposable) {
        CacheDisposable<T>[] cacheDisposableArr;
        CacheDisposable[] cacheDisposableArr2;
        do {
            cacheDisposableArr = this.c.get();
            int length = cacheDisposableArr.length;
            if (length == 0) {
                return;
            }
            int i = 0;
            while (true) {
                if (i < length) {
                    if (cacheDisposableArr[i] == cacheDisposable) {
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
                cacheDisposableArr2 = j;
            } else {
                CacheDisposable[] cacheDisposableArr3 = new CacheDisposable[length - 1];
                System.arraycopy(cacheDisposableArr, 0, cacheDisposableArr3, 0, i);
                System.arraycopy(cacheDisposableArr, i + 1, cacheDisposableArr3, i, (length - i) - 1);
                cacheDisposableArr2 = cacheDisposableArr3;
            }
        } while (!androidx.compose.animation.core.g1.a(this.c, cacheDisposableArr, cacheDisposableArr2));
    }

    @Override // io.reactivex.Observer
    public void onNext(T t) {
        int i = this.g;
        if (i == this.b) {
            a<T> aVar = new a<>(i);
            aVar.a[0] = t;
            this.g = 1;
            this.f.b = aVar;
            this.f = aVar;
        } else {
            this.f.a[i] = t;
            this.g = i + 1;
        }
        this.d++;
        for (CacheDisposable<T> cacheDisposable : this.c.get()) {
            d(cacheDisposable);
        }
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super T> observer) {
        CacheDisposable<T> cacheDisposable = new CacheDisposable<>(observer, this);
        observer.onSubscribe(cacheDisposable);
        b(cacheDisposable);
        if (!this.a.get() && this.a.compareAndSet(false, true)) {
            this.source.subscribe(this);
        } else {
            d(cacheDisposable);
        }
    }

    void d(CacheDisposable<T> cacheDisposable) {
        boolean z;
        if (cacheDisposable.getAndIncrement() != 0) {
            return;
        }
        long j2 = cacheDisposable.index;
        int i = cacheDisposable.offset;
        a<T> aVar = cacheDisposable.node;
        Observer<? super T> observer = cacheDisposable.downstream;
        int i2 = this.b;
        int i3 = 1;
        while (!cacheDisposable.disposed) {
            boolean z2 = this.i;
            if (this.d == j2) {
                z = true;
            } else {
                z = false;
            }
            if (z2 && z) {
                cacheDisposable.node = null;
                Throwable th = this.h;
                if (th != null) {
                    observer.onError(th);
                    return;
                } else {
                    observer.onComplete();
                    return;
                }
            }
            if (!z) {
                if (i == i2) {
                    aVar = aVar.b;
                    i = 0;
                }
                observer.onNext(aVar.a[i]);
                i++;
                j2++;
            } else {
                cacheDisposable.index = j2;
                cacheDisposable.offset = i;
                cacheDisposable.node = aVar;
                i3 = cacheDisposable.addAndGet(-i3);
                if (i3 == 0) {
                    return;
                }
            }
        }
        cacheDisposable.node = null;
    }

    public ObservableCache(Observable<T> observable, int i) {
        super(observable);
        this.b = i;
        this.a = new AtomicBoolean();
        a<T> aVar = new a<>(i);
        this.e = aVar;
        this.f = aVar;
        this.c = new AtomicReference<>(j);
    }
}
