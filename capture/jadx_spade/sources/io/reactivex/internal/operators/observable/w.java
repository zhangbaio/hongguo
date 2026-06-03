package io.reactivex.internal.operators.observable;

import com.bytedance.covode.number.Covode;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.functions.BiPredicate;
import io.reactivex.functions.Function;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class w<T, K> extends io.reactivex.internal.operators.observable.a<T, T> {
    final Function<? super T, K> a;
    final BiPredicate<? super K, ? super K> b;

    static {
        Covode.recordClassIndex(657195);
    }

    static final class a<T, K> extends io.reactivex.internal.observers.a<T, T> {
        final Function<? super T, K> f;
        final BiPredicate<? super K, ? super K> g;
        K h;
        boolean i;

        static {
            Covode.recordClassIndex(657196);
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
            }
        }

        @Override // nm6.f
        public int requestFusion(int i) {
            return d(i);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            if (this.d) {
                return;
            }
            if (this.e != 0) {
                this.a.onNext(t);
                return;
            }
            try {
                K apply = this.f.apply(t);
                if (this.i) {
                    boolean test = this.g.test(this.h, apply);
                    this.h = apply;
                    if (test) {
                        return;
                    }
                } else {
                    this.i = true;
                    this.h = apply;
                }
                this.a.onNext(t);
            } catch (Throwable th) {
                c(th);
            }
        }

        a(Observer<? super T> observer, Function<? super T, K> function, BiPredicate<? super K, ? super K> biPredicate) {
            super(observer);
            this.f = function;
            this.g = biPredicate;
        }
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new a(observer, this.a, this.b));
    }

    public w(ObservableSource<T> observableSource, Function<? super T, K> function, BiPredicate<? super K, ? super K> biPredicate) {
        super(observableSource);
        this.a = function;
        this.b = biPredicate;
    }
}
