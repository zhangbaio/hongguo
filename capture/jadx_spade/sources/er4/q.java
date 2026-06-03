package er4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public abstract class q<T, V> {
    public static final int d;
    public boolean a = true;
    public boolean b = true;
    public boolean c = true;

    static {
        Covode.recordClassIndex(611461);
        d = 8;
    }

    protected abstract void I(T t, V v);

    protected abstract void J(T t, V v);

    protected abstract Observable<T> K(V v);

    protected abstract Observable<T> L(V v);

    protected abstract Observable<T> q(V v);

    /* JADX INFO: Access modifiers changed from: private */
    public static final ObservableSource s(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "<unused var>");
        return Observable.empty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ObservableSource u(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "<unused var>");
        return Observable.empty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ObservableSource D(Throwable e) {
        Intrinsics.checkNotNullParameter(e, "e");
        LogWrapper.error("AbsCacheRepo", "磁盘缓存命中后异步刷新网络失败", new Object[]{e});
        return Observable.empty();
    }

    public final Observable<T> r(final V v) {
        Observable<T> empty;
        ObservableSource<? extends T> empty2;
        Observable<T> empty3;
        if (this.a) {
            Observable<T> K = K(v);
            final Function1 function1 = new Function1() { // from class: er4.a
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    ObservableSource s;
                    s = q.s((Throwable) obj);
                    return s;
                }
            };
            empty = K.onErrorResumeNext(new Function() { // from class: er4.h
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    ObservableSource t;
                    t = q.t(Function1.this, obj);
                    return t;
                }
            });
        } else {
            empty = Observable.empty();
        }
        if (this.b) {
            Observable<T> q = q(v);
            final Function1 function12 = new Function1() { // from class: er4.i
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    ObservableSource u;
                    u = q.u((Throwable) obj);
                    return u;
                }
            };
            Observable<T> onErrorResumeNext = q.onErrorResumeNext(new Function() { // from class: er4.j
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    ObservableSource v2;
                    v2 = q.v(Function1.this, obj);
                    return v2;
                }
            });
            final Function1 function13 = new Function1() { // from class: er4.k
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit w;
                    w = q.w(q.this, v, obj);
                    return w;
                }
            };
            Observable<T> doOnNext = onErrorResumeNext.doOnNext(new Consumer() { // from class: er4.l
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    q.x(Function1.this, obj);
                }
            });
            final Function1 function14 = new Function1() { // from class: er4.m
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    ObservableSource y;
                    y = q.y(q.this, v, obj);
                    return y;
                }
            };
            empty2 = doOnNext.flatMap(new Function() { // from class: er4.n
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    ObservableSource F;
                    F = q.F(Function1.this, obj);
                    return F;
                }
            });
        } else {
            empty2 = Observable.empty();
        }
        if (this.c) {
            Observable<T> L = L(v);
            final Function1 function15 = new Function1() { // from class: er4.o
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit G;
                    G = q.G(q.this, v, obj);
                    return G;
                }
            };
            empty3 = L.doOnNext(new Consumer() { // from class: er4.p
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    q.H(Function1.this, obj);
                }
            });
        } else {
            empty3 = Observable.empty();
        }
        Observable<T> observable = empty.concatWith(empty2).switchIfEmpty(empty3).firstElement().toObservable();
        Intrinsics.checkNotNullExpressionValue(observable, "toObservable(...)");
        return observable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ObservableSource E(Function1 function1, Object p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return (ObservableSource) function1.invoke(p0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ObservableSource F(Function1 function1, Object p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return (ObservableSource) function1.invoke(p0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ObservableSource t(Function1 function1, Object p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return (ObservableSource) function1.invoke(p0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ObservableSource v(Function1 function1, Object p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return (ObservableSource) function1.invoke(p0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z(Object obj, Disposable disposable) {
        LogWrapper.info("AbsCacheRepo", "磁盘缓存命中后异步刷新网络请求发送", new Object[]{obj});
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B(q qVar, Object obj, Object obj2) {
        qVar.J(obj2, obj);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G(q qVar, Object obj, Object obj2) {
        qVar.J(obj2, obj);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w(q qVar, Object obj, Object obj2) {
        qVar.I(obj2, obj);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ObservableSource y(final q qVar, final Object obj, Object diskData) {
        Intrinsics.checkNotNullParameter(diskData, "diskData");
        if (qVar.c) {
            Observable<T> L = qVar.L(obj);
            final Function1 function1 = new Function1() { // from class: er4.b
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    Unit z;
                    z = q.z(obj, (Disposable) obj2);
                    return z;
                }
            };
            Observable<T> doOnSubscribe = L.doOnSubscribe(new Consumer() { // from class: er4.c
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj2) {
                    q.A(Function1.this, obj2);
                }
            });
            final Function1 function12 = new Function1() { // from class: er4.d
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    Unit B;
                    B = q.B(q.this, obj, obj2);
                    return B;
                }
            };
            Observable<T> doOnNext = doOnSubscribe.doOnNext(new Consumer() { // from class: er4.e
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj2) {
                    q.C(Function1.this, obj2);
                }
            });
            final Function1 function13 = new Function1() { // from class: er4.f
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    ObservableSource D;
                    D = q.D((Throwable) obj2);
                    return D;
                }
            };
            doOnNext.onErrorResumeNext(new Function() { // from class: er4.g
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj2) {
                    ObservableSource E;
                    E = q.E(Function1.this, obj2);
                    return E;
                }
            }).subscribe();
        }
        return Observable.just(diskData);
    }
}
