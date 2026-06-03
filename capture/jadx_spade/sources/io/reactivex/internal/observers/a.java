package io.reactivex.internal.observers;

import com.bytedance.covode.number.Covode;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class a<T, R> implements Observer<T>, nm6.e<R> {
    protected final Observer<? super R> a;
    protected Disposable b;
    protected nm6.e<T> c;
    protected boolean d;
    protected int e;

    static {
        Covode.recordClassIndex(656364);
    }

    protected void a() {
    }

    protected boolean b() {
        return true;
    }

    @Override // nm6.j
    public void clear() {
        this.c.clear();
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        this.b.dispose();
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.b.isDisposed();
    }

    @Override // nm6.j
    public boolean isEmpty() {
        return this.c.isEmpty();
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        if (this.d) {
            return;
        }
        this.d = true;
        this.a.onComplete();
    }

    public a(Observer<? super R> observer) {
        this.a = observer;
    }

    @Override // nm6.j
    public final boolean offer(R r) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    protected final void c(Throwable th) {
        Exceptions.throwIfFatal(th);
        this.b.dispose();
        onError(th);
    }

    protected final int d(int i) {
        nm6.e<T> eVar = this.c;
        if (eVar != null && (i & 4) == 0) {
            int requestFusion = eVar.requestFusion(i);
            if (requestFusion != 0) {
                this.e = requestFusion;
            }
            return requestFusion;
        }
        return 0;
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable th) {
        if (this.d) {
            RxJavaPlugins.onError(th);
        } else {
            this.d = true;
            this.a.onError(th);
        }
    }

    @Override // io.reactivex.Observer
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.b, disposable)) {
            this.b = disposable;
            if (disposable instanceof nm6.e) {
                this.c = (nm6.e) disposable;
            }
            if (b()) {
                this.a.onSubscribe(this);
                a();
            }
        }
    }
}
