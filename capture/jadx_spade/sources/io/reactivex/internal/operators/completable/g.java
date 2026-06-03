package io.reactivex.internal.operators.completable;

import com.bytedance.covode.number.Covode;
import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.internal.disposables.EmptyDisposable;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class g extends Completable {
    final Throwable a;

    static {
        Covode.recordClassIndex(656419);
    }

    public g(Throwable th) {
        this.a = th;
    }

    @Override // io.reactivex.Completable
    protected void subscribeActual(CompletableObserver completableObserver) {
        EmptyDisposable.error(this.a, completableObserver);
    }
}
