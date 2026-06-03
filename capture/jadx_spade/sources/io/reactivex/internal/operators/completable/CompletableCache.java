package io.reactivex.internal.operators.completable;

import androidx.compose.animation.core.g1;
import com.bytedance.covode.number.Covode;
import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class CompletableCache extends Completable implements CompletableObserver {
    static final InnerCompletableCache[] e;
    static final InnerCompletableCache[] f;
    final CompletableSource a;
    final AtomicReference<InnerCompletableCache[]> b = new AtomicReference<>(e);
    final AtomicBoolean c = new AtomicBoolean();
    Throwable d;

    @Override // io.reactivex.CompletableObserver
    public void onSubscribe(Disposable disposable) {
    }

    final class InnerCompletableCache extends AtomicBoolean implements Disposable {
        private static final long serialVersionUID = 8943152917179642732L;
        final CompletableObserver downstream;

        static {
            Covode.recordClassIndex(656397);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return get();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (compareAndSet(false, true)) {
                CompletableCache.this.e(this);
            }
        }

        InnerCompletableCache(CompletableObserver completableObserver) {
            this.downstream = completableObserver;
        }
    }

    static {
        Covode.recordClassIndex(656396);
        e = new InnerCompletableCache[0];
        f = new InnerCompletableCache[0];
    }

    @Override // io.reactivex.CompletableObserver
    public void onComplete() {
        for (InnerCompletableCache innerCompletableCache : this.b.getAndSet(f)) {
            if (!innerCompletableCache.get()) {
                innerCompletableCache.downstream.onComplete();
            }
        }
    }

    public CompletableCache(CompletableSource completableSource) {
        this.a = completableSource;
    }

    boolean d(InnerCompletableCache innerCompletableCache) {
        InnerCompletableCache[] innerCompletableCacheArr;
        InnerCompletableCache[] innerCompletableCacheArr2;
        do {
            innerCompletableCacheArr = this.b.get();
            if (innerCompletableCacheArr == f) {
                return false;
            }
            int length = innerCompletableCacheArr.length;
            innerCompletableCacheArr2 = new InnerCompletableCache[length + 1];
            System.arraycopy(innerCompletableCacheArr, 0, innerCompletableCacheArr2, 0, length);
            innerCompletableCacheArr2[length] = innerCompletableCache;
        } while (!g1.a(this.b, innerCompletableCacheArr, innerCompletableCacheArr2));
        return true;
    }

    void e(InnerCompletableCache innerCompletableCache) {
        InnerCompletableCache[] innerCompletableCacheArr;
        InnerCompletableCache[] innerCompletableCacheArr2;
        do {
            innerCompletableCacheArr = this.b.get();
            int length = innerCompletableCacheArr.length;
            if (length == 0) {
                return;
            }
            int i = 0;
            while (true) {
                if (i < length) {
                    if (innerCompletableCacheArr[i] == innerCompletableCache) {
                        break;
                    } else {
                        i++;
                    }
                } else {
                    i = -1;
                    break;
                }
            }
            if (i < 0) {
                return;
            }
            if (length == 1) {
                innerCompletableCacheArr2 = e;
            } else {
                InnerCompletableCache[] innerCompletableCacheArr3 = new InnerCompletableCache[length - 1];
                System.arraycopy(innerCompletableCacheArr, 0, innerCompletableCacheArr3, 0, i);
                System.arraycopy(innerCompletableCacheArr, i + 1, innerCompletableCacheArr3, i, (length - i) - 1);
                innerCompletableCacheArr2 = innerCompletableCacheArr3;
            }
        } while (!g1.a(this.b, innerCompletableCacheArr, innerCompletableCacheArr2));
    }

    @Override // io.reactivex.CompletableObserver
    public void onError(Throwable th) {
        this.d = th;
        for (InnerCompletableCache innerCompletableCache : this.b.getAndSet(f)) {
            if (!innerCompletableCache.get()) {
                innerCompletableCache.downstream.onError(th);
            }
        }
    }

    @Override // io.reactivex.Completable
    protected void subscribeActual(CompletableObserver completableObserver) {
        InnerCompletableCache innerCompletableCache = new InnerCompletableCache(completableObserver);
        completableObserver.onSubscribe(innerCompletableCache);
        if (d(innerCompletableCache)) {
            if (innerCompletableCache.isDisposed()) {
                e(innerCompletableCache);
            }
            if (this.c.compareAndSet(false, true)) {
                this.a.subscribe(this);
                return;
            }
            return;
        }
        Throwable th = this.d;
        if (th != null) {
            completableObserver.onError(th);
        } else {
            completableObserver.onComplete();
        }
    }
}
