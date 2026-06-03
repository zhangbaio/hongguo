package io.reactivex.internal.operators.observable;

import com.bytedance.covode.number.Covode;
import io.reactivex.Notification;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class b<T> implements Iterable<T> {
    final ObservableSource<T> a;

    static {
        Covode.recordClassIndex(657104);
    }

    static final class a<T> extends io.reactivex.observers.b<Notification<T>> implements Iterator<T> {
        Notification<T> b;
        final Semaphore c = new Semaphore(0);
        final AtomicReference<Notification<T>> d = new AtomicReference<>();

        static {
            Covode.recordClassIndex(657105);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Read-only iterator.");
        }

        a() {
        }

        @Override // java.util.Iterator
        public T next() {
            if (hasNext()) {
                T value = this.b.getValue();
                this.b = null;
                return value;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            Notification<T> notification = this.b;
            if (notification != null && notification.isOnError()) {
                throw ExceptionHelper.wrapOrThrow(this.b.getError());
            }
            if (this.b == null) {
                try {
                    io.reactivex.internal.util.c.b();
                    this.c.acquire();
                    Notification<T> andSet = this.d.getAndSet(null);
                    this.b = andSet;
                    if (andSet.isOnError()) {
                        throw ExceptionHelper.wrapOrThrow(andSet.getError());
                    }
                } catch (InterruptedException e) {
                    dispose();
                    this.b = Notification.createOnError(e);
                    throw ExceptionHelper.wrapOrThrow(e);
                }
            }
            return this.b.isOnNext();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            RxJavaPlugins.onError(th);
        }

        @Override // io.reactivex.Observer
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onNext(Notification<T> notification) {
            boolean z;
            if (this.d.getAndSet(notification) == null) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                this.c.release();
            }
        }
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        a aVar = new a();
        Observable.wrap(this.a).materialize().subscribe(aVar);
        return aVar;
    }

    public b(ObservableSource<T> observableSource) {
        this.a = observableSource;
    }
}
