package io.reactivex.internal.operators.flowable;

import com.bytedance.covode.number.Covode;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.functions.BiPredicate;
import io.reactivex.functions.Function;
import org.reactivestreams.Subscriber;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class t<T, K> extends io.reactivex.internal.operators.flowable.a<T, T> {
    final Function<? super T, K> b;
    final BiPredicate<? super K, ? super K> c;

    static {
        Covode.recordClassIndex(656579);
    }

    static final class a<T, K> extends io.reactivex.internal.subscribers.a<T, T> {
        final Function<? super T, K> f;
        final BiPredicate<? super K, ? super K> g;
        K h;
        boolean i;

        static {
            Covode.recordClassIndex(656580);
        }

        @Override // nm6.j
        public T poll() throws Exception {
            while (true) {
                T poll = this.c.poll();
                if (poll == null) {
                    return null;
                }
                K apply = this.f.apply(poll);
                if (!this.i) {
                    this.i = true;
                    this.h = apply;
                    return poll;
                }
                if (!this.g.test(this.h, apply)) {
                    this.h = apply;
                    return poll;
                }
                this.h = apply;
                if (this.e != 1) {
                    this.b.request(1L);
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
                return this.a.tryOnNext(t);
            }
            try {
                K apply = this.f.apply(t);
                if (this.i) {
                    boolean test = this.g.test(this.h, apply);
                    this.h = apply;
                    if (test) {
                        return false;
                    }
                } else {
                    this.i = true;
                    this.h = apply;
                }
                this.a.onNext(t);
                return true;
            } catch (Throwable th) {
                c(th);
                return true;
            }
        }

        a(nm6.a<? super T> aVar, Function<? super T, K> function, BiPredicate<? super K, ? super K> biPredicate) {
            super(aVar);
            this.f = function;
            this.g = biPredicate;
        }
    }

    static final class b<T, K> extends io.reactivex.internal.subscribers.b<T, T> implements nm6.a<T> {
        final Function<? super T, K> f;
        final BiPredicate<? super K, ? super K> g;
        K h;
        boolean i;

        static {
            Covode.recordClassIndex(656581);
        }

        @Override // nm6.j
        public T poll() throws Exception {
            while (true) {
                T poll = this.c.poll();
                if (poll == null) {
                    return null;
                }
                K apply = this.f.apply(poll);
                if (!this.i) {
                    this.i = true;
                    this.h = apply;
                    return poll;
                }
                if (!this.g.test(this.h, apply)) {
                    this.h = apply;
                    return poll;
                }
                this.h = apply;
                if (this.e != 1) {
                    this.b.request(1L);
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
                this.a.onNext(t);
                return true;
            }
            try {
                K apply = this.f.apply(t);
                if (this.i) {
                    boolean test = this.g.test(this.h, apply);
                    this.h = apply;
                    if (test) {
                        return false;
                    }
                } else {
                    this.i = true;
                    this.h = apply;
                }
                this.a.onNext(t);
                return true;
            } catch (Throwable th) {
                c(th);
                return true;
            }
        }

        b(Subscriber<? super T> subscriber, Function<? super T, K> function, BiPredicate<? super K, ? super K> biPredicate) {
            super(subscriber);
            this.f = function;
            this.g = biPredicate;
        }
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        if (subscriber instanceof nm6.a) {
            this.a.subscribe((FlowableSubscriber) new a((nm6.a) subscriber, this.b, this.c));
        } else {
            this.a.subscribe((FlowableSubscriber) new b(subscriber, this.b, this.c));
        }
    }

    public t(Flowable<T> flowable, Function<? super T, K> function, BiPredicate<? super K, ? super K> biPredicate) {
        super(flowable);
        this.b = function;
        this.c = biPredicate;
    }
}
