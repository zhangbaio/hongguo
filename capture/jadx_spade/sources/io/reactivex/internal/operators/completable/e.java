package io.reactivex.internal.operators.completable;

import com.bytedance.covode.number.Covode;
import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class e extends Completable {
    final CompletableSource a;
    final Consumer<? super Throwable> b;

    static {
        Covode.recordClassIndex(656416);
    }

    final class a implements CompletableObserver {
        private final CompletableObserver a;

        static {
            Covode.recordClassIndex(656417);
        }

        @Override // io.reactivex.CompletableObserver
        public void onComplete() {
            try {
                e.this.b.accept(null);
                this.a.onComplete();
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.a.onError(th);
            }
        }

        @Override // io.reactivex.CompletableObserver
        public void onSubscribe(Disposable disposable) {
            this.a.onSubscribe(disposable);
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(Throwable th) {
            try {
                e.this.b.accept(th);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                th = new CompositeException(th, th2);
            }
            this.a.onError(th);
        }

        a(CompletableObserver completableObserver) {
            this.a = completableObserver;
        }
    }

    @Override // io.reactivex.Completable
    protected void subscribeActual(CompletableObserver completableObserver) {
        this.a.subscribe(new a(completableObserver));
    }

    public e(CompletableSource completableSource, Consumer<? super Throwable> consumer) {
        this.a = completableSource;
        this.b = consumer;
    }
}
