package io.reactivex.internal.operators.observable;

import com.bytedance.covode.number.Covode;
import io.reactivex.Emitter;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.observables.ConnectableObservable;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class ObservableInternalHelper {
    static {
        Covode.recordClassIndex(657257);
    }

    static final class g<T> implements Action {
        final Observer<T> a;

        static {
            Covode.recordClassIndex(657265);
        }

        @Override // io.reactivex.functions.Action
        public void run() throws Exception {
            this.a.onComplete();
        }

        g(Observer<T> observer) {
            this.a = observer;
        }
    }

    static final class j<T> implements Callable<ConnectableObservable<T>> {
        private final Observable<T> a;

        static {
            Covode.recordClassIndex(657268);
        }

        @Override // java.util.concurrent.Callable
        public ConnectableObservable<T> call() {
            return this.a.replay();
        }

        j(Observable<T> observable) {
            this.a = observable;
        }
    }

    static final class a<T> implements Callable<ConnectableObservable<T>> {
        private final Observable<T> a;
        private final int b;

        static {
            Covode.recordClassIndex(657258);
        }

        @Override // java.util.concurrent.Callable
        public ConnectableObservable<T> call() {
            return this.a.replay(this.b);
        }

        a(Observable<T> observable, int i) {
            this.a = observable;
            this.b = i;
        }
    }

    static final class b<T> implements Callable<ConnectableObservable<T>> {
        private final Observable<T> a;
        private final int b;
        private final long c;
        private final TimeUnit d;
        private final Scheduler e;

        static {
            Covode.recordClassIndex(657259);
        }

        @Override // java.util.concurrent.Callable
        public ConnectableObservable<T> call() {
            return this.a.replay(this.b, this.c, this.d, this.e);
        }

        b(Observable<T> observable, int i, long j, TimeUnit timeUnit, Scheduler scheduler) {
            this.a = observable;
            this.b = i;
            this.c = j;
            this.d = timeUnit;
            this.e = scheduler;
        }
    }

    static final class n<T> implements Callable<ConnectableObservable<T>> {
        private final Observable<T> a;
        private final long b;
        private final TimeUnit c;
        private final Scheduler d;

        static {
            Covode.recordClassIndex(657272);
        }

        @Override // java.util.concurrent.Callable
        public ConnectableObservable<T> call() {
            return this.a.replay(this.b, this.c, this.d);
        }

        n(Observable<T> observable, long j, TimeUnit timeUnit, Scheduler scheduler) {
            this.a = observable;
            this.b = j;
            this.c = timeUnit;
            this.d = scheduler;
        }
    }

    enum MapToInt implements Function<Object, Object> {
        INSTANCE;

        static {
            Covode.recordClassIndex(657264);
        }

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) throws Exception {
            return 0;
        }
    }

    static final class c<T, U> implements Function<T, ObservableSource<U>> {
        private final Function<? super T, ? extends Iterable<? extends U>> a;

        static {
            Covode.recordClassIndex(657260);
        }

        c(Function<? super T, ? extends Iterable<? extends U>> function) {
            this.a = function;
        }

        @Override // io.reactivex.functions.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ObservableSource<U> apply(T t) throws Exception {
            return new k0((Iterable) ObjectHelper.requireNonNull(this.a.apply(t), "The mapper returned a null Iterable"));
        }
    }

    static final class f<T, U> implements Function<T, ObservableSource<T>> {
        final Function<? super T, ? extends ObservableSource<U>> a;

        static {
            Covode.recordClassIndex(657263);
        }

        f(Function<? super T, ? extends ObservableSource<U>> function) {
            this.a = function;
        }

        @Override // io.reactivex.functions.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ObservableSource<T> apply(T t) throws Exception {
            return new n1((ObservableSource) ObjectHelper.requireNonNull(this.a.apply(t), "The itemDelay returned a null ObservableSource"), 1L).map(Functions.justFunction(t)).defaultIfEmpty(t);
        }
    }

    static final class h<T> implements Consumer<Throwable> {
        final Observer<T> a;

        static {
            Covode.recordClassIndex(657266);
        }

        h(Observer<T> observer) {
            this.a = observer;
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) throws Exception {
            this.a.onError(th);
        }
    }

    static final class i<T> implements Consumer<T> {
        final Observer<T> a;

        static {
            Covode.recordClassIndex(657267);
        }

        i(Observer<T> observer) {
            this.a = observer;
        }

        @Override // io.reactivex.functions.Consumer
        public void accept(T t) throws Exception {
            this.a.onNext(t);
        }
    }

    static final class l<T, S> implements BiFunction<S, Emitter<T>, S> {
        final BiConsumer<S, Emitter<T>> a;

        static {
            Covode.recordClassIndex(657270);
        }

        l(BiConsumer<S, Emitter<T>> biConsumer) {
            this.a = biConsumer;
        }

        @Override // io.reactivex.functions.BiFunction
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public S apply(S s, Emitter<T> emitter) throws Exception {
            this.a.accept(s, emitter);
            return s;
        }
    }

    static final class m<T, S> implements BiFunction<S, Emitter<T>, S> {
        final Consumer<Emitter<T>> a;

        static {
            Covode.recordClassIndex(657271);
        }

        m(Consumer<Emitter<T>> consumer) {
            this.a = consumer;
        }

        @Override // io.reactivex.functions.BiFunction
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public S apply(S s, Emitter<T> emitter) throws Exception {
            this.a.accept(emitter);
            return s;
        }
    }

    static final class o<T, R> implements Function<List<ObservableSource<? extends T>>, ObservableSource<? extends R>> {
        private final Function<? super Object[], ? extends R> a;

        static {
            Covode.recordClassIndex(657273);
        }

        o(Function<? super Object[], ? extends R> function) {
            this.a = function;
        }

        @Override // io.reactivex.functions.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ObservableSource<? extends R> apply(List<ObservableSource<? extends T>> list) {
            return Observable.zipIterable(list, this.a, false, Observable.bufferSize());
        }
    }

    public static <T, U> Function<T, ObservableSource<U>> a(Function<? super T, ? extends Iterable<? extends U>> function) {
        return new c(function);
    }

    public static <T, U> Function<T, ObservableSource<T>> c(Function<? super T, ? extends ObservableSource<U>> function) {
        return new f(function);
    }

    public static <T> Action d(Observer<T> observer) {
        return new g(observer);
    }

    public static <T> Consumer<Throwable> e(Observer<T> observer) {
        return new h(observer);
    }

    public static <T> Consumer<T> f(Observer<T> observer) {
        return new i(observer);
    }

    public static <T> Callable<ConnectableObservable<T>> g(Observable<T> observable) {
        return new j(observable);
    }

    public static <T, S> BiFunction<S, Emitter<T>, S> l(BiConsumer<S, Emitter<T>> biConsumer) {
        return new l(biConsumer);
    }

    public static <T, S> BiFunction<S, Emitter<T>, S> m(Consumer<Emitter<T>> consumer) {
        return new m(consumer);
    }

    public static <T, R> Function<List<ObservableSource<? extends T>>, ObservableSource<? extends R>> n(Function<? super Object[], ? extends R> function) {
        return new o(function);
    }

    static final class d<U, R, T> implements Function<U, R> {
        private final BiFunction<? super T, ? super U, ? extends R> a;
        private final T b;

        static {
            Covode.recordClassIndex(657261);
        }

        @Override // io.reactivex.functions.Function
        public R apply(U u) throws Exception {
            return this.a.apply(this.b, u);
        }

        d(BiFunction<? super T, ? super U, ? extends R> biFunction, T t) {
            this.a = biFunction;
            this.b = t;
        }
    }

    static final class e<T, R, U> implements Function<T, ObservableSource<R>> {
        private final BiFunction<? super T, ? super U, ? extends R> a;
        private final Function<? super T, ? extends ObservableSource<? extends U>> b;

        static {
            Covode.recordClassIndex(657262);
        }

        @Override // io.reactivex.functions.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ObservableSource<R> apply(T t) throws Exception {
            return new v0((ObservableSource) ObjectHelper.requireNonNull(this.b.apply(t), "The mapper returned a null ObservableSource"), new d(this.a, t));
        }

        e(BiFunction<? super T, ? super U, ? extends R> biFunction, Function<? super T, ? extends ObservableSource<? extends U>> function) {
            this.a = biFunction;
            this.b = function;
        }
    }

    static final class k<T, R> implements Function<Observable<T>, ObservableSource<R>> {
        private final Function<? super Observable<T>, ? extends ObservableSource<R>> a;
        private final Scheduler b;

        static {
            Covode.recordClassIndex(657269);
        }

        @Override // io.reactivex.functions.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ObservableSource<R> apply(Observable<T> observable) throws Exception {
            return Observable.wrap((ObservableSource) ObjectHelper.requireNonNull(this.a.apply(observable), "The selector returned a null ObservableSource")).observeOn(this.b);
        }

        k(Function<? super Observable<T>, ? extends ObservableSource<R>> function, Scheduler scheduler) {
            this.a = function;
            this.b = scheduler;
        }
    }

    public static <T, U, R> Function<T, ObservableSource<R>> b(Function<? super T, ? extends ObservableSource<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        return new e(biFunction, function);
    }

    public static <T> Callable<ConnectableObservable<T>> h(Observable<T> observable, int i2) {
        return new a(observable, i2);
    }

    public static <T, R> Function<Observable<T>, ObservableSource<R>> k(Function<? super Observable<T>, ? extends ObservableSource<R>> function, Scheduler scheduler) {
        return new k(function, scheduler);
    }

    public static <T> Callable<ConnectableObservable<T>> j(Observable<T> observable, long j2, TimeUnit timeUnit, Scheduler scheduler) {
        return new n(observable, j2, timeUnit, scheduler);
    }

    public static <T> Callable<ConnectableObservable<T>> i(Observable<T> observable, int i2, long j2, TimeUnit timeUnit, Scheduler scheduler) {
        return new b(observable, i2, j2, timeUnit, scheduler);
    }
}
