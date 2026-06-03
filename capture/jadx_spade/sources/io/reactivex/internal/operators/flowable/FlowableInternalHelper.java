package io.reactivex.internal.operators.flowable;

import com.bytedance.covode.number.Covode;
import io.reactivex.Emitter;
import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class FlowableInternalHelper {
    static {
        Covode.recordClassIndex(656653);
    }

    static final class k<T> implements Action {
        final Subscriber<T> a;

        static {
            Covode.recordClassIndex(656665);
        }

        @Override // io.reactivex.functions.Action
        public void run() throws Exception {
            this.a.onComplete();
        }

        k(Subscriber<T> subscriber) {
            this.a = subscriber;
        }
    }

    static final class a<T> implements Callable<km6.a<T>> {
        private final Flowable<T> a;
        private final int b;

        static {
            Covode.recordClassIndex(656654);
        }

        @Override // java.util.concurrent.Callable
        public km6.a<T> call() {
            return this.a.replay(this.b);
        }

        a(Flowable<T> flowable, int i) {
            this.a = flowable;
            this.b = i;
        }
    }

    static final class b<T> implements Callable<km6.a<T>> {
        private final Flowable<T> a;
        private final int b;
        private final long c;
        private final TimeUnit d;
        private final Scheduler e;

        static {
            Covode.recordClassIndex(656655);
        }

        @Override // java.util.concurrent.Callable
        public km6.a<T> call() {
            return this.a.replay(this.b, this.c, this.d, this.e);
        }

        b(Flowable<T> flowable, int i, long j, TimeUnit timeUnit, Scheduler scheduler) {
            this.a = flowable;
            this.b = i;
            this.c = j;
            this.d = timeUnit;
            this.e = scheduler;
        }
    }

    static final class g<T> implements Callable<km6.a<T>> {
        private final Flowable<T> a;

        static {
            Covode.recordClassIndex(656660);
        }

        @Override // java.util.concurrent.Callable
        public km6.a<T> call() {
            return this.a.replay();
        }

        g(Flowable<T> flowable) {
            this.a = flowable;
        }
    }

    static final class n<T> implements Callable<km6.a<T>> {
        private final Flowable<T> a;
        private final long b;
        private final TimeUnit c;
        private final Scheduler d;

        static {
            Covode.recordClassIndex(656668);
        }

        @Override // java.util.concurrent.Callable
        public km6.a<T> call() {
            return this.a.replay(this.b, this.c, this.d);
        }

        n(Flowable<T> flowable, long j, TimeUnit timeUnit, Scheduler scheduler) {
            this.a = flowable;
            this.b = j;
            this.c = timeUnit;
            this.d = scheduler;
        }
    }

    public enum RequestMax implements Consumer<Subscription> {
        INSTANCE;

        static {
            Covode.recordClassIndex(656662);
        }

        @Override // io.reactivex.functions.Consumer
        public void accept(Subscription subscription) throws Exception {
            subscription.request(Long.MAX_VALUE);
        }
    }

    static final class c<T, U> implements Function<T, Publisher<U>> {
        private final Function<? super T, ? extends Iterable<? extends U>> a;

        static {
            Covode.recordClassIndex(656656);
        }

        c(Function<? super T, ? extends Iterable<? extends U>> function) {
            this.a = function;
        }

        @Override // io.reactivex.functions.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Publisher<U> apply(T t) throws Exception {
            return new FlowableFromIterable((Iterable) ObjectHelper.requireNonNull(this.a.apply(t), "The mapper returned a null Iterable"));
        }
    }

    static final class f<T, U> implements Function<T, Publisher<T>> {
        final Function<? super T, ? extends Publisher<U>> a;

        static {
            Covode.recordClassIndex(656659);
        }

        f(Function<? super T, ? extends Publisher<U>> function) {
            this.a = function;
        }

        @Override // io.reactivex.functions.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Publisher<T> apply(T t) throws Exception {
            return new c1((Publisher) ObjectHelper.requireNonNull(this.a.apply(t), "The itemDelay returned a null Publisher"), 1L).map(Functions.justFunction(t)).defaultIfEmpty(t);
        }
    }

    static final class i<T, S> implements BiFunction<S, Emitter<T>, S> {
        final BiConsumer<S, Emitter<T>> a;

        static {
            Covode.recordClassIndex(656663);
        }

        i(BiConsumer<S, Emitter<T>> biConsumer) {
            this.a = biConsumer;
        }

        @Override // io.reactivex.functions.BiFunction
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public S apply(S s, Emitter<T> emitter) throws Exception {
            this.a.accept(s, emitter);
            return s;
        }
    }

    static final class j<T, S> implements BiFunction<S, Emitter<T>, S> {
        final Consumer<Emitter<T>> a;

        static {
            Covode.recordClassIndex(656664);
        }

        j(Consumer<Emitter<T>> consumer) {
            this.a = consumer;
        }

        @Override // io.reactivex.functions.BiFunction
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public S apply(S s, Emitter<T> emitter) throws Exception {
            this.a.accept(emitter);
            return s;
        }
    }

    static final class l<T> implements Consumer<Throwable> {
        final Subscriber<T> a;

        static {
            Covode.recordClassIndex(656666);
        }

        l(Subscriber<T> subscriber) {
            this.a = subscriber;
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) throws Exception {
            this.a.onError(th);
        }
    }

    static final class m<T> implements Consumer<T> {
        final Subscriber<T> a;

        static {
            Covode.recordClassIndex(656667);
        }

        m(Subscriber<T> subscriber) {
            this.a = subscriber;
        }

        @Override // io.reactivex.functions.Consumer
        public void accept(T t) throws Exception {
            this.a.onNext(t);
        }
    }

    static final class o<T, R> implements Function<List<Publisher<? extends T>>, Publisher<? extends R>> {
        private final Function<? super Object[], ? extends R> a;

        static {
            Covode.recordClassIndex(656669);
        }

        o(Function<? super Object[], ? extends R> function) {
            this.a = function;
        }

        @Override // io.reactivex.functions.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Publisher<? extends R> apply(List<Publisher<? extends T>> list) {
            return Flowable.zipIterable(list, this.a, false, Flowable.bufferSize());
        }
    }

    public static <T, U> Function<T, Publisher<U>> a(Function<? super T, ? extends Iterable<? extends U>> function) {
        return new c(function);
    }

    public static <T, U> Function<T, Publisher<T>> c(Function<? super T, ? extends Publisher<U>> function) {
        return new f(function);
    }

    public static <T> Callable<km6.a<T>> d(Flowable<T> flowable) {
        return new g(flowable);
    }

    public static <T, S> BiFunction<S, Emitter<T>, S> i(BiConsumer<S, Emitter<T>> biConsumer) {
        return new i(biConsumer);
    }

    public static <T, S> BiFunction<S, Emitter<T>, S> j(Consumer<Emitter<T>> consumer) {
        return new j(consumer);
    }

    public static <T> Action k(Subscriber<T> subscriber) {
        return new k(subscriber);
    }

    public static <T> Consumer<Throwable> l(Subscriber<T> subscriber) {
        return new l(subscriber);
    }

    public static <T> Consumer<T> m(Subscriber<T> subscriber) {
        return new m(subscriber);
    }

    public static <T, R> Function<List<Publisher<? extends T>>, Publisher<? extends R>> n(Function<? super Object[], ? extends R> function) {
        return new o(function);
    }

    static final class d<U, R, T> implements Function<U, R> {
        private final BiFunction<? super T, ? super U, ? extends R> a;
        private final T b;

        static {
            Covode.recordClassIndex(656657);
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

    static final class e<T, R, U> implements Function<T, Publisher<R>> {
        private final BiFunction<? super T, ? super U, ? extends R> a;
        private final Function<? super T, ? extends Publisher<? extends U>> b;

        static {
            Covode.recordClassIndex(656658);
        }

        @Override // io.reactivex.functions.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Publisher<R> apply(T t) throws Exception {
            return new p0((Publisher) ObjectHelper.requireNonNull(this.b.apply(t), "The mapper returned a null Publisher"), new d(this.a, t));
        }

        e(BiFunction<? super T, ? super U, ? extends R> biFunction, Function<? super T, ? extends Publisher<? extends U>> function) {
            this.a = biFunction;
            this.b = function;
        }
    }

    static final class h<T, R> implements Function<Flowable<T>, Publisher<R>> {
        private final Function<? super Flowable<T>, ? extends Publisher<R>> a;
        private final Scheduler b;

        static {
            Covode.recordClassIndex(656661);
        }

        @Override // io.reactivex.functions.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Publisher<R> apply(Flowable<T> flowable) throws Exception {
            return Flowable.fromPublisher((Publisher) ObjectHelper.requireNonNull(this.a.apply(flowable), "The selector returned a null Publisher")).observeOn(this.b);
        }

        h(Function<? super Flowable<T>, ? extends Publisher<R>> function, Scheduler scheduler) {
            this.a = function;
            this.b = scheduler;
        }
    }

    public static <T, U, R> Function<T, Publisher<R>> b(Function<? super T, ? extends Publisher<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        return new e(biFunction, function);
    }

    public static <T> Callable<km6.a<T>> e(Flowable<T> flowable, int i2) {
        return new a(flowable, i2);
    }

    public static <T, R> Function<Flowable<T>, Publisher<R>> h(Function<? super Flowable<T>, ? extends Publisher<R>> function, Scheduler scheduler) {
        return new h(function, scheduler);
    }

    public static <T> Callable<km6.a<T>> g(Flowable<T> flowable, long j2, TimeUnit timeUnit, Scheduler scheduler) {
        return new n(flowable, j2, timeUnit, scheduler);
    }

    public static <T> Callable<km6.a<T>> f(Flowable<T> flowable, int i2, long j2, TimeUnit timeUnit, Scheduler scheduler) {
        return new b(flowable, i2, j2, timeUnit, scheduler);
    }
}
