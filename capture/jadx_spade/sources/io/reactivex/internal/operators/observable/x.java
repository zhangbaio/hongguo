package io.reactivex.internal.operators.observable;

import com.bytedance.covode.number.Covode;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.functions.Consumer;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class x<T> extends io.reactivex.internal.operators.observable.a<T, T> {
    final Consumer<? super T> a;

    static {
        Covode.recordClassIndex(657197);
    }

    static final class a<T> extends io.reactivex.internal.observers.a<T, T> {
        final Consumer<? super T> f;

        static {
            Covode.recordClassIndex(657198);
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

        @Override // io.reactivex.Observer
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

        a(Observer<? super T> observer, Consumer<? super T> consumer) {
            super(observer);
            this.f = consumer;
        }
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new a(observer, this.a));
    }

    public x(ObservableSource<T> observableSource, Consumer<? super T> consumer) {
        super(observableSource);
        this.a = consumer;
    }
}
