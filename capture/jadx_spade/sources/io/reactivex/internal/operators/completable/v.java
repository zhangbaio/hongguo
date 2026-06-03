package io.reactivex.internal.operators.completable;

import com.bytedance.covode.number.Covode;
import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class v extends Completable {
    final CompletableSource a;
    final Predicate<? super Throwable> b;

    static {
        Covode.recordClassIndex(656448);
    }

    final class a implements CompletableObserver {
        private final CompletableObserver a;

        static {
            Covode.recordClassIndex(656449);
        }

        @Override // io.reactivex.CompletableObserver
        public void onComplete() {
            this.a.onComplete();
        }

        @Override // io.reactivex.CompletableObserver
        public void onSubscribe(Disposable disposable) {
            this.a.onSubscribe(disposable);
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(Throwable th) {
            try {
                if (v.this.b.test(th)) {
                    this.a.onComplete();
                } else {
                    this.a.onError(th);
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.a.onError(new CompositeException(th, th2));
            }
        }

        a(CompletableObserver completableObserver) {
            this.a = completableObserver;
        }
    }

    @Override // io.reactivex.Completable
    protected void subscribeActual(CompletableObserver completableObserver) {
        this.a.subscribe(new a(completableObserver));
    }

    public v(CompletableSource completableSource, Predicate<? super Throwable> predicate) {
        this.a = completableSource;
        this.b = predicate;
    }
}
