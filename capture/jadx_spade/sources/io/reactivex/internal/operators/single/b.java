package io.reactivex.internal.operators.single;

import com.bytedance.covode.number.Covode;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiPredicate;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class b<T> extends Single<Boolean> {
    final SingleSource<T> a;
    final Object b;
    final BiPredicate<Object, Object> c;

    static {
        Covode.recordClassIndex(657531);
    }

    final class a implements SingleObserver<T> {
        private final SingleObserver<? super Boolean> a;

        static {
            Covode.recordClassIndex(657532);
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // io.reactivex.SingleObserver
        public void onSubscribe(Disposable disposable) {
            this.a.onSubscribe(disposable);
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(T t) {
            try {
                b bVar = b.this;
                this.a.onSuccess(Boolean.valueOf(bVar.c.test(t, bVar.b)));
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.a.onError(th);
            }
        }

        a(SingleObserver<? super Boolean> singleObserver) {
            this.a = singleObserver;
        }
    }

    @Override // io.reactivex.Single
    protected void subscribeActual(SingleObserver<? super Boolean> singleObserver) {
        this.a.subscribe(new a(singleObserver));
    }

    public b(SingleSource<T> singleSource, Object obj, BiPredicate<Object, Object> biPredicate) {
        this.a = singleSource;
        this.b = obj;
        this.c = biPredicate;
    }
}
