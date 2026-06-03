package io.reactivex.internal.operators.flowable;

import com.bytedance.covode.number.Covode;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.functions.Consumer;
import org.reactivestreams.Subscriber;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class u<T> extends io.reactivex.internal.operators.flowable.a<T, T> {
    final Consumer<? super T> b;

    static {
        Covode.recordClassIndex(656582);
    }

    static final class a<T> extends io.reactivex.internal.subscribers.a<T, T> {
        final Consumer<? super T> f;

        static {
            Covode.recordClassIndex(656583);
        }

        @Override // nm6.j
        public T poll() throws Exception {
            T poll = this.c.poll();
            if (poll != null) {
                this.f.accept(poll);
            }
            return poll;
        }

        @Override // nm6.f
        public int requestFusion(int i) {
            return d(i);
        }

        public void onNext(T t) {
            this.a.onNext(t);
            if (this.e == 0) {
                try {
                    this.f.accept(t);
                } catch (Throwable th) {
                    c(th);
                }
            }
        }

        @Override // nm6.a
        public boolean tryOnNext(T t) {
            boolean tryOnNext = this.a.tryOnNext(t);
            try {
                this.f.accept(t);
            } catch (Throwable th) {
                c(th);
            }
            return tryOnNext;
        }

        a(nm6.a<? super T> aVar, Consumer<? super T> consumer) {
            super(aVar);
            this.f = consumer;
        }
    }

    static final class b<T> extends io.reactivex.internal.subscribers.b<T, T> {
        final Consumer<? super T> f;

        static {
            Covode.recordClassIndex(656584);
        }

        @Override // nm6.j
        public T poll() throws Exception {
            T poll = this.c.poll();
            if (poll != null) {
                this.f.accept(poll);
            }
            return poll;
        }

        @Override // nm6.f
        public int requestFusion(int i) {
            return d(i);
        }

        public void onNext(T t) {
            if (this.d) {
                return;
            }
            this.a.onNext(t);
            if (this.e == 0) {
                try {
                    this.f.accept(t);
                } catch (Throwable th) {
                    c(th);
                }
            }
        }

        b(Subscriber<? super T> subscriber, Consumer<? super T> consumer) {
            super(subscriber);
            this.f = consumer;
        }
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        if (subscriber instanceof nm6.a) {
            this.a.subscribe((FlowableSubscriber) new a((nm6.a) subscriber, this.b));
        } else {
            this.a.subscribe((FlowableSubscriber) new b(subscriber, this.b));
        }
    }

    public u(Flowable<T> flowable, Consumer<? super T> consumer) {
        super(flowable);
        this.b = consumer;
    }
}
