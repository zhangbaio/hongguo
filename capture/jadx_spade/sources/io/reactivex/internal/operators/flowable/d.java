package io.reactivex.internal.operators.flowable;

import com.bytedance.covode.number.Covode;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Notification;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class d<T> implements Iterable<T> {
    final Publisher<? extends T> a;

    static {
        Covode.recordClassIndex(656480);
    }

    static final class a<T> implements Iterator<T> {
        private final b<T> a;
        private final Publisher<? extends T> b;
        private T c;
        private boolean d = true;
        private boolean e = true;
        private Throwable f;
        private boolean g;

        static {
            Covode.recordClassIndex(656481);
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
            try {
                if (!this.g) {
                    this.g = true;
                    this.a.e();
                    Flowable.fromPublisher(this.b).materialize().subscribe((FlowableSubscriber<? super Notification<T>>) this.a);
                }
                Notification<T> f = this.a.f();
                if (f.isOnNext()) {
                    this.e = false;
                    this.c = f.getValue();
                    return true;
                }
                this.d = false;
                if (f.isOnComplete()) {
                    return false;
                }
                if (f.isOnError()) {
                    Throwable error = f.getError();
                    this.f = error;
                    throw ExceptionHelper.wrapOrThrow(error);
                }
                throw new IllegalStateException("Should not reach here");
            } catch (InterruptedException e) {
                this.a.dispose();
                this.f = e;
                throw ExceptionHelper.wrapOrThrow(e);
            }
        }

        a(Publisher<? extends T> publisher, b<T> bVar) {
            this.b = publisher;
            this.a = bVar;
        }
    }

    static final class b<T> extends io.reactivex.subscribers.b<Notification<T>> {
        private final BlockingQueue<Notification<T>> b = new ArrayBlockingQueue(1);
        final AtomicInteger c = new AtomicInteger();

        static {
            Covode.recordClassIndex(656482);
        }

        public void onComplete() {
        }

        void e() {
            this.c.set(1);
        }

        public Notification<T> f() throws InterruptedException {
            e();
            io.reactivex.internal.util.c.b();
            return this.b.take();
        }

        b() {
        }

        public void onError(Throwable th) {
            RxJavaPlugins.onError(th);
        }

        /* renamed from: d, reason: merged with bridge method [inline-methods] */
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

    public d(Publisher<? extends T> publisher) {
        this.a = publisher;
    }
}
