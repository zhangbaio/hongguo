package io.reactivex.internal.operators.observable;

import com.bytedance.covode.number.Covode;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.internal.functions.ObjectHelper;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class h0<T> extends Observable<T> {
    final T[] a;

    static {
        Covode.recordClassIndex(657231);
    }

    static final class a<T> extends io.reactivex.internal.observers.b<T> {
        final Observer<? super T> a;
        final T[] b;
        int c;
        boolean d;
        volatile boolean e;

        static {
            Covode.recordClassIndex(657232);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.e = true;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.e;
        }

        @Override // nm6.j
        public void clear() {
            this.c = this.b.length;
        }

        @Override // nm6.j
        public boolean isEmpty() {
            if (this.c == this.b.length) {
                return true;
            }
            return false;
        }

        @Override // nm6.j
        public T poll() {
            int i = this.c;
            T[] tArr = this.b;
            if (i != tArr.length) {
                this.c = i + 1;
                return (T) ObjectHelper.requireNonNull(tArr[i], "The array element is null");
            }
            return null;
        }

        void a() {
            T[] tArr = this.b;
            int length = tArr.length;
            for (int i = 0; i < length && !isDisposed(); i++) {
                T t = tArr[i];
                if (t == null) {
                    this.a.onError(new NullPointerException("The " + i + "th element is null"));
                    return;
                }
                this.a.onNext(t);
            }
            if (!isDisposed()) {
                this.a.onComplete();
            }
        }

        @Override // nm6.f
        public int requestFusion(int i) {
            if ((i & 1) != 0) {
                this.d = true;
                return 1;
            }
            return 0;
        }

        a(Observer<? super T> observer, T[] tArr) {
            this.a = observer;
            this.b = tArr;
        }
    }

    public h0(T[] tArr) {
        this.a = tArr;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        a aVar = new a(observer, this.a);
        observer.onSubscribe(aVar);
        if (aVar.d) {
            return;
        }
        aVar.a();
    }
}
