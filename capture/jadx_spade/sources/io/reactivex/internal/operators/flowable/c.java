package io.reactivex.internal.operators.flowable;

import com.bytedance.covode.number.Covode;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class c<T> implements Iterable<T> {
    final Flowable<T> a;
    final T b;

    static {
        Covode.recordClassIndex(656477);
    }

    static final class a<T> extends io.reactivex.subscribers.a<T> {
        volatile Object b;

        static {
            Covode.recordClassIndex(656478);
        }

        /* renamed from: io.reactivex.internal.operators.flowable.c$a$a, reason: collision with other inner class name */
        final class C0177a implements Iterator<T> {
            private Object a;

            static {
                Covode.recordClassIndex(656479);
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

            C0177a() {
            }
        }

        public a<T>.C0177a c() {
            return new C0177a();
        }

        public void onComplete() {
            this.b = NotificationLite.complete();
        }

        public void onError(Throwable th) {
            this.b = NotificationLite.error(th);
        }

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
        this.a.subscribe((FlowableSubscriber) aVar);
        return aVar.c();
    }

    public c(Flowable<T> flowable, T t) {
        this.a = flowable;
        this.b = t;
    }
}
