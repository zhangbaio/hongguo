package io.reactivex.internal.operators.flowable;

import com.bytedance.covode.number.Covode;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Collection;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscriber;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class s<T, K> extends io.reactivex.internal.operators.flowable.a<T, T> {
    final Function<? super T, K> b;
    final Callable<? extends Collection<? super K>> c;

    static {
        Covode.recordClassIndex(656577);
    }

    static final class a<T, K> extends io.reactivex.internal.subscribers.b<T, T> {
        final Collection<? super K> f;
        final Function<? super T, K> g;

        static {
            Covode.recordClassIndex(656578);
        }

        @Override // io.reactivex.internal.subscribers.b, nm6.j
        public void clear() {
            this.f.clear();
            super.clear();
        }

        @Override // io.reactivex.internal.subscribers.b
        public void onComplete() {
            if (!this.d) {
                this.d = true;
                this.f.clear();
                this.a.onComplete();
            }
        }

        @Override // nm6.j
        public T poll() throws Exception {
            T poll;
            while (true) {
                poll = this.c.poll();
                if (poll == null || this.f.add((Object) ObjectHelper.requireNonNull(this.g.apply(poll), "The keySelector returned a null key"))) {
                    break;
                }
                if (this.e == 2) {
                    this.b.request(1L);
                }
            }
            return poll;
        }

        @Override // nm6.f
        public int requestFusion(int i) {
            return d(i);
        }

        @Override // io.reactivex.internal.subscribers.b
        public void onError(Throwable th) {
            if (this.d) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.d = true;
            this.f.clear();
            this.a.onError(th);
        }

        public void onNext(T t) {
            if (this.d) {
                return;
            }
            if (this.e == 0) {
                try {
                    if (this.f.add(ObjectHelper.requireNonNull(this.g.apply(t), "The keySelector returned a null key"))) {
                        this.a.onNext(t);
                        return;
                    } else {
                        this.b.request(1L);
                        return;
                    }
                } catch (Throwable th) {
                    c(th);
                    return;
                }
            }
            this.a.onNext((Object) null);
        }

        a(Subscriber<? super T> subscriber, Function<? super T, K> function, Collection<? super K> collection) {
            super(subscriber);
            this.g = function;
            this.f = collection;
        }
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        try {
            this.a.subscribe((FlowableSubscriber) new a(subscriber, this.b, (Collection) ObjectHelper.requireNonNull(this.c.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.")));
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptySubscription.error(th, subscriber);
        }
    }

    public s(Flowable<T> flowable, Function<? super T, K> function, Callable<? extends Collection<? super K>> callable) {
        super(flowable);
        this.b = function;
        this.c = callable;
    }
}
