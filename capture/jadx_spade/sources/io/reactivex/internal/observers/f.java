package io.reactivex.internal.observers;

import com.bytedance.covode.number.Covode;
import io.reactivex.CompletableObserver;
import io.reactivex.MaybeObserver;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class f<T> extends CountDownLatch implements SingleObserver<T>, CompletableObserver, MaybeObserver<T> {
    T a;
    Throwable b;
    Disposable c;
    volatile boolean d;

    static {
        Covode.recordClassIndex(656371);
    }

    @Override // io.reactivex.CompletableObserver
    public void onComplete() {
        countDown();
    }

    public f() {
        super(1);
    }

    void f() {
        this.d = true;
        Disposable disposable = this.c;
        if (disposable != null) {
            disposable.dispose();
        }
    }

    public Throwable d() {
        if (getCount() != 0) {
            try {
                io.reactivex.internal.util.c.b();
                await();
            } catch (InterruptedException e) {
                f();
                return e;
            }
        }
        return this.b;
    }

    public T b() {
        if (getCount() != 0) {
            try {
                io.reactivex.internal.util.c.b();
                await();
            } catch (InterruptedException e) {
                f();
                throw ExceptionHelper.wrapOrThrow(e);
            }
        }
        Throwable th = this.b;
        if (th == null) {
            return this.a;
        }
        throw ExceptionHelper.wrapOrThrow(th);
    }

    @Override // io.reactivex.SingleObserver
    public void onError(Throwable th) {
        this.b = th;
        countDown();
    }

    @Override // io.reactivex.SingleObserver
    public void onSuccess(T t) {
        this.a = t;
        countDown();
    }

    @Override // io.reactivex.SingleObserver
    public void onSubscribe(Disposable disposable) {
        this.c = disposable;
        if (this.d) {
            disposable.dispose();
        }
    }

    public T c(T t) {
        if (getCount() != 0) {
            try {
                io.reactivex.internal.util.c.b();
                await();
            } catch (InterruptedException e) {
                f();
                throw ExceptionHelper.wrapOrThrow(e);
            }
        }
        Throwable th = this.b;
        if (th == null) {
            T t2 = this.a;
            if (t2 != null) {
                return t2;
            }
            return t;
        }
        throw ExceptionHelper.wrapOrThrow(th);
    }

    public boolean a(long j, TimeUnit timeUnit) {
        if (getCount() != 0) {
            try {
                io.reactivex.internal.util.c.b();
                if (!await(j, timeUnit)) {
                    f();
                    return false;
                }
            } catch (InterruptedException e) {
                f();
                throw ExceptionHelper.wrapOrThrow(e);
            }
        }
        Throwable th = this.b;
        if (th == null) {
            return true;
        }
        throw ExceptionHelper.wrapOrThrow(th);
    }

    public Throwable e(long j, TimeUnit timeUnit) {
        if (getCount() != 0) {
            try {
                io.reactivex.internal.util.c.b();
                if (!await(j, timeUnit)) {
                    f();
                    throw ExceptionHelper.wrapOrThrow(new TimeoutException(ExceptionHelper.timeoutMessage(j, timeUnit)));
                }
            } catch (InterruptedException e) {
                f();
                throw ExceptionHelper.wrapOrThrow(e);
            }
        }
        return this.b;
    }
}
