package io.reactivex.internal.operators.mixed;

import ak4.d;
import com.bytedance.covode.number.Covode;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.MaybeSource;
import io.reactivex.Observer;
import io.reactivex.SingleSource;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.maybe.MaybeToObservable;
import io.reactivex.internal.operators.single.SingleToObservable;
import java.util.concurrent.Callable;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class b {
    static {
        Covode.recordClassIndex(657098);
    }

    static <T> boolean a(Object obj, Function<? super T, ? extends CompletableSource> function, CompletableObserver completableObserver) {
        CompletableSource completableSource;
        if (obj instanceof Callable) {
            try {
                d.a.C0000a c0000a = (Object) ((Callable) obj).call();
                if (c0000a != null) {
                    completableSource = (CompletableSource) ObjectHelper.requireNonNull(function.apply(c0000a), "The mapper returned a null CompletableSource");
                } else {
                    completableSource = null;
                }
                if (completableSource == null) {
                    EmptyDisposable.complete(completableObserver);
                } else {
                    completableSource.subscribe(completableObserver);
                }
                return true;
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                EmptyDisposable.error(th, completableObserver);
                return true;
            }
        }
        return false;
    }

    static <T, R> boolean b(Object obj, Function<? super T, ? extends MaybeSource<? extends R>> function, Observer<? super R> observer) {
        MaybeSource maybeSource;
        if (obj instanceof Callable) {
            try {
                d.a.C0000a c0000a = (Object) ((Callable) obj).call();
                if (c0000a != null) {
                    maybeSource = (MaybeSource) ObjectHelper.requireNonNull(function.apply(c0000a), "The mapper returned a null MaybeSource");
                } else {
                    maybeSource = null;
                }
                if (maybeSource == null) {
                    EmptyDisposable.complete(observer);
                } else {
                    maybeSource.subscribe(MaybeToObservable.b(observer));
                }
                return true;
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                EmptyDisposable.error(th, observer);
                return true;
            }
        }
        return false;
    }

    static <T, R> boolean c(Object obj, Function<? super T, ? extends SingleSource<? extends R>> function, Observer<? super R> observer) {
        SingleSource singleSource;
        if (obj instanceof Callable) {
            try {
                d.a.C0000a c0000a = (Object) ((Callable) obj).call();
                if (c0000a != null) {
                    singleSource = (SingleSource) ObjectHelper.requireNonNull(function.apply(c0000a), "The mapper returned a null SingleSource");
                } else {
                    singleSource = null;
                }
                if (singleSource == null) {
                    EmptyDisposable.complete(observer);
                } else {
                    singleSource.subscribe(SingleToObservable.b(observer));
                }
                return true;
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                EmptyDisposable.error(th, observer);
                return true;
            }
        }
        return false;
    }
}
