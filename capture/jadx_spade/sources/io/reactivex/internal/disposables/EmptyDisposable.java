package io.reactivex.internal.disposables;

import com.bytedance.covode.number.Covode;
import io.reactivex.CompletableObserver;
import io.reactivex.MaybeObserver;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import nm6.e;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public enum EmptyDisposable implements e<Object> {
    INSTANCE,
    NEVER;

    @Override // nm6.j
    public void clear() {
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
    }

    @Override // nm6.j
    public boolean isEmpty() {
        return true;
    }

    @Override // nm6.j
    public Object poll() throws Exception {
        return null;
    }

    @Override // nm6.f
    public int requestFusion(int i) {
        return i & 2;
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        if (this == INSTANCE) {
            return true;
        }
        return false;
    }

    static {
        Covode.recordClassIndex(656303);
    }

    @Override // nm6.j
    public boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public static void complete(CompletableObserver completableObserver) {
        completableObserver.onSubscribe(INSTANCE);
        completableObserver.onComplete();
    }

    public static void complete(MaybeObserver<?> maybeObserver) {
        maybeObserver.onSubscribe(INSTANCE);
        maybeObserver.onComplete();
    }

    public static void complete(Observer<?> observer) {
        observer.onSubscribe(INSTANCE);
        observer.onComplete();
    }

    public static void error(Throwable th, CompletableObserver completableObserver) {
        completableObserver.onSubscribe(INSTANCE);
        completableObserver.onError(th);
    }

    public boolean offer(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public static void error(Throwable th, MaybeObserver<?> maybeObserver) {
        maybeObserver.onSubscribe(INSTANCE);
        maybeObserver.onError(th);
    }

    public static void error(Throwable th, Observer<?> observer) {
        observer.onSubscribe(INSTANCE);
        observer.onError(th);
    }

    public static void error(Throwable th, SingleObserver<?> singleObserver) {
        singleObserver.onSubscribe(INSTANCE);
        singleObserver.onError(th);
    }
}
