package io.reactivex.internal.operators.completable;

import com.bytedance.covode.number.Covode;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class z<T> extends Observable<T> {
    final CompletableSource a;

    static {
        Covode.recordClassIndex(656466);
    }

    static final class a extends io.reactivex.internal.observers.b<Void> implements CompletableObserver {
        final Observer<?> a;
        Disposable b;

        static {
            Covode.recordClassIndex(656467);
        }

        @Override // nm6.j
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void poll() throws Exception {
            return null;
        }

        @Override // nm6.j
        public void clear() {
        }

        @Override // nm6.j
        public boolean isEmpty() {
            return true;
        }

        @Override // nm6.f
        public int requestFusion(int i) {
            return i & 2;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.b.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.b.isDisposed();
        }

        @Override // io.reactivex.CompletableObserver
        public void onComplete() {
            this.a.onComplete();
        }

        a(Observer<?> observer) {
            this.a = observer;
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // io.reactivex.CompletableObserver
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.b, disposable)) {
                this.b = disposable;
                this.a.onSubscribe(this);
            }
        }
    }

    public z(CompletableSource completableSource) {
        this.a = completableSource;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super T> observer) {
        this.a.subscribe(new a(observer));
    }
}
