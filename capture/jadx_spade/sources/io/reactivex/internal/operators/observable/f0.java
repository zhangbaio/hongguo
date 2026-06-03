package io.reactivex.internal.operators.observable;

import com.bytedance.covode.number.Covode;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.functions.Predicate;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class f0<T> extends io.reactivex.internal.operators.observable.a<T, T> {
    final Predicate<? super T> a;

    static {
        Covode.recordClassIndex(657212);
    }

    static final class a<T> extends io.reactivex.internal.observers.a<T, T> {
        final Predicate<? super T> f;

        static {
            Covode.recordClassIndex(657213);
        }

        @Override // nm6.j
        public T poll() throws Exception {
            T poll;
            do {
                poll = this.c.poll();
                if (poll == null) {
                    break;
                }
            } while (!this.f.test(poll));
            return poll;
        }

        @Override // nm6.f
        public int requestFusion(int i) {
            return d(i);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            if (this.e == 0) {
                try {
                    if (this.f.test(t)) {
                        this.a.onNext(t);
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    c(th);
                    return;
                }
            }
            this.a.onNext(null);
        }

        a(Observer<? super T> observer, Predicate<? super T> predicate) {
            super(observer);
            this.f = predicate;
        }
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new a(observer, this.a));
    }

    public f0(ObservableSource<T> observableSource, Predicate<? super T> predicate) {
        super(observableSource);
        this.a = predicate;
    }
}
