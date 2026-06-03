package io.reactivex.internal.operators.flowable;

import com.bytedance.covode.number.Covode;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import org.reactivestreams.Subscriber;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class o0<T, U> extends io.reactivex.internal.operators.flowable.a<T, U> {
    final Function<? super T, ? extends U> b;

    static {
        Covode.recordClassIndex(656684);
    }

    static final class a<T, U> extends io.reactivex.internal.subscribers.a<T, U> {
        final Function<? super T, ? extends U> f;

        static {
            Covode.recordClassIndex(656685);
        }

        @Override // nm6.j
        public U poll() throws Exception {
            T poll = this.c.poll();
            if (poll != null) {
                return (U) ObjectHelper.requireNonNull(this.f.apply(poll), "The mapper function returned a null value.");
            }
            return null;
        }

        @Override // nm6.f
        public int requestFusion(int i) {
            return d(i);
        }

        @Override // nm6.a
        public boolean tryOnNext(T t) {
            if (this.d) {
                return false;
            }
            try {
                return this.a.tryOnNext(ObjectHelper.requireNonNull(this.f.apply(t), "The mapper function returned a null value."));
            } catch (Throwable th) {
                c(th);
                return true;
            }
        }

        public void onNext(T t) {
            if (this.d) {
                return;
            }
            if (this.e != 0) {
                this.a.onNext((Object) null);
                return;
            }
            try {
                this.a.onNext(ObjectHelper.requireNonNull(this.f.apply(t), "The mapper function returned a null value."));
            } catch (Throwable th) {
                c(th);
            }
        }

        a(nm6.a<? super U> aVar, Function<? super T, ? extends U> function) {
            super(aVar);
            this.f = function;
        }
    }

    static final class b<T, U> extends io.reactivex.internal.subscribers.b<T, U> {
        final Function<? super T, ? extends U> f;

        static {
            Covode.recordClassIndex(656686);
        }

        @Override // nm6.j
        public U poll() throws Exception {
            T poll = this.c.poll();
            if (poll != null) {
                return (U) ObjectHelper.requireNonNull(this.f.apply(poll), "The mapper function returned a null value.");
            }
            return null;
        }

        @Override // nm6.f
        public int requestFusion(int i) {
            return d(i);
        }

        public void onNext(T t) {
            if (this.d) {
                return;
            }
            if (this.e != 0) {
                this.a.onNext((Object) null);
                return;
            }
            try {
                this.a.onNext(ObjectHelper.requireNonNull(this.f.apply(t), "The mapper function returned a null value."));
            } catch (Throwable th) {
                c(th);
            }
        }

        b(Subscriber<? super U> subscriber, Function<? super T, ? extends U> function) {
            super(subscriber);
            this.f = function;
        }
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super U> subscriber) {
        if (subscriber instanceof nm6.a) {
            this.a.subscribe((FlowableSubscriber) new a((nm6.a) subscriber, this.b));
        } else {
            this.a.subscribe((FlowableSubscriber) new b(subscriber, this.b));
        }
    }

    public o0(Flowable<T> flowable, Function<? super T, ? extends U> function) {
        super(flowable);
        this.b = function;
    }
}
