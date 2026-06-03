package io.reactivex.internal.operators.observable;

import com.bytedance.covode.number.Covode;
import io.reactivex.Notification;
import io.reactivex.ObservableSource;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class d<T> implements Iterable<T> {
    final ObservableSource<T> a;

    static {
        Covode.recordClassIndex(657109);
    }

    static final class a<T> implements Iterator<T> {
        private final b<T> a;
        private final ObservableSource<T> b;
        private T c;
        private boolean d = true;
        private boolean e = true;
        private Throwable f;
        private boolean g;

        static {
            Covode.recordClassIndex(657110);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Read only iterator");
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            Throwable th = this.f;
            if (th == null) {
                if (!this.d) {
                    return false;
                }
                if (this.e && !b()) {
                    return false;
                }
                return true;
            }
            throw ExceptionHelper.wrapOrThrow(th);
        }

        @Override // java.util.Iterator
        public T next() {
            Throwable th = this.f;
            if (th == null) {
                if (hasNext()) {
                    this.e = true;
                    return this.c;
                }
                throw new NoSuchElementException("No more elements");
            }
            throw ExceptionHelper.wrapOrThrow(th);
        }

        private boolean b() {
            if (!this.g) {
                this.g = true;
                this.a.d();
                new x0(this.b).subscribe(this.a);
            }
            try {
                Notification<T> e = this.a.e();
                if (e.isOnNext()) {
                    this.e = false;
                    this.c = e.getValue();
                    return true;
                }
                this.d = false;
                if (e.isOnComplete()) {
                    return false;
                }
                Throwable error = e.getError();
                this.f = error;
                throw ExceptionHelper.wrapOrThrow(error);
            } catch (InterruptedException e2) {
                this.a.dispose();
                this.f = e2;
                throw ExceptionHelper.wrapOrThrow(e2);
            }
        }

        a(ObservableSource<T> observableSource, b<T> bVar) {
            this.b = observableSource;
            this.a = bVar;
        }
    }

    static final class b<T> extends io.reactivex.observers.b<Notification<T>> {
        private final BlockingQueue<Notification<T>> b = new ArrayBlockingQueue(1);
        final AtomicInteger c = new AtomicInteger();

        static {
            Covode.recordClassIndex(657111);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
        }

        void d() {
            this.c.set(1);
        }

        public Notification<T> e() throws InterruptedException {
            d();
            io.reactivex.internal.util.c.b();
            return this.b.take();
        }

        b() {
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            RxJavaPlugins.onError(th);
        }

        @Override // io.reactivex.Observer
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onNext(Notification<T> notification) {
            if (this.c.getAndSet(0) == 1 || !notification.isOnNext()) {
                while (!this.b.offer(notification)) {
                    Notification<T> poll = this.b.poll();
                    if (poll != null && !poll.isOnNext()) {
                        notification = poll;
                    }
                }
            }
        }
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        return new a(this.a, new b());
    }

    public d(ObservableSource<T> observableSource) {
        this.a = observableSource;
    }
}
