package io.reactivex.internal.operators.observable;

import com.bytedance.covode.number.Covode;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class v0<T, U> extends io.reactivex.internal.operators.observable.a<T, U> {
    final Function<? super T, ? extends U> a;

    static {
        Covode.recordClassIndex(657286);
    }

    static final class a<T, U> extends io.reactivex.internal.observers.a<T, U> {
        final Function<? super T, ? extends U> f;

        static {
            Covode.recordClassIndex(657287);
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

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            if (this.d) {
                return;
            }
            if (this.e != 0) {
                this.a.onNext(null);
                return;
            }
            try {
                this.a.onNext(ObjectHelper.requireNonNull(this.f.apply(t), "The mapper function returned a null value."));
            } catch (Throwable th) {
                c(th);
            }
        }

        a(Observer<? super U> observer, Function<? super T, ? extends U> function) {
            super(observer);
            this.f = function;
        }
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super U> observer) {
        this.source.subscribe(new a(observer, this.a));
    }

    public v0(ObservableSource<T> observableSource, Function<? super T, ? extends U> function) {
        super(observableSource);
        this.a = function;
    }
}
