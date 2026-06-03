package io.reactivex.internal.operators.flowable;

import com.bytedance.covode.number.Covode;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.functions.Predicate;
import org.reactivestreams.Subscriber;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class b0<T> extends io.reactivex.internal.operators.flowable.a<T, T> {
    final Predicate<? super T> b;

    static {
        Covode.recordClassIndex(656601);
    }

    static final class a<T> extends io.reactivex.internal.subscribers.a<T, T> {
        final Predicate<? super T> f;

        static {
            Covode.recordClassIndex(656602);
        }

        @Override // nm6.j
        public T poll() throws Exception {
            nm6.g<T> gVar = this.c;
            Predicate<? super T> predicate = this.f;
            while (true) {
                T poll = gVar.poll();
                if (poll == null) {
                    return null;
                }
                if (predicate.test(poll)) {
                    return poll;
                }
                if (this.e == 2) {
                    gVar.request(1L);
                }
            }
        }

        @Override // nm6.f
        public int requestFusion(int i) {
            return d(i);
        }

        public void onNext(T t) {
            if (!tryOnNext(t)) {
                this.b.request(1L);
            }
        }

        @Override // nm6.a
        public boolean tryOnNext(T t) {
            if (this.d) {
                return false;
            }
            if (this.e != 0) {
                return this.a.tryOnNext(null);
            }
            try {
                if (!this.f.test(t) || !this.a.tryOnNext(t)) {
                    return false;
                }
                return true;
            } catch (Throwable th) {
                c(th);
                return true;
            }
        }

        a(nm6.a<? super T> aVar, Predicate<? super T> predicate) {
            super(aVar);
            this.f = predicate;
        }
    }

    static final class b<T> extends io.reactivex.internal.subscribers.b<T, T> implements nm6.a<T> {
        final Predicate<? super T> f;

        static {
            Covode.recordClassIndex(656603);
        }

        @Override // nm6.j
        public T poll() throws Exception {
            nm6.g<T> gVar = this.c;
            Predicate<? super T> predicate = this.f;
            while (true) {
                T poll = gVar.poll();
                if (poll == null) {
                    return null;
                }
                if (predicate.test(poll)) {
                    return poll;
                }
                if (this.e == 2) {
                    gVar.request(1L);
                }
            }
        }

        @Override // nm6.f
        public int requestFusion(int i) {
            return d(i);
        }

        public void onNext(T t) {
            if (!tryOnNext(t)) {
                this.b.request(1L);
            }
        }

        @Override // nm6.a
        public boolean tryOnNext(T t) {
            if (this.d) {
                return false;
            }
            if (this.e != 0) {
                this.a.onNext((Object) null);
                return true;
            }
            try {
                boolean test = this.f.test(t);
                if (test) {
                    this.a.onNext(t);
                }
                return test;
            } catch (Throwable th) {
                c(th);
                return true;
            }
        }

        b(Subscriber<? super T> subscriber, Predicate<? super T> predicate) {
            super(subscriber);
            this.f = predicate;
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

    public b0(Flowable<T> flowable, Predicate<? super T> predicate) {
        super(flowable);
        this.b = predicate;
    }
}
