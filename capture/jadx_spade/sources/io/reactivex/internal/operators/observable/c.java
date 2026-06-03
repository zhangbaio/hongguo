package io.reactivex.internal.operators.observable;

import com.bytedance.covode.number.Covode;
import io.reactivex.ObservableSource;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class c<T> implements Iterable<T> {
    final ObservableSource<T> a;
    final T b;

    static {
        Covode.recordClassIndex(657106);
    }

    static final class a<T> extends io.reactivex.observers.a<T> {
        volatile Object b;

        static {
            Covode.recordClassIndex(657107);
        }

        /* renamed from: io.reactivex.internal.operators.observable.c$a$a, reason: collision with other inner class name */
        final class C0180a implements Iterator<T> {
            private Object a;

            static {
                Covode.recordClassIndex(657108);
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("Read only iterator");
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                this.a = a.this.b;
                return !NotificationLite.isComplete(r0);
            }

            @Override // java.util.Iterator
            public T next() {
                try {
                    if (this.a == null) {
                        this.a = a.this.b;
                    }
                    if (!NotificationLite.isComplete(this.a)) {
                        if (!NotificationLite.isError(this.a)) {
                            return (T) NotificationLite.getValue(this.a);
                        }
                        throw ExceptionHelper.wrapOrThrow(NotificationLite.getError(this.a));
                    }
                    throw new NoSuchElementException();
                } finally {
                    this.a = null;
                }
            }

            C0180a() {
            }
        }

        public a<T>.C0180a b() {
            return new C0180a();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.b = NotificationLite.complete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.b = NotificationLite.error(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            this.b = NotificationLite.next(t);
        }

        a(T t) {
            this.b = NotificationLite.next(t);
        }
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        a aVar = new a(this.b);
        this.a.subscribe(aVar);
        return aVar.b();
    }

    public c(ObservableSource<T> observableSource, T t) {
        this.a = observableSource;
        this.b = t;
    }
}
