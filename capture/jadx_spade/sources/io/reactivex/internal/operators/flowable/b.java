package io.reactivex.internal.operators.flowable;

import com.bytedance.covode.number.Covode;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Notification;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class b<T> implements Iterable<T> {
    final Publisher<? extends T> a;

    static {
        Covode.recordClassIndex(656475);
    }

    static final class a<T> extends io.reactivex.subscribers.b<Notification<T>> implements Iterator<T> {
        final Semaphore b = new Semaphore(0);
        final AtomicReference<Notification<T>> c = new AtomicReference<>();
        Notification<T> d;

        static {
            Covode.recordClassIndex(656476);
        }

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
            if (hasNext() && this.d.isOnNext()) {
                T value = this.d.getValue();
                this.d = null;
                return value;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            Notification<T> notification = this.d;
            if (notification != null && notification.isOnError()) {
                throw ExceptionHelper.wrapOrThrow(this.d.getError());
            }
            Notification<T> notification2 = this.d;
            if ((notification2 == null || notification2.isOnNext()) && this.d == null) {
                try {
                    io.reactivex.internal.util.c.b();
                    this.b.acquire();
                    Notification<T> andSet = this.c.getAndSet(null);
                    this.d = andSet;
                    if (andSet.isOnError()) {
                        throw ExceptionHelper.wrapOrThrow(andSet.getError());
                    }
                } catch (InterruptedException e) {
                    dispose();
                    this.d = Notification.createOnError(e);
                    throw ExceptionHelper.wrapOrThrow(e);
                }
            }
            return this.d.isOnNext();
        }

        public void onError(Throwable th) {
            RxJavaPlugins.onError(th);
        }

        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void onNext(Notification<T> notification) {
            boolean z;
            if (this.c.getAndSet(notification) == null) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                this.b.release();
            }
        }
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        a aVar = new a();
        Flowable.fromPublisher(this.a).materialize().subscribe((FlowableSubscriber<? super Notification<T>>) aVar);
        return aVar;
    }

    public b(Publisher<? extends T> publisher) {
        this.a = publisher;
    }
}
